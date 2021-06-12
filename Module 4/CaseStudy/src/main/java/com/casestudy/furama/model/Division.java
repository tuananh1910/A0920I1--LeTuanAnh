package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int division_id;

    private String division_name;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Division() {
    }
}
