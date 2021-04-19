package dao;



import model.Customer;
import model.Customer_Type;

import java.util.List;

public interface ICustomerDao {
    void insertCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getAllCustomer();
    boolean upodateCustomer(Customer custoemr);
    boolean deleteCustomer(int id);
    List<Customer_Type> getAllCustomerType();
//    Customer_Type getCustomerType(int id);
}
