package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class student  {
    @NotBlank(message = "Phone not null")
    String phone;

    public student() {
    }

    public student( String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
