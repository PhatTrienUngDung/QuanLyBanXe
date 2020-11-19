
package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 8, 2020
* @version: 1.0
*/


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.Dao_NhaCungCap;
import dao.Dao_NhanVien;
import dao.Dao_PhieuNhap;
import entity.PhieuNhap;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UI_PhieuNhap extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JTextField txtmaPhieuNhap;
	private JTextField txtmaNhacc;
	private JTextField txtmaXe;
	private JTextField txtnguoiNhap;
	private JTextField txtsoLuong;
	private JTextField txtdonGia;
	private JTextField txtvat;
	private JTextField txtthanhTien;
	private JTextField txttienThue;
	private JTextField txttiemKiem;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_PhieuNhap frame = new UI_PhieuNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JButton btnThem,btnXoa,btncapNhat,btnlamMoi,btnthanhTien,btntienThue;
	private JComboBox cbtenNhacc,cbtenXe;
	private JTextArea txtchuThich;
	private JDateChooser datengayNhap;
	private Dao_PhieuNhap pn_dao;
	

	/**
	 * Create the frame.
	 */
	public UI_PhieuNhap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Dao_NhaCungCap dao_Ncc = new Dao_NhaCungCap();
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage(UI_PhieuNhap.class.getResource("/image/truck-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(5,5 , screen.width, screen.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel paneltieuDe = new JPanel();
		paneltieuDe.setBackground(Color.LIGHT_GRAY);
		paneltieuDe.setBounds(0, 0, 1340, 40);
		contentPane.add(paneltieuDe);
		paneltieuDe.setLayout(null);
		
		JLabel lbltieuDe = new JLabel("Quản Lý Phiếu Nhập");
		lbltieuDe.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Window-Enter-icon.png")));
		lbltieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltieuDe.setBounds(29, 11, 301, 25);
		paneltieuDe.add(lbltieuDe);
		
		JPanel panelthongTin = new JPanel();
		panelthongTin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin Chi Ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelthongTin.setBackground(new Color(238, 232, 170));
		panelthongTin.setBounds(33, 51, 864, 190);
		contentPane.add(panelthongTin);
		panelthongTin.setLayout(null);
		
		JLabel lblmaPhieuNhap = new JLabel("Mã Phiếu Nhập");
		lblmaPhieuNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaPhieuNhap.setBounds(31, 36, 87, 14);
		panelthongTin.add(lblmaPhieuNhap);
		
		txtmaPhieuNhap = new JTextField();
		txtmaPhieuNhap.setBounds(128, 33, 276, 20);
		panelthongTin.add(txtmaPhieuNhap);
		txtmaPhieuNhap.setColumns(10);
		
		JLabel lblmaNhacc = new JLabel("Mã Cung Cấp");
		lblmaNhacc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaNhacc.setBounds(31, 95, 78, 14);
		panelthongTin.add(lblmaNhacc);
		
		JLabel lbltenNhacc = new JLabel("Tên Nhà CC");
		lbltenNhacc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltenNhacc.setBounds(31, 64, 87, 20);
		panelthongTin.add(lbltenNhacc);
		
		txtmaNhacc = new JTextField();
		txtmaNhacc.setBackground(new Color(211, 211, 211));
		txtmaNhacc.setBounds(128, 95, 276, 20);
		panelthongTin.add(txtmaNhacc);
		txtmaNhacc.setColumns(10);
		
		JLabel lblngayNhap = new JLabel("Ngày Nhập");
		lblngayNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblngayNhap.setBounds(31, 134, 71, 14);
		panelthongTin.add(lblngayNhap);
		
		//date chooser
		datengayNhap = new JDateChooser();
		datengayNhap.setBounds(128, 126, 185, 20);
		panelthongTin.add(datengayNhap);
		datengayNhap.setDateFormatString("dd/MM/yyyy");
		JLabel lblchuThich = new JLabel("Chú Thích");
		lblchuThich.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblchuThich.setBounds(447, 126, 71, 14);
		panelthongTin.add(lblchuThich);
		
		JLabel lblmaXe = new JLabel("Mã Xe");
		lblmaXe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaXe.setBounds(447, 67, 46, 14);
		panelthongTin.add(lblmaXe);
		
		JLabel lbltenXe = new JLabel("Tên Xe");
		lbltenXe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltenXe.setBounds(447, 36, 46, 14);
		panelthongTin.add(lbltenXe);
		
		txtmaXe = new JTextField();
		txtmaXe.setBackground(new Color(211, 211, 211));
		txtmaXe.setBounds(531, 64, 244, 20);
		panelthongTin.add(txtmaXe);
		txtmaXe.setColumns(10);
		
		JLabel lblnguoiNhap = new JLabel("Người Nhập");
		lblnguoiNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnguoiNhap.setBounds(447, 98, 74, 14);
		panelthongTin.add(lblnguoiNhap);
		
		txtnguoiNhap = new JTextField();
		txtnguoiNhap.setBounds(531, 95, 244, 20);
		panelthongTin.add(txtnguoiNhap);
		txtnguoiNhap.setColumns(10);
		
		txtchuThich = new JTextArea();
		txtchuThich.setBounds(531, 129, 244, 50);
		panelthongTin.add(txtchuThich);
		
		cbtenNhacc = new JComboBox(dao_Ncc.getListSuppilerName().toArray());
		cbtenNhacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//cbtenNhacc.setModel(dao_Ncc.getListSuppilerName().toArray())
		//cbtenNhacc.setModel(new DefaultComboBoxModel(new String[] {"", "Công Ty TNHH Thương Mại Ngọc Hoa", "Công Ty TNHH KBK Việt Nam Bearing", "CÔNG TY TNHH SẢN XUẤT VÀ THƯƠNG MẠI TIẾN LỘC"}));
		cbtenNhacc.setBounds(128, 64, 276, 20);
		panelthongTin.add(cbtenNhacc);
		
		cbtenXe = new JComboBox();
		cbtenXe.setModel(new DefaultComboBoxModel(new String[] {"", "Exciter 150 RC", "Exciter 150 CC", "Jupiter 150"}));
		cbtenXe.setBounds(531, 33, 244, 20);
		panelthongTin.add(cbtenXe);
		
		JPanel panel_Tien = new JPanel();
		panel_Tien.setBorder(new TitledBorder(null, "Th\u00E0nh Ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_Tien.setBackground(new Color(238, 232, 170));
		panel_Tien.setBounds(907, 51, 433, 190);
		contentPane.add(panel_Tien);
		panel_Tien.setLayout(null);
		
		JLabel lblsoLuong = new JLabel("Số Lượng");
		lblsoLuong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblsoLuong.setBounds(10, 22, 69, 19);
		panel_Tien.add(lblsoLuong);
		
		txtsoLuong = new JTextField();
		txtsoLuong.setBounds(78, 21, 79, 20);
		panel_Tien.add(txtsoLuong);
		txtsoLuong.setColumns(10);
		
		JLabel lbldonGia = new JLabel("Đơn Giá");
		lbldonGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldonGia.setBounds(10, 52, 46, 14);
		panel_Tien.add(lbldonGia);
		
		txtdonGia = new JTextField();
		txtdonGia.setBounds(78, 49, 137, 20);
		panel_Tien.add(txtdonGia);
		txtdonGia.setColumns(10);
		
		JLabel lblVat = new JLabel("%VAT");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVat.setBounds(10, 86, 46, 14);
		panel_Tien.add(lblVat);
		
		txtvat = new JTextField();
		txtvat.setBounds(78, 83, 79, 20);
		panel_Tien.add(txtvat);
		txtvat.setColumns(10);
		
		btnthanhTien = new JButton("Tổng Tiền");
		btnthanhTien.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Money-icon.png")));
		btnthanhTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnthanhTien.setBackground(new Color(255, 248, 220));
		btnthanhTien.setBounds(78, 127, 137, 39);
		panel_Tien.add(btnthanhTien);
		
	     btntienThue = new JButton("Tiền Thuế");
		btntienThue.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Percent-icon.png")));
		btntienThue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btntienThue.setBackground(new Color(255, 248, 220));
		btntienThue.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			}
		});
		btntienThue.setBounds(251, 127, 143, 39);
		panel_Tien.add(btntienThue);
		
		txtthanhTien = new JTextField();
		txtthanhTien.setBackground(SystemColor.inactiveCaption);
		txtthanhTien.setBounds(301, 49, 122, 20);
		panel_Tien.add(txtthanhTien);
		txtthanhTien.setColumns(10);
		
		txttienThue = new JTextField();
		txttienThue.setBackground(SystemColor.inactiveCaption);
		txttienThue.setBounds(301, 83, 122, 20);
		panel_Tien.add(txttienThue);
		txttienThue.setColumns(10);
		
		JLabel lblthanhTien = new JLabel("Thành Tiền");
		lblthanhTien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblthanhTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblthanhTien.setBounds(222, 52, 69, 14);
		panel_Tien.add(lblthanhTien);
		
		JLabel lbltienThue = new JLabel("Tiền Thuế");
		lbltienThue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltienThue.setBounds(232, 85, 55, 17);
		panel_Tien.add(lbltienThue);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(Color.WHITE);
		panelTable.setBounds(0, 252, 1288, 372);
		contentPane.add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 11, 1224, 350);
		panelTable.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				 "Mã Phiếu", "Mã Nhà Cung Cấp", "Người Nhập", "Tên Xe", "Số Lượng", "Đơn Giá"," Tiền Thuế","Thành Tiền","Chú Thích"	 
			}
		));
		
		JPanel panelchucNang = new JPanel();
		panelchucNang.setBackground(new Color(255, 165, 0));
		panelchucNang.setBounds(678, 646, 631, 45);
		contentPane.add(panelchucNang);
		panelchucNang.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Button-Add-icon.png")));
		btnThem.setBackground(new Color(255, 222, 173));
		btnThem.setBounds(36, 5, 119, 34);
		panelchucNang.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/delete-icon.png")));
		btnXoa.setBackground(new Color(255, 222, 173));
		btnXoa.setBounds(192, 5, 112, 34);
		panelchucNang.add(btnXoa);
		
		btncapNhat = new JButton("Cập Nhật");
		btncapNhat.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Other-Update-Metro-icon.png")));
		btncapNhat.setBackground(new Color(255, 222, 173));
		btncapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btncapNhat.setBounds(327, 5, 127, 34);
		panelchucNang.add(btncapNhat);
		
		btnlamMoi = new JButton("Làm Mới");
		btnlamMoi.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Actions-view-refresh-icon.png")));
		btnlamMoi.setBackground(new Color(255, 222, 173));
		btnlamMoi.setBounds(485, 5, 112, 34);
		panelchucNang.add(btnlamMoi);
		
		JPanel paneltimKiem = new JPanel();
		paneltimKiem.setBackground(new Color(169, 169, 169));
		paneltimKiem.setBounds(10, 646, 547, 45);
		contentPane.add(paneltimKiem);
		paneltimKiem.setLayout(null);
		
		JLabel lbltimKiem = new JLabel("Nhập mã phiếu cần tìm");
		lbltimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltimKiem.setBounds(10, 14, 159, 14);
		paneltimKiem.add(lbltimKiem);
		
		txttiemKiem = new JTextField();
		txttiemKiem.setBounds(188, 9, 211, 25);
		paneltimKiem.add(txttiemKiem);
		txttiemKiem.setColumns(10);
		
		JButton btntim = new JButton("Tìm");
		btntim.setBackground(new Color(255, 255, 0));
		btntim.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/search1.png")));
		btntim.setBounds(430, 8, 107, 26);
		paneltimKiem.add(btntim);
		
		//event
		btnlamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btncapNhat.addActionListener(this);
		btnthanhTien.addActionListener(this);
		btnthanhTien.addActionListener(this);
		btntienThue.addActionListener(this);
	}
	public void themVaoTable(PhieuNhap pn,DefaultTableModel modelTable) {
		modelTable.addRow(new Object[] {
			pn.getMaPhieuNhap(),pn.getNhaCungCap().getMaNhaCungCap(),pn.getNhanVien().getTenNhanVien(),
			pn.getXe().getTenXe(),pn.getSoLuong(),pn.getDonGia(),pn.getTienThue(),pn.getThanhTien(),pn.getChuThich()
			
		});
	}
	public void docDuLieuTuSQLVaoTable() {
		//DefaultTableModel<PhieuNhap> pn = pn_dao.getAllPN();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnlamMoi))
			lamMoi();
		if(o.equals(btnThem))
			themMoi();
			
	}
	
	//ham retest
	public void lamMoi() {
		txtmaPhieuNhap.setText("");
		cbtenNhacc.setSelectedIndex(-1);
		txtmaNhacc.setText("");
		cbtenXe.setSelectedIndex(-1);
		txtmaXe.setText("");
		txtnguoiNhap.setText("");
		txtchuThich.setText("");
		txtsoLuong.setText("");
		txtdonGia.setText("");
		txtvat.setText("");
		txtthanhTien.setText("");
		txttienThue.setText("");
		datengayNhap.setCalendar(null);
		txtmaPhieuNhap.requestFocus();
	}
	
	//ham them
	public void themMoi() {
		
	}
}


