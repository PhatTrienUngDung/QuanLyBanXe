package GD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;

public class GD_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_NhanVien frame = new GD_NhanVien();
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
	public GD_NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1313, 743);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1279, 686);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(10, 10, 712, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQunLNhn = new JLabel("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLNhn.setBounds(10, 10, 201, 30);
		panel_1.add(lblQunLNhn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 378, 1259, 298);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1216, 257);
		panel_2.add(scrollPane);
		
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
			},
			new String[] {
				"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới sinh", "Email", "Số điện thoại", "Địa chỉ", "Chức vụ", "Ngày vào làm"
			}
		));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(732, 70, 537, 268);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_4.setBounds(10, 115, 517, 143);
		panel_5.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(59, 33, 104, 21);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(59, 97, 104, 21);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sửa");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(364, 33, 104, 21);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(364, 97, 104, 21);
		panel_4.add(btnNewButton_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(230, 230, 250));
		panel_7.setBounds(10, 11, 517, 94);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblChcNng_1 = new JLabel("Chức năng");
		lblChcNng_1.setBounds(217, 33, 100, 17);
		lblChcNng_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_7.add(lblChcNng_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 70, 712, 268);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(224, 255, 255));
		panel_6.setBounds(10, 10, 692, 25);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblThngTinNhn = new JLabel("Thông tin nhân viên");
		lblThngTinNhn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngTinNhn.setBounds(10, 10, 161, 13);
		panel_6.add(lblThngTinNhn);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(230, 230, 250));
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(10, 45, 692, 198);
		panel_3.add(panel_3_1);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 100, 13);
		panel_3_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 64, 100, 13);
		panel_3_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày Sinh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 121, 88, 26);
		panel_3_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(245, 10, 59, 13);
		panel_3_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(245, 64, 46, 13);
		panel_3_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(245, 128, 90, 13);
		panel_3_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Địa chỉ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(472, 10, 46, 13);
		panel_3_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Chức vụ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(472, 64, 83, 18);
		panel_3_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày vào làm");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(472, 121, 96, 26);
		panel_3_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 9, 96, 19);
		panel_3_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 61, 96, 19);
		panel_3_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 127, 96, 19);
		panel_3_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(345, 63, 96, 19);
		panel_3_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(345, 127, 96, 19);
		panel_3_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(588, 9, 96, 19);
		panel_3_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(588, 63, 96, 19);
		panel_3_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(588, 118, 96, 19);
		panel_3_1.add(textField_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(345, 8, 96, 21);
		panel_3_1.add(comboBox);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 240, 245));
		panel_8.setBounds(732, 10, 522, 50);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNhpThngTin = new JLabel("Nhập thông tin nhân viên cần tìm");
		lblNhpThngTin.setBackground(new Color(255, 228, 225));
		lblNhpThngTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhpThngTin.setBounds(10, 10, 221, 30);
		panel_8.add(lblNhpThngTin);
		
		textField_8 = new JTextField();
		textField_8.setBounds(244, 18, 122, 19);
		panel_8.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBounds(406, 17, 106, 21);
		panel_8.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("");
		
		lblNewLabel_9.setBounds(390, 21, 46, 13);
		panel_8.add(lblNewLabel_9);
	}
}
