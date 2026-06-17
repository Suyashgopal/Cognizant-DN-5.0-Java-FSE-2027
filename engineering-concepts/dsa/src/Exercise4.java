class Employee{

    int id;
    String name,pos;
    double sal;

    Employee(int id,String name,String pos,double sal){
        this.id=id;
        this.name=name;
        this.pos=pos;
        this.sal=sal;
    }
}


public class Exercise4{

    static Employee arr[]=new Employee[10];
    static int n=0;


    static void add(Employee e){
        arr[n++]=e; // add employee
    }


    static void search(int id){

        for(int i=0;i<n;i++)
            if(arr[i].id==id)
                System.out.println(arr[i].name);
    }


    static void delete(int id){

        for(int i=0;i<n;i++){

            if(arr[i].id==id){

                arr[i]=arr[n-1];
                n--; // delete data
            }
        }
    }


    public static void main(String[] args){

        add(new Employee(1,"Ram","Dev",50000));
        search(1);
        delete(1);
    }
}

// add/search/traverse/delete=o(1)

