public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;
    public StripeAdapter(StripeGateway stripe) {

        this.stripe = stripe;
    }


    // converts common payment call into stripe specific call

    public void processpayment(int amount) {

        stripe.sendmoney(amount);
    }
}