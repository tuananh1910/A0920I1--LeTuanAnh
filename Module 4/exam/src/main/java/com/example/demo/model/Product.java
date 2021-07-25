package com.example.demo.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Product implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is not blank")
    @Size(min = 5, max = 50, message = "Ten san pham phai tu 5 - 50 ki tu")
    private String name;

//    @NotBlank(message = "Price is not blank")
//    @Range(min = 100000, message = "Gia thap nhat la 100.000VND")
    private double price;

    @ManyToOne(targetEntity = ProductType.class)
    private ProductType productType;

    private String status;



    public Product() {
    }

    public Product(int id, String name, double price, ProductType productType, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product= (Product) target;
        double price = product.getPrice();

        if (price<100000){
            errors.rejectValue("price", "price.form");
        }
    }
}
