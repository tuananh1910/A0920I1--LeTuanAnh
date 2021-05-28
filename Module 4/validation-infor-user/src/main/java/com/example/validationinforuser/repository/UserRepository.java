package com.example.validationinforuser.repository;

import com.example.validationinforuser.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByLast_NameContains (String name, Pageable pageable);
}
