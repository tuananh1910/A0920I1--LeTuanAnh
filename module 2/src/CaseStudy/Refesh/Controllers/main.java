package CaseStudy.Refesh.Controllers;

import CaseStudy.Refesh.Service.*;

import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);
    static boolean out_Menu = true;    // biến check để exit menu
    public static void main(String[] args)  {
        Villa_Service.get_On_Data_Villa();
        House_Service.get_On_Data_House();
        Room_Service.get_On_Data_Room();
        Customer_Service.get_On_Data_Customer();
        display_Menu();  // goi method display_Menu

    }
    public static void display_Menu() { // method hien ra trinh don menu

        System.out.println("-----------MENU--------------");
        do { // cho phép người dùng chọn chức năng
            System.out.println( "1.Add New Services \n" +
                    "2.Show Services\n 3.Add New Customer\n" +
                    "4.Show Information of Customer\n 5.Add New Booking\n" +
                    "6. Show Information of Employee\n 7. Exit");

            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    add_New_Service();
                    break;
                case 2:
                    show_Services();
                    break;
                case 3:
                    Customer_Service.add_New_Customer();
                    break;
                case 4:
                    Customer_Service.show_Customer();
                    break;
                case 5:
                    Booking_Service.add_New_Booking();
                    break;
                case 6:
                    Employee_Service.show_Information_Of_Employee();
                    break;
                case 7:
                    out_Menu = false;
                    break;
                default:
                    break;
            }
        } while (out_Menu);
    }
    public static void add_New_Service()  {  // thêm mới 1 service
        do {  // hiện ra trình đơn service bao gồm villa house và room
            System.out.println("Menu\n 1.Add New Villa \n" +
                    "2.Add New House\n 3.Add New Room\n" +
                    "4.Back to Menu\n 5.Exit");
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    Villa_Service.input_Villa();
                    break;
                case 2:
                    House_Service.input_House();
                    break;
                case 3:
                    Room_Service.input_Room();
                    break;
                case 4:
                    display_Menu();
                    break;
                case 5:
                    out_Menu = false;
                    break;
                default:
                    break;
            }
        } while (out_Menu);
    }
    public static void show_Services() {   // hiện thị ra trình đơn cho phép xem tất cả các thông tin về từng loại service
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
                    Villa_Service.show_Villa();
                    break;
                case 2:
                    House_Service.show_House();
                    break;
                case 3:
                    Room_Service.show_Room();
                    break;
                case 4:
                    Villa_Service.show_Villa_Not_Duplicate();
                    break;
                case 5:
                    House_Service.show_House_Not_Duplicate();
                    break;
                case 6:
                    Room_Service.show_Room_Not_Duplicate();
                    break;
                case 7:
                    display_Menu();
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
