package com.casestudy.furama.controller;

import com.casestudy.furama.model.*;
import com.casestudy.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/furama-employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private RoleService roleService;


    @ModelAttribute("positions")
    public List<Position> positions(){
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public List<Education_Degree> education_degrees(){
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public List<Division> divisions(){
        return divisionService.findAll();
    }

    @ModelAttribute("roles")
    public List<Role> roles(){
        return roleService.findAll();
    }

    //employee
    @GetMapping("/employee-list")
    public ModelAndView listEmployee() {
        return new ModelAndView("employee/list", "employees", employeeService.findAll());
    }

    @GetMapping("/create-new-employee")
    public ModelAndView createEmployeePage(Model model){
//        model.addAttribute("user", new User());
        model.addAttribute("userRole", new User_role());
        return new ModelAndView("employee/create","employee",new Employee());
    }

//    @PostMapping(value = "/addNewEmployee")
//    public ModelAndView createEmployee(
//            @ModelAttribute("userRole") User_role user_role,
//            @Validated @ModelAttribute("employee") Employee employee, BindingResult result){
//
//        if (result.hasFieldErrors()){
//            return new ModelAndView("employee/create","employee", new Employee());
//        }
//        User user = new User(employee.getUser().getUsername(),employee.getUser().getPassword());
//        userService.save(user);
//        userRoleService.save(new User_role(user_role.getRole_id(),user.getUsername()));
//        employeeService.save(employee);
//        return new ModelAndView("employee/list","employees",employeeService.findAll());
//
//    }

    @PostMapping(value = "/addNewEmployee",
    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee createEmployee(
            @RequestBody List<Object> json){


        System.out.println("create");
        User user = (User) json.get(2);
        userService.save(user);

        User_role user_role = (User_role)json.get(1);
        userRoleService.save(new User_role(user_role.getRole_id(),user.getUsername()));
//

        Employee employee = (Employee)json.get(0);
        return  employeeService.save(employee);
    }
}
