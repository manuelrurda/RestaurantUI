package LogIn;

import Main.Utils;

import User.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

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
        Image logo = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);
        Image lockImage = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/LockIcon.png"));
        lockIcon.setImage(lockImage);
    }

    /**
     * Metodo llamado al momento de hacer click en el boton, "Introducir". Obtiene los valores
     * del nombre de usuario y contraseña. Si las credenciales son correctas, cambia de escena a la interfaz principal.
     * Ademas, crea un archivo temporal para pasar el objeto de usuario a la interfaz principal.
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

            // Como cambia de tamano la ventana, aqui no se utiliza Utils.changeScene()
            try{
                // Cambiar de escena a la interfaz principal
                Parent root = new FXMLLoader().load(Utils.formInputStreamFromURL(
                        "src/main/java/Menus/TablesMenu/TablesMenu.fxml"));
                Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setHeight(600);
                stage.setWidth(900);

                stage.show();
            }catch (IOException exception){
                System.out.println("Error loading FXML file.");
                exception.printStackTrace();
            }
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
