public class Main {

    public static void main(String[] args) {

        // changing payment method without changing main logic

        PaymentContext payment;


        payment = new PaymentContext(new CreditCardPayment());

        payment.makepayment(2000);



        payment = new PaymentContext(new PayPalPayment());

        payment.makepayment(5000);
    }
}