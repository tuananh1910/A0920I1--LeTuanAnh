package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServie;
import com.example.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductServie productServie;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/product/list")
    public String showList(Model model) {
        model.addAttribute("products", productServie.findAllProduct());
        return "product/list";
    }

    @GetMapping("product/create-new")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productTypeService.findAllProductType());
        return "product/create";
    }

    @PostMapping("product/save")
    public String addProduct(@Validated Product product, BindingResult bindingResult, Model model) {
        double price = product.getPrice();
        product.setPrice(price);
        new Product().validate(product, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("productTypes", productTypeService.findAllProductType());
            return "/product/create";
        } else {
            product.setStatus("Đang chờ duyệt");
            productServie.saveProduct(product);
            return "redirect:/product/list";
        }

    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productServie.findProductById(id));
        model.addAttribute("productTypes", productTypeService.findAllProductType());
        return "product/edit";
    }

    @PostMapping("/product/update")
    public String updateProduct(@Validated Product product, BindingResult bindingResult, Model model) {
        double price = product.getPrice();
        product.setPrice(price);
        new Product().validate(product, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("productTypes", productTypeService.findAllProductType());
            return "/product/edit";
        } else {
            productServie.saveProduct(product);
            return "redirect:/product/list";
        }

    }

    @PostMapping("/customer/deleteAllById")
    public String deleteAllById(@RequestParam(value = "checkBoxId") List<Integer> checkBoxId){
        System.out.println(checkBoxId.size());

        for (int i = 0; i<checkBoxId.size();i++){
            productServie.deleteProductById(checkBoxId.get(i));
        }
        return "redirect:/product/list";
    }

}
