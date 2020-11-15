package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class Dao_HoaDon {

	private ArrayList<HoaDon> listBill;
	private HoaDon hd;
	
	public Dao_HoaDon() {
		// TODO Auto-generated constructor stub
		listBill = new ArrayList<HoaDon>();
		hd = new HoaDon();
	}
	
//Đọc dữ liệu lên bảng
		public ArrayList<HoaDon> docTuBang(){
			try {
				Connection con = ConnectDB.getInstance().getCon();
				String sql = "Select * from HoaDon";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					String maHoaDon;
					KhachHang khachHang;
					NhanVien nhanVien;
					Date ngayLHD;
					
					maHoaDon = rs.getString(1);
					khachHang = new KhachHang(rs.getString(2));
					nhanVien = new NhanVien(rs.getString(3));
					ngayLHD = rs.getDate(4);
					
					HoaDon hd = new HoaDon(maHoaDon, khachHang, nhanVien, ngayLHD);
					listBill.add(hd);
				}
			}catch (SQLException e) { 
				// TODO: handle exception
				e.printStackTrace();
			}
			return listBill;
		}
}
