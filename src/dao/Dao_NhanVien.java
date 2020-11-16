package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.NhanVien;

public class Dao_NhanVien {
	private int n;
	public Dao_NhanVien() {}
		
	}
//Load data
		public DefaultTableModel getAllNV() throws SQLException {
			String[] header=  {"Mã Nhân Viên","Tên Nhân Viên", "Địa Chỉ", "Email", "Số Điện Thoại","Giới tính","Ngày Sinh","Chức Vụ","Ngày Vào Làm"};
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
		
<<<<<<< .mine

||||||| .r33
	}
=======
	
>>>>>>> .r45
//Tìm
	public DefaultTableModel timKiem(String maNV) throws SQLException {
		String[] header= {"Mã Nhân Viên","Tên Nhân Viên", "Địa Chỉ", "Email","Giới tính", "Số Điện Thoại","Ngày Sinh","Chức Vụ","Ngày Vào Làm"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select *from nhanVien where maNhanVien='" + maNV + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8) };
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
		
}
