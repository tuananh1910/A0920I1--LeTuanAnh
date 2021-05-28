package com.example.customer_m.service;

import com.example.customer_m.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(int id);

    void save(Province province);

    void remove(int id);
}
