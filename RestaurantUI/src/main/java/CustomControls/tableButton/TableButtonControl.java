package CustomControls.tableButton;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;

import Main.Utils;
import java.io.IOException;

public class TableButtonControl extends AnchorPane {

    TableButtonController controller;

    /**
     * Constructor llamado al momento de inicializar el componente padre.
     * @param tableNumber parametro pasado en archivo FXML. Texto del boton, se utiliza para darle el numero de mesa.
     */
    public TableButtonControl(@NamedArg("tableNumber") String tableNumber){
        super();

        try {
            FXMLLoader loader = new FXMLLoader(Utils.formURLFromPath("src/main/java/CustomControls/TableButton/TableButton.fxml"));

            controller = new TableButtonController();
            loader.setController(controller);
            Node n = loader.load();

            this.getChildren().add(n);

            controller.getMenuButton().setText(tableNumber);


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

    public void setTableOccupiedStatus(boolean b){
        controller.setTableOccupiedStatus(b);
    }

    public boolean getTableStatus(){
        return controller.getTable().getOccupied();
    }

}
