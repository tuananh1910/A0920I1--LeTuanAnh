package com.example.validationinforuser.controller;

import com.example.validationinforuser.exception.DuplicateEmailException;
import com.example.validationinforuser.service.ProvinceService;
import com.example.validationinforuser.service.impl.UserServiceImpl;
import com.example.validationinforuser.model.Province;
import com.example.validationinforuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class userController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProvinceService provinceService;

//    @GetMapping("/")
//    public ModelAndView getHome(@RequestParam Optional<String> key_search, @PageableDefault(value = 2) Pageable pageable, Model model) {
//        if (!key_search.isPresent()) {
//            return new ModelAndView("user/list", "users", userService.findAllUser(pageable));
//        } else {
//            model.addAttribute("key_search", key_search.get());
//            return new ModelAndView("user/list", "users", userService.findByLast_NameContains(key_search.get(), pageable));
//        }
//    }



    @GetMapping("/")
    public ModelAndView getHome(
             Model model,
            @RequestParam(name = "page", required = false, defaultValue = "0")Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5")Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC")String sort) throws Exception {
        Sort sortable = null;
        if (sort.equals("ASC")){
            sortable = Sort.by("timeCreated").ascending();
        }
        if (sort.equals("DESC")){
            sortable= Sort.by("timeCreated").descending();
        }
        assert sortable != null;
        Pageable pageable = PageRequest.of(page,size,sortable);
//        if (!key_search.isPresent()) {
//            return new ModelAndView("user/list", "users", userService.findAllUser(pageable));
//        } else {
//            model.addAttribute("key_search", key_search.get());
//            return new ModelAndView("user/list", "users", userService.findByLast_NameContains(key_search.get(), pageable));
//        }
        return new ModelAndView("user/list", "users", userService.findAllUser(pageable));
    }


    @GetMapping("/create-user")
    public ModelAndView getCreate() {
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("user/create");
        }

        user.setTimeCreated(java.time.LocalDate.now());


        try {
            userService.save(user);
        }catch (DuplicateEmailException e){
            return new ModelAndView("error");
        }
        return new ModelAndView("user/result");
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(Pageable pageable) {
        return provinceService.findAll(pageable);
    }



    @GetMapping("/edit-user/{id}")
    public ModelAndView getEdit(@PathVariable(value = "id") int id) {
        return new ModelAndView("user/edit", "user", userService.findUserById(id));
    }

    @PostMapping("/update-user")
    public String updateUser(User user) {
        try {
            userService.save(user);
        }catch (DuplicateEmailException e){
            return "error";
        }

        return "redirect:/";
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        userService.removeById(id);
        return "redirect:/";
    }


    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showError(){
        return new ModelAndView("error");
    }
}
