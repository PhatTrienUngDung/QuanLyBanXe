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
import entity.Xe;

public class Dao_ThongKe {
	ArrayList<ChiTietHoaDon> dscthd=new ArrayList<ChiTietHoaDon>();
	//Top 10 theo tháng
	public Dao_ThongKe() {}
	public DefaultTableModel getAllCTHD(int thang, int nam) throws SQLException{
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			String sql= "SELECT Xe.tenXe, count(xe.tenXe), sum(HoaDon.tongTien)\r\n"
					+ "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
					+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
					+ "where MONTH(ngayLapHoaDon)="+thang+" and YEAR(ngayLapHoaDon)="+nam+"\r\n"
					+ "group by xe.tenXe\r\n"
					+ "order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
					Object[] o = { rs.getString(1), rs.getString(2),rs.getInt(3)};
					tableModel.addRow(o);
			}
			return tableModel;
	}
	public DefaultTableModel getAllCTHD(int ngay,int thang, int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql= "SELECT Xe.tenXe, count(xe.tenXe), sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
				+ "where MONTH(ngayLapHoaDon)="+thang+" and YEAR(ngayLapHoaDon)="+nam+" and Day(ngayLapHoaDon)="+ngay+"\r\n"
				+ "group by xe.tenXe\r\n"
				+ "order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2),rs.getInt(3)};
				tableModel.addRow(o);
		}
		return tableModel;
}
	public DefaultTableModel getAllKH(int thang, int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String[] header= {"Tên Khách Hàng","Giới tính","Số điện thoại"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql= "select tenKhachHang,gioiTinh,soDienThoai from khachhang where month(ngayGiaNhap)="+thang+" and year(ngayGiaNhap)="+nam+"";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2),rs.getString(3)};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	public DefaultTableModel getAllKH(int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String[] header= {"Tên Khách Hàng","Giới tính","Số điện thoại"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql= "select tenKhachHang,gioiTinh,soDienThoai from khachhang where year(ngayGiaNhap)="+nam+"";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2),rs.getString(3)};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	public DefaultTableModel getAllKH(int ngay,int thang, int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String[] header= {"Tên Khách Hàng","Giới tính","Số điện thoại"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql= "select tenKhachHang,gioiTinh,soDienThoai from khachhang where day(ngayGiaNhap)="+ngay+" and month(ngayGiaNhap)="+thang+" and  year(ngayGiaNhap)="+nam+"";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
			DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
				Object[] o = { rs.getString(1), rs.getString(2),df.format(rs.getString(3))};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	public DefaultTableModel getAllNV(int ngay,int thang, int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên cửa hàng","Mã nhân viên","Tên nhân viên","Giới tính","Số lượng", "Doanh thu"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql = "SELECT  NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.gioiTinh, count(chiTietHoaDon.maXe), sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien\r\n"
				+ "where day(ngayLapHoaDon)="+ngay+" and month(ngayLapHoaDon)="+thang+" and year(ngayLapHoaDon)="+nam+"\r\n"
				+ "group by  NhanVien.tenNhanVien, NhanVien.maNhanVien, NhanVien.gioiTinh\r\n"
				+ "order by count(chiTietHoaDon.maXe) desc ,sum(HoaDon.tongTien) desc";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			    double tt= rs.getDouble(5);
				Object[] o = {"Cửa Hàng Xe Máy Thành Nam",rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),df.format(tt)};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	
	public DefaultTableModel getAllCTNV(int ngay,int thang, int nam, String ma) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên Xe","Số Lượng","Phiên Bản","Phân Khối", "Doanh thu"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql = "SELECT NhanVien.maNhanVien, Xe.tenXe ,count(xe.tenXe), Xe.phienBan, Xe.phanKhoi, sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien\r\n"
				+ "where day(ngayLapHoaDon)="+ngay+" and month(ngayLapHoaDon)="+thang+" and year(ngayLapHoaDon)="+nam+" and NhanVien.maNhanVien='"+ma+"'\r\n"
				+ "group by  NhanVien.maNhanVien, Xe.tenXe, Xe.phienBan, Xe.phanKhoi";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			    double tt= rs.getDouble(6);
				Object[] o = {rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),df.format(tt)};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	public DefaultTableModel getAllNV(int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên cửa hàng","Mã nhân viên","Tên nhân viên","Giới tính","Số lượng", "Doanh thu"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql = "SELECT  NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.gioiTinh, count(chiTietHoaDon.maXe), sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien\r\n"
				+ "where year(ngayLapHoaDon)="+nam+"\r\n"
				+ "group by  NhanVien.tenNhanVien, NhanVien.maNhanVien, NhanVien.gioiTinh\r\n"
				+ "order by count(chiTietHoaDon.maXe) desc ,sum(HoaDon.tongTien) desc";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
			    DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			    double tt= rs.getDouble(5);
				Object[] o = {"Cửa Hàng Xe Máy Thành Nam",rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),df.format(tt)};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	public DefaultTableModel getAllCTNV(int nam, String ma) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên Xe","Số Lượng","Phiên Bản","Phân Khối", "Doanh thu"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql = "SELECT NhanVien.maNhanVien, Xe.tenXe ,count(xe.tenXe), Xe.phienBan, Xe.phanKhoi, sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien\r\n"
				+ "where year(ngayLapHoaDon)="+nam+" and NhanVien.maNhanVien='"+ma+"'\r\n"
				+ "group by  NhanVien.maNhanVien, Xe.tenXe, Xe.phienBan, Xe.phanKhoi";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			    double tt= rs.getDouble(6);
				Object[] o = {rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),df.format(tt)};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	public DefaultTableModel getAllNV(int thang,int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên cửa hàng","Mã nhân viên","Tên nhân viên","Giới tính","Số lượng", "Doanh thu"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql = "SELECT  NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.gioiTinh, count(chiTietHoaDon.maXe), sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien\r\n"
				+ "where month(ngayLapHoaDon)="+thang+" and year(ngayLapHoaDon)="+nam+"\r\n"
				+ "group by  NhanVien.tenNhanVien, NhanVien.maNhanVien, NhanVien.gioiTinh\r\n"
				+ "order by count(chiTietHoaDon.maXe) desc ,sum(HoaDon.tongTien) desc";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
			 	DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			    double tt= rs.getDouble(5);
				Object[] o = {"Cửa Hàng Xe Máy Thành Nam",rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),df.format(tt)};
				tableModel.addRow(o);
		}
		return tableModel;
	}
	public DefaultTableModel getAllCTNV(int thang, int nam, String ma) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên Xe","Số Lượng","Phiên Bản","Phân Khối", "Doanh thu"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql = "SELECT NhanVien.maNhanVien, Xe.tenXe ,count(xe.tenXe), Xe.phienBan, Xe.phanKhoi, sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe INNER JOIN\r\n"
				+ "                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien\r\n"
				+ "where month(ngayLapHoaDon)="+thang+" and year(ngayLapHoaDon)="+nam+" and NhanVien.maNhanVien='"+ma+"'\r\n"
				+ "group by  NhanVien.maNhanVien, Xe.tenXe, Xe.phienBan, Xe.phanKhoi";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			    double tt= rs.getDouble(6);
				Object[] o = {rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),df.format(tt)};
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
		String sql= "SELECT Xe.tenXe, count(xe.tenXe), sum(HoaDon.tongTien)\r\n"
				+ "FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
				+ "where YEAR(ngayLapHoaDon)="+nam+"\r\n"
				+ "group by xe.tenXe\r\n"
				+ "order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc";
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
			String sql = "SELECT count(xe.maXe)\r\n"
					+ "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
					+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
					+ "where MONTH(ngayLapHoaDon)="+thang+" and YEAR(ngayLapHoaDon)="+nam+"";
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
			String sql = "SELECT count(xe.maXe)\r\n"
					+ "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
					+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
					+ "where DAY(ngayLapHoaDon)="+ngay+" and MONTH(ngayLapHoaDon)="+thang+" and YEAR(ngayLapHoaDon)="+nam+"";
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
			String sql = "select count(maKhachHang) from KhachHang where day(ngayGiaNhap)="+ngay+" and YEAR(ngayGiaNhap)="+nam+" and  Month(ngayGiaNhap)="+thang+"";
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
			String sql = "select sum(tongTien) from HoaDon where day(ngayLapHoaDon)="+ngay+" and YEAR(ngayLapHoaDon)="+nam+" and Month(ngayLapHoaDon)="+thang+"";
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
			String sql = "SELECT count(xe.maXe)\r\n"
					+ "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
					+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
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
		public Xe XeNhieuNhat() {
			Xe xe = null;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql= "SELECT top 1 Xe.tenXe, count(xe.tenXe), sum(HoaDon.tongTien)\r\n"
						+ "FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
						+ "group by xe.tenXe\r\n"
						+ "order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					String ten=rs.getString(1);
					String soluong=rs.getString(2);
					xe= new Xe(ten, soluong);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return xe;
		}
		public String XeItNhat() {
			String count= "0";
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql= "select ROW_NUMBER() over (order by tenXe),  tenXe,count(xe.tenXe)  from Xe\r\n"
						+ "where maXe not in (select maXe from ChiTietHoaDon)\r\n"
						+ "group by xe.tenXe\r\n"
						+ "order by ROW_NUMBER() over (order by tenXe) desc";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					count=rs.getString(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return count;
		}
		public int TuoiTrungBinh() {
			int count= 0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql= "SELECT sum(DATEDIFF(year, ngaySinh,GETDATE()))/count(maKhachHang)\r\n"
						+ 	"FROM KhachHang";
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
		public int TiLe(int tuoi1, int tuoi2) {
			int count= 0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql= "SELECT DATEDIFF(year, ngaySinh,GETDATE()) AS AgeTB\r\n"
						+ "    FROM KhachHang\r\n"
						+ "	where DATEDIFF(year, ngaySinh,GETDATE())>"+tuoi1+"  and DATEDIFF(year, ngaySinh,GETDATE())<="+tuoi2+"";
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
		public double SoLuongTuoi(int tuoi1 ,int tuoi2) {
			int count= 0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql= "SELECT top 1 ROW_NUMBER() over (order by DATEDIFF(year, ngaySinh,GETDATE())), DATEDIFF(year, ngaySinh,GETDATE()) AS AgeTB\r\n"
						+ "    FROM KhachHang\r\n"
						+ "	where DATEDIFF(year, ngaySinh,GETDATE())>"+tuoi1+"  and DATEDIFF(year, ngaySinh,GETDATE())<="+tuoi2+""
						+ "	order by DATEDIFF(year, ngaySinh,GETDATE()) desc";
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
