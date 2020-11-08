package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.SwingConstants;

public class UI_HoaDon extends JFrame {

	private JPanel contentPane;
	private JTable tableProductInfo_Bill;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_HoaDon frame = new UI_HoaDon();
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
	public UI_HoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1113, 614);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pBillTitle = new JPanel();
		pBillTitle.setBounds(5, 5, 1089, 35);
		pBillTitle.setBackground(new Color(176, 224, 230));
		contentPane.add(pBillTitle);
		
		JLabel lblBillTitle = new JLabel("H\u00F3a \u0110\u01A1n B\u00E1n L\u1EBB");
		lblBillTitle.setForeground(new Color(220, 20, 60));
		lblBillTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		pBillTitle.add(lblBillTitle);
		
		JPanel pGenInfo_Bill = new JPanel();
		pGenInfo_Bill.setBackground(new Color(211, 211, 211));
		pGenInfo_Bill.setBounds(5, 50, 621, 107);
		contentPane.add(pGenInfo_Bill);
		pGenInfo_Bill.setLayout(null);
		
		JLabel lblGenInfo_Bill = new JLabel("Th\u00F4ng tin chung");
		lblGenInfo_Bill.setBounds(10, 5, 105, 16);
		lblGenInfo_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		pGenInfo_Bill.add(lblGenInfo_Bill);
		
		JPanel pCustomerInfo_Bill = new JPanel();
		pCustomerInfo_Bill.setBackground(new Color(230, 230, 250));
		pCustomerInfo_Bill.setBounds(1, 25, 619, 81);
		pGenInfo_Bill.add(pCustomerInfo_Bill);
		pCustomerInfo_Bill.setLayout(null);
		
		JLabel lblCustomerNum_Bill = new JLabel("M\u00E3 Kh\u00E1ch H\u00E0ng");
		lblCustomerNum_Bill.setBounds(10, 10, 87, 16);
		lblCustomerNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pCustomerInfo_Bill.add(lblCustomerNum_Bill);
		
		TextField textField = new TextField();
		textField.setBounds(123, 10, 102, 21);
		pCustomerInfo_Bill.add(textField);
		
		JLabel lblCustomerName_Bill = new JLabel("T\u00EAn Kh\u00E1ch H\u00E0ng");
		lblCustomerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCustomerName_Bill.setBounds(276, 10, 109, 16);
		pCustomerInfo_Bill.add(lblCustomerName_Bill);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(391, 10, 215, 21);
		pCustomerInfo_Bill.add(textField_1);
		
		JLabel lblNote_Bill = new JLabel("Ch\u00FA Th\u00EDch");
		lblNote_Bill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNote_Bill.setBounds(10, 45, 67, 16);
		pCustomerInfo_Bill.add(lblNote_Bill);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(123, 40, 483, 30);
		pCustomerInfo_Bill.add(textArea);
		
		JPanel pOtherInfo_Bill = new JPanel();
		pOtherInfo_Bill.setBackground(new Color(211, 211, 211));
		pOtherInfo_Bill.setBounds(636, 50, 458, 107);
		contentPane.add(pOtherInfo_Bill);
		pOtherInfo_Bill.setLayout(null);
		
		JLabel lblOtherInfo_Bill = new JLabel("Th\u00F4ng tin kh\u00E1c");
		lblOtherInfo_Bill.setBounds(10, 5, 97, 16);
		lblOtherInfo_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		pOtherInfo_Bill.add(lblOtherInfo_Bill);
		
		JPanel pEmployeeInfo_Bill = new JPanel();
		pEmployeeInfo_Bill.setBounds(1, 25, 456, 81);
		pOtherInfo_Bill.add(pEmployeeInfo_Bill);
		pEmployeeInfo_Bill.setLayout(null);
		
		JLabel lblEmployee_Bill = new JLabel("Nh\u00E2n Vi\u00EAn");
		lblEmployee_Bill.setBackground(new Color(230, 230, 250));
		lblEmployee_Bill.setBounds(10, 12, 78, 16);
		lblEmployee_Bill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pEmployeeInfo_Bill.add(lblEmployee_Bill);
		
		TextField txtEmployeeNum_Bill = new TextField();
		txtEmployeeNum_Bill.setBounds(112, 10, 125, 21);
		pEmployeeInfo_Bill.add(txtEmployeeNum_Bill);
		
		TextField txtEmployeeName_Bill = new TextField();
		txtEmployeeName_Bill.setEditable(false);
		txtEmployeeName_Bill.setBounds(243, 10, 204, 21);
		pEmployeeInfo_Bill.add(txtEmployeeName_Bill);
		
		JLabel lblBillNum = new JLabel("M\u00E3 H\u00F3a \u0110\u01A1n");
		lblBillNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBillNum.setBounds(10, 38, 78, 13);
		pEmployeeInfo_Bill.add(lblBillNum);
		
		TextField txtBillNum = new TextField();
		txtBillNum.setBounds(112, 37, 125, 21);
		pEmployeeInfo_Bill.add(txtBillNum);
		
		JLabel lblBillDate = new JLabel("Ng\u00E0y LHD");
		lblBillDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBillDate.setBounds(243, 38, 65, 13);
		pEmployeeInfo_Bill.add(lblBillDate);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(316, 37, 131, 21);
		pEmployeeInfo_Bill.add(textField_2);
		
		JPanel pProduct_Bill = new JPanel();
		pProduct_Bill.setBackground(new Color(211, 211, 211));
		pProduct_Bill.setBounds(5, 166, 1089, 73);
		contentPane.add(pProduct_Bill);
		pProduct_Bill.setLayout(null);
		
		JLabel lblProduct_Bill = new JLabel("Th\u00EAm xe m\u1EDBi");
		lblProduct_Bill.setBounds(10, 5, 85, 16);
		lblProduct_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		pProduct_Bill.add(lblProduct_Bill);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 25, 989, 46);
		pProduct_Bill.add(scrollPane);
		
		tableProductInfo_Bill = new JTable();
		scrollPane.setViewportView(tableProductInfo_Bill);
		tableProductInfo_Bill.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 xe", "T\u00EAn xe", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		tableProductInfo_Bill.setRowHeight(25);
		tableProductInfo_Bill.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		//tableProductInfo_Bill.getTableHeader().setBackground(Color.green);
		tableProductInfo_Bill.getTableHeader().setForeground(new Color(50, 205, 50));
		tableProductInfo_Bill.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnAddProduct_Bill = new JButton("Th\u00EAm Xe");
		btnAddProduct_Bill.setBackground(new Color(230, 230, 250));
		btnAddProduct_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddProduct_Bill.setBounds(988, 25, 100, 46);
		pProduct_Bill.add(btnAddProduct_Bill);
		
		JPanel pBillDetailsList = new JPanel();
		pBillDetailsList.setBackground(new Color(211, 211, 211));
		pBillDetailsList.setBounds(5, 248, 1089, 264);
		contentPane.add(pBillDetailsList);
		pBillDetailsList.setLayout(null);
		
		JLabel lblBillDetailsList = new JLabel("Danh s\u00E1ch xe b\u00E1n");
		lblBillDetailsList.setBounds(10, 5, 114, 16);
		lblBillDetailsList.setFont(new Font("Tahoma", Font.BOLD, 13));
		pBillDetailsList.add(lblBillDetailsList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1, 25, 1087, 238);
		pBillDetailsList.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
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
			},
			new String[] {
				"STT", "M\u00E3 xe", "T\u00EAn xe", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(255, 522, 313, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalBill = new JLabel("T\u1ED5ng ti\u1EC1n");
		lblTotalBill.setBounds(10, 10, 88, 22);
		lblTotalBill.setForeground(new Color(255, 0, 0));
		lblTotalBill.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalBill.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblTotalBill);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(115, 6, 162, 30);
		panel.add(textField_3);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(598, 522, 496, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddCustomer_Bill = new JButton("Th\u00EAm Kh\u00E1ch H\u00E0ng");
		btnAddCustomer_Bill.setBounds(10, 5, 185, 31);
		btnAddCustomer_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnAddCustomer_Bill);
		
		JButton btnNewButton = new JButton("H\u1EE7y H\u00F3a \u0110\u01A1n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(205, 5, 128, 31);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thanh To\u00E1n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(343, 5, 142, 31);
		panel_1.add(btnNewButton_1);
	}
}
