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
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;
public class Dao_NhanVien {
	@SuppressWarnings("unused")
	private int n;
	@SuppressWarnings("unused")
	private ArrayList<NhanVien> listNhanVien;
	private ArrayList<String> list_MaNV;
	public Dao_NhanVien() {
		list_MaNV = new ArrayList<String>();
	}
	
	public String getTenNhanVienById(String ID) {
		Connection con = ConnectDB.getCon();
		String sql = "select tenNhanVien from NhanVien where maNhanVien = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				String tenNhanVien = rs.getString(1);
				return tenNhanVien;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> getListMaNV(){	
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
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
	
	public NhanVien getNhanVienById(String properties, String ID) {
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where " + properties + " = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NhanVien nhanvien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(10), rs.getString(5), rs.getString(6), new ChucVu(rs.getString(8)), rs.getString(7), rs.getDate(9));
				return nhanvien;	
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
//Load data
		public DefaultTableModel getAllNV() throws SQLException {
			String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","CMND","Ngày Sinh","Giới Tính","Địa Chỉ","Email","Số Điện Thoại","Ngày Vào Làm","Chức vụ",};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.CMND, NhanVien.ngaySinh,NhanVien.gioiTinh, NhanVien.diaChi, NhanVien.email, NhanVien.soDienThoai, NhanVien.ngayVaoLam,  ChucVu.tenChucVu\r\n" + 
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
	public DefaultTableModel timKiem(String id,String sdt) throws SQLException {
		String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","CMND","Ngày Sinh","Giới Tính","Địa Chỉ","Email","Số Điện Thoại","Chức vụ","Ngày Vào Làm"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.CMND, NhanVien.ngaySinh,NhanVien.gioiTinh, NhanVien.diaChi, NhanVien.email, NhanVien.soDienThoai,   ChucVu.tenChucVu,NhanVien.ngayVaoLam\r\n" + 
				"FROM     NhanVien INNER JOIN\r\n" + 
				"                  ChucVu ON NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND \r\n" + 
				"                  NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu AND NhanVien.maChucVu = ChucVu.maChucVu where CMND like '"+id+"' or sodienThoai like '"+sdt+"'";
                 
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
//Thêm
	public boolean themNV(NhanVien nv){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into nhanVien values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setString(3, nv.getCMND());
			stmt.setString(4, nv.getGioiTinh());
			stmt.setString(5, nv.getDiaChi());
			stmt.setString(6, nv.getEmail());
			stmt.setString(7, nv.getSdt());
			stmt.setString(8, nv.getChucVu().getMaChucVu());
			stmt.setDate(10, (Date) nv.getNgaySinh());
			stmt.setDate(9, (Date) nv.getNgayVaoLam());
			
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
	public ChucVu getMaChucVu(String ten) {
		ChucVu cv;
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from ChucVu where tenChucVu=N'"+ten+"'";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String macv=rs.getString(1);
				
				cv= new ChucVu(macv);
				return cv;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	//Xóa dữ liệu khỏi bảng
		public boolean xoaNV(String maNV) throws SQLException {
			Connection a = ConnectDB.getCon();// Tao Ket Noi
			String sql = "delete NhanVien where maNhanVien='" + maNV + "'";
			PreparedStatement pstm = a.prepareStatement(sql);
			if (pstm.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên " + maNV);
				return true;
			}
			return false;
		}
	//Cập nhật dữ liệu
		public boolean update(NhanVien nv) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				
				stmt = con.prepareStatement(
						"update nhanVien set tenNhanVien=?,CMND=?,gioiTinh=?,diaChi=?,email=?,soDienThoai=?,maChucVu=?,ngayVaoLam=?,ngaySinh=? where maNhanVien=?");
				stmt.setString(1, nv.getTenNhanVien());
				stmt.setString(2, nv.getCMND());
				stmt.setString(3, nv.getGioiTinh());
				stmt.setString(4, nv.getDiaChi());
				stmt.setString(5, nv.getEmail());				
				stmt.setString(6, nv.getSdt());
				stmt.setString(7, nv.getChucVu().getMaChucVu());
				stmt.setDate(8, (Date) nv.getNgaySinh());
				stmt.setDate(9, (Date) nv.getNgayVaoLam());
				stmt.setString(10, nv.getMaNhanVien());
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
		
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

		public String getMaHDTail(String properties, String table) {
		Connection con = ConnectDB.getCon();
		String sql = "select Top 1 " + properties + " from " + table + " order by " + properties + " desc";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String ma;
				ma = rs.getString(1);
				String[] parts = ma.split("_");
				int so = Integer.parseInt(parts[1]) + 1;
				return parts[0] + "_" + String.format("%04d", so);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
}
