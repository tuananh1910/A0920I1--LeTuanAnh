package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_type_id;

    private String service_type_name;

    @OneToMany(targetEntity = Service.class)
    private List<Service> services;

    public Service_type() {
    }
}
