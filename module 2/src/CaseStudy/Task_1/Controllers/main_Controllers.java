package CaseStudy.Task_1.Controllers;

import CaseStudy.Task_1.Models.House;
import CaseStudy.Task_1.Models.Room;
import CaseStudy.Task_1.Models.Services;
import CaseStudy.Task_1.Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main_Controllers {
    static Scanner scanner = new Scanner(System.in);
    static boolean out_Menu = true;
    static ArrayList<Villa> villas = new ArrayList<>();
    static ArrayList<House> houses = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        displayMenu();
    }

    // menu
    public static void displayMenu()  {
        ArrayList<Services> services = new ArrayList<>();
        do {
            System.out.println("Menu\n 1.Add New Services \n" +
                    "2.Show Services\n 3.Add New Customer\n" +
                    "4.Show Information of Customer\n 5.Add New Booking\n" +
                    "6. Show Information of Employee\n 7. Exit");

            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    add_New_Services();
                    break;
                case 2:
                    show_Services();
                    break;
                case 3:
                    add_New_Customer();
                    break;
                case 4:
                    show_Information_Of_Custumer();
                    break;
                case 5:
                    add_New_Booking();
                    break;
                case 6:
                    show_Information_Of_Employee();
                    break;
                case 7:
                    out_Menu = false;
                    break;
            }
        } while (out_Menu);
    }


    // add new services
    private static void add_New_Services() {
        do {
            System.out.println("Menu\n 1.Add New Villa \n" +
                    "2.Add New House\n 3.Add New Room\n" +
                    "4.Back to Menu\n 5.Exit");
            int number = Integer.parseInt(scanner.nextLine());
            switch (number){
                case 1:
                    add_New_Villa();
                    break;
                case 2:
                    add_New_House();
                    break;
                case 3:
                    add_New_Room();
                    break;
                case 4:
                    displayMenu();
                    break;
                case 5:
                    out_Menu = false;
                    break;
            }
        }while (out_Menu);
    }
    private static void add_New_Villa() {
        System.out.println("Enter Information Villa :");
        System.out.println("Area will use :");
        double area_Use = scanner.nextDouble();
        System.out.println("Price :");
        double price = scanner.nextDouble();
        System.out.println("Max number of people :");
        int max_People = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Rental Type :");
        String rental_Type = scanner.nextLine();
        System.out.println("Standard Room :");
        String standard_Room = scanner.nextLine();
        System.out.println("Description :");
        String description = scanner.nextLine();
        System.out.println("Pool Area :");
        double pool_Area = scanner.nextDouble();
        System.out.println("Number Of Floor :");
        int number_Of_Floor = scanner.nextInt();
        scanner.nextLine();
        villas.add(new Villa("Villa",area_Use,price,
                max_People,rental_Type,standard_Room,description,
                pool_Area,number_Of_Floor));
        String dong;
        try {
            File file = new File("E:\\DATA\\A0920I1--LeTuanAnh\\" +
                    "module 2\\src\\CaseStudy\\Villa.txt");
            BufferedReader fileReader = new BufferedReader(
                    new FileReader(file));
            
        }catch (Exception e){

        }
    }
    private static void add_New_House(){
        System.out.println("Enter Information House :");
        System.out.println("Area will use :");
        double area_Use = scanner.nextDouble();
        System.out.println("Price :");
        double price = scanner.nextDouble();
        System.out.println("Max number of people :");
        int max_People = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Rental Type :");
        String rental_Type = scanner.nextLine();
        System.out.println("Standard Room :");
        String standard_Room = scanner.nextLine();
        System.out.println("Description :");
        String description = scanner.nextLine();
        System.out.println("Number Of Floor :");
        int number_Of_Floor = scanner.nextInt();
        scanner.nextLine();
        houses.add(new House("House",area_Use,price,max_People,
                rental_Type,standard_Room,description,number_Of_Floor));
    }
    private static void add_New_Room(){
        System.out.println("Enter Information House :");
        System.out.println("Area will use :");
        double area_Use = scanner.nextDouble();
        System.out.println("Price :");
        double price = scanner.nextDouble();
        System.out.println("Max number of people :");
        int max_People = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Rental Type :");
        String rental_Type = scanner.nextLine();
        System.out.println("Free For Service");
        String free_For_Service = scanner.nextLine();
        rooms.add(new Room("Room",area_Use,price,max_People
                ,rental_Type,free_For_Service));
    }


    // show services
    private static void show_Services() {
        do {
            System.out.println("Menu\n 1.Show All Villa \n" +
                    "2.Show All House\n 3.Show All Room\n" +
                    "4.Show All Name Villa Not Duplicate\n " +
                    "5.Show All Name House Not Duplicate\n"+
                    "6.Show All Name Room Not Duplicate\n"+
                    "7.Back to Menu\n"+"8.Exit");
            int number = Integer.parseInt(scanner.nextLine());
            switch (number){
                case 1:
                    show_All_Villa();
                    break;
                case 2:
                    show_ALl_House();
                    break;
                case 3:
                    show_All_Room();
                    break;
                case 4:
                    show_All_Name_Villa_Not_Duplicate();
                    break;
                case 5:
                    show_All_Name_House_Not_Duplicate();
                    break;
                case 6:
                    show_All_Name_Room_Not_Duplicate();
                    break;
                case 7:
                    displayMenu();
                    break;
                case 8:
                    out_Menu = false;
                    break;
            }
        }while (out_Menu);

    }

    private static void show_All_Name_Room_Not_Duplicate() {

    }

    private static void show_All_Name_House_Not_Duplicate() {

    }

    private static void show_All_Name_Villa_Not_Duplicate() {

    }

    private static void show_All_Room() {
        for (Room room : rooms){
            System.out.println(room.showInfor());
        }
    }

    private static void show_ALl_House() {
        for (House house : houses){
            System.out.println(house.showInfor());
        }
    }

    private static void show_All_Villa() {
        for (Villa villa : villas){
            System.out.println(villa.showInfor());
        }
    }



    // add new customer
    private static void add_New_Customer() {

    }
    // show information of custumer
    private static void show_Information_Of_Custumer() {
    }

    // add new booking
    private static void add_New_Booking() {
    }

    // show information of employee
    private static void show_Information_Of_Employee() {
    }


}
