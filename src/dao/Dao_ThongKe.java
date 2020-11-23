package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.NhaCungCap;
import entity.Xe;

public class Dao_ThongKe {
	ArrayList<ChiTietHoaDon> dscthd=new ArrayList<ChiTietHoaDon>();
	
	public Dao_ThongKe() {}
	public DefaultTableModel getAllCTHD(int thang, int nam) throws SQLException{
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			String sql= "SELECT Xe.maXe,Xe.tenXe, sum(chiTietHoaDon.soLuong),TongTien=sum(chiTietHoaDon.soLuong*chitiethoadon.donGia)\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  chiTietHoaDon ON HoaDon.maHoaDon = chiTietHoaDon.maHoaDon INNER JOIN\r\n"
					+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
					+ "where MONTH(ngayLapHoaDon)="+thang+" and YEAR(ngayLapHoaDon)="+nam+"\r\n"
					+ "group by Xe.maXe,Xe.tenXe\r\n"
					+ "order by TongTien desc";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
					Object[] o = { rs.getString(2), rs.getString(3),rs.getString(4)};
					tableModel.addRow(o);
			}
			return tableModel;
	}
	public DefaultTableModel getAllYear(int nam) throws SQLException{
		ConnectDB.getInstance();
		Connection con= ConnectDB.getCon();
		String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		String sql= "SELECT Xe.maXe,Xe.tenXe, sum(chiTietHoaDon.soLuong),TongTien=sum(chiTietHoaDon.soLuong*chitiethoadon.donGia)\r\n"
				+ "FROM     HoaDon INNER JOIN\r\n"
				+ "                  chiTietHoaDon ON HoaDon.maHoaDon = chiTietHoaDon.maHoaDon INNER JOIN\r\n"
				+ "                  Xe ON chiTietHoaDon.maXe = Xe.maXe\r\n"
				+ "where YEAR(ngayLapHoaDon)="+nam+"\r\n"
				+ "group by Xe.maXe,Xe.tenXe\r\n"
				+ "order by TongTien desc";
		Statement statement= con.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		
		while(rs.next()) {
				Object[] o = { rs.getString(2), rs.getString(3),rs.getString(4)};
				tableModel.addRow(o);
		}
		return tableModel;
}
	public String SoLuongXeNhapTrongThang(int thang, int nam) {
		String count =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select count(maXe) from Xe where YEAR(ngaynhap)="+nam+" and  Month(ngaynhap)="+thang+"";
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
	public String SoLuongXeBanTrongThang(int thang, int nam) {
		String count =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT sum(chiTietHoaDon.soLuong)\r\n"
					+ "FROM     chiTietHoaDon INNER JOIN\r\n"
					+ "                  HoaDon ON chiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
					+ "where YEAR(ngayLapHoaDon)="+nam+" and  Month(ngayLapHoaDon)="+thang+"";
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
	
	public ArrayList<Xe> getAllXe(){
		ArrayList<Xe> dsXe=new ArrayList<Xe>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from Xe";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String maXe=rs.getString(1);
				String tenXe=rs.getString(2);
				Xe xe= new Xe(maXe, tenXe);
				dsXe.add(xe);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsXe;
	}
}
