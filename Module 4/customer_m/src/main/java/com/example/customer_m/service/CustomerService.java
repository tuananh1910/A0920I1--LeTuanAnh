package com.example.customer_m.service;

import com.example.customer_m.model.Customer;
import com.example.customer_m.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Iterable<Customer> findAll(Pageable pageable);
    Customer findById(int id);
    void save(Customer customer);
    void remove(int id);

    Page<Customer> findByNameContains(String name, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);
}
