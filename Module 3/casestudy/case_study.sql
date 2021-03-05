drop database if exists case_study;
create database case_study;
use case_study;
create table viTri(
	IDViTri int primary key unique not null,
    tenViTri varchar(45) not null
);

create table trinhDo(
	IDTrinhDo int primary key unique not null,
    TrinhDo varchar(45) not null
);

create table boPhan(
	IDBoPhan int primary key unique not null,
    tenBoPhan varchar(45) not null
);
create table LoaiKhach(
	IDLoaiKhach int primary key unique not null,
    TenLoaiKhach varchar(45) not null
);
create table KieuThue(
	IDKieuThue int primary key unique not null,
    TenKieuThue varchar(45),
    Gia int
);
create table LoaiDichVu(
	IDLoaiDichVu int not null,
    TenLoaiDichVu varchar(45) not null
);
create table DichVuDiKem(
	IDDichVuDiKem int primary key unique not null,
    TenDichVuDiKem varchar(45) not null,
    Gia int not null,
    DonVi int not null,
    TrangThaiKhaDung varchar(45) not null
);


create table NhanVien(
	IDNhanVien int primary key unique not null,
    HoTenNhanVien varchar(30) not null,
    IDViTri int  not null,
    IDTrinhDo int not null,
    IDBoPhan int not null,
    NgaySinh date not null,
    SoCMND varchar(45) not null,
    Luong varchar(45) not null,
    SDT varchar(45) not null,
    Email varchar(45) not null,
    DiaChi varchar(45) not null,
    foreign key(IDViTri)references Vitri(IDViTri),
    foreign key(IDTrinhDo)references TrinhDo(IDTrinhDo),
    foreign key(IDBoPhan)references BoPhan(IDBoPhan)
);
create table KhachHang(
	IDKhachHang int primary key unique not null,
    IDLoaiKhach int not null,
    HoTen varchar(45) not null,
    NgaySinh date not null,
    SoCMND varchar(45) not null,
    Email varchar(45) not null,
    DiaChi varchar(45) not null,
    foreign key(IDLoaiKhach)references LoaiKhach(IDLoaiKhach)
);


create table HopDong(
	IDHopDong int primary key unique not null,
    IDNhanVien int  not null,
    IDKhachHang int not null,
    IDDichVu int not null,
    NgayLamHopDong date not null,
    NgayKetThucHopDong date not null,
    TienDatCoc int not null,
    TongTien int  not null,
    foreign key (IDKhachHang) references KhachHang(IDKhachHang),
    foreign key (IDNhanVien) references NhanVien(IDNhanVien),
    foreign key (IDDichVu) references DichVu(IDDichVu)
);

create table HopDongChiTiet(
	IDHopDongChiTiet int primary key unique not null,
    IDHopDong int not null,
    IDDichVuDiKem int not null,
    SoLuong int not null,
    foreign key (IDHopDong) references HopDong(IDHopDong),
    foreign key(IDDichVuDiKem)references DichVuDiKem(IDDichVuDiKem)
);

create table DichVu(
	IDDichVu int primary key not null ,
    TenDichVu varchar (45) not null,
    DienTich int not null,
    SoTang int not null,
    SoNguoiToiDa int not null,
    ChiPhiThue varchar(45) not null,
    IDKieuThue int not null,
    IDLoaiDichVu int not null,
    TrangThai varchar(45) not null,
    foreign key(IDKieuThue)references KieuThue(IDKieuThue),
    foreign key (IDLoaiDichVu)references LoaiDichVu(IDLoaiDichVu)
);



