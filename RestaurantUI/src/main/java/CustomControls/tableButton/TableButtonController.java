package CustomControls.tableButton;

import Main.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.effect.InnerShadow;

import java.net.URL;
import java.util.ResourceBundle;

import Table.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Controlador del componente <code>TableButton</code>. Obtiene los componentes del archivo FXML, inicializa valores
 * y contiene los metodos para los botones. Implementa la interfaz Initializable para poder ser utilizado en FXML.
 */

public class TableButtonController implements Initializable {

    @FXML
    private Pane mainPane;
    @FXML
    private MenuButton menuButton;
    @FXML
    private InnerShadow innerShadow;

    private final Table table = new Table();

    /**
     * Metodo que se llama al cargar el archivo FXML para configurar valores iniciales del componente.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image tableIcon = new Image(Utils.formInputStreamFromPath("src/main/resources/Images/TableIcon.png"));
        ImageView tiIV = new ImageView(tableIcon);
        tiIV.setFitWidth(80);
        tiIV.setFitHeight(80);
        menuButton.setGraphic(tiIV);
    }

    // Getters y Setters

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
     * Metodo llamado al momento de hacer click en la opcion "Coupar/Desocupar" de este componente. Cambia el estado de la mesa
     * y guarda los cambios en el archivo JSON.
     * @param e Click del mouse en el componente.
     */
    public void occupyButtonClick(ActionEvent e){
        setTableOccupiedStatus(!getTable().getOccupied());
        changeJsonStatus();
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

    /**
     *  Carga el archivo JSON de mesas y cambia el estado de la mesa al contrario en el que se encontraba.
     */
    private void changeJsonStatus(){
        String path = "src/main/resources/Tables.json";

        org.json.simple.JSONArray tablesDataJson = Utils.getSimpleJSONData(path);
        org.json.simple.JSONObject currentTableDataJSON = (org.json.simple.JSONObject) tablesDataJson.get(Integer.valueOf(table.getTableNum()) - 1);

        currentTableDataJSON.put("OccupiedStatus", !((Boolean)(currentTableDataJSON.get("OccupiedStatus"))));
        currentTableDataJSON.put("order",  new org.json.simple.JSONArray());

        Utils.saveJSONFile(tablesDataJson, path);
    }

    /**
     * Metodo llamado al hacer click en la opcion de "Ordenar". Establece la mesa que se esta atendiendo en la clase Singleton.
     * y cambia la escena al Menu de ordenar.
     * @param e
     */
    public void openOrder(ActionEvent e){
        CurrentTable.getInstance().setCurrentTable(table);
        Stage stage = (Stage) mainPane.getScene().getWindow();
        Utils.changeScene("src/main/java/Menus/OrderMenu/OrderMenu.fxml", stage);
    }

}
