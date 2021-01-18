package CaseStudy.Task_1.Controllers;

import CaseStudy.Task_1.Controllers.Comparator.Comparator;
import CaseStudy.Task_1.Controllers.Regex.Regex;
import CaseStudy.Task_1.Controllers.User_Exception.*;
import CaseStudy.Task_1.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task_1.Models.*;
import CaseStudy.Task_1.Models.Customer.Customer;

import java.io.*;
import java.util.*;

public class main_Controllers {

    static Scanner scanner = new Scanner(System.in);
    static boolean out_Menu = true;
    static ArrayList<Villa> villas = new ArrayList<>();
    static ArrayList<House> houses = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static Write_Read_File write_read_file = new Write_Read_File();
    static Regex regex = new Regex();
    static final String PATH = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy";
    static Comparator comparator = new Comparator();


    public static void main(String[] args) throws IOException {
        villas.add(new Villa("SVVL-0123","Va",30,20,20,"Va","Va","Va",30,1));
        customers.add(new Customer("Anh","19/10/2000","Male","123 123 123",123,"zxczxc@gmail.com","Za","Za"));
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
                default:break;
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
                default:
                    break;
            }
        } while (out_Menu);
    }

    public static void add_New_Villa() throws IOException {
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
            boolean check = area_Use < 30;
            System.out.println(check);
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
        String string = null;
        for (int index = 0; index < villas.size(); index++) {
            string += villas.get(index).showInfor();
        }
        System.out.println("--------");
        System.out.println(PATH + "\\Villa.txt");
        write_read_file.write_File(PATH + "\\Villa.txt", string);

    }

    private static void add_New_House() throws IOException {
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
        String string = null;
        for (int index = 0; index < houses.size(); index++) {
            string += houses.get(index).showInfor();
        }
        System.out.println("--------");
        System.out.println(PATH + "\\House.txt");
        write_read_file.write_File(PATH + "\\House.txt", string);
    }

    private static void add_New_Room() throws IOException {
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
        String string = null;
        for (int index = 0; index < rooms.size(); index++) {
            string += rooms.get(index).showInfor();
        }
        System.out.println("--------");
        System.out.println(PATH + "\\Room.txt");
        write_read_file.write_File(PATH + "\\Room.txt", string);
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
                default:break;
            }
        } while (out_Menu);

    }

    private static void show_All_Name_Room_Not_Duplicate() {

    }

    private static void show_All_Name_House_Not_Duplicate() {

    }

    private static void show_All_Name_Villa_Not_Duplicate() {

    }

    private static void show_All_Room() {
        for (int index =0; index<rooms.size();index++){
            System.out.println(rooms.get(index).showInfor());
        }
    }

    private static void show_ALl_House() {
        for (int index =0; index<houses.size();index++){
            System.out.println(houses.get(index).showInfor());
        }
    }

    private static void show_All_Villa() {
        for (int index =0; index<villas.size();index++){
            System.out.println(villas.get(index).showInfor());
        }
    }


    // add new customer
    static Name_Exception name_exception = new Name_Exception();
    static Email_Exception email_exception = new Email_Exception();
    static Gender_Exception gender_exception = new Gender_Exception();
    static Id_Card_Exception id_card_exception = new Id_Card_Exception();
    static Birthday_Exception birthday_exception = new Birthday_Exception();

    private static void add_New_Customer() throws IOException {
        System.out.println("Enter Information Customer :");
        String name;
        while (true) {
            try {
                System.out.println("Name : ");
                name = scanner.nextLine();
                name = name+" ";
                if (name_exception.name_Exeption(name)) {
                    break;
                }
            } catch (Name_Exception e) {
                e.getMessage();
            }
        }

        String date;
        while (true) {
            try {
                System.out.println("Date : ");
                date = scanner.nextLine();
                if (birthday_exception.birthday_Exception(date)) {

                    break;
                }
            } catch (Birthday_Exception e) {
                e.getMessage();
            }
        }

        String gender;
        do {
            System.out.println("Gender : ");
            gender = scanner.nextLine();
        } while (!gender_exception.gender_Exeption(gender));

        gender = gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
        System.out.println(gender);

        String indentity_Card;
        while (true) {
            try {
                System.out.println("Identity card : ");
                indentity_Card = scanner.nextLine();
                String ID = indentity_Card + " ";
                if (id_card_exception.id_Card_Exception(ID)) {
                    break;
                }
            } catch (Id_Card_Exception id) {
                id.getMessage();
            }
        }

        System.out.println("Phone number : ");
        int phone_Number = scanner.nextInt();
        scanner.nextLine();

        String email;
        while (true) {
            try {
                System.out.println("Email : ");
                email = scanner.nextLine();
                if (email_exception.email_Exeption(email)) {
                    break;
                }
            } catch (Email_Exception ex) {
                ex.getMessage();
            }

        }
        System.out.println("Type customer : ");
        String type_Customer = scanner.nextLine();
        System.out.println("Address : ");
        String address = scanner.nextLine();
        customers.add(new Customer(name, date, gender, indentity_Card, phone_Number
                , email, type_Customer, address));
        Collections.sort(customers, comparator);
        String string = "";
        for (int index = 0; index < customers.size(); index++) {
            string +=  customers.get(index).showInfor(index);
        }
        System.out.println(PATH + "\\Customer.csv");
        write_read_file.write_File(PATH + "\\Customer.csv", string);
    }

    // show information of custumer
    private static void show_Information_Of_Custumer() {
        for (int index =0; index<customers.size();index++){
            System.out.println(customers.get(index).showInfor(index));
        }

//        customers.sort(java.util.Comparator.comparing(Customer::getName));
//        System.out.println("After sort : -------");
//        for (Customer customer : customers){
//            System.out.println(customer.showInfor());
//        }
    }

    // add new booking
    private static void add_New_Booking() throws IOException {
        show_Information_Of_Custumer();
        System.out.println("Select the customer order number, " +
                "for which you want to order the service");
        int  number_Customer = scanner.nextInt();

        scanner.nextLine();
        System.out.println("1.Booking Villa\n" +
                "2.Booking House\n" +
                "3.Booking Room\n");
        int number_Booking = scanner.nextInt();
        int number_Service ;
        scanner.nextLine();
        switch (number_Booking){
            case 1:
                show_All_Villa();
                System.out.println("Chon Service");
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer-1).setUse_Service(villas.get(number_Service-1));
                System.out.println("After Booking");
                show_Information_Of_Custumer();
                String string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string +=  customers.get(index).showInfor(index);
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
            case 2:
                show_ALl_House();
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer-1).setUse_Service(houses.get(number_Service-1));
                System.out.println("After Booking");
                show_Information_Of_Custumer();
                string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string +=  customers.get(index).showInfor(index);
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);

            case 3:
                show_All_Room();
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer-1).setUse_Service(rooms.get(number_Service-1));
                System.out.println("After Booking");
                show_Information_Of_Custumer();
                string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string +=  customers.get(index).showInfor(index);
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
            default:
                break;
        }
    }

    // show information of employee
    private static void show_Information_Of_Employee() throws IOException {
        Map<Integer,Employee> employees = new TreeMap<>();
        employees.put(1,new Employee("Le A",20,"DN"));
        employees.put(2,new Employee("Le A",20,"DN"));
        employees.put(3,new Employee("Le A",20,"DN"));
        employees.put(4,new Employee("Le A",20,"DN"));
        employees.put(5,new Employee("Le A",20,"DN"));
        employees.put(6,new Employee("Le A",20,"DN"));
        employees.put(7,new Employee("Le A",20,"DN"));
        employees.put(8,new Employee("Le A",20,"DN"));
        employees.put(9,new Employee("Le A",20,"DN"));
        employees.put(10,new Employee("Le A",20,"DN"));
        System.out.println(PATH + "\\Employee.csv");
        write_read_file.write_File(PATH + "\\Employee.csv", employees.toString());


//        System.out.println(PATH + "\\Employee.csv");
        System.out.println(write_read_file.read_File(PATH + "\\Employee.csv"));
        System.out.println("---------------");
    }


}
