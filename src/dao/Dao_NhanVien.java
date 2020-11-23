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
import entity.ChucVu;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.TaiKhoan;

public class Dao_NhanVien {
	private int n;
	private ArrayList<NhanVien> listNhanVien;
	private ArrayList<String> list_MaNV;
	public Dao_NhanVien() {
		list_MaNV = new ArrayList<String>();
	}
	
	public ArrayList<String> getListMaNV(){	
		try {
			Connection con = ConnectDB.getInstance().getCon();
			String sql = "Select maNhanVien from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien;
				maNhanVien = rs.getString(1);
				list_MaNV.add(maNhanVien);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return list_MaNV;
	}
//Load data
		public DefaultTableModel getAllNV() throws SQLException {
			String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","CMND","Giới Tính","Địa Chỉ","Email","Số Điện Thoại","Ngày Vào Làm","Ngay Sinh","Chức Vụ"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.CMND, NhanVien.gioiTinh, NhanVien.diaChi, NhanVien.email, NhanVien.soDienThoai, NhanVien.ngayVaoLam, NhanVien.ngaySinh, ChucVu.tenChucVu\r\n" + 
					"FROM     NhanVien INNER JOIN\r\n" + 
					"                  ChucVu ON NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND \r\n" + 
					"                  NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu";
	                 
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
//Tìm
	public DefaultTableModel timKiem(String id) throws SQLException {
		String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","CMND","Ngày Sinh","Giới Tính","Địa Chỉ","Email","Số Điện Thoại","Chức vụ","Ngày Vào Làm"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.CMND, NhanVien.gioiTinh, NhanVien.diaChi, NhanVien.email, NhanVien.soDienThoai, NhanVien.ngayVaoLam, NhanVien.ngaySinh, ChucVu.tenChucVu\r\n" + 
				"FROM     NhanVien INNER JOIN\r\n" + 
				"                  ChucVu ON NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND \r\n" + 
				"                  NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu where tenNhanVien like '"+id+"' or sodienThoai like '"+id+"'";
                 
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
//Thêm
	public boolean themNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into nhanVien values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setString(3, nv.getGioiTinh());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getEmail());
			stmt.setString(6, nv.getSdt());
			stmt.setDate(7, (Date) nv.getNgaySinh());
			stmt.setDate(8, (Date) nv.getNgayVaoLam());
			stmt.setString(9, nv.getGioiTinh());
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
		public void xoaNV(String maNV) throws SQLException {
			Connection a = ConnectDB.getCon();// Tao Ket Noi
			String sql = "delete nhanVien where maNhanVien='" + maNV + "'";
			PreparedStatement pstm = a.prepareStatement(sql);
			if (pstm.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên " + maNV);
			}
		}
	//Cập nhật dữ liệu
		public boolean update(NhanVien nv) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				
				stmt = con.prepareStatement(
						"update nhanVien set maNhanVien=?,tenNhanVien=?,diaChi=?,email=?,soDienThoai=?,gioiTinh=?,maChucVu=?,ngayVaoLam=? where maNhanVien=?");
				stmt.setString(1, nv.getMaNhanVien());
				stmt.setString(2, nv.getTenNhanVien());
				stmt.setString(3, nv.getDiaChi());
				stmt.setString(4, nv.getEmail());
				stmt.setString(5, nv.getSdt());
				stmt.setString(6, nv.getChucVu().getMaChucVu());
				stmt.setDate(7,(Date) nv.getNgaySinh());
				stmt.setDate(8,(Date) nv.getNgayVaoLam());
				stmt.setString(9, nv.getGioiTinh());
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
		public ArrayList<ChucVu> getAllChucVus(){
			ArrayList<ChucVu> dsCV=new ArrayList<ChucVu>();
			try {
				ConnectDB.getInstance();
				Connection con= ConnectDB.getCon();
				String sql= "select * from ChucVu";
				Statement statement= con.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				
				while(rs.next()) {
					String maCV=rs.getString(1);
					String tenCV=rs.getString(2);
					
					ChucVu cv= new ChucVu(maCV, tenCV);
					dsCV.add(cv);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsCV;
		}
}
