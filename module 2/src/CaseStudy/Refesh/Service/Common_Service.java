package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Regex;
import CaseStudy.Refesh.Models.House;
import CaseStudy.Refesh.Models.Room;
import CaseStudy.Refesh.Models.Services;
import CaseStudy.Refesh.Models.Villa;

import java.util.Scanner;

public class Common_Service {
    static Scanner scanner=  new Scanner(System.in);
    public static Services input_Service(int number){ // phương thức này để nhập tất cả các thuộc tính chung và các service
        System.out.println("Enter Information Service :");
        String id_Service;
        do {
            System.out.println("Enter ID Service");
            id_Service = scanner.nextLine();
        }while (!Regex.check_Id_Service(id_Service,number));
        String name_Service;
        do {
            System.out.println("Enter Name Service");
            name_Service=scanner.nextLine();
        }
        while (Regex.check_Service(name_Service));
        double area_Use;
        boolean check;
        do {
            System.out.println("Area will use:");
            area_Use = scanner.nextDouble();
            check = !Regex.check_Number_Double(String.valueOf(area_Use))&& area_Use<30;
        }while (check);
        double price;
        do {
            System.out.println("Price :");
            price = scanner.nextDouble();
        } while (!Regex.check_Number_Double(String.valueOf(price))&&price<0);
        int max_People;
        do {
            System.out.println("Max number of people :");
            max_People = scanner.nextInt();
        } while (!Regex.check_Number_Double(String.valueOf(max_People))
                && max_People < 20);
        scanner.nextLine();
        String rental_Type;
        do {
            System.out.println("Rental Type :");
            rental_Type = scanner.nextLine();
        } while (Regex.check_Service(rental_Type));
        // trả về 1 đối tượng
        switch (number){
            case 1:
                return new Villa(id_Service,name_Service,area_Use,price
                ,max_People,rental_Type);
            case 2:
                return new House(id_Service,name_Service,area_Use,price
                        ,max_People,rental_Type);
            case 3:
                return new Room(id_Service,name_Service,area_Use,price
                        ,max_People,rental_Type);
        }
        return null;
    }

}
