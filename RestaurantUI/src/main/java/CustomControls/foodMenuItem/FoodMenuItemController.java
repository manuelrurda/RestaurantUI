package CustomControls.foodMenuItem;

import Menus.OrderMenu.OrderMenu;
import Product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador del componente <code>FoodMenuItem</code>. Obtiene los componentes del archivo FXML y los metodos para
 * los botones. Implementa la interfaz Initializable para poder ser utilizado en FXML.
 */
public class FoodMenuItemController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;

    private Product product;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    // Getters y Setters

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

    /**
     *  Llama al metodo <code>addItem</code> del controller y pasa como parametro el objeto Product asociado con el componente.
     * @param e Click en el boton.
     */
    public void addItem(ActionEvent e){
        OrderMenu.getInstance().getController().addItem(product);
    }

    public void deleteItem(ActionEvent e) {
        OrderMenu.getInstance().getController().deleteItem(product);
    }
}
