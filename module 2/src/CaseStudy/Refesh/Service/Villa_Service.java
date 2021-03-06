package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Common.Regex;
import CaseStudy.Refesh.Common.Get_Data;
import CaseStudy.Refesh.Models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

public class Villa_Service {
    static ArrayList<Villa> villaArrayList = new ArrayList<>(); // 1 arraylist để quản lí các đối tượng kiểu villa
    static Scanner scanner = new Scanner(System.in);
    static String PATH ="E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Villa.csv"; // đường dẫn để đọc ghi file
    public static void input_Villa() {
        //gọi phương thức input service
        Villa villa = (Villa) Common_Service.input_Service(1);
        // villa đã được nhập thông tin chung nhất bên service .
        // nhập thêm thông tin chỉ villa mới có
        // set tất cả các thuộc tính đó cho villa
        StringBuilder alert = new StringBuilder();

        String standard_Room;
        do {
            System.out.println("Standard Room:");
            standard_Room = scanner.nextLine();
            if (Regex.check_Service(standard_Room)){
                alert.append("Ban phai nhap dung kieu du lieu ");
            }
            else {
                break;
            }
            System.out.println(alert);
            alert = new StringBuilder();
        } while (true);

        assert villa != null;
        villa.setStandard_Room(standard_Room);

        System.out.println("Description :");
        String description = scanner.nextLine();
        villa.setDescription(description);

        double pool_Area;
        do {
            System.out.println("Pool Area :");
            pool_Area = scanner.nextDouble();
            if (Regex.check_Number_Double(String.valueOf(pool_Area))){
                alert.append("ban phai nhap dung kieu du lieu ");
            }
            else {
                if (pool_Area>30){
                    break;
                }
                else {
                    alert.append("pool area >30");
                }
            }
            System.out.println(alert);
            alert= new StringBuilder();
        } while (true);
        villa.setPool_Area(pool_Area);


        int number_Of_Floor;
        do {
            System.out.println("Number Of Floor");
            number_Of_Floor = scanner.nextInt();
            if (Regex.check_Number_Int(String.valueOf(number_Of_Floor))){
                alert.append("Ban phai nhap dung kieu du lieu ");
            }
            else {
                if (number_Of_Floor>0){
                    break;
                }
                else {
                    alert.append("so tang >0");
                }
            }
            System.out.println(alert);
            alert= new StringBuilder();
        }while (true);
        villa.setNumber_Of_Floors(number_Of_Floor);
//        scanner.nextLine();
        villaArrayList.add(villa); // rồi thêm đối tượng villa vào list villa để quản lí
        // ghi thông tin của villa đã được thêm ở array list vào file villa.csv

        Read_Write_File.write_File(PATH,villa.toString());

        System.out.println("Success !");


    }
    public static void show_Villa() {
        // hiện thị tất cả thông tin của dịch vụ villa
        for (Villa villa : villaArrayList){
            System.out.println(villa.showInfor());
        }
    }
    public static void show_Villa_Not_Duplicate(){

    }

    public static void get_On_Data_Villa(){
        // sau khi khởi động lại display_menu thì dữ liệu villa sẽ được gọi lên arraylist .
        villaArrayList = Get_Data.get_Data_Villa();
    }

}