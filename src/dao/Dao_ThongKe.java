package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.ChiTietHoaDon;

public class Dao_ThongKe {
	ArrayList<ChiTietHoaDon> dscthd=new ArrayList<ChiTietHoaDon>();
	//Top 10 theo tháng
	public Dao_ThongKe() {}
	public DefaultTableModel getAllCTHD(int thang, int nam) throws SQLException{
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			String sql= "SELECT top(10) Xe.tenXe, sum(chiTietHoaDon.soLuong), sum(HoaDon.tongTien)\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  chiTietHoaDon ON HoaDon.maHoaDon = chiTietHoaDon.maHoaDon INNER JOIN\r\n"
					+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
					+ "where MONTH(ngayLapHoaDon)="+thang+"and YEAR(ngayLapHoaDon)="+nam+"\r\n"
					+ "group by  Xe.tenXe\r\n"
					+ "order by sum(chiTietHoaDon.soLuong) desc,sum(HoaDon.tongTien) desc\r\n"
					+ "";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
					Object[] o = { rs.getString(1), rs.getString(2),df.format(rs.getInt(3))};
					tableModel.addRow(o);
			}
			return tableModel;
	}
	//Top 10 theo năm
	public DefaultTableModel getAllYear(int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql= "SELECT top(10) Xe.tenXe, sum(chiTietHoaDon.soLuong), sum(HoaDon.tongTien)\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  chiTietHoaDon ON HoaDon.maHoaDon = chiTietHoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
				+ "where YEAR(ngayLapHoaDon)="+nam+"\r\n"
				+ "group by Xe.tenXe\r\n"
				+ "order by sum(chiTietHoaDon.soLuong) desc,sum(HoaDon.tongTien) desc\r\n"
				+ "";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
				double tt=Double.parseDouble(rs.getString(3));
				Object[] o = { rs.getString(1), rs.getString(2),df.format(tt)};
				tableModel.addRow(o);
		}
		return tableModel;
}
	//Theo Tháng
	//1. Thong ke xe nhap bieu đồ theo tháng
	public int BieuDoXeNhap(int thang, int nam) {
		int count=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select count(maXe) from Xe where YEAR(ngaynhap)="+nam+" and  Month(ngaynhap)="+thang+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	//2. Biểu đồ va thống kê xe bán theo tháng
	public int BieuDoXeBan(int thang, int nam) {
		int count=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT sum(chiTietHoaDon.soLuong)\r\n"
					+ 				 "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ 				 "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
					+ 				 "where YEAR(ngayLapHoaDon)="+nam+" and  Month(ngayLapHoaDon)="+thang+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	//3. Thống kê số lượng khách hàng theo tháng
		public int SoLuongKhachHangTrongThang(int thang, int nam) {
			int count =0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select count(maKhachHang) from KhachHang where YEAR(ngayGiaNhap)="+nam+" and  Month(ngayGiaNhap)="+thang+"";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					count=rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return count;
		}

	//4. Thống kê thu nhập trong tháng
		public int TongTienTheoThang(int thang, int nam) {
			int count =0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select sum(tongTien) from HoaDon where YEAR(ngayLapHoaDon)="+nam+" and Month(ngayLapHoaDon)="+thang+"";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					count=rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return count;
		}
		
	//-------------------------------------------------------------------------------Theo Ngày---------------------------------------------------------------
	//1. Thong ke vao bieu đồ theo ngày trong tháng
		public int BieuDoXeNhap(int ngay, int thang, int nam) {
			int count=0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select count(maXe) from Xe where day(ngaynhap)="+ngay+" and YEAR(ngaynhap)="+nam+" and  Month(ngaynhap)="+thang+"";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					count=rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return count;
		}
	//2. Biểu đồ xe bán theo ngày trong tháng
	public int BieuDoXeBan(int ngay, int thang, int nam) {
		int count=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT sum(chiTietHoaDon.soLuong)\r\n"
					+ 				 "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ 				 "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
					+ 				 "where day(ngaylaphoadon)="+ngay+" and 	YEAR(ngayLapHoaDon)="+nam+" and  Month(ngayLapHoaDon)="+thang+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	//3. Biểu đồ khách hàng theo ngày 
	public int BieuDoKhachHangTheoNgay(int ngay ,int thang, int nam) {
		int count =0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select count(maKhachHang) where day(ngayLapHoaDon)="+ngay+" and YEAR(ngayLapHoaDon)="+nam+" and  Month(ngayLapHoaDon)="+thang+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	//4. Biểu đồ xe tổng tiền theo ngày
	public int TongTienTheoNgay(int ngay,int thang, int nam) {
		int count =0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select sum(tongTien) from HoaDon where day(ngayLapHoaDon) and YEAR(ngayLapHoaDon)="+nam+" and Month(ngayLapHoaDon)="+thang+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	//---------------------------------------------------------------------Theo Năm-------------------------------------------------------------------------------
	//Thống kê số lượng xe nhập trong năm
	public int SoLuongXeNhapTrongNam(int nam) {
		int count =0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select count(maXe) from Xe where YEAR(ngaynhap)="+nam+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	//Thống kê xe bán trong năm
	public int SoLuongXeBanTrongNam(int nam) {
		int count =0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT sum(chiTietHoaDon.soLuong)\r\n"
					+ "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
					+ "where YEAR(ngayLapHoaDon)="+nam+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	//Thống kê số lượng khách hàng theo năm
	public int SoLuongKhachHangTrongNam(int nam) {
		int count =0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select count(maKhachHang) from khachhang where YEAR([ngayGiaNhap])="+nam+"";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	//THống kê thu nhập trong nam
		public int TongTienTheoNam(int nam) {
			int count =0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select sum(tongTien) from HoaDon where YEAR(ngayLapHoaDon)="+nam+"";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					count=rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return count;
		}

}
