package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Models.Customer;
import CaseStudy.Refesh.Models.Services;

import java.util.Scanner;

public class Booking_Service {
    static Scanner scanner = new Scanner(System.in);
    public static void add_New_Booking(){
        Customer_Service.show_Customer();
        // sua lai phan getdata
        System.out.println("Select the customer order number, " +
                "for which you want to order the service");
        int number_Customer = Integer.parseInt(scanner.nextLine());



        scanner.nextLine();
        System.out.println("1.Booking Villa\n" +
                "2.Booking House\n" +
                "3.Booking Room\n");
        int number_Booking = Integer.parseInt(scanner.nextLine());
        int number_Service;
        switch (number_Booking){
            case 1:
                Villa_Service.show_Villa();
                System.out.println("Choose Number Service :");
                number_Service = Integer.parseInt(scanner.nextLine());

                Services villa =Villa_Service.villaArrayList.get(number_Service-1);
                Customer_Service.customerArrayList.get(number_Customer-1).setUse_Service(villa);

                System.out.println("After Booking : ");
                Customer_Service.show_Customer();
                break;
            case 2:
                House_Service.show_House();
                System.out.println("Choose Number Service :");
                number_Service = Integer.parseInt(scanner.nextLine());

                Services house =House_Service.houseArrayList.get(number_Service-1);
                Customer_Service.customerArrayList.get(number_Customer-1).setUse_Service(house);

                System.out.println("After Booking : ");
                Customer_Service.show_Customer();
                break;
            case 3:
                Room_Service.show_Room();
                System.out.println("Choose Number Service :");
                number_Service = Integer.parseInt(scanner.nextLine());

                Services room = Room_Service.roomArrayList.get(number_Service-1);
                Customer_Service.customerArrayList.get(number_Customer-1).setUse_Service(room);

                System.out.println("After Booking : ");
                Customer_Service.show_Customer();
                break;
            default:break;
        }

        for (Customer value : Customer_Service.customerArrayList){
            Read_Write_File.write_File(Customer_Service.PATH,value.toString());
        }

        System.out.println("Success !");
    }
}
