package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Regex;
import CaseStudy.Refesh.Models.House;
import CaseStudy.Refesh.Models.Room;
import CaseStudy.Refesh.Models.Services;
import CaseStudy.Refesh.Models.Villa;

import java.util.Scanner;

public class Common_Service {
    static Scanner scanner = new Scanner(System.in);

    public static Services input_Service(int number) { // phương thức này để nhập tất cả các thuộc tính chung và các service
        System.out.println("Enter Information Service :");
        String id_Service;
        do {
            System.out.println("Enter ID Service");
            id_Service = scanner.nextLine();
        } while (!Regex.check_Id_Service(id_Service, number));
        String name_Service;
        do {
            System.out.println("Enter Name Service");
            name_Service = scanner.nextLine();
        }
        while (Regex.check_Service(name_Service));

        StringBuilder alert = new StringBuilder();

        double area_Use;
        boolean check_use;
        do {
            System.out.println("Area will use:");
            area_Use = scanner.nextDouble();
            check_use = Regex.check_Number_Double(String.valueOf(area_Use));
            if (check_use) {
                alert.append("ban phai nhap dung kieu du lieu");
            } else {
                if (area_Use > 30) {
                    break;
                } else {
                    alert.append("Area >30");
                }
            }
            System.out.println(alert);
            alert = new StringBuilder();
        } while (true);

        double price;
        do {
            System.out.println("Price :");
            price = scanner.nextDouble();
            if (Regex.check_Number_Double(String.valueOf(price))) {
                alert.append("Ban phai nhap dung kieu du lieu !");
            } else {
                if (price > 0) {
                    break;
                } else {
                    alert.append("Price >0");
                }
            }
            System.out.println(alert);
            alert = new StringBuilder();
        } while (true);

        int max_People;
        boolean check_People;
        do {
            System.out.println("Max number of people :");
            max_People = scanner.nextInt();
            check_People = Regex.check_Number_Int(String.valueOf(max_People));
            if (check_People) {
                alert.append("Ban phai nhap dung kieu du lieu , so duong!");
            }
            else {
                if (max_People > 20) {
                    alert.append("So nguoi phai <20");
                }
                else {
                    break;
                }

            }
            System.out.println(alert);
            alert = new StringBuilder();
        } while (true);

        scanner.nextLine();
        String rental_Type;
        do {
            System.out.println("Rental Type :");
            rental_Type = scanner.nextLine();
            if (Regex.check_Service(rental_Type)){
                alert.append("Ban phai nhap dung kieu du lieu !");
            }
            else {
                break;
            }
            System.out.println(alert);
            alert = new StringBuilder();
        } while (true);
        // trả về 1 đối tượng
        switch (number) {
            case 1:
                return new Villa(id_Service, name_Service, area_Use, price
                        , max_People, rental_Type);
            case 2:
                return new House(id_Service, name_Service, area_Use, price
                        , max_People, rental_Type);
            case 3:
                return new Room(id_Service, name_Service, area_Use, price
                        , max_People, rental_Type);
        }
        return null;
    }

}
