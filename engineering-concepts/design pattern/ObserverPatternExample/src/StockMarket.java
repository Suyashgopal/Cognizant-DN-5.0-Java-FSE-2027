import java.util.*;

public class StockMarket implements Stock {

    private List<Observer> list = new ArrayList<>();

    private int price;


    public void addobserver(Observer obj) {

        list.add(obj);
    }


    public void removeobserver(Observer obj) {

        list.remove(obj);
    }


    public void notifyobserver() {

        for(Observer obj : list) {

            obj.update(price);
        }
    }


    // whenever price changes all observers get updated

    public void setprice(int price) {

        this.price = price;

        notifyobserver();
    }
}