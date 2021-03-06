package com.example.validationinforuser.service;

import com.example.validationinforuser.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAllUser(Pageable pageable);
    User findUserById(int id);

    void save (User user);

    void removeById (int id);

    Page<User> findByLast_NameContains(String name, Pageable pageable);
}
