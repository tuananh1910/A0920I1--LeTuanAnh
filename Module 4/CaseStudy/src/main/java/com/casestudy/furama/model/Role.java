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
}
