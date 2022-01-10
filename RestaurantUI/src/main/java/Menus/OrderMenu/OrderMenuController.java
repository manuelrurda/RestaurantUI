package Menus.OrderMenu;

import CustomControls.foodMenuItem.FoodMenuItem;

import Main.Utils;
import Product.Product;
import Table.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OrderMenuController {

    @FXML
    private VBox foodMenuItemsVBox;
    @FXML
    private Label currentTableLabel;
    @FXML
    private TableView foodMenuItemsTable;

    private Table table;

    private org.json.simple.JSONArray tablesDataJson;
    private org.json.simple.JSONObject currentTableDataJSON;

    /**
     * Metodo que se llama al cargar el archivo FXML para configurar valores iniciales del componente.
     */
    public void initialize() {

        // Establecer controller para ser accesible para los otros componentes
        OrderMenu.getInstance().setOrderMenu(this);

        table = CurrentTable.getInstance().getCurrentTable();
        System.out.println(table.getOrder().toString());
        // Mostrar numero de mesa
        currentTableLabel.setText("Mesa " + table.getTableNum());

        loadTableData();
        loadMenu();
        loadTableOrder();


    }

    private void loadMenu(){
        // Cargar menu
        try{
            String data = new String(Files.readAllBytes(Paths.get("src/main/resources/Menu.json")));
            org.json.JSONArray jsonArray = new JSONArray(data);

            for(int i = 0; i < jsonArray.length(); i++){
                // Cada array dentro del menu representa una categoria de comida diferente: Entradas, Quedadillas, Bebidas, etc.
                org.json.JSONArray arr = jsonArray.getJSONArray(i);

                int fila=0;
                for (int j = 0; j < arr.length(); j++) {

                    org.json.JSONObject ob = arr.getJSONObject(j);

                    // Crear componente
                    FoodMenuItem fmi = new FoodMenuItem(ob.getString("name"), (float)ob.getDouble("price"),
                            (float)ob.getDouble("taxPorcentage"));

                    // 2*i ya que hay elementos de tipo <Separator> despues de cada GridPane y no se tienen que tomar en cuenta
                    GridPane gp = (GridPane)foodMenuItemsVBox.getChildren().get(2*i);

                    // Posicionar FoodMenuItem
                    int numCols = 2;
                    // Si se llega al numero de columnas, agregar 1 a la fila
                    if(j%numCols == 0){fila++;}
                    // Agregar componente
                    gp.add(fmi, j%numCols, fila, 1, 1);

                }
            }

        }catch (IOException | JSONException e){
            System.out.println("Error reading menu data.");
            e.printStackTrace();
        }
    }

    private void loadTableOrder(){
        for (Object obj : (org.json.simple.JSONArray) currentTableDataJSON.get("order")){
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;

           Product p = new Product((String) jsonObject.get("name"), ((double)jsonObject.get("price")),
                    ((double)jsonObject.get("taxPorcentage")));
            // Agregar elemento a objeto Product
            table.getOrder().add(p);
            // Agregar elemento a la tabla visible
            foodMenuItemsTable.getItems().add(p);
        }
    }

    private void loadTableData(){
        try{
            String data = new String(Files.readAllBytes(Paths.get("src/main/resources/Tables.json")));
            tablesDataJson = (org.json.simple.JSONArray) JSONValue.parse(data);

            currentTableDataJSON = (org.json.simple.JSONObject) tablesDataJson.get(Integer.valueOf(table.getTableNum()) - 1);

        }catch (IOException e){
            System.out.println("Error loading table data.");
            e.printStackTrace();
        }
    }

    public void addItem(Product product) {

        // Agregar elemento a objeto Product
        table.getOrder().add(product);
        // Agregar elemento a la tabla visible
        foodMenuItemsTable.getItems().add(product);

        org.json.simple.JSONObject p = productToJSON(product);
        org.json.simple.JSONArray order = (org.json.simple.JSONArray)currentTableDataJSON.get("order");
        order.add(p);
        System.out.println(order.toJSONString());
    }

    public  org.json.simple.JSONObject productToJSON(Product p){
        org.json.simple.JSONObject ob = new org.json.simple.JSONObject();
        ob.put("name", p.getName());
        ob.put("price", p.getPrice());
        ob.put("taxPorcentage", p.getTaxPorcentage());
        ob.put("totalPrice", p.getTotalPrice());
        return ob;
    }

    public void returnToTableMenu(ActionEvent event) {
        // Escribir cambios en JSON
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/Tables.json");
            fileWriter.write(tablesDataJson.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Utils.changeScene("src/main/java/Menus/TablesMenu/TablesMenu.fxml", stage);
    }
}
