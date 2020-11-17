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
import entity.HopDong;
import entity.NhanVien;

public class Dao_HopDong {
	private int n;
	public Dao_HopDong() {}
		//Load data
				public DefaultTableModel getAllHD() throws SQLException {
					String[] header=  {"Mã Hợp Đồng","Mã Khách Hàng","Mã Nhân Viên","Mã Xe","Ngày Lập","Thời gian bảo hành"};
					DefaultTableModel tableModel = new DefaultTableModel(header, 0);
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					String sql = "select *from HopDong";
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while (rs.next()) {
						Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getNString(7),rs.getNString(8) ,rs.getString(9)};
						tableModel.addRow(o);
					}
					return tableModel;
				}
				public boolean themHD(HopDong hd) {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					PreparedStatement stmt = null;
					int n = 0;
					try {
						stmt = con.prepareStatement("insert into HopDong values(?,?,?,?,?,?,?,?,?)");
						stmt.setString(1, hd.getMaHD());
						stmt.setString(2, hd.getKhachHang().getMaKhachHang());
						stmt.setString(3, hd.getNhanVien().getMaNhanVien());
						stmt.setString(4, hd.getXe().getMaXe());
						stmt.setString(5, hd.getTGBH());
						stmt.setDate(6, (Date) hd.getNgayLap());
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
			
		//Tìm
			public DefaultTableModel timKiem(String maHD) throws SQLException {
				String[] header= {"Mã Hợp Đồng","Mã Khách Hàng","Mã Nhân Viên","Mã Xe","Ngày Lập","Thời gian bảo hành"};
				DefaultTableModel tableModel = new DefaultTableModel(header, 0);
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select *from HopDong where maHopDong='" + maHD + "'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8) };
					tableModel.addRow(o);
				}
				return tableModel;
			}
		//Thêm
			
			//Xóa dữ liệu khỏi bảng
				public void xoaHD(String maHD) throws SQLException {
					Connection a = ConnectDB.getCon();// Tao Ket Noi
					String sql = "delete HopDong where maHopDong='" + maHD + "'";
					PreparedStatement pstm = a.prepareStatement(sql);
					if (pstm.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công hợp đồng " + maHD);
					}
				}
			//Cập nhật dữ liệu
				public boolean update(HopDong hd) {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					PreparedStatement stmt = null;
					int n = 0;
					try {
						
						stmt = con.prepareStatement(
								"update HopDong set maHopDong=?,maKhachHang=?,maNhanVien=?,maXe=?,ngayLap=?,thoiGianBH=? where maHopDong=?");
						stmt.setString(1, hd.getMaHD());
						stmt.setString(2, hd.getKhachHang().getMaKhachHang());
						stmt.setString(3, hd.getNhanVien().getMaNhanVien());
						stmt.setString(4, hd.getXe().getMaXe());
						stmt.setString(5, hd.getTGBH());
						stmt.setDate(6, (Date) hd.getNgayLap());
						
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
