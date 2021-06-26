package com.casestudy.furama.service.impl;

import com.casestudy.furama.model.Role;
import com.casestudy.furama.repository.RoleRepository;
import com.casestudy.furama.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
