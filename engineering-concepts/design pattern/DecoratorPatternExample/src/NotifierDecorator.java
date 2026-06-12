public abstract class NotifierDecorator implements Notifier {

    protected Notifier notifier;


    // stores old notifier so we can add extra features on it

    public NotifierDecorator(Notifier notifier) {

        this.notifier = notifier;
    }


    public void send(String msg) {

        notifier.send(msg);
    }
}