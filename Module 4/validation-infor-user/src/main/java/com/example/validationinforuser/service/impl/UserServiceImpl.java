package com.example.validationinforuser.service.impl;

import com.example.validationinforuser.exception.DuplicateEmailException;
import com.example.validationinforuser.repository.UserRepository;
import com.example.validationinforuser.model.User;

import com.example.validationinforuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> findAllUser( Pageable pageable) throws Exception {
//
//        if (true) {
//            throw new Exception("a dummy exception");
//        }
        System.out.println("find All");
        return userRepository.findAll(pageable);
    }
    @Override
    public User findUserById(int id)   {
//        User target = userRepository.findById(id).orElse(null);
//        if (target==null){
//            throw new Exception("User not found!");
//        }
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) throws DuplicateEmailException {
        try{
            userRepository.save(user);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void removeById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findByLast_NameContains(String name, Pageable pageable) {
//
//        List<User> users = new ArrayList<>();
//        users = (List<User>) userRepository.findByLast_NameContains(name,pageable);
        return userRepository.findByLastNameContains(name, pageable);
    }
}
