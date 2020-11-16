package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 13, 2020
* @version: 1.0
*/
import entity.PhieuNhap;
public class Dao_PhieuNhap {
	private int n;
	public Dao_PhieuNhap() {}
		//Load data
				public DefaultTableModel getAllPN() throws SQLException {
					String[] header=  {"Mã Phiếu Nhập","Tên Xe", "Người Nhập", "Tên Xe", "Số Lượng","Đơn Giá","Tiền Thuế","Thành Tiền"};
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
				
				public ArrayList<PhieuNhap> getAllPn(){
					ArrayList<PhieuNhap> dsPN = new ArrayList<PhieuNhap>();
					Statement stmt = null;
					
					try {
						ConnectDB.getInstance();
						Connection con = ConnectDB.getCon();
						String sql = "select * from PhieuNhap";
						
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							String maPN = rs.getString(1);
							
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							stmt.close();
						}catch(SQLException e2) {
							e2.printStackTrace();
						}
					}
					return dsPN;
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


