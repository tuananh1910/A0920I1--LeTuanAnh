package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
    @RequestMapping(value = "/home" )
    public String getHomePage(Model model){
        model.addAttribute("text", "Hello cac ban");
        return "home";
    }

//    @RequestMapping(value = "/")
//    public String getIndex(){
//        return "index";
//    }

    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }
}
