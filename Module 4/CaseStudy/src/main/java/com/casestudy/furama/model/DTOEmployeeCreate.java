package com.casestudy.furama.model;

public class DTOEmployeeCreate {
    private String employee_name;
    private String employee_birthday;
    private String employee_id_card;
    private double employee_salary;
    private String employee_phone;
    private String employee_email;
    private String employee_address;
    private Position position_id;
    private Education_Degree education_degree_id;
    private Division division_id;
    private User username;
    private String password;
    private int role_id;

    public DTOEmployeeCreate() {
    }

    public DTOEmployeeCreate(String employee_name, String employee_birthday, String employee_id_card, double employee_salary, String employee_phone, String employee_email, String employee_address, Position position_id, Education_Degree education_degree_id, Division division_id, User username, String password, int role_id) {
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
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

    public Position getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Position position_id) {
        this.position_id = position_id;
    }

    public Education_Degree getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(Education_Degree education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public Division getDivision_id() {
        return division_id;
    }

    public void setDivision_id(Division division_id) {
        this.division_id = division_id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
