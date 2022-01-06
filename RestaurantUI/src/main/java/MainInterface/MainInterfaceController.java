package MainInterface;

import Main.Utils;
import User.*;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainInterfaceController {

    @FXML
    private ImageView fondaTistaLogo;
    @FXML
    private MenuButton dropDownMenuButton;

    private User user;

    /**
     * Metodo inicial de la escena, configura valores iniciales para los componentes.
     */
    public void initialize(){
        Image logo = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);
        // Recibir usuario de escena de login.
        user = (User) Utils.receiveObject("currentUser");
        dropDownMenuButton.setText(user.getFirstName());
        System.out.println(user.getClass());
    }

}
