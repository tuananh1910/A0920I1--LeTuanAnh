package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Common.Regex;
import CaseStudy.Refesh.Controllers.Get_Data;
import CaseStudy.Refesh.Models.House;

import java.util.ArrayList;
import java.util.Scanner;

public class House_Service {
    static ArrayList<House> houseArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String PATH ="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\House.csv";

    public static void input_House() {
        House house = (House) Common_Service.input_Service(2);

        String standard_Room;
        do {
            System.out.println("Standard Room:");
            standard_Room = scanner.nextLine();
        } while (Regex.check_Service(standard_Room));
        assert house != null;
        house.setStandard_Room(standard_Room);

        System.out.println("Description :");
        String description = scanner.nextLine();
        house.setDescription(description);

        int number_Of_Floor;
        do {
            System.out.println("Number Of Floor");
            number_Of_Floor = Integer.parseInt(scanner.nextLine());
        }while (Regex.check_Number_Int(String.valueOf(number_Of_Floor)));
        house.setNumber_Of_Floors(number_Of_Floor);

        houseArrayList.add(house);

        for (House value : houseArrayList){
            Read_Write_File.write_File(PATH,value.toString());
        }
        System.out.println("Success !");

    }
    public static void show_House() {
        for (House house : houseArrayList){
            System.out.println(house.showInfor());
        }
    }
    public static void show_House_Not_Duplicate(){

    }
    public static void get_On_Data_House(){
        houseArrayList = Get_Data.get_Data_House();
    }

}
