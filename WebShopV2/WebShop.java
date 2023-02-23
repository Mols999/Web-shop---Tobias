import java.util.Scanner;

public class WebShop {

    private static WebShop instance;

    private ShoppingCart shoppingCart = null;

    public static WebShop getInstance() {
        return instance;
    }

    public static void setInstance(WebShop instance) {
        WebShop.instance = instance;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }


    public enum InfoRequest {
        ShowPurchasePrice,
        ShowRetailPrice,
        ShowShippingCosts,
    }

    public void buyStuff() {
        // Opretter en ny indkøbskurv til brugeren
        this.shoppingCart = new ShoppingCart();
        boolean done = false;

        // Prompt brugeren ti at vælge produkter, der skal tilføjes til deres indkøbskurv, indtil de er færdige
        while (!done) {
            System.out.println("Please choose a product to add to your shopping cart:");
            System.out.println("1. Milk");
            System.out.println("2. T-Shirt");
            System.out.println("3. iPad");
            System.out.println("4. Done shopping");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                    // Hvis brugeren vælger Mælk, tilføjer en ny Mælkevare til indkøbskurven
                case 1:
                    this.shoppingCart.getItems().add(new Milk(9,"Skim Milk", 5, 1 , 1000));
                    break;
                    // Hvis brugeren vælger en T-Shirt, tilføjer en ny TShirt-vare til indkøbskurven
                case 2:
                    this.shoppingCart.getItems().add(new TShirt(100.0,"Fruit of the loom",10.5,150));
                    break;
                    // Hvis brugeren vælger en iPad, tilføjer en ny IPad-vare til indkøbskurven
                case 3:
                    this.shoppingCart.getItems().add(new IPad(2000,"IPad Air", 1950.0));
                    break;
                    // Hvis brugeren er færdig med at handle, forlad loop
                case 4:
                    done = true;
                    break;
                    // Hvis brugeren vælger en ugyldig indstilling, viser en fejlmeddelelse
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }



    public void webShopUI(InfoRequest info) {

        //Variabler for købspris, forsendelsesomkostninger og antal iPads.
        double purchasePrice = 0;
        double shippingCosts = 40;
        int numIPads = 0;

        // Gentag over alle varer i indkøbskurven og beregn den samlede købspris.
        // Hvis det er en iPad, skal du øge variablen numIPads.
        for (Product item : this.shoppingCart.getItems()) {
            if (item instanceof IPad) {
                numIPads++;
            }
            purchasePrice += item.getPrice();
        }

        // Hvis der er iPads i kurven, så øg fragtomkostningerne med 30 kr for hver iPad.
        if (numIPads > 0) {
            shippingCosts += (numIPads * 30);
        }

        // Hvis den samlede vægt af varer i kurven er over 2000 gram, øger forsendelsen med 20 kr.
        if (this.shoppingCart.getTotalWeight() > 2000) {
            shippingCosts += 20;
        }
        switch (info) {
            case ShowPurchasePrice:
                System.out.println("Purchase Price: " + purchasePrice);
                break;
            case ShowRetailPrice:
                System.out.println("Retail Price");
                break;
            case ShowShippingCosts:
                System.out.println("Shipping Costs: " + shippingCosts);
                break;
        }
    }
}
