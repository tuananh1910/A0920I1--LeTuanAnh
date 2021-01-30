package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Controllers.Get_Data;
import CaseStudy.Refesh.Models.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class Room_Service {
    static ArrayList<Room> roomArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String PATH ="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Room.csv";

    public static void input_Room() {
        Room room = (Room) Common_Service.input_Service(3);
        String Service_Free;
        System.out.println("Free For Service:");
        Service_Free = scanner.nextLine();
        assert room != null;
        room.setService_Free(Service_Free);
        roomArrayList.add(room);

        for (Room value : roomArrayList){
            Read_Write_File.write_File(PATH,value.toString());
        }
        System.out.println("Success !");

    }
    public static void show_Room() {
        for (Room room : roomArrayList){
            System.out.println(room.showInfor());
        }
    }
    public static void show_Room_Not_Duplicate(){

    }

    public static void get_On_Data_Room(){
        roomArrayList = Get_Data.get_Data_Room();
    }
}
