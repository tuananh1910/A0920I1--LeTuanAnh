package com.casestudy.furama.model;

import javax.persistence.*;

//@Entity
public class User_role {    // ko co primary key

    private int role_id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public User_role() {
    }
}
