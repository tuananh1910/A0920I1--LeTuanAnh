package com.casestudy.furama.service;

import com.casestudy.furama.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee remove(int id);
}
