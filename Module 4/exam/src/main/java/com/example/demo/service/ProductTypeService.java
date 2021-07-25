package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAllProductType();
    ProductType findProductTypeById(int id);
    void saveProductType(ProductType productType);
    void deleteProductTypeById(int id);
}
