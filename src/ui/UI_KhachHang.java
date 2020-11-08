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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
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
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class UI_KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(UI_KhachHang.class.getResource("/image/customer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 5, 1267, 730);
		contentPane = new JPanel();
		
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin chi ti\u1EBFt ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel Title
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.LIGHT_GRAY);
		panelTitle.setBounds(0, 0, 1267, 40);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		//Panel LabelTitle
		JLabel lblTitle = new JLabel("Quản Lý Khách Hàng");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(29, 11, 600, 25);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		panelTitle.add(lblTitle);
		
		JPanel panelTimkiem = new JPanel();
		panelTimkiem.setBackground(new Color(230, 230, 250));
		panelTimkiem.setBounds(654, 51, 597, 53);
		contentPane.add(panelTimkiem);
		panelTimkiem.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mã khách hàng cần tìm\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(36, 16, 190, 26);
		panelTimkiem.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 18, 190, 22);
		panelTimkiem.add(textArea);
		
		JButton btnTmKiem = new JButton("Tìm Kiếm");
		btnTmKiem.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/search1.png")));
		btnTmKiem.setBackground(new Color(0, 255, 127));
		btnTmKiem.setForeground(new Color(0, 0, 0));
		btnTmKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTmKiem.setBounds(478, 17, 109, 23);
		panelTimkiem.add(btnTmKiem);
		
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
		panelthongTin.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelthongTin.setBackground(new Color(60, 179, 113));
		panelthongTin.setBounds(23, 498, 774, 169);
		contentPane.add(panelthongTin);
		panelthongTin.setLayout(null);
		
		JLabel lblTnKhchHang = new JLabel("Tên Khách Hàng");
		lblTnKhchHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKhchHang.setBounds(315, 27, 104, 19);
		panelthongTin.add(lblTnKhchHang);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setBackground(new Color(255, 248, 220));
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGiiTnh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiiTnh.setBounds(20, 56, 75, 19);
		panelthongTin.add(lblGiiTnh);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày Sinh");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 115, 75, 17);
		panelthongTin.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa Chỉ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(315, 65, 63, 19);
		panelthongTin.add(lblNewLabel_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(315, 95, 63, 17);
		panelthongTin.add(lblEmail);
		
		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 85, 88, 19);
		panelthongTin.add(lblNewLabel_5);
		
		JLabel lblChThch = new JLabel("Chú Thích");
		lblChThch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChThch.setBounds(315, 123, 57, 19);
		panelthongTin.add(lblChThch);
		
		textField = new JTextField();
		textField.setBounds(137, 26, 155, 20);
		panelthongTin.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(422, 26, 342, 20);
		panelthongTin.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(137, 55, 86, 20);
		panelthongTin.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(422, 64, 342, 20);
		panelthongTin.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(422, 93, 342, 20);
		panelthongTin.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setBackground(new Color(192, 192, 192));
		textField_4.setBounds(422, 122, 342, 36);
		panelthongTin.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(137, 84, 155, 20);
		panelthongTin.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMKhchHng = new JLabel("Mã Khách Hàng");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMKhchHng.setBounds(20, 28, 107, 17);
		panelthongTin.add(lblMKhchHng);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(137, 115, 155, 20);
		panelthongTin.add(dateChooser);
		
		JPanel panelchucNang = new JPanel();
		panelchucNang.setBackground(Color.ORANGE);
		panelchucNang.setBounds(853, 498, 362, 169);
		contentPane.add(panelchucNang);
		panelchucNang.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 342, 45);
		panelchucNang.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chức Năng");
		lblNewLabel_1.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Settings-icon.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(88, 11, 173, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Delete-group-icon.png")));
		btnXoa.setBackground(new Color(255, 228, 196));
		btnXoa.setBounds(201, 67, 135, 34);
		panelchucNang.add(btnXoa);
		
		JButton btncapNhat = new JButton("Cập Nhật");
		btncapNhat.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-edit-icon.png")));
		btncapNhat.setBackground(new Color(255, 228, 196));
		btncapNhat.setBounds(38, 118, 135, 34);
		panelchucNang.add(btncapNhat);
		
		JButton btnlamMoi = new JButton("Làm Mới");
		btnlamMoi.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/refresh-icon.png")));
		btnlamMoi.setBackground(new Color(255, 228, 181));
		btnlamMoi.setBounds(201, 118, 135, 34);
		panelchucNang.add(btnlamMoi);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-add-icon.png")));
		btnNewButton.setBounds(38, 67, 135, 34);
		panelchucNang.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 143, 1251, 331);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				
			},
			new String[] {
				"STT","Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Email", "Số Điện Thoại","Chú Thích"
			}
		));
	}
}


