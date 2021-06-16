package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

    private String service_name;
    private int service_area;
    private double service_cost;
    private int service_max_people;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private Service_type service_type;


    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private Rent_type rent_type;

    private String standard_room;
    private String description_other_convenience;
    private double pool_area;
    private int number_of_floors;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;


    public Service() {
    }
}
