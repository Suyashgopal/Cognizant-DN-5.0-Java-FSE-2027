public class Main {

    public static void main(String[] args) {


        // giving required object to service using constructor

        CustomerRepository repo = new CustomerRepositoryImpl();


        CustomerService service = new CustomerService(repo);


        service.getcustomer(101);
    }
}