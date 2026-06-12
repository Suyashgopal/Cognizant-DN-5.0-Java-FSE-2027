public class PaymentContext {

    private PaymentStrategy strategy;


    // stores the selected payment method

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }


    public void makepayment(int amount) {
        strategy.pay(amount);
    }
}