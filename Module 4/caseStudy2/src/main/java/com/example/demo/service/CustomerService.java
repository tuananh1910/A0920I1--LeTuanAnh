package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();
    Customer findCustomerById(String id);
    Customer saveCustomer(Customer customer);
    void deleteCustomerById(String id);
    List<Customer> findCustomerByName(String nameSearch);
}
