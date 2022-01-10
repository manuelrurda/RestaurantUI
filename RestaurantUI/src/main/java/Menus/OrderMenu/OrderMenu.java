package Menus.OrderMenu;


/**
 * Clase Singleton para poder acceder a la mesa en uso.
 */
public class OrderMenu {
    private OrderMenuController orderMenu;
    private final static OrderMenu INSTANCE = new OrderMenu();

    private OrderMenu(){}

    public static OrderMenu getInstance(){
        return INSTANCE;
    }

    public void setOrderMenu(OrderMenuController omc){
        this.orderMenu = omc;
    }

    public void clearOrderMenu(){
        this.orderMenu = null;
    }
    public OrderMenuController getController(){
        return this.orderMenu;
    }
}