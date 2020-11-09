package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI_HopDong extends JFrame {

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
		setBounds(100, 100, 1312, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(10, 10, 1279, 683);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		
		JLabel lblQLHD = new JLabel("Quản lý hợp đồng");
		lblQLHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQLHD.setBackground(new Color(255, 69, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 224));
		
		JLabel lblNhapHD = new JLabel("Nhập mã hợp đồng");
		lblNhapHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbLNhapHD.setBackground(Color.RED);
		
		
		
		JButton btntimKiem = new JButton("Tìm kiếm");
		btntimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 215, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 235, 205));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBackground(Color.WHITE);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblChucNang = new JLabel("Chức năng");
		lblChucNang.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(250, 250, 210));
		panel_7.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 37, 634, 183);
		panel_7.add(panel_3);
		panel_3.setBackground(new Color(255, 228, 181));
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
		
		
		
		JLabel lblTTHD = new JLabel("Thông tin hợp đồng");
		lblTTHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTTHD.setBounds(63, 10, 185, 24);
		panel_7.add(lblTTHD);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBackground(new Color(255, 248, 220));
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1239, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 667, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(21))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
					.addGap(40)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhapHD, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addComponent(btntimKiem)
					.addGap(90))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhapHD, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btntimKiem, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(78, Short.MAX_VALUE)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
							.addGap(60))
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addComponent(lblChucNang, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(188))))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(24)
					.addComponent(lblChucNang, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(103)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(103)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
		);
		panel_4.setLayout(gl_panel_4);
		panel_6.setLayout(gl_panel_6);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(562, Short.MAX_VALUE)
					.addComponent(lblQLHD, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(532))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblQLHD, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
	}
}


