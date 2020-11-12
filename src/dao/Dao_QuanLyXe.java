package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;

public class Dao_QuanLyXe {
	public Dao_QuanLyXe() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<NhaCungCap> getAllNCC(){
		ArrayList<NhaCungCap> dsNCC=new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from nhaCungCap";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String maNcc0=rs.getString(1);
				String tenNCC=rs.getString(2);
				NhaCungCap ncc= new NhaCungCap(maNcc0,tenNCC);
				dsNCC.add(ncc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNCC;
	}
	public ArrayList<HangSanXuat> getAllHangSX(){
		ArrayList<HangSanXuat> dsHSX=new ArrayList<HangSanXuat>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from HangSanXuat";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String maHang=rs.getString(1);
				String tenHang=rs.getString(2);
				HangSanXuat hangSanXuat= new HangSanXuat(maHang,tenHang);
				dsHSX.add(hangSanXuat);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHSX;
	}
	public ArrayList<LoaiXe> getAllLoaiXe(){
		ArrayList<LoaiXe> dsLoaiXe=new ArrayList<LoaiXe>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from LoaiXe";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String maLoai=rs.getString(1);
				String tenLoai=rs.getString(2);
				LoaiXe loaiXe= new LoaiXe(maLoai,tenLoai);
				dsLoaiXe.add(loaiXe);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLoaiXe;
	}
	public DefaultTableModel getAllXe() throws SQLException {
		String[] header= {"Mã Xe","Tên Xe", "Loại Xe","Màu xe", "Nhà cung cấp","Hãng sản xuất","Phân Khối","Số Lượng","Giá Nhập","Ngày Nhập","Trạng Thái","Chú Thích"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select *from Xe";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
}
