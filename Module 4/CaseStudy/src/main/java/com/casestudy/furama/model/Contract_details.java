package com.casestudy.furama.model;

import javax.persistence.*;

@Entity
public class Contract_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_details_id;

    @ManyToOne
    @JoinColumn(name = "contract_id" )
    private Contract contract;


    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    private Attach_service attach_service;


    private int quality;

    public Contract_details() {
    }
}
