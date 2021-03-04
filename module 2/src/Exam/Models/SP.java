package Exam.Models;

public abstract class SP {
    private int id_san_pham;
    private String ma_san_pham;
    private String ten_san_pham;
    private double gia_ca;
    private int soluong;
    private String nha_san_xuat;

    public SP() {
    }

    public int getId_san_pham() {
        return id_san_pham;
    }

    public void setId_san_pham(int id_san_pham) {
        this.id_san_pham = id_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public double getGia_ca() {
        return gia_ca;
    }

    public void setGia_ca(double gia_ca) {
        this.gia_ca = gia_ca;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNha_san_xuat() {
        return nha_san_xuat;
    }

    public void setNha_san_xuat(String nha_san_xuat) {
        this.nha_san_xuat = nha_san_xuat;
    }

    public String getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(String ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public SP(int id_san_pham, String ma_san_pham, String ten_san_pham,
              double gia_ca, int soluong, String nha_san_xuat) {
        this.id_san_pham = id_san_pham;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.gia_ca = gia_ca;
        this.soluong = soluong;
        this.nha_san_xuat = nha_san_xuat;
    }

    public abstract String hien_thi();
}
