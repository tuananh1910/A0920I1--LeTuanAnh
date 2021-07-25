package com.example.demo.service.impl;

import com.example.demo.model.ProductType;
import com.example.demo.repository.ProductTypeRepository;
import com.example.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAllProductType() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findProductTypeById(int id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void deleteProductTypeById(int id) {
        productTypeRepository.deleteById(id);
    }
}
