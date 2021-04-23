package dao;

import model.*;

import java.util.List;

public interface IEmployeeDao {
    void insertEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployee();
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int id);

    Position getPosition(int id);
    Education_Degree getEducationDegree(int id);
    Division getDivision(int id);

    //user
    void insertUser (User user);
    boolean deleteUser(String username,String old_username);
    User getUser(String username);
    boolean updateUser(String username, String old_username);

    //user role
    void insertUserRole (User_role user_role);
    boolean deleteUserRole(String username,String old_username);
    User_role getUserRole(String username);
    boolean updateUserRole(String username,String old_username);

}
