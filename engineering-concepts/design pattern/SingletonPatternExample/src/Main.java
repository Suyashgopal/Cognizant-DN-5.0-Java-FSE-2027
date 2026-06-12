// Testing if both references are using the same Logger object.

public class Main {

    public static void main(String[] args) {

        Logger logger1 = Logger.getinstance();

        Logger logger2 = Logger.getinstance();


        logger1.log("application started");

        logger2.log("user logged in");


        if (logger1 == logger2) {
            System.out.println("same logger object used");
        }
        else {
            System.out.println("different objects created");
        }
    }
}