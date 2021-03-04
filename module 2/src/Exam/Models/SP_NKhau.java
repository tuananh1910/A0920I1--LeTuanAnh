package Exam.Models;

public class SP_NKhau extends SP {
    private double gia_NKhau;
    private String tinh_thanh_nhap;
    private double thue_nhap_khau;

    public SP_NKhau(int id_san_pham, String ma_san_pham, String ten_san_pham,
                    double gia_ca, int soluong, String nha_san_xuat,
                    double gia_NKhau, String tinh_thanh_nhap,
                    double thue_nhap_khau) {
        super(id_san_pham, ma_san_pham, ten_san_pham, gia_ca, soluong, nha_san_xuat);
        this.gia_NKhau = gia_NKhau;
        this.tinh_thanh_nhap = tinh_thanh_nhap;
        this.thue_nhap_khau = thue_nhap_khau;
    }

    public SP_NKhau(int i, String ma_sp, String ten_sp, double gia, int so_luong, String nha_sx) {
        super(i, ma_sp, ten_sp, gia, so_luong, nha_sx);
    }



    public double getGia_NKhau() {
        return gia_NKhau;
    }

    public void setGia_NKhau(double gia_NKhau) {
        this.gia_NKhau = gia_NKhau;
    }

    public String getTinh_thanh_nhap() {
        return tinh_thanh_nhap;
    }

    public void setTinh_thanh_nhap(String tinh_thanh_nhap) {
        this.tinh_thanh_nhap = tinh_thanh_nhap;
    }

    public double getThue_nhap_khau() {
        return thue_nhap_khau;
    }

    public void setThue_nhap_khau(double thue_nhap_khau) {
        this.thue_nhap_khau = thue_nhap_khau;
    }

    @Override
    public String toString() {
        return super.getId_san_pham() + "," +
                super.getMa_san_pham() + "," +
                super.getTen_san_pham() + "," +
                super.getGia_ca() + "," +
                super.getNha_san_xuat() + "," +
                this.getGia_NKhau() + "," +
                this.getTinh_thanh_nhap() + "," +
                this.getThue_nhap_khau();
    }

    public String hien_thi() {
        return
                "Id san pham : " + super.getId_san_pham() + "\n" +
                "ma san pham :" + super.getMa_san_pham() + "\n" +
                "ten san pham :" + super.getTen_san_pham() + "\n" +
                "gia ca :" + super.getGia_ca() + "\n" +
                "nha san xuat :" + super.getNha_san_xuat() + "\n" +
                "gia ca nhap khau :" + this.getGia_NKhau() + "\n" +
                "tinh thanh nhap :" + this.getTinh_thanh_nhap() + "\n" +
                "thue nhap khau : " + this.getThue_nhap_khau() + "\n";
    }

}
