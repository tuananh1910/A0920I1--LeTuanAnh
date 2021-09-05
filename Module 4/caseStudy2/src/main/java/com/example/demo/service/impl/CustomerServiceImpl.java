package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        System.out.println(id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findCustomerByName(String nameSearch) {
        return customerRepository.findCustomersByName(nameSearch);
    }
}
