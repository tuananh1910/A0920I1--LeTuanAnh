package com.example.demo.service.impl;


import com.example.demo.model.EducationDegree;
import com.example.demo.repository.EducationDegreeRepository;
import com.example.demo.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findEducationDegreeById(int educationDegreeId) {
        return educationDegreeRepository.findById(educationDegreeId).orElse(null);
    }
}
