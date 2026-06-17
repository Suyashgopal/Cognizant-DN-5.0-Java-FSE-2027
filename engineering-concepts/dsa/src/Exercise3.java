class Order{

    int id;
    String name;
    double price;

    Order(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}


public class Exercise3{


    static void bubble(Order a[]){

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){

                if(a[j].price>a[j+1].price){

                    Order t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t; // swap order
                }
            }
        }
    }


    static void quick(Order a[],int l,int h){

        if(l<h){

            int p=part(a,l,h);

            quick(a,l,p-1);
            quick(a,p+1,h);
        }
    }


    static int part(Order a[],int l,int h){

        double p=a[h].price;
        int i=l-1;

        for(int j=l;j<h;j++){

            if(a[j].price<p){

                i++;
                Order t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }

        Order t=a[i+1];
        a[i+1]=a[h];
        a[h]=t;

        return i+1;
    }


    public static void main(String[] args){

        Order a[]={
                new Order(1,"A",500),
                new Order(2,"B",100)
        };

        quick(a,0,a.length-1);

        System.out.println("Orders Sorted");
    }
}

// bubble o(n^2) quick o(nlog n)

