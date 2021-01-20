package CaseStudy.Task_1.Controllers.Booking;

import CaseStudy.Task_1.Controllers.Customer.Customer_Main;
import CaseStudy.Task_1.Controllers.House.House_Main;
import CaseStudy.Task_1.Controllers.Rooms.Room_Main;
import CaseStudy.Task_1.Controllers.Villa.Villa_Main;
import CaseStudy.Task_1.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task_1.Models.Customer.Customer;
import CaseStudy.Task_1.Models.House;
import CaseStudy.Task_1.Models.Room;
import CaseStudy.Task_1.Models.Villa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Booking_Main {
    Scanner scanner = new Scanner(System.in);
    Customer_Main customer_main = new Customer_Main();
    Villa_Main villa_main = new Villa_Main();
    House_Main house_main = new House_Main();
    Room_Main room_main = new Room_Main();
    Write_Read_File write_read_file = new Write_Read_File();
    public void add_New_Booking(ArrayList<Customer> customers,ArrayList<Villa> villas
    ,ArrayList<House> houses,ArrayList<Room> rooms,final String PATH) throws IOException {
//        show_Information_Of_Custumer();
        customer_main.show_Information_Of_Custumer(customers);
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
//                show_All_Villa();
                villa_main.show_All_Villa(villas);
                System.out.println("Chon Service");
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer-1).setUse_Service(villas.get(number_Service-1));
                System.out.println("After Booking");
//                show_Information_Of_Custumer();
                customer_main.show_Information_Of_Custumer(customers);
                String string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string +=  customers.get(index).showInfor(index);
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
                break;
            case 2:
//                show_ALl_House();
                house_main.show_ALl_House(houses);
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer-1).setUse_Service(houses.get(number_Service-1));
                System.out.println("After Booking");
//                show_Information_Of_Custumer();
                customer_main.show_Information_Of_Custumer(customers);
                string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string +=  customers.get(index).showInfor(index);
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
                break;

            case 3:
//                show_All_Room();
                room_main.show_All_Room(rooms);
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer-1).setUse_Service(rooms.get(number_Service-1));
                System.out.println("After Booking");
//                show_Information_Of_Custumer();
                customer_main.show_Information_Of_Custumer(customers);
                string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string +=  customers.get(index).showInfor(index);
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
                break;
            default:
                break;
        }
    }
}
