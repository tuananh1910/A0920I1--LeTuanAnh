drop database if exists case_study;
create database case_study;
use case_study;
create table ViTri(
	IDViTri int primary key unique not null,
    tenViTri varchar(45) not null
);

create table TrinhDo(
	IDTrinhDo int primary key unique not null,
    TrinhDo varchar(45) not null
);

create table BoPhan(
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
	IDLoaiDichVu int primary key not null,
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
    DiaChi varchar(45) not null
);
create table KhachHang(
	IDKhachHang int primary key unique not null,
    IDLoaiKhach int not null,
    HoTen varchar(45) not null,
    NgaySinh date not null,
    SoCMND varchar(45) not null,
    Email varchar(45) not null,
    DiaChi varchar(45) not null
);
create table DichVu(
	IDDichVu int primary key not null ,
    TenDichVu varchar (45) not null,
    DienTich int not null,
    SoTang int not null,
    SoNguoiToiDa int not null,
    ChiPhiThue int not null,
    IDKieuThue int not null,
    IDLoaiDichVu int not null,
    TrangThai varchar(45) not null
);
create table HopDong(
	IDHopDong int primary key unique not null,
    IDNhanVien int  not null,
    IDKhachHang int not null,
    IDDichVu int not null,
    NgayLamHopDong date not null,
    NgayKetThucHopDong date not null,
    TienDatCoc int not null,
    TongTien int not null
);

create table HopDongChiTiet(
	IDHopDongChiTiet int primary key unique not null,
    IDHopDong int not null,
    IDDichVuDiKem int not null,
    SoLuong int not null
);

-- set foreign key cho cac table
alter table NhanVien
	add constraint fk_IDViTri foreign key(IDViTri)references Vitri(IDViTri),
	add constraint fk_IDTrinhDo foreign key(IDTrinhDo)references TrinhDo(IDTrinhDo),
	add constraint fk_IDBoPhan foreign key(IDBoPhan)references BoPhan(IDBoPhan);
  
alter table KhachHang
	add constraint fk_IDLoaiKhach foreign key(IDLoaiKhach)references LoaiKhach(IDLoaiKhach);

alter table DichVu
	add constraint fk_IDKieuThue foreign key(IDKieuThue)references KieuThue(IDKieuThue),
    add constraint fk_IDLoaiDichVu foreign key (IDLoaiDichVu)references LoaiDichVu(IDLoaiDichVu);

alter table HopDong
	add constraint fk_IDKhachHang foreign key (IDKhachHang) references KhachHang(IDKhachHang),
	add constraint fk_IDNhanVien foreign key (IDNhanVien) references NhanVien(IDNhanVien),
    add constraint fk_IDDichVu	foreign key (IDDichVu) references DichVu(IDDichVu);

alter table HopDongChiTiet
	add constraint fk_IDHopDong foreign key (IDHopDong) references HopDong(IDHopDong),
	add	constraint fk_IDDichVuDiKem	foreign key(IDDichVuDiKem)references DichVuDiKem(IDDichVuDiKem);

-- them moi thong tin
-- table BoPhan
INSERT INTO BoPhan VALUES ('1', 'CSKH');
INSERT INTO BoPhan VALUES ('2', 'Marketing');
INSERT INTO BoPhan VALUES ('3', 'Manufacturing');
-- table trinh do
INSERT INTO TrinhDo VALUES ('1', 'Dai Hoc');
INSERT INTO TrinhDo VALUES ('2', 'Dai Hoc');
INSERT INTO TrinhDo VALUES ('3', 'Dai Hoc');
-- table vi tri
INSERT INTO ViTri VALUES ('1', 'Employee');
INSERT INTO ViTri VALUES ('2', 'Employ');
INSERT INTO ViTri VALUES ('3', 'Manage');

-- table dich vu di kem
INSERT INTO DichVuDiKem VALUES ('1', 'Buffet', '10', '5', 'on');
INSERT INTO DichVuDiKem VALUES ('2', 'Rent Car', '50', '25', 'on');
INSERT INTO DichVuDiKem VALUES ('3', 'Party', '100', '50', 'on');
-- table kieu thue
INSERT INTO KieuThue VALUES ('1', 'Villa', '500');
INSERT INTO KieuThue VALUES ('2', 'Home', '300');
INSERT INTO KieuThue VALUES ('3', 'House', '200');
-- table loai dich vu
INSERT INTO LoaiDichVu VALUES ('1', 'Villa');
INSERT INTO LoaiDichVu VALUES ('2', 'House');
INSERT INTO LoaiDichVu VALUES ('3', 'Room');
-- table loai khach
INSERT INTO LoaiKhach (`IDLoaiKhach`, `TenLoaiKhach`) VALUES ('1', 'Diamond');
INSERT INTO LoaiKhach (`IDLoaiKhach`, `TenLoaiKhach`) VALUES ('2', 'Vip');
INSERT INTO LoaiKhach (`IDLoaiKhach`, `TenLoaiKhach`) VALUES ('3', 'Normal');

-- table dich vu
INSERT INTO DichVu VALUES (1, 'Villa', '500', '5', '10', 1000, 1, 1, 'on');
INSERT INTO DichVu VALUES (2, 'Home', '300', '3', '5', 500, 2, 2, 'on');
INSERT INTO DichVu VALUES (3, 'House', '200', '2', '3', 200, 3, 3, 'on');
-- table nhan vien
INSERT INTO NhanVien VALUES ('1', 'Tran Thi K', '1', '1', '1', '2000-10-19', '123132', '2500', '0123456', 'anh@gmail.com', 'Da Nang');
INSERT INTO NhanVien VALUES ('2', 'Tran Thi T', '2', '2', '2', '2000-10-19', '123132', '1500', '0123456', 'anh@gmail.com', 'Da Nang');
INSERT INTO NhanVien VALUES ('3', 'Tran Thi H', '3', '3', '3', '2000-10-19', '123132', '3000', '0123456', 'anh@gmail.com', 'Da Nang');
-- table khach hang
INSERT INTO KhachHang VALUES ('1', '1', 'Le Tuan Anh', '2000-10-19', '123456', 'anht@gmail.com', 'Da Nang');
INSERT INTO KhachHang VALUES ('2', '2', 'Doan Hoang Anh', '2000-10-19', '123136', 'anh@gmail.com', 'HCM');
INSERT INTO KhachHang VALUES ('3', '3', 'Le An Nhien', '2000-10-19', '123135', 'anh@gmail.com', 'Da Nang');

-- table hop dong
INSERT INTO HopDong VALUES ('1', '1', '1', '1', '2021-03-06', '2021-03-10', '100', '500');
INSERT INTO HopDong VALUES ('2', '2', '2', '2', '2021-03-05', '2021-03-09', '100', '200');
INSERT INTO HopDong VALUES ('3', '3', '3', '3', '2021-03-04', '2021-03-08', '100', '300');
INSERT INTO HopDong VALUES ('4', '1', '1', '2', '2021-03-07', '2021-03-15', '100',300);   -- HopDong.TongTien =(DichVu.ChiPhiThue+(DichVuDiKem.DonGia*DichVuDiKem.Gia))
-- table hop dong chi tiet
INSERT INTO HopDongChiTiet VALUES ('1', '1', '1', '10');
INSERT INTO HopDongChiTiet VALUES ('2', '2', '2', '01');
INSERT INTO HopDongChiTiet VALUES ('3', '3', '3', '19');






-- task 2
select IDNhanVien, HoTenNhanVien, IDViTri, IDTrinhDo, IDBoPhan, NgaySinh, SoCMND, Luong, SDT, Email, DiaChi
from NhanVien
group by IDNhanVien, HoTenNhanVien, IDViTri, IDTrinhDo, IDBoPhan, NgaySinh, SoCMND, Luong, SDT, Email, DiaChi
having HoTenNhanVien like 't%' or '%k' or '%h';

-- task3

select IDKhachHang, IDLoaiKhach, HoTen, NgaySinh,round(datediff(curdate(), KhachHang.NgaySinh)/365.0) as Age, SoCMND, Email, DiaChi
from KhachHang
group by IDKhachHang, IDLoaiKhach, HoTen, SoCMND, Email, DiaChi
having Age >18 and Age <50 
		and (KhachHang.DiaChi ='Da Nang' or KhachHang.DiaChi ='Quang Tri' );
        
-- task 4
select HopDong.IDKhachHang, KhachHang.HoTen,LoaiKhach.TenLoaiKhach, count(HopDong.IDKhachHang) as SoLanDatPhong 
from HopDong join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang   -- dem so lan dat phong cua moi khach hang
join LoaiKhach on LoaiKhach.IDLoaiKhach = KhachHang.IDLoaiKhach
where LoaiKhach.TenLoaiKhach ='Diamond'
group by HopDong.IDKhachHang		
order by SoLanDatPhong ASC;			-- sap xep theo so lan dat phong tang dan!

-- task 5
select KhachHang.IDKhachHang, KhachHang.HoTen, LoaiKhach.TenLoaiKhach, HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, HopDong.NgayKetThucHopDong,
		( HopDong.TongTien =(DichVu.ChiPhiThue+(DichVuDiKem.DonVi*DichVuDiKem.Gia))) as TongTien
from KhachHang
left join HopDong on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join LoaiKhach on LoaiKhach.IDLoaiKhach = KhachHang.IDLoaiKhach
left join DichVu on DichVu.IDDichVu = HopDong.DichVu;












