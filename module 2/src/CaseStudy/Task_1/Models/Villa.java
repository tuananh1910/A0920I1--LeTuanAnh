package CaseStudy.Task_1.Models;

public class Villa extends Services{
    private String standard_Room;
    private String description;
    private double pool_Area;
    private int number_Of_Floors;
    // constructor

    public Villa(String name_Service, double areaUse,
                 double price, double max_Number_Of_People, String rental_Type,
                 String standard_Room, String description, double pool_Area,
                 int number_Of_Floors) {
        super(name_Service, areaUse, price, max_Number_Of_People, rental_Type);
        this.standard_Room = standard_Room;
        this.description = description;
        this.pool_Area = pool_Area;
        this.number_Of_Floors = number_Of_Floors;
    }
    //getter setter
    public String getStandard_Room() {
        return standard_Room;
    }
    public void setStandard_Room(String standard_Room) {
        this.standard_Room = standard_Room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPool_Area() {
        return pool_Area;
    }

    public void setPool_Area(double pool_Area) {
        this.pool_Area = pool_Area;
    }

    public int getNumber_Of_Floors() {
        return number_Of_Floors;
    }

    public void setNumber_Of_Floors(int number_Of_Floors) {
        this.number_Of_Floors = number_Of_Floors;
    }

    @Override
    public String showInfor() {
        System.out.println("Villas : \n");
        return "Name Service : "+this.getName_Service()+"\n"+
                "Area Use : "+ this.getAreaUse()+"\n"+
                "Price : "+this.getPrice()+"\n" +
                "Max Number Of People : "+this.getMax_Number_Of_People()+"\n"+
                "Rental Type : "+this.getRental_Type() +"\n"+
                "Standard Room : "+this.getStandard_Room()+"\n"+
                "Description : "+this.getDescription()+"\n" +
                "Pool Area : "+this.getPool_Area()+"\n"+
                "Number Of Floors"+this.getNumber_Of_Floors();
    }
}
