package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.impl.CustomerServiceImpl;
import com.example.demo.service.impl.CustomerTypeServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerTypeServiceImpl customerTypeService;
    @Autowired
    RoleServiceImpl roleService;

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/customer")
    public List<Customer> ViewListCustomer(){
        return customerService.findAllCustomer();
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable("id") String id){
        return customerService.findCustomerById(id);
    }
//    @GetMapping("customer/create")
//    public String viewCreateForm(Model model){
//        model.addAttribute("customer",new Customer());
//        model.addAttribute("customerTypes",customerTypeService.findAllListCustomerType());
//        return "/customer/create";
//    };
    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
      return customerService.saveCustomer(customer);
    }
//
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        System.out.println(id);
        customerService.deleteCustomerById(id);
    }


//    @GetMapping("/customer/edit/{id}")
//    public String viewEditForm(Model model,@PathVariable("id") String id){
//        System.out.println("Edit");
//        model.addAttribute("customer",customerService.findCustomerById(id));
//        model.addAttribute("customerTypes",customerTypeService.findAllListCustomerType());
//        return "/customer/edit";
//    }

    @PutMapping("/customer/{id}")
    public Customer editCustomer(@RequestBody Customer customer,
                                 @PathVariable("id") String id){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customer/searchName/{nameSearch}")
    public List<Customer> findCustomerByName(@PathVariable("nameSearch") String nameSearch){
        return customerService.findCustomerByName(nameSearch);
    }
}
