package com.casestudy.furama.controller;

import com.casestudy.furama.model.Employee;
import com.casestudy.furama.model.User;
import com.casestudy.furama.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHome(){
        return new ModelAndView("home/home");
    }

//    @RequestMapping(value = "/employee-list" , method = RequestMethod.GET,
//            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
//    @ResponseBody
//    public List<Employee> getListEmployees(){
//        return  employeeService.findAll();
//    }

    //employee
    @GetMapping("/employee-list")
    public ModelAndView listEmployee(){
        return new ModelAndView("employee/list","employees",employeeService.findAll());

    }


    //login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model){
        return new ModelAndView("home/login");
    }

//    @RequestMapping(value = "/j_spring_security_check", method = RequestMethod.POST)
//    public



    //page admin
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(Model model, Principal principal){

//        User loginedUser =(User) ((Authentication)principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
        return new ModelAndView("home/admin");
    }
    
    //403
    @GetMapping("/403")
    public ModelAndView accessDenied() {
        return new ModelAndView("home/403");
    }
}
