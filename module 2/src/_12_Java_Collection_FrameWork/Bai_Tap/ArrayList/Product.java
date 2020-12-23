package _12_Java_Collection_FrameWork.Bai_Tap.ArrayList;

public class Product {
    private int id;
    private String nameProduct;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(int id, String nameProduct, double price) {
        this.id= id;
        this.nameProduct=nameProduct;
        this.price=price;
    }
    public Product(){}
    public String toString(){
        return "ID : "+ id + " Name Product :"+ nameProduct+
                " Price : " + price;
    }
}

