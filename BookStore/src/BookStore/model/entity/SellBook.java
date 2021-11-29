package BookStore.model.entity;

import java.time.LocalDateTime;

public class SellBook {
    private Long id;

    // ManyToMany
    private Book book;

    // OneToOne
    private Payment payment;

    //ManyToOne
    private Account account;

    private LocalDateTime orderDate;
    private String receivingAddress;

    // constructor
    public SellBook() {
    }

    public SellBook(Long id, Book book, Payment payment, Account account, LocalDateTime orderDate, String receivingAddress) {
        this.id = id;
        this.book = book;
        this.payment = payment;
        this.account = account;
        this.orderDate = orderDate;
        this.receivingAddress = receivingAddress;
    }

    // getter setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }
}
