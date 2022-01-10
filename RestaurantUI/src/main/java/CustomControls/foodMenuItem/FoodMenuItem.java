package CustomControls.foodMenuItem;

import CustomControls.navigationBar.NavigationBarController;
import Main.Utils;
import Product.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FoodMenuItem extends AnchorPane {

    FoodMenuItemController controller;

    public FoodMenuItem(String name, float price, float taxPorcentage){
        super();

        try {
            FXMLLoader loader = new FXMLLoader(Utils.formURLFromPath("src/main/java/CustomControls/foodMenuItem/FoodMenuItem.fxml"));

            controller = new FoodMenuItemController();
            loader.setController(controller);
            Node n = loader.load();

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
