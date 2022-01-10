package Table;

import Product.Product;

import java.util.ArrayList;

/**
 * Clase que ira de la mano del componente <code>TableButtonControl</code>. En ella se especifican los estados de la
 * mesa y se guarda la orden.
 */

public class Table {

    private String tableNum;
    private boolean occupied;

    private ArrayList<Product> order = new ArrayList<Product>();

    public Table() {
    }

    public boolean getOccupied(){
        return occupied;
    }

    public void setOccupied(boolean b) {
        this.occupied = b;
    }

    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
    }

    public ArrayList<Product> getOrder() {
        return order;
    }
}
