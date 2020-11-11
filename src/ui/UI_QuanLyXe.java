package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class UI_QuanLyXe extends JFrame {

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
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_QuanLyXe frame = new UI_QuanLyXe();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_QuanLyXe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, screen.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1242, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
		);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1507, 41);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Nhập Xe");
		lblNewLabel.setBounds(11, 1, 295, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 47, 1507, 82);
		
		JLabel lblNewLabel_1 = new JLabel("DANH SÁCH XE NHẬP");
		lblNewLabel_1.setBounds(57, 0, 329, 72);
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setIcon(new ImageIcon("img1/moto.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 131, 1507, 195);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1.setBounds(11, 11, 130, 14);
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setBounds(145, 11, 208, 19);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1.setBounds(11, 40, 130, 14);
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 40, 208, 19);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1.setBounds(11, 69, 130, 19);
		lblNewLabel_2_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 69, 208, 19);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 98, 208, 19);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_1.setBounds(11, 98, 130, 19);
		lblNewLabel_2_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 127, 208, 19);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1_2 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_2.setBounds(11, 127, 130, 19);
		lblNewLabel_2_4_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_2 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2.setBounds(620, 7, 88, 19);
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(760, 9, 181, 19);
		comboBox.setEditable(true);
		
		JLabel lblNewLabel_2_4_1_2_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2_1.setBounds(620, 39, 130, 19);
		lblNewLabel_2_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(760, 38, 124, 19);
		comboBox_1.setEditable(true);
		
		JLabel lblNewLabel_2_4_1_2_2 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2_2.setBounds(620, 69, 130, 19);
		lblNewLabel_2_4_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(760, 68, 124, 19);
		comboBox_2.setEditable(true);
		
		textField_10 = new JTextField();
		textField_10.setBounds(760, 98, 124, 19);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_2_2_2 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2_2_2.setBounds(620, 98, 130, 19);
		lblNewLabel_2_4_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_11 = new JTextField();
		textField_11.setBounds(760, 127, 124, 19);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_2_2_2_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2_2_2_1.setBounds(620, 127, 130, 19);
		lblNewLabel_2_4_1_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_4 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_4.setBounds(1066, 11, 130, 14);
		lblNewLabel_2_4_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_3 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_3.setBounds(1066, 40, 130, 14);
		lblNewLabel_2_4_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_1_4 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_4.setBounds(1066, 69, 130, 19);
		lblNewLabel_2_4_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_1_1_2 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_1_2.setBounds(1066, 98, 130, 19);
		lblNewLabel_2_4_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_1_2_2 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_2_2.setBounds(1066, 127, 130, 19);
		lblNewLabel_2_4_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_12 = new JTextField();
		textField_12.setBounds(1200, 127, 208, 19);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(1200, 98, 208, 19);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(1200, 69, 208, 19);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(1200, 40, 208, 19);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(1200, 11, 208, 19);
		textField_16.setColumns(10);
		panel_2.setLayout(null);
		panel_2.add(panel);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		panel_4.add(lblNewLabel_2_4_1);
		panel_4.add(textField);
		panel_4.add(lblNewLabel_2_4_1_1);
		panel_4.add(textField_1);
		panel_4.add(lblNewLabel_2_4_1_1_1);
		panel_4.add(textField_2);
		panel_4.add(lblNewLabel_2_4_1_1_1_1);
		panel_4.add(textField_3);
		panel_4.add(lblNewLabel_2_4_1_1_1_2);
		panel_4.add(textField_4);
		panel_4.add(lblNewLabel_2_4_1_2_2_2_1);
		panel_4.add(lblNewLabel_2_4_1_2_2_2);
		panel_4.add(lblNewLabel_2_4_1_2_2);
		panel_4.add(textField_11);
		panel_4.add(textField_10);
		panel_4.add(comboBox_2);
		panel_4.add(lblNewLabel_2_4_1_2_1);
		panel_4.add(comboBox_1);
		panel_4.add(lblNewLabel_2_4_1_2);
		panel_4.add(comboBox);
		panel_4.add(lblNewLabel_2_4_1_4);
		panel_4.add(textField_16);
		panel_4.add(lblNewLabel_2_4_1_1_3);
		panel_4.add(textField_15);
		panel_4.add(lblNewLabel_2_4_1_1_1_4);
		panel_4.add(textField_14);
		panel_4.add(lblNewLabel_2_4_1_1_1_1_2);
		panel_4.add(textField_13);
		panel_4.add(lblNewLabel_2_4_1_1_1_2_2);
		panel_4.add(textField_12);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		JPanel panel_2_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2_1, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_2 = new JLabel("Quản Lý Nhập Xe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1237, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(930, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_1_1 = new JPanel();
		
		JLabel lblNewLabel_1_1 = new JLabel("DANH SÁCH XE NHẬP");
		lblNewLabel_1_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1237, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(57)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(851, Short.MAX_VALUE))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 82, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_4_1 = new JPanel();
		
		JLabel lblNewLabel_2_4_1_2_2_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setEditable(true);
		comboBox_2_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2_4_1_1_1_3 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1_1_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1_2_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_3 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_2 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_2_3 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setEditable(true);
		comboBox_3.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2_4_1_2_1_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setEditable(true);
		comboBox_1_1.setBackground(Color.WHITE);
		GroupLayout gl_panel_4_1 = new GroupLayout(panel_4_1);
		gl_panel_4_1.setHorizontalGroup(
			gl_panel_4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1237, Short.MAX_VALUE)
				.addGroup(gl_panel_4_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_4_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_4_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4_1.createSequentialGroup()
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_4_1.createSequentialGroup()
										.addComponent(lblNewLabel_2_4_1_3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_8))
									.addGroup(gl_panel_4_1.createSequentialGroup()
										.addComponent(lblNewLabel_2_4_1_1_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_4_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_4_1_1_1_3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
							.addGap(146)
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_4_1_2_2_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBox_2_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_4_1_2_3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_4_1_2_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(478, Short.MAX_VALUE))
		);
		gl_panel_4_1.setVerticalGroup(
			gl_panel_4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 195, Short.MAX_VALUE)
				.addGroup(gl_panel_4_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_2_4_1_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_4_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2_4_1_2_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4_1.createSequentialGroup()
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2_4_1_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_4_1_1_1_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_4_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_4_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_4_1.createSequentialGroup()
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_4_1_2_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_4_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_4_1_2_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))))
		);
		panel_4_1.setLayout(gl_panel_4_1);
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1237, Short.MAX_VALUE)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
				.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
				.addComponent(panel_4_1, GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 685, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panel_4_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(359, Short.MAX_VALUE))
		);
		panel_2_1.setLayout(gl_panel_2_1);
		contentPane.setLayout(gl_contentPane);
	}
}
