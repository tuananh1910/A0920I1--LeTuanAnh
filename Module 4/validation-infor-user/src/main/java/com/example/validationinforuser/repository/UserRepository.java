package com.example.validationinforuser.repository;

import com.example.validationinforuser.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//        @Query(
//            value = "SELECT * FROM User WHERE last_name like :last_name%",
//            nativeQuery = true)
//    Page<User> findByLastNameContains(@Param("last_name") String name, Pageable pageable);


//    @Query(
//            value = "SELECT * FROM User u WHERE u.last_name = ?1",
//            nativeQuery = true)
    //    @Query("SELECT e FROM User e WHERE e.last_Name like '?1%' ")

//    @Query("SELECT e FROM User e WHERE e.last_Name = :last_name")
}
