package com.example.smartphone.service;

import com.example.smartphone.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Integer id);
}
