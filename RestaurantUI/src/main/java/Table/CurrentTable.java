package Table;

/**
 * Clase Singleton para poder acceder a la mesa en uso.
 */
public class CurrentTable {
    private Table currentTable;
    private final static CurrentTable INSTANCE = new CurrentTable();

    private CurrentTable(){}

    public static CurrentTable getInstance(){
        return INSTANCE;
    }

    public void setCurrentTable(Table t){
        this.currentTable = t;
    }

    public Table getCurrentTable(){
        return this.currentTable;
    }
}