public class Main {

    public static void main(String[] args) {


        // using different gateways with same interface

        PaymentProcessor p1 =
                new PaypalAdapter(new PaypalGateway());


        p1.processpayment(500);



        PaymentProcessor p2 =
                new StripeAdapter(new StripeGateway());


        p2.processpayment(1000);
    }
}