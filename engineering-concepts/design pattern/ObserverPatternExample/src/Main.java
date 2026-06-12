public class Main {

    public static void main(String[] args) {


        StockMarket stock = new StockMarket();


        Observer mobile = new MobileApp();

        Observer web = new WebApp();


        // adding users who want stock updates

        stock.addobserver(mobile);

        stock.addobserver(web);



        stock.setprice(500);
        stock.setprice(800);
    }
}