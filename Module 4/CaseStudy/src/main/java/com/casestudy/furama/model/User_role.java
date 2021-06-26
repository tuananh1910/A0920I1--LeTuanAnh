package com.casestudy.furama.model;

import javax.persistence.*;

@Entity
public class User_role {    // ko co primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;

    private int role_id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id",insertable = false, updatable = false)
    private Role role;


    public User_role() {
    }

    public User_role(int role_id, String username) {
        this.role_id = role_id;
        this.username = username;
    }

    public User_role(int userRoleId, int role_id, String username, User user, Role role) {
        this.userRoleId = userRoleId;
        this.role_id = role_id;
        this.username = username;
        this.user = user;
        this.role = role;
    }

    public User_role(int userRoleId, int role_id, String username) {
        this.userRoleId = userRoleId;
        this.role_id = role_id;
        this.username = username;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
