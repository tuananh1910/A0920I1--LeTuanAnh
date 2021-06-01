package com.example.validationinforuser.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @NotEmpty
    @Size(max = 45, min = 5)
    //cai nay la first name ma // con cua m ben repository la name?
    private String first_Name;

    @NotEmpty
    @Size(max = 45, min = 5)
    private String last_Name;

    @Min(18)
    private int age;

    @Email(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")
    private String email;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;


    //
    private LocalDate timeCreated;

    public LocalDate getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDate timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User(int ID, @NotEmpty @Size(max = 45, min = 5) String first_Name, @NotEmpty @Size(max = 45, min = 5) String last_Name, @Min(18) int age, @Email(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$") String email, Province province, LocalDate timeCreated) {
        this.ID = ID;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.age = age;
        this.email = email;
        this.province = province;
        this.timeCreated = timeCreated;
    }

    //


    public User() {
    }

    public User(int ID, @NotEmpty @Size(max = 45, min = 5) String first_Name, @NotEmpty @Size(max = 45, min = 5) String last_Name, @Min(18) int age, @Email(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$") String email, Province province) {
        this.ID = ID;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.age = age;
        this.email = email;
        this.province = province;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
