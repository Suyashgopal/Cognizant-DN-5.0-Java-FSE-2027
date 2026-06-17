import java.util.*;

class product{
    int id;
    String name,cat;

    product(int id,String name,String cat){
        this.id=id;
        this.name=name;
        this.cat=cat;
    }
}

public class Exercise2{

    static int linear(Product a[],int id){

        for(int i=0;i<a.length;i++){
            if(a[i].id==id)
                return i; // item found
        }
        return -1;
    }


    static int binary(product a[],int id){

        int l=0,h=a.length-1;

        while(l<=h){

            int m=(l+h)/2;

            if(a[m].id==id)
                return m; // item found

            if(a[m].id<id)
                l=m+1;
            else
                h=m-1;
        }
        return -1;
    }


    public static void main(String[] args){

        product a[]={
                new product(1,"Phone","Tech"),
                new product(2,"Book","Study")
        };

        System.out.println(binary(a ,2));
    }
}

// Linear: O(n) Binary: O(log n)
