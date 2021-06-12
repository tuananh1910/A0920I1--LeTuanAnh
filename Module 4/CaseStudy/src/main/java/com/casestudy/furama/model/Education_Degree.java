package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Education_Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int education_degree_id;

    private String education_degree_name;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;


    public Education_Degree() {
    }

    public Education_Degree(int education_degree_id, String education_degree_name, List<Employee> employees) {
        this.education_degree_id = education_degree_id;
        this.education_degree_name = education_degree_name;
        this.employees = employees;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public String getEducation_degree_name() {
        return education_degree_name;
    }

    public void setEducation_degree_name(String education_degree_name) {
        this.education_degree_name = education_degree_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
