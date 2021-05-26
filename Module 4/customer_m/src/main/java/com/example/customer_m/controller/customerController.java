package com.example.customer_m.controller;

import com.example.customer_m.model.Customer;
import com.example.customer_m.model.Province;
import com.example.customer_m.service.CustomerService;
import com.example.customer_m.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class customerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/")
    public ModelAndView getHome(@RequestParam Optional<String> key_search, @PageableDefault(value = 2) Pageable pageable, Model model){
        if (!key_search.isPresent()){
            System.out.println("all list");
            return new ModelAndView("customer/list","customers",customerService.findAll(pageable));
        }else {
            System.out.println("keysr:"+key_search.get());
            model.addAttribute("key_search", key_search.get());
            return new ModelAndView("customer/list","customers", customerService.findByNameContains(key_search.get(),pageable));
        }
    }


    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable(value = "id") int id){
        return new ModelAndView("customer/edit","customer",customerService.findById(id));
    }

    @PostMapping("/update")
    public String Update (Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable(value = "id")int id){
        customerService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView getCreate(){
        System.out.println("create");
        return new ModelAndView("customer/create","customer",new Customer());
    }

    @PostMapping("/save")
    public String add(Customer blog){
        System.out.println("save");
        customerService.save(blog);
        return "redirect:/";
    }
}
