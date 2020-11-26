package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.NhaCungCap;


public class Dao_NhaCungCap {
	private int n;
	private ArrayList<String> listSupplierName;
	public Dao_NhaCungCap() {
		listSupplierName = new ArrayList<String>();
	}
	
	public NhaCungCap getTenNhaCCById(String ID) {
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhaCungCap where maNhaCungCap = '" + ID + "'";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(6), rs.getString(5), rs.getString(4));
				return ncc;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	
	public void getListSupplierName_Bill(String tenXe, String version, String mauXe, JComboBox comboBox) {
		Connection con = ConnectDB.getCon();
		String sql = "SELECT DISTINCT tenNhaCungCap FROM NhaCungCap, Xe WHERE Xe.maNhaCungCap = NhaCungCap.maNhaCungCap and tenXe = '" + tenXe + "' and phienBan = N'"+ version +"' and mauXe = N'"+ mauXe +"'";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}
	
	public ArrayList<String> getListSuppilerName() {
		try {
			listSupplierName.clear();
			Connection con = ConnectDB.getInstance().getCon();
			String sql = "select maNhaCungCap, tenNhaCungCap from NhaCungCap order by maNhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String tenNhaCungCap;
				tenNhaCungCap = rs.getString(2);
				listSupplierName.add(tenNhaCungCap);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return listSupplierName;
	}
//Đọc dữ liệu lên bảng
	public DefaultTableModel getAllNCC() throws SQLException {
		String[] header= {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại","Ghi Chú"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select *from nhaCungCap";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) };
			tableModel.addRow(o);
		}
		return tableModel;
	}
//Tìm
	public DefaultTableModel timKiem(String maNCC) throws SQLException {
		String[] header= {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại","Ghi Chú"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select *from nhaCungCap where maNhaCungCap='" + maNCC + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(4),rs.getString(5),rs.getString(6)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
//Thêm dữ liệu vào bảng
	public boolean themNCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into nhaCungCap values(?,?,?,?,?,?)");
			stmt.setString(1, ncc.getMaNhaCungCap());
			stmt.setString(2, ncc.getTenNhaCungCap());
			stmt.setString(3, ncc.getDiaChi());
			stmt.setString(4, ncc.getEmail());
			stmt.setString(5, ncc.getSoDienThoai());
			stmt.setString(6, ncc.getChuThich());
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
	public void xoaNCC(String maNCC) throws SQLException {
		Connection a = ConnectDB.getCon();// Tao Ket Noi
		String sql = "delete nhaCungCap where maNhaCungCap='" + maNCC + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công nhà cung cấp " + maNCC);
		}
	}
//Cập nhật dữ liệu
	public boolean update(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			
			stmt = con.prepareStatement(
					"update nhaCungCap set maNhaCungCap=?,tenNhaCungcap=?,diaChi=?,email=?,soDienThoai=?,chuThich=? where maNhaCungCap=?");
			stmt.setString(1, ncc.getMaNhaCungCap());
			stmt.setString(2, ncc.getTenNhaCungCap());
			stmt.setString(3, ncc.getDiaChi());
			stmt.setString(4, ncc.getEmail());
			stmt.setString(5, ncc.getSoDienThoai());
			stmt.setString(6, ncc.getChuThich());
			stmt.setString(7, ncc.getMaNhaCungCap());
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
