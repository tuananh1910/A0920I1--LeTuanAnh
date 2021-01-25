package CaseStudy.Task.Controllers.House;

import CaseStudy.Task.Controllers.Regex.Regex;
import CaseStudy.Task.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task.Models.House;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class House_Main {
    Scanner scanner = new Scanner(System.in);
    Regex regex = new Regex();
    Write_Read_File write_read_file = new Write_Read_File();

    public void add_New_House(ArrayList<House> houses, final String PATH) throws IOException {
        System.out.println("Enter Information House :");
        String code_Service;
        do {
            System.out.println("Enter code service :");
            code_Service = scanner.nextLine();
        }
        while (!regex.check_Format_Code_Service(code_Service, "House"));
        String nameService;
        do {
            System.out.println("Enter name service :");
            nameService = scanner.nextLine();
        }
        while (!regex.check_Name_Service(nameService, "House"));
        double area_Use;
        do {
            System.out.println("Area will use :");
            area_Use = scanner.nextDouble();
        } while (!regex.check_Number(String.valueOf(area_Use), "House") && area_Use > 30);
        double price;
        do {
            System.out.println("Price :");
            price = scanner.nextDouble();
        } while (!regex.check_Number(String.valueOf(price), "House"));
        int max_People;
        do {
            System.out.println("Max number of people :");
            max_People = scanner.nextInt();
        } while (!regex.check_Number(String.valueOf(max_People), "House")
                && max_People < 20);
        scanner.nextLine();
        String rental_Type;
        do {
            System.out.println("Rental Type :");
            rental_Type = scanner.nextLine();
        } while (!regex.check_Name_Service(rental_Type, "House"));
        String standard_Room;
        do {
            System.out.println("Standard Room :");
            standard_Room = scanner.nextLine();
        } while (!regex.check_Name_Service(standard_Room, "House"));
        System.out.println("Description :");
        String description = scanner.nextLine();
        System.out.println("Number Of Floor :");
        int number_Of_Floor = scanner.nextInt();
        scanner.nextLine();
        houses.add(new House(code_Service, nameService, area_Use, price, max_People,
                rental_Type, standard_Room, description, number_Of_Floor));
        String string = "";
        for (int index = 0; index < houses.size(); index++) {
            string += houses.get(index).showInfor();
        }
        System.out.println("--------");
        System.out.println(PATH + "\\House.txt");
        write_read_file.write_File(PATH + "\\House.txt", string);
    }

    public void show_ALl_House(ArrayList<House> houses) {
        for (int index = 0; index < houses.size(); index++) {
            System.out.println(houses.get(index).showInfor());
        }
    }

    public void show_All_Name_House_Not_Duplicate() {

    }
}
