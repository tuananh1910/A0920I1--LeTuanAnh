package com.casestudy.furama.repository;

import com.casestudy.furama.model.User_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRoleRepository extends JpaRepository<User_role,String> {

    @Modifying
    @Transactional
    @Query(value ="DELETE from User_role where username=:username",nativeQuery = true)
    void deleteByUsername (@Param("username") String username);

}
