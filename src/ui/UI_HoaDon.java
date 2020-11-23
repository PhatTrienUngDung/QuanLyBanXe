package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import autoComplete.FillCombo;
import connect.ConnectDB;
import dao.Dao_HangSanXuat;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_NhaCungCap;
import dao.Dao_QuanLyXe;
import dao.Dao_TaiKhoan;
import entity.Xe;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class UI_HoaDon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static TextField txtTotal = new TextField();

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
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		Dao_KhachHang dao_kh = new Dao_KhachHang();
		Dao_HangSanXuat dao_Hsx = new Dao_HangSanXuat();
		Dao_QuanLyXe dao_Xe = new Dao_QuanLyXe();
		Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		List<String> list_CMND = dao_kh.getListCMND();
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
		txtCMND_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND_Bill.setBounds(100, 10, 250, 25);
		pCustomerInfo_Bill.add(txtCMND_Bill);
		
		JLabel lblNumPhone_Bill = new JLabel("SĐT");
		lblNumPhone_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumPhone_Bill.setBounds(10, 55, 45, 21);
		pCustomerInfo_Bill.add(lblNumPhone_Bill);
		
		TextField txtNumPhone_Bill = new TextField();
		txtNumPhone_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNumPhone_Bill.setBounds(100, 53, 250, 25);
		pCustomerInfo_Bill.add(txtNumPhone_Bill);
		
		JLabel lblCustomerName_Bill = new JLabel("Tên Khách Hàng");
		lblCustomerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerName_Bill.setBounds(405, 12, 128, 21);
		pCustomerInfo_Bill.add(lblCustomerName_Bill);
		
		TextField txtCustomerName_Bill = new TextField();
		txtCustomerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCustomerName_Bill.setBounds(570, 10, 327, 25);
		pCustomerInfo_Bill.add(txtCustomerName_Bill);
		
		JLabel lblNote_Bill = new JLabel("Chú Thích");
		lblNote_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNote_Bill.setBounds(405, 55, 87, 21);
		pCustomerInfo_Bill.add(lblNote_Bill);
		
		JTextArea txtNoteCustomer_Bill = new JTextArea();
		txtNoteCustomer_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNoteCustomer_Bill.setBounds(570, 53, 327, 25);
		pCustomerInfo_Bill.add(txtNoteCustomer_Bill);
		
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
		txtEmployeeNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmployeeNum_Bill.setEditable(false);
		txtEmployeeNum_Bill.setBounds(140, 10, 168, 25);
		pEmployeeInfo_Bill.add(txtEmployeeNum_Bill);
		
		TextField txtEmployeeName_Bill = new TextField();
		txtEmployeeName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmployeeName_Bill.setEditable(false);
		txtEmployeeName_Bill.setBounds(320, 10, 258, 25);
		pEmployeeInfo_Bill.add(txtEmployeeName_Bill);
		
		JLabel lblBillNum = new JLabel("Mã Hóa Đơn");
		lblBillNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBillNum.setBounds(10, 55, 92, 21);
		pEmployeeInfo_Bill.add(lblBillNum);
		
		TextField txtBillNum = new TextField();
		txtBillNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBillNum.setEditable(false);
		txtBillNum.setBounds(140, 53, 168, 25);
		pEmployeeInfo_Bill.add(txtBillNum);
		
		JLabel lblBillDate = new JLabel("Ngày LHD");
		lblBillDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBillDate.setBounds(320, 55, 86, 21);
		pEmployeeInfo_Bill.add(lblBillDate);
		
		TextField txtDateBill = new TextField();
		txtDateBill.setText(LocalDate.now().toString());
		txtDateBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateBill.setEditable(false);
		txtDateBill.setBounds(414, 53, 164, 25);
		pEmployeeInfo_Bill.add(txtDateBill);
		
		JPanel pProduct_Bill = new JPanel();
		pProduct_Bill.setBackground(new Color(211, 211, 211));
		pProduct_Bill.setBounds(5, 175, 910, 163);
		contentPane.add(pProduct_Bill);
		pProduct_Bill.setLayout(null);
		
		JLabel lblProduct_Bill = new JLabel("Thêm Xe Mới");
		lblProduct_Bill.setBounds(10, 5, 111, 20);
		lblProduct_Bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		pProduct_Bill.add(lblProduct_Bill);
		
		JPanel pAddVehicle_Bill = new JPanel();
		pAddVehicle_Bill.setToolTipText("");
		pAddVehicle_Bill.setBounds(1, 26, 907, 134);
		pProduct_Bill.add(pAddVehicle_Bill);
		pAddVehicle_Bill.setLayout(null);
		
		JLabel lblVehicleNum_Bill = new JLabel("Mã Xe");
		lblVehicleNum_Bill.setBounds(10, 12, 44, 21);
		lblVehicleNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAddVehicle_Bill.add(lblVehicleNum_Bill);
		
		JLabel lblVehicleName_Bill = new JLabel("Tên Xe");
		lblVehicleName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleName_Bill.setBounds(405, 12, 60, 21);
		pAddVehicle_Bill.add(lblVehicleName_Bill);
		
		JComboBox cbbVehicleColor_Bill = new JComboBox();
		cbbVehicleColor_Bill.setBackground(Color.WHITE);
		cbbVehicleColor_Bill.setBounds(570, 53, 132, 25);
		pAddVehicle_Bill.add(cbbVehicleColor_Bill);
		
		JLabel lblVehicleColor_Bill = new JLabel("Màu Xe");
		lblVehicleColor_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleColor_Bill.setBounds(405, 55, 68, 21);
		pAddVehicle_Bill.add(lblVehicleColor_Bill);
		
		TextField txtVehicleNum_Bill = new TextField();
		txtVehicleNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtVehicleNum_Bill.setEditable(false);
		txtVehicleNum_Bill.setEnabled(false);
		txtVehicleNum_Bill.setBounds(100, 10, 251, 25);
		pAddVehicle_Bill.add(txtVehicleNum_Bill);
		
		JLabel lblManufacturerName_Bill = new JLabel("Hãng SX");
		lblManufacturerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblManufacturerName_Bill.setBounds(10, 55, 68, 21);
		pAddVehicle_Bill.add(lblManufacturerName_Bill);
		
		JComboBox cbbManufacturer = new JComboBox();
		cbbManufacturer.setBackground(Color.WHITE);
		cbbManufacturer.setBounds(100, 53, 132, 25);
		pAddVehicle_Bill.add(cbbManufacturer);
		
		JLabel lblAmountVehicle_Bill = new JLabel("Số Lượng");
		lblAmountVehicle_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAmountVehicle_Bill.setBounds(405, 98, 70, 21);
		pAddVehicle_Bill.add(lblAmountVehicle_Bill);
		
		JSpinner txtAmount = new JSpinner();
		txtAmount.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		txtAmount.setBounds(570, 96, 132, 25);
		pAddVehicle_Bill.add(txtAmount);
		
		JLabel lblSupplier_Bill = new JLabel("NCC");
		lblSupplier_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplier_Bill.setBounds(10, 98, 44, 21);
		pAddVehicle_Bill.add(lblSupplier_Bill);
		
		JComboBox cbbSupplier = new JComboBox();
		cbbSupplier.setBounds(100, 98, 132, 25);
		pAddVehicle_Bill.add(cbbSupplier);
		
		JComboBox cbbVehicleName_Bill = new JComboBox();
		cbbVehicleName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbVehicleName_Bill.setBackground(Color.WHITE);
		cbbVehicleName_Bill.setBounds(570, 10, 327, 25);
		pAddVehicle_Bill.add(cbbVehicleName_Bill);
		
		FillCombo combo = new FillCombo();
		try {
			combo.fill("select DISTINCT tenXe from Xe where soLuong > 0" , cbbVehicleName_Bill, "tenXe");	
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		
		JPanel pBillDetailsList = new JPanel();
		pBillDetailsList.setBackground(new Color(211, 211, 211));
		pBillDetailsList.setBounds(5, 348, 1518, 351);
		contentPane.add(pBillDetailsList);
		pBillDetailsList.setLayout(null);
		
		JLabel lblBillDetailsList = new JLabel("Danh sách xe bán");
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
		//DefaultTableModel tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		scrollPane_1.setViewportView(table);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.getTableHeader().setForeground(new Color(50,205,50));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		Border border = new LineBorder(Color.white);
		scrollPane_1.setBorder(border);
		table.getTableHeader().setBorder(border);
		table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.white));
		//table.setBorder(BorderFactory.createLineBorder(Color.white));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(489, 709, 343, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalBill = new JLabel("Tổng Tiền");
		lblTotalBill.setBounds(10, 18, 115, 25);
		lblTotalBill.setForeground(new Color(255, 0, 0));
		lblTotalBill.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalBill.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblTotalBill);
		txtTotal.setForeground(Color.RED);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setEditable(false);
		
		//txtTotal = new TextField();
		txtTotal.setText("0 VNĐ");
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotal.setBounds(136, 12, 197, 35);
		panel.add(txtTotal);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(943, 709, 580, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnDeleteRowTableCTHD = new JButton("Xóa Xe CTHD");	
		btnDeleteRowTableCTHD.setBackground(new Color(255, 69, 0));
		btnDeleteRowTableCTHD.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/delete-icon.png")));
		btnDeleteRowTableCTHD.setBounds(10, 6, 191, 51);
		btnDeleteRowTableCTHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(btnDeleteRowTableCTHD);
		
		JButton btnRemoveCTHD = new JButton("Hủy CTHD");
		btnRemoveCTHD.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Status-dialog-error-icon.png")));
		btnRemoveCTHD.setBackground(Color.RED);
		btnRemoveCTHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemoveCTHD.setBounds(211, 6, 175, 51);
		panel_1.add(btnRemoveCTHD);
		
		JButton btnPayments = new JButton("Thanh Toán");
		btnPayments.setBackground(Color.ORANGE);
		btnPayments.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/coin-icon.png")));
		btnPayments.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPayments.setBounds(396, 6, 175, 51);
		panel_1.add(btnPayments);
		
		JPanel pImageVehicle_Bill = new JPanel();
		pImageVehicle_Bill.setBounds(934, 175, 368, 163);
		contentPane.add(pImageVehicle_Bill);
		pImageVehicle_Bill.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 368, 163);
		pImageVehicle_Bill.add(lblImage);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1312, 175, 210, 163);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnEmptyDelete_Bill = new JButton("Xóa Trống");
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

		txtCMND_Bill.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
		        else
		        {   
		            String to_check=txtCMND_Bill.getText();
		            int to_check_len=to_check.length();
		            for(String data:list_CMND)
		            {
		                String check_from_data="";
		                for(int i=0;i<to_check_len;i++)
		                {
		                    if(to_check_len<=data.length())
		                    {
		                        check_from_data = check_from_data+data.charAt(i);
		                    }
		                }
		                //System.out.print(check_from_data);
		                if(check_from_data.equals(to_check))
		                {
		                    //System.out.print("Found");
		                    txtCMND_Bill.setText(data);
		                    txtCMND_Bill.setSelectionStart(to_check_len);
		                    txtCMND_Bill.setSelectionEnd(data.length());
		                    break;
		                }
		            }
		        }
				Connection con = ConnectDB.getCon();
				String sql = "select * from KhachHang where CMND = ?";
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, txtCMND_Bill.getText());
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						txtCustomerName_Bill.setText(rs.getString("tenKhachHang"));
						txtNumPhone_Bill.setText(rs.getString("soDienThoai"));
						txtNoteCustomer_Bill.setText(rs.getString("chuThich"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
		});
		
		cbbVehicleName_Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbManufacturer.getItemCount() > 0)
					cbbManufacturer.removeAllItems();
				String tenXe;
				if (cbbVehicleName_Bill.getSelectedItem().toString().equalsIgnoreCase(""))
					tenXe = "";
				else
					tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				dao_Hsx.getListHSX(tenXe, cbbManufacturer);
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
		});
		
		cbbManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbVehicleColor_Bill.getItemCount() > 0)
					cbbVehicleColor_Bill.removeAllItems();
				String tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				String hangSanXuat;
				if (cbbManufacturer.getItemCount()==0) 
					hangSanXuat = "";
				else
					hangSanXuat  = cbbManufacturer.getSelectedItem().toString();
				dao_Xe.getListColor(tenXe, hangSanXuat, cbbVehicleColor_Bill);
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
			
		});
		
		cbbVehicleColor_Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbSupplier.getItemCount() > 0)
					cbbSupplier.removeAllItems();
				String tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				String hangSanXuat;
				String mauXe ;
				if (cbbVehicleColor_Bill.getItemCount()==0) 
					mauXe = "";
				else
					mauXe = cbbVehicleColor_Bill.getSelectedItem().toString();
				if (cbbManufacturer.getItemCount()==0) 
					hangSanXuat = "";
				else
					hangSanXuat  = cbbManufacturer.getSelectedItem().toString();
				dao_ncc.getListSupplierName_Bill(tenXe, hangSanXuat, mauXe, cbbSupplier);
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
		});
		
		
		cbbSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenXe, hangSanXuat, mauXe, nhaCungCap;
				if (cbbVehicleName_Bill.getSelectedItem().toString().equalsIgnoreCase(""))
					tenXe = "";
				else
					tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				if (cbbManufacturer.getItemCount()==0) 
					hangSanXuat = "";
				else
					hangSanXuat  = cbbManufacturer.getSelectedItem().toString();
				if (cbbVehicleColor_Bill.getItemCount()==0) 
					mauXe = "";
				else
					mauXe = cbbVehicleColor_Bill.getSelectedItem().toString();
				if (cbbSupplier.getItemCount()==0) 
					nhaCungCap = "";
				else
					nhaCungCap = cbbSupplier.getSelectedItem().toString();
				dao_Xe.getVehicleNum_Bill(tenXe, hangSanXuat, mauXe, nhaCungCap, txtVehicleNum_Bill);
				int soLuong = dao_Xe.getAmountByVehicleID(txtVehicleNum_Bill.getText());
				txtAmount.setModel(new SpinnerNumberModel(1, 1, soLuong, 1));
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
		});
		
		btnAddVehicle_Bill.addMouseListener(new MouseAdapter() {
			public String CheckValueVehicle() {
				if (cbbVehicleName_Bill.getSelectedItem() == null) {
					return "Vui lòng chọn Tên Xe";}
				else if (cbbManufacturer.getSelectedItem() == null)
					return "Vui lòng chọn Hãng Sản Xuất";
				else if (cbbVehicleColor_Bill.getSelectedItem() == null)
					return "Vui lòng chọn Màu Xe";
				else if (cbbSupplier.getSelectedItem() == null)
					return "Vui lòng chọn Nhà Cung Cấp";
				else if (Integer.parseInt(txtAmount.getValue().toString()) == 0)
					return "Số lượng phải lớn hơn 0";
				else
					return null;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (CheckValueVehicle()!= null)
					JOptionPane.showMessageDialog(null, CheckValueVehicle());
				else {
					int soLuong = Integer.parseInt(txtAmount.getValue().toString());
					int soLuongTon = dao_Xe.getAmountByVehicleID(txtVehicleNum_Bill.getText());
					if(soLuong > soLuongTon)
							JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ, giá trị lớn nhất là " + soLuongTon);
					else {
						Xe xe = dao_Xe.getInfoXe(txtVehicleNum_Bill.getText());
						double thanhTien = xe.getDonGia() + xe.getThueVAT();
						tableModel.addRow(new Object[] {xe.getMaXe(), xe.getTenXe(), xe.getMauXe(), xe.getPhanKhoi(), cbbManufacturer.getSelectedItem().toString(), txtAmount.getValue().toString(), df.format(xe.getDonGia()), df.format(xe.getThueVAT()), df.format(thanhTien)});
						double total = 0;
						try {
							total = df.parse(txtTotal.getText()).doubleValue() + thanhTien;
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						txtTotal.setText(String.valueOf(df.format(total)));
					}
						//JOptionPane.showMessageDialog(null, "Xử lý đổ dữ liệu là ok");	
				}
			}
		});
		
		btnDeleteRowTableCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row < 0)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Xe cần xóa khỏi CTHD");
				else
					tableModel.removeRow(row);
			}
		});
		
		btnRemoveCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();
			}
		});
		
		btnPayments.addMouseListener(new MouseAdapter() {
			public boolean CheckPayment() throws HeadlessException, ParseException {
				if (txtCMND_Bill.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Khách Hàng!");
					return false;
				}					
				else if(dao_kh.getKhachHangById(txtCMND_Bill.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Thông tin Khách Hàng không hợp lệ!");
					return false;
				}				
				else if(df.parse(txtTotal.getText()).doubleValue() == 0) {
					JOptionPane.showMessageDialog(null, "Chưa có sản phẩm");
					return false;
				}
				return true;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (CheckPayment()) {
						UI_ThanhToan thanhToan = new UI_ThanhToan();
						thanhToan.setVisible(true);
						thanhToan.txtCusMoney.requestFocus();
					}
				} catch (HeadlessException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});		
	}
}
