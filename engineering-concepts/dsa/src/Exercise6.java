class Book{

    int id;
    String title,author;

    Book(int id,String title,String author){
        this.id=id;
        this.title=title;
        this.author=author;
    }
}


public class Exercise6{


    static int linear(Book a[],String s){

        for(int i=0;i<a.length;i++){

            if(a[i].title.equals(s))
                return i; // book found
        }

        return -1;
    }


    static int binary(Book a[],String s){

        int l=0,h=a.length-1;

        while(l<=h){

            int m=(l+h)/2;

            int c=a[m].title.compareTo(s);

            if(c==0)
                return m;

            if(c<0)
                l=m+1;
            else
                h=m-1;
        }

        return -1;
    }


    public static void main(String args[]){

        Book a[]={
                new Book(1,"ABC","Ram"),
                new Book(2,"XYZ","Tom")
        };

        System.out.println(binary(a,"XYZ"));
    }
}


