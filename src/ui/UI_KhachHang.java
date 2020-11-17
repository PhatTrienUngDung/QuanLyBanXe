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
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class UI_KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtmaKh;
	private JTextField txttenKh;
	private JTextField txtdiaChi;
	private JTextField txtEmail;
	private JTextField txtchuThich;
	private JTextField txtsoDt;
	private JTable table;
	private JTextField txttimKiem;

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
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, screen.height);
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
		JLabel lblTitle = new JLabel("Quáº£n LÃ½ KhÃ¡ch HÃ ng");
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

		JLabel lblNewLabel = new JLabel("Nhập mã khách hàng cần tìm\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(36, 16, 190, 26);
		panelTimkiem.add(lblNewLabel);

		JLabel lblNewLabel = new JLabel("Nháº­p mÃ£ khÃ¡ch hÃ ng cáº§n tÃ¬m\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(36, 16, 190, 26);
		panelTimkiem.add(lblNewLabel);

		
		JButton btnTmKiem = new JButton("TÃ¬m Kiáº¿m");
		btnTmKiem.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/search1.png")));
		btnTmKiem.setBackground(new Color(0, 255, 127));
		btnTmKiem.setForeground(new Color(0, 0, 0));
		btnTmKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTmKiem.setBounds(478, 17, 109, 23);
		panelTimkiem.add(btnTmKiem);
		
		txttimKiem = new JTextField();
		txttimKiem.setBounds(240, 20, 217, 20);
		panelTimkiem.add(txttimKiem);
		txttimKiem.setColumns(10);
		
		JPanel paneltenBang = new JPanel();
		paneltenBang.setBounds(0, 51, 575, 81);
		contentPane.add(paneltenBang);
		paneltenBang.setLayout(null);
		
		JLabel lbltenBang = new JLabel("Báº¢NG KHÃ�CH HÃ€NG");
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
		

		JLabel lbltenKh = new JLabel("Tên Khách Hàng");
		lbltenKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltenKh.setBounds(315, 27, 104, 19);
		panelthongTin.add(lbltenKh);

		JLabel lblTnKhchHang = new JLabel("Tên Khách Hàng");
		lblTnKhchHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKhchHang.setBounds(315, 27, 104, 19);
		panelthongTin.add(lblTnKhchHang);

		JLabel lblTnKhchHang = new JLabel("TÃªn KhÃ¡ch HÃ ng");
		lblTnKhchHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKhchHang.setBounds(315, 27, 104, 19);
		panelthongTin.add(lblTnKhchHang);

		JLabel lblgioiTinh = new JLabel("Giới Tính");
		lblgioiTinh.setBackground(new Color(255, 248, 220));
		lblgioiTinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblgioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblgioiTinh.setBounds(20, 56, 75, 19);
		panelthongTin.add(lblgioiTinh);

		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setBackground(new Color(255, 248, 220));
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGiiTnh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiiTnh.setBounds(20, 56, 75, 19);
		panelthongTin.add(lblGiiTnh);

		JLabel lblGiiTnh = new JLabel("Giá»›i TÃ­nh");
		lblGiiTnh.setBackground(new Color(255, 248, 220));
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGiiTnh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiiTnh.setBounds(20, 56, 75, 19);
		panelthongTin.add(lblGiiTnh);

		JLabel lblngaySinh = new JLabel("Ngày Sinh");
		lblngaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblngaySinh.setBounds(20, 115, 75, 17);
		panelthongTin.add(lblngaySinh);

		JLabel lblNewLabel_3 = new JLabel("Ngày Sinh");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 115, 75, 17);
		panelthongTin.add(lblNewLabel_3);

		JLabel lblNewLabel_3 = new JLabel("NgÃ y Sinh");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 115, 75, 17);
		panelthongTin.add(lblNewLabel_3);

		JLabel lbldiaChi = new JLabel("Địa Chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldiaChi.setBounds(315, 56, 63, 19);
		panelthongTin.add(lbldiaChi);
||||||| .r33
		JLabel lblNewLabel_4 = new JLabel("Địa Chỉ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(315, 65, 63, 19);
		panelthongTin.add(lblNewLabel_4);
=======
		JLabel lblNewLabel_4 = new JLabel("Ä�á»‹a Chá»‰");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(315, 65, 63, 19);
		panelthongTin.add(lblNewLabel_4);
>>>>>>> .r45
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(315, 86, 63, 17);
		panelthongTin.add(lblEmail);
		
<<<<<<< .mine
		JLabel lblsoDt = new JLabel("Số Điện Thoại");
		lblsoDt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblsoDt.setBounds(20, 85, 88, 19);
		panelthongTin.add(lblsoDt);
||||||| .r33
		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 85, 88, 19);
		panelthongTin.add(lblNewLabel_5);
=======
		JLabel lblNewLabel_5 = new JLabel("Sá»‘ Ä�iá»‡n Thoáº¡i");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 85, 88, 19);
		panelthongTin.add(lblNewLabel_5);
>>>>>>> .r45
		
<<<<<<< .mine
		JLabel lblchuThich = new JLabel("Chú Thích");
		lblchuThich.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblchuThich.setBounds(315, 114, 57, 19);
		panelthongTin.add(lblchuThich);
||||||| .r33
		JLabel lblChThch = new JLabel("Chú Thích");
		lblChThch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChThch.setBounds(315, 123, 57, 19);
		panelthongTin.add(lblChThch);
=======
		JLabel lblChThch = new JLabel("ChÃº ThÃ­ch");
		lblChThch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChThch.setBounds(315, 123, 57, 19);
		panelthongTin.add(lblChThch);
>>>>>>> .r45
		
		txtmaKh = new JTextField();
		txtmaKh.setBounds(137, 26, 155, 20);
		panelthongTin.add(txtmaKh);
		txtmaKh.setColumns(10);
		
		txttenKh = new JTextField();
		txttenKh.setBounds(422, 26, 342, 20);
		panelthongTin.add(txttenKh);
		txttenKh.setColumns(10);
		
<<<<<<< .mine
		JComboBox cbgioiTinh = new JComboBox();
		cbgioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbgioiTinh.setBounds(137, 55, 86, 20);
		panelthongTin.add(cbgioiTinh);
||||||| .r33
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(137, 55, 86, 20);
		panelthongTin.add(comboBox);
=======
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Ná»¯"}));
		comboBox.setBounds(137, 55, 86, 20);
		panelthongTin.add(comboBox);
>>>>>>> .r45
		
		txtdiaChi = new JTextField();
		txtdiaChi.setBounds(422, 55, 342, 20);
		panelthongTin.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(422, 84, 342, 20);
		panelthongTin.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtchuThich = new JTextField();
		txtchuThich.setForeground(Color.LIGHT_GRAY);
		txtchuThich.setBackground(new Color(192, 192, 192));
		txtchuThich.setBounds(422, 115, 342, 36);
		panelthongTin.add(txtchuThich);
		txtchuThich.setColumns(10);
		
		txtsoDt = new JTextField();
		txtsoDt.setBounds(137, 84, 155, 20);
		panelthongTin.add(txtsoDt);
		txtsoDt.setColumns(10);
		
<<<<<<< .mine
		JLabel lblmaKh = new JLabel("Mã Khách Hàng");
		lblmaKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaKh.setBounds(20, 28, 107, 17);
		panelthongTin.add(lblmaKh);
||||||| .r33
		JLabel lblMKhchHng = new JLabel("Mã Khách Hàng");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMKhchHng.setBounds(20, 28, 107, 17);
		panelthongTin.add(lblMKhchHng);
=======
		JLabel lblMKhchHng = new JLabel("MÃ£ KhÃ¡ch HÃ ng");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMKhchHng.setBounds(20, 28, 107, 17);
		panelthongTin.add(lblMKhchHng);
>>>>>>> .r45
		
		JDateChooser dcngaySinh = new JDateChooser();
		dcngaySinh.setBounds(137, 115, 155, 20);
		panelthongTin.add(dcngaySinh);
		
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
		
<<<<<<< .mine
		JLabel lblchucNang = new JLabel("Chức Năng");
		lblchucNang.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Settings-icon.png")));
		lblchucNang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblchucNang.setBounds(88, 11, 173, 23);
		panel.add(lblchucNang);
		lblchucNang.setForeground(Color.BLACK);
		lblchucNang.setBackground(Color.GREEN);
		lblchucNang.setHorizontalAlignment(SwingConstants.CENTER);
||||||| .r33
		JLabel lblNewLabel_1 = new JLabel("Chức Năng");
		lblNewLabel_1.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Settings-icon.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(88, 11, 173, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
=======
		JLabel lblNewLabel_1 = new JLabel("Chá»©c NÄƒng");
		lblNewLabel_1.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Settings-icon.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(88, 11, 173, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
>>>>>>> .r45
		
		JButton btnXoa = new JButton("XÃ³a");
		btnXoa.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Delete-group-icon.png")));
		btnXoa.setBackground(new Color(255, 228, 196));
		btnXoa.setBounds(201, 67, 135, 34);
		panelchucNang.add(btnXoa);
		
		JButton btncapNhat = new JButton("Cáº­p Nháº­t");
		btncapNhat.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-edit-icon.png")));
		btncapNhat.setBackground(new Color(255, 228, 196));
		btncapNhat.setBounds(38, 118, 135, 34);
		panelchucNang.add(btncapNhat);
		
		JButton btnlamMoi = new JButton("LÃ m Má»›i");
		btnlamMoi.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/refresh-icon.png")));
		btnlamMoi.setBackground(new Color(255, 228, 181));
		btnlamMoi.setBounds(201, 118, 135, 34);
		panelchucNang.add(btnlamMoi);
		
<<<<<<< .mine
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(255, 228, 196));
		btnThem.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-add-icon.png")));
		btnThem.setBounds(38, 67, 135, 34);
		panelchucNang.add(btnThem);
||||||| .r33
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-add-icon.png")));
		btnNewButton.setBounds(38, 67, 135, 34);
		panelchucNang.add(btnNewButton);
=======
		JButton btnNewButton = new JButton("ThÃªm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-add-icon.png")));
		btnNewButton.setBounds(38, 67, 135, 34);
		panelchucNang.add(btnNewButton);
>>>>>>> .r45
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 156, 1303, 331);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
<<<<<<< .mine
			 "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "\u0110\u1ECBa Ch\u1EC9", "Email", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "Ch\u00FA Th\u00EDch"
||||||| .r33
				"STT","Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Email", "Số Điện Thoại","Chú Thích"
=======
				"STT","MÃ£ KhÃ¡ch HÃ ng", "TÃªn KhÃ¡ch HÃ ng", "Giá»›i TÃ­nh", "NgÃ y Sinh", "Ä�á»‹a Chá»‰", "Email", "Sá»‘ Ä�iá»‡n Thoáº¡i","ChÃº ThÃ­ch"
>>>>>>> .r45
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		table.getColumnModel().getColumn(4).setPreferredWidth(74);
	}
}


