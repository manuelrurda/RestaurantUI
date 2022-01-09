package Menus.TablesMenu;

import CustomControls.tableButton.TableButtonControl;
import javafx.fxml.FXML;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TablesMenuController {

    @FXML
    private List<TableButtonControl> tableButtons;

    /**
     * Metodo que se llama al cargar el archivo FXML para configurar valores iniciales del componente.
     */
    public void initialize(){
        // Leer estado de las mesas
        try{
            String data = new String(Files.readAllBytes(Paths.get("src/main/resources/Tables.json")));
            JSONArray jsonArray = new JSONArray(data);
            int i = 0;
            for(TableButtonControl b : tableButtons){
                // Cargar estado de mesa segun archivo
                JSONObject ob = jsonArray.getJSONObject(i);
                b.setTableOccupiedStatus(ob.getBoolean("OccupiedStatus"));
                i++;
            }

        }catch (IOException | JSONException e){
            System.out.println("Error reading table data.");
            e.printStackTrace();
        }
    }
}
