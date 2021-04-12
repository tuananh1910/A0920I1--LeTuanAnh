package dao;

import model.Employee;

import java.util.List;

public interface IEmployeeDao {
    void insertEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployee();
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
