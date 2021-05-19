package com.thymeleaf.service;

import com.thymeleaf.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Long id);

    void update(Long id, Customer customer);

    void remove(Long id);

}
