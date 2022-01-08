package CustomControls.tableButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.effect.InnerShadow;

import java.net.URL;
import java.util.ResourceBundle;

import Table.Table;
import javafx.scene.paint.Color;

/**
 * Esta clase es el puente entre la clase del componente, y el archivo FXML.
 */
public class TableButtonController implements Initializable {

    @FXML
    private MenuButton menuButton;
    @FXML
    private InnerShadow innerShadow;

    private final Table table = new Table();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public MenuButton getMenuButton() {
        return menuButton;
    }

    public InnerShadow getInnerShadow() {
        return innerShadow;
    }

    public Table getTable() {
        return table;
    }

    public void tableButtonClick(ActionEvent e){
        setTableOccupiedStatus(!getTable().getOccupied());
    }

    public void setTableOccupiedStatus(boolean b){
        if(b){
            getTable().setOccupied(b);
            getInnerShadow().setColor(Color.web("#ff0009"));
        }else{
            getTable().setOccupied(b);
            getInnerShadow().setColor(Color.color(0.09247, 0.86842, 0.11833));
        }
    }
}
