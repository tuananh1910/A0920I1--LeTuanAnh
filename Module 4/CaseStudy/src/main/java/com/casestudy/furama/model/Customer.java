package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private Customer_type customer_type;

    private String customer_name;
    private String customer_birthday;
    private String customer_gender;
    private String customer_id_card;
    private String customer_phone;
    private String customer_email;
    private String customer_address;


    public Customer() {
    }
}
