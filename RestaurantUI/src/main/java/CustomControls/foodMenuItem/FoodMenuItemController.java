package CustomControls.foodMenuItem;

import Product.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
}
