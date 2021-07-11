package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserByUsername( String username);

    void save(User user);

    void remove (String username);
}
