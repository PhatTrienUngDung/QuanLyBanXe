package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Dao_HoaDon;
import dao.Dao_TaiKhoan;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class UI_HoaDon extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_HoaDon frame = new UI_HoaDon();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		//setBounds(0, 0, 1113, 614);
		setBounds(0, 0, width, height);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pBillTitle = new JPanel();
		pBillTitle.setBounds(5, 5, 1518, 35);
		pBillTitle.setBackground(new Color(176, 224, 230));
		contentPane.add(pBillTitle);
		pBillTitle.setLayout(null);
		
		JLabel lblBillTitle = new JLabel("Hóa Đơn Bán Lẻ");
		lblBillTitle.setBounds(72, 4, 168, 25);
		lblBillTitle.setForeground(new Color(220, 20, 60));
		lblBillTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		pBillTitle.add(lblBillTitle);
		
		JPanel pGenInfo_Bill = new JPanel();
		pGenInfo_Bill.setBackground(new Color(211, 211, 211));
		pGenInfo_Bill.setBounds(5, 50, 910, 116);
		contentPane.add(pGenInfo_Bill);
		pGenInfo_Bill.setLayout(null);
		
		JLabel lblGenInfo_Bill = new JLabel("Thông tin chung");
		lblGenInfo_Bill.setBounds(10, 5, 139, 20);
		lblGenInfo_Bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		pGenInfo_Bill.add(lblGenInfo_Bill);
		
		JPanel pCustomerInfo_Bill = new JPanel();
		pCustomerInfo_Bill.setBackground(new Color(230, 230, 250));
		pCustomerInfo_Bill.setBounds(1, 26, 907, 88);
		pGenInfo_Bill.add(pCustomerInfo_Bill);
		pCustomerInfo_Bill.setLayout(null);
		
		JLabel lblCustomerNum_Bill = new JLabel("CMND");
		lblCustomerNum_Bill.setBounds(10, 12, 87, 21);
		lblCustomerNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pCustomerInfo_Bill.add(lblCustomerNum_Bill);
		
		TextField txtCMND_Bill = new TextField();
		txtCMND_Bill.setBounds(100, 10, 220, 25);
		pCustomerInfo_Bill.add(txtCMND_Bill);
		
		JButton btnSearchCMND_Bill = new JButton("");
		btnSearchCMND_Bill.setBackground(Color.WHITE);
		btnSearchCMND_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/search-icon.png")));
		btnSearchCMND_Bill.setBounds(320, 10, 25, 25);
		pCustomerInfo_Bill.add(btnSearchCMND_Bill);
		
		JLabel lblNumPhone_Bill = new JLabel("SĐT");
		lblNumPhone_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumPhone_Bill.setBounds(10, 55, 45, 21);
		pCustomerInfo_Bill.add(lblNumPhone_Bill);
		
		TextField txtNumPhone_Bill = new TextField();
		txtNumPhone_Bill.setBounds(100, 53, 220, 25);
		pCustomerInfo_Bill.add(txtNumPhone_Bill);
		
		JLabel lblCustomerName_Bill = new JLabel("Tên Khách Hàng");
		lblCustomerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerName_Bill.setBounds(405, 12, 128, 21);
		pCustomerInfo_Bill.add(lblCustomerName_Bill);
		
		TextField txtCustomerName_Bill = new TextField();
		txtCustomerName_Bill.setBounds(570, 10, 327, 25);
		pCustomerInfo_Bill.add(txtCustomerName_Bill);
		
		JLabel lblNote_Bill = new JLabel("Chú Thích");
		lblNote_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNote_Bill.setBounds(405, 55, 87, 21);
		pCustomerInfo_Bill.add(lblNote_Bill);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(570, 53, 327, 25);
		pCustomerInfo_Bill.add(textArea);
		
		JPanel pOtherInfo_Bill = new JPanel();
		pOtherInfo_Bill.setBackground(new Color(211, 211, 211));
		pOtherInfo_Bill.setBounds(934, 50, 588, 115);
		contentPane.add(pOtherInfo_Bill);
		pOtherInfo_Bill.setLayout(null);
		
		JLabel lblOtherInfo_Bill = new JLabel("Thông Tin Khác");
		lblOtherInfo_Bill.setBounds(10, 5, 150, 16);
		lblOtherInfo_Bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		pOtherInfo_Bill.add(lblOtherInfo_Bill);
		
		JPanel pEmployeeInfo_Bill = new JPanel();
		pEmployeeInfo_Bill.setBounds(1, 25, 584, 88);
		pOtherInfo_Bill.add(pEmployeeInfo_Bill);
		pEmployeeInfo_Bill.setLayout(null);
		
		JLabel lblEmployee_Bill = new JLabel("Nhân Viên");
		lblEmployee_Bill.setBackground(new Color(230, 230, 250));
		lblEmployee_Bill.setBounds(10, 12, 87, 21);
		lblEmployee_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pEmployeeInfo_Bill.add(lblEmployee_Bill);
		
		TextField txtEmployeeNum_Bill = new TextField();
		txtEmployeeNum_Bill.setEditable(false);
		txtEmployeeNum_Bill.setBounds(140, 10, 168, 25);
		pEmployeeInfo_Bill.add(txtEmployeeNum_Bill);
		
		TextField txtEmployeeName_Bill = new TextField();
		txtEmployeeName_Bill.setEditable(false);
		txtEmployeeName_Bill.setBounds(320, 10, 258, 25);
		pEmployeeInfo_Bill.add(txtEmployeeName_Bill);
		
		JLabel lblBillNum = new JLabel("Mã Hóa Đơn");
		lblBillNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBillNum.setBounds(10, 55, 92, 21);
		pEmployeeInfo_Bill.add(lblBillNum);
		
		TextField txtBillNum = new TextField();
		txtBillNum.setEditable(false);
		txtBillNum.setBounds(140, 53, 168, 25);
		pEmployeeInfo_Bill.add(txtBillNum);
		
		JLabel lblBillDate = new JLabel("Ngày LHD");
		lblBillDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBillDate.setBounds(320, 55, 86, 21);
		pEmployeeInfo_Bill.add(lblBillDate);
		
		TextField textField_2 = new TextField();
		textField_2.setEditable(false);
		textField_2.setBounds(414, 53, 164, 25);
		pEmployeeInfo_Bill.add(textField_2);
		
		JPanel pProduct_Bill = new JPanel();
		pProduct_Bill.setBackground(new Color(211, 211, 211));
		pProduct_Bill.setBounds(5, 175, 910, 163);
		contentPane.add(pProduct_Bill);
		pProduct_Bill.setLayout(null);
		
		JLabel lblProduct_Bill = new JLabel("Th\u00EAm xe m\u1EDBi");
		lblProduct_Bill.setBounds(10, 5, 111, 20);
		lblProduct_Bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		pProduct_Bill.add(lblProduct_Bill);
		
		JPanel pAddVehicle_Bill = new JPanel();
		pAddVehicle_Bill.setToolTipText("");
		pAddVehicle_Bill.setBounds(1, 26, 907, 134);
		pProduct_Bill.add(pAddVehicle_Bill);
		pAddVehicle_Bill.setLayout(null);
		
		JLabel lblVehicleNum_Bill = new JLabel("M\u00E3 Xe");
		lblVehicleNum_Bill.setBounds(10, 12, 44, 21);
		lblVehicleNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAddVehicle_Bill.add(lblVehicleNum_Bill);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setToolTipText("ch\u1ECDn m\u00E3");
		comboBox.setBounds(100, 10, 220, 25);
		pAddVehicle_Bill.add(comboBox);
		
		JLabel lblVehicleName_Bill = new JLabel("T\u00EAn Xe");
		lblVehicleName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleName_Bill.setBounds(405, 12, 60, 21);
		pAddVehicle_Bill.add(lblVehicleName_Bill);
		
		TextField txtVehicleName_Bill = new TextField();
		txtVehicleName_Bill.setBounds(570, 10, 302, 25);
		pAddVehicle_Bill.add(txtVehicleName_Bill);
		
		JComboBox cbbVehicleColor_Bill = new JComboBox();
		cbbVehicleColor_Bill.setBackground(Color.WHITE);
		cbbVehicleColor_Bill.setBounds(100, 53, 132, 25);
		pAddVehicle_Bill.add(cbbVehicleColor_Bill);
		
		JLabel lblVehicleColor_Bill = new JLabel("M\u00E0u Xe");
		lblVehicleColor_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleColor_Bill.setBounds(10, 55, 68, 21);
		pAddVehicle_Bill.add(lblVehicleColor_Bill);
		
		JLabel lblManufacturerName_Bill = new JLabel("H\u00E3ng s\u1EA3n xu\u1EA5t");
		lblManufacturerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblManufacturerName_Bill.setBounds(405, 55, 115, 21);
		pAddVehicle_Bill.add(lblManufacturerName_Bill);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(570, 53, 132, 25);
		pAddVehicle_Bill.add(comboBox_1);
		
		JLabel lblAmountVehicle_Bill = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblAmountVehicle_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAmountVehicle_Bill.setBounds(10, 98, 70, 21);
		pAddVehicle_Bill.add(lblAmountVehicle_Bill);
		
		TextField textField = new TextField();
		textField.setBounds(100, 96, 132, 21);
		pAddVehicle_Bill.add(textField);
		
		JButton btnSearchVehicleName_Bill = new JButton("");
		btnSearchVehicleName_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/search-icon.png")));
		btnSearchVehicleName_Bill.setBackground(Color.WHITE);
		btnSearchVehicleName_Bill.setBounds(872, 10, 25, 25);
		pAddVehicle_Bill.add(btnSearchVehicleName_Bill);
		
		JLabel lblNoteVehicle_Bill = new JLabel("Ghi Ch\u00FA");
		lblNoteVehicle_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoteVehicle_Bill.setBounds(405, 98, 60, 13);
		pAddVehicle_Bill.add(lblNoteVehicle_Bill);
		
		JTextArea txtNoteVehicle_Bill = new JTextArea();
		txtNoteVehicle_Bill.setBounds(570, 96, 327, 25);
		pAddVehicle_Bill.add(txtNoteVehicle_Bill);
		
		JPanel pBillDetailsList = new JPanel();
		pBillDetailsList.setBackground(new Color(211, 211, 211));
		pBillDetailsList.setBounds(5, 348, 1518, 351);
		contentPane.add(pBillDetailsList);
		pBillDetailsList.setLayout(null);
		
		JLabel lblBillDetailsList = new JLabel("Danh s\u00E1ch xe b\u00E1n");
		lblBillDetailsList.setBounds(10, 5, 114, 16);
		lblBillDetailsList.setFont(new Font("Tahoma", Font.BOLD, 13));
		pBillDetailsList.add(lblBillDetailsList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1, 25, 1516, 326);
		pBillDetailsList.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		String[] header = {"Mã Xe", "Tên Xe", "Màu xe", "Phân Khối", "Hãng Sản Xuất", "Số Lượng", "Đơn Giá", "Thuế VAT", "Thành tiền"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		table.setModel(tableModel);
		scrollPane_1.setViewportView(table);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.getTableHeader().setForeground(new Color(50,205,50));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(489, 709, 343, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalBill = new JLabel("T\u1ED5ng ti\u1EC1n");
		lblTotalBill.setBounds(10, 18, 115, 25);
		lblTotalBill.setForeground(new Color(255, 0, 0));
		lblTotalBill.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalBill.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblTotalBill);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(136, 12, 197, 35);
		panel.add(textField_3);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(943, 709, 580, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddCustomer_Bill = new JButton("Th\u00EAm M\u1EDBi KH");
		btnAddCustomer_Bill.setBackground(new Color(50, 205, 50));
		btnAddCustomer_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Add-group-icon.png")));
		btnAddCustomer_Bill.setBounds(10, 6, 191, 51);
		btnAddCustomer_Bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(btnAddCustomer_Bill);
		
		JButton btnNewButton = new JButton("H\u1EE7y CTHD");
		btnNewButton.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Status-dialog-error-icon.png")));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(211, 6, 175, 51);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thanh To\u00E1n");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/coin-icon.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(396, 6, 175, 51);
		panel_1.add(btnNewButton_1);
		
		JPanel pImageVehicle_Bill = new JPanel();
		pImageVehicle_Bill.setBounds(934, 175, 368, 163);
		contentPane.add(pImageVehicle_Bill);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1312, 175, 210, 163);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnEmptyDelete_Bill = new JButton("X\u00F3a Tr\u1EAFng");
		btnEmptyDelete_Bill.setBackground(new Color(135, 206, 250));
		btnEmptyDelete_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Recycle-Bin-Full-icon.png")));
		btnEmptyDelete_Bill.setBounds(26, 18, 160, 51);
		btnEmptyDelete_Bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btnEmptyDelete_Bill);
		
		JButton btnAddVehicle_Bill = new JButton("Th\u00EAm Xe");
		btnAddVehicle_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/sign-add-icon.png")));
		btnAddVehicle_Bill.setBackground(new Color(50, 205, 50));
		btnAddVehicle_Bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddVehicle_Bill.setBounds(26, 90, 160, 51);
		panel_2.add(btnAddVehicle_Bill);
	}
}
