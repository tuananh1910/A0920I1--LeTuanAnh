package com.casestudy.furama.repository;

import com.casestudy.furama.model.User_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<User_role,Integer> {
}
