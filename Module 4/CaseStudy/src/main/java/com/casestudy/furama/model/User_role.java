package com.casestudy.furama.model;

import javax.persistence.*;

@Entity
public class User_role {    // ko co primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;

    @ManyToOne
    @JoinColumn(name = "username", updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", updatable = false)
    private Role role;


    public User_role() {
    }

    public User_role(Role role_id, User username) {

        this.role = role_id;
        this.user = username;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
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
