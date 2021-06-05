package com.example.cart.service;

import com.example.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable) ;
    Product findById(int id) ;

    void save (Product product);

    void removeById (int id);
}
