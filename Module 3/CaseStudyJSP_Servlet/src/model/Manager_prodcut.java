package model;

public class Manager_prodcut {
    private int manager_product_id;
     private String product_name;
     private double product_price;
     private int product_discount;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(int product_discount) {
        this.product_discount = product_discount;
    }

    public Manager_prodcut(){};
    public Manager_prodcut(int manager_product_id, String product_name, double product_price, int product_discount) {
        this.manager_product_id = manager_product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
    }
    public Manager_prodcut(String product_name, double product_price, int product_discount) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
    }
}
