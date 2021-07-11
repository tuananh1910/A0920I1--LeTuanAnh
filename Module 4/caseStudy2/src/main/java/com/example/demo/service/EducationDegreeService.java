package com.example.demo.service;


import com.example.demo.model.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();
    EducationDegree findEducationDegreeById(int id);
}
