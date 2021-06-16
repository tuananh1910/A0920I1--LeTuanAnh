package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rent_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rent_type_id;

    private String rent_type_name;
    private double rent_type_cost;

    @OneToMany(targetEntity = Service.class)
    private List<Service> services;

    public Rent_type() {
    }
}
