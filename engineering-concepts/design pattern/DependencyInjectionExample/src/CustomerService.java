public class CustomerService {

    private CustomerRepository repo;


    // dependency is passed from outside instead of creating here

    public CustomerService(CustomerRepository repo) {

        this.repo = repo;
    }


    public void getcustomer(int id) {

        System.out.println(repo.findcustomerbyid(id));
    }
}