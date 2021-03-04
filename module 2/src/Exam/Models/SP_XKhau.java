package Exam.Models;

public class SP_XKhau extends SP {
    private double gia_XKhau;
    private String quoc_gia_nhap_san_pham;

    public SP_XKhau(int id_san_pham, String ma_san_pham, String ten_san_pham,
                    double gia_ca, int soluong, String nha_san_xuat,
                    double gia_XKhau, String quoc_gia_nhap_san_pham) {
        super(id_san_pham, ma_san_pham, ten_san_pham, gia_ca, soluong, nha_san_xuat);
        this.gia_XKhau = gia_XKhau;
        this.quoc_gia_nhap_san_pham = quoc_gia_nhap_san_pham;
    }

    public SP_XKhau(int i, String ma_sp, String ten_sp, double gia, int so_luong, String nha_sx) {
        super(i, ma_sp, ten_sp, gia, so_luong, nha_sx);
    }

    public double getGia_XKhau() {
        return gia_XKhau;
    }

    public void setGia_XKhau(double gia_XKhau) {
        this.gia_XKhau = gia_XKhau;
    }

    public String getQuoc_gia_nhap_san_pham() {
        return quoc_gia_nhap_san_pham;
    }

    public void setQuoc_gia_nhap_san_pham(String quoc_gia_nhap_san_pham) {
        this.quoc_gia_nhap_san_pham = quoc_gia_nhap_san_pham;
    }

    @Override
    public String toString() {
        return super.getId_san_pham() + "," +
                super.getMa_san_pham() + "," +
                super.getTen_san_pham() + "," +
                super.getGia_ca() + "," +
                super.getNha_san_xuat() + "," +
                this.getGia_XKhau() + "," +
                this.getQuoc_gia_nhap_san_pham();
    }

    public String hien_thi() {
        return
                "Id san pham : " + super.getId_san_pham() + "\n" +
                        "ma san pham :" + super.getMa_san_pham() + "\n" +
                        "ten san pham :" + super.getTen_san_pham() + "\n" +
                        "gia ca :" + super.getGia_ca() + "\n" +
                        "nha san xuat :" + super.getNha_san_xuat() + "\n" +
                        "gia xuat khau :" + this.getGia_XKhau() + "\n" +
                        "quoc gia nhap san pham :" + this.getQuoc_gia_nhap_san_pham() + "\n";
    }
}
