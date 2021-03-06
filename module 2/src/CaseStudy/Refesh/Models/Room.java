package CaseStudy.Refesh.Models;

public class Room extends Services {
    private String service_Free;

    public Room(String codeServices, String name_Service,
                double areaUse, double price,
                double max_Number_Of_People, String rental_Type,
                String service_Free) {
        super(codeServices, name_Service, areaUse, price, max_Number_Of_People, rental_Type);
        this.service_Free = service_Free;
    }

    public Room(String codeServices, String name_Service, double areaUse,
                double price, double max_Number_Of_People,
                String rental_Type) {
        super(codeServices, name_Service, areaUse, price, max_Number_Of_People, rental_Type);
    }

    public String getService_Free() {
        return service_Free;
    }

    public void setService_Free(String service_Free) {
        this.service_Free = service_Free;
    }

    @Override
    public String showInfor() {
        return "Rooms : \n"+
                "Code Service : " + super.getCodeServices()+"\n"+
                "Name Service : "+this.getName_Service()+"\n"+
                "Area Use : "+ this.getAreaUse()+"\n"+
                "Price : "+this.getPrice()+"\n" +
                "Max Number Of People : "+this.getMax_Number_Of_People()+"\n"+
                "Rental Type : "+this.getRental_Type() +"\n"+
                "Free For Service : "+this.getService_Free()+"\n";
    }
    @Override
    public String toString() {
        return super.getCodeServices() + "," +
                super.getName_Service() + "," +
                super.getAreaUse() + "," +
                super.getPrice() + "," +
                super.getMax_Number_Of_People() + "," +
                super.getRental_Type() + "," +
                this.getService_Free() ;
    }
}
