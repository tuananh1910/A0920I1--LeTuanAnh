package CaseStudy.Refesh.Models;

public class House extends Services{
    private String standard_Room;
    private String description;
    private int number_Of_Floors;

    public House(String codeServices, String name_Service,
                 double areaUse, double price,
                 double max_Number_Of_People,
                 String rental_Type, String standard_Room,
                 String description, int number_Of_Floors) {
        super(codeServices, name_Service, areaUse, price, max_Number_Of_People, rental_Type);
        this.standard_Room = standard_Room;
        this.description = description;
        this.number_Of_Floors = number_Of_Floors;
    }

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

    public int getNumber_Of_Floors() {
        return number_Of_Floors;
    }

    public void setNumber_Of_Floors(int number_Of_Floors) {
        this.number_Of_Floors = number_Of_Floors;
    }

    @Override
    public String showInfor() {
        return "House : \n"+
                "Code Service : " + super.getCodeServices()+"\n"+
                "Name Service : "+this.getName_Service()+"\n"+
                "Area Use : "+ this.getAreaUse()+"\n"+
                "Price : "+this.getPrice()+"\n" +
                "Max Number Of People : "+this.getMax_Number_Of_People()+"\n"+
                "Rental Type : "+this.getRental_Type() +"\n"+
                "Standard Room : "+this.getStandard_Room()+"\n"+
                "Description : "+this.getDescription()+"\n" +
                "Number Of Floors"+this.getNumber_Of_Floors()+"\n";
    }
}
