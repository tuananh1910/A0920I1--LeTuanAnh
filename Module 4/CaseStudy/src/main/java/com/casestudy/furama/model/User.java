package com.casestudy.furama.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
    private String username;
    private String password;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    @OneToMany(targetEntity = User_role.class)
    private List<User_role> user_roles;




    public User() {
    }

    public User(String username, String password, List<Employee> employees, List<User_role> user_roles) {
        this.username = username;
        this.password = password;
        this.employees = employees;
        this.user_roles = user_roles;
    }

    public User(String username, String password, List<GrantedAuthority> grantList) {

    }


//    public User(String username, String password, GrantedAuthority authority) { ??
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<User_role> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(List<User_role> user_roles) {
        this.user_roles = user_roles;
    }
}
