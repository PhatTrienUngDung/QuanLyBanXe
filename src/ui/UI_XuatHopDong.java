package ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.Dao_LoaiXe;
import dao.Dao_XuatHopDong;
import entity.HopDong;
import entity.KhachHang;
import entity.LoaiXe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_XuatHopDong extends JFrame {

	private JPanel contentPane;
	public static JTextField txtmaHD;
	public static JTextField txttenNV;
	public static JTextField txtcmnd;
	public static JTextField txtsdt;
	public static JTextField txtloaiXe;
	public static JTextField txttenXe;
	public static JTextField txtphanKhoi;
	public static JTextField txtmauXe;
	public static JTextField txtsoKhung;
	public static JTextField txtsoMay;
	public static JTextField txtdonGia;
	public static JTextField txttgbh;
	private Dao_XuatHopDong daoxhd = new Dao_XuatHopDong();
	public static JTextField txttenKH;
	public static JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_XuatHopDong frame = new UI_XuatHopDong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_XuatHopDong() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHpngMua = new JLabel("Hợp đồng mua bán xe");
		lblHpngMua.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHpngMua.setBounds(127, 10, 232, 39);
		contentPane.add(lblHpngMua);
		
		JLabel lblMHpng = new JLabel("Mã hợp đồng");
		lblMHpng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMHpng.setBounds(23, 77, 110, 13);
		contentPane.add(lblMHpng);
		Dao_LoaiXe dao_lx = new Dao_LoaiXe();
		txtmaHD = new JTextField();
		txtmaHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				HopDong hd;
				hd = daoxhd.getAllHopDong(txtmaHD.getText());
				if(hd!=null) {
					txtcmnd.setText(hd.getKhachHang().getCMND());
					txttenNV.setText(hd.getNhanVien().getTenNhanVien());
					txttenKH.setText(hd.getKhachHang().getTenKhachHang());
					txttenXe.setText(hd.getXe().getTenXe());
					txtmauXe.setText(hd.getXe().getMauXe());
					txtphanKhoi.setText(hd.getXe().getPhanKhoi()+"");
					txtsoKhung.setText(hd.getXe().getSoKhung());
					txtsoMay.setText(hd.getXe().getSoMay());
					txtsdt.setText(hd.getKhachHang().getSoDienThoai());
					LoaiXe lx = dao_lx.getLoaiXeByID(hd.getXe().getLoaiXe().getMaLoaiXe());
					txtloaiXe.setText(lx.getTenLoaiXe());
					DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
					
					txtdonGia.setText(hd.getXe().getDonGia()+"");
					txttgbh.setText(hd.getThoiGianBaoHanh()+"");
				}
			}
		});
	
		txtmaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmaHD.setBounds(210, 74, 136, 19);
		contentPane.add(txtmaHD);
		txtmaHD.setColumns(10);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnNhnVin.setBounds(21, 120, 112, 13);
		contentPane.add(lblTnNhnVin);
		
		txttenNV = new JTextField();
		txttenNV.setBounds(210, 119, 136, 19);
		contentPane.add(txttenNV);
		txttenNV.setColumns(10);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCmnd.setBounds(24, 164, 61, 13);
		contentPane.add(lblCmnd);
		
		txtcmnd = new JTextField();
		txtcmnd.setBounds(210, 163, 136, 19);
		contentPane.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSinThoi.setBounds(23, 252, 110, 13);
		contentPane.add(lblSinThoi);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(210, 246, 136, 19);
		contentPane.add(txtsdt);
		txtsdt.setColumns(10);
		
		JLabel lblaCh = new JLabel("Loại xe");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblaCh.setBounds(23, 290, 77, 13);
		contentPane.add(lblaCh);
		
		txtloaiXe = new JTextField();
		txtloaiXe.setBounds(210, 284, 136, 19);
		contentPane.add(txtloaiXe);
		txtloaiXe.setColumns(10);
		
		JLabel lblTnXe = new JLabel("Tên xe");
		lblTnXe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnXe.setBounds(23, 325, 77, 13);
		contentPane.add(lblTnXe);
		
		txttenXe = new JTextField();
		txttenXe.setBounds(210, 324, 136, 19);
		contentPane.add(txttenXe);
		txttenXe.setColumns(10);
		
		JLabel lblPhnKhi = new JLabel("Phân khối");
		lblPhnKhi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhnKhi.setBounds(23, 360, 77, 13);
		contentPane.add(lblPhnKhi);
		
		txtphanKhoi = new JTextField();
		txtphanKhoi.setBounds(210, 359, 135, 19);
		contentPane.add(txtphanKhoi);
		txtphanKhoi.setColumns(10);
		
		JLabel lblMuXe = new JLabel("Màu xe");
		lblMuXe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMuXe.setBounds(23, 404, 62, 13);
		contentPane.add(lblMuXe);
		
		txtmauXe = new JTextField();
		txtmauXe.setBounds(209, 403, 137, 19);
		contentPane.add(txtmauXe);
		txtmauXe.setColumns(10);
		
		JLabel lblSKhung = new JLabel("Số khung");
		lblSKhung.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSKhung.setBounds(23, 450, 77, 13);
		contentPane.add(lblSKhung);
		
		txtsoKhung = new JTextField();
		txtsoKhung.setBounds(210, 449, 136, 19);
		contentPane.add(txtsoKhung);
		txtsoKhung.setColumns(10);
		
		JLabel lblSMy = new JLabel("Số máy");
		lblSMy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSMy.setBounds(23, 498, 62, 13);
		contentPane.add(lblSMy);
		
		txtsoMay = new JTextField();
		txtsoMay.setBounds(210, 497, 136, 19);
		contentPane.add(txtsoMay);
		txtsoMay.setColumns(10);
		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnGi.setBounds(23, 542, 77, 13);
		contentPane.add(lblnGi);
		
		txtdonGia = new JTextField();
		txtdonGia.setBounds(210, 541, 136, 19);
		contentPane.add(txtdonGia);
		txtdonGia.setColumns(10);
		
		JLabel lblThiGianBo = new JLabel("Thời gian bảo hành");
		lblThiGianBo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThiGianBo.setBounds(23, 584, 155, 13);
		contentPane.add(lblThiGianBo);
		
		txttgbh = new JTextField();
		txttgbh.setBounds(210, 583, 136, 19);
		contentPane.add(txttgbh);
		txttgbh.setColumns(10);
		
		JLabel lblBnBn = new JLabel("Bên bán");
		lblBnBn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBnBn.setBounds(70, 631, 63, 13);
		contentPane.add(lblBnBn);
		
		JLabel lblBnMua = new JLabel("Bên mua");
		lblBnMua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBnMua.setBounds(380, 631, 66, 13);
		contentPane.add(lblBnMua);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnKhchHng.setBounds(23, 214, 128, 13);
		contentPane.add(lblTnKhchHng);
		
		txttenKH = new JTextField();
		txttenKH.setBounds(210, 213, 136, 19);
		contentPane.add(txttenKH);
		txttenKH.setColumns(10);
		
		JButton btnXuat = new JButton("Xuất");
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillHopDong bill = new BillHopDong();
				//bill.setVisible(true);
				PrintSupport.printComponent(bill.textArea);
			}
		});
//		btnXuat.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//		
//			}
//		});
		btnXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXuat.setBounds(266, 695, 85, 21);
		contentPane.add(btnXuat);
		
		JButton btnng = new JButton("Đóng");
		btnng.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnng.setBounds(383, 697, 85, 21);
		contentPane.add(btnng);
	}
}
