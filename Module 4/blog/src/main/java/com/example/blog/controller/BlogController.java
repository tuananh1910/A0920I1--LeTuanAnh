package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

//    @ResponseBody
//    public String welcome(){
//        return "list";
//    }
    // find all blog
    @RequestMapping(value = "/blogs",method = RequestMethod.GET)
    public ModelAndView getHome(
            @RequestParam Optional<String> key_search,
            @PageableDefault(value = 2)Pageable pageable, Model model,
            @RequestParam(value = "lang", required = false) String lang){
        if (lang == null) {
            lang = "en";
        }
        model.addAttribute("lang", lang);
        if (!key_search.isPresent()){
            System.out.println("all list");
            return new ModelAndView("list","blogs",blogService.findAllBlog(pageable));
        }else {
            System.out.println("key search:"+key_search.get());
            model.addAttribute("key_search", key_search.get());
            return new ModelAndView("list","blogs", blogService.findByNameContainsPage(key_search.get(),pageable));
        }
    }

    @RequestMapping(value = "/load-more", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Blog> moreList(
            @RequestParam("key_search")String key_search,
            @PageableDefault(value = 2)Pageable pageable,
            Model model){
        if (key_search.equals("")) {
            System.out.println("all list more");
            model.addAttribute("blogs", blogService.findAllBlog(pageable));
            return blogService.findByNameContainsList(key_search);
        }else {
            System.out.println("key search:"+key_search);
            model.addAttribute("key_search", key_search);
            return blogService.findByNameContainsList(key_search);
        }
    }

    //key search
    @RequestMapping(value = "/key-search",method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
    @ResponseBody
    public List<Blog> searchBlog(
            @RequestParam("key_search") String key_search,
            Model model){
        System.out.println("test");
       model.addAttribute("key_search", key_search.getBytes());
       return blogService.findByNameContainsList(key_search);
    }

    //findByID

//    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE })
//    public Blog getBlog(@PathVariable("id")int id){
//        return blogService.findBlogById(id);
//    }


    // create
    // target form create
    @GetMapping("/blogs-create")
    public ModelAndView getCreatePage(
            @RequestParam(value = "lang", required = false) String lang,
            Model model){
        if (lang==null){
            lang="en";
        }
        model.addAttribute("lang",lang);
        return new ModelAndView("create","blog",new Blog());
    }

    @RequestMapping(value = "/create-new-blog", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Blog addBlog(@RequestBody Blog blog) {
        System.out.println("(Service Side) Creating blog: " + blog.getName());
        return blogService.save(blog);
    }

    // target form edit
    @GetMapping("/blogs-edit/{id}")
    public ModelAndView getEdit(
            @PathVariable(value = "id") int id,Model model,
            @RequestParam(value = "lang", required = false) String lang){
        if (lang==null){
            lang="en";
        }
        model.addAttribute("lang",lang);
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
    @RequestMapping(value = "/blogs-delete/{id}", //
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
