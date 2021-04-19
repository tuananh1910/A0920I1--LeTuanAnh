package dao.impl;

import common.PrintSQLException;
import dao.IEmployeeDao;
import model.Employee;
import model.User;
import untils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao {
    private static final String INSERT_EMPLOYEE_SQL = "Insert into EMPLOYEE(employee_name, employee_birthday," +
            " employee_id_card, employee_salary,employee_phone,employee_email,employee_address,position_id," +
            "education_degree_id,division_id,username) " +
            "values (?, ?, ?, ?,?, ?, ?, ?,?,?,?)";   //11
    private static final String SELECT_EMPLOYEE_BY_ID = "Select * from EMPLOYEE where employee_id = ?";
    private static final String SELECT_ALL_EMPLOYEE = "Select * from EMPLOYEE";
    private static final String DELETE_EMPLOYEE_BY_ID = "Delete from EMPLOYEE where employee_id = ?";
    private static final String UPDATE_EMPLOYEE = "Update EMPLOYEE set employee_name=? , employee_birthday = ?, employee_id_card = ?, " +
            "employee_salary = ?, employee_phone = ?, employee_email = ?,employee_address = ?, position_id= ?" +
            "education_degree_id=? ,division_id=?,username=? where employee_id = ?";  //12

    // user
    private static final String INSERT_USER_SQL = "Insert into USER values (?,?)";

    @Override
    public void insertUser(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_USER_SQL);

            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());

            System.out.println(statement);
            statement.executeUpdate();

        }catch (SQLException e){
            PrintSQLException.printSQLException(e);
        }
    }
    @Override
    public void insertEmployee(Employee employee) {
        Connection connection = null;
        PreparedStatement statement= null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);

            statement.setString(1, employee.getEmployee_name());
            statement.setString(2, employee.getEmployee_birthday());
            statement.setString(3, employee.getEmployee_id_card());
            statement.setDouble(4, employee.getEmployee_salary());
            statement.setString(5, employee.getEmployee_phone());
            statement.setString(6, employee.getEmployee_email());
            statement.setString(7, employee.getEmployee_address());
            statement.setInt(8, employee.getPosition_id());
            statement.setInt(9, employee.getEducation_degree_id());
            statement.setInt(10, employee.getDivision_id());
            statement.setString(11, employee.getUsername());

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
    public Employee getEmployee(int id) {
        Employee employee = null;
        try {
            try (Connection connection = ConnectionDB.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {

                //Create a statement using connection object
                preparedStatement.setInt(1,id);
                System.out.println(preparedStatement);

                // Execute the query or update query
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int employee_id = resultSet.getInt("employee_id");
                    String employee_name = resultSet.getString("employee_name");
                    String employee_birthday = resultSet.getString("employee_birthday");
                    String employee_id_card = resultSet.getString("employee_id_card");
                    Double employee_salary = resultSet.getDouble("employee_salary");

                    String employee_phone = resultSet.getString("employee_phone");
                    String employee_email = resultSet.getString("employee_email");
                    String employee_address = resultSet.getString("employee_address");

                    int position_id = resultSet.getInt("position_id");
                    int education_degree_id = resultSet.getInt("education_degree_id");
                    int division_id = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");

                    employee=new Employee(employee_id,employee_name,employee_birthday,employee_id_card,
                            employee_salary,employee_phone,employee_email,employee_address,
                            position_id,education_degree_id,division_id,username);
                }
            }
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }

        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        //Establishing a Connection
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {

            //Create a statement using connection object

            System.out.println(preparedStatement);

            // Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");

                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");

                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");

                employeeList.add(new Employee(employee_id,employee_name,employee_birthday,employee_id_card,
                        employee_salary,employee_phone,employee_email,employee_address,
                        position_id,education_degree_id,division_id,username));
            }
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean rowUpdate=false;               //!!!!!!
        Connection connection;
        PreparedStatement statement;

        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(UPDATE_EMPLOYEE);
//            System.out.println(customer.getCustomer_id());
            statement.setString(1, employee.getEmployee_name());
            statement.setString(2, employee.getEmployee_birthday());
            statement.setString(3, employee.getEmployee_id_card());

            statement.setDouble(4, employee.getEmployee_salary());
            // Data too long for column 'customer_gender' at row 1


            statement.setString(5, employee.getEmployee_phone());
            statement.setString(6, employee.getEmployee_email());
            statement.setString(7, employee.getEmployee_address());
            statement.setInt(8, employee.getPosition_id());
            statement.setInt(9,employee.getEducation_degree_id());
            statement.setInt(10,employee.getDivision_id());
            statement.setString(11, employee.getUsername());
            statement.setInt(12,employee.getEmployee_id());



            System.out.println(statement.executeUpdate());
            rowUpdate = statement.executeUpdate()>0;

        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        System.out.println(rowUpdate);
        return rowUpdate;
    }

    @Override
    public boolean deleteEmployee(int id) {
        // Fk employee  !!
        boolean rowDelete= false;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID)){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate()>0; // excuteUpdate
        } catch (SQLException e) {
            PrintSQLException.printSQLException(e);
        }
        //System.out.println(rowDelete);
        return rowDelete;
    }
}
