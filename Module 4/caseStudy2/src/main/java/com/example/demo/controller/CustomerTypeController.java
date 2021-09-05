package com.example.demo.controller;

import com.example.demo.model.CustomerType;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerTypeController {
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("/customerType")
    public List<CustomerType> ViewListCustomer(){
        System.out.println(customerTypeService.findAllListCustomerType());
        return customerTypeService.findAllListCustomerType();
    }

}
