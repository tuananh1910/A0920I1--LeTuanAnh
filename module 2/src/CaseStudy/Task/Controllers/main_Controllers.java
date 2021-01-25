package CaseStudy.Task.Controllers;

import CaseStudy.Task.Controllers.Booking.Booking_Main;
import CaseStudy.Task.Controllers.Customer.Customer_Main;
import CaseStudy.Task.Controllers.Employee_Main.Employee_Main;
import CaseStudy.Task.Controllers.House.House_Main;
import CaseStudy.Task.Controllers.Rooms.Room_Main;
import CaseStudy.Task.Controllers.Villa.Villa_Main;
import CaseStudy.Task.Models.*;
import CaseStudy.Task.Models.Customer.Customer;

import java.io.*;
import java.util.*;

public class main_Controllers {

    static Scanner scanner = new Scanner(System.in);
    static boolean out_Menu = true;
    static ArrayList<Villa> villas = new ArrayList<>();
    static ArrayList<House> houses = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static final String PATH = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy";
    static Villa_Main villa_main = new Villa_Main();
    static House_Main house_main = new House_Main();
    static Room_Main room_main = new Room_Main();
    static Customer_Main customer_main = new Customer_Main();
    static Booking_Main booking_main = new Booking_Main();
    static Employee_Main employee_main = new Employee_Main();
    static Map<Integer, Employee> employees = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        villas.add(new Villa("SVVL-0123", "Va", 30, 20, 20, "Va", "Va", "Va", 30, 1));
        customers.add(new Customer("Anh", "19/10/2000", "Male", "123 123 123", 123, "zxczxc@gmail.com", "Za", "Za"));
        displayMenu();
    }

    // menu
    public static void displayMenu() throws IOException {
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
                    customer_main.add_New_Customer(customers, PATH);
                    break;
                case 4:
                    customer_main.show_Information_Of_Custumer(customers);
                    break;
                case 5:
                    booking_main.add_New_Booking(customers, villas, houses, rooms, PATH);
                    break;
                case 6:
                    employee_main.show_Information_Of_Employee(employees,PATH);
                    break;
                case 7:
                    out_Menu = false;
                    break;
                default:
                    break;
            }
        } while (out_Menu);
    }


    // add new services
    public static void add_New_Services() throws IOException {
        do {
            System.out.println("Menu\n 1.Add New Villa \n" +
                    "2.Add New House\n 3.Add New Room\n" +
                    "4.Back to Menu\n 5.Exit");
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    villa_main.add_New_Villa(villas, PATH);
                    break;
                case 2:
                    house_main.add_New_House(houses, PATH);
                    break;
                case 3:
                    room_main.add_New_Room(rooms, PATH);
                    break;
                case 4:
                    displayMenu();
                    break;
                case 5:
                    out_Menu = false;
                    break;
                default:
                    break;
            }
        } while (out_Menu);
    }

    // show services
    private static void show_Services() throws IOException {
        do {
            System.out.println("Menu\n 1.Show All Villa \n" +
                    "2.Show All House\n 3.Show All Room\n" +
                    "4.Show All Name Villa Not Duplicate\n " +
                    "5.Show All Name House Not Duplicate\n" +
                    "6.Show All Name Room Not Duplicate\n" +
                    "7.Back to Menu\n" + "8.Exit");
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    villa_main.show_All_Villa(villas);
                    break;
                case 2:
                    house_main.show_ALl_House(houses);
                    break;
                case 3:
                    room_main.show_All_Room(rooms);
                    break;
                case 4:
                    villa_main.show_All_Name_Villa_Not_Duplicate();
                    break;
                case 5:
                    house_main.show_All_Name_House_Not_Duplicate();
                    break;
                case 6:
                    room_main.show_All_Name_Room_Not_Duplicate();
                    break;
                case 7:
                    displayMenu();
                    break;
                case 8:
                    out_Menu = false;
                    break;
                default:
                    break;
            }
        } while (out_Menu);
    }
}
