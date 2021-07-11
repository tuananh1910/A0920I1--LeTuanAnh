package com.example.demo.service;

import com.example.demo.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAllListCustomerType();
    CustomerType findCustomerTypeById(String id);
    void saveCustomerType(CustomerType customerType);
    void deleteCustomerTypeById(String id);
}
