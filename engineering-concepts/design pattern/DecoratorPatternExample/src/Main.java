public class Main {

    public static void main(String[] args) {


        // adding sms and slack features without changing email class

        Notifier notifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()
                        )
                );


        notifier.send("server is running");
    }
}