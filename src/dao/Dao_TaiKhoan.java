package dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
					
					nhanVien = new NhanVien(rs.getString(1));
					matKhau = rs.getString(2);
					quyen = rs.getString(3);
					
					TaiKhoan tk = new TaiKhoan(nhanVien, matKhau, quyen);
					listTaiKhoan.add(tk);
				}
			}catch (SQLException e) { 
				// TODO: handle exception
				e.printStackTrace();
			}
			return listTaiKhoan;
		}
		
		public DefaultTableModel getAllAccount(String[] header, DefaultTableModel tableModel) throws SQLException {
			int stt = 1;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNhanVien), TaiKhoan.*, tenNhanVien"
					+ " from TaiKhoan, NhanVien"
					+ " where TaiKhoan.maNhanvien = NhanVien.maNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = {rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(3), rs.getString(4)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
		
		public boolean create (TaiKhoan tk) {
			Connection con = ConnectDB.getInstance().getCon();
			PreparedStatement stmt = null;
			int n= 0;
			try {
				stmt = con.prepareStatement("insert into Users values (?,?,?)");
				stmt.setString(1, tk.getNhanVien().getMaNhanVien());
				stmt.setString(2, tk.getMatKhau());
				stmt.setString(3, tk.getQuyen());
				n=stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
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
}
