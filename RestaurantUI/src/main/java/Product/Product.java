package Product;

/**
 *  Clase Product estara asociada a un <code>foodMenuItem</code>. Guarda la informacion para el nombre, precio y porcentaje de impuestos del producto.
 */

public class Product {

    private String name;
    private double price;
    private double taxPorcentage;
    private double totalPrice;

    public Product(String name, double price, double taxPorcentage){
        this.name = name;
        this.price = price;
        this.taxPorcentage = taxPorcentage;
        // Redondear a dos decimales
        this.totalPrice = (Math.round((price + price*taxPorcentage)*100.0)/100.0);
    }

    // Setters y Getters

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTaxPorcentage() {
        return taxPorcentage;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // para debug
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", taxPorcentage=" + taxPorcentage +
                '}';
    }
}
