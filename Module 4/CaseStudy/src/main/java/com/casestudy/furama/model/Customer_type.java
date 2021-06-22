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

    public Customer_type(int customer_type_id, String customer_type_name, List<Customer> customers) {
        this.customer_type_id = customer_type_id;
        this.customer_type_name = customer_type_name;
        this.customers = customers;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_type_name() {
        return customer_type_name;
    }

    public void setCustomer_type_name(String customer_type_name) {
        this.customer_type_name = customer_type_name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
