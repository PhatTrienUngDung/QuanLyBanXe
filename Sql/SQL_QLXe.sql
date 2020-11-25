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

--Loai Xe
CREATE TABLE [dbo].[LoaiXe](
	[maLoaiXe] [varchar](15) NOT NULL,
	[tenLoaiXe] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

--Nha cung cap
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [varchar](25) NOT NULL,
	[tenNhaCungCap] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[email] [nvarchar](50) NULL,
	[soDienThoai] [char](20) NULL,
	[chuThich] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

--Xe
CREATE TABLE [dbo].[Xe](
	[maXe] [varchar](15) NOT NULL,
	[tenXe] [nvarchar](50) NOT NULL,
	[maLoaiXe] [varchar](15) NOT NULL,
	[mauXe] [nvarchar](50) NOT NULL,
	[maNhaCungCap] [varchar](25) NOT NULL,
	[maHangSanXuat] [varchar](15) NOT NULL,
	[phanKhoi] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaNhap] [float] NOT NULL,
	[ngayNhap] [date] NOT NULL,
	[trangThai] [nvarchar](50) NULL,
	[chuThich] [nvarchar](50) NULL,
	[img1] [nvarchar](200) NOT NULL,
	[img2] [nvarchar](200) NULL,
	[img3] [nvarchar](200) NULL,
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
	[diaChi] [nvarchar](50) NULL,
	[email] [char](50) NULL,
	[soDienThoai] [char](11) NULL,
	[chuThich] [nvarchar](50) NULL,
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
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--Chi tiet phieu nhap
CREATE TABLE [dbo].[chiTietPhieuNhap](
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
GO

--Chi tiet hoa don
CREATE TABLE [dbo].[chiTietHoaDon](
	[maHoaDon] [varchar](15) NOT NULL,
	[maXe] [varchar](15) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[thueVAT] [float] NOT NULL
) ON [PRIMARY]
GO

--Chuc vu
CREATE TABLE [dbo].[ChucVu](
	[maChucVu] [varchar](15) NOT NULL,
	[tenChucVu] [char](15) NOT NULL,
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
	[diaChi] [nvarchar](50) NOT NULL,
	[email] [char](50) NULL,
	[soDienThoai] [char](15) NULL,
	[maChucVu] [varchar](15) NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[ngaySinh] [date] NOT NULL,
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
CREATE TABLE [dbo].[PhieuNhap](
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
GO

ALTER TABLE [dbo].[PhieuNhap] ADD CONSTRAINT [DF_PhieuNhap_NgayNhap] DEFAULT (getdate()) FOR [ngayNhap]
GO

ALTER TABLE [dbo].[Xe] ADD CONSTRAINT [DF_Xe_NgayNhap] DEFAULT (getdate()) FOR [ngayNhap]
GO

ALTER TABLE [dbo].[HoaDon] ADD CONSTRAINT [DF_HoaDon_NgayLHD] DEFAULT (getdate()) FOR [ngayLapHoaDon]
GO

ALTER TABLE [dbo].[HopDong] ADD CONSTRAINT [DF_HopDong_NgayLap] DEFAULT (getdate()) FOR [ngayLap]
GO

ALTER TABLE [dbo].[KhachHang] ADD CONSTRAINT [DF-KhachHang_NgayGiaNhap] DEFAULT (getdate()) FOR [ngayGiaNhap]
GO

ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO

ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[nhaCungCap] ([maNhaCungCap])
GO

ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO

ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([maHangSanXuat])
REFERENCES [dbo].[HangSanXuat] ([maHangSanXuat])
GO

ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([maLoaiXe])
REFERENCES [dbo].[LoaiXe] ([maLoaiXe])
GO

ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[nhaCungCap] ([maNhaCungCap])
GO

ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD FOREIGN KEY([maXe])
REFERENCES [dbo].[Xe] ([maXe])
GO

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

INSERT INTO HangSanXuat values('HSX_0001',N'Yamaha',N'Nhật Bản'),
							  ('HSX_0002',N'Vinfast',N'Việt Nam'),
							  ('HSX_0003',N'Honda',N'Nhật Bản')
GO

INSERT INTO LoaiXe values('LX_0001',N'Xe số'),
						 ('LX_0002',N'Xe tay ga'),
						 ('LX_0003',N'Xe tay côn')
GO

INSERT INTO NhaCungCap values('NCC_0001',N'Công Ty TNHH Thương Mại Ngọc Hoa',N'138-140 Hoàng Diệu, P. 9, Q. 4, Tp. Hồ Chí Minh',N'ngochoacty138@yahoo.com.vn',N'0839400925',N'Không'),
							 ('NCC_0002',N'Công Ty TNHH KBK Việt Nam Bearing',N'278 Trần Văn Kiểu, P. 11, Q. 6, Tp. Hồ Chí Minh',N'bearings_duyentran@yahoo.com',N'0837558396',N'Không'),
							 ('NCC_0003',N'CÔNG TY TNHH SẢN XUẤT VÀ THƯƠNG MẠI TIẾN LỘC',N' 27 Nguyễn Trung Trực, Phường Bến Thành, Quận 1, TP. Hồ Chí Minh ',N'tienlocco@hcm.vnn.vn',N'0835210350',N'Không')			 
GO

INSERT INTO Xe values('X_0001',N'Exciter 150 RC','LX_0002',N'Đen','NCC_0001','HSX_0001',150,20,20000000,CAST(N'2020-11-11' AS DATE),N'Còn hàng',N'Không','','',''),
					 ('X_0002',N'Exciter 150 CC','LX_0002',N'Đen','NCC_0001','HSX_0001',150,20,25000000,CAST(N'2020-11-11' AS DATE),N'Còn hàng',N'Không','','',''),
					 ('X_0003',N'Jupiter 150','LX_0002',N'Đỏ','NCC_0001','HSX_0001',150,20,35000000,CAST(N'2020-11-11' AS DATE),N'Còn hàng',N'Không','','','')
GO

INSERT INTO KhachHang values('KH_0001',N'Lê Tuấn Khang',N'312439087',N'Nam',CAST(N'2000-3-9'AS DATE),CAST(N'2020-1-3'AS DATE),N'Gò Vấp',N'Khangletuan098@gmail.com',N'0987654321',N'Không'),
							('KH_0002',N'Nguyễn Thanh Hoài',N'371955531',N'Nam',CAST(N'2000-4-9' AS DATE),CAST(N'2020-1-14'AS DATE),N'Gò Vấp',N'Nguyenthanhhoai@gmail.com',N'0987654321',N'Không'),
							('KH_0003',N'Nguyễn Trần Nhật Hưng',N'312239087',N'Nam',CAST(N'2000-2-9' AS DATE),CAST(N'2020-2-8'AS DATE),N'Gò Vấp',N'Nhathung@gmail.com',N'0937832233',N'Không'),
							('KH_0004',N'Bùi Thành Nam',N'312239087',N'Nam',CAST(N'2000-7-7' AS DATE),CAST(N'2020-2-26'AS DATE),N'Gò Vấp',N'Nambui@gmail.com',N'0987654321',N'Không')					
GO

INSERT INTO HoaDon values('HD_0001','KH_0001',N'NV_0001',CAST(N'2020-1-3' AS DATE)),
						 ('HD_0002','KH_0002',N'NV_0002',CAST(N'2020-1-14' AS DATE)),
					   	 ('HD_0003','KH_0003',N'NV_0003',CAST(N'2020-2-8' AS DATE))
GO

INSERT INTO chiTietPhieuNhap values('CTPN_0001',N'X_0001',20,20000000,N'Không'),
									('CTPN_0002',N'X_0002',14,25000000,N'Không'),
									('CTPN_0003',N'X_0003',10,35000000,N'Không')

GO

INSERT INTO chiTietHoaDon values('HD_0001','X_0001',2,20000000,2000000),
								('HD_0002','X_0002',1,25000000,1250000),
								('HD_0003','X_0003',1,35000000,1750000)
GO

INSERT INTO ChucVu values('CV_0001','QuanLy'),
						('CV_0002','NhanVien')
			
GO

INSERT INTO NhanVien values('NV_0001',N'Bùi Thành Nam', '651452874961', N'Nam',N'448 Phan Huy ích Gò Vấp','thanhnam@gmail.com','0012467424','CV_0001',CAST(N'2016-5-3' AS DATE),CAST(N'1994-02-12' AS DATE)),
							('NV_0002',N'Trần Nhật Hưng', '784256341', N'Nam',N'12 Huỳnh Khương An Gò Vấp','Hung123@gmail.com','0253565748','CV_0002',CAST(N'2017-2-1' AS DATE),CAST(N'1996-08-12' AS DATE)),
							('NV_0003',N'Nguyễn Tuấn Khang', '324947512', N'Nam',N'54 Huỳnh Khương An Gò Vấp','TungKhang@gmail.com','0111112346','CV_0002',CAST(N'2017-4-4' AS DATE),CAST(N'1997-04-20' AS DATE)),
							('NV_0004',N'Nguyễn Thanh Hoài', '371955531', N'Nam',N'165 Phạm Văn Đồng Gò Vấp','Hoaibitly@gmail.com','0549621564','CV_0002',CAST(N'2017-8-6' AS DATE),CAST(N'2000-02-25' AS DATE))
GO

INSERT INTO TaiKhoan values('NV_0001','111111',N'Nhân Viên', N'Nhân viên thực tập'),
							('NV_0002','222222',N'Quản Lý', N'Nhân viên chính thức')
GO

INSERT INTO HopDong values('HD_0001','KH_0001','NV_0001','X_0001',CAST(N'2020-1-4' AS DATE),1),
							('HD_0002','KH_0002','NV_0002','X_0002',CAST(N'2020-4-3'AS DATE),1),
							('HD_0003','KH_0003','NV_0002','X_0003',CAST(N'2020-6-4' AS DATE),1)
GO

INSERT INTO PhieuNhap values('PN_0001','NV_0001','NCC_0001',CAST(N'2020-1-1' AS DATE),''),
							('PN_0002','NV_0002','NCC_0002',CAST(N'2020-3-6' AS DATE),''),
							('PN_0003','NV_0003','NCC_0003',CAST(N'2020-8-7' AS DATE),'')
GO

select Top 1 maHoaDon from HoaDon order by maHoaDon desc
go

select HoaDon.maHoaDon, sum((ChiTietHoaDon.donGia + ChiTietHoaDon.thueVAT)*chiTietHoaDon.soLuong) as TongTien from HoaDon
inner join chiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon
group by chiTietHoaDon.maHoaDon, HoaDon.maHoaDon
go
