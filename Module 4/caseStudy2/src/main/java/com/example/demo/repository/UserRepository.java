package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "SELECT * from User where username=:username" , nativeQuery = true)
    User findUserByUsername(@Param("username")String username);
    @Query(
            value="SELECT Role.role_name from User_role inner join User on User.username = User_role.username inner join Role on Role.role_id= User_role.role_id where User.username=:username "
                , nativeQuery = true
    )
    String findRoleNameByUsername(@Param("username") String username);

}
