public class SMSNotifierDecorator extends NotifierDecorator {


    public SMSNotifierDecorator(Notifier notifier) {

        super(notifier);
    }


    public void send(String msg) {

        super.send(msg);

        System.out.println("sms sent: " + msg);
    }
}