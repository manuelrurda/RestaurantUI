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
 * Esta clase es el Adapter entre la clase del componente, incluyendo el archivo FXML y el resto del programa.
 * Tiene toda la logica y comportamiento del componente.
 */
public class TableButtonController implements Initializable {

    @FXML
    private MenuButton menuButton;
    @FXML
    private InnerShadow innerShadow;

    private final Table table = new Table();

    /**
     * Metodo necesario para Trabajar con componentes perzonalizados en javaFX.
     * @param location
     * @param resources
     */
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

    /**
     * Metodo llamado al momento de hacer click en el <code>MenuItem</code> "Coupar/Desocupar" de este componente.
     * @param e Click del mouse en el componente.
     */
    public void tableButtonClick(ActionEvent e){
        setTableOccupiedStatus(!getTable().getOccupied());
    }

    /**
     * Metodo para cambiar el status de la mesa, se encarga de cambiar el estado del objeto <code>Table</code> y la
     * apariencia del componente.
     * @param b Estado de ocupacion al que se desea cambiar el componente.
     */
    public void setTableOccupiedStatus(boolean b){
        if(b){
            getTable().setOccupied(b);
            getInnerShadow().setColor(Color.web("#ff0009"));
            getMenuButton().getItems().get(0).setText("Desocupar");
            getMenuButton().getItems().get(1).setVisible(true);
        }else{
            getTable().setOccupied(b);
            getInnerShadow().setColor(Color.color(0.09247, 0.86842, 0.11833));
            getMenuButton().getItems().get(0).setText("Ocupar");
            getMenuButton().getItems().get(1).setVisible(false);
        }
    }
}
