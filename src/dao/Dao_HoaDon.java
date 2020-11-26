package dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.Xe;

public class Dao_HoaDon {

	private ArrayList<HoaDon> listBill;
	private HoaDon hd;
	
	public Dao_HoaDon() {
		// TODO Auto-generated constructor stub
		listBill = new ArrayList<HoaDon>();
		hd = new HoaDon();
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
	
	public boolean createHD (HoaDon hd) {
		Connection con = ConnectDB.getInstance().getCon();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon values (?,?,?,?,?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(2, hd.getKhachHang().getMaKhachHang());
			stmt.setString(3, hd.getNhanVien().getMaNhanVien());
			stmt.setDate(4, hd.getNgayLapHoaDon());
			stmt.setDouble(5, hd.getTongTien());
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return n > 0;
	}
	
	public boolean createCTHD (ChiTietHoaDon cthd) {
		Connection con = ConnectDB.getInstance().getCon();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietHoaDon values (?,?,?,?,?)");
			stmt.setString(1, cthd.getHoaDon().getMaHoaDon());
			stmt.setString(2, cthd.getSanPham().getMaXe());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setDouble(4, cthd.getDonGia());
			stmt.setDouble(5, cthd.getThueVAT());
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return n > 0;
	}
	

}
