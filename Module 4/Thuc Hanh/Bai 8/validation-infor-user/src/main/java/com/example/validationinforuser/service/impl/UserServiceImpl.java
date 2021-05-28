package com.example.validationinforuser.service.impl;

import com.example.validationinforuser.model.User;
import com.example.validationinforuser.repository.UserRepository;

import com.example.validationinforuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> findAllUser(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findByLast_NameContains(String name, Pageable pageable) {
        return userRepository.findByLast_NameContains(name, pageable);
    }
}
