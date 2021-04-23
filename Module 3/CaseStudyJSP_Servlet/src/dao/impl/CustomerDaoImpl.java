package dao.impl;

import dao.ICustomerDao;
import exception.PrintSQLException;
import model.Customer;
import model.Customer_Type;
import untils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {
    private static final String INSERT_CUSTOMER_SQL = "Insert into CUSTOMER(customer_type_id, customer_name," +
            " customer_birthday, customer_gender,customer_id_card,customer_phone,customer_email,customer_address) " +
            "values (?, ?, ?, ?,?, ?, ?, ?)";
    private static final String SELECT_CUSTOMER_BY_ID = "Select * from CUSTOMER where customer_id = ?";
    private static final String SELECT_ALL_CUSTOMER = "Select * from CUSTOMER";
    private static final String DELETE_CUSTOMER_BY_ID = "Delete from CUSTOMER where customer_id = ?";
    private static final String UPDATE_CUSTOMER = "Update CUSTOMER set customer_type_id=? , customer_name = ?, customer_birthday = ?, " +
            "customer_gender = ?, customer_id_card = ?, customer_phone = ?,customer_email = ?, customer_address= ?" +
            "where customer_id = ?";

    //customertypeid
    private static final String SELECT_CUSTOMER_TYPE = "Select * from CUSTOMER_TYPE";
    private static final String SELECT_CUSTOMER_TYPE_BY_ID = "Select * from CUSTOMER_TYPE where customer_id = ?";




    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_CUSTOMER_SQL);

            statement.setInt(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setString(3, customer.getCustomer_birthday());
            statement.setString(4, customer.getCustomer_gender());
            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        try {
            try (Connection connection = ConnectionDB.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {

                //Create a statement using connection object
                preparedStatement.setInt(1,id);
                System.out.println(preparedStatement);

                // Execute the query or update query
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int customer_id = resultSet.getInt("customer_id");
                    int customer_type_id = resultSet.getInt("customer_type_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    String customer_gender = resultSet.getString("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_emnai = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");

                    customer=new Customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
                            customer_id_card,customer_phone,customer_emnai,customer_address);
                    }
            }
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();

        //Establishing a Connection
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {

            //Create a statement using connection object

            System.out.println(preparedStatement);

            // Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                String customer_gender = resultSet.getString("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_emnai = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");

                customers.add(new Customer(customer_id,customer_type_id, customer_name, customer_birthday, customer_gender,
                        customer_id_card, customer_phone, customer_emnai, customer_address));
            }
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        return customers;
    }

    @Override
    public boolean upodateCustomer(Customer customer) {
        boolean rowUpdate=false;               //!!!!!!
        Connection connection;
        PreparedStatement statement;

        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(UPDATE_CUSTOMER);
//            System.out.println(customer.getCustomer_id());
            statement.setInt(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setString(3, customer.getCustomer_birthday());

            statement.setString(4, customer.getCustomer_gender());
            // Data too long for column 'customer_gender' at row 1
            System.out.println(customer.getCustomer_gender());

            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
            statement.setInt(9,customer.getCustomer_id());
            System.out.println(statement.executeUpdate());
            rowUpdate = statement.executeUpdate()>0;

        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        System.out.println(rowUpdate);
        return rowUpdate;
    }

    @Override
    public boolean deleteCustomer(int id) {

        // Fk customer id contract !!
        boolean rowDelete= false;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID)){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate()>0; // excuteUpdate
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        //System.out.println(rowDelete);
        return rowDelete;
    }

    @Override
    public List<Customer_Type> getAllCustomerType() {
        List<Customer_Type> list_customer_type=new ArrayList<>();
        try {
            Connection connection=ConnectionDB.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CUSTOMER_TYPE);
            System.out.println(preparedStatement);

            // Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                list_customer_type.add(new Customer_Type(customer_type_id,customer_type_name));
            }
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        return list_customer_type;
    }

//    @Override
//    public Customer_Type getCustomerType(int id) {
//        Customer_Type customer_type = null;
//        try {
//            try (Connection connection = ConnectionDB.getConnection();
//                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE_BY_ID)) {
//
//                //Create a statement using connection object
//                preparedStatement.setInt(1,id);
//                System.out.println(preparedStatement);
//
//                // Execute the query or update query
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()){
//                    int customer_type_id = resultSet.getInt("customer_type_id");
//
//                    String customer_type_name = resultSet.getString("customer_type_name");
//
//                    customer_type=new Customer_Type(customer_type_id,customer_type_name);
//                }
//            }
//        } catch (SQLException e) {
//            PrintSQLException.printSQLException(e);
//        }
//
//        return customer_type;
//    }
}
