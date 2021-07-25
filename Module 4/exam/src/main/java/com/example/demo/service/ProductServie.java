package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductServie {
    List<Product> findAllProduct();
    Product findProductById(int id);
    void saveProduct(Product product);
    void deleteProductById(int id);

    void deleteAllProductById(List<Integer> id );
}
