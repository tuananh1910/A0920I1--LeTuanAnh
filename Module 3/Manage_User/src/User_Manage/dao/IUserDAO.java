package User_Manage.dao;

import User_Manage.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user);
    User selectUser(int id);
    List<User> selectAllUsers();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> findByCountry(String country);

    //goi store procedure
    User getUserById(int id);
    void insertUserStore (User user);

    //JDBC transaction
    void addUserTransaction(User user, int[] permision);
    //witoutTransaction
    void insertUpdateWithoutTransaction();

    //withTransaction
    void insertUpdateUseTransaction();
}
