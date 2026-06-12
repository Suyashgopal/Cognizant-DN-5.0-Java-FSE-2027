public class PaypalAdapter implements PaymentProcessor {

    private PaypalGateway paypal;


    public PaypalAdapter(PaypalGateway paypal) {

        this.paypal = paypal;
    }


    // converts common payment call into paypal specific call

    public void processpayment(int amount) {

        paypal.makepayment(amount);
    }
}