package com.example.demo.service.impl;


import com.example.demo.model.Division;
import com.example.demo.repository.DivisionRepository;
import com.example.demo.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findDivisionById(int divisionId) {
        return divisionRepository.findById(divisionId).orElse(null);
    }
}
