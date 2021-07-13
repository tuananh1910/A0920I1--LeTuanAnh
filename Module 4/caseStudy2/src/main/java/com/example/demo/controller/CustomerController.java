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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerTypeServiceImpl customerTypeService;
    @Autowired
    RoleServiceImpl roleService;

    @GetMapping("/customer")
    public ModelAndView ViewListCustomer(){
        return new ModelAndView("customer/list","customers", customerService.findAllCustomer());
    }

    @GetMapping("customer/create")
    public String viewCreateForm(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypes",customerTypeService.findAllListCustomerType());
        return "/customer/create";
    };
    @PostMapping("customer/save")
    public String saveCustomer(@Validated Customer customer, BindingResult bindingResult, Model model){
        new Customer().validate(customer,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customer",customer);
            model.addAttribute("customerTypes",customerTypeService.findAllListCustomerType());
//          redirectAttributes.addFlashAttribute()
            return "/customer/create";
        }
        else{
//            redirectAttributes.addFlashAttribute("message","Create Success Customer! ");
            customerService.saveCustomer(customer);
            return "redirect:/customer";
        }

    }

    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomerById(id);
        return "redirect:/customer";
    }


    @GetMapping("/customer/edit/{id}")
    public String viewEditForm(Model model,@PathVariable("id") String id){
        System.out.println("Edit");
        model.addAttribute("customer",customerService.findCustomerById(id));
        model.addAttribute("customerTypes",customerTypeService.findAllListCustomerType());
        return "/customer/edit";
    }

    @PostMapping("/customer/update")
    public String editCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }
}
