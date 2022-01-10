package LogIn;

import Main.Utils;

import User.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Controlador para la escena de Log-In. Contiene toda la logica para obtener la informacion de los campos de texto
 * y verificar las credenciales.
 */
public class LogInController {
    @FXML
    private ImageView fondaTistaLogo;
    @FXML
    private ImageView lockIcon;
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField pswdField;
    @FXML
    private Label incorrectCreds;

    /**
     * Metodo inicial de la escena, configura valores iniciales para los componentes.
     */
    public void initialize(){
        Image logo = new Image(Utils.formInputStreamFromPath("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);
        Image lockImage = new Image(Utils.formInputStreamFromPath("src/main/resources/Images/LockIcon.png"));
        lockIcon.setImage(lockImage);
    }

    /**
     * Metodo llamado al momento de hacer click en el boton, "Introducir". Obtiene los valores
     * del nombre de usuario y contraseña. Si las credenciales son correctas, cambia de escena a la interfaz principal.
     * @param e Evento, click del boton.
     */
    public void submitButton(ActionEvent e){
        String username = userTextField.getText();
        String password = pswdField.getText();

        // Se usa polimorfismo, se guarda un Admin o un Waiter en un User
        User user = authenticate(username, password);
        if(user != null){

            // Establecer usuario identificado en clase Singleton
            CurrentUser currentUser = CurrentUser.getInstance();
            currentUser.setCurrentUser(user);

            // Obtener ventana actual
            Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            // Tamano de la nueva ventana
            stage.setHeight(600);
            stage.setWidth(900);
            // Cambiar de escena a la interfaz principal
            Utils.changeScene("src/main/java/Menus/TablesMenu/TablesMenu.fxml", stage);

        }else{
            incorrectCreds.setText("Credenciales incorrectas, intentelo de nuevo.");
        }
    }

    /**
     * Metodo para autentificar las credenciales introducidas en la interfaz de Log-in.
     * @param username Nombre se usuario introducido en el campo "Usuario".
     * @param password Constrasena introducida en el campo "Constrasena".
     * @return Devuelve el usuario si las credenciales son correctas, si alguna es incorrecta,
     * devuelve null.
     */
    public static User authenticate(String username, String password){
        User user = User.USERS.get(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }


}
