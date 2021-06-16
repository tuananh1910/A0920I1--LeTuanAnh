package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_type_id;

    private String customer_type_name;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public Customer_type() {
    }
}
