package dao;

import model.Employee;
import model.User;

import java.util.List;

public interface IEmployeeDao {
    void insertEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployee();
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int id);
    void insertUser (User user);
}
