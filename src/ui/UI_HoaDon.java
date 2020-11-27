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
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import autoComplete.FillCombo;
import connect.ConnectDB;
import dao.Dao_HangSanXuat;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_NhaCungCap;
import dao.Dao_NhanVien;
import dao.Dao_QuanLyXe;
import dao.Dao_TaiKhoan;
import entity.HangSanXuat;
import entity.KhachHang;
import entity.NhaCungCap;
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
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class UI_HoaDon extends JFrame {

	private JPanel contentPane;
	public static JTable table;
	public static JTextField txtTotal = new JTextField();
	public static JTextField txtBillNum;
	public static String maKhachHang;
	public static JTextField txtEmployeeNum_Bill;
	public static JTextField txtDateBill;
	public static double thueVAT;
	public static DefaultTableModel tableModel;
	public static JTextField txtCMND_Bill;
    public static JTextField txtNumPhone_Bill;
    public static JTextField txtCustomerName_Bill;
    public static JTextArea txtNoteCustomer_Bill;
    public static JComboBox cbbVehicleName_Bill;
    

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
		Dao_HoaDon dao_hd = new Dao_HoaDon();
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		List<String> list_CMND = dao_kh.getListCMND();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		//setBounds(0, 0, 1113, 614);
		setBounds(0, 0, width, height);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pGenInfo_Bill = new JPanel();
		pGenInfo_Bill.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin Chung", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pGenInfo_Bill.setBackground(SystemColor.control);
		pGenInfo_Bill.setBounds(10, 181, 905, 106);
		contentPane.add(pGenInfo_Bill);
		pGenInfo_Bill.setLayout(null);
		
		JPanel pCustomerInfo_Bill = new JPanel();
		pCustomerInfo_Bill.setBackground(SystemColor.control);
		pCustomerInfo_Bill.setBounds(10, 20, 890, 76);
		pGenInfo_Bill.add(pCustomerInfo_Bill);
		pCustomerInfo_Bill.setLayout(null);
		
		JLabel lblCustomerNum_Bill = new JLabel("CMND");
		lblCustomerNum_Bill.setBounds(10, 12, 87, 21);
		lblCustomerNum_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		pCustomerInfo_Bill.add(lblCustomerNum_Bill);
		
		txtCMND_Bill = new JTextField();
		txtCMND_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCMND_Bill.setBounds(100, 10, 250, 21);
		pCustomerInfo_Bill.add(txtCMND_Bill);
		
		JLabel lblNumPhone_Bill = new JLabel("SĐT");
		lblNumPhone_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumPhone_Bill.setBounds(10, 41, 45, 21);
		pCustomerInfo_Bill.add(lblNumPhone_Bill);
		
		txtNumPhone_Bill = new JTextField();
		txtNumPhone_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumPhone_Bill.setBounds(100, 39, 250, 21);
		pCustomerInfo_Bill.add(txtNumPhone_Bill);
		
		JLabel lblCustomerName_Bill = new JLabel("Tên Khách Hàng");
		lblCustomerName_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCustomerName_Bill.setBounds(405, 12, 128, 21);
		pCustomerInfo_Bill.add(lblCustomerName_Bill);
		
		txtCustomerName_Bill = new JTextField();
		txtCustomerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCustomerName_Bill.setBounds(570, 10, 310, 21);
		pCustomerInfo_Bill.add(txtCustomerName_Bill);
		
		JLabel lblNote_Bill = new JLabel("Chú Thích");
		lblNote_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNote_Bill.setBounds(405, 43, 87, 21);
		pCustomerInfo_Bill.add(lblNote_Bill);
		
		txtNoteCustomer_Bill = new JTextArea();
		txtNoteCustomer_Bill.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNoteCustomer_Bill.setBounds(570, 41, 310, 23);
		pCustomerInfo_Bill.add(txtNoteCustomer_Bill);
		
		JPanel pOtherInfo_Bill = new JPanel();
		pOtherInfo_Bill.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin Kh\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pOtherInfo_Bill.setBackground(SystemColor.control);
		pOtherInfo_Bill.setBounds(925, 181, 598, 106);
		contentPane.add(pOtherInfo_Bill);
		pOtherInfo_Bill.setLayout(null);
		
		JPanel pEmployeeInfo_Bill = new JPanel();
		pEmployeeInfo_Bill.setBounds(10, 20, 574, 76);
		pOtherInfo_Bill.add(pEmployeeInfo_Bill);
		pEmployeeInfo_Bill.setLayout(null);
		
		JLabel lblEmployee_Bill = new JLabel("Nhân Viên");
		lblEmployee_Bill.setBackground(new Color(230, 230, 250));
		lblEmployee_Bill.setBounds(10, 12, 87, 21);
		lblEmployee_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		pEmployeeInfo_Bill.add(lblEmployee_Bill);	
		
		txtEmployeeNum_Bill = new JTextField();
		txtEmployeeNum_Bill.setEditable(false);
		//txtEmployeeNum_Bill.setText(Login.txtuser.getText());
		txtEmployeeNum_Bill.setBackground(Color.WHITE);
		txtEmployeeNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmployeeNum_Bill.setBounds(140, 10, 168, 21);
		pEmployeeInfo_Bill.add(txtEmployeeNum_Bill);
		
		JTextField txtEmployeeName_Bill = new JTextField();
		txtEmployeeName_Bill.setEditable(false);
		txtEmployeeName_Bill.setText(dao_nv.getTenNhanVienById(txtEmployeeNum_Bill.getText()));
		txtEmployeeName_Bill.setBackground(Color.WHITE);
		txtEmployeeName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmployeeName_Bill.setBounds(320, 10, 244, 21);
		pEmployeeInfo_Bill.add(txtEmployeeName_Bill);
		
		JLabel lblBillNum = new JLabel("Mã Hóa Đơn");
		lblBillNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBillNum.setBounds(10, 45, 92, 21);
		pEmployeeInfo_Bill.add(lblBillNum);
		
		/*String a = "MHD0005";
		String[] parts = a.split("D");
		System.out.println(parts[1]);*/
		
		String maHD = dao_hd.getMaHDTail("maHoaDon", "HoaDon");
		
		txtBillNum = new JTextField();
		txtBillNum.setEditable(false);
		txtBillNum.setText(maHD);
		txtBillNum.setBackground(Color.WHITE);
		txtBillNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBillNum.setBounds(140, 43, 168, 23);
		pEmployeeInfo_Bill.add(txtBillNum);
		
		JLabel lblBillDate = new JLabel("Ngày LHD");
		lblBillDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBillDate.setBounds(320, 45, 86, 21);
		pEmployeeInfo_Bill.add(lblBillDate);
		
		txtDateBill = new JTextField();
		txtDateBill.setEditable(false);
		txtDateBill.setBackground(Color.WHITE);
		txtDateBill.setText(LocalDate.now().toString());
		txtDateBill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateBill.setBounds(414, 43, 150, 22);
		pEmployeeInfo_Bill.add(txtDateBill);
		
		JPanel pProduct_Bill = new JPanel();
		pProduct_Bill.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin Xe", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pProduct_Bill.setBackground(SystemColor.control);
		pProduct_Bill.setBounds(10, 305, 905, 137);
		contentPane.add(pProduct_Bill);
		pProduct_Bill.setLayout(null);
		
		JPanel pAddVehicle_Bill = new JPanel();
		pAddVehicle_Bill.setToolTipText("");
		pAddVehicle_Bill.setBounds(10, 21, 890, 102);
		pProduct_Bill.add(pAddVehicle_Bill);
		pAddVehicle_Bill.setLayout(null);
		
		JLabel lblVehicleNum_Bill = new JLabel("Mã Xe");
		lblVehicleNum_Bill.setBounds(10, 12, 44, 21);
		lblVehicleNum_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		pAddVehicle_Bill.add(lblVehicleNum_Bill);
		
		JLabel lblVehicleName_Bill = new JLabel("Tên Xe");
		lblVehicleName_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleName_Bill.setBounds(405, 12, 60, 21);
		pAddVehicle_Bill.add(lblVehicleName_Bill);
		
		cbbVehicleName_Bill = new JComboBox();
		cbbVehicleName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbVehicleName_Bill.setBackground(Color.WHITE);
		cbbVehicleName_Bill.setBounds(570, 10, 290, 21);
		pAddVehicle_Bill.add(cbbVehicleName_Bill);
		
		FillCombo combo = new FillCombo();
		try {
			combo.fill("select DISTINCT tenXe from Xe where soLuong > 0 order by tenXe" , cbbVehicleName_Bill, "tenXe");	
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		
		JComboBox cbbVehicleColor_Bill = new JComboBox();
		cbbVehicleColor_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbVehicleColor_Bill.setBackground(Color.WHITE);
		cbbVehicleColor_Bill.setBounds(570, 43, 132, 21);
		pAddVehicle_Bill.add(cbbVehicleColor_Bill);
		
		JLabel lblVehicleColor_Bill = new JLabel("Màu Xe");
		lblVehicleColor_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleColor_Bill.setBounds(405, 45, 68, 21);
		pAddVehicle_Bill.add(lblVehicleColor_Bill);
		
		JTextField txtVehicleNum_Bill = new JTextField();
		txtVehicleNum_Bill.setEditable(false);
		txtVehicleNum_Bill.setBackground(Color.white);
		txtVehicleNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVehicleNum_Bill.setBounds(115, 10, 203, 21);
		pAddVehicle_Bill.add(txtVehicleNum_Bill);
		
		JLabel lblManufacturerName_Bill = new JLabel("Phiên bản");
		lblManufacturerName_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblManufacturerName_Bill.setBounds(10, 43, 68, 21);
		pAddVehicle_Bill.add(lblManufacturerName_Bill);
		
		JComboBox cbbVersion = new JComboBox();
		cbbVersion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbVersion.setBackground(Color.WHITE);
		cbbVersion.setBounds(115, 41, 203, 21);
		pAddVehicle_Bill.add(cbbVersion);
		
		JLabel lblAmountVehicle_Bill = new JLabel("Số Lượng");
		lblAmountVehicle_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAmountVehicle_Bill.setBounds(405, 76, 70, 21);
		pAddVehicle_Bill.add(lblAmountVehicle_Bill);
		
		JSpinner txtAmount = new JSpinner();
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAmount.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		txtAmount.setBounds(570, 74, 132, 21);
		pAddVehicle_Bill.add(txtAmount);
		
		JLabel lblSupplier_Bill = new JLabel("Nhà Cung Cấp");
		lblSupplier_Bill.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSupplier_Bill.setBounds(10, 74, 95, 21);
		pAddVehicle_Bill.add(lblSupplier_Bill);
		
		JComboBox cbbSupplier = new JComboBox();
		cbbSupplier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbSupplier.setBounds(115, 74, 203, 21);
		pAddVehicle_Bill.add(cbbSupplier);
		
		JPanel pBillDetailsList = new JPanel();
		pBillDetailsList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch Xe B\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pBillDetailsList.setBackground(SystemColor.control);
		pBillDetailsList.setBounds(10, 452, 1513, 245);
		contentPane.add(pBillDetailsList);
		pBillDetailsList.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 25, 1498, 210);
		pBillDetailsList.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		String[] header = {"Mã Xe", "Tên Xe", "Phiên Bản", "Màu xe", "Phân Khối", "Hãng Sản Xuất", "Số Lượng", "Đơn Giá", "Thuế VAT", "Thành tiền"};
		tableModel = new DefaultTableModel(header, 0){
	       @Override
	       public boolean isCellEditable(int i, int i1) {
	           return false; //To change body of generated methods, choose Tools | Templates.
	       }
		};
		//DefaultTableModel tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		scrollPane_1.setViewportView(table);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		//table.setBorder(BorderFactory.createLineBorder(Color.white));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(231,150,36));
		panel.setBounds(461, 703, 473, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalBill = new JLabel("Tổng Tiền");
		lblTotalBill.setBounds(37, 24, 88, 19);
		lblTotalBill.setForeground(new Color(255, 0, 0));
		lblTotalBill.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalBill.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblTotalBill);
		txtTotal.setForeground(Color.RED);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setEditable(false);
		
		//txtTotal = new TextField();
		txtTotal.setText("0 VNĐ");
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTotal.setBounds(131, 21, 308, 22);
		panel.add(txtTotal);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(231,150,36));
		panel_1.setBounds(943, 703, 580, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnDeleteRowTableCTHD = new JButton("Xóa Xe CTHD");	
		btnDeleteRowTableCTHD.setBackground(new Color(255, 69, 0));
		btnDeleteRowTableCTHD.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/delete-icon.png")));
		btnDeleteRowTableCTHD.setBounds(10, 6, 191, 45);
		btnDeleteRowTableCTHD.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_1.add(btnDeleteRowTableCTHD);
		
		JButton btnRemoveCTHD = new JButton("Hủy CTHD");
		btnRemoveCTHD.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Status-dialog-error-icon.png")));
		btnRemoveCTHD.setBackground(Color.RED);
		btnRemoveCTHD.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRemoveCTHD.setBounds(211, 6, 175, 45);
		panel_1.add(btnRemoveCTHD);
		
		JButton btnPayments = new JButton("Thanh Toán");
		btnPayments.setBackground(Color.ORANGE);
		btnPayments.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/coin-icon.png")));
		btnPayments.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPayments.setBounds(396, 6, 175, 45);
		panel_1.add(btnPayments);
		
		JPanel pImageVehicle_Bill = new JPanel();
		pImageVehicle_Bill.setBorder(new LineBorder(new Color(0, 0, 0)));
		pImageVehicle_Bill.setBounds(925, 305, 373, 137);
		contentPane.add(pImageVehicle_Bill);
		pImageVehicle_Bill.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 373, 145);
		pImageVehicle_Bill.add(lblImage);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(231,150,36));
		panel_2.setBounds(1308, 305, 215, 137);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnEmptyDelete_Bill = new JButton("Xóa Trống");
		btnEmptyDelete_Bill.setBackground(new Color(255,190,87));
		btnEmptyDelete_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Recycle-Bin-Full-icon.png")));
		btnEmptyDelete_Bill.setBounds(26, 10, 160, 51);
		btnEmptyDelete_Bill.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_2.add(btnEmptyDelete_Bill);
		
		JButton btnAddVehicle_Bill = new JButton("Th\u00EAm Xe");
		btnAddVehicle_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/sign-add-icon.png")));
		btnAddVehicle_Bill.setBackground(new Color(255,190,87));
		btnAddVehicle_Bill.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAddVehicle_Bill.setBounds(26, 84, 160, 51);
		panel_2.add(btnAddVehicle_Bill);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(0, 0, 1530, 78);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ THÔNG TIN HÓA ĐƠN");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 88, 526, 72);
		contentPane.add(lblNewLabel_1);

//====================Xử lý eventAction============================

		//>>>>>>>>>>> txt CMND
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
				/*Connection con = ConnectDB.getCon();
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
				}*/
				KhachHang kh = dao_kh.getKhachHangById("CMND", txtCMND_Bill.getText());
				if(kh != null) {
					txtCustomerName_Bill.setText(kh.getTenKhachHang());
					txtNumPhone_Bill.setText(kh.getSoDienThoai());
					txtNoteCustomer_Bill.setText(kh.getChuThich());
				}
				else {
					txtCustomerName_Bill.setText("");
					txtNumPhone_Bill.setText("");
					txtNoteCustomer_Bill.setText("");
				}
			}
		});
		
		//>>>>>>>>>>> cbb Vehicle Name
		cbbVehicleName_Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbVersion.getItemCount() > 0)
					cbbVersion.removeAllItems();
				String tenXe;
				if (cbbVehicleName_Bill.getSelectedItem().toString().equalsIgnoreCase(""))
					tenXe = "";
				else
					tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				dao_Xe.getListVersion(tenXe, cbbVersion);
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
		});
		
		//>>>>>>>>>>> cbb Version Vehicle
		cbbVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbVehicleColor_Bill.getItemCount() > 0)
					cbbVehicleColor_Bill.removeAllItems();
				String tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				String version;
				if (cbbVersion.getItemCount()==0) 
					version = "";
				else
					version = cbbVersion.getSelectedItem().toString();
				dao_Xe.getListColor(tenXe, version, cbbVehicleColor_Bill);
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
			
		});
		
		//>>>>>>>>>>> cbb  Vehicle Color
		cbbVehicleColor_Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbSupplier.getItemCount() > 0)
					cbbSupplier.removeAllItems();
				String tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				String version;
				String mauXe ;
				if (cbbVehicleColor_Bill.getItemCount()==0) 
					mauXe = "";
				else
					mauXe = cbbVehicleColor_Bill.getSelectedItem().toString();
				if (cbbVersion.getItemCount()==0) 
					version = "";
				else
					version  = cbbVersion.getSelectedItem().toString();
				dao_ncc.getListSupplierName_Bill(tenXe, version, mauXe, cbbSupplier);
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
		});
		
		//>>>>>>>>>>> cbb Supplier 
		cbbSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenXe, version, mauXe, nhaCungCap;
				if (cbbVehicleName_Bill.getSelectedItem().toString().equalsIgnoreCase(""))
					tenXe = "";
				else
					tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
				if (cbbVersion.getItemCount()==0) 
					version = "";
				else
					version  = cbbVersion.getSelectedItem().toString();
				if (cbbVehicleColor_Bill.getItemCount()==0) 
					mauXe = "";
				else
					mauXe = cbbVehicleColor_Bill.getSelectedItem().toString();
				if (cbbSupplier.getItemCount()==0) 
					nhaCungCap = "";
				else
					nhaCungCap = cbbSupplier.getSelectedItem().toString();
				dao_Xe.getVehicleNum_Bill(tenXe, version, mauXe, nhaCungCap, txtVehicleNum_Bill);
				int soLuong = dao_Xe.getAmountByVehicleID(txtVehicleNum_Bill.getText());
				txtAmount.setModel(new SpinnerNumberModel(1, 1, soLuong, 1));
				boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
		});
		
		//>>>>>>>>>>> tbl Table
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int viTriDongVuaBam = table.getSelectedRow();
				 txtVehicleNum_Bill.setText(table.getValueAt(viTriDongVuaBam, 0).toString());
				 Xe xe = dao_Xe.getInfoXe(table.getValueAt(viTriDongVuaBam, 0).toString());
			
				 int sl = cbbVehicleName_Bill.getItemCount();
				 for (int i = 0; i<sl; i++) {
					 if(cbbVehicleName_Bill.getItemAt(i).toString().equalsIgnoreCase(xe.getTenXe())) {
						 cbbVehicleName_Bill.setSelectedIndex(i);
						 break;
					 }
				 }
				 
				 sl = cbbVersion.getItemCount();
				 
				 for (int i = 0; i<sl; i++) {
					 if(cbbVersion.getItemAt(i).toString().equalsIgnoreCase(xe.getPhienBan())) {
						 cbbVersion.setSelectedIndex(i);
						 break;
					 }
				 }
				 
				 sl = cbbVehicleColor_Bill.getItemCount();
				 for (int i = 0; i<sl; i++) {
					 if(cbbVehicleColor_Bill.getItemAt(i).toString().equalsIgnoreCase(xe.getMauXe())) {
						 cbbVehicleColor_Bill.setSelectedIndex(i);
						 break;
					 }
				 }
				 
				 NhaCungCap ncc = dao_ncc.getTenNhaCCById(xe.getNhaCungCap().getMaNhaCungCap());
				 
				 sl = cbbSupplier.getItemCount();
				 for (int i = 0; i<sl; i++) {
					 if(cbbSupplier.getItemAt(i).toString().equalsIgnoreCase(ncc.getTenNhaCungCap())) {
						 cbbSupplier.setSelectedIndex(i);
						 break;
					 }
				 }
				 
				 txtAmount.setValue(Integer.parseInt(table.getValueAt(viTriDongVuaBam, 6).toString()));
				 boolean check = dao_Xe.getImage(lblImage, txtVehicleNum_Bill.getText());
			}
		});
	
//====================UPDATE DATA============================
		
		// update CMND Customer
		pCustomerInfo_Bill.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				String cmndKHTail = list_CMND.get(list_CMND.size()-1);
				KhachHang kh = dao_kh.getKhachHangTail();
				if (list_CMND.get(list_CMND.size()-1).equalsIgnoreCase(kh.getCMND())) {
					
				} else {
					list_CMND.add(kh.getCMND());
				}		
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		/*// update Vehicle Name
		pAddVehicle_Bill.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				try {
					combo.fill("select DISTINCT tenXe from Xe where soLuong > 0" , cbbVehicleName_Bill, "tenXe");	
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});*/
		
		
//====================Xử lý button============================
		
		//>>>>>>>>>>> ADD Vehicle
		btnAddVehicle_Bill.addMouseListener(new MouseAdapter() {
			public String CheckValueVehicle() {
				if (cbbVehicleName_Bill.getSelectedItem() == null) {
					return "Vui lòng chọn Tên Xe";}
				else if (cbbVersion.getSelectedItem() == null)
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
					int choose = 0;
					int i = 0;
					double dongia = 0;
					Xe xe = dao_Xe.getInfoXe(txtVehicleNum_Bill.getText());
					double thanhTien = 0;
					double total = 0;
					for (i = 0 ; i<table.getRowCount(); i++) {
						if(table.getValueAt(i, 0).toString().equalsIgnoreCase(txtVehicleNum_Bill.getText())) {
							//soLuong += Integer.parseInt(table.getValueAt(i, 5).toString());
							choose = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn chèn thông tin Xe đã có?");
							if (choose == 0) {
								try { 
									double tien = df.parse(table.getValueAt(i, 9).toString()).doubleValue();
									table.setValueAt(soLuong, i, 6);
									thanhTien = (xe.getDonGia() + xe.getThueVAT())*soLuong;
									table.setValueAt(df.format(thanhTien), i, 9);
									total = df.parse(txtTotal.getText()).doubleValue();
									total -= tien;
									total += thanhTien;
									//System.out.println(df.format(total));
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							break;
						}
					}
					if (i == table.getRowCount()) {
						thanhTien = (xe.getDonGia() + xe.getThueVAT())*soLuong;
						HangSanXuat hsx = dao_Hsx.getHangSanXuatById(xe.getHangSanXuat().getMaHangSX());
						tableModel.addRow(new Object[] {xe.getMaXe(), xe.getTenXe(), xe.getPhienBan(), xe.getMauXe(), xe.getPhanKhoi(), hsx.getTenHangSX(), txtAmount.getValue().toString(), df.format(xe.getDonGia()), df.format(xe.getThueVAT()), df.format(thanhTien)});
						try {
							total = df.parse(txtTotal.getText()).doubleValue();
							total += thanhTien;
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
					txtTotal.setText(String.valueOf(df.format(total)));
				}
			}
		});
		
		//>>>>>>>>>>> DELETE Vehicle
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
		
		//>>>>>>>>>>> REMOVE CTHD
		btnRemoveCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();
			}
		});
		
		//>>>>>>>>>>> PAYMENTS
		btnPayments.addMouseListener(new MouseAdapter() {
			public boolean CheckPayment() throws HeadlessException, ParseException {
				if (txtCMND_Bill.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Khách Hàng!");
					return false;
				}					
				else if(dao_kh.getKhachHangById("CMND",txtCMND_Bill.getText()) == null) {
					KhachHang kh = dao_kh.getKhachHangById("CMND",txtCMND_Bill.getText());
					JOptionPane.showMessageDialog(null, "Thông tin Khách Hàng không hợp lệ!");
					return false;
				}				
				else if(df.parse(txtTotal.getText()).doubleValue() == 0) {
					JOptionPane.showMessageDialog(null, "Chưa có sản phẩm");
					return false;
				}
				if(txtCMND_Bill.getText().length()==0) 
					maKhachHang = "";
				else
					maKhachHang = dao_kh.getKhachHangById("CMND",txtCMND_Bill.getText()).getMaKhachHang();
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
