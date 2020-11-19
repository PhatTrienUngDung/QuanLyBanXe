package dao;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

public class Dao_QuanLyXe {
	private static final String String = null;
	private ArrayList<String> listColor;
	public Dao_QuanLyXe() {
		// TODO Auto-generated constructor stub
		listColor = new ArrayList<String>();
	}
	
	public int getAmountByVehicleID(String maXe) {
		Connection con = ConnectDB.getCon();
		String sql = "select soLuong from Xe where maXe = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maXe);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return -1;
	}
	
	public void getVehicleNum_Bill (String tenXe, String hangSanXuat, String mauXe, String nhaCungCap, TextField txtF) {
		Connection con = ConnectDB.getCon();
		String sql = "select maXe from Xe, NhaCungCap, HangSanXuat where Xe.maNhaCungCap = NhaCungCap.maNhaCungCap and Xe.maHangSanXuat = HangSanXuat.maHangSanXuat and tenXe = ? and HangSanXuat.tenHangSanXuat = ? and mauXe = ? and NhaCungCap.tenNhaCungCap = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tenXe);
			pst.setString(2, hangSanXuat);
			pst.setString(3, mauXe);
			pst.setString(4, nhaCungCap);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				txtF.setText(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}
	
//Đọc dữ liệu lên bảng
	public void getListColor(String tenXe, String hangSanXuat, JComboBox comboBox){
		Connection con = ConnectDB.getCon();
		String sql = "select distinct mauXe from xe, HangSanXuat where Xe.maHangSanXuat=HangSanXuat.maHangSanXuat and HangSanXuat.tenHangSanXuat = ? and tenXe = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, hangSanXuat);
			pst.setString(2, tenXe);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}
// Lấy toàn bộ nhà cung cấp 
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
//Lấy 1 nhà cung cấp được chọn
	public ArrayList<NhaCungCap> getAllNCC(String id){
		ArrayList<NhaCungCap> dsNCC=new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from nhaCungCap where maNhaCungCap='"+id+"'";
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
//Lấy toàn bộ hãng sản xuất
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
//Lấy 1 hãng sản xuất được chọn 
	public ArrayList<HangSanXuat> getAllHangSX(String id){
		ArrayList<HangSanXuat> dsHSX=new ArrayList<HangSanXuat>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from HangSanXuat where maHangSanXuat='"+id+"'";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String maHang=rs.getString(1);
				String tenHang=rs.getString(2);
				String quocGia=rs.getString(3);
				HangSanXuat hangSanXuat= new HangSanXuat(maHang,tenHang,quocGia);
				dsHSX.add(hangSanXuat);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHSX;
	}
//Lấy toàn bộ các loại xe
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
//Lấy loại xe được chọn
	public ArrayList<LoaiXe> getAllLoaiXe(String id){
		ArrayList<LoaiXe> dsLoaiXe=new ArrayList<LoaiXe>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from LoaiXe where maLoaiXe='"+id+"'";
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
//Lấy thông tin xe 
	public ArrayList<Xe> getInfoXe(String id){
		ArrayList<Xe> dsXe=new ArrayList<Xe>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from Xe where maXe='"+id+"'";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String maXe=rs.getString(1);
				String tenXe=rs.getString(2);
				String loaiXe= rs.getString(3);
				String mauXe=rs.getString(4);
				String maNcc=rs.getString(5);
				String maHangSX=rs.getString(6);
				int phanKhoi= rs.getInt(7);
				int soLuong=rs.getInt(8);
				double giaNhap=rs.getDouble(9);
				Date ngay= rs.getDate(10);
				String trangThai=rs.getString(11);
				String chuThich=rs.getString(12);
				String img1= rs.getString(13);
				String img2= rs.getString(14);
				String img3= rs.getString(15);
				Xe xe = new Xe(maXe, tenXe, mauXe, phanKhoi, soLuong, giaNhap, new LoaiXe(loaiXe), new NhaCungCap(maNcc), new HangSanXuat(maHangSX),ngay, trangThai, chuThich, img1, img2, img3);
				dsXe.add(xe);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsXe;
	}
//Hiển thị danh sách xe
	public DefaultTableModel getAllXe() throws SQLException {
		String[] header= {"Mã Xe","Tên Xe", "Màu xe","Loại xe", "Hãng sản xuất","Nhà cung cấp","Quốc gia","Phân khối","Số lượng","Giá nhập","Ngày nhập","Trạng thái","Chú thích", "Tổng tiền"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSanXuat, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.soLuong, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai, Xe.chuThich,giaNhap*soLuong\r\n"
				+ "FROM     Xe INNER JOIN\r\n"
				+ "                  NhaCungCap ON Xe.maNhaCungCap = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
				+ "                  LoaiXe ON Xe.maLoaiXe = LoaiXe.maLoaiXe INNER JOIN\r\n"
				+ "                  HangSanXuat ON Xe.maHangSanXuat = HangSanXuat.maHangSanXuat";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
//Thêm xe mới 
	public boolean themXe(Xe xe) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Xe values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, xe.getMaXe());
			stmt.setString(2, xe.getTenXe());
			stmt.setString(3, xe.getLoaiXe().getMaLoaiXe());
			stmt.setString(4, xe.getMauXe());
			stmt.setString(5, xe.getNhaCungCap().getMaNhaCungCap());
			stmt.setString(6, xe.getHangSanXuat().getMaHangSX());
			stmt.setInt(7, xe.getPhanKhoi());
			stmt.setInt(8, xe.getSoLuong());
			stmt.setDouble(9, xe.getGiaNhap());
			stmt.setDate(10, xe.getNgayNhap());
			stmt.setString(11, xe.getTrangThai());
			stmt.setString(12, xe.getChuThich());
			stmt.setString(13, xe.getImg1());
			stmt.setString(14, xe.getImg2());
			stmt.setString(15, xe.getImg3());
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
	
//Cập nhật dữ liệu
		public boolean update(Xe xe) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				//"Mã Xe","Tên Xe", "Loại Xe","Màu xe", "Nhà cung cấp","Hãng sản xuất","Phân Khối","Số Lượng","Giá Nhập","Ngày Nhập","Trạng Thái","Chú Thích"
				stmt = con.prepareStatement(
						"update Xe set maxe=?,tenxe=?,maloaixe=?,mauxe=?,manhacungcap=?,mahangsanxuat=?,phankhoi=?,soluong=?,gianhap=?,ngaynhap=?,trangthai=?,chuthich=?,img1=?,img2=?,img3=? where maXe=?");
				stmt.setString(1, xe.getMaXe());
				stmt.setString(2, xe.getTenXe());
				stmt.setString(3, xe.getLoaiXe().getMaLoaiXe());
				stmt.setString(4, xe.getMauXe());
				stmt.setString(5, xe.getNhaCungCap().getMaNhaCungCap());
				stmt.setString(6, xe.getHangSanXuat().getMaHangSX());
				stmt.setInt(7, xe.getPhanKhoi());
				stmt.setInt(8, xe.getSoLuong());
				stmt.setDouble(9, xe.getGiaNhap());
				stmt.setDate(10, xe.getNgayNhap());
				stmt.setString(11, xe.getTrangThai());
				stmt.setString(12, xe.getChuThich());
				stmt.setString(13, xe.getImg1());
				stmt.setString(14, xe.getImg2());
				stmt.setString(15, xe.getImg3());
				stmt.setString(16, xe.getMaXe());
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
//Xóa xe
	public void xoaXe(String maXe) throws SQLException {
		Connection a = ConnectDB.getCon();// Tao Ket Noi
		String sql = "delete Xe where maXe='" + maXe + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công xe " + maXe);
		}
	}
//Tìm xe
		public DefaultTableModel timKiem(String search) throws SQLException {
			String[] header= {"Mã Xe","Tên Xe", "Màu xe","Loại xe", "Hãng sản xuất","Nhà cung cấp","Quốc gia","Phân khối","Số lượng","Giá nhập","Ngày nhập","Trạng thái","Chú thích", "Tổng tiền"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSanXuat, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.soLuong, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai, Xe.chuThich,giaNhap*soLuong\r\n"
					+ "FROM     Xe INNER JOIN\r\n"
					+ "                  NhaCungCap ON Xe.maNhaCungCap = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
					+ "                  LoaiXe ON Xe.maLoaiXe = LoaiXe.maLoaiXe INNER JOIN\r\n"
					+ "                  HangSanXuat ON Xe.maHangSanXuat = HangSanXuat.maHangSanXuat where maXe like'" + search + "' or tenXe like'"+search+"' ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
}
