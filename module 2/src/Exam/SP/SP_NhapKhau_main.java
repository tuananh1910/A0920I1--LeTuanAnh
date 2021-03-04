package Exam.SP;

import Exam.Common.Input_Common;
import Exam.Common.Read_Write;
import Exam.Models.SP_NKhau;

import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SP_NhapKhau_main {
    private static final String PATH = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\Exam\\Data\\nhapkhau.csv";
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<SP_NKhau> sp_nKhauArrayList = new ArrayList<>();

    public static void nhap_thong_tin_SP_NhapKhau() {
        SP_NKhau sp_nhapKhau = (SP_NKhau) Input_Common.input_Product(1);

        double gia_NK;
        do {
            System.out.println("Nhap gia nhap khau :");
            gia_NK = scanner.nextDouble();

        } while (gia_NK < 0);
        sp_nhapKhau.setGia_NKhau(gia_NK);
        scanner.nextLine();

        String tinh_thanh_Nhap;
        System.out.println("Nhap tinh thanh nhap");
        tinh_thanh_Nhap = scanner.nextLine();
        sp_nhapKhau.setTinh_thanh_nhap(tinh_thanh_Nhap);

        double thue_NK;
        do {
            System.out.println("Nhap thue nhap khau :");
            thue_NK = scanner.nextDouble();
        } while (thue_NK < 0);
        sp_nhapKhau.setThue_nhap_khau(thue_NK);
        scanner.nextLine();

        sp_nKhauArrayList.add(sp_nhapKhau);

        Read_Write.write_File(PATH, sp_nhapKhau.toString(), true);

        System.out.println("Success");
    }

    public static void hien_thi_SPNK() {
        for (SP_NKhau value : sp_nKhauArrayList) {
            System.out.println(value.hien_thi());
        }
    }

    public static void xoa_SPNK() {
//        hien_thi_SPNK();
//        System.out.println("Chon so san pham muon xoa :");
//        int number = scanner.nextInt();
//        scanner.nextLine();
//        sp_nKhauArrayList.remove(number+1);
//        Read_Write.write_File(PATH,sp_nKhauArrayList.toString(),false);
//        System.out.println("danh sach san pham sau khi xoa");
//        hien_thi_SPNK();

        hien_thi_SPNK();
        System.out.println("Nhap ma san pham muon xoa");
        String ma_SP_Xoa = scanner.nextLine();
        for (int i = 0; i < sp_nKhauArrayList.size(); i++) {
            if (sp_nKhauArrayList.get(i).getMa_san_pham().equals(ma_SP_Xoa)) {
                sp_nKhauArrayList.remove(i);
                break;
            } else {
                System.out.println("is not found !");
            }
        }
//        Read_Write.write_File(PATH, sp_nKhauArrayList.toString(), false);
        for (SP_NKhau value : sp_nKhauArrayList){
            Read_Write.write_File(PATH, value.toString(),false);
        }
        System.out.println("sau khi xoa :");
        hien_thi_SPNK();
    }

    public static void tim_kiem() {
        System.out.println("Nhap ma san pham muon tim kiem");
        String ma_SP_Tim_Kiem = scanner.nextLine();

        for (int i = 0; i < sp_nKhauArrayList.size(); i++) {
            if (sp_nKhauArrayList.get(i).getMa_san_pham().equals(ma_SP_Tim_Kiem)) {
                System.out.println(sp_nKhauArrayList.get(i).hien_thi());
                break;
            } else {
                System.out.println("is not found !");
            }
        }
    }
}
