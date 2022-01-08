package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import User.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Manuel Rodriguez, Juan Pablo
 */
public class MainApp extends Application {

    /**
     * Metodo de inicializacion de JavaFX, se llama al inicio del programa para configurar los parametros de la ventana,
     * dar valores inciales y mostrar la primera escena.
     * @param stage Ventana principal, JavaFX la genera automaticamente.
     */
    @Override
    public void start(Stage stage) throws IOException, JSONException {
        try{
            Parent root = new FXMLLoader().load(Utils.formInputStreamFromURL("src/main/java/LogIn/LogIn.fxml"));
            Scene scene = new Scene(root);

            // Escena principl, pantalla de LogIn
            stage.setTitle("La Fonda Tista");
            stage.setScene(scene);
            stage.setHeight(400);
            stage.setWidth(650);
            stage.setResizable(false);
            stage.show();

        }catch(IOException e){
            System.out.println("Error al cargar el archivo");
            e.printStackTrace();
        }

        //TODO: refactor exceptions, clean this code, test in main method
        String data = new String(Files.readAllBytes(Paths.get("src/main/resources/Users.json")));
        JSONArray jsonArray = new JSONArray(data);

        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject ob = jsonArray.getJSONObject(i);

            // Tal vez haya una mejor manera de hacer esto
            if(ob.getString("type").equals("Admin")){
                new Admin(ob.getString("firstName"), ob.getString("lastName"), ob.getString("username"),
                        ob.getString("password"));
            }else{
                new Waiter(ob.getString("firstName"), ob.getString("lastName"), ob.getString("username"),
                        ob.getString("password"));
            }
        }

        for(User u: User.USERS.values()){
            System.out.println(u.toString());
            System.out.println(u instanceof Waiter);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}

