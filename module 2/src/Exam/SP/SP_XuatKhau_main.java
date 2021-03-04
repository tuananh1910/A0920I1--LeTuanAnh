package Exam.SP;

import Exam.Common.Input_Common;
import Exam.Common.Read_Write;
import Exam.Models.SP_XKhau;

import java.util.ArrayList;
import java.util.Scanner;

public class SP_XuatKhau_main {
    private static final String PATH = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\Exam\\Data\\xuatkhau.csv";
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<SP_XKhau> sp_xKhauArrayList = new ArrayList<>();

    public static void nhap_thong_tin_SP_XuatKhau() {
        SP_XKhau sp_xKhau = (SP_XKhau) Input_Common.input_Product(2);

        double gia_NK;
        String quoc_gia_nhap_SP;

        do {
            System.out.println("Nhap gia xuat khau :");
            gia_NK = scanner.nextDouble();
        } while (gia_NK < 0);
        assert sp_xKhau != null;
        sp_xKhau.setGia_XKhau(gia_NK);
        scanner.nextLine();

        System.out.println("Nhap quoc gia nhap san pham:");
        quoc_gia_nhap_SP = scanner.nextLine();
        sp_xKhau.setQuoc_gia_nhap_san_pham(quoc_gia_nhap_SP);

        sp_xKhauArrayList.add(sp_xKhau);

        Read_Write.write_File(PATH, sp_xKhau.toString(), true);

        System.out.println("Success !");

    }

    public static void hien_thi_SPXK() {
        for (SP_XKhau value : sp_xKhauArrayList) {
            System.out.println(value.hien_thi());
        }
    }

    public static void xoa_SPXK() {
//        hien_thi_SPXK();
//        System.out.println("Chon so san pham muon xoa :");
//        int number = scanner.nextInt();
//        scanner.nextLine();
//        sp_xKhauArrayList.remove(number+1);
//        Read_Write.write_File(PATH,sp_xKhauArrayList.toString(),false);

//        System.out.println("danh sach san pham sau khi xoa");
//        hien_thi_SPXK();
        hien_thi_SPXK();
        System.out.println("Nhap ma san pham muon xoa");
        String ma_SP_Xoa = scanner.nextLine();
        for (int i = 0; i < sp_xKhauArrayList.size(); i++) {
            if (sp_xKhauArrayList.get(i).getMa_san_pham().equals(ma_SP_Xoa)) {
                sp_xKhauArrayList.remove(i);
                break;
            } else {
                System.out.println("is not found !");
            }
        }
        Read_Write.write_File(PATH, sp_xKhauArrayList.toString(), false);
        System.out.println("sau khi xoa :");
        hien_thi_SPXK();

    }

    public static void tim_kiem() {
        System.out.println("Nhap ma san pham muon tim kiem");
        String ma_SP_Tim_Kiem = scanner.nextLine();

        for (int i = 0; i < sp_xKhauArrayList.size(); i++) {
            if (sp_xKhauArrayList.get(i).getMa_san_pham().equals(ma_SP_Tim_Kiem)) {
                System.out.println(sp_xKhauArrayList.get(i).hien_thi());
                break;
            } else {
                System.out.println("is not found !");
            }
        }
    }
}
