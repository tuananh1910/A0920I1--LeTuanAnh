package com.thymeleaf.service.impl;

import com.thymeleaf.model.Customer;
import com.thymeleaf.repository.CustomerRepository;
import com.thymeleaf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(Long id, Customer customer) {

    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }

}
