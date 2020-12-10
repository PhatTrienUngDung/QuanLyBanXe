﻿Create database SQL_QLXe
go
use SQL_QLXe
go

--Hang san xuat
CREATE TABLE [dbo].[HangSanXuat](
	[maHangSanXuat] [varchar](15) NOT NULL,
	[tenHangSanXuat] [nvarchar](50) NOT NULL,
	[quocGia] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHangSanXuat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

--Loai Xe
CREATE TABLE [dbo].[LoaiXe](
	[maLoaiXe] [varchar](15) NOT NULL,
	[tenLoaiXe] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Nha cung cap
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [varchar](25) NOT NULL,
	[tenNhaCungCap] [nvarchar](100) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[email] [nvarchar](50) NULL,
	[soDienThoai] [char](20) NULL,
	[chuThich] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Xe
CREATE TABLE [dbo].[Xe](
	[maXe] [varchar](15) NOT NULL,
	[tenXe] [nvarchar](50) NOT NULL,
	[maLoaiXe] [varchar](15) NOT NULL,
	[phienBan] [nvarchar](60) NOT NULL,
	[mauXe] [nvarchar](50) NOT NULL,
	[maNhaCungCap] [varchar](25) NOT NULL,
	[maHangSanXuat] [varchar](15) NOT NULL,
	[phanKhoi] [int] NOT NULL,
	[soKhung] [varchar] (50) NOT NULL ,
	[soMay] [varchar] (50) NOT NULL ,
	[giaNhap] [float] NOT NULL,
	[ngayNhap] [date] NOT NULL,
	[trangThai] [nvarchar](50) NULL,
	[chuThich] [nvarchar](50) NULL,
	[img1] [nvarchar](255) NOT NULL,
	unique(soKhung,soMay),
PRIMARY KEY CLUSTERED 
(
	[maXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO

--Khach hang
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [varchar](15) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[CMND] [nvarchar](50) NOT NULL,
	[gioiTinh] [nvarchar](5) NOT NULL,
	[ngaySinh] [date] NULL,
	[ngayGiaNhap] [date]  NOT NULL,
	[diaChi] [nvarchar](100) NULL,
	[email] [char](50) NULL,
	[soDienThoai] [char](11) NULL,
	[chuThich] [nvarchar](50) NULL,
	unique(cmnd),
PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Hoa Don
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [varchar](15) NOT NULL,
	[maKhachHang] [varchar](15) NOT NULL,
	[maNhanVien] [varchar](15) NOT NULL,
	[ngayLapHoaDon] [date] NOT NULL,
	[tongTien] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Chi tiet phieu nhap
/*CREATE TABLE [dbo].[chiTietPhieuNhap](
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[maXe] [varchar](15) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[chuThich] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO*/

--Chi tiet hoa don
CREATE TABLE [dbo].[chiTietHoaDon](
	[maHoaDon] [varchar](15) NOT NULL,
	[maXe] [varchar](15) NOT NULL,
	[donGia] [float] NOT NULL,
	[thueVAT] [float] NOT NULL
) ON [PRIMARY]
GO

--Chuc vu
CREATE TABLE [dbo].[ChucVu](
	[maChucVu] [varchar](15) NOT NULL,
	[tenChucVu] [nvarchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Nhan vien
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [varchar](15) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[CMND] [varchar](50) NOT NULL,
	[gioiTinh] [nvarchar](5) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[email] [char](50) NULL,
	[soDienThoai] [char](15) NULL,
	[maChucVu] [varchar](15) NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[ngaySinh] [date] NOT NULL,
	unique(cmnd),
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Tai khoan
CREATE TABLE [dbo].[TaiKhoan](
	[maNhanvien] [varchar](15) NOT NULL,
	[matKhau] [char](20) NULL,
	[quyen] [nvarchar](20) NOT NULL,
	[chuThich] [nvarchar](50) NULL
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Hop dong
CREATE TABLE [dbo].[HopDong](
	[maHopDong] [varchar](15) NOT NULL,
	[maKhachHang] [varchar](15) NOT NULL,
	[maNhanVien] [varchar](15) NOT NULL,
	[maXe] [varchar](15) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[thoiGianBH] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Phieu nhap
/*CREATE TABLE [dbo].[PhieuNhap](
	[maPhieuNhap] [varchar](15) NOT NULL,
	[maNhanVien] [varchar](15) NOT NULL,
	[maNhaCungCap] [varchar](25) NOT NULL,
	[ngayNhap] [date] NOT NULL,
	[chuThich] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO*/

--ALTER TABLE [dbo].[PhieuNhap] ADD CONSTRAINT [DF_PhieuNhap_NgayNhap] DEFAULT (getdate()) FOR [ngayNhap]
--GO

ALTER TABLE [dbo].[Xe] ADD CONSTRAINT [DF_Xe_NgayNhap] DEFAULT (getdate()) FOR [ngayNhap]
GO

ALTER TABLE [dbo].[HoaDon] ADD CONSTRAINT [DF_HoaDon_NgayLHD] DEFAULT (getdate()) FOR [ngayLapHoaDon]
GO

ALTER TABLE [dbo].[HopDong] ADD CONSTRAINT [DF_HopDong_NgayLap] DEFAULT (getdate()) FOR [ngayLap]
GO

ALTER TABLE [dbo].[KhachHang] ADD CONSTRAINT [DF-KhachHang_NgayGiaNhap] DEFAULT (getdate()) FOR [ngayGiaNhap]
GO

/*ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO

ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[nhaCungCap] ([maNhaCungCap])
GO

ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO*/

ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([maHangSanXuat])
REFERENCES [dbo].[HangSanXuat] ([maHangSanXuat])
GO

ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([maLoaiXe])
REFERENCES [dbo].[LoaiXe] ([maLoaiXe])
GO

ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[nhaCungCap] ([maNhaCungCap])
GO

/*ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD FOREIGN KEY([maXe])
REFERENCES [dbo].[Xe] ([maXe])
GO*/

ALTER TABLE [dbo].[chiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO

ALTER TABLE [dbo].[chiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([maXe])
REFERENCES [dbo].[Xe] ([maXe])
GO

ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([maChucVu])
REFERENCES [dbo].[ChucVu] ([maChucVu])
GO

ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([maNhanvien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO

ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO

ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO

ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([maXe])
REFERENCES [dbo].[Xe] ([maXe])
GO

ALTER TABLE[dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO

INSERT INTO HangSanXuat values('HSX_0001',N'Honda',N'Nhật Bản'),
							  ('HSX_0002',N'Indian Motorcycle',N'Mỹ'),
							  ('HSX_0003',N'Triumph',N'Anh'),
							  ('HSX_0004',N'Yamaha',N'Nhật Bản'),
							  ('HSX_0005',N'Benelli',N'Ý'),
							  ('HSX_0006',N'Harley-Davidson',N'Hoa Kỳ'),
							  ('HSX_0007',N'Kawasaki',N'Nhật Bản'),
							  ('HSX_0008',N'Ducati',N'Ý'),
							  ('HSX_0009',N'Suzuki',N'Nhật Bản'),
							  ('HSX_0010',N'BMW',N'Đức'),
							  ('HSX_0011',N'Piaggio',N'Italy'),
							  ('HSX_0012',N'SYM',N'Đài Loan')
GO

INSERT INTO LoaiXe values('LX_0001',N'Xe số'),
						 ('LX_0002',N'Xe tay ga'),
						 ('LX_0003',N'Xe côn tay'),
						 ('LX_0004',N'Xe máy điện')
GO

INSERT INTO NhaCungCap values('NCC_0001',N'Công Ty TNHH Thương Mại Ngọc Hoa',N'138-140 Hoàng Diệu, P. 9, Q. 4, Tp. Hồ Chí Minh',N'ngochoacty138@yahoo.com.vn','0839400925',N''),
							 ('NCC_0002',N'Công Ty TNHH KBK Việt Nam Bearing',N'278 Trần Văn Kiểu, P. 11, Q. 6, Tp. Hồ Chí Minh',N'bearings_duyentran@yahoo.com','0837558396',N''),
							 ('NCC_0003',N'CÔNG TY TNHH SẢN XUẤT VÀ THƯƠNG MẠI TIẾN LỘC',N'27 Nguyễn Trung Trực, Phường Bến Thành, Quận 1, TP. Hồ Chí Minh ',N'tienlocco@hcm.vnn.vn','0835210350',N''),
							 ('NCC_0004',N'Công Ty TNHH Thương Mại Dịch Vụ Xuất Nhập Khẩu Mã Lực',N'651 Âu Cơ, Phường Hòa Thạnh, Quận Tân Phú, TP Hồ Chí Minh',N'infomaluc@gmail.com.vn','0906358398',N''),
							 ('NCC_0005',N'Công Ty CPTM & XNK Việt Hồng Chinh',N'Km 5 Đ. 9D KCN Nam, TP. Đông Hà, Tỉnh Quảng Trị',N'viethongchinh@yahoo.com','0942944357',N''),
							 ('NCC_0006',N'CÔNG TY TNHH MTV Xe Máy Nhập Khẩu Sài Gòn',N'816 Võ Văn Kiệt, P. 5, Q. 5, Tp. Hồ Chí Minh',N'nhapkhau452@gmail.com','0856023452',N'')
GO

INSERT INTO Xe values('X_0001',N'Blade 110','LX_0001',N'Phanh đĩa, vành đúc',N'Đen - Xanh - Xám','NCC_0001','HSX_0001',110,N'15468741A365424D34',N'JD5F123',21300000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0002',N'Blade 110','LX_0001',N'Phanh đĩa, vành đúc',N'Đen - Đỏ - Xám','NCC_0001','HSX_0001',110,N'15368457E2354Y4647',N'JD5F124',21300000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0003',N'Blade 110','LX_0001',N'Phanh đĩa, vành đúc',N'Đen - Trắng - Bạc','NCC_0002','HSX_0001',110,N'15368457E2354Y4644',N'JD5F125',21300000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0004',N'Blade 110','LX_0001',N'Phanh đĩa, vành đúc',N'Đen - Xám','NCC_0003','HSX_0001',110,N'15368457E2354Y4645',N'JD5F126',21300000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0005',N'Blade 110','LX_0001',N'Phanh cơ, vành nan hoa',N'Xanh - Đen','NCC_0002','HSX_0001',110,N'15368457E2354Y4646',N'JD5F127',18800000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0006',N'Blade 110','LX_0001',N'Phanh cơ, vành nan hoa',N'Đỏ - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4649',N'JD5F128',18800000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0007',N'Blade 110','LX_0001',N'Phanh cơ, vành nan hoa',N'Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4650',N'JD5F129',18800000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0008',N'Blade 110','LX_0001',N'Phanh đĩa, vành nan hoa',N'Đỏ - Đen','NCC_0002','HSX_0001',110,N'15368457E2354Y4651',N'JD5F130',19800000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0009',N'Blade 110','LX_0001',N'Phanh đĩa, vành nan hoa',N'Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4652',N'JD5F131',19800000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0010',N'Blade 110','LX_0001',N'Phanh đĩa, vành nan hoa',N'Xanh - Đen','NCC_0003','HSX_0001',110,N'15368457E2354Y4653',N'JD5F132',19800000,CAST(N'2020-05-04' AS DATE),N'Còn hàng',N'',''),
					 ('X_0011',N'Wave RSX FI 110','LX_0001',N'Vành đúc phanh đĩa',N'Trắng - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4654',N'JD5F133',24690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0012',N'Wave RSX FI 110','LX_0001',N'Vành đúc phanh đĩa',N'Xanh Đậm - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4655',N'JD5F134',24690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0013',N'Wave RSX FI 110','LX_0001',N'Vành đúc phanh đĩa',N'Đỏ - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4656',N'JD5F135',24690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0014',N'Wave RSX FI 110','LX_0001',N'Vành đúc phanh đĩa',N'Xanh - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4657',N'JD5F136',24690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0015',N'Wave RSX FI 110','LX_0001',N'Vành nan hoa phanh cơ',N'Xám - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4658',N'JD5F137',21690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0016',N'Wave RSX FI 110','LX_0001',N'Vành nan hoa phanh cơ',N'Xanh - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4659',N'JD5F138',21690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0017',N'Wave RSX FI 110','LX_0001',N'Vành nan hoa phanh cơ',N'Đỏ - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4660',N'JD5F139',21690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0018',N'Wave RSX FI 110','LX_0001',N'Vành nan hoa phanh cơ',N'Trắng - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4661',N'JD5F140',21690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0019',N'Wave RSX FI 110','LX_0001',N'Vành nan hoa phanh đĩa',N'Xám - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4662',N'JD5F141',22690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0020',N'Wave RSX FI 110','LX_0001',N'Vành nan hoa phanh đĩa',N'Đỏ - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4663',N'JD5F142',22690000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0021',N'Wave Alpha 110cc','LX_0001',N'Phanh cơ, vành nan hoa',N'Trắng - Đen - Bạc','NCC_0001','HSX_0001',110,N'15368457E2354Y4664',N'JD5F143',17790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0022',N'Wave Alpha 110cc','LX_0001',N'Phanh cơ, vành nan hoa',N'Đỏ - Đen - Bạc','NCC_0001','HSX_0001',110,N'15368457E2354Y4665',N'JD5F144',17790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0023',N'Wave Alpha 110cc','LX_0001',N'Phanh cơ, vành nan hoa',N'Xanh - Đen - Bạc','NCC_0001','HSX_0001',110,N'15368457E2354Y4666',N'JD5F145',17790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0024',N'Wave Alpha 110cc','LX_0001',N'Phanh cơ, vành nan hoa',N'Xanh Đậm - Đen - Bạc','NCC_0001','HSX_0001',110,N'15368457E2354Y4667',N'JD5F146',17790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0025',N'Wave Alpha 110cc','LX_0001',N'Phanh cơ, vành nan hoa',N'Đen - Bạc','NCC_0001','HSX_0001',110,N'15368457E2354Y4668',N'JD5F147',17790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0026',N'Future 125 FI','LX_0001',N'Vành đúc',N'Bạc nâu đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4669',N'JD5F148',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0027',N'Future 125 FI','LX_0001',N'Vành đúc',N'Đỏ nâu đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4670',N'JD5F149',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0028',N'Future 125 FI','LX_0001',N'Vành đúc',N'Xanh nâu đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4671',N'JD5F150',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0029',N'Future 125 FI','LX_0001',N'Vành đúc',N'Đen nâu','NCC_0001','HSX_0001',125,N'15368457E2354Y4672',N'JD5F151',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0030',N'Future 125 FI','LX_0001',N'Vành đúc',N'Trắng nâu đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4673',N'JD5F152',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0031',N'Future 125 FI','LX_0001',N'Vành nan hoa',N'Đỏ đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4674',N'JD5F153',30190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0032',N'Future 125 FI','LX_0001',N'Vành nan hoa',N'Xanh đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4675',N'JD5F154',30190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0033',N'Super Cub C125','LX_0001',N'C125',N'Xanh lam','NCC_0001','HSX_0001',125,N'15368457E2354Y4676',N'JD5F155',84990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0034',N'Super Cub C125','LX_0001',N'C125',N'Đỏ trắng','NCC_0001','HSX_0001',125,N'15368457E2354Y4677',N'JD5F156',84990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0035',N'Super Cub C125','LX_0001',N'C125',N'Xanh lam xám','NCC_0001','HSX_0001',125,N'15368457E2354Y4678',N'JD5F157',84990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0036',N'Sh mode 125','LX_0002',N'Phiên bản Cá tính (ABS)',N'Đỏ đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4679',N'JD5F158',58990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0037',N'Sh mode 125','LX_0002',N'Phiên bản Cá tính (ABS)',N'Bạc đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4680',N'JD5F159',58990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0038',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Đỏ đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4681',N'JD5F160',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0039',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Xanh Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4682',N'JD5F161',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0040',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Bạc đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4683',N'JD5F162',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0041',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Trắng Nâu','NCC_0001','HSX_0001',125,N'15368457E2354Y4684',N'JD5F163',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0042',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Vàng Nâu','NCC_0001','HSX_0001',125,N'15368457E2354Y4685',N'JD5F164',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0043',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (CBS)',N'Đỏ Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4686',N'JD5F165',53890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0044',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (CBS)',N'Vàng Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4687',N'JD5F166',53890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0045',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (CBS)',N'Xanh Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4688',N'JD5F167',53890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0046',N'Air Blade 125/150','LX_0002',N'Air Blade 125 - Phiên bản Đặc biệt',N'Đen Vàng đồng','NCC_0001','HSX_0001',125,N'15368457E2354Y4689',N'JD5F168',42390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0047',N'Air Blade 125/150','LX_0002',N'Air Blade 125 - Phiên bản Tiêu chuẩn',N'Đỏ Đen Xám','NCC_0001','HSX_0001',125,N'15368457E2354Y4690',N'JD5F169',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0048',N'Air Blade 125/150','LX_0002',N'Air Blade 125 - Phiên bản Tiêu chuẩn',N'Xanh Đen Xám','NCC_0001','HSX_0001',125,N'15368457E2354Y4691',N'JD5F170',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0049',N'Air Blade 125/150','LX_0002',N'Air Blade 125 - Phiên bản Tiêu chuẩn',N'Bạc Xanh Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4692',N'JD5F171',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0050',N'Air Blade 125/150','LX_0002',N'Air Blade 125 - Phiên bản Tiêu chuẩn',N'Trắng Đỏ Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4693',N'JD5F172',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0051',N'Air Blade 125/150','LX_0002',N'Air Blade 150 - Phiên bản Đặc biệt',N'Xanh Xám Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4694',N'JD5F173',56390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0052',N'Air Blade 125/150','LX_0002',N'Air Blade 150 - Phiên bản Tiêu chuẩn',N'Đỏ Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4695',N'JD5F174',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0053',N'Air Blade 125/150','LX_0002',N'Air Blade 150 - Phiên bản Tiêu chuẩn',N'Xanh Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4696',N'JD5F175',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0054',N'Air Blade 125/150','LX_0002',N'Air Blade 150 - Phiên bản Tiêu chuẩn',N'Xám Đen Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4697',N'JD5F176',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0055',N'Air Blade 125/150','LX_0002',N'Air Blade 150 - Phiên bản Tiêu chuẩn',N'Đen Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4698',N'JD5F177',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0056',N'Vision','LX_0002',N'Phiên bản Cao cấp',N'Xanh lam - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4699',N'JD5F178',30790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0057',N'Vision','LX_0002',N'Phiên bản Cao cấp',N'Xanh lục - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4747',N'JD5F179',30790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0058',N'Vision','LX_0002',N'Phiên bản Cao cấp',N'Vàng - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4748',N'JD5F180',30790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0059',N'Vision','LX_0002',N'Phiên bản Cao cấp',N'Đen - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4749',N'JD5F181',30790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0060',N'Vision','LX_0002',N'Phiên bản Cao cấp',N'Đỏ - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4750',N'JD5F182',30790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0061',N'Vision','LX_0002',N'Phiên bản Đặc biệt',N'Đen - Xám','NCC_0001','HSX_0001',110,N'15368457E2354Y4751',N'JD5F183',31990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0062',N'Vision','LX_0002',N'Phiên bản Đặc biệt',N'Trắng - Đen','NCC_0001','HSX_0001',110,N'15368457E2354Y4752',N'JD5F184',31990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0063',N'Vision','LX_0002',N'Phiên bản Tiêu chuẩn',N'Trắng - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4753',N'JD5F185',29990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0064',N'Vision','LX_0002',N'Phiên bản Tiêu chuẩn',N'Đen - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4754',N'JD5F186',29990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0065',N'Vision','LX_0002',N'Phiên bản Tiêu chuẩn',N'Đỏ - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4755',N'JD5F187',29990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0066',N'Winner X','LX_0003',N'Phiên bản Camo',N'Xanh - Đen - Bạc','NCC_0001','HSX_0001',150,N'15368457E2354Y4756',N'JD5F188',48990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0067',N'Winner X','LX_0003',N'Phiên bản Camo',N'Đỏ - Đen - Bạc','NCC_0001','HSX_0001',150,N'15368457E2354Y4757',N'JD5F189',48990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0068',N'Winner X','LX_0003',N'Phiên bản Đen mờ',N'Đen - Vàng đồng','NCC_0001','HSX_0001',150,N'15368457E2354Y4758',N'JD5F190',49490000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0069',N'Winner X','LX_0003',N'Phiên bản Đường đua',N'Đỏ - Xanh - Trắng - Đen','NCC_0001','HSX_0001',150,N'15368457E2354Y4759',N'JD5F191',49990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0070',N'Winner X','LX_0003',N'Phiên bản Thể thao - Phanh ABS',N'Bạc - Đen - Đỏ','NCC_0001','HSX_0001',150,N'15368457E2354Y4760',N'JD5F192',48990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0071',N'Winner X','LX_0003',N'Phiên bản Thể thao - Phanh thường',N'Đỏ - Đen','NCC_0001','HSX_0001',150,N'15368457E2354Y4761',N'JD5F193',45990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0072',N'Winner X','LX_0003',N'Phiên bản Thể thao - Phanh thường',N'Xanh - Đen','NCC_0001','HSX_0001',150,N'15368457E2354Y4762',N'JD5F194',45990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0073',N'Winner X','LX_0003',N'Phiên bản Thể thao - Phanh thường',N'Đen - Xanh','NCC_0001','HSX_0001',150,N'15368457E2354Y4763',N'JD5F195',45990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0074',N'Winner X','LX_0003',N'Phiên bản Thể thao - Phanh thường',N'Đen','NCC_0001','HSX_0001',150,N'15368457E2354Y4764',N'JD5F196',45990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0076',N'Exciter','LX_0003',N'Phiên bản Monster Energy Yamaha MotoGP',N'Đen','NCC_0001','HSX_0004',150,N'15368457E2354Y4765',N'JD5F197',48990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0077',N'Exciter','LX_0003',N'Phiên bản Giới hạn',N'Xanh - Đen - Cam','NCC_0001','HSX_0004',150,N'15368457E2354Y4766',N'JD5F198',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0078',N'Exciter','LX_0003',N'Phiên bản Giới hạn',N'Xám - Đen - Xanh','NCC_0001','HSX_0004',150,N'15368457E2354Y4767',N'JD5F199',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0079',N'Exciter','LX_0003',N'Phiên bản Giới hạn',N'Đỏ - Cam - Bạc','NCC_0001','HSX_0004',150,N'15368457E2354Y4768',N'JD5F200',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0080',N'Exciter','LX_0003',N'Phiên bản Giới hạn',N'Xanh lá - Đen','NCC_0001','HSX_0004',150,N'15368457E2354Y4769',N'JD5F201',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0081',N'Exciter','LX_0003',N'Phiên bản Doxou',N'Đen - Đồng ánh hồng','NCC_0001','HSX_0004',150,N'15368457E2354Y4770',N'JD5F202',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0082',N'Exciter','LX_0003',N'Phiên bản Movistar',N'Movistar','NCC_0001','HSX_0004',150,N'15368457E2354Y4771',N'JD5F203',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0083',N'Exciter','LX_0003',N'GP phiên bản mới',N'GP','NCC_0001','HSX_0004',150,N'15368457E2354Y4772',N'JD5F204',47490000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0084',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Đen nhám','NCC_0001','HSX_0004',115,N'15368457E2354Y4773',N'JD5F205',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0085',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Đỏ','NCC_0001','HSX_0004',115,N'15368457E2354Y4774',N'JD5F206',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0086',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Xám cam','NCC_0001','HSX_0004',115,N'15368457E2354Y4775',N'JD5F207',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0087',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Trắng đen','NCC_0001','HSX_0004',115,N'15368457E2354Y4776',N'JD5F208',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0088',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Đỏ đen ánh kim','NCC_0001','HSX_0004',115,N'15368457E2354Y4777',N'JD5F1209',1340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0089',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Đen xám ánh kim','NCC_0001','HSX_0004',115,N'15368457E2354Y4778',N'JD5F210',21340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0090',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Xanh đen ánh kim','NCC_0001','HSX_0004',115,N'15368457E2354Y4779',N'JD5F211',21340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0091',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Xám','NCC_0001','HSX_0004',115,N'15368457E2354Y4780',N'JD5F212',21340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0092',N'Sirius FI','LX_0001',N'Phanh cơ',N'Đen','NCC_0001','HSX_0004',115,N'15368457E2354Y4781',N'JD5F213',20340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0093',N'Sirius FI','LX_0001',N'Phanh cơ',N'Đỏ','NCC_0001','HSX_0004',115,N'15368457E2354Y4782',N'JD5F214',2040000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0094',N'Sirius FI','LX_0001',N'Phanh cơ',N'Xanh','NCC_0001','HSX_0004',115,N'15368457E2354Y4783',N'JD5F215',20340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0095',N'Sirius FI','LX_0001',N'Phanh cơ',N'Xám','NCC_0001','HSX_0004',115,N'15368457E2354Y4784',N'JD5F216',20340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0096',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản giới hạn',N'Bạc','NCC_0001','HSX_0004',125,N'15368457E2354Y4785',N'JD5F217',50000000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0097',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản giới hạn',N'Đen nhám','NCC_0001','HSX_0004',125,N'15368457E2354Y4786',N'JD5F218',50000000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0098',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản giới hạn',N'Xanh nhám','NCC_0001','HSX_0004',125,N'15368457E2354Y4787',N'JD5F219',50000000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0099',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản tiêu chuẩn',N'Đỏ Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4788',N'JD5F220',45500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0100',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản tiêu chuẩn',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4789',N'JD5F221',45500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0101',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản tiêu chuẩn',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4790',N'JD5F222',45500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0102',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản đặc biệt',N'Đỏ xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4791',N'JD5F223',49500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0103',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản đặc biệt',N'Trắng Ngọc Trai','NCC_0001','HSX_0004',125,N'15368457E2354Y4791',N'JD5F224',49500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0104',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản đặc biệt',N'Xám Nhám','NCC_0001','HSX_0004',125,N'15368457E2354Y4792',N'JD5F225',49500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0105',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4793',N'JD5F226',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0106',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Xanh nhám','NCC_0001','HSX_0004',125,N'15368457E2354Y4794',N'JD5F227',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0107',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4795',N'JD5F228',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0108',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Nâu','NCC_0001','HSX_0004',125,N'15368457E2354Y4796',N'JD5F229',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0109',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Xanh lá','NCC_0001','HSX_0004',125,N'15368457E2354Y4797',N'JD5F230',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0110',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Xanh ngọc','NCC_0001','HSX_0004',125,N'15368457E2354Y4798',N'JD5F231',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0111',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Xanh dương','NCC_0001','HSX_0004',125,N'15368457E2354Y4799',N'JD5F232',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0112',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4800',N'JD5F233',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'','')
GO

INSERT INTO KhachHang values('KH_0001',N'Châu Quốc An',N'312439087',N'Nam',CAST(N'2000-3-9'AS DATE),CAST(N'2020-1-3'AS DATE),N'Gò Vấp',N'quocan@gmail.com',N'0987654321',N'Không'),
							('KH_0002',N'Giang Đức Anh',N'312452875',N'Nam',CAST(N'2000-3-10'AS DATE),CAST(N'2020-1-10'AS DATE),N'Gò Vấp',N'ducanh@gmail.com',N'0354215486',N'Không'),
							('KH_0003',N'Nguyễn Tuấn Anh',N'345218765',N'Nam',CAST(N'2000-3-15'AS DATE),CAST(N'2020-1-15'AS DATE),N'Gò Vấp',N'tuananh@gmail.com',N'0125462856',N'Không'),
							('KH_0004',N'Đặng Trần Bích Chiêu',N'452896475',N'Nữ',CAST(N'2000-2-9'AS DATE),CAST(N'2020-1-15'AS DATE),N'Gò Vấp',N'bichchieu@gmail.com',N'0325462589',N'Không'),
							('KH_0005',N'Mai Kiên Cường',N'968741275',N'Nam',CAST(N'2000-3-5'AS DATE),CAST(N'2020-1-15'AS DATE),N'Gò Vấp',N'kiencuong@gmail.com',N'0369854625',N'Không'),
							('KH_0006',N'Trương Công Cường',N'345125491',N'Nam',CAST(N'2000-10-9'AS DATE),CAST(N'2020-1-17'AS DATE),N'Gò Vấp',N'congcuong@gmail.com',N'0985452526',N'Không'),
							('KH_0007',N'Trần Hoàng Đăng',N'321545252',N'Nam',CAST(N'2000-3-8'AS DATE),CAST(N'2020-2-3'AS DATE),N'Gò Vấp',N'hoangdang@gmail.com',N'0978546214',N'Không'),
							('KH_0008',N'Vũ Đình Khánh Đăng',N'376954245',N'Nam',CAST(N'2000-5-9'AS DATE),CAST(N'2020-2-5'AS DATE),N'Gò Vấp',N'khanhdang@gmail.com',N'0224526358',N'Không'),
							('KH_0009',N'Lữ Công Danh',N'314524215',N'Nam',CAST(N'2000-1-25'AS DATE),CAST(N'2020-2-5'AS DATE),N'Gò Vấp',N'congdanh@gmail.com',N'0846251345',N'Không'),
							('KH_0010',N'Nguyễn Công Thành Đạt',N'782596425',N'Nam',CAST(N'2000-6-10'AS DATE),CAST(N'2020-2-5'AS DATE),N'Gò Vấp',N'thanhdat@gmail.com',N'0216458524',N'Không'),
							('KH_0011',N'Nguyễn Thế Đạt',N'452366252',N'Nam',CAST(N'2000-7-9'AS DATE),CAST(N'2020-2-6'AS DATE),N'Gò Vấp',N'thedat@gmail.com',N'0964521542',N'Không'),
							('KH_0012',N'Tằng Tiến Đạt',N'312754128',N'Nam',CAST(N'2000-8-9'AS DATE),CAST(N'2020-2-7'AS DATE),N'Gò Vấp',N'tiendatgmail.com',N'0987654563',N'Không'),
							('KH_0013',N'Dương Thị Diễm',N'314361852',N'Nữ',CAST(N'2000-9-9'AS DATE),CAST(N'2020-3-2'AS DATE),N'Gò Vấp',N'thidiem@gmail.com',N'0936258741',N'Không'),
							('KH_0014',N'Đỗ Đạt Đức',N'125365214',N'Nam',CAST(N'2000-3-9'AS DATE),CAST(N'2020-3-3'AS DATE),N'Gò Vấp',N'datduc@gmail.com',N'0965452589',N'Không'),
							('KH_0015',N'Nguyễn Tùng Dương',N'362546213',N'Nam',CAST(N'2000-3-12'AS DATE),CAST(N'2020-3-3'AS DATE),N'Gò Vấp',N'tungduong@gmail.com',N'0452852645',N'Không'),
							('KH_0016',N'Huỳnh Nguyễn Đình Duy',N'345124369',N'Nam',CAST(N'2000-3-9'AS DATE),CAST(N'2020-3-3'AS DATE),N'Gò Vấp',N'dinhduy@gmail.com',N'0645214523',N'Không'),
							('KH_0017',N'Trần Phan Kỳ',N'345216258',N'Nam',CAST(N'2000-12-9'AS DATE),CAST(N'2020-3-3'AS DATE),N'Gò Vấp',N'phanky@gmail.com',N'0965245145',N'Không'),
							('KH_0018',N'Trần Phạm Gia Long',N'215369874',N'Nam',CAST(N'1989-3-9'AS DATE),CAST(N'2020-3-5'AS DATE),N'Gò Vấp',N'gialong@gmail.com',N'0912452635',N'Không'),
							('KH_0019',N'Trương Đình Phước',N'684524521',N'Nam',CAST(N'1990-3-9'AS DATE),CAST(N'2020-3-5'AS DATE),N'Gò Vấp',N'dinhphuoc@gmail.com',N'0365452135',N'Không'),
							('KH_0020',N'Nguyễn Văn Trinh',N'456217852',N'Nam',CAST(N'1975-3-9'AS DATE),CAST(N'2020-3-5'AS DATE),N'Gò Vấp',N'vantrinh@gmail.com',N'0987459124',N'Không'),
							('KH_0021',N'Mai Thanh Vỹ',N'625462863',N'Nữ',CAST(N'1994-3-9'AS DATE),CAST(N'2020-3-5'AS DATE),N'Gò Vấp',N'thanhvy@gmail.com',N'0745245625',N'Không')					
GO

INSERT INTO HoaDon values('HD_0001','KH_0001',N'NV_0001',CAST(N'2020-1-3' AS DATE), 26199000),
						 ('HD_0002','KH_0002',N'NV_0001',CAST(N'2020-1-10' AS DATE), 26199000),
						 ('HD_0003','KH_0003',N'NV_0001',CAST(N'2020-1-15' AS DATE), 26199000),
						 ('HD_0004','KH_0004',N'NV_0002',CAST(N'2020-1-15' AS DATE), 26199000),
						 ('HD_0005','KH_0005',N'NV_0002',CAST(N'2020-1-15' AS DATE), 21620000),
						 ('HD_0006','KH_0006',N'NV_0002',CAST(N'2020-1-17' AS DATE), 21620000),
						 ('HD_0007','KH_0007',N'NV_0002',CAST(N'2020-2-3' AS DATE), 21620000),
						 ('HD_0008','KH_0008',N'NV_0001',CAST(N'2020-2-5' AS DATE), 21620000),
						 ('HD_0009','KH_0009',N'NV_0001',CAST(N'2020-2-5' AS DATE), 21620000),
						 ('HD_0010','KH_0010',N'NV_0001',CAST(N'2020-2-5' AS DATE), 21620000),
						 ('HD_0011','KH_0011',N'NV_0001',CAST(N'2020-2-6' AS DATE), 22770000),
						 ('HD_0012','KH_0012',N'NV_0001',CAST(N'2020-2-7' AS DATE), 22770000),
						 ('HD_0013','KH_0013',N'NV_0002',CAST(N'2020-3-2' AS DATE), 22770000),
						 ('HD_0014','KH_0014',N'NV_0002',CAST(N'2020-3-3' AS DATE), 22770000),
						 ('HD_0015','KH_0015',N'NV_0002',CAST(N'2020-3-3' AS DATE), 26678700),
						 ('HD_0016','KH_0016',N'NV_0002',CAST(N'2020-3-3' AS DATE), 26678700),
						 ('HD_0017','KH_0017',N'NV_0002',CAST(N'2020-3-3' AS DATE), 26678700),
						 ('HD_0018','KH_0018',N'NV_0002',CAST(N'2020-3-5' AS DATE), 26678700),
						 ('HD_0019','KH_0019',N'NV_0001',CAST(N'2020-3-5' AS DATE), 27908700),
						 ('HD_0020','KH_0020',N'NV_0001',CAST(N'2020-3-5' AS DATE), 27908700),
						 ('HD_0021','KH_0021',N'NV_0001',CAST(N'2020-3-5' AS DATE), 27908700)
GO

/*INSERT INTO chiTietPhieuNhap values('CTPN_0001',N'X_0001',20,20000000,N'Không'),
									('CTPN_0002',N'X_0002',14,25000000,N'Không'),
									('CTPN_0003',N'X_0003',10,35000000,N'Không')

GO*/

INSERT INTO chiTietHoaDon values('HD_0001','X_0001',24495000,1704000),
								('HD_0002','X_0002',24495000,1704000),
								('HD_0003','X_0003',24495000,1704000),
								('HD_0004','X_0004',24495000,1704000),
								('HD_0005','X_0005',20680000,940000),
								('HD_0006','X_0006',20680000,940000),
								('HD_0007','X_0007',20680000,940000),
								('HD_0008','X_0008',21780000,990000),
								('HD_0009','X_0009',21780000,990000),
								('HD_0010','X_0010',21780000,990000),
								('HD_0011','X_0011',28393500,1975000),
								('HD_0012','X_0012',28393500,1975000),
								('HD_0013','X_0013',28393500,1975000),
								('HD_0014','X_0014',28393500,1975000),
								('HD_0015','X_0015',24943500,1735200),
								('HD_0016','X_0016',24943500,1735200),
								('HD_0017','X_0017',24943500,1735200),
								('HD_0018','X_0018',24943500,1735200),
								('HD_0019','X_0019',26093500,1815200),
								('HD_0020','X_0020',26093500,1815200),
								('HD_0021','X_0021',26093500,1815200)
GO

INSERT INTO ChucVu values('CV_0001','Quản Lý'),
						('CV_0002','Nhân Viên')
			
GO

INSERT INTO NhanVien values('NV_0001',N'Bùi Thành Nam', '651452874961', N'Nam',N'448 Phan Huy ích Gò Vấp','thanhnam@gmail.com','0012467424','CV_0001',CAST(N'2016-5-3' AS DATE),CAST(N'1994-02-12' AS DATE)),
							('NV_0002',N'Trần Nhật Hưng', '784256341', N'Nam',N'12 Huỳnh Khương An Gò Vấp','Hung123@gmail.com','0253565748','CV_0002',CAST(N'2017-2-1' AS DATE),CAST(N'1996-08-12' AS DATE)),
							('NV_0003',N'Nguyễn Tuấn Khang', '324947512', N'Nam',N'54 Huỳnh Khương An Gò Vấp','TungKhang@gmail.com','0111112346','CV_0002',CAST(N'2017-4-4' AS DATE),CAST(N'1997-04-20' AS DATE)),
							('NV_0004',N'Nguyễn Thanh Hoài', '371955531', N'Nam',N'165 Phạm Văn Đồng Gò Vấp','Hoaibitly@gmail.com','0549621564','CV_0002',CAST(N'2017-8-6' AS DATE),CAST(N'2000-02-25' AS DATE))
GO

INSERT INTO TaiKhoan values('NV_0001','111111',N'Nhân Viên', N'Nhân viên thực tập'),
							('NV_0002','222222',N'Quản Lý', N'Nhân viên chính thức'),
							('NV_0003','222222',N'Nhân Viên', N'Nhân viên chính thức'),
							('NV_0004','18052451',N'Nhân Viên', N'Nhân viên chính thức')
GO

INSERT INTO HopDong values('HDG_0001','KH_0001','NV_0001','X_0001',CAST(N'2020-1-3' AS DATE),3),
						  ('HDG_0002','KH_0002','NV_0001','X_0002',CAST(N'2020-1-10'AS DATE),3),
						  ('HDG_0003','KH_0003','NV_0001','X_0003',CAST(N'2020-1-15' AS DATE),3),
						  ('HDG_0004','KH_0004','NV_0002','X_0004',CAST(N'2020-1-15' AS DATE),3),
						  ('HDG_0005','KH_0005','NV_0002','X_0005',CAST(N'2020-1-15' AS DATE),3),
						  ('HDG_0006','KH_0006','NV_0002','X_0006',CAST(N'2020-1-17' AS DATE),3),
						  ('HDG_0007','KH_0007','NV_0002','X_0007',CAST(N'2020-2-3' AS DATE),3),
						  ('HDG_0008','KH_0008','NV_0002','X_0008',CAST(N'2020-2-5' AS DATE),3),
						  ('HDG_0009','KH_0009','NV_0001','X_0009',CAST(N'2020-2-5' AS DATE),3),
						  ('HDG_0010','KH_0010','NV_0001','X_0010',CAST(N'2020-2-5' AS DATE),3),
						  ('HDG_0011','KH_0011','NV_0001','X_0011',CAST(N'2020-2-6' AS DATE),3),
						  ('HDG_0012','KH_0012','NV_0001','X_0012',CAST(N'2020-2-7' AS DATE),3),
						  ('HDG_0013','KH_0013','NV_0001','X_0013',CAST(N'2020-3-2' AS DATE),3),
						  ('HDG_0014','KH_0014','NV_0002','X_0014',CAST(N'2020-3-3' AS DATE),3),
						  ('HDG_0015','KH_0015','NV_0002','X_0015',CAST(N'2020-3-3' AS DATE),3),
						  ('HDG_0016','KH_0016','NV_0002','X_0016',CAST(N'2020-3-3' AS DATE),3),
						  ('HDG_0017','KH_0017','NV_0002','X_0017',CAST(N'2020-3-3' AS DATE),3),
						  ('HDG_0018','KH_0018','NV_0002','X_0018',CAST(N'2020-3-5' AS DATE),3),
						  ('HDG_0019','KH_0019','NV_0001','X_0019',CAST(N'2020-3-5' AS DATE),3),
						  ('HDG_0020','KH_0020','NV_0001','X_0020',CAST(N'2020-3-5' AS DATE),3),
						  ('HDG_0021','KH_0021','NV_0001','X_0021',CAST(N'2020-3-5' AS DATE),3)
GO

/*INSERT INTO PhieuNhap values('PN_0001','NV_0001','NCC_0001',CAST(N'2020-1-1' AS DATE),''),
							('PN_0002','NV_0002','NCC_0002',CAST(N'2020-3-6' AS DATE),''),
							('PN_0003','NV_0003','NCC_0003',CAST(N'2020-8-7' AS DATE),'')
GO*/