package com.casestudy.furama.service;

import com.casestudy.furama.model.Education_Degree;

import java.util.List;

public interface EducationDegreeService {
    List<Education_Degree> findAll();
    Education_Degree findEducationDegreeById(int educationDegreeId);
}
