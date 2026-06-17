import java.util.*;

class Product{
    int id, qty;
    String name;
    double price;

    Product(int id,String name,int qty,double price){
        this.id=id;
        this.name=name;
        this.qty=qty;
        this.price=price;
    }
}

public class Exercise1{

    static HashMap<Integer,Product> map=new HashMap<>();

    static void add(Product p){
        map.put(p.id,p); // add item
    }

    static void update(int id,int q){
        map.get(id).qty=q; // update qty
    }

    static void delete(int id){
        map.remove(id); // remove item
    }

    public static void main(String[] args){

        add(new Product(1,"Laptop",5,50000));
        update(1,10);
        delete(1);

        System.out.println("Inventory Updated");
    }
}

//hashmap add/update/delete= O(1)
