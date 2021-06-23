package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    private String role_name;

    @OneToMany(targetEntity = User_role.class)
    private List<User_role> user_roles;


    public Role() {
    }

    public Role(int role_id, String role_name, List<User_role> user_roles) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.user_roles = user_roles;
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

    public List<User_role> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(List<User_role> user_roles) {
        this.user_roles = user_roles;
    }
}
