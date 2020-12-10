package dao;
import java.sql.Connection;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;
import entity.Xe;

public class Dao_XuatHopDong {
	private static final String Xe = null;

	public ArrayList<HopDong> getAllHopDong(){
		ArrayList<HopDong> dshd= new ArrayList<HopDong>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from HopDong";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
			Dao_NhanVien dao_nv = new Dao_NhanVien();
			Dao_KhachHang dao_kh = new Dao_KhachHang();
			while(rs.next()) {
				String maHD=rs.getString(1);
				Date ngayLap=rs.getDate(5);
				int tgbh = rs.getInt(6);
				String maXe = rs.getString(4);
				String maNV= rs.getString(3);
				Xe xe = dao_xe.getInfoXe("maXe", maXe);
				NhanVien nv =dao_nv.getNhanVienById("maNhanVien", maNV);
				String maKH = rs.getString(2);
				KhachHang kh = dao_kh.getKhachHangById("maKhachHang", maKH);
				HopDong hd = new HopDong(maHD, kh, nv, xe, ngayLap, tgbh);
				dshd.add(hd);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dshd;
		
	}
}
