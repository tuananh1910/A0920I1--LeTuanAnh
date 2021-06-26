package com.casestudy.furama.service;

import com.casestudy.furama.model.Role;
import com.casestudy.furama.model.User_role;

import java.util.List;

public interface UserRoleService {
    List<User_role> findAll();

    void save(User_role user_role);
}
