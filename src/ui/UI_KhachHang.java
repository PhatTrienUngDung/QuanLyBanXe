package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 7, 2020
* @version: 1.0
*/

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

import connect.ConnectDB;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import entity.KhachHang;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

public class UI_KhachHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmaKh;
	private JTextField txttenKh;
	private JTextField txtdiaChi;
	private JTextField txtEmail;
	private JTextField txtchuThich;
	private JTextField txtsoDt;
	private JTable table;
	private JButton btnThem,btnXoa,btncapNhat,btnlamMoi,btntimKiem;
	private JTextField txttimKiem;
	private DefaultTableModel tableModel;
	private JDateChooser dcngaySinh,dcngayGiaNhap;
	private Dao_KhachHang dao_kh;
	private ArrayList<String> cmnd ;
	private JTextField txtCmnd;
	private JComboBox cbgioiTinh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_KhachHang frame = new UI_KhachHang();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UI_KhachHang() {
		
		try {
			ConnectDB.getInstance().connect();
			
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(UI_KhachHang.class.getResource("/image/customer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(5, 5, screen.width, screen.height);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTimkiem = new JPanel();
		panelTimkiem.setBackground(SystemColor.control);
		panelTimkiem.setBounds(915, 134, 597, 53);
		contentPane.add(panelTimkiem);
		panelTimkiem.setLayout(null);
		

		JLabel lbltimKiem = new JLabel("Nhập thông tin khách hàng cần tìm\r\n");
		lbltimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltimKiem.setForeground(new Color(0, 0, 0));
		lbltimKiem.setBounds(10, 14, 237, 26);
		panelTimkiem.add(lbltimKiem);

	

		btntimKiem = new JButton("Tìm Kiếm");
		btntimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txttimKiem.getText().length()>0) {
					try {
						timKhachHang();
					}catch(SQLException e1) {
						e1.printStackTrace();
						
					}
				}
				else {
						try {
							loadKH();
						}catch(SQLException e1) {
							e1.printStackTrace();
						}
				}
			}
		});
		btntimKiem.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/search1.png")));
		btntimKiem.setBackground(new Color(255,190,87));
		btntimKiem.setForeground(new Color(0, 0, 0));
		btntimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btntimKiem.setBounds(478, 17, 109, 23);
		panelTimkiem.add(btntimKiem);
		
		txttimKiem = new JTextField();
		txttimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(txttimKiem.getText().length()==0) {
					try {
						loadKH();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(txttimKiem.getText().length()>0) {
					try {
						timKhachHang();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		txttimKiem.setBounds(270, 19, 177, 20);
		panelTimkiem.add(txttimKiem);
		txttimKiem.setColumns(10);
		
		JPanel panelthongTin = new JPanel();
		panelthongTin.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelthongTin.setBackground(SystemColor.control);
		panelthongTin.setBounds(10, 539, 1055, 169);
		contentPane.add(panelthongTin);
		panelthongTin.setLayout(null);
		

		JLabel lbltenKh = new JLabel("Tên Khách Hàng");
		lbltenKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltenKh.setBounds(524, 27, 104, 19);
		panelthongTin.add(lbltenKh);



		JLabel lblgioiTinh = new JLabel("Giới Tính");
		lblgioiTinh.setBackground(new Color(255, 248, 220));
		lblgioiTinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblgioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblgioiTinh.setBounds(20, 56, 107, 19);
		panelthongTin.add(lblgioiTinh);



		JLabel lblngaySinh = new JLabel("Ngày Sinh");
		lblngaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblngaySinh.setBounds(20, 115, 104, 17);
		panelthongTin.add(lblngaySinh);



		JLabel lbldiaChi = new JLabel("Địa Chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldiaChi.setBounds(524, 57, 63, 19);
		panelthongTin.add(lbldiaChi);


		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(524, 86, 63, 17);
		panelthongTin.add(lblEmail);
		

		JLabel lblsoDt = new JLabel("Số Điện Thoại");
		lblsoDt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblsoDt.setBounds(20, 85, 104, 19);
		panelthongTin.add(lblsoDt);

		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 85, 88, 19);
		panelthongTin.add(lblNewLabel_5);

		
		


		JLabel lblchuThich = new JLabel("Chú Thích");
		lblchuThich.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblchuThich.setBounds(524, 114, 57, 19);
		panelthongTin.add(lblchuThich);
		Dao_HoaDon dao_hd = new Dao_HoaDon();
		//
		String maKH = dao_hd.getMaHDTail("maKhachHang", "KhachHang");
		txtmaKh = new JTextField();
		txtmaKh.setText(maKH);
		txtmaKh.setEditable(false);
		txtmaKh.setBounds(137, 26, 276, 20);
		panelthongTin.add(txtmaKh);
		txtmaKh.setColumns(10);
		
		txttenKh = new JTextField();
		txttenKh.setBounds(638, 26, 342, 20);
		panelthongTin.add(txttenKh);
		txttenKh.setColumns(10);
		

		cbgioiTinh = new JComboBox();
		cbgioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbgioiTinh.setBounds(137, 55, 145, 20);
		panelthongTin.add(cbgioiTinh);

		
		txtdiaChi = new JTextField();
		txtdiaChi.setBounds(638, 55, 342, 20);
		panelthongTin.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(638, 84, 342, 20);
		panelthongTin.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtchuThich = new JTextField();
		txtchuThich.setForeground(Color.BLACK);
		txtchuThich.setBackground(new Color(255, 255, 255));
		txtchuThich.setBounds(638, 115, 342, 20);
		panelthongTin.add(txtchuThich);
		txtchuThich.setColumns(10);
		
		txtsoDt = new JTextField();
		txtsoDt.setBounds(137, 84, 276, 20);
		panelthongTin.add(txtsoDt);
		txtsoDt.setColumns(10);
		

		JLabel lblmaKh = new JLabel("Mã Khách Hàng");
		lblmaKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaKh.setBounds(20, 28, 393, 17);
		panelthongTin.add(lblmaKh);

		
		dcngaySinh = new JDateChooser();
		dcngaySinh.setBounds(137, 112, 145, 20);
		dcngaySinh.setDateFormatString("yyy/MM/dd");
		panelthongTin.add(dcngaySinh);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCmnd.setBounds(20, 143, 393, 14);
		panelthongTin.add(lblCmnd);
		
		txtCmnd = new JTextField();
		txtCmnd.setBounds(137, 140, 276, 20);
		panelthongTin.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JPanel panelchucNang = new JPanel();
		panelchucNang.setBackground(new Color(231,150,36));
		panelchucNang.setBounds(1098, 539, 414, 169);
		contentPane.add(panelchucNang);
		panelchucNang.setLayout(null);

		btnXoa = new JButton("Xóa");
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Khách hàng này sẽ bị xóa","Chú ý", JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r = table.getSelectedRow();
							tableModel.removeRow(r);
							xoaKhachHang();
							
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Delete-group-icon.png")));
		btnXoa.setBackground(new Color(255,190,87));
		btnXoa.setBounds(237, 33, 135, 49);
		panelchucNang.add(btnXoa);
		
		btncapNhat = new JButton("Cập Nhật");
		btncapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(validData()) {
				try {
					if(row !=-1) {
						JFrame f = new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Khách Hàng '"+txttenKh.getText()+"' sẽ được cập nhật !!!","Chú ý ",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String makH = txtmaKh.getText();
				    		String tenkH = txttenKh.getText();
				    		String cmnd = txtCmnd.getText();
				    		String gioiTinh = cbgioiTinh.getSelectedItem().toString();
				    		String date = ((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText();
				    		Date ngay = Date.valueOf(LocalDate.parse(date));
				    		Date ngaygiaNhap = Date.valueOf(LocalDate.now());
				    		String diachi = txtdiaChi.getText();
				    		String email = txtEmail.getText();
				    		String sodt = txtsoDt.getText();
				    		String ghiChu = txtchuThich.getText();
				    		KhachHang kh = new KhachHang(makH,tenkH,cmnd,gioiTinh,ngay,ngaygiaNhap,diachi,email,sodt,ghiChu);
				    		if(dao_kh.update(kh)) {
				    			//loadKH();
				    			update();
					    		JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
				    		}
				    		txtmaKh.setText("");
							txtchuThich.setText("");
							txtdiaChi.setText("");
							txtEmail.setText("");
							txtsoDt.setText("");
							txttenKh.setText("");
							txttimKiem.setText("");
							txtCmnd.setText("");
							dcngaySinh.setCalendar(null);
							dcngayGiaNhap.setCalendar(null);
							cbgioiTinh.setSelectedIndex(-1);
							txttenKh.requestFocus();
//				    		try {
//				    			loadKH();
//				    		}catch(Exception e2) {
//				    			e2.printStackTrace();
//				    		}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần cập nhật");
				}catch(Exception e2) {
					e2.printStackTrace();
					}
				}
			}
		});
		btncapNhat.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-edit-icon.png")));
		btncapNhat.setBackground(new Color(255,190,87));
		btncapNhat.setBounds(56, 110, 135, 49);
		panelchucNang.add(btncapNhat);
		
		btnlamMoi = new JButton("Làm Mới");
		btnlamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtmaKh.setText("");
				txtchuThich.setText("");
				txtdiaChi.setText("");
				txtEmail.setText("");
				txtsoDt.setText("");
				txttenKh.setText("");
				txttimKiem.setText("");
				txtCmnd.setText("");
				cbgioiTinh.setSelectedIndex(-1);
				dcngaySinh.setCalendar(null);
				dcngayGiaNhap.setCalendar(null);
				txtmaKh.requestFocus();
			}
		});
		
		btnlamMoi.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/refresh-icon.png")));
		btnlamMoi.setBackground(new Color(255,190,87));
		btnlamMoi.setBounds(237, 110, 135, 49);
		panelchucNang.add(btnlamMoi);
		
		dcngaySinh.setDateFormatString("yyy-MM-dd");

		
		JLabel lblngayGiaNhap = new JLabel("Ngày Gia Nhập");
		lblngayGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblngayGiaNhap.setBounds(524, 143, 88, 14);
		panelthongTin.add(lblngayGiaNhap);
		
		dcngayGiaNhap = new JDateChooser();
		dcngayGiaNhap.setBounds(638, 140, 183, 20);
		dcngayGiaNhap.setDateFormatString("yyyy-MM-dd");
		panelthongTin.add(dcngayGiaNhap);
	    btnThem = new JButton("Thêm");
	    btnThem.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    	 if(validData() && CMND(txtCmnd.getText())==false ) {
	    	  //try {
	    		String makH = txtmaKh.getText();
	    		String tenkH = txttenKh.getText();
	    		String cmnd = txtCmnd.getText();
	    		String gioiTinh = cbgioiTinh.getSelectedItem().toString();
	    		String date = ((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText();
	    		Date ngay = Date.valueOf(LocalDate.parse(date));
	    		String dategn = ((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).getText();
	    		Date ngaygiaNhap = Date.valueOf(LocalDate.parse(dategn));
	    		String diachi = txtdiaChi.getText();
	    		String email = txtEmail.getText();
	    		String sodt = txtsoDt.getText();
	    		String ghiChu = txtchuThich.getText();
	    		KhachHang kh = new KhachHang(makH,tenkH,cmnd,gioiTinh,ngay,ngaygiaNhap,diachi,email,sodt,ghiChu);
	    		if(dao_kh.themKH(kh))
	    		{
	    			String maKH = dao_hd.getMaHDTail("maKhachHang", "KhachHang");
		    		JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
		    		txtmaKh.setText(maKH);
					txtchuThich.setText("");
					txtdiaChi.setText("");
					txtEmail.setText("");
					txtsoDt.setText("");
					txttenKh.setText("");
					txtCmnd.setText("");
					txttimKiem.setText("");
					dcngaySinh.setCalendar(null);
					cbgioiTinh.setSelectedIndex(-1);
					dcngayGiaNhap.setCalendar(null);
					txtmaKh.requestFocus();
					tableModel.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getCMND(),kh.getGioiTinh(),kh.getNgaySinh()+"",kh.getNgaygiaNhap()+"",kh.getDiaChi(),kh.getEmail(),kh.getSoDienThoai(),kh.getChuThich()});
	    		}
	    		
	    	
	    	 }
	    	 else {
	    		 JOptionPane.showMessageDialog(null, "Đã trùng chứng minh nhân dân");
	    	 }
	    	}
	    });
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(255,190,87));
		btnThem.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-add-icon.png")));
		btnThem.setBounds(56, 33, 135, 49);
		panelchucNang.add(btnThem);
		

		JLabel lblchucNang = new JLabel("Chức Năng");
		lblchucNang.setBounds(124, 0, 173, 23);
		panelchucNang.add(lblchucNang);
		lblchucNang.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Settings-icon.png")));
		lblchucNang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblchucNang.setForeground(Color.BLACK);
		lblchucNang.setBackground(Color.GREEN);
		lblchucNang.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 1502, 331);
		contentPane.add(scrollPane);
		String[] header = {
				"Mã Khách Hàng", "Tên Khách Hàng","CMND", "Giới Tính", "Ngày Sinh", "Ngày Gia Nhập","Địa Chỉ", "Email", "Số Điện Thoại","Chú Thích"
		};
		tableModel = new DefaultTableModel(header,0);
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtmaKh.setText(tableModel.getValueAt(i, 0).toString());
				txttenKh.setText(tableModel.getValueAt(i, 1).toString());
				txtCmnd.setText(tableModel.getValueAt(i, 2).toString());
				cbgioiTinh.setSelectedItem(tableModel.getValueAt(i, 3).toString());
				dcngaySinh.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 4).toString())));
				dcngayGiaNhap.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 5).toString())));
				txtdiaChi.setText(tableModel.getValueAt(i, 6).toString());
				txtEmail.setText(tableModel.getValueAt(i, 7).toString());
				txtsoDt.setText(tableModel.getValueAt(i, 8).toString());
				txtchuThich.setText(tableModel.getValueAt(i, 9).toString());
			}
		});
		
		//table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1522, 78);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 88, 497, 72);
		contentPane.add(lblNewLabel_1);
		try {
			loadKH();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		table.getColumnModel().getColumn(4).setPreferredWidth(74);
		
		
	} 
	//load
	private void loadKH() throws SQLException {
		dao_kh = new Dao_KhachHang();
		tableModel= dao_kh.getAllKH();
		table.setModel(tableModel);
	}
	private void update() {
		for(int i =0 ; i<table.getRowCount();i++) {
			if(txtmaKh.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString())) {
				table.setValueAt(txttenKh.getText(),i, 1);
				table.setValueAt(txtCmnd.getText(),i, 2);
				table.setValueAt(cbgioiTinh.getSelectedItem().toString(),i, 3);
				table.setValueAt(((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText(),i, 4);
				table.setValueAt(((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).getText().toString(),i, 5);
				table.setValueAt(txtdiaChi.getText(),i, 6);
				table.setValueAt(txtEmail.getText(),i, 7);
				table.setValueAt(txtsoDt.getText(),i, 8);
				table.setValueAt(txtchuThich.getText(),i, 9);
				
			}
		}
	}
	private void xoaKhachHang() throws SQLException{
		dao_kh = new Dao_KhachHang();
		dao_kh.xoaKH(txtmaKh.getText());
		//loadKH();
	}
	//Đếm số KhachHang
	private void timKhachHang() throws SQLException {
		dao_kh = new Dao_KhachHang();
		tableModel = dao_kh.timKiem("%"+txttimKiem.getText()+"%");
		table.setModel(tableModel);
		
	}
	
	public ArrayList<String> xetCMND() {
		cmnd = new ArrayList<String>();
		try {
			Connection con = ConnectDB.getInstance().getCon();
			String sql = "Select CMND from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String CMND;
				CMND = rs.getString(1);
				cmnd.add(CMND);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return cmnd;
	}
	public boolean CMND(String cmnd) {
		List<String> list = xetCMND();
		for(String i:list) {
			if(i.equalsIgnoreCase(cmnd))
				return true;
			
		}
		return false;
	}
	//validdata
	private boolean validData(){
		String makh = txtmaKh.getText().trim();
		String tenkh = txttenKh.getText().trim();
		String cmnd = txtCmnd.getText().trim();
		String diachi = txtdiaChi.getText().trim();
		String email = txtEmail.getText().trim();
		String sodt = txtsoDt.getText().trim();
		String ghichu = txtchuThich.getText().trim();
//		if(!(makh.length()>0 && makh.matches("[K][H][_]\\d{4}"))) {
//			JOptionPane.showMessageDialog(null, "Mã khách hàng không để trống và phải bắt đầu từ KH và theo sau là 4 số"  );
//			return false;
//		}
		if(!(tenkh.length()>0 && tenkh.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không để trống và không chứa ký tự số hoặc các ký tự đặc biệt" );
			return false;
		}
		if(!(cmnd.length()>0 && cmnd.matches("\\d{9}|\\d{12}") )) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân không để trống và phải có 9 chữ số và không được trùng " );
			return false;
		}
		if(!(diachi.length()>0 && diachi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s/\\\\.]+$"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ " );
			return false;
		}
//		if(!(email.length()>0 && email.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\r\n" + 
//				"			+ \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$"))) {
//			JOptionPane.showMessageDialog(null, "Email không hợp lệ " );
//			return false;
//		}
		if(!(sodt.length()>0 && sodt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được trống và phải có 10 số " );
			return false;
		}
		if(!( ghichu.length()>0 &&  ghichu.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Ghi chú không được trống và phải hợp lệ " );
			return false;
		}
		return true;
	}
}


