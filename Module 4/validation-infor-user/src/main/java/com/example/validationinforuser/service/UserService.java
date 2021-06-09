package com.example.validationinforuser.service;

import com.example.validationinforuser.exception.DuplicateEmailException;
import com.example.validationinforuser.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAllUser(Pageable pageable) throws Exception;
    User findUserById(int id) ;

    void save (User user) throws DuplicateEmailException;

    void removeById (int id);

//    Page<User> findByLast_NameContains(String name, Pageable pageable);
}
