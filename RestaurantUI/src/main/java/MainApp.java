import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Manuel Rodriguez, Juan Pablo
 */
public class MainApp extends Application {

    /**
     * Este metodo se utiliza para cargar un archivo FXML a un FXMLLoader. Se tuvo que crear este metodo porque
     * ocurrian errores cargar el archivo directamente al loader, la solucion fue cargar un InputStream al loader.
     * @return el padre de la escena.
     */
    private Parent getRoot(){
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {

            String path = "src/main/java/LogIn/LogIn.fxml";
            InputStream fxmlStream = new FileInputStream(path);
            root =  loader.load(fxmlStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return root;
        }
    }

    /**
     * Metodo de inicializacion de JavaFX, se llama al inicio del programa para configurar los parametros de la ventana,
     * dar valores inciales y mostrar la primera escena.
     * @param stage
     */
    @Override
    public void start(Stage stage) {

        try{
            Scene scene = new Scene(getRoot());
            //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            stage.setTitle("JavaFX and Gradle");
            stage.setScene(scene);
            stage.show();

        }catch(NullPointerException e){
            System.out.println("Error al cargar el archivo FXML");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}