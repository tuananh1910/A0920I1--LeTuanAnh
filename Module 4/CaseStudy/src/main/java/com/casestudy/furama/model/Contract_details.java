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

    public Contract_details(int contract_details_id, Contract contract, Attach_service attach_service, int quality) {
        this.contract_details_id = contract_details_id;
        this.contract = contract;
        this.attach_service = attach_service;
        this.quality = quality;
    }

    public int getContract_details_id() {
        return contract_details_id;
    }

    public void setContract_details_id(int contract_details_id) {
        this.contract_details_id = contract_details_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Attach_service getAttach_service() {
        return attach_service;
    }

    public void setAttach_service(Attach_service attach_service) {
        this.attach_service = attach_service;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
