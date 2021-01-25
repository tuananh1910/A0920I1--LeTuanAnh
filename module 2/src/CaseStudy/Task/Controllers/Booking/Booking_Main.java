package CaseStudy.Task.Controllers.Booking;

import CaseStudy.Task.Controllers.Customer.Customer_Main;
import CaseStudy.Task.Controllers.House.House_Main;
import CaseStudy.Task.Controllers.Rooms.Room_Main;
import CaseStudy.Task.Controllers.Villa.Villa_Main;
import CaseStudy.Task.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task.Models.Customer.Customer;
import CaseStudy.Task.Models.House;
import CaseStudy.Task.Models.Room;
import CaseStudy.Task.Models.Villa;

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

    public void add_New_Booking(ArrayList<Customer> customers, ArrayList<Villa> villas
            , ArrayList<House> houses, ArrayList<Room> rooms, final String PATH) throws IOException {
        customer_main.show_Information_Of_Custumer(customers);
        System.out.println("Select the customer order number, " +
                "for which you want to order the service");
        int number_Customer = scanner.nextInt();

        scanner.nextLine();
        System.out.println("1.Booking Villa\n" +
                "2.Booking House\n" +
                "3.Booking Room\n");
        int number_Booking = scanner.nextInt();
        int number_Service;
        String string = "";
        for (int index = 0; index < customers.size(); index++) {
            string += customers.get(index).getName() + "," +
                    customers.get(index).getDate() + "," +
                    customers.get(index).getGender() + "," +
                    customers.get(index).getIndentity_Card() + "," +
                    customers.get(index).getPhone_Number() + "," +
                    customers.get(index).getEmail() + "," +
                    customers.get(index).getType_Customer() + "," +
                    customers.get(index).getAddress() + ",";
        }
        switch (number_Booking) {
            case 1:
                villa_main.show_All_Villa(villas);
                System.out.println("Chon Service");
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer - 1).setUse_Service(villas.get(number_Service - 1));
                System.out.println("After Booking");
                customer_main.show_Information_Of_Custumer(customers);

                for (int index = 0; index < customers.size(); index++) {
                    string += customers.get(index).getUse_Service().get_CodeService() + "," +
                            customers.get(index).getUse_Service().getName_Service() + "," +
                            customers.get(index).getUse_Service().getAreaUse() + "," +
                            customers.get(index).getUse_Service().getPrice() + "," +
                            customers.get(index).getUse_Service().getMax_Number_Of_People() + "," +
                            customers.get(index).getUse_Service().getRental_Type() + "," +
                            ((Villa) customers.get(index).getUse_Service()).getStandard_Room() + "," +
                            ((Villa) customers.get(index).getUse_Service()).getDescription() + "," +
                            ((Villa) customers.get(index).getUse_Service()).getPool_Area() + "," +
                            ((Villa) customers.get(index).getUse_Service()).getNumber_Of_Floors() + "\n";
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
                break;
            case 2:
                house_main.show_ALl_House(houses);
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer - 1).setUse_Service(houses.get(number_Service - 1));
                System.out.println("After Booking");
                customer_main.show_Information_Of_Custumer(customers);
                string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string += customers.get(index).getUse_Service().get_CodeService() + "," +
                            customers.get(index).getUse_Service().getName_Service() + "," +
                            customers.get(index).getUse_Service().getAreaUse() + "," +
                            customers.get(index).getUse_Service().getPrice() + "," +
                            customers.get(index).getUse_Service().getMax_Number_Of_People() + "," +
                            customers.get(index).getUse_Service().getRental_Type() + "," +
                            ((House) customers.get(index).getUse_Service()).getStandard_Room() + "," +
                            ((House) customers.get(index).getUse_Service()).getDescription() + "," +
                            ((House) customers.get(index).getUse_Service()).getNumber_Of_Floors() + "\n";
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
                break;

            case 3:
                room_main.show_All_Room(rooms);
                number_Service = scanner.nextInt();
                scanner.nextLine();
                customers.get(number_Customer - 1).setUse_Service(rooms.get(number_Service - 1));
                System.out.println("After Booking");
                customer_main.show_Information_Of_Custumer(customers);
                string = "";
                for (int index = 0; index < customers.size(); index++) {
                    string += customers.get(index).getUse_Service().get_CodeService() + "," +
                            customers.get(index).getUse_Service().getName_Service() + "," +
                            customers.get(index).getUse_Service().getAreaUse() + "," +
                            customers.get(index).getUse_Service().getPrice() + "," +
                            customers.get(index).getUse_Service().getMax_Number_Of_People() + "," +
                            customers.get(index).getUse_Service().getRental_Type() + "," +
                            ((Room) customers.get(index).getUse_Service()).getService_Free() + "\n";
                }
                write_read_file.write_File(PATH + "\\Customer.csv", string);
                break;
            default:
                break;
        }
    }
}
