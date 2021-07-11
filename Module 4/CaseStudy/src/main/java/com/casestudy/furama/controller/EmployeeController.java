package com.casestudy.furama.controller;

import com.casestudy.furama.model.*;
import com.casestudy.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@RestController
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

    @Autowired
    private RoleService roleService;


    @ModelAttribute("positions")
    public List<Position> positions() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public List<Education_Degree> education_degrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public List<Division> divisions() {
        return divisionService.findAll();
    }

    @ModelAttribute("roles")
    public List<Role> roles() {
        return roleService.findAll();
    }

    //employee
    @GetMapping("/employee-list")
    public ModelAndView listEmployee() {
        return new ModelAndView("employee/list", "employees", employeeService.findAll());
    }


    @GetMapping("/create-new-employee")
    public ModelAndView createEmployeePage(Model model) {
        model.addAttribute("role", new Role());
        return new ModelAndView("employee/create", "employee", new Employee());
    }

    @PostMapping(value = "/addNewEmployee")
    public ModelAndView createEmployee(
            @Valid @ModelAttribute("employee") Employee employee, BindingResult result){

        System.out.println("Create");

        new Employee().validate(employee,result);

        if (result.hasFieldErrors()){
            System.out.println("Validate error");
            return new ModelAndView("employee/create","employee", new Employee());
        }

        Role role = new Role("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        System.out.println("User");
        User user = new User(employee.getUser().getUsername(),employee.getUser().getPassword(),roleSet);

        System.out.println("Save user");

        try {
            userService.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Saved user");


        Employee employee1 =  new Employee(
                employee.getEmployee_name(),
                employee.getEmployee_birthday(),
                employee.getEmployee_id_card(),
                employee.getEmployee_salary(),
                employee.getEmployee_phone(),
                employee.getEmployee_email(),
                employee.getEmployee_address(),
                employee.getPosition()
        ,employee.getEducation_degree(),employee.getDivision(),employee.getUser());

        System.out.println("Save employee");
        employeeService.save(employee1);
        System.out.println("Saved employee");


        return new ModelAndView("employee/list","employees",employeeService.findAll());

    }


//    ------------------------------------


//    ------------------------------------

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee deleteSmartphone(@PathVariable int id) {
        System.out.println("Delete");


        Employee employee = employeeService.findById(id);

//        userRoleService.remove(employee.getUser().getUsername());
        employeeService.remove(id);
        userService.remove(employee.getUser().getUsername());

        return employee;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editEmployeeForm(@PathVariable int id) {
        return new ModelAndView("employee/edit", "employee", employeeService.findById(id));
    }


    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee employee) {

        System.out.println("update");

        return employeeService.save(employee);
    }

}
