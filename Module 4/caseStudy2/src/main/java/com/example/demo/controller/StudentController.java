package com.example.demo.controller;

import com.example.demo.model.student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    @GetMapping("/student/create")
    public String create(Model model){
        model.addAttribute("student", new student());
        return "student/create";
    }

    @PostMapping("/student/save")
    public String save(
            @Valid @ModelAttribute("student") student student,
            BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
//            model.addAttribute("student", new student());
            return "/student/create";
        }else {
            System.out.println("OK");
            return "redirect:/";
        }
    }
}
