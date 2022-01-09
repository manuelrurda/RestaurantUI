package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Clase con metodos de utilidad para trabajar con JavaFX
 */
public abstract class Utils {
    /**
     * Metodo para generar un InputStream a partir de un directorio, es necesario para cargar archivos FXML, imagenes,
     * stylesheets, etc. Ya existe un metodo que hace esto en Javafx, sin embargo se generaban muchos errores al cargar
     * archivos.
     * @param url Direccion del arhivo desde raiz del proyecto - RestaurantUI/
     * @return Devuelve un objeto InputStream a partir del url.
     */
    public static InputStream formInputStreamFromURL(String url){
        InputStream is = null;
        try{
            is = new FileInputStream(url);
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
     * Metodo para recibir objetos de otras escenas. El metodo buscara un archivo de objeto con el identificador dado.
     * Una vez recuperado el objeto, se eliminara el archivo.
     * @param id Identificador del objeto a recibir.
     * @return Objeto recivido.
     */
    public static Object receiveObject(String id){
        Object obj = null;
        try{
            FileInputStream f = new FileInputStream("src/main/java/"+ id + ".ser");
            ObjectInputStream s = new ObjectInputStream(f);
            obj = s.readObject();
            // Borrar archivo temporal
            new File("src/main/java/"+ id + ".ser").delete();
            s.close();
        }catch (FileNotFoundException e){
            System.out.println("Object with given Id not found.");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("Error reading Object data.");
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return obj;
    }

    public static void changeScene(String path, Stage stage){
        try{

            Parent root = new FXMLLoader().load(Utils.formInputStreamFromURL(
                    path));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException exception){
            System.out.println("Error loading Scene FXML file.");
            exception.printStackTrace();
        }
    }
}
