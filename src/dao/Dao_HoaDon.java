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
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
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
				return ma;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}

}
