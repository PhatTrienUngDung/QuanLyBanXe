package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 8, 2020
* @version: 1.0
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class UI_PhieuNhap extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
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

	/**
	 * Create the frame.
	 */
	public UI_PhieuNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 5, 1267, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1267, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Phiếu Nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(29, 11, 600, 25);
		panel.add(lblNewLabel);
		
		JPanel panelNhap = new JPanel();
		panelNhap.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin Chi Ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelNhap.setBackground(new Color(144, 238, 144));
		panelNhap.setBounds(0, 51, 785, 190);
		contentPane.add(panelNhap);
		panelNhap.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu Nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 16, 87, 14);
		panelNhap.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(128, 11, 276, 20);
		panelNhap.add(textField);
		textField.setColumns(10);
		
		JLabel lblNhCungCp = new JLabel("Mã Cung Cấp");
		lblNhCungCp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNhCungCp.setBounds(31, 47, 78, 14);
		panelNhap.add(lblNhCungCp);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 44, 276, 20);
		panelNhap.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNgiNhp = new JLabel("Tên Nhà CC");
		lblNgiNhp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgiNhp.setBounds(31, 76, 87, 20);
		panelNhap.add(lblNgiNhp);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 76, 276, 20);
		panelNhap.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNgyNhp = new JLabel("Ngày Nhập");
		lblNgyNhp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgyNhp.setBounds(31, 117, 71, 14);
		panelNhap.add(lblNgyNhp);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(128, 111, 185, 20);
		panelNhap.add(dateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("Chú Thích");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(31, 153, 71, 14);
		panelNhap.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(128, 150, 276, 29);
		panelNhap.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMXe = new JLabel("Mã Xe");
		lblMXe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMXe.setBounds(447, 11, 46, 14);
		panelNhap.add(lblMXe);
		
		textField_4 = new JTextField();
		textField_4.setBounds(531, 8, 244, 20);
		panelNhap.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTnXe = new JLabel("Tên Xe");
		lblTnXe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnXe.setBounds(447, 47, 46, 14);
		panelNhap.add(lblTnXe);
		
		textField_5 = new JTextField();
		textField_5.setBounds(531, 44, 244, 20);
		panelNhap.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNgiNhp_1 = new JLabel("Người Nhập");
		lblNgiNhp_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgiNhp_1.setBounds(447, 79, 74, 14);
		panelNhap.add(lblNgiNhp_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(531, 76, 244, 20);
		panelNhap.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_Tien = new JPanel();
		panel_Tien.setBorder(new TitledBorder(null, "Th\u00E0nh Ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_Tien.setBackground(new Color(135, 206, 250));
		panel_Tien.setBounds(808, 51, 433, 190);
		contentPane.add(panel_Tien);
		panel_Tien.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Số Lượng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 22, 69, 19);
		panel_Tien.add(lblNewLabel_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(78, 21, 79, 20);
		panel_Tien.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Đơn Giá");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 52, 46, 14);
		panel_Tien.add(lblNewLabel_4);
		
		textField_8 = new JTextField();
		textField_8.setBounds(78, 49, 137, 20);
		panel_Tien.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblVat = new JLabel("%VAT");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVat.setBounds(10, 86, 46, 14);
		panel_Tien.add(lblVat);
		
		textField_9 = new JTextField();
		textField_9.setBounds(78, 83, 79, 20);
		panel_Tien.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("Tổng Tiền");
		btnNewButton.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Money-icon.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setBounds(78, 127, 137, 39);
		panel_Tien.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tiền Thuế");
		btnNewButton_1.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Percent-icon.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(250, 128, 114));
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(251, 127, 143, 39);
		panel_Tien.add(btnNewButton_1);
		
		textField_10 = new JTextField();
		textField_10.setBackground(SystemColor.inactiveCaption);
		textField_10.setBounds(301, 10, 122, 20);
		panel_Tien.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(SystemColor.inactiveCaption);
		textField_11.setBounds(301, 49, 122, 20);
		panel_Tien.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblThnhTin = new JLabel("Thành Tiền");
		lblThnhTin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThnhTin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThnhTin.setBounds(222, 13, 69, 14);
		panel_Tien.add(lblThnhTin);
		
		JLabel lblThu = new JLabel("Tiền Thuế");
		lblThu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThu.setBounds(232, 52, 59, 14);
		panel_Tien.add(lblThu);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(Color.WHITE);
		panelTable.setBounds(0, 252, 1251, 372);
		contentPane.add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1231, 350);
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
				"STT", "Mã Phiếu", "Tên Xe", "Người Nhập", "Tên Xe", "Số Lượng", "Đơn Giá","Thuế","Thành Tiền"
			}
		));
		
		JPanel panelchucNang = new JPanel();
		panelchucNang.setBackground(new Color(255, 165, 0));
		panelchucNang.setBounds(634, 635, 631, 45);
		contentPane.add(panelchucNang);
		panelchucNang.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Button-Add-icon.png")));
		btnNewButton_2.setBackground(new Color(255, 222, 173));
		btnNewButton_2.setBounds(36, 5, 119, 34);
		panelchucNang.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Xóa");
		btnNewButton_3.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/delete-icon.png")));
		btnNewButton_3.setBackground(new Color(255, 222, 173));
		btnNewButton_3.setBounds(192, 5, 112, 34);
		panelchucNang.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cập Nhật");
		btnNewButton_4.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Other-Update-Metro-icon.png")));
		btnNewButton_4.setBackground(new Color(255, 222, 173));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(327, 5, 127, 34);
		panelchucNang.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Làm Mới");
		btnNewButton_5.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Actions-view-refresh-icon.png")));
		btnNewButton_5.setBackground(new Color(255, 222, 173));
		btnNewButton_5.setBounds(485, 5, 112, 34);
		panelchucNang.add(btnNewButton_5);
		
		JPanel paneltimKiem = new JPanel();
		paneltimKiem.setBackground(new Color(169, 169, 169));
		paneltimKiem.setBounds(10, 635, 547, 45);
		contentPane.add(paneltimKiem);
		paneltimKiem.setLayout(null);
		
		JLabel lblNhpMPhiu = new JLabel("Nhập mã phiếu cần tìm");
		lblNhpMPhiu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhpMPhiu.setBounds(10, 14, 159, 14);
		paneltimKiem.add(lblNhpMPhiu);
		
		textField_12 = new JTextField();
		textField_12.setBounds(188, 9, 211, 25);
		paneltimKiem.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.setBackground(new Color(255, 255, 0));
		btnTm.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/search1.png")));
		btnTm.setBounds(430, 8, 107, 26);
		paneltimKiem.add(btnTm);
//		
//		JPanel panelTitle = new JPanel();
//		panelTitle.setBackground(Color.LIGHT_GRAY);
//		panelTitle.setBounds(0, 0, 50, 40);
//		contentPane.add(panelTitle);
//		panelTitle.setLayout(null);
//		
//		//Panel LabelTitle
//		JLabel lblTitle = new JLabel("Quản Lý Khách Hàng");
//		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
//		lblTitle.setBounds(29, 11, 600, 25);
//		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
//		panelTitle.add(lblTitle);
	}
}


