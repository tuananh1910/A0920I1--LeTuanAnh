package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Entity
public class Customer {
    // implement Validator
    private static final String ID_REGEX = "KH-\\d{4}";
    private static final String PHONE_REGEX = "090\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}|\\(84\\)\\+90\\d{7}";
    private static final String ID_CARD_REGEX = "\\d{9}|\\d{12}";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String NUMBER_REGEX = "^[1-9]\\d*$";
    private static final String NUMBER_DECIMAL = "^(\\d*\\.)?\\d+$";
    private static final String BIRTHDAY_REGEX = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    @Id
    String id;
    @ManyToOne(targetEntity = CustomerType.class)
    CustomerType customerType;
    String name;
    Date birthday;
    @Column(name = "idCard")
    String idCard;
    String phone;
    String gender;
    String email;
    String address;

    public Customer() {
    }

    public Customer(String id, CustomerType customerType, String name, Date birthday, String idCard, String phone, String email, String address, String gender) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String id_card) {
        this.idCard = id_card;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Customer.class.isAssignableFrom(clazz);
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//        Customer customer = (Customer) target;
//        String id = customer.getId();
//        String phone = customer.getPhone();
//        String idCard = customer.getIdCard();
//        String email = customer.getEmail();
//        String birthday = new SimpleDateFormat().format(customer.getBirthday());
//
//
//        if (!phone.matches(PHONE_REGEX)) {
//            errors.rejectValue("phone", "phone.form");
//        }
//        if (!idCard.matches(ID_CARD_REGEX)) {
//            errors.rejectValue("id_card", "idCard.form");
//        }
//        if (!email.matches(EMAIL_REGEX)) {
//            errors.rejectValue("email", "email.form");
//        }
//        if (!id.matches(ID_REGEX)) {
//            errors.rejectValue("id", "id.form");
//        }
//        System.out.println("birthday: " + birthday);
//        if (!birthday.matches(BIRTHDAY_REGEX)) {
//            errors.rejectValue("birthday", "day.form");
//        }
//    }
}
