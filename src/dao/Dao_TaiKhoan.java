package dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import ui.UI_TaiKhoan;

public class Dao_TaiKhoan {
	

	private ArrayList<TaiKhoan> listTaiKhoan;
	TaiKhoan tk;
	
	public Dao_TaiKhoan() {
		// TODO Auto-generated constructor stub
		listTaiKhoan = new ArrayList<TaiKhoan>();
		tk = new TaiKhoan();
	}
	public TaiKhoan Login(String username, String password) {
		Connection con = ConnectDB.getCon();
		String sql = "select * from TaiKhoan where maNhanVien = ? and matKhau = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				TaiKhoan tk = new TaiKhoan(new NhanVien(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4));
				return tk;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	//Đọc dữ liệu lên bảng
		public ArrayList<TaiKhoan> docTuBang(){
			try {
				Connection con = ConnectDB.getInstance().getCon();
				String sql = "Select * from TaiKhoan";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					NhanVien nhanVien;
					String matKhau;
					String quyen;
					String chuThich;
					
					nhanVien = new NhanVien(rs.getString(1));
					matKhau = rs.getString(2);
					quyen = rs.getString(3);
					chuThich = rs.getString(4);
					
					TaiKhoan tk = new TaiKhoan(nhanVien, matKhau, quyen, chuThich);
					listTaiKhoan.add(tk);
				}
			}catch (SQLException e) { 
				// TODO: handle exception
				e.printStackTrace();
			}
			return listTaiKhoan;
		}
		public DefaultTableModel getAccountByName(String[] header, DefaultTableModel tableModel, String tenNhanVien) throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNhanVien), TaiKhoan.*, tenNhanVien"
					+ " from TaiKhoan, NhanVien"
					+ " where TaiKhoan.maNhanvien = NhanVien.maNhanVien and NhanVien.tenNhanVien like N'%"+tenNhanVien+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
		public DefaultTableModel getAccountById(String[] header, DefaultTableModel tableModel, String maNhanVien) throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNhanVien), TaiKhoan.*, tenNhanVien"
					+ " from TaiKhoan, NhanVien"
					+ " where TaiKhoan.maNhanvien = NhanVien.maNhanVien and TaiKhoan.maNhanVien like '%"+maNhanVien+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
		
		public DefaultTableModel getAllAccount(String[] header, DefaultTableModel tableModel) throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNhanVien), TaiKhoan.*, tenNhanVien"
					+ " from TaiKhoan, NhanVien"
					+ " where TaiKhoan.maNhanvien = NhanVien.maNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
		
		public boolean create (TaiKhoan tk) {
			Connection con = ConnectDB.getInstance().getCon();
			PreparedStatement stmt = null;
			int n= 0;
			try {
				stmt = con.prepareStatement("insert into TaiKhoan values (?,?,?,?)");
				stmt.setString(1, tk.getNhanVien().getMaNhanVien());
				stmt.setString(2, tk.getMatKhau());
				stmt.setString(3, tk.getQuyen());
				stmt.setString(4, tk.getChuThich());
				n=stmt.executeUpdate();
			}catch(SQLException e) {
				//e.printStackTrace();
			}
					return n > 0;
		}
		
		public boolean delete(String ID){
	       Connection con= ConnectDB.getInstance().getCon();
	       PreparedStatement stmt = null;
	       int n=0;
	       try{
	           stmt = con.prepareStatement("delete from TaiKhoan where maNhanVien = ?");
	           stmt.setString(1, ID);
	           n = stmt.executeUpdate();
	       }catch(SQLException e){
	           e.printStackTrace();
	       }
	       return n>0;
	   }
		
		public boolean Update (String maNhanVien) {
			Connection con= ConnectDB.getInstance().getCon();
		    PreparedStatement stmt = null;
		    int n = 0;
		    try {
		    	stmt = con.prepareStatement("update TaiKhoan set matKhau = '123456' where maNhanVien = ?");
		    	stmt.setString(1, maNhanVien);
		    	n = stmt.executeUpdate();
		    } catch (Exception e) {
				// TODO: handle exception
		    	e.printStackTrace();
			}
		    return n>0;
		}
}
