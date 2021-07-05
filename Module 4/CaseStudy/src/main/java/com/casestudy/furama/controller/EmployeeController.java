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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
//        model.addAttribute("user", new User());
        model.addAttribute("userRole", new User_role());
        return new ModelAndView("employee/create", "employee", new DTOEmployeeCreate());
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

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee createEmployee(
            @RequestBody DTOEmployeeCreate employee) {
        System.out.println("create");

        User user = new User(employee.getUsername().getUsername(),employee.getPassword());
        userService.save(user);

        User_role user_role = new User_role(employee.getRole_id(),employee.getUsername().getUsername());
        userRoleService.save(user_role);


        Employee employee1 = new Employee(employee.getEmployee_name(),employee.getEmployee_birthday(),employee.getEmployee_id_card()
        ,employee.getEmployee_salary(),employee.getEmployee_phone(),employee.getEmployee_email(),employee.getEmployee_address()
        ,employee.getPosition_id(),employee.getEducation_degree_id(),employee.getDivision_id(),employee.getUsername());

        return employeeService.save(employee1);
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

        userRoleService.remove(employee.getUser().getUsername());
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
