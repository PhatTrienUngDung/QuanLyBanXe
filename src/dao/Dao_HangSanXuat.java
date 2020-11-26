package dao;

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
import entity.HangSanXuat;
import entity.KhachHang;

public class Dao_HangSanXuat {


	public void getListHSX(String tenXe, JComboBox comboBox) {
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
	
	public HangSanXuat getHangSanXuatById(String id) {
		Connection con = ConnectDB.getCon();
		String sql = "select * from HangSanXuat where maHangSanXuat = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String tenHangSanXuat = rs.getString(2);
				String quocGia = rs.getString(3);
				HangSanXuat hsx = new HangSanXuat(id, tenHangSanXuat, quocGia);
				return hsx;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	//Đọc dữ liệu lên bảng
		public DefaultTableModel getAllHSX() throws SQLException {
			String[] header= {"Mã Hãng Sản Xuất","Tên Hãng Sản Xuất","Quốc Gia"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select * from HangSanXuat";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
		
		//Tìm
		public DefaultTableModel timKiem(String mahSX) throws SQLException {
			String[] header= {"Mã Hãng Sản Xuất","Tên Hãng Sản Xuất","Quốc Gia"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select *from HangSanXuat where maHangSanXuat like'" + mahSX + "' or tenHangSanXuat like '"+mahSX+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
		
		//Thêm
		public boolean themHSX(HangSanXuat hsx) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("insert into HangSanXuat values(?,?,?)");
				stmt.setString(1, hsx.getMaHangSX());
				stmt.setString(2, hsx.getTenHangSX());
				stmt.setString(3, hsx.getQuocGia());
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
		//xóa
		public void xoaHSX(String mahsx) throws SQLException {
			Connection a = ConnectDB.getCon();// Tao Ket Noi
			String sql = "delete HangSanXuat where maHangSanXuat='" + mahsx + "'";
			PreparedStatement pstm = a.prepareStatement(sql);
			if (pstm.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công hãng sản xuất" + mahsx);
			}
		}
		
		//Cập nhật dữ liệu
		public boolean update(HangSanXuat hsx) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				
				stmt = con.prepareStatement(
						"update HangSanXuat set maHangSanXuat=?,tenHangSanXuat=?,quocGia=? where maHangSanXuat=?");
				stmt.setString(1, hsx.getMaHangSX());
				stmt.setString(2, hsx.getTenHangSX());
				stmt.setString(3, hsx.getQuocGia());
				stmt.setString(4, hsx.getMaHangSX());
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
