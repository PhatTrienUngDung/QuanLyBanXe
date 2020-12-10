package dao;

import java.lang.reflect.Array;


import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChucVu;
import entity.HangSanXuat;
import entity.HopDong;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;
import entity.LoaiXe;

public class Dao_HopDong {
	private int n;
	public Dao_HopDong() {}
		//Load data
//				public DefaultTableModel getAllHD() throws SQLException {
//					String[] header=  {"Mã Hợp Đồng","Tên Khách Hàng","CMND","Ngày Sinh","Địa Chỉ","Số Điện Thoại","Tên Nhân Viên","Tên Xe","Loại Xe","Màu Xe","Phân Khối","Số Lượng","Gía Nhập","Tổng Tiền","Ngày Lập","Thời gian bảo hành"};
//					DefaultTableModel tableModel = new DefaultTableModel(header, 0);
//					ConnectDB.getInstance();
//					Connection con = ConnectDB.getCon();
//					String sql = "SELECT  HopDong.maHopDong, KhachHang.tenKhachHang, KhachHang.CMND, KhachHang.ngaySinh, KhachHang.diaChi,KhachHang.soDienThoai, NhanVien.tenNhanVien, Xe.tenXe, LoaiXe.tenLoaiXe, Xe.mauXe, Xe.phanKhoi, chiTietHoaDon.soLuong, chiTietHoaDon.donGia, chiTietHoaDon.soLuong*chiTietHoaDon.donGia, HopDong.ngayLap, HopDong.thoiGianBH\r\n" + 
//							"FROM     HopDong INNER JOIN\r\n" + 
//							"                  KhachHang ON HopDong.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n" + 
//							"                  NhanVien ON HopDong.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n" + 
//							"                  Xe ON HopDong.maXe = Xe.maXe INNER JOIN\r\n" + 
//							"                  LoaiXe ON Xe.maLoaiXe = LoaiXe.maLoaiXe INNER JOIN\r\n" + 
//							"                  chiTietHoaDon ON Xe.maXe = chiTietHoaDon.maXe";
//					Statement statement = con.createStatement();
//					ResultSet rs = statement.executeQuery(sql);
//					while (rs.next()) {
//						Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)};
//						tableModel.addRow(o);
//					}
//					return tableModel;
//				}
//				
	
				public HopDong getHopDongByVehicleNum(String maXe) {
					Connection con = ConnectDB.getCon();
					String sql = "select * from HopDong where maXe = '" + maXe + "'";
					try {
						PreparedStatement pst = con.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						while(rs.next()) {
							HopDong hd = new HopDong(rs.getString(1));
							return hd;
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1);
						e1.printStackTrace();
					}
					return null;
				}
	
				public DefaultTableModel getAllXe() throws SQLException{
					String[] header = {"Mã xe","Tên xe","Loại xe","Phiên bản","Phân khối","Số khung","Số máy","Đơn giá","Thuế","Trạng thái"};
					DefaultTableModel tableModel = new DefaultTableModel(header,0);
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					String sql = "select maxe,tenxe,maloaixe,phienban,phankhoi,sokhung,somay,gianhap,trangthai from Xe";
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next()) {
						DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
						DecimalFormat df1 = new DecimalFormat("############");

						Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8),""
								,rs.getString(9)};
						
						tableModel.addRow(o);
					}
					return tableModel;
					
				}
				public DefaultTableModel getAllHD(String[] header1, DefaultTableModel tableModel1) throws SQLException{
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					String sql = "select * from HopDong";
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					Dao_QuanLyXe dao_xe  = new Dao_QuanLyXe();
					Dao_KhachHang dao_kh = new Dao_KhachHang();
					Dao_NhanVien dao_nv = new Dao_NhanVien();
					Dao_LoaiXe dao_lx = new Dao_LoaiXe();
					Xe xe;
					while(rs.next()) {
						//{"Mã hợp đồng","CMND","Tên khách hàng","Số điện thoại","Mã nhân viên", "Tên nhân viên","Mã xe","Tên xe","Loại xe","Phiên bản","Phân khối","Số khung","Số máy","Đơn giá","Thuế","Ngày lập","Thời gian bảo hành"};
						xe = dao_xe.getInfoXe("maXe",rs.getString(4));
						LoaiXe lx = dao_lx.getLoaiXeByID(xe.getLoaiXe().getMaLoaiXe());
						KhachHang kh = dao_kh.getKhachHangById("maKhachHang", rs.getString(2));
						NhanVien nv = dao_nv.getNhanVienById("maNhanVien", rs.getString(3));
						DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
						DecimalFormat df1 = new DecimalFormat("############");
						//double thue = xe.getThueVAT();
						//double donGia=Double.parseDouble(rs.getString(27));
						Object[] o = {rs.getString(1), kh.getCMND(), kh.getTenKhachHang(), kh.getSoDienThoai(), nv.getMaNhanVien(), nv.getTenNhanVien(), xe.getMaXe(), xe.getTenXe(), lx.getTenLoaiXe(), xe.getPhienBan(), xe.getPhanKhoi(), xe.getSoKhung(), xe.getSoMay(), df.format(xe.getDonGia()), df.format(xe.getThueVAT()), rs.getDate(5), rs.getInt(6)+""};
						//Object[] o = {rs.getString(1),rs.getString(9),rs.getString(8),rs.getString(15),rs.getString(4),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(24),rs.getString(25),rs.getString(26),df.format(donGia),"",rs.getString(5),rs.getString(6)};
						tableModel1.addRow(o);
					}
					return tableModel1;
					
				}
				
				public ArrayList<String> getListXeByCustomer(String maKH, String ngay) {
					ArrayList<String> listXe = new ArrayList<String>();
					try {
						ConnectDB.getInstance();
						Connection con = ConnectDB.getCon();
						String sql = "select distinct maXe from HoaDon hd, ChiTietHoaDon cthd"
									+ " where hd.maHoaDon = cthd.maHoaDon and maKhachHang = '" + maKH + "' and ngayLapHoaDon like '%" + ngay + "%'";
						Statement statement = con.createStatement();
						ResultSet rs = statement.executeQuery(sql);
						while(rs.next()) {
							listXe.add(rs.getString(1));
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					return listXe;
				}
				
				public boolean themHD(HopDong hd) {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					PreparedStatement stmt = null;
					int n = 0;
					try {
						stmt = con.prepareStatement("insert into HopDong values(?,?,?,?,?,?)");
						stmt.setString(1, hd.getMaHD());
						stmt.setString(2,hd.getKhachHang().getMaKhachHang());
						stmt.setString(3, hd.getNhanVien().getMaNhanVien());
						stmt.setString(4, hd.getXe().getMaXe());						
						stmt.setDate(5, hd.getNgayLap());
						stmt.setInt(6, hd.getThoiGianBaoHanh());
					
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
			
		//Tìm
			public DefaultTableModel timKiem(String cmnd) throws SQLException {
				String[] header= {"Mã hợp đồng","CMND","Tên khách hàng","Số điện thoại","Mã xe","Tên xe","Loại xe","Phiên bản","Phân khối","Số khung","Số máy","Đơn giá","Thuế","Ngày lập","Thời gian bảo hành"};
				DefaultTableModel tableModel = new DefaultTableModel(header, 0);
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				
				String sql ="select * from HopDong inner join KhachHang ON HopDong.maKhachHang = KhachHang.maKhachHang inner join  Xe ON HopDong.maXe = Xe.maXe where CMND like '" + cmnd + "' ";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
					DecimalFormat df1 = new DecimalFormat("############");
					double donGia=Double.parseDouble(rs.getString(27));
					Object[] o = { rs.getString(1),rs.getString(9),rs.getString(8),rs.getString(15),rs.getString(4),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(24),rs.getString(25),rs.getString(26),df.format(donGia),"",df.format(donGia),rs.getString(6) };
					tableModel.addRow(o);
				}
				return tableModel;
			}
			
			public DefaultTableModel timKiemXe(String tenXe) throws SQLException{
				String[] header = {"Mã xe","Tên xe","Loại xe","Phiên bản","Phân khối","Số khung","Số máy","Đơn giá","Thuế"};
				DefaultTableModel tableModel = new DefaultTableModel(header,0);
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql ="select *from Xe inner join  HopDong inner join KhachHang ON HopDong.maKhachHang = KhachHang.maKhachHang inner join  Xe ON HopDong.maXe = Xe.maXe  here TenXe like '"+tenXe+"'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					Object[] o = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(8),rs.getString(9),rs.getString(10), ""};
					tableModel.addRow(o);
				}
				return tableModel;
			}
			//Ờ mấy zingg gút chốp
			public DefaultTableModel timKiemNgay(String ngayLap) throws SQLException{
				String[] header= {"Mã hợp đồng","CMND","Tên khách hàng","Số điện thoại","Mã xe","Tên xe","Loại xe","Phiên bản","Phân khối","Số khung","Số máy","Đơn giá","Thuế","Ngày lập","Thời gian bảo hành"};
				DefaultTableModel tableModel = new DefaultTableModel(header, 0);
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select * from HopDong inner join KhachHang ON HopDong.maKhachHang = KhachHang.maKhachHang inner join  Xe ON HopDong.maXe = Xe.maXe where HopDong.ngayLap='"+ngayLap+"'";
			//	String sql ="select chiTietHoaDon.* from chiTietHoaDon,HoaDon,HopDong where HoaDon.maHoaDon=chiTietHoaDon.maHoaDon and HoaDon.ngayLapHoaDon='"+ngayLap+"'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					Object[] o = { rs.getString(1),rs.getString(9),rs.getString(8),rs.getString(15),rs.getString(4),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(7),rs.getString(26),rs.getString(9),rs.getDate(5),rs.getString(6) };
					tableModel.addRow(o);
				}
				return tableModel;
			}
			public DefaultTableModel locData(String cmnd,String ngayLap) throws SQLException{
				String[] header = {"Mã xe","Tên xe","Loại xe","Phiên bản","Phân khối","Số khung","Số máy","Đơn giá","Thuế"};
			//	String[] header1= {"Mã hợp đồng","CMND","Tên khách hàng","Số điện thoại","Mã xe","Tên xe","Loại xe","Phiên bản","Phân khối","Số khung","Đơn giá","Thuế","Ngày lập","Thời gian bảo hành"};
		//		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
				DefaultTableModel tableModel1 = new DefaultTableModel(header,0);
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql ="select chiTietHoaDon.* from chiTietHoaDon,HoaDon,HopDong where HoaDon.maHoaDon=chiTietHoaDon.maHoaDon and HoaDon.maKhachHang = '"+cmnd+"' and HoaDon.ngayLapHoaDon='"+ngayLap+"'";
		
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
			
//				while (rs.next()) {
//					double donGia=Double.parseDouble(rs.getString(26));
//					Object[] o = { rs.getString(1),rs.getString(9),rs.getString(8),rs.getString(15),rs.getString(4),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(24),rs.getString(25),rs.getString(8),rs.getString(5),rs.getString(6) };
//					tableModel.addRow(o);
//				}
				while(rs.next()) {
					Object[] o = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(8),"",rs.getString(10), ""};
					tableModel1.addRow(o);
				}
				return tableModel1;
			}
		//Thêm
			
			//Xóa dữ liệu khỏi bảng
				public void xoaHD(String maHD) throws SQLException {
					Connection a = ConnectDB.getCon();// Tao Ket Noi
					String sql = "delete HopDong where maHopDong='" + maHD + "'";
					PreparedStatement pstm = a.prepareStatement(sql);
					if (pstm.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công hợp đồng " + maHD);
					}
				}
		//	Cập nhật dữ liệu
				public boolean update(HopDong hd) {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					PreparedStatement stmt = null;
					int n = 0;
					try {
						
						stmt = con.prepareStatement(
								"update HopDong set maHopDong=?,maKhachHang=?,maNhanVien=?,maXe=?,ngayLap=?,thoiGianBH=? where maHopDong=?");
						stmt.setString(1, hd.getMaHD());
						stmt.setString(2, hd.getKhachHang().getMaKhachHang());
					//	stmt.setString(3, hd.getKhachHang().getCMND());
					//	stmt.setDate(4, hd.getKhachHang().getNgaySinh());
						
					//	stmt.setString(4, hd.getKhachHang().getDiaChi());
					//	stmt.setString(5, hd.getKhachHang().getSoDienThoai());
						stmt.setString(3, hd.getNhanVien().getMaNhanVien());
						stmt.setString(4, hd.getXe().getMaXe());
					//	stmt.setString(8, hd.getXe().getLoaiXe().getTenLoaiXe());
					//	stmt.setString(9, hd.getXe().getMauXe());
					//	stmt.setInt(10, hd.getXe().getPhanKhoi());
					//	stmt.setInt(11, hd.getXe().getSoLuong());
					//	stmt.setDouble(12, hd.getXe().getGiaNhap());
					
						
						
						stmt.setDate(5, hd.getNgayLap());
					
						stmt.setInt(6, hd.getThoiGianBaoHanh());
						stmt.setString(7, hd.getMaHD());
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
			
				
				public ArrayList<NhanVien> getAllNV(){
					ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
					try {
						ConnectDB.getInstance();
						Connection con= ConnectDB.getCon();
						String sql= "select * from NhanVien";
						Statement statement= con.createStatement();
						ResultSet rs= statement.executeQuery(sql);
						
						while(rs.next()) {
							String maNV=rs.getString(1);
							String tenNV=rs.getString(2);
							NhanVien nv= new NhanVien(maNV,tenNV);
							dsNV.add(nv);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsNV;
				}
				public ArrayList<KhachHang> getAllKH(){
					ArrayList<KhachHang> dsKH=new ArrayList<KhachHang>();
					try {
						ConnectDB.getInstance();
						Connection con= ConnectDB.getCon();
						String sql= "select cmnd,tenkhachhang from KhachHang";
						Statement statement= con.createStatement();
						ResultSet rs= statement.executeQuery(sql);
						
						while(rs.next()) {
							String cmnd=rs.getString(1);
							String tenKH=rs.getString(2);
						
							
							KhachHang kh= new KhachHang(tenKH, cmnd);
							dsKH.add(kh);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsKH;
				}
				public ArrayList<Xe> getAllXes(){
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
							String loaiXe = rs.getString(3);
							String mauXe = rs.getString(4);
							int phanKhoi = rs.getInt(7);
							double giaNhap = rs.getDouble(9);
							Xe xe= new Xe(maXe, tenXe,new LoaiXe(loaiXe), mauXe, phanKhoi, giaNhap);
							dsXe.add(xe);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsXe;
				}
				public ArrayList<LoaiXe> getAllLoai(){
					ArrayList<LoaiXe> dsLXe=new ArrayList<LoaiXe>();
					try {
						ConnectDB.getInstance();
						Connection con= ConnectDB.getCon();
						String sql= "select * from LoaiXe";
						Statement statement= con.createStatement();
						ResultSet rs= statement.executeQuery(sql);
						
						while(rs.next()) {
							String maLX=rs.getString(1);
							String tenLX=rs.getString(2);
							
							LoaiXe lx= new LoaiXe(maLX, tenLX);
							dsLXe.add(lx);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return dsLXe;
				}
				public void getList(String tenXe, JComboBox comboBox) {
					Connection con = ConnectDB.getCon();
					String sql = "select DISTINCT HangSanXuat.tenHangSanXuat from Xe, HangSanXuat where Xe.maHangSanXuat=HangSanXuat.maHangSanXuat and tenXe = ?";
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
				public HopDong getInfoHDG(String properties, String id){
					Connection con = ConnectDB.getCon();
					String sql = "select * from HopDong where " + properties + " = ?";
					try {
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, id);
						ResultSet rs = pst.executeQuery();
						while(rs.next()) {
							
							HopDong nv = new HopDong(rs.getString(1),new KhachHang(rs.getString(2)),new NhanVien(rs.getString(3)),new Xe(rs.getString(4)),rs.getDate(5),rs.getInt(6));
							return nv ;
						}
					} catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return null;
				}
				public String getMaHDGTail(String properties, String table) {
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
}