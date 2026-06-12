public class WebApp implements Observer {


    public void update(int price) {

        System.out.println("web app price update: " + price);
    }
}