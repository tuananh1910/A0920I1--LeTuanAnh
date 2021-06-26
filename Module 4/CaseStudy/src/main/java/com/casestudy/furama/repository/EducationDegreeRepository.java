package com.casestudy.furama.repository;

import com.casestudy.furama.model.Education_Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepository extends JpaRepository<Education_Degree,Integer> {
}
