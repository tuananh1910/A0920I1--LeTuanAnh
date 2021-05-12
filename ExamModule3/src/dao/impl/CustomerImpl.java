package dao.impl;

import dao.ICustomerDao;
import model.Customer;
import untils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerImpl implements ICustomerDao {

    private static final String GET_CUSTOMER_BY_ID = "Select * from CUSTOMER where customer_id=?";
    private static final String GET_ALL_CUSTOMER = "Select * from CUSTOMER";
    @Override
    public void insertCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement statement = null;

            try  {
                connection = ConnectionDB.getConnection();
                statement = connection.prepareStatement(GET_CUSTOMER_BY_ID);
                //Create a statement using connection object
                statement.setInt(1,id);
                System.out.println(statement);

                // Execute the query or update query
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int customer_id = resultSet.getInt("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_address = resultSet.getString("customer_address");
                    String customer_email = resultSet.getString("customer_email");

                    customer=new Customer(customer_id,customer_name,customer_birthday,customer_phone,customer_address,customer_email);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try  {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(GET_ALL_CUSTOMER);
            //Create a statement using connection object

            System.out.println(statement);

            // Execute the query or update query
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_address = resultSet.getString("customer_address");
                String customer_email = resultSet.getString("customer_email");

                customerList.add(new Customer(customer_id,customer_name,customer_birthday,customer_phone,customer_address,customer_email));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }
}
