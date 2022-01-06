package MainInterface;

import Main.Utils;
import User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainInterfaceController {

    @FXML
    private ImageView fondaTistaLogo;
    @FXML
    private MenuButton dropDownMenuButton;

    private User user;
    public void initialize(){
        Image logo = new Image(Utils.formInputStreamFromURL("src/main/resources/Images/FondaTistaLogo.png"));
        fondaTistaLogo.setImage(logo);
    }

}
