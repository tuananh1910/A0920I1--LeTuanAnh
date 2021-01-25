package CaseStudy.Task.Models;

public abstract class Services {
    private String codeServices;
    private String name_Service;
    private double areaUse;
    private double price;
    private double max_Number_Of_People;
    private String rental_Type;

    public Services(String codeServices, String name_Service, double areaUse,
                    double price, double max_Number_Of_People,
                    String rental_Type) {
        this.codeServices = codeServices;
        this.name_Service = name_Service;
        this.areaUse = areaUse;
        this.price = price;
        this.max_Number_Of_People = max_Number_Of_People;
        this.rental_Type = rental_Type;
    }

//    public Services(String name_service) {
//        this.name_Service = name_service;
//    }

    public String get_CodeService(){return codeServices;}
    public void set_CodeService(String codeServices){this.codeServices=codeServices;}

    public String getName_Service() {
        return name_Service;
    }

    public void setName_Service(String name_Service) {
        this.name_Service = name_Service;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMax_Number_Of_People() {
        return max_Number_Of_People;
    }

    public void setMax_Number_Of_People(double max_Number_Of_People) {
        this.max_Number_Of_People = max_Number_Of_People;
    }

    public String getRental_Type() {
        return rental_Type;
    }

    public void setRental_Type(String rental_Type) {
        this.rental_Type = rental_Type;
    }

    public abstract String showInfor();

}
