package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
//@SessionAttributes("cart")
public class productController {
    @Autowired
    ProductService productService;

//    @ModelAttribute("cart")
//    public Cart setUpUserForm(){
//        return new Cart();
//    }

    @GetMapping("/")
    public ModelAndView getHome(Model model,
                                @RequestParam(name = "page", required = false, defaultValue = "0")Integer page,
                                @RequestParam(name = "size", required = false, defaultValue = "5")Integer size,
                                @RequestParam(name = "sort", required = false, defaultValue = "ASC")String sort){
        Sort sortable = null;
        if (sort.equals("ASC")){
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")){
            sortable= Sort.by("id").descending();
        }
        assert sortable != null;
        Pageable pageable = PageRequest.of(page,size,sortable);

        return new ModelAndView("product/list","products",productService.findAll(pageable));
    }

    @GetMapping("/view/{id}")
    public ModelAndView getViewProduct(@PathVariable(value = "id")int id){
        return new ModelAndView("product/view","product",productService.findById(id));
    }

}
