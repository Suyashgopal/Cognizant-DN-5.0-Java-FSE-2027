class Task{

    int id;
    String name,status;
    Task next;

    Task(int id,String name,String status){
        this.id=id;
        this.name=name;
        this.status=status;
    }
}


public class Exercise5{

    static Task head;


    static void add(Task t){

        t.next=head;
        head=t; // add node
    }


    static void search(int id){

        Task t=head;

        while(t!=null){

            if(t.id==id)
                System.out.println(t.name);

            t=t.next;
        }
    }


    static void delete(){

        head=head.next; // remove first
    }


    public static void main(String[] args){

        add(new Task(1,"Study","Done"));

        search(1);

        delete();
    }
}


