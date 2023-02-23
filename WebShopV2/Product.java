public class Product {

    private double price;
    private String description;
    private double retailPrice;
    private double weight;


    public Product(double price, String description, double retailPrice, double weight) {

        this.price = price;
        this.description = description;
        this.retailPrice = retailPrice;
        this.weight = weight;
    }


    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public double getWeight() {
        return weight;
    }
}
