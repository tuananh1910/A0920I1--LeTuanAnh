package CaseStudy.Refesh.Models;



public class Customer {
    private String name;
    private String date;
    private String gender;
    private String indentity_Card;
    private int phone_Number;
    private String email;
    private String type_Customer;
    private String address;
    private String use_Service;


    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIndentity_Card() {
        return indentity_Card;
    }

    public void setIndentity_Card(String indentity_Card) {
        this.indentity_Card = indentity_Card;
    }

    public int getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType_Customer() {
        return type_Customer;
    }

    public void setType_Customer(String type_Customer) {
        this.type_Customer = type_Customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUse_Service() {
        return use_Service;
    }

    public void setUse_Service(String use_Service) {
        this.use_Service = use_Service;
    }
    // constructor
    public Customer(String name, String date, String gender,
                    String indentity_Card, int phone_Number, String email,
                    String type_Customer, String address, String services) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.indentity_Card = indentity_Card;
        this.phone_Number = phone_Number;
        this.email = email;
        this.type_Customer = type_Customer;
        this.address = address;
        this.use_Service = services;
    }
    public String showInfor(int index){
        return  "Information Customer : \n"+ (index+1)+
                ". Name : " + this.getName()+ "\n" +
                "Date : " + this.getDate()+ "\n"+
                "Gender : "+this.getGender()+"\n"+
                "Identity Card : "+ this.getIndentity_Card()+"\n"+
                "Phone number : "+this.getPhone_Number()+"\n"+
                "Email : "+this.getEmail()+"\n"+
                "Type customer : "+this.getType_Customer()+"\n"+
                "Address : "+ this.getAddress()+"\n"+
                "Service : "+ (this.getUse_Service());
    }

    @Override
    public String toString() {
        return this.getName()+","+
                this.getDate()+","+
                this.getGender()+","+
                this.getIndentity_Card()+","+
                this.getPhone_Number()+","+
                this.getEmail()+","+
                this.getType_Customer()+","+
                this.getAddress()+","+
                this.getUse_Service();
    }
}
