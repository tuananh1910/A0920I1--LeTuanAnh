package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class emailController {
    @RequestMapping(value = "/login")
    public String login1() {
        return "email/login";
    }
}
