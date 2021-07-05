package com.casestudy.furama.service;

import com.casestudy.furama.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    void remove (String username);
}
