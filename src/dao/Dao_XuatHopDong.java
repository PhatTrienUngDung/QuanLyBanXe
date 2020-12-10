package dao;
import java.sql.Connection;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;
import entity.Xe;

public class Dao_XuatHopDong {
	private static final String Xe = null;

	public HopDong getAllHopDong(String ma){
		//ArrayList<HopDong> dshd= new ArrayList<HopDong>();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from HopDong where maHopDong='"+ma+"'";
			Statement statement;
			try {
				statement = con.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
				Dao_NhanVien dao_nv = new Dao_NhanVien();
				Dao_KhachHang dao_kh = new Dao_KhachHang();
				while(rs.next()) {
					System.out.println(rs.getString(1));
					String maHD=rs.getString(1);
					String maKH = rs.getString(2);
					String maNV= rs.getString(3);
					String maXe = rs.getString(4);
					Date ngayLap=rs.getDate(5);
					int tgbh = rs.getInt(6);
					Xe xe = dao_xe.getInfoXe("maXe", maXe);
					NhanVien nv =dao_nv.getNhanVienById("maNhanVien", maNV);
					
					KhachHang kh = dao_kh.getKhachHangById("maKhachHang", maKH);
					

					HopDong hd = new HopDong(maHD, kh, nv, xe, ngayLap, tgbh);
					//dshd.add(hd);
					return hd;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return null;
	}
}
