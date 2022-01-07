package MainInterface;

import Main.Utils;
import User.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdk.jshell.execution.Util;

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
    private List<Button> tableButtons;

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

        // Iconos de las mesas
        /*for(Button b : tableButtons){
            Image tableIcon = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/TableIcon.png"));
            ImageView tiIV = new ImageView(tableIcon);
            tiIV.setFitWidth(80);
            tiIV.setFitHeight(80);
            b.setGraphic(tiIV);
        }*/

        // Recibir usuario de escena de login.
        user = (User) Utils.receiveObject("currentUser");
        nameLabel.setText(user.getFirstName());
        System.out.println(user.getClass());

        // Habilitar menu admin
        adminMenuButton.setVisible(user instanceof Admin);
    }

}
