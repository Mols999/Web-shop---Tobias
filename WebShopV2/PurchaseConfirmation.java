public class PurchaseConfirmation {


    // Metode til at vise bekræftelses-e-mail med købsdetaljer
    public void confirmationEmail() {
        // Hent indkøbskurv fra webshoppen
        ShoppingCart cart = WebShop.getInstance().getShoppingCart();
        double purchasePrice = 0;
        double shippingCosts = 40;
        int numIPads = 0;

        System.out.println("Thank you for your purchase!\n");


        for (Product item : cart.getItems()) {
            System.out.println(item.getDescription());
            purchasePrice += item.getPrice();

            // Hvis varen er en IPad, bliver antallet af iPads i kurven øget
            if (item instanceof IPad) {
                numIPads++;
            }
        }

        // Beregn forsendelsesomkostninger baseret på antal iPads og indkøbskurvens samlede vægt
        if (numIPads > 0) {
            shippingCosts += (numIPads * 30);
        }

        if (cart.getTotalWeight() > 2000) {
            shippingCosts += 20;
        }

        // Udskriv købsprisen, forsendelsesomkostninger og den samlede købspris
        System.out.println("\nPurchase Price: " + purchasePrice);
        System.out.println("Shipping Costs: " + shippingCosts);
        System.out.println("Total Purchase Price: " + (purchasePrice + shippingCosts));
    }
}
