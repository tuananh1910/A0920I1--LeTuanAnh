package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Comparator;
import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Common.Regex;
import CaseStudy.Refesh.Common.Get_Data;
import CaseStudy.Refesh.Models.Customer;
import CaseStudy.Refesh.User_Exception.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Customer_Service {
    // đường dẫn PATH của file customer.csv
    public static final String PATH ="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Customer.csv" ;
    private static final Scanner scanner = new Scanner(System.in);
    public static  ArrayList<Customer> customerArrayList = new ArrayList<>(); // list quản lí các đối tượng kiểu customer
    static Comparator comparator = new Comparator();
    public static void add_New_Customer() {
        // nhập tất cả thông tin của customer
        System.out.println("Enter information customer :");
        String name;
        while (true) {
            try {
                System.out.println("Name :");
                name = scanner.nextLine();
                name += " ";
                if (Name_Exception.name_Exeption(name)) {
                    break;
                }
            } catch (Name_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String date;
        while (true) {
            try {
                System.out.println("Date : ");
                date = scanner.nextLine();
                if (Birthday_Exception.birthday_Exception(date)) {
                    break;
                }
            } catch (Birthday_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String gender;
        do {
            System.out.println("Gender : ");
            gender = scanner.nextLine();
            gender = gender.substring(0, 1).toUpperCase()
                    + gender.substring(1).toLowerCase();
        } while (!Gender_Exception.gender_Exeption(gender));

        String identity_Card;
        while (true) {
            try {
                System.out.println("Identity card : ");
                identity_Card = scanner.nextLine();
                identity_Card += " ";
                if (Id_Card_Exception.id_Card_Exception(identity_Card)) {
                    break;
                }
            } catch (Id_Card_Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int phone_Number;
        do {
            System.out.println("Phone Number :");
            phone_Number = scanner.nextInt();
        }while (Regex.check_Number_Int(String.valueOf(phone_Number)));
        scanner.nextLine();

        String email;
        while (true){
            try{
                System.out.println("Email :");
                email = scanner.nextLine();
                if (Email_Exception.email_Exeption(email)){
                    break;
                }
            }catch (Email_Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Type customer : ");
        String type_Customer = scanner.nextLine();

        System.out.println("Address : ");
        String address = scanner.nextLine();

        Customer customer = new Customer(name,date,gender,identity_Card
        ,phone_Number,email,type_Customer,address,null);
        // sau khi add vào list customer thì sẽ tiến hành ghi vào file customer.csv
        customerArrayList.add(customer);

        Collections.sort(customerArrayList, comparator);
// nghi bug !

            Read_Write_File.write_File(PATH,customer.toString());

        System.out.println("Success !");

    }
    public static void show_Customer(){
//        customerArrayList = Get_Data.get_Data_Customer();
        int index=0;
        for (Customer customer : customerArrayList){
            System.out.println(customer.showInfor(index));
            index++;
        }
    }

    public static void get_On_Data_Customer(){
        customerArrayList = Get_Data.get_Data_Customer();
    }
}
