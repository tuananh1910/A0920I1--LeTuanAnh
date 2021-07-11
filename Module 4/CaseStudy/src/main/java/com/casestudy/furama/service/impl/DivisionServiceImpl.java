package com.casestudy.furama.service.impl;

import com.casestudy.furama.model.Division;
import com.casestudy.furama.repository.DivisionRepository;
import com.casestudy.furama.service.DivisionService;
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
