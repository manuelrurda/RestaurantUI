package MainInterface;

import Main.Utils;
import User.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import CustomControls.tableButton.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainInterfaceController {

    @FXML
    private ImageView fondaTistaLogo;
    @FXML
    private Label nameLabel;
    @FXML
    private Button logOutButton;
    @FXML
    private Button adminMenuButton;
    @FXML
    private List<TableButtonControl> tableButtons;
    @FXML
    private Pane tablesPane;
    @FXML
    private Pane orderPane;

    private User user;

    /**
     * Metodo inicial de la escena, configura valores iniciales para los componentes.
     */
    public void initialize(){

        // Logo Fonda Tista
        Image logo = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);

        // Icono Log-Out
        Image logOutIcon = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/LogOutIcon.png"));
        ImageView lgiIV = new ImageView(logOutIcon);
        lgiIV.setFitWidth(30);
        lgiIV.setFitHeight(30);
        logOutButton.setGraphic(lgiIV);

        // Leer estado de las mesas
        try{
            String data = new String(Files.readAllBytes(Paths.get("src/main/resources/Tables.json")));
            JSONArray jsonArray = new JSONArray(data);

            int i = 0;
            for(TableButtonControl b : tableButtons){
                // Imagen, tamano y numero de mesa
                Image tableIcon = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/TableIcon.png"));
                ImageView tiIV = new ImageView(tableIcon);
                tiIV.setFitWidth(80);
                tiIV.setFitHeight(80);
                b.getMenuButton().setText(String.valueOf(i+1));
                b.getMenuButton().setGraphic(tiIV);

                // Cargar estado de mesa segun archivo
                JSONObject ob = jsonArray.getJSONObject(i);
                b.setTableOccupiedStatus(ob.getBoolean("OccupiedStatus"));
                i++;
            }

        }catch (IOException | JSONException e){
            System.out.println("Error reading table data.");
            e.printStackTrace();
        }


        // Recibir usuario de escena de login.
        user = (User) Utils.receiveObject("currentUser");
        nameLabel.setText(user.getFirstName());
        System.out.println(user.getClass());

        // Habilitar menu admin
        adminMenuButton.setVisible(user instanceof Admin);
    }

    /**
     * Metodo llamado al hacer click en el boton de Log-Out, para regresar a la interfaz de Log-In.
     * @param e
     */
    public void logOut(ActionEvent e){
        try{
            // Cambiar de escena a interfaz login
            Parent root = new FXMLLoader().load(Utils.formInputStreamFromURL(
                    "src/main/java/LogIn/LogIn.fxml"));
            Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setHeight(400);
            stage.setWidth(650);

            stage.show();
        }catch (IOException exception){
            System.out.println("Error loading FXML file.");
            exception.printStackTrace();
        }
    }

    public  void closeOrderPane(ActionEvent e){
        orderPane.setVisible(false);
        tablesPane.setVisible(true);
    }

}
