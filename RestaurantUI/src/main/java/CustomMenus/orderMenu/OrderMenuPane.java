package CustomMenus.orderMenu;

import Main.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class OrderMenuPane extends AnchorPane {

    OrderMenuController controller;

    /**
     * Constructor estandar para componentes personalizados en javaFX.
     */
    public OrderMenuPane(){
        super();

        try {
            FXMLLoader loader = new FXMLLoader(Utils.formURLFromPath("src/main/java/CustomMenus/orderMenu/OrderMenu.fxml"));

            controller = new OrderMenuController();
            loader.setController(controller);
            Node n = loader.load();

            this.getChildren().add(n);


        }catch (
                IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Cierra el panel de ordenar y abre el panel de las mesas.
     */
    public void closePane(ActionEvent e){
        controller.closePane(e);
    }
}
