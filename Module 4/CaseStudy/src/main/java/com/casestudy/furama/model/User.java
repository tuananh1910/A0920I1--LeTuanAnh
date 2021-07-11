package com.casestudy.furama.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    private String username;

    @NotEmpty
    @Size(min = 6)
    private String password;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    //    @OneToMany(targetEntity = User_role.class)
//    private List<User_role> user_roles;
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role;


    public User() {
    }

    public User(String username, @NotEmpty @Size(min = 6) String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, @NotEmpty @Size(min = 6) String password, Set<Role> role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, @NotEmpty @Size(min = 6) String password, List<Employee> employees, Set<Role> role) {
        this.username = username;
        this.password = password;
        this.employees = employees;
        this.role = role;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
