package model;

public class Manager_order_product {
    private int manager_order_product_id;
    private String method_pay;
    private String customer_name;
    private String employee_name;
    private String date_order;
    private String date_recive;
    private String address_revice;

    public Manager_order_product() {
    }

    public Manager_order_product(int manager_order_product_id, String method_pay, String customer_name, String employee_name, String date_order, String date_recive, String address_revice) {
        this.manager_order_product_id = manager_order_product_id;
        this.method_pay = method_pay;
        this.customer_name = customer_name;
        this.employee_name = employee_name;
        this.date_order = date_order;
        this.date_recive = date_recive;
        this.address_revice = address_revice;
    }

    public int getManager_order_product_id() {
        return manager_order_product_id;
    }

    public void setManager_order_product_id(int manager_order_product_id) {
        this.manager_order_product_id = manager_order_product_id;
    }

    public String getMethod_pay() {
        return method_pay;
    }

    public void setMethod_pay(String method_pay) {
        this.method_pay = method_pay;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public String getDate_recive() {
        return date_recive;
    }

    public void setDate_recive(String date_recive) {
        this.date_recive = date_recive;
    }

    public String getAddress_revice() {
        return address_revice;
    }

    public void setAddress_revice(String address_revice) {
        this.address_revice = address_revice;
    }
}
