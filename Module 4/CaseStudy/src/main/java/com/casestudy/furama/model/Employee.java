package com.casestudy.furama.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

import java.util.List;

@Entity
public class Employee implements Validator {
    private static final String BIRTHDAY_REGEX="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    private static final String ID_CARD_REGEX="\\d{9}|\\d{12}";
    private static final String PHONE_REGEX="090\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}|\\(84\\)\\+90\\d{7}";
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    private String employee_name;

    private String employee_birthday;

    private String employee_id_card;

    private double employee_salary;

    private String employee_phone;

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

    public Employee( String employee_name, String employee_birthday, String employee_id_card, double employee_salary, String employee_phone, String employee_email, String employee_address, Position position, Education_Degree education_degree, Division division, User user) {

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

    public Employee(int employee_id, String employee_name, String employee_birthday, String employee_id_card, double employee_salary, String employee_phone, String employee_email, String employee_address, Position position, Education_Degree education_degree, Division division, User user, List<Contract> contracts) {
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


    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        String phone = employee.getEmployee_phone();
        String idCard = employee.getEmployee_id_card();
        String email = employee.getEmployee_email();
        String birthday = employee.getEmployee_birthday();

        if(!phone.matches(PHONE_REGEX)){
            errors.rejectValue("employee_phone","employee_phone.form");
        }
        if(!idCard.matches(ID_CARD_REGEX)){
            errors.rejectValue("employee_id_card","employee_id_card.form");
        }
        if(!email.matches(EMAIL_REGEX)){
            errors.rejectValue("employee_email","employee_email.form");
        }
        if(!birthday.matches(BIRTHDAY_REGEX)){
            errors.rejectValue("employee_birthday","employee_birthday.form");
        }

    }
}
