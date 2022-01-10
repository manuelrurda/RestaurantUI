package Menus.OrderMenu;

import CustomControls.foodMenuItem.FoodMenuItem;
import CustomControls.tableButton.TableButtonControl;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OrderMenuController {

    @FXML
    private VBox foodMenuItemsVBox;

    /**
     * Metodo que se llama al cargar el archivo FXML para configurar valores iniciales del componente.
     */
    public void initialize(){
        // Leer menu
        try{
            String data = new String(Files.readAllBytes(Paths.get("src/main/resources/Menu.json")));
            JSONArray jsonArray = new JSONArray(data);

            for(int i = 0; i < jsonArray.length(); i++){
                // Cada array dentro del menu representa una categoria de comida diferente: Entradas, Quedadillas, Bebidas, etc.
                JSONArray arr = jsonArray.getJSONArray(i);

                int fila=0;
                for (int j = 0; j < arr.length(); j++) {

                    JSONObject ob = arr.getJSONObject(j);

                    FoodMenuItem fmi = new FoodMenuItem(ob.getString("name"), (float)ob.getDouble("price"),
                            (float)ob.getDouble("taxPorcentage"));

                    // 2*i ya que hay elementos de tipo <Separator> despues de cada GridPane y no se tienen que tomar en cuenta
                    GridPane gp = (GridPane)foodMenuItemsVBox.getChildren().get(2*i);

                    // Posicionar FoodMenuItem
                    int numCols = 2;
                    // Si se llega al numero de columnas, agregar 1 a la fila
                    if(j%numCols == 0){fila++;}
                    gp.add(fmi, j%numCols, fila, 1, 1);

                }
            }

        }catch (IOException | JSONException e){
            System.out.println("Error reading menu data.");
            e.printStackTrace();
        }
    }
}
