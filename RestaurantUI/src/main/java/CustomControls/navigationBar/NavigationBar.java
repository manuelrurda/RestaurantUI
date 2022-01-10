package CustomControls.navigationBar;

import CustomControls.tableButton.TableButtonController;
import Main.Utils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Componente personalizado, es la barra de navegacion, con los botones para acceder a los menus necesarios. Muestra el
 * nombre del usuario y tiene el boton de Log-Out.
 */

public class NavigationBar extends AnchorPane {
    NavigationBarController controller;

    /**
     * * Constructor llamado al momento de inicializar el componente padre.
     */
    public NavigationBar(){
        super();

        try {
            FXMLLoader loader = new FXMLLoader(Utils.formURLFromPath("src/main/java/CustomControls/navigationBar/NavigationBar.fxml"));

            controller = new NavigationBarController();
            loader.setController(controller);
            Node n = loader.load();

            this.getChildren().add(n);


        }catch (IOException e){
            System.out.println("Error generating custom component");
            e.printStackTrace();
        }
    }
}
