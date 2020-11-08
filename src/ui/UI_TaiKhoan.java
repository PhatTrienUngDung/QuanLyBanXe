package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class UI_TaiKhoan extends JFrame {

	private JPanel pAccount;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_TaiKhoan frame = new UI_TaiKhoan();
				
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
	public UI_TaiKhoan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1133, 678);
		pAccount = new JPanel();
		pAccount.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pAccount);
		pAccount.setLayout(null);
		
		JLabel lblAccountName = new JLabel("TÀI KHOẢN");
		lblAccountName.setBounds(450, 5, 367, 22);
		lblAccountName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountName.setForeground(Color.BLUE);
		lblAccountName.setFont(new Font("Tahoma", Font.BOLD, 18));
		pAccount.add(lblAccountName);
		
		JPanel pAccountInfo = new JPanel();
		pAccountInfo.setBackground(Color.LIGHT_GRAY);
		pAccountInfo.setBounds(5, 37, 675, 113);
		pAccountInfo.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		pAccount.add(pAccountInfo);
		pAccountInfo.setLayout(null);
		
		JLabel lblEmployeeName_Acc = new JLabel("Mã Nhân Viên");
		lblEmployeeName_Acc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeName_Acc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeName_Acc.setBounds(5, 24, 103, 13);
		pAccountInfo.add(lblEmployeeName_Acc);
		
		TextField txtEmployeeNum_Acc = new TextField();
		txtEmployeeNum_Acc.setBounds(111, 20, 149, 23);
		pAccountInfo.add(txtEmployeeNum_Acc);
		
		JLabel lblNewLabel = new JLabel("Tên Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(300, 25, 103, 13);
		pAccountInfo.add(lblNewLabel);
		
		TextField txtEmployeeName_Acc = new TextField();
		txtEmployeeName_Acc.setEditable(false);
		txtEmployeeName_Acc.setBounds(406, 20, 252, 23);
		pAccountInfo.add(txtEmployeeName_Acc);
		
		JLabel lblPassword_Acc = new JLabel("Mật Khẩu");
		lblPassword_Acc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword_Acc.setBounds(17, 52, 93, 13);
		pAccountInfo.add(lblPassword_Acc);
		
		TextField txtPassword_Acc = new TextField();
		txtPassword_Acc.setBounds(111, 50, 149, 23);
		pAccountInfo.add(txtPassword_Acc);
		
		JLabel lblPower_Acc = new JLabel("Quyền");
		lblPower_Acc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPower_Acc.setBounds(17, 80, 103, 13);
		pAccountInfo.add(lblPower_Acc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Quản Lý", "Nhân Viên"}));
		comboBox.setBounds(111, 80, 149, 23);
		pAccountInfo.add(comboBox);
		
		JLabel lblNote_Acc = new JLabel("Chú Thích");
		lblNote_Acc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNote_Acc.setBounds(300, 52, 103, 13);
		pAccountInfo.add(lblNote_Acc);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(406, 52, 252, 51);
		pAccountInfo.add(textArea);
		
		JPanel pAccountFunction = new JPanel();
		pAccountFunction.setBackground(Color.LIGHT_GRAY);
		pAccountFunction.setBounds(690, 37, 419, 113);
		pAccountFunction.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		pAccount.add(pAccountFunction);
		pAccountFunction.setLayout(null);
		
		JButton btnAdd_Acc = new JButton("Cấp Tài Khoản");
		btnAdd_Acc.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAdd_Acc.setBounds(24, 25, 157, 30);
		pAccountFunction.add(btnAdd_Acc);
		btnAdd_Acc.setIcon(new ImageIcon("icon/add-icon.png"));
		
		JButton btnDelete_Acc = new JButton("Xóa Tài Khoản");
		btnDelete_Acc.setFont(new Font("Dialog", Font.BOLD, 13));
		btnDelete_Acc.setBounds(225, 25, 157, 30);
		pAccountFunction.add(btnDelete_Acc);
		btnDelete_Acc.setIcon(new ImageIcon("/icon/delete.png"));
		
		JButton btnResetPassword_Acc = new JButton("Đặt Lại Mật Khẩu");
		btnResetPassword_Acc.setFont(new Font("Dialog", Font.BOLD, 13));
		btnResetPassword_Acc.setBounds(120, 70, 180, 30);
		pAccountFunction.add(btnResetPassword_Acc);
		btnResetPassword_Acc.setIcon(new ImageIcon("Clear-icon.png"));
		
		JPanel pSearchAccount = new JPanel();
		pSearchAccount.setBackground(Color.LIGHT_GRAY);
		pSearchAccount.setForeground(Color.BLACK);
		pSearchAccount.setBounds(5, 160, 675, 41);
		pAccount.add(pSearchAccount);
		pSearchAccount.setLayout(null);

		JLabel lblSearch_Acc = new JLabel("Nhập nội dung tìm kiếm:");
		lblSearch_Acc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearch_Acc.setBounds(17, 13, 148, 13);
		pSearchAccount.add(lblSearch_Acc);
		
		TextField txtSearch_Acc = new TextField();
		txtSearch_Acc.setBounds(174, 10, 340, 21);
		pSearchAccount.add(txtSearch_Acc);
		
		Button btnSearch_Acc = new Button("Tìm");
		btnSearch_Acc.setBounds(536, 10, 113, 21);
		pSearchAccount.add(btnSearch_Acc);
		
		JPanel pTypeSearch_Acc = new JPanel();
		pTypeSearch_Acc.setBackground(Color.LIGHT_GRAY);
		pTypeSearch_Acc.setBounds(690, 160, 409, 41);
		pAccount.add(pTypeSearch_Acc);
		pTypeSearch_Acc.setLayout(null);
		
		JLabel lblTypeSearch_Acc = new JLabel("Loại tìm kiếm:");
		lblTypeSearch_Acc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTypeSearch_Acc.setBounds(17, 13, 96, 13);
		pTypeSearch_Acc.add(lblTypeSearch_Acc);
		
		JRadioButton radEmployeeNumSearch = new JRadioButton("Mã Nhân Viên");
		radEmployeeNumSearch.setBackground(Color.LIGHT_GRAY);
		radEmployeeNumSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radEmployeeNumSearch.setBounds(136, 10, 112, 21);
		pTypeSearch_Acc.add(radEmployeeNumSearch);
		
		JRadioButton radEmpployeeNameSearch = new JRadioButton("Tên Nhân Viên");
		radEmpployeeNameSearch.setBackground(Color.LIGHT_GRAY);
		radEmpployeeNameSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radEmpployeeNameSearch.setBounds(272, 10, 118, 21);
		pTypeSearch_Acc.add(radEmpployeeNameSearch);
		
		JPanel pAccountList = new JPanel();
		pAccountList.setBounds(5, 211, 1114, 420);
		pAccount.add(pAccountList);
		pAccountList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 0, 1100, 430);
		pAccountList.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "M\u1EADt Kh\u1EA9u", "Quy\u1EC1n", "Ch\u00FA Th\u00EDch"
			}
		));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		
	}
}
