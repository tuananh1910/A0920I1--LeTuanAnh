package com.casestudy.furama.service.impl;

import com.casestudy.furama.model.Education_Degree;
import com.casestudy.furama.repository.EducationDegreeRepository;
import com.casestudy.furama.repository.EmployeeRepository;
import com.casestudy.furama.service.EducationDegreeService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<Education_Degree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Education_Degree findEducationDegreeById(int educationDegreeId) {
        return educationDegreeRepository.findById(educationDegreeId).orElse(null);
    }
}
