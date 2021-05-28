package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.ICustomerService;
import service.Impl.CustomerServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class customerController {

//    @Autowired
//    ICustomerService iCustomerSerivce;

    @GetMapping("/customers")
    public String showList(HttpServletRequest request){
        return "customers/list";
    }


}
