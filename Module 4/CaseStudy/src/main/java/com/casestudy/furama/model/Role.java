package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    private String role_name;

    @ManyToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<User> users;

    public Role() {
    }

    public Role(int role_id, String role_name, Set<User> users) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.users = users;
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
