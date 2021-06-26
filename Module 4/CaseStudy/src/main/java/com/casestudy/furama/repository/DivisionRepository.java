package com.casestudy.furama.repository;

import com.casestudy.furama.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
