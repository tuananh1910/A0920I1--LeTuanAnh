package com.casestudy.furama.service.impl;

import com.casestudy.furama.model.User_role;
import com.casestudy.furama.repository.UserRoleRepository;
import com.casestudy.furama.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<User_role> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public void save(User_role user_role) {
        userRoleRepository.save(user_role);
    }
}
