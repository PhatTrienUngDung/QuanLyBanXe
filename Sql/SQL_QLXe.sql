create database SQL_QLXe
go
use SQL_QLXe
go
create table ChucVu(
	maChucVu varchar(15) primary key NOT NULL,
	tenChucVu char(15) NULL
);
go
create table TaiKhoan(
	maNhanvien varchar(15)  foreign key references NhanVien(maNhanVien),
	matKhau char(20) NULL,
	quyen nvarchar(20) NULL
);
go
create table NhanVien(
	maNhanVien varchar(15) primary key NOT NULL,
	tenNhanVien nvarchar(50)  NULL,
	gioiTinh nvarchar(5)  NULL,
	diaChi nvarchar(50)  NULL,
	email char(50)  NULL,
	soDienThoai char(15)  NULL,
	maChucVu varchar(15) foreign key references ChucVu(maChucVu),
	ngayVaoLam date  NULL
);
go
create table nhaCungCap(
	maNhaCungCap varchar(15) primary key NOT NULL,
	tenNhaCungCap nvarchar(50) NULL,
	diaChi nvarchar(50) NULL,
	email nvarchar(50) NULL,
	soDienThoai	char(10) NULL,
	chuThich nvarchar(50) NULL
);
go
create table HoaDon(
	maHoaDon varchar(15) primary key NOT NULL,
	maKhachHang char(10) NULL,
	maNhanVien char(12) NULL,
	ngayLapHoaDon date NULL DEFAULT GETDATE()
);
go
create table chiTietHoaDon(
	maHoaDon varchar(15) foreign key  references HoaDon(maHoaDon),
	maXe varchar(15) foreign key references Xe(maXe) NULL,
	soLuong int NULL,
	donGia float  NULL
);
go
create table HangSanXuat(
	maHangSanXuat varchar(15) primary key NOT NULL,
	tenHangSanXuat nvarchar(50) NULL
);
go
create table LoaiXe(
	maLoaiXe varchar(15) primary key NOT NULL,
	tenLoaiXe nvarchar(50) NULL
);
go
create table Xe (
	maXe varchar(15) primary key NOT NULL,
	tenXe nvarchar(50) NULL,
	maLoaiXe varchar(15) foreign key  references LoaiXe(maLoaiXe) NULL, 
	mauXe nvarchar(50) NULL,
	maNhaCungCap varchar(15) foreign key  references NhaCungCap(maNhaCungCap) NULL,
	maHangSanXuat varchar(15) foreign key references HangSanXuat(maHangSanXuat) NULL,
	phanKhoi int NULL,
	soLuong int NULL,
	giaNhap float NULL,
	ngayNhap date NULL DEFAULT GETDATE(),
	trangThai int NULL,
	chuThich nvarchar(50) NULL,
	img1 nvarchar(200) null,
	img2 nvarchar(200) null,
	img3 nvarchar(200) null
);
go
create table KhachHang(
	maKhachHang varchar(15) primary key not null,
	tenKhachHang nvarchar(50) NULL,
	gioiTinh nvarchar(5) NULL,
	ngaySinh date NULL,
	diaChi nvarchar(50) NULL,
	email char(50) NULL,
	soDienThoai char(11) NULL,
	chuThich nvarchar(50) NULL
);
go
create table HopDong(
	maHopDong varchar(15) primary key NOT NULL,
	maKhachHang varchar(15) foreign key references KhachHang(maKhachHang) NULL,
	maNhanVien varchar(15) foreign key references NhanVien(maNhanVien) NULL,
	maXe varchar(15) foreign key references Xe(maXe),
	ngayLap	date NULL DEFAULT GETDATE(),
	thoiGianBH int NULL
);
go
create table PhieuNhap(
	maPhieuNhap varchar(15) primary key NOT NULL,
	maNhanVien varchar(15) foreign key references NhanVien(maNhanVien) NULL,
	maNhaCungCap varchar(15) foreign key references NhaCungCap(maNhaCungCap) NULL,
	ngayNhap date  NULL DEFAULT GETDATE(),
	chuThich nvarchar(50) NULL
);
go
create table chiTietPhieuNhap(
	maPhieuNhap nvarchar(50) primary key NOT NULL,
	maXe varchar(15) foreign key references Xe(maXe) NULL,
	soLuong int NULL,
	donGia float NULL,
	chuThich nvarchar(50) NULL
);









go

insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE001','Vision','LX001','Đỏ','honda','150','20','45000000','2020-10-1','1',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE002','Vision','LX001','Vàng','honda','150','22','45000000','2020-1-21','1',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE003','Vision','LX001','Kem','honda','150','10','45000000','2020-10-6','1',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE004','Wave','LX002','Đỏ','honda','100','21','32000000','2020-5-17','1',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE005','Wave','LX002','Trắng','honda','100','20','32000000','2020-3-1','1',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE006','Sirius','LX002','Đen','suzuki','100','0','30000000','2020-10-4','0',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE007','Sirius','LX002','Trắng','suzuki','100','5','30000000','2020-10-1','1',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE008','Air Blade','LX001','Đỏ','honda','150','10','48000000','2020-12-12','1',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE009','Air Blade','LX001','Đen','honda','150','0','48000000','2020-4-1','0',' ')
insert into Xe (maXe,tenXe,maLoaiXe,mauXe,maNhaCungCap,phanKhoi,soLuong,giaNhap,ngayNhap,trangThai,chuThich) values ('XE010','Air Blade','LX001','Xám','hoda','150','20','48000000','2020-7-1','1',' ')



insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD001','800000000001','102548330000','XE002','Vision','2020-10-1','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD002','800000000002','102548340000','XE003','Vision','2020-10-2','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD003','800000000003','102548010000','XE002','Vision','2020-8-15','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD004','800000000004','102548010000','XE005','Wave','2020-10-2','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD005','800000000005','102548340000','XE002','Vision','2020-10-2','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD006','800000000006','102548440000','XE005','Wave','2020-1-2','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD007','800000000007','102548010000','XE006','Sirius','2020-10-2','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD008','800000000008','102548550000','XE008','Air Blade','2020-10-9','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD009','800000000009','102548010000','XE008','Air Blade','2020-6-2','1')
insert into HopDong (maHopDong,maKhachHang,maNhanVien,maXe,ngayLap,thoiGianBH) values('HD010','800000000010','102548550000','XE009','Air Blade','2020-10-2','1 ')



insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN001','XE002','10','450000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN002','XE003','20','900000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN003','XE001','5','225000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN004','XE008','2','96000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN005','XE006','6','360000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN006','XE007','9','270000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN007','XE002','2','90000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN008','XE005','8','256000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN009','XE009','25','1200000000',' ')
insert into chiTietPhieuNhap (maPhieuNhap,maXe,soLuong,donGia,chuThich) values('CTPN010','XE010','5','24000000',' ')

	

insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN001','102548260000','HSX001','2020-3-12',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN002','102548330000','HSX001 ','2020-4-13',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN003','102548440000','HSX002 ','2020-3-12',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN004','102548550000','HSX001 ','2020-5-12',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN005','102548550000','HSX003','2020-7-18',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN006','102548010000','HSX002','2020-4-12',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN007','102548340000','HSX001','2020-3-25',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN008','102548960000','HSX003 ','2020-9-12',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN009','102548010000','HSX001 ','2020-12-27',' ')
insert into PhieuNhap (maPhieuNhap,maNhanVien,maNhaCungCap,ngayNhap,chuThich) values('PN010','102548340000','HSX002','2020-8-21',' ')



insert into HangSanXuat (maHangSanXuat,tenHangSanXuat)values('HSX001','Honda')
insert into HangSanXuat (maHangSanXuat,tenHangSanXuat)values('HSX002','Kawasaki ')
insert into HangSanXuat (maHangSanXuat,tenHangSanXuat)values('HSX003','Yamaha')
insert into HangSanXuat (maHangSanXuat,tenHangSanXuat)values('HSX004','Piaggio ')
insert into HangSanXuat (maHangSanXuat,tenHangSanXuat)values('HSX005','Suzuki ')


insert into LoaiXe (maLoaiXe,tenLoaiXe) values('LX001','Xe ga')
insert into LoaiXe (maLoaiXe,tenLoaiXe) values('LX002','Xe số ')



insert into nhaCungCap(maNhaCungCap,tenNhaCungCap,diaChi,email,soDienThoai,chuThich) values ('NCC001','motobikeSG','5 Hai Bà Trưng DaKao quận 1','motobkileSG@gmail.com','0909341238',' ')
insert into nhaCungCap(maNhaCungCap,tenNhaCungCap,diaChi,email,soDienThoai,chuThich) values ('NCC002','xemayVN','248 Phạm Ngũ Lão quận 5','xemayVN@gmail.com','0364258416',' ')
insert into nhaCungCap(maNhaCungCap,tenNhaCungCap,diaChi,email,soDienThoai,chuThich) values ('NCC003','Nicksan','500 Quang Trung quận Gò Vấp','nicksan@gmail.com','0232256158',' ')



insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548260000','NV_1','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548330000','NV_2','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548440000','NV_3','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548550000','NV_4','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548660000','NV_7','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548770000','NV_8','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548000000','NV_10','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548340000','NV_11','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548960000','NV_12','Nhân Viên')
insert into TaiKhoan (maNhanvien,matKhau,quyen) values ('102548010000','NV_13','Quản Lí')

insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548260000','Trần Mỹ Lệ','Nữ','87 Huỳnh Khương An, phường 5,Gò Vấp,Hồ Chí Minh','myle1988@gmail.com','0936064271','Nhân viên bán hàng','2015-6-8')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548330000','Bùi Thành Nam','Nam','448/6 Phan Huy Ích','thanhna_1990@gmail.com','0905135431','Nhân viên bán hàng','2015-6-8')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548440000','Nguyễn Long Thành ','Nam','97 Nguyễn Thị Đinh, Quận 4,Hồ Chí Minh','Thanh_1996@gmail.com','0937065271','Nhân viên bán hàng','2016-6-8')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548550000','Vương Anh Toàn ','Nam','82 Nguyễn Văn Bảo, phường 4,Gò Vấp,Hồ Chí Minh','anhtoan_1988@gmail.com','0967064271','Nhân viên bán hàng','2017-1-7')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548660000','Võ Thị Bích Loan ','Nữ','19 Phan Văn Trị , phường 5,Gò Vấp,Hồ Chí Minh','bichloan_1990@gmail.com','0905882651','Nhân viên bán hàng','2017-6-8')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548770000','Trần Thị Bưởi','Nữ','84 Phan Xào Nam,Quận 5,Hồ Chí Minh','thibuoi_1986@gmail.com','0967886793','Nhân viên bán hàng','2014-6-8')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548000000','Bạch Phương Mai ','Nữ','123 Toàn Thắng, quận 11,Hồ Chí Minh','phuongmai_1987@gmail.com','0933806521','Nhân viên bán hàng','2018-7-15')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548340000','Đoàn Văn Vĩnh ','Nam','44/4 hẻm 8 Cách Mạng Tháng 8,Hồ Chí Minh','vanvinh_1992@gmail.com','0905778521','Nhân viên bán hàng','2016-6-12')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548960000','Nguyễn Thị Linh','Nữ','55/8 Phan Văn Trị,Gò Vấp,Hồ Chí Minh','thilinh_1996@gmail.com','093658824','Nhân viên bán hàng','2019-6-1')
insert into NhanVien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,soDienThoai,chucVu,ngayVaoLam) values ('102548010000','Vương Tư Thông','Nam','121 Nguyễn Oanh,phường 5,Gò Vấp,Hồ Chí Minh','tuthong_2000@gmail.com','0987064271','Quản lí','2017-12-8')

insert into ChucVu(maChucVu,tenChucVu) values('NVBH','Nhân viên bán hàng')
insert into ChucVu(maChucVu,tenChucVu) values('NVQL','Nhân viên quản lý')

insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD001','800000000001','102548660000','2019-5-12')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD002','800000000003','102548770000','2019-5-12')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD003','800000000005','102548330000','2020-5-2')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD004','800000000009','102548330000','2019-6-1')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD005','800000000010','102548660000','2019-5-12')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD006','800000000006','102548770000','2020-5-12')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD007','800000000002','102548960000','2019-5-12')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD008','800000000004','102548340000','2020-8-1')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD009','800000000008','102548440000','2019-12-12')
insert into HoaDon(maHoaDon,maKhachHang,maNhanVien,ngayLapHoaDon) values('HD010','800000000007','102548550000','2019-7-1')

insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE001',1,'45000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD002','XE004',2,'64000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE002',1,'45000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE007',1,'30000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE003',2,'45000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE006',1,'30000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE005',1,'32000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE008',1,'48000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE009',1,'48000000')
insert into ChiTietHoaDon(maHoaDon,maXe,soLuong,donGia) values('CTHD001','XE010',1,'48000000')

insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000001','Đoàn Văn Nghĩa','Nam','1985-12-4','123 Phạm Ngũ Lão, Quận 1,Hồ Chí Minh','vannghia_1985@gmail.com','0965426513','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000002','Nguyễn Khương Toàn','Nam','1985-12-4','87 Phan Văn Trị,phường 5,quận Gò Vấp,Hồ Chí Minh','khuongtoan_1980@gmail.com','097836952','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000003','Đỗ Thị Minh Tuyết','Nữ','1965-3-4','15 Nguyễn Văn Bảo,phường 4,quận Gò Vấp,Hồ Chí Minh','minhtuyet_1990@gmail.com','0946123456','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000004','Ngô Thị Thúy Hằng','Nữ','1985-2-4','13 Yersin,quận 5, thành phố Hồ Chí Minh','thuyhang_1996@gmail.com','0912886537','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000005','Nguyễn Tuấn Hải','Nam','1975-1-4','97 Nguyễn Thị Định,quận Bình Chánh','tuanhai_1964@gmail.com','0905446778','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000006','Trần Thị Bích Chiêu','Nữ','1955-9-1','57 Trần Kiên,quận Phú Nhuận,Hồ Chí Minh','bichchieu_1970@gmail.com','0963056513','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000007','Vương Gia Thịnh','Nam','1965-6-14','69 Đào Thị Nguyệt, quận 6, Hồ Chí Minh','giathinh_1975@gmail.com','01233503472','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000008','Nguyễn Chí Hòa','Nam','1981-12-5','523/4  Nguyễn Tri Phương, quận 10, Hồ Chí Minh.','chihoa_1992@gmail.com','0986225630','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000009','Trần Đức Huy','Nam','1980-2-4','12 Lê Văn Sỹ, Quận 3, Hồ Chí Minh','duchuy_1995@gmail.com','0965426563','')
insert into KhachHang(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,diaChi,email,soDienThoai,chuThich) values('800000000010','Nguyễn Mỹ Hảo','Nữ','1985-1-3','62 Trần Não, phường Bình An, quận 2, Hồ Chí Minh','myhao_1989@gmail.com','0965123456','')

