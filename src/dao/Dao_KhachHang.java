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
	
	public KhachHang getKhachHangById(String properties, String ID) {
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang where " + properties + " = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8), rs.getString(9),rs.getString(10));
				return khachHang;	
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	
	public KhachHang getKhachHangTail() {
		Connection con = ConnectDB.getCon();
		String sql = "select top 1 * from KhachHang order by maKhachHang desc";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8), rs.getString(9),rs.getString(10));
				return khachHang;	
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
//Đọc dữ liệu lên bảng
	public DefaultTableModel getAllKH() throws SQLException {
		String[] header= {"Mã Khách Hàng","Tên Khách Hàng","cmnd" ,"Giới Tính", "Ngày Sinh", "Ngày Gia Nhập","Địa Chỉ","Email","Số Điện Thoại","Ghi Chú"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	
	//Tìm
	public DefaultTableModel timKiem(String maKh) throws SQLException {
		String[] header= {"Mã Khách Hàng", "Tên Khách Hàng","CMND" ,"Giới Tính", "Ngày Sinh","Ngày Gia Nhập","Địa Chỉ","Email","Số Điện Thoại","Ghi Chú"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang where maKhachHang like '" + maKh + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
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
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKhachHang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(3, kh.getCMND());
			stmt.setString(4, kh.getGioiTinh());
			stmt.setDate(5, (Date) kh.getNgaySinh());
			stmt.setDate(6, (Date) kh.getNgaygiaNhap());
			stmt.setString(7, kh.getDiaChi());
			stmt.setString(8, kh.getEmail());
			stmt.setString(9, kh.getSoDienThoai());
			stmt.setString(10, kh.getChuThich());
			
			
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
		String sql = "delete KhachHang where maKhachHang='" + maKH + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công khách hàng " + maKH);
		}
	}
	
	//Cập nhật dữ liệu
	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			//"Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Ngày Sinh","Địa Chỉ","Email","Số Điện Thoại","Chú Thích"							
			stmt = con.prepareStatement(
					"update KhachHang set tenKhachHang=?,cmnd=?,gioiTinh=?,ngaySinh=?,ngayGiaNhap=?,diaChi=?,email=?,sodienThoai=?,chuThich=? where maKhachHang=?");
			stmt.setString(1, kh.getTenKhachHang());
			stmt.setString(2, kh.getCMND());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setDate(4, (Date) kh.getNgaySinh());
			stmt.setDate(5, (Date) kh.getNgaygiaNhap());
			stmt.setString(6, kh.getDiaChi());
			stmt.setString(7, kh.getEmail());
			stmt.setString(8, kh.getSoDienThoai());
			stmt.setString(9, kh.getChuThich());
			stmt.setString(10, kh.getMaKhachHang());
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
