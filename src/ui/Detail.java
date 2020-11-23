package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.ConnectDB;
import dao.Dao_NhaCungCap;
import dao.Dao_QuanLyXe;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

public class Detail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dao_QuanLyXe dao_qlLyXe= new Dao_QuanLyXe();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		 EventQueue.invokeLater(new Runnable() { public void run() { try { Detail
		 frame = new Detail("aa"); frame.setVisible(true); } catch (Exception e) {
		 e.printStackTrace(); } } });
		
	}

	/**
	 * Create the frame.
	 */
	public Detail(String id) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Xe listXe= dao_qlLyXe.getInfoXe(id);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(320, 80, 896, 681);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbImg = new JLabel();
		lbImg.setBounds(48, 76, 348, 486);
		BufferedImage img = null;
		String img1= listXe.getImg1();
		try {
		    img = ImageIO.read(new File(img1));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lbImg.getWidth(), lbImg.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lbImg.setIcon(imageIcon);
		
	
				
				
		contentPane.add(lbImg);
		
		JLabel lbten = new JLabel("Tên xe");
		lbten.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbten.setBounds(450, 76, 130, 14);
		contentPane.add(lbten);
		
		JLabel lbMau = new JLabel("Màu xe");
		lbMau.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMau.setBounds(450, 115, 130, 19);
		contentPane.add(lbMau);
		
		JLabel lbSl = new JLabel("Số lượng");
		lbSl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbSl.setBounds(450, 159, 130, 19);
		contentPane.add(lbSl);
		
		JLabel lbPhanKhoi = new JLabel("Phân khối");
		lbPhanKhoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbPhanKhoi.setBounds(450, 205, 130, 19);
		contentPane.add(lbPhanKhoi);
		
		JLabel lbNcc = new JLabel("Nhà cung cấp");
		lbNcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbNcc.setBounds(450, 254, 88, 19);
		contentPane.add(lbNcc);
		
		JLabel lbHang = new JLabel("Hãng sản xuất");
		lbHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbHang.setBounds(450, 301, 130, 19);
		contentPane.add(lbHang);
		
		JLabel lbLoai = new JLabel("Loại xe");
		lbLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLoai.setBounds(450, 385, 130, 19);
		contentPane.add(lbLoai);
		
		JLabel lbGia = new JLabel("Giá nhập");
		lbGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbGia.setBounds(450, 428, 130, 19);
		contentPane.add(lbGia);
		
		JLabel lbNgay = new JLabel("Ngày nhập");
		lbNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbNgay.setBounds(450, 473, 130, 14);
		contentPane.add(lbNgay);
		
		JLabel lbTrangThai = new JLabel("Trạng thái");
		lbTrangThai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTrangThai.setBounds(450, 520, 130, 19);
		contentPane.add(lbTrangThai);
		
		JLabel lbChuThic = new JLabel("Chú thích");
		lbChuThic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbChuThic.setBounds(450, 560, 130, 19);
		contentPane.add(lbChuThic);
		
		JLabel lbQuocGia = new JLabel("Quốc gia sản xuất");
		lbQuocGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbQuocGia.setBounds(450, 344, 109, 19);
		contentPane.add(lbQuocGia);
		
		JLabel lbEditten = new JLabel("...");
		lbEditten.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditten.setBounds(609, 76, 188, 14);
		contentPane.add(lbEditten);
		
		lbEditten.setText(listXe.getTenXe());
		
		
		JLabel lbEditMau = new JLabel("...");
		lbEditMau.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditMau.setBounds(609, 115, 188, 19);
		contentPane.add(lbEditMau);
		lbEditMau.setText(listXe.getMauXe());
		
		JLabel lbEditSl = new JLabel("...");
		lbEditSl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditSl.setBounds(609, 159, 188, 19);
		contentPane.add(lbEditSl);
		String sl= Integer.toString(listXe.getSoLuong());
		lbEditSl.setText(sl);
		
		JLabel lbEditPhanKhoi = new JLabel("...");
		lbEditPhanKhoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditPhanKhoi.setBounds(609, 205, 188, 19);
		contentPane.add(lbEditPhanKhoi);
		String phanKhoi= Integer.toString(listXe.getPhanKhoi());
		lbEditPhanKhoi.setText(phanKhoi);
		
		String id1= listXe.getNhaCungCap().getMaNhaCungCap();
		String id2=listXe.getLoaiXe().getMaLoaiXe();
		String id3=listXe.getHangSanXuat().getMaHangSX();
		ArrayList<LoaiXe> dsLoai= dao_qlLyXe.getAllLoaiXe(id2);
		ArrayList<NhaCungCap> dsncc= dao_qlLyXe.getAllNCC(id1);
		ArrayList<HangSanXuat> dshsx= dao_qlLyXe.getAllHangSX(id3);
		
		JLabel lbeditNcc = new JLabel("...");
		lbeditNcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbeditNcc.setBounds(609, 254, 225, 19);
		contentPane.add(lbeditNcc);
		lbeditNcc.setText(dsncc.get(0).getTenNhaCungCap());
		
		JLabel lbEditHang = new JLabel("...");
		lbEditHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditHang.setBounds(609, 301, 188, 19);
		contentPane.add(lbEditHang);
		
		lbEditHang.setText(dshsx.get(0).getMaHangSX());
		
		JLabel lbeditQuocGia = new JLabel("...");
		lbeditQuocGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbeditQuocGia.setBounds(609, 344, 188, 19);
		contentPane.add(lbeditQuocGia);
		lbeditQuocGia.setText(dshsx.get(0).getQuocGia());
		
		JLabel lbEditLoai = new JLabel("...");
		lbEditLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditLoai.setBounds(609, 385, 188, 19);
		contentPane.add(lbEditLoai);
		lbEditLoai.setText(dsLoai.get(0).getTenLoaiXe());
		
		JLabel lbEditGia = new JLabel("...");
		lbEditGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditGia.setBounds(609, 428, 188, 19);
		contentPane.add(lbEditGia);
		String gia= Double.toString(listXe.getGiaNhap());
		lbEditGia.setText(gia);
		
		JLabel lbeditNgay = new JLabel("...");
		lbeditNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbeditNgay.setBounds(609, 473, 188, 14);
		contentPane.add(lbeditNgay);
		lbeditNgay.setText(listXe.getNgayNhap().toString());
		
		JLabel lbEditTt = new JLabel("...");
		lbEditTt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditTt.setBounds(609, 520, 188, 19);
		contentPane.add(lbEditTt);
		lbEditTt.setText(listXe.getTrangThai());
		
		JLabel lbEditChuThich = new JLabel("...");
		lbEditChuThich.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditChuThich.setBounds(609, 560, 188, 19);
		contentPane.add(lbEditChuThich);
		lbEditChuThich.setText(listXe.getChuThich());
		
		JLabel lbeditdetail = new JLabel("...");
		lbeditdetail.setHorizontalAlignment(SwingConstants.CENTER);
		lbeditdetail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbeditdetail.setBounds(172, 10, 523, 35);
		lbeditdetail.setText("Thông tin chi tiết xe "+listXe.getTenXe());
		contentPane.add(lbeditdetail);
	}
}
