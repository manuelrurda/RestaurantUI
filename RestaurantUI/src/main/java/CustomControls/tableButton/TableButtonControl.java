package CustomControls.tableButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;

import Main.Utils;
import javafx.scene.paint.Color;

import java.io.IOException;

// TODO: usar archivos para leer mesas ocupadas y desocupadas despues de salir de la aplicacion

public class TableButtonControl extends AnchorPane {

    TableButtonController controller;
    public TableButtonControl(){
        super();

        try {
            FXMLLoader loader = new FXMLLoader(Utils.formURLFromPath("src/main/java/CustomControls/TableButton/TableButton.fxml"));

            controller = new TableButtonController();
            loader.setController(controller);
            Node n = loader.load();

            this.getChildren().add(n);


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public MenuButton getMenuButton() {
        return controller.getMenuButton();
    }

    public InnerShadow getInnerShadow() {
        return controller.getInnerShadow();
    }

    public static void tableButtonClick(TableButtonController controller){
        if(!controller.getTable().getOccupied()){
            controller.getTable().changeOccupiedStatus();
            controller.getInnerShadow().setColor(Color.web("#ff0009"));
        }else{
            controller.getTable().changeOccupiedStatus();
            controller.getInnerShadow().setColor(Color.color(0.09247, 0.86842, 0.11833));
        }
    }

}
