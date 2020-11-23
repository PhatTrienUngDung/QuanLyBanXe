package dao;

import java.lang.reflect.Array;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChucVu;
import entity.HopDong;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;
import entity.LoaiXe;

public class Dao_HopDong {
	private int n;
	public Dao_HopDong() {}
		//Load data
				public DefaultTableModel getAllHD() throws SQLException {
					String[] header=  {"Mã Hợp Đồng","Tên Khách Hàng","CMND","Ngày Sinh","Địa Chỉ","Số Điện Thoại","Tên Nhân Viên","Tên Xe","Loại Xe","Màu Xe","Phân Khối","Số Lượng","Gía Nhập","Tổng Tiền","Ngày Lập","Thời gian bảo hành"};
					DefaultTableModel tableModel = new DefaultTableModel(header, 0);
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					String sql = "SELECT  HopDong.maHopDong, KhachHang.tenKhachHang, KhachHang.CMND, KhachHang.ngaySinh, KhachHang.diaChi,KhachHang.soDienThoai, NhanVien.tenNhanVien, Xe.tenXe, LoaiXe.tenLoaiXe, Xe.mauXe, Xe.phanKhoi, chiTietHoaDon.soLuong, chiTietHoaDon.donGia, chiTietHoaDon.soLuong*chiTietHoaDon.donGia, HopDong.ngayLap, HopDong.thoiGianBH\r\n" + 
							"FROM     HopDong INNER JOIN\r\n" + 
							"                  KhachHang ON HopDong.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n" + 
							"                  NhanVien ON HopDong.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n" + 
							"                  Xe ON HopDong.maXe = Xe.maXe INNER JOIN\r\n" + 
							"                  LoaiXe ON Xe.maLoaiXe = LoaiXe.maLoaiXe INNER JOIN\r\n" + 
							"                  chiTietHoaDon ON Xe.maXe = chiTietHoaDon.maXe";
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while (rs.next()) {
						Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)};
						tableModel.addRow(o);
					}
					return tableModel;
				}
				
				public boolean themHD(HopDong hd) {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					PreparedStatement stmt = null;
					int n = 0;
					try {
						stmt = con.prepareStatement("insert into HopDong values(?,?,?,?,?,?)");
						stmt.setString(1, hd.getMaHD());
						stmt.setString(2,hd.getKhachHang().getMaKhachHang());
						stmt.setString(3, hd.getNhanVien().getMaNhanVien());
						stmt.setString(4, hd.getXe().getMaXe());						
						stmt.setDate(5, hd.getNgayLap());
						stmt.setInt(6, hd.getThoiGianBaoHanh());
					
						n = stmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							stmt.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					return n > 0;
				}
			
		//Tìm
			public DefaultTableModel timKiem(String maHD) throws SQLException {
				String[] header= {"Mã Hợp Đồng","Mã Khách Hàng","Mã Nhân Viên","Mã Xe","Ngày Lập","Thời gian bảo hành"};
				DefaultTableModel tableModel = new DefaultTableModel(header, 0);
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select *from HopDong where maHopDong='" + maHD + "'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8) };
					tableModel.addRow(o);
				}
				return tableModel;
			}
		//Thêm
			
			//Xóa dữ liệu khỏi bảng
				public void xoaHD(String maHD) throws SQLException {
					Connection a = ConnectDB.getCon();// Tao Ket Noi
					String sql = "delete HopDong where maHopDong='" + maHD + "'";
					PreparedStatement pstm = a.prepareStatement(sql);
					if (pstm.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công hợp đồng " + maHD);
					}
				}
		//	Cập nhật dữ liệu
				public boolean update(HopDong hd) {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					PreparedStatement stmt = null;
					int n = 0;
					try {
						
						stmt = con.prepareStatement(
								"update HopDong set maHopDong=?,maKhachHang=?,maNhanVien=?,maXe=?,ngayLap=?,thoiGianBH=? where maHopDong=?");
						stmt.setString(1, hd.getMaHD());
						stmt.setString(2, hd.getKhachHang().getMaKhachHang());
					//	stmt.setString(3, hd.getKhachHang().getCMND());
					//	stmt.setDate(4, hd.getKhachHang().getNgaySinh());
						
					//	stmt.setString(4, hd.getKhachHang().getDiaChi());
					//	stmt.setString(5, hd.getKhachHang().getSoDienThoai());
						stmt.setString(3, hd.getNhanVien().getMaNhanVien());
						stmt.setString(4, hd.getXe().getMaXe());
					//	stmt.setString(8, hd.getXe().getLoaiXe().getTenLoaiXe());
					//	stmt.setString(9, hd.getXe().getMauXe());
					//	stmt.setInt(10, hd.getXe().getPhanKhoi());
					//	stmt.setInt(11, hd.getXe().getSoLuong());
					//	stmt.setDouble(12, hd.getXe().getGiaNhap());
					
						
						
						stmt.setDate(5, hd.getNgayLap());
					
						stmt.setInt(6, hd.getThoiGianBaoHanh());
						stmt.setString(7, hd.getMaHD());
						n = stmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							stmt.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					return n > 0;
				}
				
				
				public ArrayList<NhanVien> getAllNV(){
					ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
					try {
						ConnectDB.getInstance();
						Connection con= ConnectDB.getCon();
						String sql= "select * from NhanVien";
						Statement statement= con.createStatement();
						ResultSet rs= statement.executeQuery(sql);
						
						while(rs.next()) {
							String maNV=rs.getString(1);
							String tenNV=rs.getString(2);
							NhanVien nv= new NhanVien(maNV,tenNV);
							dsNV.add(nv);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsNV;
				}
				public ArrayList<KhachHang> getAllKH(){
					ArrayList<KhachHang> dsKH=new ArrayList<KhachHang>();
					try {
						ConnectDB.getInstance();
						Connection con= ConnectDB.getCon();
						String sql= "select * from KhachHang";
						Statement statement= con.createStatement();
						ResultSet rs= statement.executeQuery(sql);
						
						while(rs.next()) {
							String maKH=rs.getString(1);
							String tenKH=rs.getString(2);
							String cmnd=rs.getString(3);
							Date ngaySinh = rs.getDate(5);
							String diaChi=rs.getString(6);
							String sdt = rs.getString(8);
							
							KhachHang kh= new KhachHang(maKH, tenKH, cmnd, ngaySinh, diaChi,sdt);
							dsKH.add(kh);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsKH;
				}
				public ArrayList<Xe> getAllXes(){
					ArrayList<Xe> dsXe=new ArrayList<Xe>();
					try {
						ConnectDB.getInstance();
						Connection con= ConnectDB.getCon();
						String sql= "select * from Xe";
						Statement statement= con.createStatement();
						ResultSet rs= statement.executeQuery(sql);
						
						while(rs.next()) {
							String maXe=rs.getString(1);
							String tenXe=rs.getString(2);
							String loaiXe = rs.getString(3);
							String mauXe = rs.getString(4);
							int phanKhoi = rs.getInt(7);
							double giaNhap = rs.getDouble(9);
							Xe xe= new Xe(maXe, tenXe,new LoaiXe(loaiXe), mauXe, phanKhoi, giaNhap);
							dsXe.add(xe);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsXe;
				}
				public ArrayList<LoaiXe> getAllLoai(){
					ArrayList<LoaiXe> dsLXe=new ArrayList<LoaiXe>();
					try {
						ConnectDB.getInstance();
						Connection con= ConnectDB.getCon();
						String sql= "select * from LoaiXe";
						Statement statement= con.createStatement();
						ResultSet rs= statement.executeQuery(sql);
						
						while(rs.next()) {
							String maLX=rs.getString(1);
							String tenLX=rs.getString(2);
							
							LoaiXe lx= new LoaiXe(maLX, tenLX);
							dsLXe.add(lx);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsLXe;
				}
				public void getList(String tenXe, JComboBox comboBox) {
					Connection con = ConnectDB.getCon();
					String sql = "select DISTINCT HangSanXuat.tenHangSanXuat from Xe, HangSanXuat where Xe.maHangSanXuat=HangSanXuat.maHangSanXuat and tenXe = ?";
					try {
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, tenXe);
						ResultSet rs = pst.executeQuery();
						while(rs.next()) {
							comboBox.addItem(rs.getString(1));
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1);
						e1.printStackTrace();
					}
				}
				
}
