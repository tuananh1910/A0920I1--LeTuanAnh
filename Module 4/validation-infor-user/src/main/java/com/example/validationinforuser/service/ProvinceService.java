package com.example.validationinforuser.service;

import com.example.validationinforuser.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvinceService {
    Page<Province> findAll(Pageable pageable );

    Province findById(int id);

    void save (Province province);

    void removeById (int id);
}
