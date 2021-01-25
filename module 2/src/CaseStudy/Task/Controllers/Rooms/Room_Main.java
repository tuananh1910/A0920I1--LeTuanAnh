package CaseStudy.Task.Controllers.Rooms;

import CaseStudy.Task.Controllers.Regex.Regex;
import CaseStudy.Task.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task.Models.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room_Main {
    Scanner scanner = new Scanner(System.in);
    Regex regex = new Regex();
    Write_Read_File write_read_file = new Write_Read_File();

    public void add_New_Room(ArrayList<Room> rooms, final String PATH) throws IOException {
        System.out.println("Enter Information Room :");
        String code_Service;
        do {
            System.out.println("Enter code service :");
            code_Service = scanner.nextLine();
        }
        while (!regex.check_Format_Code_Service(code_Service, "Room"));
        String nameService;
        do {
            System.out.println("Enter name service :");
            nameService = scanner.nextLine();
        }
        while (!regex.check_Name_Service(nameService, "Room"));
        double area_Use;
        do {
            System.out.println("Area will use :");
            area_Use = scanner.nextDouble();
        } while (!regex.check_Number(String.valueOf(area_Use), "Room") && area_Use > 30);
        double price;
        do {
            System.out.println("Price :");
            price = scanner.nextDouble();
        } while (!regex.check_Number(String.valueOf(price), "Room"));
        int max_People;
        do {
            System.out.println("Max number of people :");
            max_People = scanner.nextInt();
        } while (!regex.check_Number(String.valueOf(max_People), "Room")
                && max_People < 20);
        scanner.nextLine();
        String rental_Type;
        do {
            System.out.println("Rental Type :");
            rental_Type = scanner.nextLine();
        } while (!regex.check_Name_Service(rental_Type, "Room"));
        System.out.println("Free For Service");
        String free_For_Service = scanner.nextLine();
        rooms.add(new Room(code_Service, nameService, area_Use, price, max_People
                , rental_Type, free_For_Service));
        String string = "";
        for (int index = 0; index < rooms.size(); index++) {
            string += rooms.get(index).showInfor();
        }
        System.out.println("--------");
        System.out.println(PATH + "\\Room.txt");
        write_read_file.write_File(PATH + "\\Room.txt", string);
    }

    public void show_All_Room(ArrayList<Room> rooms) {
        for (int index = 0; index < rooms.size(); index++) {
            System.out.println(rooms.get(index).showInfor());
        }
    }

    public void show_All_Name_Room_Not_Duplicate() {

    }
}
