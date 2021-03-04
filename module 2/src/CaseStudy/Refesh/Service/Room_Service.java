package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Common.Regex;
import CaseStudy.Refesh.Common.Get_Data;
import CaseStudy.Refesh.Models.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class Room_Service {
    static ArrayList<Room> roomArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String PATH ="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Room.csv";

    public static void input_Room() {
        Room room = (Room) Common_Service.input_Service(3);
        StringBuilder alert = new StringBuilder();

        String Service_Free;

        do {
            System.out.println("Free For Service:");
            Service_Free = scanner.nextLine();
            if (Regex.check_Service_Free(Service_Free)){
                alert.append("Dịch vụ đi kèm : massage, karaoke, food, drink, car");
            }
            else {
                break;
            }
            System.out.println(alert);
            alert = new StringBuilder();
        }while (true);

        assert room != null;
        room.setService_Free(Service_Free);
        roomArrayList.add(room);

// bug The process cannot access the file because it is being used by another process)
//	at java.base/java.io.FileOutputStream.open0(Native Method)
        Read_Write_File.write_File(PATH,room.toString());

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
