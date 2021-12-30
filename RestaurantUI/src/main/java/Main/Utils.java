package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase con metodos de utilidad para trabajar con JavaFX y JSON
 */
public class Utils {
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
