package CaseStudy.Task.Controllers.Customer;

import CaseStudy.Task.Controllers.Comparator.Comparator;
import CaseStudy.Task.Controllers.User_Exception.*;
import CaseStudy.Task.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task.Models.Customer.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Customer_Main {
     Name_Exception name_exception = new Name_Exception();
     Email_Exception email_exception = new Email_Exception();
     Gender_Exception gender_exception = new Gender_Exception();
     Id_Card_Exception id_card_exception = new Id_Card_Exception();
     Birthday_Exception birthday_exception = new Birthday_Exception();
     Scanner scanner = new Scanner(System.in);
     Write_Read_File write_read_file = new Write_Read_File();
    Comparator comparator = new Comparator();
    public void add_New_Customer(ArrayList<Customer> customers, final String PATH) throws IOException {
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
            string +=  customers.get(index).getName()+","+
                    customers.get(index).getDate()+","+
                    customers.get(index).getGender()+","+
                    customers.get(index).getIndentity_Card()+","+
                    customers.get(index).getPhone_Number()+","+
                    customers.get(index).getEmail()+","+
                    customers.get(index).getType_Customer()+","+
                    customers.get(index).getAddress()+","+
                    customers.get(index).getUse_Service()+"\n";
        }
        System.out.println(PATH + "\\Customer.csv");
        write_read_file.write_File(PATH + "\\Customer.csv", string);
    }

    // show information of custumer
    public void show_Information_Of_Custumer(ArrayList<Customer> customers) {
        for (int index = 0; index < customers.size(); index++) {
            System.out.println(customers.get(index).showInfor(index));
        }
    }
}
