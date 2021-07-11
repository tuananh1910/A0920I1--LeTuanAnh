package com.casestudy.furama.service;

import com.casestudy.furama.model.Division;

import java.util.List;

public interface DivisionService {
    List<com.casestudy.furama.model.Division> findAll();
    Division findDivisionById(int divisionId);
}
