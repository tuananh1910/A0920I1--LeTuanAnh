package com.tuananh.Sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sandwichController {
    @GetMapping("/sandwich")
    public String getSandwichCodiments(ModelMap model,
        @RequestParam(name = "condiments" ,required = false,
                defaultValue = "-----") String condiments){
        System.out.println(condiments);
        model.addAttribute("condiment",condiments);
        return "index";
    }
}
