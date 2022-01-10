package CustomControls.foodMenuItem;

import Main.Utils;
import Product.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Componente personalizado, se encarga de mostrar el nombre y precio de un producto. Ademas de tener botones para agregar
 * y eliminar elementos de la orden.
 */

public class FoodMenuItem extends AnchorPane {

    FoodMenuItemController controller;

    /**
     * Constructor llamado al momento de inicializar el componente padre. Los parametros se utilizaran para crear un
     * nuevo objeto Product que estara asociado al componente.
     * @param name Nombre del producto.
     * @param price Precio del producto.
     * @param taxPorcentage Porcentaje de impuestos en el producto.
     */

    public FoodMenuItem(String name, float price, float taxPorcentage){
        super();

        try {
            FXMLLoader loader = new FXMLLoader(Utils.formURLFromPath("src/main/java/CustomControls/foodMenuItem/FoodMenuItem.fxml"));

            controller = new FoodMenuItemController();
            loader.setController(controller);
            Node n = loader.load();

            // Establecer valores al cargar el componente, se hacen desde esta clase para no tener que pasar los parametros al
            // controller.
            controller.setProduct(new Product(name, price, taxPorcentage));
            controller.getNameLabel().setText(name);
            controller.getPriceLabel().setText(String.format("Precio: $%.2f", price+price*taxPorcentage));

            this.getChildren().add(n);

        }catch (IOException e){
            System.out.println("Error generating custom component");
            e.printStackTrace();
        }
    }


}
