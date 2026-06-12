public class PayPalPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("paid using paypal: " + amount);
    }
}