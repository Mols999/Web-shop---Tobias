public class Milk extends Product {
    private int volume;

    public Milk(double price, String description, double retailPrice, int volume, double weight) {
        super(price, description, retailPrice,weight);
        this.volume = volume;
    }
}
