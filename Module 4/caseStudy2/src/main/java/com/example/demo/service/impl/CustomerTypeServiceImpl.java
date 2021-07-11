package com.example.demo.service.impl;

import com.example.demo.model.CustomerType;
import com.example.demo.repository.CustomerTypeRepository;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllListCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findCustomerTypeById(String id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomerType(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void deleteCustomerTypeById(String id) {
        customerTypeRepository.deleteById(id);
    }
}
