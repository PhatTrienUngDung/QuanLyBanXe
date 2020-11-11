package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI_HopDong extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtmaHD;
	private JTextField txtmaKH;
	private JTextField txttenKH;
	private JTextField txtmaNV;
	private JTextField txttenNV;
	private JTextField txtmaXe;
	private JTextField txttenXe;
	private JTextField txtngayLap;
	private JTextField txtchuThich;
	private JTextField txttimKiem;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_HopDong frame = new UI_HopDong();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setBounds(0, 0, 1900, screen.height);
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
	public UI_HopDong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1314, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 10, 1279, 683);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 1269, 50);
		panel_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblQLHD = new JLabel("Quản lý hợp đồng");
		lblQLHD.setBounds(529, 10, 189, 35);
		lblQLHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQLHD.setBackground(Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 340, 571, 50);
		panel_5.setBackground(new Color(255, 255, 224));
		
		JLabel lblNhapHD = new JLabel("Nhập mã hợp đồng");
		lblNhapHD.setBounds(10, 13, 147, 26);
		lblNhapHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhapHD.setBackground(Color.RED);
		
		
		
		JButton btntimKiem = new JButton("Tìm kiếm");
		btntimKiem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/search1.png")));
		btntimKiem.setBounds(390, 9, 120, 34);
		btntimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(687, 71, 571, 229);
		panel_6.setBackground(new Color(255, 215, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 64, 571, 165);
		
		panel_4.setBackground(new Color(244, 164, 96));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Button-Add-icon.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/delete-icon.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Settings-icon.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/refresh-icon.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblChucNang = new JLabel("Chức năng");
		lblChucNang.setBounds(252, 24, 131, 13);
		lblChucNang.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 70, 667, 41);
		panel_7.setBackground(new Color(255, 215, 0));
		panel_7.setLayout(null);
		
		
		
		JLabel lblTTHD = new JLabel("Thông tin hợp đồng");
		lblTTHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTTHD.setBounds(63, 10, 185, 24);
		panel_7.add(lblTTHD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 448, 1239, 235);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
			},
			new String[] {
				"M\u00E3 H\u1EE3p \u0110\u1ED3ng", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "M\u00E3 Xe", "T\u00EAn xe", "Ng\u00E0y L\u1EADp"
			}
		));
		
		textField = new JTextField();
		textField.setBounds(175, 19, 148, 19);
		textField.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
					.addGap(156)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addGap(83))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThem)
						.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		panel_4.setLayout(gl_panel_4);
		panel.setLayout(null);
		panel.add(panel_5);
		panel_5.setLayout(null);
		panel_5.add(lblNhapHD);
		panel_5.add(textField);
		panel_5.add(btntimKiem);
		panel.add(scrollPane);
		panel.add(panel_7);
		panel.add(panel_6);
		panel_6.setLayout(null);
		panel_6.add(panel_4);
		panel_6.add(lblChucNang);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblQLHD);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 107, 667, 193);
		panel.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		
		JLabel lblmaHD = new JLabel("Mã hợp đồng");
		lblmaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaHD.setBounds(24, 10, 96, 24);
		panel_3.add(lblmaHD);
		
		txtmaHD = new JTextField();
		txtmaHD.setBounds(130, 15, 96, 19);
		panel_3.add(txtmaHD);
		txtmaHD.setColumns(10);
		
		
		
		JLabel 	lblmaKH = new JLabel("Mã khách hàng");
		lblmaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaKH.setBounds(24, 83, 96, 13);
		panel_3.add(lblmaKH);
		
		txtmaKH = new JTextField();
		txtmaKH.setBounds(130, 45, 96, 19);
		panel_3.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		JLabel lbltenKH = new JLabel("Tên khách hàng");
		lbltenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltenKH.setBounds(24, 46, 109, 13);
		panel_3.add(lbltenKH);
		
		txttenKH = new JTextField();
		txttenKH.setBounds(130, 82, 96, 19);
		panel_3.add(txttenKH);
		txttenKH.setColumns(10);
		
		JLabel lblmaNV = new JLabel("Mã nhân viên");
		lblmaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaNV.setBounds(24, 120, 96, 13);
		panel_3.add(lblmaNV);
		
		txtmaNV = new JTextField();
		txtmaNV.setBounds(130, 119, 96, 19);
		panel_3.add(txtmaNV);
		txtmaNV.setColumns(10);
		
		JLabel lbltenNV = new JLabel("Tên nhân viên");
		lbltenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltenNV.setBounds(24, 156, 96, 13);
		panel_3.add(lbltenNV);
		
		txttenNV = new JTextField();
		txttenNV.setBounds(130, 155, 96, 19);
		panel_3.add(txttenNV);
		txttenNV.setColumns(10);
		
		JLabel lblmaXe = new JLabel("Mã xe");
		lblmaXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaXe.setBounds(394, 16, 73, 13);
		panel_3.add(lblmaXe);
		
		txtmaXe = new JTextField();
		txtmaXe.setBounds(474, 15, 96, 19);
		panel_3.add(txtmaXe);
		txtmaXe.setColumns(10);
		
		JLabel lbltenXe = new JLabel("Tên xe");
		lbltenXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltenXe.setBounds(394, 46, 73, 13);
		panel_3.add(lbltenXe);
		
		txttenXe = new JTextField();
		txttenXe.setBounds(474, 45, 96, 19);
		panel_3.add(txttenXe);
		txttenXe.setColumns(10);
		
		JLabel lblngayLap = new JLabel("Ngày lập");
		lblngayLap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblngayLap.setBounds(394, 72, 84, 35);
		panel_3.add(lblngayLap);
		
		txtngayLap = new JTextField();
		txtngayLap.setBounds(474, 82, 96, 19);
		panel_3.add(txtngayLap);
		txtngayLap.setColumns(10);
		
		JLabel lblChuThich = new JLabel("Chú thích");
		lblChuThich.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChuThich.setBounds(394, 133, 73, 13);
		panel_3.add(lblChuThich);
		
		
		
		txtchuThich= new JTextField();
		txtchuThich.setBounds(474, 132, 96, 19);
		panel_3.add(txtchuThich);
		txtchuThich.setColumns(10);
		
	}
}


