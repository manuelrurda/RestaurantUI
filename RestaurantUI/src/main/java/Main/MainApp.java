package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import User.User;

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
            Parent root = new FXMLLoader().load(formInputStreamFromURL("src/main/java/LogIn/LogIn.fxml"));
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
            new User(ob.getString("name"), ob.getString("username"), ob.getString("password"),
                    ob.getBoolean("admin"));
        }

        for(User u: User.getUSERS().values()){
            System.out.println(u.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metodo para generar un InputStream a partir de un directorio, es necesario para cargar archivos FXML, imagenes,
     * stylesheets, etc.
     * @param url Direccion del arhivo desde raiz del proyecto - RestaurantUI/
     * @return Devuelve un objeto InputStream a partir del url.
     */
    public static InputStream formInputStreamFromURL(String url){
        InputStream is = null;
        try{
            is = new FileInputStream(url);
        }catch(IOException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        return is;
    }

}

