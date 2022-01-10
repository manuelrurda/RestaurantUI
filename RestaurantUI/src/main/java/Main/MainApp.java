package Main;


//TODO: refactorizar table buton para inicializar la foto desde el controller del componente y no el menu. con @NamedArg pasar usuario entre escenas de manera mas eficiente
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
 *
 * Clase principal.
 */
public class MainApp extends Application {

    /**
     * Metodo de inicializacion de JavaFX, se llama al inicio del programa para configurar los parametros de la ventana,
     * dar valores inciales, mostrar la primera escena y cargar los usuarios.
     * @param stage Ventana principal, JavaFX la genera automaticamente.
     */
    @Override
    public void start(Stage stage) {
        try{
            //Testing
            Admin testUser = new Admin("m", "l", "m", "m");
            CurrentUser.getInstance().setCurrentUser(testUser);
            Parent root = new FXMLLoader().load(Utils.formInputStreamFromPath("src/main/java/Menus/TablesMenu/TablesMenu.fxml"));
            stage.setHeight(600);
            stage.setWidth(900);

            //TODO: Remove comments after testing
            //Parent root = new FXMLLoader().load(Utils.formInputStreamFromURL("src/main/java/LogIn/LogIn.fxml"));
            Scene scene = new Scene(root);

            // Escena principl, pantalla de LogIn

            stage.setTitle("La Fonda Tista");
            stage.setScene(scene);
            //stage.setHeight(400);
            //stage.setWidth(650);
            stage.setResizable(false);
            stage.show();

        }catch(IOException e){
            System.out.println("Error starting the application");
            e.printStackTrace();
        }


        // Cargar informacion de los usuarios al iniciar
        try{
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
        }catch (IOException | JSONException e){
            System.out.println("Error reading Users data.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }


}

