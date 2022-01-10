package CustomControls.foodMenuItem;

import Main.Utils;
import Menus.OrderMenu.OrderMenu;
import Menus.OrderMenu.OrderMenuController;
import Product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodMenuItemController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;

    private Product product;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public Label getPriceLabel() {
        return priceLabel;
    }

    public void addItem(ActionEvent e){

        OrderMenu.getInstance().getController().addItem(product);
    }


}
