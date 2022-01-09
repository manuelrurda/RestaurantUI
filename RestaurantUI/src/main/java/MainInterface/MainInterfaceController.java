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
    private Pane tablesPane;
    @FXML
    private Pane orderPane;

    private User user;

    /**
     * Metodo inicial de la escena, configura valores iniciales para los componentes.
     */
    public void initialize(){



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
