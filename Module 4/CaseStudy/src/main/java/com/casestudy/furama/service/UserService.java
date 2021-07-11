package com.casestudy.furama.service;

import com.casestudy.furama.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserByUsername( String username);

    void save(User user);

    void remove (String username);
}
