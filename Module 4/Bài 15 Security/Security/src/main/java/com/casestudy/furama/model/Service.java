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

    public Service(int service_id, String service_name, int service_area, double service_cost, int service_max_people, Service_type service_type, Rent_type rent_type, String standard_room, String description_other_convenience, double pool_area, int number_of_floors, List<Contract> contracts) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.service_type = service_type;
        this.rent_type = rent_type;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
        this.contracts = contracts;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_area() {
        return service_area;
    }

    public void setService_area(int service_area) {
        this.service_area = service_area;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    public int getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(int service_max_people) {
        this.service_max_people = service_max_people;
    }

    public Service_type getService_type() {
        return service_type;
    }

    public void setService_type(Service_type service_type) {
        this.service_type = service_type;
    }

    public Rent_type getRent_type() {
        return rent_type;
    }

    public void setRent_type(Rent_type rent_type) {
        this.rent_type = rent_type;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
