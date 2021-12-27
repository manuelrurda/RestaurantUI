package LogIn;

import Main.MainApp;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * Controlador para la escena de Log-In. Contiene toda la logica para obtener la informacion de los campos de texto
 * y verificar las credenciales.
 */
public class LogInController {
    @FXML
    ImageView fondaTistaLogo;
    @FXML
    ImageView lockIcon;

    /**
     * Metodo inicial de la escena, configura valores iniciales para los componentes.
     */
    public void initialize(){
        Image logo = new Image(MainApp.formInputStreamFromURL("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);
        Image lockImage = new Image(MainApp.formInputStreamFromURL("src/main/resources/Images/LockIcon.png"));
        lockIcon.setImage(lockImage);
    }
}
