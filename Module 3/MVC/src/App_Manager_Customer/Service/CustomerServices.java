package App_Manager_Customer.Service;

import App_Manager_Customer.Model.Customer;

import java.util.List;

public interface CustomerServices {
    List<Customer>findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer);
    void remove(int id);
}
