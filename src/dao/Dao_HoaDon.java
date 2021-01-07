package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HangSanXuat;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;


public class Dao_HoaDon {

	@SuppressWarnings("unused")
	private ArrayList<HoaDon> listBill;
	@SuppressWarnings("unused")
	private HoaDon hd;
	
	public Dao_HoaDon() {
		// TODO Auto-generated constructor stub
		listBill = new ArrayList<HoaDon>();
		hd = new HoaDon();
	}
	
	public HoaDon getHoaDonByID(String ID) {
		Connection con = ConnectDB.getCon();
		String sql = "select * from HoaDon where maHoaDon = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				HoaDon hd = new HoaDon(rs.getString(1), new KhachHang(rs.getString(2)), new NhanVien(rs.getString(3)), rs.getDate(4), rs.getDouble(5));
				return hd;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
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
	
	public double getTotalMoneyHD(String maHD) {
		Connection con = ConnectDB.getCon();
		String sql = "select tongTien from HoaDon where maHoaDon = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maHD);
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
	
	public KhachHang getKhachHangbyHDId(String maHD) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select maKhachHang from HoaDon where maHoaDon = '"+ maHD +"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Dao_KhachHang dao_kh = new Dao_KhachHang();
				KhachHang kh = dao_kh.getKhachHangById("maKhachHang", rs.getString(1));
				return kh;
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Xe> getListOrderDetails(String maHD){
		ArrayList<Xe> listOrderDetails = new ArrayList<Xe>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select maXe from ChiTietHoaDon where maHoaDon = '"+ maHD +"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
				Xe xe = dao_xe.getInfoXe("maXe", rs.getString(1));
				listOrderDetails.add(xe);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return listOrderDetails;
	}
	
	public boolean createHD (HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon values (?,?,?,?,?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(2, hd.getKhachHang().getMaKhachHang());
			stmt.setString(3, hd.getNhanVien().getMaNhanVien());
			stmt.setDate(4, hd.getNgayLapHoaDon());
			stmt.setDouble(5, hd.getTongTien());
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return n > 0;
	}
	
	public boolean createCTHD (ChiTietHoaDon cthd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietHoaDon values (?,?,?,?)");
			stmt.setString(1, cthd.getHoaDon().getMaHoaDon());
			stmt.setString(2, cthd.getSanPham().getMaXe());
			stmt.setDouble(3, cthd.getDonGia());
			stmt.setDouble(4, cthd.getThueVAT());
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return n > 0;
	}
	
	public DefaultTableModel getAllOrder(String[] header, DefaultTableModel tableModel) throws SQLException {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select Top 50 hd.*, kh.tenKhachHang, kh.CMND, nv.tenNhanVien "
				+ "from HoaDon hd, KhachHang kh, NhanVien nv "
				+ "where hd.maKhachHang = kh.maKhachHang and hd.maNhanVien = nv.maNhanVien "
				+ "order by maHoaDon desc";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			double tien = Double.parseDouble(rs.getString(5));
			Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(7), rs.getString(3), rs.getString(8), rs.getString(4), df.format(tien)};
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllOrderById(String[] header, DefaultTableModel tableModel, String maHD, String maKH, String tenKH, String ngay) throws SQLException {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select hd.*, kh.tenKhachHang, kh.CMND, nv.tenNhanVien "
				+ "from HoaDon hd, KhachHang kh, NhanVien nv "
				+ "where hd.maKhachHang = kh.maKhachHang and hd.maNhanVien = nv.maNhanVien and "
							+ "hd.maHoaDon like '%" + maHD + "%' and hd.maKhachHang like '%" + maKH + "%' and kh.tenKhachHang like N'%" + tenKH + "%' and hd.ngayLapHoaDon like '%"+ ngay +"%' " 
				+ "order by hd.maHoaDon desc";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			double tien = Double.parseDouble(rs.getString(5));
			Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(7), rs.getString(3), rs.getString(8), rs.getString(4), df.format(tien)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	
	public DefaultTableModel getOrderDetails(String[] header, DefaultTableModel tableModel, String maHD) throws SQLException {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
		Dao_LoaiXe dao_lx = new Dao_LoaiXe();
		Dao_HangSanXuat dao_hsx = new Dao_HangSanXuat();
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from ChiTietHoaDon where maHoaDon = '"+ maHD + "'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Xe xe = dao_xe.getInfoXe("maXe", rs.getString(2));
			LoaiXe lx = dao_lx.getLoaiXeByID(xe.getLoaiXe().getMaLoaiXe());
			HangSanXuat hsx = dao_hsx.getHangSanXuatById(xe.getHangSanXuat().getMaHangSX());
			Object[] o = {rs.getString(1), rs.getString(2), xe.getTenXe(), lx.getTenLoaiXe(), xe.getPhienBan(), xe.getMauXe(), xe.getPhanKhoi()+"", hsx.getTenHangSX(), xe.getSoKhung(), xe.getSoMay(), df.format(Double.parseDouble(rs.getString(3))), df.format(Double.parseDouble(rs.getString(4))), df.format(xe.getThanhTien())};
			tableModel.addRow(o);
		}
		return tableModel;
	}

}
