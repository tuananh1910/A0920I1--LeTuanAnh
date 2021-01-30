package CaseStudy.Refesh.Controllers;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Models.Customer;
import CaseStudy.Refesh.Models.House;
import CaseStudy.Refesh.Models.Room;
import CaseStudy.Refesh.Models.Villa;

import java.util.ArrayList;

public class Get_Data {
    private static final String PATH_CUSTOMER="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Customer.csv";
    private static final String PATH_VILLA = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Villa.csv";
    private static final String PATH_ROOM ="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Room.csv" ;
    private static final String PATH_HOUSE ="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\House.csv" ;
    public static ArrayList<Customer> get_Data_Customer() {
        ArrayList<String> Customer_List = Read_Write_File.read_File(PATH_CUSTOMER);
        Customer customer;
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        for (int index = 0; index < (Customer_List.size() / 8); index++) {

            customer = new Customer(Customer_List.get(index),
                    Customer_List.get(index + 1),
                    Customer_List.get(index+2),
                    Customer_List.get(index+3),
                    Integer.parseInt(Customer_List.get(index+4)),
                    Customer_List.get(index+5),
                    Customer_List.get(index+6),
                    Customer_List.get(index+7));
            customerArrayList.add(customer);
        }

        return customerArrayList;
    }
        public static ArrayList<Villa> get_Data_Villa() {
            //get data villa
            ArrayList<String> Villa_List_String=Read_Write_File.read_File(PATH_VILLA);
            Villa villa;

            ArrayList<Villa> villaArrayList = new ArrayList<>();

            System.out.println("size: "+Villa_List_String.size()); // check bug

            for (int index = 0; index < (Villa_List_String.size() / 10); index++){ // bug ở for

                System.out.println(Villa_List_String.get(index+5)); // check bug

                villa = new Villa(Villa_List_String.get(index), Villa_List_String.get(index + 1),
                        Double.parseDouble(Villa_List_String.get(index + 2)),
                        Double.parseDouble(Villa_List_String.get(index + 3)),
                        Double.parseDouble(Villa_List_String.get(index + 4)),
                        (Villa_List_String.get(index + 5)), Villa_List_String.get(index + 6), // numberFormatException index= 5 (6)
                        Villa_List_String.get(index + 7),
                        Double.parseDouble(Villa_List_String.get(index + 8)),
                        Integer.parseInt(Villa_List_String.get(index + 9)));
                villaArrayList.add(villa);
            }return villaArrayList;
        }

        public static ArrayList<Room> get_Data_Room() {
            //get data room
            ArrayList<String> Room_List=Read_Write_File.read_File(PATH_ROOM);
            Room room;
            ArrayList<Room> roomArrayList = new ArrayList<>();
            for (int index = 0; index < (Room_List.size() / 7); index++) {
                room = new Room(Room_List.get(index), Room_List.get(index + 1),
                        Double.parseDouble(Room_List.get(index + 2)),
                        Double.parseDouble(Room_List.get(index + 3)),
                       Double.parseDouble(Room_List.get(index + 4)),
                        Room_List.get(index + 5), Room_List.get(index + 6));
                roomArrayList.add(room);
            }return roomArrayList;
        }
        //get data house

    public static ArrayList<House> get_Data_House(){
        ArrayList<String> House_List=Read_Write_File.read_File(PATH_HOUSE);
        House house;
        ArrayList<House> houseArrayList = new ArrayList<>();
        for (int index=0;index<(House_List.size()/9);index++ ){
            house = new House(House_List.get(index),
                    House_List.get(index + 1),
                    Double.parseDouble(House_List.get(index + 2)),
                    Double.parseDouble(House_List.get(index + 3)),
                    Double.parseDouble(House_List.get(index + 4)),
                    House_List.get(index + 5), House_List.get(index + 6), House_List.get(index + 7),
                    Integer.parseInt(House_List.get(index + 8)));
            houseArrayList.add(house);
        }

        return houseArrayList;
    }
}
