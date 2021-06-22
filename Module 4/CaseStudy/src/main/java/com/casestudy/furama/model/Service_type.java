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

    public Service_type(int service_type_id, String service_type_name, List<Service> services) {
        this.service_type_id = service_type_id;
        this.service_type_name = service_type_name;
        this.services = services;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getService_type_name() {
        return service_type_name;
    }

    public void setService_type_name(String service_type_name) {
        this.service_type_name = service_type_name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
