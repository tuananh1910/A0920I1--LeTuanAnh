package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
public class Employee implements Validator {
    private static final String PHONE_REGEX="090\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}|\\(84\\)\\+90\\d{7}";
    private static final String ID_CARD_REGEX="\\d{9}|\\d{12}";
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String BIRTHDAY_REGEX="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

    @Id
     String id;
     String name;
     Date birthDay;
     String idCard;
     int salary;
     String phone;
     String email;
     String address;
    @ManyToOne(targetEntity = Position.class)
     Position position;
    @ManyToOne(targetEntity = Division.class)
     Division division;
    @ManyToOne(targetEntity = EducationDegree.class)
     EducationDegree educationDegree;
    @ManyToOne(targetEntity = User.class)
     User user;
    public Employee() {
    }

    public Employee(String id, String name, Date birthDay, String idCard, int salary, String phone, String email, String address, Position position, Division division, EducationDegree educationDegree, User user) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.division = division;
        this.educationDegree = educationDegree;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee =(Employee) target;

        String phone = employee.getPhone();
        String idCard =  employee.getIdCard();
//        String birthDay = employee.getBirthDay();
        String email = employee.getEmail();


        if(!phone.matches(PHONE_REGEX)){
            errors.rejectValue("phone","phone.form");
        }
        if(!idCard.matches(ID_CARD_REGEX)){
            errors.rejectValue("idCard","idCard.form");
        }
        if(!email.matches(EMAIL_REGEX)){
            errors.rejectValue("email","email.form");
        }
//        if(!birthDay.matches(BIRTHDAY_REGEX)){
//            errors.rejectValue("birthDay","day.form");
//        }
    }
}
