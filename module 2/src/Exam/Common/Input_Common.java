package Exam.Common;


import Exam.Models.SP;
import Exam.Models.SP_NKhau;
import Exam.Models.SP_XKhau;

import java.util.Scanner;

public class Input_Common {
    static Scanner scanner = new Scanner(System.in);
    static int ID_NK = 0;
    static int ID_XK = 0;
    public static SP input_Product(int number){
        System.out.println("Nhap thong tin san pham :");
         // ID san pham tu tang
         String ma_SP;
         String ten_SP;
         double gia;
         int so_luong;
         String nha_SX;

        System.out.println("Nhap ma san pham : ");
        ma_SP = scanner.nextLine();

        System.out.println("nhap ten san pham :");
        ten_SP = scanner.nextLine();

        do {
            System.out.println("Nhap gia: ");
            gia = scanner.nextDouble();
        }
        while (gia<0);
        scanner.nextLine();

        do {
            System.out.println("nhap so luong :");
            so_luong = scanner.nextInt();
        }      while (so_luong<0);

        scanner.nextLine();

        System.out.println("nhap nha san xuat :");
        nha_SX = scanner.nextLine();

        switch (number){
            case 1:
                ID_NK ++;
                return new SP_NKhau((ID_NK),ma_SP,ten_SP,gia,so_luong,nha_SX) ;
            case 2:
                ID_XK++;
                return new SP_XKhau((ID_XK),ma_SP,ten_SP,gia,so_luong,nha_SX) ;
        }
        return null;

    }
}
