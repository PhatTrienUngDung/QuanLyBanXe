package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import connect.ConnectDB;
import entity.LoaiXe;

public class Dao_LoaiXe {
	//Đọc dữ liệu lên bảng
		public DefaultTableModel getAllLX() throws SQLException {
			String[] header= {"Mã Loại Xe","Tên Loại Xe"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select *from LoaiXe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
	//Tìm
		public DefaultTableModel timKiem(String id) throws SQLException {
			String[] header= {"Mã Loại Xe","Tên Loại Xe"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select *from LoaiXe where maLoaixe like'"+id+"' or tenLoaixe like'"+id+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
	//Thêm dữ liệu vào bảng
		public boolean themLX(LoaiXe lx) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("insert into LoaiXe values(?,?)");
				stmt.setString(1, lx.getMaLoaiXe());
				stmt.setString(2, lx.getTenLoaiXe());
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
		public void xoaLoaiXe(String id) throws SQLException {
			Connection a = ConnectDB.getCon();// Tao Ket Noi
			String sql = "delete LoaiXe where maLoaiXe='" + id + "'";
			PreparedStatement pstm = a.prepareStatement(sql);
			if (pstm.executeUpdate() > 0) {
				
			}
		}
	//Cập nhật dữ liệu
		public boolean update(LoaiXe lx) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				
				stmt = con.prepareStatement(
						"update LoaiXe set maLoaiXe=?,tenLoaiXe=? where maLoaiXe=?");
				stmt.setString(1, lx.getMaLoaiXe());
				stmt.setString(2, lx.getTenLoaiXe());
				stmt.setString(3, lx.getMaLoaiXe());
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
