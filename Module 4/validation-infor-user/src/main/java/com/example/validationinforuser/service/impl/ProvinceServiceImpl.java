package com.example.validationinforuser.service.impl;

import com.example.validationinforuser.model.Province;
import com.example.validationinforuser.repository.ProvinceRepository;
import com.example.validationinforuser.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Page<Province> findAll(Pageable pageable ) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(int id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void removeById(int id) {
        provinceRepository.deleteById(id);
    }
}
