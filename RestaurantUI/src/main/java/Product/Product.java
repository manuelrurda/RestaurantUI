package Product;

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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", taxPorcentage=" + taxPorcentage +
                '}';
    }
}
