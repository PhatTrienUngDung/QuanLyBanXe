package GD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class GD_HopDong extends JFrame {

	
	
	
	

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
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_HopDong frame = new GD_HopDong();
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
	public GD_HopDong() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(10, 10, 1279, 683);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBounds(10, 10, 667, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQunLHp = new JLabel("Quản lý hợp đồng");
		lblQunLHp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQunLHp.setBackground(new Color(255, 69, 0));
		lblQunLHp.setBounds(10, 5, 659, 35);
		panel_1.add(lblQunLHp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 482, 1259, 191);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1239, 263);
		panel_2.add(scrollPane);
		
		table = new JTable();
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
			},
			new String[] {
				"M\u00E3 H\u1EE3p \u0110\u1ED3ng", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "M\u00E3 Xe", "T\u00EAn xe", "Ng\u00E0y L\u1EADp"
			}
		));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 250, 240));
		panel_5.setBounds(687, 10, 571, 50);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mã hợp đồng ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(10, 10, 147, 26);
		panel_5.add(lblNewLabel);
		
		textField_8 = new JTextField();
		textField_8.setBounds(178, 16, 171, 19);
		panel_5.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(388, 13, 91, 21);
		panel_5.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 215, 0));
		panel_6.setBounds(687, 71, 571, 229);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(77, 58, 433, 133);
		panel_6.add(panel_4);
		panel_4.setBackground(new Color(255, 235, 205));
		panel_4.setLayout(null);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThm.setBackground(Color.WHITE);
		btnThm.setBounds(74, 27, 100, 21);
		panel_4.add(btnThm);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXa.setBounds(74, 86, 100, 21);
		panel_4.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSa.setBounds(277, 27, 100, 21);
		panel_4.add(btnSa);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(277, 86, 100, 21);
		panel_4.add(btnNewButton_1);
		
		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChcNng.setBounds(253, 23, 131, 13);
		panel_6.add(lblChcNng);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(238, 232, 170));
		panel_7.setBounds(10, 70, 667, 230);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 37, 634, 183);
		panel_7.add(panel_3);
		panel_3.setBackground(new Color(255, 228, 181));
		panel_3.setLayout(null);
		
		JLabel lblMHpng = new JLabel("Mã hợp đồng");
		lblMHpng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHpng.setBounds(24, 26, 96, 24);
		panel_3.add(lblMHpng);
		
		textField = new JTextField();
		textField.setBounds(143, 29, 96, 21);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng");
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKhchHng.setBounds(24, 112, 96, 13);
		panel_3.add(lblMKhchHng);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(24, 74, 109, 13);
		panel_3.add(lblTnKhchHng);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin.setBounds(24, 156, 96, 13);
		panel_3.add(lblMNhnVin);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNhnVin.setBounds(394, 32, 96, 13);
		panel_3.add(lblTnNhnVin);
		
		JLabel lblMXe = new JLabel("Mã xe");
		lblMXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMXe.setBounds(394, 74, 73, 13);
		panel_3.add(lblMXe);
		
		JLabel lblTnXe = new JLabel("Tên xe");
		lblTnXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnXe.setBounds(394, 112, 73, 13);
		panel_3.add(lblTnXe);
		
		JLabel lblNgyLp = new JLabel("Ngày lập");
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyLp.setBounds(394, 145, 84, 35);
		panel_3.add(lblNgyLp);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 153, 96, 19);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 109, 96, 19);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(143, 71, 96, 19);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(504, 71, 96, 19);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(504, 109, 96, 19);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(504, 153, 96, 19);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(504, 29, 96, 19);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin hợp đồng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(63, 10, 185, 24);
		panel_7.add(lblNewLabel_1);
		
	}
}
