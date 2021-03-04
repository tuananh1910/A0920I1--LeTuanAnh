package Exam.Controllers;

import Exam.SP.SP_NhapKhau_main;
import Exam.SP.SP_XuatKhau_main;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean out_menu = true;

    public static void main(String[] args) {
        do {
            System.out.println("Menu: " + "\n" +
                    "1. Them moi " + "\n" +
                    "2. Xoa" + "\n" +
                    "3. Xem danh sach cac san pham :" + "\n" +
                    "4. Tim kiem: " + "\n" +
                    "5. Thoat");
            System.out.println("Chon chuc nang");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    them_moi_SP();
                    break;
                case 2:
                    xoa_SP();
                    break;
                case 3:
                    hien_thi_sp();
                    break;
                case 4:
                    tim_kiem();
                    break;
                case 5:
                    out_menu = false;
                    break;

            }
        } while (out_menu);
    }

    private static void tim_kiem() {
        System.out.println("1. tim keim san pham nhap khau :" + "\n" +
                "2. tim kiem san pham xuat khau");
        int number = scanner.nextInt();
        scanner.nextLine();
        switch (number) {
            case 1:
                SP_NhapKhau_main.tim_kiem();
                break;
            case 2:
                SP_XuatKhau_main.tim_kiem();
                break;
            default:
                break;

        }
    }

    private static void hien_thi_sp() {
        System.out.println("1. hien thi san pham nhap khau :" + "\n" +
                "2. hien thi san pham xuat khau");
        int number = scanner.nextInt();
        scanner.nextLine();
        switch (number) {
            case 1:
                SP_NhapKhau_main.hien_thi_SPNK();
                break;
            case 2:
                SP_XuatKhau_main.hien_thi_SPXK();
                break;
            default:
                break;
        }
    }

    public static void them_moi_SP() {
        System.out.println("1. them san pham nhap khau :" + "\n" +
                "2. them san pham xuat khau");
        int number = scanner.nextInt();
        scanner.nextLine();
        switch (number) {
            case 1:
                SP_NhapKhau_main.nhap_thong_tin_SP_NhapKhau();
                break;
            case 2:
                SP_XuatKhau_main.nhap_thong_tin_SP_XuatKhau();
                break;
            default:
                break;
        }
    }

    public static void xoa_SP() {
        System.out.println("1. xoa san pham nhap khau :" + "\n" +
                "2. xoa san pham xuat khau");
        int number = scanner.nextInt();
        scanner.nextLine();
        switch (number) {
            case 1:
                SP_NhapKhau_main.xoa_SPNK();
                break;
            case 2:
                SP_XuatKhau_main.xoa_SPXK();
                break;
            default:
                break;
        }
    }
}
