public class IPad extends Product {
    public double getHandlingCosts() {
        return handlingCosts;
    }

    private final double handlingCosts = 30;


    public IPad(double price, String description, double retailPrice) {
        super(price, description, retailPrice, 750);

    }
}
