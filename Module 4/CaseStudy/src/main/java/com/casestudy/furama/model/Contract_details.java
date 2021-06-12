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


    private int attach_service_id;
    private int quality;

    public Contract_details() {
    }
}
