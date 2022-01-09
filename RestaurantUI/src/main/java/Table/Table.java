package Table;

/**
 * Clase que ira de la mano del componente <code>TableButtonControl</code>. En ella se especifican los estados de la
 * mesa y se guarda la orden.
 */

public class Table {
    private boolean occupied;

    public Table() {
    }

    public boolean getOccupied(){
        return occupied;
    }

    public void setOccupied(boolean b) {
        this.occupied = b;
    }
}
