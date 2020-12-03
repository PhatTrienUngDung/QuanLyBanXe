package dao;

import java.awt.Image;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return -1;
	}
	
	public void getListTenXe(JComboBox comboBox){
		Connection con = ConnectDB.getCon();
		String sql = "SELECT DISTINCT tenXe FROM Xe order by tenXe asc";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}
	/*
	public void getVehicleNum_Bill (String soKhung, JTextField txtF) {
		Connection con = ConnectDB.getCon();
		String sql = "SELECT maXe FROM Xe WHERE soKhung = '" + soKhung;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				txtF.setText(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}*/
	
	public String getMaXeTail() {
		Connection con = ConnectDB.getCon();
		String sql = "select Top 1 maXe from Xe order by maXe desc";
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
	
	public void getListVersion(String tenXe, JComboBox comboBox) {
		Connection con = ConnectDB.getCon();
		String sql = "SELECT DISTINCT phienBan FROM Xe WHERE tenXe = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tenXe);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}
	
	public void getListChassisNumber(String tenXe, String version, String mauXe, JComboBox comboBox) {
		Connection con = ConnectDB.getCon();
		String sql = "SELECT DISTINCT soKhung FROM NhaCungCap, Xe WHERE Xe.maNhaCungCap = NhaCungCap.maNhaCungCap and tenXe = '" + tenXe + "' and phienBan = N'"+ version +"' and mauXe = N'"+ mauXe +"'";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}
	
	
	
//Đọc dữ liệu lên bảng
	public void getListColor(String tenXe, String version, JComboBox comboBox){
		Connection con = ConnectDB.getCon();
		String sql = "SELECT DISTINCT mauXe FROM Xe where tenXe = '" + tenXe +"' and phienBan = N'" + version + "'";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
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
	public Xe getInfoXe(String properties, String id){
		//ArrayList<Xe> dsXe=new ArrayList<Xe>();
		Xe xe = new Xe();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getCon();
			String sql= "select * from Xe where " + properties + " ='"+id+"'";
			Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next()) {
				String maXe=rs.getString(1);
				String tenXe=rs.getString(2);
				String loaiXe= rs.getString(3);
				String phienBan = rs.getString(4);
				String mauXe=rs.getString(5);
				String maNcc=rs.getString(6);
				String maHangSX=rs.getString(7);
				int phanKhoi= rs.getInt(8);
				String soKhung= rs.getString(9);
				String soMay=rs.getString(10);
				double giaNhap=rs.getDouble(11);
				Date ngay= rs.getDate(12);
				String trangThai=rs.getString(13);
				String chuThich=rs.getString(14);
				String img1= rs.getString(15);
				
				xe = new Xe(maXe, tenXe, new LoaiXe(loaiXe), phienBan, mauXe, new NhaCungCap(maNcc), new HangSanXuat(maHangSX), phanKhoi, soKhung, soMay, giaNhap, ngay, trangThai, chuThich, img1);
				//dsXe.add(xe);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return xe;
	}
//Hiển thị danh sách xe
	public DefaultTableModel getAllXe() throws SQLException {
		String[] header= {"Mã Xe","Tên Xe", "Màu xe","Loại xe", "Hãng sản xuất","Nhà cung cấp","Quốc gia","Phân khối","Giá nhập","Ngày nhập","Trạng thái", "Phiên Bản","Số khung","Số máy","Chú thích","Tổng tiền","Ảnh"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSanXuat, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.giaNhap,Xe.img1\r\n"
				+ "FROM     Xe INNER JOIN\r\n"
				+ "                  NhaCungCap ON Xe.maNhaCungCap = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
				+ "                  LoaiXe ON Xe.maLoaiXe = LoaiXe.maLoaiXe INNER JOIN\r\n"
				+ "                  HangSanXuat ON Xe.maHangSanXuat = HangSanXuat.maHangSanXuat";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			DecimalFormat df1 = new DecimalFormat("############");
			double tt= Double.parseDouble(rs.getString(16));
			double donGia=Double.parseDouble(rs.getString(9));
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), df1.format(donGia), rs.getString(10) , rs.getString(11), rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),df.format(tt),rs.getString(17)};
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
			stmt.setString(4, xe.getPhienBan());
			stmt.setString(5, xe.getMauXe());
			stmt.setString(6, xe.getNhaCungCap().getMaNhaCungCap());
			stmt.setString(7, xe.getHangSanXuat().getMaHangSX());
			stmt.setInt(8, xe.getPhanKhoi());
			stmt.setString(9, xe.getSoKhung());
			stmt.setString(10, xe.getSoMay());
			stmt.setDouble(11, xe.getGiaNhap());
			stmt.setDate(12, xe.getNgayNhap());
			stmt.setString(13, xe.getTrangThai());
			stmt.setString(14, xe.getChuThich());
			stmt.setString(15, xe.getImg1());
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
						"update Xe set maxe=?,tenxe=?,maloaixe=?,mauxe=?,phienBan=?,manhacungcap=?,mahangsanxuat=?,phankhoi=?,sokhung=?,somay=?,gianhap=?,ngaynhap=?,trangthai=?,chuthich=?,img1=? where maXe=?");
				stmt.setString(1, xe.getMaXe());
				stmt.setString(2, xe.getTenXe());
				stmt.setString(3, xe.getLoaiXe().getMaLoaiXe());
				stmt.setString(4, xe.getPhienBan());
				stmt.setString(5, xe.getMauXe());
				stmt.setString(6, xe.getNhaCungCap().getMaNhaCungCap());
				stmt.setString(7, xe.getHangSanXuat().getMaHangSX());
				stmt.setInt(8, xe.getPhanKhoi());
				stmt.setString(9, xe.getSoKhung());
				stmt.setString(10, xe.getSoMay());
				stmt.setDouble(11, xe.getGiaNhap());
				stmt.setDate(12, xe.getNgayNhap());
				stmt.setString(13, xe.getTrangThai());
				stmt.setString(14, xe.getChuThich());
				stmt.setString(15, xe.getImg1());
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
		
		public boolean updateTrangThai(String id) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				//"Mã Xe","Tên Xe", "Loại Xe","Màu xe", "Nhà cung cấp","Hãng sản xuất","Phân Khối","Số Lượng","Giá Nhập","Ngày Nhập","Trạng Thái","Chú Thích"
				stmt = con.prepareStatement(
						"update Xe set trangThai = N'Hết hàng' where maXe = ?");
				stmt.setString(1, id);
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
	public boolean xoaXe(String maXe) throws SQLException {
		Connection a = ConnectDB.getCon();// Tao Ket Noi
		String sql = "delete Xe where maXe='" + maXe + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công xe " + maXe);
			return true;
		}
		return false;
	}
//Tìm xe
		public DefaultTableModel timKiem(String search) throws SQLException {
			String[] header= {"Mã Xe","Tên Xe", "Màu xe","Loại xe", "Hãng sản xuất","Nhà cung cấp","Quốc gia","Phân khối","Giá nhập","Ngày nhập","Trạng thái", "Phiên Bản","Số khung","Số máy","Chú thích","Tổng tiền","Ảnh"};
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSanXuat, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.giaNhap,Xe.img1\r\n"
					+ "FROM     Xe INNER JOIN\r\n"
					+ "                  NhaCungCap ON Xe.maNhaCungCap = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
					+ "                  LoaiXe ON Xe.maLoaiXe = LoaiXe.maLoaiXe INNER JOIN\r\n"
					+ "                  HangSanXuat ON Xe.maHangSanXuat = HangSanXuat.maHangSanXuat where tenxe like '"+search+"' or maxe like '"+search+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
				DecimalFormat df1 = new DecimalFormat("############");
				double tt= Double.parseDouble(rs.getString(16));
				double donGia=Double.parseDouble(rs.getString(9));
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), df1.format(donGia), rs.getString(10) , rs.getString(11), rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),df.format(tt),rs.getString(17)};
				tableModel.addRow(o);
			}
			return tableModel;
		}
		
		public boolean getImage(JLabel label, String ID) {
			BufferedImage img = null;
			Xe xe_i = getInfoXe("maXe",ID);
			if (xe_i.getImg1().length()==0) {
				label.setVisible(false);
				return false;
			}
			label.setVisible(true);
			String img1= xe_i.getImg1();
			try {
			    img = ImageIO.read(new File(img1));
			} catch (IOException e1) {
			    e1.printStackTrace();
			}
			Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
			        Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			label.setIcon(imageIcon);
			return true;
		}
}
