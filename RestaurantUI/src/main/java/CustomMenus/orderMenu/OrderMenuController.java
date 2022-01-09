package CustomMenus.orderMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderMenuController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Button returnButton;
    @FXML
    private Button payButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Pane getPane() {
        return pane;
    }

    public void closePane(ActionEvent e){
        Button b = (Button) e.getSource();
        System.out.println("There was an attempt");
    }
}
