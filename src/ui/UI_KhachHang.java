package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 7, 2020
* @version: 1.0
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import com.toedter.calendar.JDayChooser;

import connect.ConnectDB;
import dao.Dao_KhachHang;
import entity.KhachHang;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UI_KhachHang extends JFrame {

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
	private JDateChooser dcngaySinh;
	private Dao_KhachHang dao_kh;
	private JTextField txtCmnd;
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
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin chi ti\u1EBFt ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel Title
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.LIGHT_GRAY);
		panelTitle.setBounds(0, 0, 1340, 40);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		//Panel LabelTitle
		JLabel lblTitle = new JLabel("Quản Lý Khách Hàng");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(29, 11, 294, 25);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		panelTitle.add(lblTitle);
		
		JPanel panelTimkiem = new JPanel();
		panelTimkiem.setBackground(new Color(230, 230, 250));
		panelTimkiem.setBounds(743, 53, 597, 53);
		contentPane.add(panelTimkiem);
		panelTimkiem.setLayout(null);
		

		JLabel lbltimKiem = new JLabel("Nhập mã khách hàng cần tìm\r\n");
		lbltimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltimKiem.setForeground(new Color(0, 0, 0));
		lbltimKiem.setBounds(36, 16, 190, 26);
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
		btntimKiem.setBackground(new Color(0, 255, 127));
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
		txttimKiem.setBounds(240, 20, 217, 20);
		panelTimkiem.add(txttimKiem);
		txttimKiem.setColumns(10);
		
		JPanel paneltenBang = new JPanel();
		paneltenBang.setBounds(0, 51, 575, 81);
		contentPane.add(paneltenBang);
		paneltenBang.setLayout(null);
		
		JLabel lbltenBang = new JLabel("BẢNG KHÁCH HÀNG");
		lbltenBang.setForeground(new Color(128, 128, 0));
		lbltenBang.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Generate-tables-icon.png")));
		lbltenBang.setHorizontalAlignment(SwingConstants.CENTER);
		lbltenBang.setFont(new Font("Leelawadee UI", Font.BOLD, 33));
		lbltenBang.setBounds(28, 11, 537, 59);
		paneltenBang.add(lbltenBang);
		
		JPanel panelthongTin = new JPanel();
		panelthongTin.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelthongTin.setBackground(new Color(60, 179, 113));
		panelthongTin.setBounds(23, 498, 864, 169);
		contentPane.add(panelthongTin);
		panelthongTin.setLayout(null);
		

		JLabel lbltenKh = new JLabel("Tên Khách Hàng");
		lbltenKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltenKh.setBounds(378, 27, 104, 19);
		panelthongTin.add(lbltenKh);



		JLabel lblgioiTinh = new JLabel("Giới Tính");
		lblgioiTinh.setBackground(new Color(255, 248, 220));
		lblgioiTinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblgioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblgioiTinh.setBounds(20, 56, 75, 19);
		panelthongTin.add(lblgioiTinh);



		JLabel lblngaySinh = new JLabel("Ngày Sinh");
		lblngaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblngaySinh.setBounds(20, 115, 75, 17);
		panelthongTin.add(lblngaySinh);



		JLabel lbldiaChi = new JLabel("Địa Chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldiaChi.setBounds(378, 57, 63, 19);
		panelthongTin.add(lbldiaChi);


		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(378, 86, 63, 17);
		panelthongTin.add(lblEmail);
		

		JLabel lblsoDt = new JLabel("Số Điện Thoại");
		lblsoDt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblsoDt.setBounds(20, 85, 88, 19);
		panelthongTin.add(lblsoDt);

		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 85, 88, 19);
		panelthongTin.add(lblNewLabel_5);

		
		


		JLabel lblchuThich = new JLabel("Chú Thích");
		lblchuThich.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblchuThich.setBounds(378, 114, 57, 19);
		panelthongTin.add(lblchuThich);

		
		txtmaKh = new JTextField();
		txtmaKh.setBounds(137, 26, 155, 20);
		panelthongTin.add(txtmaKh);
		txtmaKh.setColumns(10);
		
		txttenKh = new JTextField();
		txttenKh.setBounds(492, 26, 342, 20);
		panelthongTin.add(txttenKh);
		txttenKh.setColumns(10);
		

		JComboBox cbgioiTinh = new JComboBox();
		cbgioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbgioiTinh.setBounds(137, 55, 86, 20);
		panelthongTin.add(cbgioiTinh);

		
		txtdiaChi = new JTextField();
		txtdiaChi.setBounds(492, 55, 342, 20);
		panelthongTin.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(492, 84, 342, 20);
		panelthongTin.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtchuThich = new JTextField();
		txtchuThich.setForeground(Color.BLACK);
		txtchuThich.setBackground(new Color(255, 255, 255));
		txtchuThich.setBounds(492, 115, 342, 36);
		panelthongTin.add(txtchuThich);
		txtchuThich.setColumns(10);
		
		txtsoDt = new JTextField();
		txtsoDt.setBounds(137, 84, 155, 20);
		panelthongTin.add(txtsoDt);
		txtsoDt.setColumns(10);
		

		JLabel lblmaKh = new JLabel("Mã Khách Hàng");
		lblmaKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaKh.setBounds(20, 28, 107, 17);
		panelthongTin.add(lblmaKh);

		
		dcngaySinh = new JDateChooser();
		dcngaySinh.setBounds(137, 112, 155, 20);
		dcngaySinh.setDateFormatString("dd/MM/yyyy");
		panelthongTin.add(dcngaySinh);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCmnd.setBounds(20, 143, 46, 14);
		panelthongTin.add(lblCmnd);
		
		txtCmnd = new JTextField();
		txtCmnd.setBounds(137, 140, 155, 20);
		panelthongTin.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JPanel panelchucNang = new JPanel();
		panelchucNang.setBackground(Color.ORANGE);
		panelchucNang.setBounds(927, 498, 362, 169);
		contentPane.add(panelchucNang);
		panelchucNang.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 342, 45);
		panelchucNang.add(panel);
		panel.setLayout(null);
		

		JLabel lblchucNang = new JLabel("Chức Năng");
		lblchucNang.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Settings-icon.png")));
		lblchucNang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblchucNang.setBounds(88, 11, 173, 23);
		panel.add(lblchucNang);
		lblchucNang.setForeground(Color.BLACK);
		lblchucNang.setBackground(Color.GREEN);
		lblchucNang.setHorizontalAlignment(SwingConstants.CENTER);

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
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(201, 67, 135, 34);
		panelchucNang.add(btnXoa);
		
		btncapNhat = new JButton("Cập Nhật");
		btncapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
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
				    		String diachi = txtdiaChi.getText();
				    		String email = txtEmail.getText();
				    		String sodt = txtsoDt.getText();
				    		String ghiChu = txtchuThich.getText();
				    		KhachHang kh = new KhachHang(makH,tenkH,cmnd,gioiTinh,ngay,diachi,email,sodt,ghiChu);
				    		dao_kh.update(kh);
				    		loadKH();
				    		JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
				    		try {
				    			loadKH();
				    		}catch(Exception e2) {
				    			e2.printStackTrace();
				    		}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần cập nhật");
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btncapNhat.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-edit-icon.png")));
		btncapNhat.setBackground(new Color(72, 61, 139));
		btncapNhat.setBounds(38, 118, 135, 34);
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
				dcngaySinh.setCalendar(null);
				txtmaKh.requestFocus();
			}
		});
		
		btnlamMoi.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/refresh-icon.png")));
		btnlamMoi.setBackground(new Color(127, 255, 0));
		btnlamMoi.setBounds(201, 118, 135, 34);
		panelchucNang.add(btnlamMoi);
		
		dcngaySinh.setDateFormatString("yyy-MM-dd");
	    btnThem = new JButton("Thêm");
	    btnThem.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    	  try {
	    		String makH = txtmaKh.getText();
	    		String tenkH = txttenKh.getText();
	    		String cmnd = txtCmnd.getText();
	    		String gioiTinh = cbgioiTinh.getSelectedItem().toString();
	    		String date = ((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText();
	    		Date ngay = Date.valueOf(LocalDate.parse(date));
	    		String diachi = txtdiaChi.getText();
	    		String email = txtEmail.getText();
	    		String sodt = txtsoDt.getText();
	    		String ghiChu = txtchuThich.getText();
	    		KhachHang kh = new KhachHang(makH,tenkH,cmnd,gioiTinh,ngay,diachi,email,sodt,ghiChu);
	    		dao_kh.themKH(kh);
	    		JFrame f = new JFrame();
	    		loadKH();
	    		JOptionPane.showMessageDialog(f, "Thêm khách hàng thành công");
	    	  }catch(SQLException e) {
	    		  e.getMessage();
	    		  JOptionPane.showConfirmDialog(null, "Thêm không thành công");
	    	  }
	    	}
	    });
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(50, 205, 50));
		btnThem.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-add-icon.png")));
		btnThem.setBounds(38, 67, 135, 34);
		panelchucNang.add(btnThem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 156, 1303, 331);
		contentPane.add(scrollPane);
		String[] header = {
				"Mã Khách Hàng", "Tên Khách Hàng","CMND", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Email", "Số Điện Thoại","Chú Thích"
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
				txtdiaChi.setText(tableModel.getValueAt(i, 5).toString());
				txtEmail.setText(tableModel.getValueAt(i, 6).toString());
				txtsoDt.setText(tableModel.getValueAt(i, 7).toString());
				txtchuThich.setText(tableModel.getValueAt(i, 8).toString());
			}
		});
		
		//table = new JTable();
		scrollPane.setViewportView(table);
		try {
			loadKH();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		table.getColumnModel().getColumn(4).setPreferredWidth(74);
		
//		btnThem.addActionListener(this);
//		btnXoa.addActionListener(this);
//		btncapNhat.addActionListener(this);
//		btntimKiem.addActionListener(this);
//		btnlamMoi.addActionListener(this);
		
	} 
	//load
	private void loadKH() throws SQLException {
		dao_kh = new Dao_KhachHang();
		tableModel= dao_kh.getAllKH();
		table.setModel(tableModel);
		
	}
	private void xoaKhachHang() throws SQLException{
		dao_kh = new Dao_KhachHang();
		dao_kh.xoaKH(txtmaKh.getText());
		loadKH();
	}
	//Đếm số KhachHang
	private void timKhachHang() throws SQLException {
		dao_kh = new Dao_KhachHang();
		tableModel = dao_kh.timKiem("%"+txttimKiem.getText()+"%");
		table.setModel(tableModel);
		
	}
}


