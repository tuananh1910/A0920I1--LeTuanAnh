package com.example.borrowbook.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private int amount;
    private int remainAmount;

    @OneToMany(targetEntity = RentBook.class)
    private List<RentBook> rentBook;

    public List<RentBook> getRentBook() {
        return rentBook;
    }

    public void setRentBook(List<RentBook> rentBook) {
        this.rentBook = rentBook;
    }

    public Book(long id, String title, int amount, int remainAmount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.remainAmount = remainAmount;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(int remainAmount) {
        this.remainAmount = remainAmount;
    }
}
