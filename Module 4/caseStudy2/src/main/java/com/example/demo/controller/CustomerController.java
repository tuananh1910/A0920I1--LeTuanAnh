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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
//    @GetMapping("customer/delete/{id}")
//    public String viewDeleteForm(Model model, @PathVariable String id){
//        model.addAttribute("customer",customerService.findCustomerById(id));
//        return "/customer/delete";
//    }
//    @PostMapping("customer/delete/{id}")
//    public RedirectView saveCustomer(Model model,@PathVariable String id,RedirectAttributes redirectAttributes){
//        customerService.deleteCustomerById(id);
//        redirectAttributes.addFlashAttribute("message","Delete Success Customer!");
//        return new RedirectView("/customer");
//    }
//    @GetMapping("/customer/edit/{id}")
//    public String viewEditForm(Model model,@PathVariable String id){
//        model.addAttribute("customer",customerService.findCustomerById(id));
//        model.addAttribute("customerTypes",customerTypeService.findAllListCustomerType());
//        return "/customer/edit";
//    }
//    @PostMapping("/customer/edit")
//    public RedirectView editCustomer(RedirectAttributes redirectAttributes,Customer customer){
//        System.out.println("customer Id :"+customer.getId());
//        System.out.println("Customer type"+customer.getCustomerType().getName());
//        redirectAttributes.addFlashAttribute("message","Edit Customer Success!");
//        customerService.saveCustomer(customer);
//        return new RedirectView("/customer");
//    }
}
