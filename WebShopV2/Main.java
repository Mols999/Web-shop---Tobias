public class Main {

    public static void main(String[] args) {

        WebShop.setInstance(new WebShop());

        WebShop.getInstance().buyStuff();

        PurchaseConfirmation confirmation = new PurchaseConfirmation();
        confirmation.confirmationEmail();
    }

}