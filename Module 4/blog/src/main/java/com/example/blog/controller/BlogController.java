package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

//    @ResponseBody
//    public String welcome(){
//        return "list";
//    }
    // find all blog
   @GetMapping("")
    public ModelAndView getHome(
            @RequestParam Optional<String> key_search,
            @PageableDefault(value = 2)Pageable pageable,
            Model model){
        if (!key_search.isPresent()){
            System.out.println("all list");
            return new ModelAndView("list","blogs",blogService.findAllBlog(pageable));
        }else {
            System.out.println("key search:"+key_search.get());
            model.addAttribute("key_search", key_search.get());
            return new ModelAndView("list","blogs", blogService.findByNameContains(key_search.get(),pageable));
        }
    }

//    @RequestMapping(value = "/blogs", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE
//            , MediaType.APPLICATION_ATOM_XML_VALUE})
////    @ResponseBody
//    public Page<Blog> getHome(@RequestParam Optional<String> key_search, @PageableDefault(value = 5)Pageable pageable, Model model){
//        if (!key_search.isPresent()){
//            System.out.println("all list");
//            return (Page<Blog>) model.addAttribute("blogs",blogService.findAllBlog(pageable));
//        }else {
//            System.out.println("key search:"+key_search.get());
//            model.addAttribute("key_search", key_search.get());
//            return (Page<Blog>) model.addAttribute("blogs",blogService.findByNameContains(key_search.get(),pageable));
//        }
//    }

    //findByID

//    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE })
//    public Blog getBlog(@PathVariable("id")int id){
//        return blogService.findBlogById(id);
//    }


    // create
    // target form create
    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        return new ModelAndView("create","blog",new Blog());
    }

    @RequestMapping(value = "/blogs", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Blog addBlog(@RequestBody Blog blog) {
        System.out.println("(Service Side) Creating blog: " + blog.getName());
        return blogService.save(blog);
    }

    // target form edit
    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable(value = "id") int id){
        return new ModelAndView("edit","blog",blogService.findBlogById(id));
    }
    //update
    @RequestMapping(value = "/edit/{id}",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }
                    )
    public Blog updateBlog(@PathVariable int id, @RequestBody Blog blog) {
        System.out.println("(Service Side) Editing Blog: " + blog.getName());
        blog.setId(id);
        return blogService.save(blog);
    }

    //delete
    @RequestMapping(value = "/delete/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Blog deleteBlog(@PathVariable("id") int id) {
        System.out.println("(Service Side) Deleting blog: " + id);
        return blogService.delete(id);
    }




//    @PostMapping("/update")
//    public String Update (Blog blog){
//        blogService.save(blog);
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String getDelete(@PathVariable(value = "id")int id){
//        blogService.delete(id);
//        return "redirect:/";
//    }
//

//
//    @PostMapping("/save")
//    public String add(Blog blog){
//        System.out.println("save");
//        blogService.save(blog);
//        return "redirect:/";
//    }

}
