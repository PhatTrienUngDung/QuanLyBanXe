Create database SQL_QLXe
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
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
					 ('X_0026',N'Future 125 FI','LX_0001',N'Vành đúc',N'Bạc - Nâu - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4669',N'JD5F148',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0027',N'Future 125 FI','LX_0001',N'Vành đúc',N'Đỏ - Nâu - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4670',N'JD5F149',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0028',N'Future 125 FI','LX_0001',N'Vành đúc',N'Xanh - Nâu - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4671',N'JD5F150',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0029',N'Future 125 FI','LX_0001',N'Vành đúc',N'Đen - Nâu','NCC_0001','HSX_0001',125,N'15368457E2354Y4672',N'JD5F151',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0030',N'Future 125 FI','LX_0001',N'Vành đúc',N'Trắng - Nâu - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4673',N'JD5F152',31390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0031',N'Future 125 FI','LX_0001',N'Vành nan hoa',N'Đỏ - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4674',N'JD5F153',30190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0032',N'Future 125 FI','LX_0001',N'Vành nan hoa',N'Xanh - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4675',N'JD5F154',30190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0033',N'Super Cub C125','LX_0001',N'C125',N'Xanh - Lam','NCC_0001','HSX_0001',125,N'15368457E2354Y4676',N'JD5F155',84990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0034',N'Super Cub C125','LX_0001',N'C125',N'Đỏ - Trắng','NCC_0001','HSX_0001',125,N'15368457E2354Y4677',N'JD5F156',84990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0035',N'Super Cub C125','LX_0001',N'C125',N'Xanh - Lam - Xám','NCC_0001','HSX_0001',125,N'15368457E2354Y4678',N'JD5F157',84990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0036',N'Sh mode 125','LX_0002',N'Phiên bản Cá tính (ABS)',N'Đỏ - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4679',N'JD5F158',58990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0037',N'Sh mode 125','LX_0002',N'Phiên bản Cá tính (ABS)',N'Bạc - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4680',N'JD5F159',58990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0038',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Đỏ - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4681',N'JD5F160',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0039',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Xanh - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4682',N'JD5F161',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0040',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Bạc - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4683',N'JD5F162',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0041',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Trắng - Nâu','NCC_0001','HSX_0001',125,N'15368457E2354Y4684',N'JD5F163',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0042',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (ABS)',N'Vàng - Nâu','NCC_0001','HSX_0001',125,N'15368457E2354Y4685',N'JD5F164',57890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0043',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (CBS)',N'Đỏ - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4686',N'JD5F165',53890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0044',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (CBS)',N'Vàng - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4687',N'JD5F166',53890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0045',N'Sh mode 125','LX_0002',N'Phiên bản Thời trang (CBS)',N'Xanh - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4688',N'JD5F167',53890000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0046',N'Air Blade 125/150','LX_0002',N'Phiên bản Đặc biệt',N'Đen - Vàng','NCC_0001','HSX_0001',125,N'15368457E2354Y4689',N'JD5F168',42390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0047',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Đỏ - Đen - Xám','NCC_0001','HSX_0001',125,N'15368457E2354Y4690',N'JD5F169',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0048',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Xanh - Đen - Xám','NCC_0001','HSX_0001',125,N'15368457E2354Y4691',N'JD5F170',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0049',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Bạc - Xanh - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4692',N'JD5F171',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0050',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Trắng - Đỏ - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4693',N'JD5F172',41190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0051',N'Air Blade 125/150','LX_0002',N'Phiên bản Đặc biệt',N'Xanh - Xám - Đen','NCC_0001','HSX_0001',125,N'15368457E2354Y4694',N'JD5F173',56390000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0052',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Đỏ - Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4695',N'JD5F174',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0053',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Xanh - Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4696',N'JD5F175',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0054',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Xám - Đen - Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4697',N'JD5F176',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0055',N'Air Blade 125/150','LX_0002',N'Phiên bản Tiêu chuẩn',N'Đen - Bạc','NCC_0001','HSX_0001',125,N'15368457E2354Y4698',N'JD5F177',55190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0056',N'Vision','LX_0002',N'Phiên bản Cao cấp',N'Xanh - Lam - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4699',N'JD5F178',30790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0057',N'Vision','LX_0002',N'Phiên bản Cao cấp',N'Xanh - Lục - Nâu','NCC_0001','HSX_0001',110,N'15368457E2354Y4747',N'JD5F179',30790000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
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
					 ('X_0068',N'Winner X','LX_0003',N'Phiên bản Đen mờ',N'Đen - Vàng - Đồng','NCC_0001','HSX_0001',150,N'15368457E2354Y4758',N'JD5F190',49490000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
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
					 ('X_0080',N'Exciter','LX_0003',N'Phiên bản Giới hạn',N'Xanh - Lá - Đen','NCC_0001','HSX_0004',150,N'15368457E2354Y4769',N'JD5F201',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0081',N'Exciter','LX_0003',N'Phiên bản Doxou',N'Đen - Hồng','NCC_0001','HSX_0004',150,N'15368457E2354Y4770',N'JD5F202',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0082',N'Exciter','LX_0003',N'Phiên bản Movistar',N'Đen','NCC_0001','HSX_0004',150,N'15368457E2354Y4771',N'JD5F203',47990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0083',N'Exciter','LX_0003',N'GP phiên bản mới',N'Đen','NCC_0001','HSX_0004',150,N'15368457E2354Y4772',N'JD5F204',47490000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0084',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Đen','NCC_0001','HSX_0004',115,N'15368457E2354Y4773',N'JD5F205',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0085',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Đỏ','NCC_0001','HSX_0004',115,N'15368457E2354Y4774',N'JD5F206',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0086',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Xám - Cam','NCC_0001','HSX_0004',115,N'15368457E2354Y4775',N'JD5F207',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0087',N'Sirius FI','LX_0001',N'RC Vành Đúc',N'Trắng - Đen','NCC_0001','HSX_0004',115,N'15368457E2354Y4776',N'JD5F208',23190000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0088',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Đỏ - Đen','NCC_0001','HSX_0004',115,N'15368457E2354Y4777',N'JD5F1209',1340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0089',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Đen - Xám','NCC_0001','HSX_0004',115,N'15368457E2354Y4778',N'JD5F210',21340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0090',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Xanh - Xám','NCC_0001','HSX_0004',115,N'15368457E2354Y4779',N'JD5F211',21340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0091',N'Sirius FI','LX_0001',N'Phanh đĩa',N'Xám','NCC_0001','HSX_0004',115,N'15368457E2354Y4780',N'JD5F212',21340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0092',N'Sirius FI','LX_0001',N'Phanh cơ',N'Đen','NCC_0001','HSX_0004',115,N'15368457E2354Y4781',N'JD5F213',20340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0093',N'Sirius FI','LX_0001',N'Phanh cơ',N'Đỏ','NCC_0001','HSX_0004',115,N'15368457E2354Y4782',N'JD5F214',2040000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0094',N'Sirius FI','LX_0001',N'Phanh cơ',N'Xanh','NCC_0001','HSX_0004',115,N'15368457E2354Y4783',N'JD5F215',20340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0095',N'Sirius FI','LX_0001',N'Phanh cơ',N'Xám','NCC_0001','HSX_0004',115,N'15368457E2354Y4784',N'JD5F216',20340000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0096',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản giới hạn',N'Bạc','NCC_0001','HSX_0004',125,N'15368457E2354Y4785',N'JD5F217',50000000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0097',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản giới hạn',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4786',N'JD5F218',50000000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0098',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản giới hạn',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4787',N'JD5F219',50000000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0099',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản tiêu chuẩn',N'Đỏ - Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4788',N'JD5F220',45500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0100',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản tiêu chuẩn',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4789',N'JD5F221',45500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0101',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản tiêu chuẩn',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4790',N'JD5F222',45500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0102',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4791',N'JD5F223',49500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0103',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản đặc biệt',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4791',N'JD5F224',49500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0104',N'Grand (Blue Core Hybrid)','LX_0002',N'Phiên bản đặc biệt',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4792',N'JD5F225',49500000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0105',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4793',N'JD5F226',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0106',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Xanh Dương','NCC_0001','HSX_0004',125,N'15368457E2354Y4794',N'JD5F227',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0107',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4795',N'JD5F228',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0108',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Premium (phiên bản đặc biệt)',N'Nâu','NCC_0001','HSX_0004',125,N'15368457E2354Y4796',N'JD5F229',43990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0109',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Xanh lá','NCC_0001','HSX_0004',125,N'15368457E2354Y4797',N'JD5F230',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0110',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Xanh lá','NCC_0001','HSX_0004',125,N'15368457E2354Y4798',N'JD5F231',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0111',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Xanh dương','NCC_0001','HSX_0004',125,N'15368457E2354Y4799',N'JD5F232',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					 ('X_0112',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4800',N'JD5F233',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					('X_0113',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4801',N'JD5F234',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					('X_0114',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4802',N'JD5F235',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					('X_0115',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4803',N'JD5F236',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					('X_0116',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4804',N'JD5F237',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					('X_0117',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4805',N'JD5F238',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					('X_0118',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4806',N'JD5F239',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					('X_0119',N'Grand (Blue Core Hybrid)','LX_0002',N'Grande Deluxe (phiên bản cao cấp)',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4807',N'JD5F240',41990000,CAST(N'2020-05-10' AS DATE),N'Còn hàng',N'',''),
					
					('X_0120',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4812',N'JD5F245',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0121',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4813',N'JD5F246',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0122',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4814',N'JD5F247',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0123',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4815',N'JD5F248',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0124',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4816',N'JD5F249',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0125',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4817',N'JD5F250',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0126',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4818',N'JD5F251',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0127',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4819',N'JD5F252',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0128',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4820',N'JD5F253',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0129',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4821',N'JD5F254',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0130',N'Super Cup','LX_0001',N'Super Cup C125',N'Xanh','NCC_0001','HSX_0004',125,N'15368457E2354Y4822',N'JD5F255',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0131',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4823',N'JD5F256',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0132',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4824',N'JD5F257',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0133',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4825',N'JD5F258',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0134',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4826',N'JD5F259',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0135',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4827',N'JD5F260',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0136',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4828',N'JD5F261',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0137',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4829',N'JD5F262',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0138',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4830 ',N'JD5F263',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0139',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4831',N'JD5F264',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0140',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4832',N'JD5F265',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0141',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4833',N'JD5F266',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0142',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4834',N'JD5F267',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0143',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4835',N'JD5F268',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0144',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4836',N'JD5F269',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0145',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4837',N'JD5F270',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0146',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4838',N'JD5F271',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0147',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4839',N'JD5F272',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0148',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4840',N'JD5F273',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0149',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4841',N'JD5F274',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0150',N'Super Cup','LX_0001',N'Super Cup C125',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4842',N'JD5F275',41990000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0151',N'Lead','LX_0002',N'Lead 125FI',N'Đỏ','NCC_0001','HSX_0004',125,N'15368457E2354Y4841',N'JD5F276',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0152',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4842',N'JD5F277',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0153',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4843',N'JD5F278',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0154',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4844',N'JD5F279',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
					('X_0155',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4845',N'JD5F280',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0156',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4846',N'JD5F281',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0157',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4847',N'JD5F282',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0158',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4848',N'JD5F283',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0159',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4849',N'JD5F284',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0160',N'Lead','LX_0001',N'Lead 125FI',N'Đỏ','NCC_0002','HSX_0004',125,N'15368457E2354Y4850',N'JD5F285',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0161',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4851',N'JD5F286',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0162',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4852',N'JD5F287',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0163',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4853',N'JD5F288',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0164',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4854',N'JD5F289',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0165',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4855',N'JD5F290',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0166',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4856',N'JD5F291',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0167',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4857',N'JD5F292',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0168',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4858',N'JD5F293',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0169',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4859',N'JD5F294',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0170',N'Lead','LX_0001',N'Lead 125FI',N'Đen','NCC_0002','HSX_0004',125,N'15368457E2354Y4860',N'JD5F295',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0171',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4861',N'JD5F296',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0172',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4862',N'JD5F297',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0173',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4863',N'JD5F298',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0174',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4864',N'JD5F299',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0175',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4865',N'JD5F300',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0176',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4866',N'JD5F301',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0177',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4867',N'JD5F302',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0178',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4868',N'JD5F303',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0179',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4869',N'JD5F304',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0180',N'Lead','LX_0001',N'Lead 125FI',N'Xám','NCC_0002','HSX_0004',125,N'15368457E2354Y4870',N'JD5F305',38000000,CAST(N'2020-06-10' AS DATE),N'Còn hàng',N'',''),
('X_0181',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4871',N'JD5F306',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0182',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4872',N'JD5F307',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0183',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4873',N'JD5F308',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0184',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4874',N'JD5F309',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0185',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4875',N'JD5F310',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0186',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4876',N'JD5F311',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0187',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4877',N'JD5F312',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0188',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4878',N'JD5F313',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0189',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4879',N'JD5F314',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0190',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4880',N'JD5F315',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0191',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4881',N'JD5F316',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0192',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4882',N'JD5F317',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0193',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4883',N'JD5F318',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0194',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4884',N'JD5F319',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0195',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4885',N'JD5F320',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0196',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4886',N'JD5F321',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0197',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4887',N'JD5F322',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0198',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4888',N'JD5F323',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0199',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4889',N'JD5F324',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0200',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Xám','NCC_0001','HSX_0004',125,N'15368457E2354Y4890',N'JD5F325',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0201',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4891',N'JD5F326',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0202',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4892',N'JD5F327',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0203',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4893',N'JD5F328',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0204',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4894',N'JD5F329',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0205',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4895',N'JD5F330',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0206',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4896',N'JD5F331',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0207',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4897',N'JD5F332',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0208',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4898',N'JD5F333',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0209',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4899',N'JD5F334',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0210',N'Winner X','LX_0002',N'Phiên bản thể thao',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4900',N'JD5F335',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0211',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4901',N'JD5F336',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0212',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4902',N'JD5F337',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0213',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4903',N'JD5F338',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0214',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4904',N'JD5F339',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0215',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4905',N'JD5F340',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0216',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4906',N'JD5F341',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0217',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4907',N'JD5F342',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0218',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4908',N'JD5F343',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0219',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4909',N'JD5F344',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0220',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4910',N'JD5F345',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0221',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4911',N'JD5F336',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0222',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4912',N'JD5F337',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0223',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4913',N'JD5F338',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0224',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4914',N'JD5F339',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0225',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4915',N'JD5F340',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0226',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4916',N'JD5F341',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0227',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4917',N'JD5F342',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0228',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4918',N'JD5F343',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0229',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4919',N'JD5F344',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0230',N'Winner X','LX_0002',N'Phiên bản cá tính',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4920',N'JD5F345',49000000,CAST(N'2020-03-10' AS DATE),N'Còn hàng',N'',''),
('X_0231',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4921',N'JD5F346',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0232',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4922',N'JD5F347',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0233',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4923',N'JD5F348',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0234',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4924',N'JD5F349',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0235',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4925',N'JD5F350',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0236',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4926',N'JD5F351',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0237',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4927',N'JD5F352',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0238',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4928',N'JD5F353',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0239',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4929',N'JD5F354',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0240',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4930',N'JD5F355',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0241',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4931',N'JD5F356',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0242',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4932',N'JD5F357',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0243',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4933',N'JD5F358',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0244',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4934',N'JD5F359',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0245',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4935',N'JD5F360',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0246',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4936',N'JD5F361',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0247',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4937',N'JD5F362',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0248',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4938',N'JD5F363',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0249',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4939',N'JD5F364',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0250',N'Winner X','LX_0002',N'Phiên bản Camo',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4940',N'JD5F365',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0251',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4941',N'JD5F366',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0252',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Trắng','NCC_0001','HSX_0004',125,N'15368457E2354Y4942',N'JD5F367',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0253',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4943',N'JD5F368',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0254',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4944',N'JD5F369',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0255',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4945',N'JD5F370',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0256',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4946',N'JD5F371',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0257',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4947',N'JD5F372',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0258',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4948',N'JD5F373',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0259',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4949',N'JD5F374',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0260',N'Winner X','LX_0002',N'Phiên bản Đen mờ',N'Đen','NCC_0001','HSX_0004',125,N'15368457E2354Y4950',N'JD5F375',49000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0261',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4951',N'JD5F376',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0262',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4952',N'JD5F377',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0263',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4953',N'JD5F378',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0264',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4954',N'JD5F379',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0265',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4955',N'JD5F380',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0266',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4956',N'JD5F381',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0267',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4957',N'JD5F382',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0268',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4958',N'JD5F383',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0269',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4959',N'JD5F384',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0270',N'Rebel','LX_0002',N'Phiên bản Rebel 500',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4960',N'JD5F385',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0271',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4961',N'JD5F386',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0272',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4962',N'JD5F387',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0273',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4963',N'JD5F388',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0274',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4964',N'JD5F389',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0275',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4965',N'JD5F390',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0276',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4966',N'JD5F391',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0277',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4967',N'JD5F392',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0278',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4968',N'JD5F393',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0279',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4969',N'JD5F394',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0280',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen','NCC_0002','HSX_0003',250,N'15368457E2354Y4970',N'JD5F395',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0281',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4971',N'JD5F396',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0282',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4972',N'JD5F397',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0283',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4973',N'JD5F398',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0284',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4974',N'JD5F399',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0285',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4975',N'JD5F400',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0286',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4976',N'JD5F401',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0287',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4977',N'JD5F402',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0288',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4978',N'JD5F403',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0289',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4979',N'JD5F404',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0290',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Đen - Đỏ','NCC_0002','HSX_0003',250,N'15368457E2354Y4980',N'JD5F405',180000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0291',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4981',N'JD5F406',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0292',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4982',N'JD5F407',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0293',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4983',N'JD5F408',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0294',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4984',N'JD5F409',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0295',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4985',N'JD5F410',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0296',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4986',N'JD5F411',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0297',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4987',N'JD5F412',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0298',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4988',N'JD5F413',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0299',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4989',N'JD5F414',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0300',N'Rebel','LX_0002',N'Phiên bản Rebel 300',N'Bạc','NCC_0002','HSX_0003',250,N'15368457E2354Y4990',N'JD5F415',125000000,CAST(N'2020-01-10' AS DATE),N'Còn hàng',N'',''),
('X_0301',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4991',N'JD5F416',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0302',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4992',N'JD5F417',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0303',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4993',N'JD5F418',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0304',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4994',N'JD5F419',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0305',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4995',N'JD5F420',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0306',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4996',N'JD5F421',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0307',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4997',N'JD5F422',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0308',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4998',N'JD5F423',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0309',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y4999',N'JD5F424',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0310',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5000',N'JD5F425',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0311',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5001',N'JD5F426',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0312',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5002',N'JD5F427',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0313',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5003',N'JD5F428',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0314',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5004',N'JD5F429',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0315',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5005',N'JD5F430',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0316',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5006',N'JD5F431',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0317',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5007',N'JD5F432',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0318',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5008',N'JD5F433',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0319',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5009',N'JD5F434',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0320',N'Honda Mokey 2020','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5010',N'JD5F435',85000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0321',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5011',N'JD5F436',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0322',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5012',N'JD5F437',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0323',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5013',N'JD5F438',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0324',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5014',N'JD5F439',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0325',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5015',N'JD5F440',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0326',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5016',N'JD5F441',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0327',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5017',N'JD5F442',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0328',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5018',N'JD5F443',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0329',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5019',N'JD5F444',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0330',N'SH MODE 125','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5020',N'JD5F445',53890000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0331',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5021',N'JD5F436',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0332',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5022',N'JD5F437',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0333',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5023',N'JD5F438',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0334',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5024',N'JD5F439',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0335',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5025',N'JD5F440',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0336',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5026',N'JD5F441',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0337',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5027',N'JD5F442',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0338',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5028',N'JD5F443',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0339',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5029',N'JD5F444',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0340',N'Air Blade 125/150','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5030',N'JD5F445',41190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0341',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5031',N'JD5F436',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0342',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5032',N'JD5F436',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0343',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5033',N'JD5F436',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
					
('X_0344',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5034',N'JD5F436',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0345',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5035',N'JD5F436',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
					
('X_0346',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5036',N'JD5F436',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
					
('X_0347',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5037',N'JD5F437',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
					
('X_0348',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5038',N'JD5F438',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
					
('X_0349',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5039',N'JD5F439',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
					
('X_0350',N'SH 125i/150i','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5040',N'JD5F440',70990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0351',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5041',N'JD5F441',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0352',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5042',N'JD5F442',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0353',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5043',N'JD5F443',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0354',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5044',N'JD5F444',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0355',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5045',N'JD5F445',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0356',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5046',N'JD5F446',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0357',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5047',N'JD5F447',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0358',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5048',N'JD5F448',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0359',N'PCX 125 - PCX 150','LX_0002',N'Phiên bản LCD',N'Xám','NCC_0002','HSX_0003',125,N'15368457E2354Y5049',N'JD5F449',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0360',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5050',N'JD5F450',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),				
('X_0361','NVision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5051',N'JD5F451',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),									
('X_0362',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5052',N'JD5F452',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0363',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5053',N'JD5F453',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0364',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5054',N'JD5F454',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0365',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5055',N'JD5F455',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0366',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5056',N'JD5F456',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0367',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5057',N'JD5F457',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0368',N'Vision','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5058',N'JD5F458',29990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0370',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5059',N'JD5F459',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),					
('X_0371',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5060',N'JD5F460',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0372',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5061',N'JD5F461',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0373',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5062',N'JD5F462',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0374',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5063',N'JD5F463',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0375',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5064',N'JD5F464',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0376',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5065',N'JD5F465',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0377',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5066',N'JD5F466',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0378',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5067',N'JD5F467',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0379',N'Lead 125 FI','LX_0002',N'Phiên bản LCD',N'Xanh lam','NCC_0002','HSX_0003',125,N'15368457E2354Y5068',N'JD5F468',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,				
('X_0380',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5069',N'JD5F469',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),							
('X_0381',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5070',N'JD5F470',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0382',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5071',N'JD5F471',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0383',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5072',N'JD5F472',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0384',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5073',N'JD5F473',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0385',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5074',N'JD5F474',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0386',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5075',N'JD5F475',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0387',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5076',N'JD5F476',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0388',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5077',N'JD5F477',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0389',N'PCX Hybrid','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5078',N'JD5F478',89990000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0390',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5089',N'JD5F489',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0391',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5090',N'JD5F490',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0392',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5091',N'JD5F491',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0393',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5092',N'JD5F492',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0394',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5093',N'JD5F493',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0395',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5094',N'JD5F494',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0396',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5095',N'JD5F495',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0397',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5096',N'JD5F496',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0398',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5097',N'JD5F497',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0399',N'Honda Wave Alpha','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5098',N'JD5F498',25000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0400',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5099',N'JD5F499',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0401',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5100',N'JD5F100',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0402',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5101',N'JD5F101',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0403',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5102',N'JD5F102',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0404',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5103',N'JD5F103',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0405',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5104',N'JD5F104',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0406',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5105',N'JD5F105',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0407',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5106',N'JD5F106',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),

('X_0408',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5108',N'JD5F108',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0409',N'Vision 2020','LX_0002',N'Phiên bản LCD',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5109',N'JD5F109',30790000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0410',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5110',N'JD5F110',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0411',N'Air Blade 150 ABS','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5111',N'JD5F111',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0412',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5112',N'JD5F112',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0413',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5113',N'JD5F113',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0414',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5114',N'JD5F114',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0415',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5115',N'JD5F115',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0416',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5116',N'JD5F116',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0417',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5117',N'JD5F117',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0418',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5118',N'JD5F118',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0419',N'Air Blade 150 ABS 2020','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5119',N'JD5F119',55190000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0420',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5120',N'JD5F120',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0421',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5121',N'JD5F121',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0422',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5122',N'JD5F122',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0423',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5123',N'JD5F123',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0424',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5124',N'JD5F124',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0425',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5125',N'JD5F125',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0426',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5126',N'JD5F126',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0427',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5127',N'JD5F127',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0428',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5128',N'JD5F128',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0429',N'Lead 2020','LX_0002',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5129',N'JD5F129',38290000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0430',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5130',N'JD5F130',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0431',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5131',N'JD5F131',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0432',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5132',N'JD5F132',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0433',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5133',N'JD5F133',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0434',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5134',N'JD5F134',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0435',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5135',N'JD5F135',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0436',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5136',N'JD5F136',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0437',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5137',N'JD5F137',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0438',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5138',N'JD5F138',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0439',N'PCX 2020 phiên bản 125cc','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5139',N'JD5F139',56490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0440',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5140',N'JD5F140',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0441',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5141',N'JD5F141',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0442',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5142',N'JD5F142',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0443',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5143',N'JD5F143',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0444',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5144',N'JD5F144',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0445',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5145',N'JD5F145',65900000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0446',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5146',N'JD5F146',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0447',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5147',N'JD5F147',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0448',N'SH Mode','LX_0002',N'Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5148',N'JD5F148',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0449',N'SH Mode','LX_0002','Phiên bản LCD',N'Bạc','NCC_0002','HSX_0003',125,N'15368457E2354Y5149',N'JD5F149',65490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0450',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5150',N'JD5F150',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0451',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5151',N'JD5F151',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0452',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5152',N'JD5F152',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0453',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5153',N'JD5F153',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0454',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5154',N'JD5F154',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0455',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5155',N'JD5F155',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0456',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5156',N'JD5F156',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0457',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5157',N'JD5F157',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0458',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5158',N'JD5F158',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0459',N'Wave RS 150CC','LX_0001',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5159',N'JD5F159',34490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0460',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5160',N'JD5F160',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0461',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5161',N'JD5F161',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0462',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5162',N'JD5F162',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0463',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5163',N'JD5F163',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0464',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5164',N'JD5F164',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0465',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5165',N'JD5F165',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0466',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5166',N'JD5F166',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0467',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5167',N'JD5F167',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0468',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5168',N'JD5F168',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0469',N'HondaX ','LX_0001',N'Phiên bản LCD',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5169',N'JD5F169',63490000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0470',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5170',N'JD5F170',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0471',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5171',N'JD5F171',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0472',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5172',N'JD5F172',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0473',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5173',N'JD5F173',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0474',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5174',N'JD5F174',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0475',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5175',N'JD5F175',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0476',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5176',N'JD5F176',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0477',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5177',N'JD5F177',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0478',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5178',N'JD5F178',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0479',N'WinnerX ','LX_0001',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5179',N'JD5F179',44000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0480',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5180',N'JD5F180',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0481',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5181',N'JD5F181',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0482',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5182',N'JD5F182',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0483',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5183',N'JD5F183',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0484',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5184',N'JD5F184',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0485',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5185',N'JD5F185',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0486',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5186',N'JD5F186',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0487',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5187',N'JD5F187',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0488',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5188',N'JD5F188',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0489',N'Exciter 150cc','LX_0001',N'Phiên bản đặc biệt',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5189',N'JD5F189',46000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0490',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5190',N'JD5F190',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0491',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5191',N'JD5F191',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0492',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5192',N'JD5F192',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0493',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5193',N'JD5F193',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0494',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5194',N'JD5F194',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0495',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5195',N'JD5F195',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0496',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5196',N'JD5F196',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0497',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5197',N'JD5F197',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0498',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5198',N'JD5F198',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0499',N'Lead 150','LX_0002',N'Phiên bản đặc biệt',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5199',N'JD5F199',56000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),		
('X_0500',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5200',N'JD5F200',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0501',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5201',N'JD5F201',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0502',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5202',N'JD5F202',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0503',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5203',N'JD5F203',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0504',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5204',N'JD5F204',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0505',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5205',N'JD5F205',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0506',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5206',N'JD5F206',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0507',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5207',N'JD5F207',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0508',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5208',N'JD5F208',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0509',N'Vespa Sprint','LX_0002',N'Phiên bản đặc biệt',N'Cam','NCC_0002','HSX_0003',125,N'15368457E2354Y5209',N'JD5F209',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0510',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5210',N'JD5F210',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0511',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5211',N'JD5F211',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0512',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5212',N'JD5F212',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0513',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5213',N'JD5F213',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0514',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5214',N'JD5F214',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0515',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5215',N'JD5F215',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0516',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5216',N'JD5F216',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0517',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5217',N'JD5F217',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0518',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5218',N'JD5F218',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0519',N'Honda PCX 2020','LX_0002',N'Phiên bản đặc biệt',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5219',N'JD5F219',86000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0520',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5220',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0521',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5221',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0522',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5222',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0523',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5223',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0524',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5224',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0525',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5225',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0526',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5226',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0527',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5227',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0528',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5228',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0529',N'Suzuki Satria 2021','LX_0002',N'Phiên bản đặc biệt',N'Đen','NCC_0002','HSX_0003',125,N'15368457E2354Y5229',N'JD5F220',52000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0530',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5230',N'JD5F230',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0531',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5232',N'JD5F232',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0532',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5233',N'JD5F233',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0533',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5234',N'JD5F234',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0534',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5235',N'JD5F235',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0535',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5236',N'JD5F236',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0536',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5237',N'JD5F237',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0537',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5238',N'JD5F238',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0538',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5239',N'JD5F239',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0539',N'GSX S150','LX_0002',N'Phiên bản LCD',N'Đỏ','NCC_0002','HSX_0003',125,N'15368457E2354Y5240',N'JD5F240',67000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0540',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5241',N'JD5F241',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0541',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5242',N'JD5F242',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0542',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5243',N'JD5F243',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0543',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5244',N'JD5F244',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0544',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5245',N'JD5F245',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0545',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5246',N'JD5F246',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0546',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5247',N'JD5F247',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0547',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5248',N'JD5F248',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0548',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5249',N'JD5F249',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0549',N'GSX R150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y0000',N'JD5F000',74000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0550',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5250',N'JD5F250',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0551',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5251',N'JD5F251',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0552',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5252',N'JD5F252',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0553',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5253',N'JD5F253',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0554',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5254',N'JD5F254',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0555',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5255',N'JD5F255',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0556',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5256',N'JD5F256',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0557',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5257',N'JD5F257',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0558',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5258',N'JD5F258',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0559',N'Intruder 150','LX_0002',N'Phiên bản LCD',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5259',N'JD5F259',89000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0560',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5260',N'JD5F260',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0561',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5261',N'JD5F261',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0562',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5262',N'JD5F262',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0563',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5263',N'JD5F263',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0564',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5264',N'JD5F264',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0565',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5265',N'JD5F265',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0566',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5266',N'JD5F266',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0567',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5267',N'JD5F267',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0568',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5268',N'JD5F268',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0569',N'Raider 2021','LX_0002',N'Phiên bản LCD',N'Vàng','NCC_0002','HSX_0003',125,N'15368457E2354Y5269',N'JD5F269',49000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')	,
('X_0570',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5270',N'JD5F270',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0571',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5271',N'JD5F271',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0572',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5272',N'JD5F272',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0573',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5273',N'JD5F273',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0574',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5274',N'JD5F274',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0575',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5275',N'JD5F275',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0576',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5276',N'JD5F276',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0577',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5277',N'JD5F277',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0578',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5278',N'JD5F278',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0579',N'GD110','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5279',N'JD5F279',28000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),	
('X_0590',N'GD111','LX_0002',N'Phiên bản LX',N'Trắng','NCC_0002','HSX_0003',125,N'15368457E2354Y5280',N'JD5F280',35000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0591',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5281',N'JD5F281',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0592',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5282',N'JD5F282',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0593',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5283',N'JD5F283',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0594',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5284',N'JD5F284',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0595',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5285',N'JD5F285',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0596',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5286',N'JD5F286',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0597',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5287',N'JD5F287',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0598',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5288',N'JD5F288',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0599',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5289',N'JD5F289',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'',''),
('X_0600',N'AXELO 125','LX_0002',N'Phiên bản LX',N'Xanh','NCC_0002','HSX_0003',125,N'15368457E2354Y5290',N'JD5F290',24000000,CAST(N'2020-02-10' AS DATE),N'Còn hàng',N'','')

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

INSERT INTO ChucVu values('CV_0001',N'Quản Lý'),
						('CV_0002',N'Nhân Viên')
			
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

select * from HoaDon
select * from ChiTietHoaDon

select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNhanVien), TaiKhoan.*, tenNhanVien
from TaiKhoan, NhanVien
				where TaiKhoan.maNhanvien = NhanVien.maNhanVien
go
select hd.*, kh.tenKhachHang, kh.CMND, nv.tenNhanVien from HoaDon hd, KhachHang kh, NhanVien nv
where hd.maKhachHang = kh.maKhachHang and hd.maNhanVien = nv.maNhanVien

SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.CMND, NhanVien.gioiTinh, NhanVien.diaChi, NhanVien.email, NhanVien.soDienThoai, NhanVien.ngayVaoLam, NhanVien.ngaySinh, ChucVu.tenChucVu
				FROM     NhanVien INNER JOIN
				                  ChucVu ON NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND 
				                  NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu 