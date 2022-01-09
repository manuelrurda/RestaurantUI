package CustomControls.navigationBar;

import Main.Utils;
import User.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class NavigationBarController implements Initializable {

    @FXML
    private ImageView fondaTistaLogo;
    @FXML
    private Label nameLabel;
    @FXML
    private Button logOutButton;
    @FXML
    private Button adminMenuButton;

    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Logo Fonda Tista
        System.out.println(System.getProperty("user.dir"));
        Image logo = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);

        // Icono Log-Out
        Image logOutIcon = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/LogOutIcon.png"));
        ImageView lgiIV = new ImageView(logOutIcon);
        lgiIV.setFitWidth(30);
        lgiIV.setFitHeight(30);
        logOutButton.setGraphic(lgiIV);

        // Obtener usuario de clase Singleton.
        user = CurrentUser.getInstance().getCurrentUser();
        nameLabel.setText(user.getFirstName());
        System.out.println(user.getClass());

        // Habilitar menu admin
        adminMenuButton.setVisible(user instanceof Admin);
    }
}
