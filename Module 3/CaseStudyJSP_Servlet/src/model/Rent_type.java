package model;

public class Rent_type {
    private int rent_type;
    private String rent_type_name;
    private double rent_type_cost;

    public Rent_type(int rent_type, String rent_type_name, double rent_type_cost) {
        this.rent_type = rent_type;
        this.rent_type_name = rent_type_name;
        this.rent_type_cost = rent_type_cost;
    }
    public Rent_type(){}

    public int getRent_type() {
        return rent_type;
    }

    public void setRent_type(int rent_type) {
        this.rent_type = rent_type;
    }

    public String getRent_type_name() {
        return rent_type_name;
    }

    public void setRent_type_name(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }

    public double getRent_type_cost() {
        return rent_type_cost;
    }

    public void setRent_type_cost(double rent_type_cost) {
        this.rent_type_cost = rent_type_cost;
    }
}
