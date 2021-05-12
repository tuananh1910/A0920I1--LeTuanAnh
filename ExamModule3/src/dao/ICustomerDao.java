package dao;

import model.Customer;

import java.util.List;

public interface ICustomerDao {
    void insertCustomer( Customer customer);
    Customer getCustomer(int id);
    List<Customer> getAllCustomer();
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
}
