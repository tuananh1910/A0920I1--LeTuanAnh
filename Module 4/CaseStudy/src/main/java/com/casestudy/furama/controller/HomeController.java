package com.casestudy.furama.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHome(){
        return new ModelAndView("home/home");
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
