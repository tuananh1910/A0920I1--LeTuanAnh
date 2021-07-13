package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/furama-employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private DivisionService divisionService;

    @ModelAttribute("positions")
    public List<Position> positions() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public List<EducationDegree> education_degrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public List<Division> divisions() {
        return divisionService.findAll();
    }

    //employee
    @GetMapping("/employee-list")
    public ModelAndView listEmployee() {
        return new ModelAndView("employee/list", "employees", employeeService.findAll());
    }


    @GetMapping("/create-new-employee")
    public ModelAndView createEmployeePage(Model model) {
//        model.addAttribute("role", new Role());
        return new ModelAndView("employee/create", "employee", new Employee());
    }

    @PostMapping("/addNewEmployee")
    public String addNewEmployee(
            @Validated Employee employee, BindingResult result, Model model){
        new Employee().validate(employee,result);



        if (result.hasFieldErrors()){
//            return new ModelAndView("employee/create", "employee", new Employee());

        model.addAttribute("employee", new Employee());
        return "/employee/create";
        }
        else {

            Role role = new Role("ROLE_USER");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);

            User user = new User(employee.getUser().getUsername(),employee.getUser().getPassword(),roleSet);

            userService.save(user);

            employeeService.save(employee);
//            return new ModelAndView("employee/list","employees",employeeService.findAll());
            return "redirect:/furama-employee/employee-list";
        }
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editEmployeeForm(@PathVariable int id) {
        return new ModelAndView("employee/edit", "employee", employeeService.findById(id));
    }

    @PostMapping(value = "/update")
    public Employee updateEmployee(Employee employee) {
        System.out.println("update");
        return employeeService.save(employee);
    }
}
