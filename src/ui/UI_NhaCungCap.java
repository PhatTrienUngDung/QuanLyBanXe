package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class UI_NhaCungCap extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_NhaCungCap frame = new UI_NhaCungCap();
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
	public UI_NhaCungCap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 740);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(UIManager.getBorder("FormattedTextField.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(UIManager.getColor("window"));
		panel_4.setBounds(10, 56, 1221, 618);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 51, 826, 167);
		panel_4.add(panel);
		panel.setForeground(UIManager.getColor("CheckBox.focus"));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new LineBorder(new Color(130, 135, 144)));
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 10, 805, 21);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u00F4ng tin nh\u00E0 cung c\u1EA5p");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 0, 210, 21);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(10, 33, 805, 122);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p");
		lblNewLabel.setBounds(10, 10, 123, 21);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p");
		lblTnNhCung.setBounds(10, 41, 123, 21);
		panel_3.add(lblTnNhCung);
		lblTnNhCung.setForeground(new Color(0, 128, 0));
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u00FA Th\u00EDch");
		lblNewLabel_1.setBounds(10, 72, 89, 13);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField = new JTextField();
		textField.setBounds(146, 11, 237, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 42, 237, 19);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(555, 11, 237, 19);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(555, 41, 237, 19);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(446, 10, 123, 21);
		panel_3.add(lblEmail);
		lblEmail.setForeground(new Color(0, 128, 0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblaCh.setBounds(446, 41, 123, 21);
		panel_3.add(lblaCh);
		lblaCh.setForeground(new Color(0, 128, 0));
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(146, 72, 646, 35);
		panel_3.add(textArea);
		textArea.setToolTipText("");
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(853, 51, 358, 167);
		panel_4.add(panel_1);
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBorder(new MatteBorder(1, 6, 1, 1, (Color) UIManager.getColor("CheckBox.focus")));
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 10, 338, 21);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_2_1 = new JLabel("Ch\u1EE9c n\u0103ng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 0, 210, 21);
		panel_2_1.add(lblNewLabel_2_1);
		
		JButton btnThem = new JButton("Th\u00EAm");
		Image img = new ImageIcon(this.getClass().getResource("/add.ico")).getImage();
		btnThem.setBackground(new Color(152, 251, 152));
		btnThem.setBounds(20, 52, 142, 36);
		panel_1.add(btnThem);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a");
		btnNewButton_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1.setBounds(199, 52, 142, 36);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C\u1EADp nh\u1EADt");
		btnNewButton_2.setBackground(new Color(152, 251, 152));
		btnNewButton_2.setBounds(20, 110, 142, 36);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("L\u00E0m t\u01B0\u01A1i");
		btnNewButton_3.setBackground(new Color(152, 251, 152));
		btnNewButton_3.setBounds(199, 110, 142, 36);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_5.setBounds(0, 0, 1221, 28);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("QU\u1EA2N L\u00DD NH\u00C0 CUNG C\u1EA4P");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(43, 0, 353, 28);
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 306, 1201, 289);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		String[] header= {"M\u00E3 nh\u00E0 cung c\u1EA5p", "T\u00EAn nh\u00E0 cung c\u1EA5p", "Email", "\u0110\u1ECBa ch\u1EC9", "Ch\u00FA th\u00EDch"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 10, 1181, 269);
		panel_6.add(scrollPane);
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E0 cung c\u1EA5p", "T\u00EAn nh\u00E0 cung c\u1EA5p", "Email", "\u0110\u1ECBa ch\u1EC9", "Ch\u00FA th\u00EDch"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(120);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(123);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 236, 826, 60);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nhập mã nhà cung cấp cần tìm");
		lblNewLabel_4.setForeground(new Color(0, 128, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 14, 190, 27);
		panel_7.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(209, 18, 228, 19);
		panel_7.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Tìm");
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.setBounds(469, 17, 85, 21);
		panel_7.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Hiển thị tất cả");
		btnNewButton_5.setBackground(new Color(0, 255, 0));
		btnNewButton_5.setBounds(566, 17, 134, 21);
		panel_7.add(btnNewButton_5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(853, 236, 358, 60);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Số lượng nhà cung cấp :");
		lblNewLabel_5.setForeground(new Color(0, 128, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(47, 10, 154, 40);
		panel_8.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(211, 18, 79, 28);
		panel_8.add(textField_5);
		textField_5.setColumns(10);
		table = new JTable();
	
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 267, 1181, -260);
	}
}
