package LogIn;

import Main.Utils;

import User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    @FXML
    TextField userTF;
    @FXML
    PasswordField pswdF;
    @FXML
    Button button;

    /**
     * Metodo inicial de la escena, configura valores iniciales para los componentes.
     */
    public void initialize(){
        Image logo = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);
        Image lockImage = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/LockIcon.png"));
        lockIcon.setImage(lockImage);
    }

    public void submitButton(ActionEvent e){
        String username = userTF.getText();
        String password = pswdF.getText();
        System.out.println(authenticate(username, password));
    }

    public static User authenticate(String username, String password){
        User user = User.getUSERS().get(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }


}
