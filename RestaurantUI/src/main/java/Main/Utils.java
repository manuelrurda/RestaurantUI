package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase con metodos de utilidad para trabajar con JavaFX
 */
public abstract class Utils {
    /**
     * Metodo para generar un InputStream a partir de un directorio, es necesario para cargar archivos FXML, imagenes,
     * stylesheets, etc. Ya existe un metodo que hace esto en Javafx, sin embargo se generaban muchos errores al cargar
     * archivos.
     * @param path Direccion del arhivo desde raiz del proyecto - RestaurantUI/
     * @return Devuelve un objeto InputStream a partir del url.
     */
    public static InputStream formInputStreamFromPath(String path){
        InputStream is = null;
        try{
            is = new FileInputStream(path);
        }catch(IOException e){
            System.out.println("Error generating Input Stream.");
            e.printStackTrace();
        }
        return is;
    }

    /**
     * Metodo para generar un objeto URL a partir de un directorio. Ya existe un metodo que hace esto en Javafx,
     * sin embargo se generaban muchos errores al cargar archivos.
     * @param path Direccion del archivo desde raiz del proyecto - RestaurantUI/
     * @return Devuelve un Objeto URL a partir de la direccion.
     */
    public static URL formURLFromPath(String path){
        URL url = null;
        try{
            url = new File(path).toURI().toURL();
        }catch (MalformedURLException e){
            System.out.println("Error generating URL.");
            e.printStackTrace();
        }
        return url;
    }

    /**
     * Metodo para enviar objetos a diferentes escenas. El objeto debe ser serializable. El metodo creara un archivo
     * temporal el cual sera eliminado una vez leido por el metodo <code>receiveObject()<code/>.
     * @param obj El objeto que sera enviado a otra escena.
     * @param id Identificador del objeto enviado, en caso de que se intente enviar mas de un objeto a la vez.
     */
    public static void sendObject(Object obj, String id){
        try{
            FileOutputStream f = new FileOutputStream("src/main/java/"+ id + ".ser");
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(obj);
            s.close();
        }catch (IOException e){
            System.out.println("Error writing Object data.");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cambiar de escena. Carga el archivo de la nueva escena y la muestra en pantalla.
     * @param path Direccion del archivo desde raiz del proyecto - RestaurantUI/
     * @param stage Ventana de la aplicacion.
     */
    public static void changeScene(String path, Stage stage){
        try{

            Parent root = new FXMLLoader().load(Utils.formInputStreamFromPath(
                    path));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException exception){
            System.out.println("Error loading Scene FXML file.");
            exception.printStackTrace();
        }
    }

    /**
     * Metodo para guardar los cambios al archivo JSON especificado.
     * @param jsonDataArray Objeto con los cambios a gaurdar.
     * @param path Direccion del archivo desde raiz del proyecto - RestaurantUI/
     */
    public static void saveJSONFile(JSONArray jsonDataArray, String path) {
        // Escribir cambios en JSON
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(jsonDataArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que utiliza la biblioteca de SimpleJSON para obtener la informacion del archivo JSON especificado.
     * @param path Direccion del archivo desde raiz del proyecto - RestaurantUI/
     * @return Objeto JSONArray con la informacion de todo el archivo.
     */
    public static org.json.simple.JSONArray getSimpleJSONData(String path){
        org.json.simple.JSONArray jsonArray = null;
        try{
            String data = new String(Files.readAllBytes(Paths.get(path)));
            jsonArray = (org.json.simple.JSONArray) JSONValue.parse(data);
        }catch(IOException e){
            System.out.println("Error reading JSON data.");
        }
        return jsonArray;
    }
}
