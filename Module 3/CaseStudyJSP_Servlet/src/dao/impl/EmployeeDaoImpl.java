package dao.impl;

import common.PrintSQLException;
import dao.IEmployeeDao;
import model.Employee;
import untils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao {
    private static final String INSERT_EMPLOYEE_SQL = "Insert into EMPLOYEE(employee_name, employee_birthday," +
            " employee_id_card, employee_salary,employee_phone,employee_email,employee_address,position_id," +
            "education_degree_id,division_id,username) " +
            "values (?, ?, ?, ?,?, ?, ?, ?,?,?,?)";   //11
    private static final String SELECT_EMPLOYEE_BY_ID = "Select * from EMPLOYEE where employee_id = ?";
    private static final String SELECT_ALL_EMPLOYEE = "Select * from CUSTOMER";
    private static final String DELETE_EMPLOYEE_BY_ID = "Delete from CUSTOMER where employee_id = ?";
    private static final String UPDATE_EMPLOYEE = "Update CUSTOMER set employee_name=? , employee_birthday = ?, employee_id_card = ?, " +
            "employee_salary = ?, employee_phone = ?, employee_email = ?,employee_address = ?, position_id= ?" +
            "education_degree_id=? ,division_id=?,username=? where customer_id = ?";  //12


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
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
