package dao;



import model.Customer;
import model.Customer_Type;

import java.util.List;

public interface ICustomerDao {
    void insertCustomer(Customer customer);
    Customer getCustomer(String id);
    List<Customer> getAllCustomer();
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String id);
//    List<Customer_Type> getAllCustomerType();
    Customer_Type getCustomerType(int id);
}
