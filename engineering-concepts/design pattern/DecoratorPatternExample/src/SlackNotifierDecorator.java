public class SlackNotifierDecorator extends NotifierDecorator {


    public SlackNotifierDecorator(Notifier notifier) {

        super(notifier);
    }


    public void send(String msg) {

        super.send(msg);

        System.out.println("slack message sent: " + msg);
    }
}