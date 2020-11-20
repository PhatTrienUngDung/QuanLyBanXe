package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.ChiTietPhieuNhap;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.NhanVien;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 13, 2020
* @version: 1.0
*/
import entity.PhieuNhap;
import entity.Xe;
public class Dao_PhieuNhap {
	private ArrayList<PhieuNhap> listPhieuNhap;
	PhieuNhap phieuNhap;
	private int n;
	public Dao_PhieuNhap() {}
	// Lấy toàn bộ nhà cung cấp 
		public ArrayList<NhaCungCap> getAllNCC(){
			ArrayList<NhaCungCap> dsNCC=new ArrayList<NhaCungCap>();
			try {
				ConnectDB.getInstance();
				Connection con= ConnectDB.getCon();
				String sql= "select * from nhaCungCap";
				Statement statement= con.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				
				while(rs.next()) {
					String maNcc0=rs.getString(1);
					String tenNCC=rs.getString(2);
					NhaCungCap ncc= new NhaCungCap(maNcc0);
					dsNCC.add(ncc);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsNCC;
		}
	//Lấy 1 nhà cung cấp được chọn
		public ArrayList<NhaCungCap> getAllNCC(String id){
			ArrayList<NhaCungCap> dsNCC=new ArrayList<NhaCungCap>();
			try {
				ConnectDB.getInstance();
				Connection con= ConnectDB.getCon();
				String sql= "select * from nhaCungCap where maNhaCungCap='"+id+"'";
				Statement statement= con.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				
				while(rs.next()) {
					String maNcc0=rs.getString(1);
					String tenNCC=rs.getString(2);
					NhaCungCap ncc= new NhaCungCap(maNcc0,tenNCC);
					dsNCC.add(ncc);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsNCC;
		}
		
		//Lấy toàn bộ các loại xe
		public ArrayList<Xe> getAllXe(){
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
					Xe xe= new Xe(maXe,tenXe);
					dsXe.add(xe);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsXe;
		}
	//Lấy loại xe được chọn
		public ArrayList<Xe> getAllXe(String id){
			ArrayList<Xe> dsXe=new ArrayList<Xe>();
			try {
				ConnectDB.getInstance();
				Connection con= ConnectDB.getCon();
				String sql= "select * from Xe where maXe='"+id+"'";
				Statement statement= con.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				
				while(rs.next()) {
					//String maLoai=rs.getString(1);
					String maXe=rs.getString(1);
					String tenXe=rs.getString(2);
					Xe xe= new Xe(maXe,tenXe);
					dsXe.add(xe);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsXe;
		}
	
		//Lấy toàn nhân viên
		public ArrayList<NhanVien> getAllNhanVien(){
			ArrayList<NhanVien> dsNhanVien=new ArrayList<NhanVien>();
			try {
				ConnectDB.getInstance();
				Connection con= ConnectDB.getCon();
				String sql= "select * from NhanVien";
				Statement statement= con.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				
				while(rs.next()) {
					String maNV=rs.getString(1);
					String tenNV=rs.getString(2);
					NhanVien nhanvien= new NhanVien(maNV,tenNV);
					dsNhanVien.add(nhanvien);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsNhanVien;
		}
		
		//Lấy nhân viên được chọn
		public ArrayList<NhanVien> getAllNhanVien(String id){
			ArrayList<NhanVien> dsNhanVien=new ArrayList<NhanVien>();
			try {
				ConnectDB.getInstance();
				Connection con= ConnectDB.getCon();
				String sql= "select * from NhanVien where maNhanVien='"+id+"'";
				Statement statement= con.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				
				while(rs.next()) {
					String maNV=rs.getString(1);
					String tenNV=rs.getString(2);
					NhanVien nhanvien= new NhanVien(maNV,tenNV);
					dsNhanVien.add(nhanvien);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsNhanVien;
		}
		
//		Load data
				public DefaultTableModel getAllPN() throws SQLException {
					String[] header=  {"Mã Phiếu Nhập","Tên Nhà Cung Cấp", "Người Nhập", "Tên Xe", "Số Lượng","Đơn Giá","Ngày Nhập","Tiền Thuế","Thành Tiền","Chú Thích"};
					DefaultTableModel tableModel = new DefaultTableModel(header, 0);
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					String sql = "select *from nhanVien";
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while (rs.next()) {
						Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getNString(7),rs.getNString(8) };
						tableModel.addRow(o);
					}
					return tableModel;
				}
//				
//				public ArrayList<PhieuNhap> getAllPn(){
//					ArrayList<PhieuNhap> dsPN = new ArrayList<PhieuNhap>();
//					Statement stmt = null;
//					
//					try {
//						ConnectDB.getInstance();
//						Connection con = ConnectDB.getCon();
//						String sql = "select * from PhieuNhap";
//						
//						ResultSet rs = stmt.executeQuery(sql);
//						while(rs.next()) {
//							String maPN = rs.getString(1);
//							
//						}
//					}catch(SQLException e) {
//						e.printStackTrace();
//					}finally {
//						try {
//							stmt.close();
//						}catch(SQLException e2) {
//							e2.printStackTrace();
//						}
//					}
//					return dsPN;
//				}
	
		//Load data
			public ArrayList<PhieuNhap> docTuBang(){
				try {
					Connection con = ConnectDB.getInstance().getCon();
					String sql = "Select * from PhieuNhap";
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next()) {
						//PhieuNhap pn;
						String maPhieu=rs.getString(1);
						String maNCC = rs.getString(2);
						String nguoiNhap = rs.getString(3);
						String tenXe = rs.getString(4);
						int soLuong = rs.getInt(5);
						double donGia = rs.getDouble(6);
						double tienThue = rs.getDouble(7);
						double thanhTien = rs.getDouble(8);
						String chuThich = rs.getString(9);
						Date ngayNhap = rs.getDate(10);
//						NhaCungCap nhaCC = new NhaCungCap(maNCC);
//						NhanVien nhanVien = new NhanVien(nguoiNhap);
//						Xe xe = new Xe(tenXe);
						
						//PhieuNhap phieuNhap = new PhieuNhap(maPhieu,new NhanVien(nguoiNhap),new NhaCungCap(maNCC),ngayNhap,soLuong,tienThue,donGia,thanhTien,chuThich,new Xe(tenXe));
						//PhieuNhap phieuNhap = new PhieuNhap(maPhieu,new NhanVien(nguoiNhap),new NhaCungCap(maNCC),ngayNhap,soLuong,tienThue,donGia,thanhTien,chuThich,new Xe(tenXe));
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return listPhieuNhap;
			}
			
		//Tìm
			public DefaultTableModel timKiem(String maPhieu) throws SQLException {
				String[] header=  {"Mã Phiếu Nhập","Tên Xe", "Người Nhập", "Tên Xe", "Số Lượng","Đơn Giá","Tiền Thuế","Thành Tiền"};
				DefaultTableModel tableModel = new DefaultTableModel(header, 0);
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select *from nhanVien where maNhanVien='" + maPhieu + "'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8) };
					tableModel.addRow(o);
				}
				return tableModel;
			}
		//Thêm
			public boolean themPN(PhieuNhap pn) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				PreparedStatement stmt = null;
				int n = 0;
				try {
					stmt = con.prepareStatement("insert into PhieuNhap values(?,?,?,?,?,?,?,?)");
					stmt.setString(1, pn.getMaPhieuNhap());
					stmt.setString(2, pn.getNhaCungCap().getMaNhaCungCap());
					stmt.setString(3, pn.getNhanVien().getTenNhanVien());
					stmt.setString(4, pn.getXe().getTenXe());
					stmt.setInt(5, pn.getSoLuong());
					stmt.setFloat(6, pn.getDonGia());
					stmt.setFloat(7, pn.getTienThue());
					stmt.setFloat(8, pn.getThanhTien());
					stmt.setString(9, pn.getChuThich());
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
			//Xóa dữ liệu khỏi bảng
				public void xoaPN(String maPN) throws SQLException {
					Connection a = ConnectDB.getCon();// Tao Ket Noi
					String sql = "delete nhanVien where maNhanVien='" + maPN + "'";
					PreparedStatement pstm = a.prepareStatement(sql);
					if (pstm.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên " + maPN);
					}
				}
			//Cập nhật dữ liệu
				public boolean update(PhieuNhap pn) {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					PreparedStatement stmt = null;
					int n = 0;
					try {
						
						stmt = con.prepareStatement(
								"update nhanVien set maPhieuNhap=?,maNhaCungCap=?,tenNhanVien=?,tenXe=?,soLuong=?,donGia=?,tienThue=?,thanhTien=?,chuThich=? where maPhieuNhap=?");
						stmt.setString(1, pn.getMaPhieuNhap());
						stmt.setString(2, pn.getNhaCungCap().getMaNhaCungCap());
						stmt.setString(3, pn.getNhanVien().getTenNhanVien());
						stmt.setString(4, pn.getXe().getTenXe());
						stmt.setInt(5, pn.getSoLuong());
						stmt.setFloat(6, pn.getDonGia());
						stmt.setFloat(7, pn.getTienThue());
						stmt.setFloat(8, pn.getThanhTien());
						stmt.setString(9, pn.getChuThich());
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
}


