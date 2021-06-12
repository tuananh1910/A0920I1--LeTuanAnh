package com.casestudy.furama.model;

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
}
