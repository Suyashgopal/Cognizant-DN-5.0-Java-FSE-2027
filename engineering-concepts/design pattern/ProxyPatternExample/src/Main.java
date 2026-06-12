public class Main {

    public static void main(String[] args) {


        // proxy controls loading of real image object

        Image img = new ProxyImage("photo.png");


        img.display();

        img.display();
    }
}