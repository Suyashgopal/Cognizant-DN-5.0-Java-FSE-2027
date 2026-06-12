// Logger is singleton because only one object should handle logging in the app.

public class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("logger created");
    }

    // This method creates object once and returns same object every time.
    public static Logger getinstance() {

        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }


    public void log(String msg) {
        System.out.println("log: " + msg);
    }
}