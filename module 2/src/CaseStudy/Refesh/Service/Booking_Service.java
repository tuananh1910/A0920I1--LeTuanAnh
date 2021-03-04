package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Get_Data;
import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Models.Customer;
import CaseStudy.Refesh.Models.House;
import CaseStudy.Refesh.Models.Villa;

import java.util.Scanner;

public class Booking_Service {
    private static final String PATH = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Booking.csv";
    static Scanner scanner = new Scanner(System.in);
    public static void add_New_Booking(){
        Customer_Service.show_Customer();
        // sua lai phan getdata
        System.out.println("Select the customer order number, " +
                "for which you want to order the service");
        int number_Customer = scanner.nextInt();

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

                Villa villa =Villa_Service.villaArrayList.get(number_Service-1);
                Customer_Service.customerArrayList.get(number_Customer-1).setUse_Service(villa.getCodeServices());

                System.out.println("After Booking : ");
                Customer_Service.show_Customer();
                Read_Write_File.write_File(PATH,Customer_Service.customerArrayList.get(number_Customer-1).toString()+","+villa.toString());
                break;
            case 2:
                House_Service.show_House();
                System.out.println("Choose Number Service :");
                number_Service = Integer.parseInt(scanner.nextLine());

                House house =House_Service.houseArrayList.get(number_Service-1);
                Customer_Service.customerArrayList.get(number_Customer-1).setUse_Service(house.getCodeServices());

                System.out.println("After Booking : ");
                Customer_Service.show_Customer();

                Read_Write_File.write_File(PATH,Customer_Service.customerArrayList.get(number_Customer-1).toString()+","+house.toString());

                break;
            case 3:
                Room_Service.show_Room();
                System.out.println("Choose Number Service :");
                number_Service = Integer.parseInt(scanner.nextLine());

                String room = Room_Service.roomArrayList.get(number_Service-1).getCodeServices();
                Customer_Service.customerArrayList.get(number_Customer-1).setUse_Service(room);

                System.out.println("After Booking : ");
                Customer_Service.show_Customer();
                Read_Write_File.write_File(PATH,Customer_Service.customerArrayList.get(number_Customer-1).toString()+","+room.toString());

                break;
            default:break;
        }
//        String data=Customer_Service.customerArrayList.get(number_Customer).toString();
//        Read_Write_File.write_File(PATH,data);
//        Read_Write_File.write_File(Customer_Service.PATH,data);
//        System.out.println("Success !");
    }
}
