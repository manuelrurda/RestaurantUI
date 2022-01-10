package Product;

public class Product {

    private String name;
    private float price;
    private float taxPorcentage;

    public Product(String name, float price, float taxPorcentage){
        this.name = name;
        this.price = price;
        this.taxPorcentage = taxPorcentage;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getTaxPorcentage() {
        return taxPorcentage;
    }
}
