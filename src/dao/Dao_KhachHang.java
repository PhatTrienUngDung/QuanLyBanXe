package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;


public class Dao_KhachHang {
	private int n;
	private ArrayList<String> list_CMND;
	public Dao_KhachHang() {
		list_CMND = new ArrayList<String>();
	}
	
//Đọc dữ liệu lên bảng
		public ArrayList<String> getListCMND(){
			try {
				Connection con = ConnectDB.getInstance().getCon();
				String sql = "Select CMND from KhachHang";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					String CMND;
					CMND = rs.getString(1);
					list_CMND.add(CMND);
				}
			}catch (SQLException e) { 
				// TODO: handle exception
				e.printStackTrace();
			}
			return list_CMND;
		}
//Đọc dữ liệu lên bảng
	public DefaultTableModel getAllNCC() throws SQLException {
		String[] header= {"Mã Khách Hàng","Tên Khách Hàng", "Giới Tính", "Ngày Sinh", "Địa Chỉ","Email","Số Điện Thoại","Ghi Chú"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	
	//Tìm
	public DefaultTableModel timKiem(String maKh) throws SQLException {
		String[] header= {"Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Ngày Sinh","Địa Chỉ","Email","Số Điện Thoại","Chú Thích"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select *from KhachHang where maKhachHang='" + maKh + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	
	//Thêm
	public boolean themKH(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKhachHang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setDate(4, (Date) kh.getNgaySinh());
			stmt.setString(5, kh.getDiaChi());
			stmt.setString(6, kh.getEmail());
			stmt.setString(7, kh.getSoDienThoai());
			stmt.setString(8, kh.getChuThich());
			
			
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
	public void xoaKH(String maKH) throws SQLException {
		Connection a = ConnectDB.getCon();// Tao Ket Noi
		String sql = "delete nhanVien where maKhachHang='" + maKH + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên " + maKH);
		}
	}
	
	//Cập nhật dữ liệu
	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			
			stmt = con.prepareStatement(
					"update nhanVien set maNhanVien=?,tenNhanVien=?,diaChi=?,email=?,soDienThoai=?,gioiTinh=?,maChucVu=?,ngayVaoLam=? where maNhanVien=?");
			stmt.setString(1, kh.getMaKhachHang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setDate(4, (Date) kh.getNgaySinh());
			stmt.setString(5, kh.getDiaChi());
			stmt.setString(6, kh.getEmail());
			stmt.setString(7, kh.getSoDienThoai());
			stmt.setString(8, kh.getChuThich());
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
