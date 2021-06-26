package com.casestudy.furama.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Size(min = 1, max = 45)
    private String employee_name;

    @NotNull
    private String employee_birthday;

    @Size(min = 6, max = 12)
    private String employee_id_card;

    @NotNull
    private double employee_salary;

    @Size(min = 8, max = 10)
    private String employee_phone;

    @Email(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")
    private String employee_email;
    private String employee_address;

    @ManyToOne
    @JoinColumn(name = "position_id", updatable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", updatable = false)
    private Education_Degree education_degree;

    @ManyToOne
    @JoinColumn(name = "division_id", updatable = false)
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username", updatable = false)
    private User user;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;

    public Employee(){
    }

    public Employee(int employee_id, @NotEmpty @Size(min = 1, max = 45) String employee_name, @NotEmpty String employee_birthday, @NotEmpty @Size(min = 6, max = 12) String employee_id_card, @NotEmpty double employee_salary, @NotEmpty @Size(min = 8, max = 10) String employee_phone, @Email(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$") String employee_email, String employee_address, Position position, Education_Degree education_degree, Division division, User user) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.position = position;
        this.education_degree = education_degree;
        this.division = division;
        this.user = user;
    }

    public Employee(int employee_id, @Size(min = 1, max = 45) String employee_name, @NotNull String employee_birthday, @Size(min = 6, max = 12) String employee_id_card, @NotNull double employee_salary, @Size(min = 8, max = 10) String employee_phone, @Email(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$") String employee_email, String employee_address, Position position, Education_Degree education_degree, Division division, User user, List<Contract> contracts) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.position = position;
        this.education_degree = education_degree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(String employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education_Degree getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(Education_Degree education_degree) {
        this.education_degree = education_degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
