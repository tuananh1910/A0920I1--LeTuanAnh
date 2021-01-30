package CaseStudy.Task.Controllers.Villa;

import CaseStudy.Task.Controllers.Regex.Regex;
import CaseStudy.Task.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task.Models.Villa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Villa_Main {
    Scanner scanner = new Scanner(System.in);
    Regex regex = new Regex();
    Write_Read_File write_read_file = new Write_Read_File();

    public void add_New_Villa(ArrayList<Villa> villas, final String PATH) throws IOException {
        System.out.println("Enter Information Villa :");
        String code_Service;
        do {
            System.out.println("Enter code service :");
            code_Service = scanner.nextLine();
        }
        while (!regex.check_Format_Code_Service(code_Service, "Villa"));
        String nameService;
        do {
            System.out.println("Enter name service :");
            nameService = scanner.nextLine();
        }
        while (!regex.check_Name_Service(nameService, "Villa"));
        double area_Use;
        do {
            System.out.println("Area will use :");
            area_Use = scanner.nextDouble();

        } while (regex.check_Number(String.valueOf(area_Use), "Villa") && area_Use < 30);
        double price;
        do {
            System.out.println("Price :");
            price = scanner.nextDouble();
        } while (!regex.check_Number(String.valueOf(price), "Villa"));
        int max_People;
        do {
            System.out.println("Max number of people :");
            max_People = scanner.nextInt();
        } while (regex.check_Number(String.valueOf(max_People), "Villa")
                && max_People > 20);
        scanner.nextLine();
        String rental_Type;
        do {
            System.out.println("Rental Type :");
            rental_Type = scanner.nextLine();
        } while (!regex.check_Name_Service(rental_Type, "Villa"));
        String standard_Room;
        do {
            System.out.println("Standard Room :");
            standard_Room = scanner.nextLine();
        } while (!regex.check_Name_Service(standard_Room, "Villa"));
        System.out.println("Description :");
        String description = scanner.nextLine();
        double pool_Area;
        do {
            System.out.println("Pool Area :");
            pool_Area = scanner.nextDouble();
        } while (regex.check_Number(String.valueOf(pool_Area), "Villa") && pool_Area < 30);
        int number_Of_Floor;
//        do {
        System.out.println("Number Of Floor :");
        number_Of_Floor = scanner.nextInt();
//        }
//        while (!regex.check_Number(String.valueOf(number_Of_Floor), "Villa"));
        scanner.nextLine();
        Villa new_Villa = new Villa(code_Service, nameService, area_Use, price,
                max_People, rental_Type, standard_Room, description,
                pool_Area, number_Of_Floor);
        villas.add(new_Villa);
        String string = "";

        for (int index = 0; index < villas.size(); index++) {
            string += villas.get(index).showInfor();

        }
        System.out.println("--------");
        System.out.println(PATH + "\\Villa.txt");
        write_read_file.write_File(PATH + "\\Villa.txt", string);
    }

    public void show_All_Villa(ArrayList<Villa> villas) {
        for (int index = 0; index < villas.size(); index++) {
            System.out.println(villas.get(index).showInfor());
        }
    }

    public void show_All_Name_Villa_Not_Duplicate() {

    }
}
