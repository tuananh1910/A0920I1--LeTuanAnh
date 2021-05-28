package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView getHome(@RequestParam Optional<String> key_search, @PageableDefault(value = 2)Pageable pageable, Model model){
        if (!key_search.isPresent()){
            System.out.println("all list");
            return new ModelAndView("list","blogs",blogService.findAllBlog(pageable));
        }else {
            System.out.println("keysr:"+key_search.get());
            model.addAttribute("key_search", key_search.get());
            return new ModelAndView("list","blogs", blogService.findByNameContains(key_search.get(),pageable));
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable(value = "id") int id){
        return new ModelAndView("edit","blog",blogService.findBlogById(id));
    }

    @PostMapping("/update")
    public String Update (Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable(value = "id")int id){
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView getCreate(){
        System.out.println("create");
        return new ModelAndView("create","blog",new Blog());
    }

    @PostMapping("/save")
    public String add(Blog blog){
        System.out.println("save");
        blogService.save(blog);
        return "redirect:/";
    }

}
