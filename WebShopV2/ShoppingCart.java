import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items = new ArrayList<Product>();
    public ArrayList<Product> getItems() {
        return items;
    }
    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }


    public double getTotalWeight() {
        //En variabel for at holde den samlede vægt
        double totalWeight = 0.0;
        // Function til at se vare i indkøbskurven og læg dens vægt til sammen
        for (Product item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}
