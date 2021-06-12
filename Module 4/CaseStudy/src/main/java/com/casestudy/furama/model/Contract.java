package com.casestudy.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_id;

    private String contract_start_date;
    private String contract_end_date;
    private double contract_deposit;
    private double contract_total_money;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    private String customer_id;
    private String service_id;

    @OneToMany(targetEntity = Contract_details.class)
    private List<Contract_details> contract_details;



    public Contract() {
    }
}
