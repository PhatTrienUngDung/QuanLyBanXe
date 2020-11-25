	package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.Dao_HoaDon;
import dao.Dao_NhaCungCap;
import entity.NhaCungCap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;


public class UI_NhaCungCap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNCC;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtTenNCC;
	private JTable table;
	private JTable table_1;
	private JTextField txtTim;
	private JTextField txtDem;
	private DefaultTableModel tableModel;
	private JTextField txtSDT;
	private JTextArea txtChuThich;
	private Dao_NhaCungCap dao_ncc= new Dao_NhaCungCap();
	private ArrayList<String> tenncc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_NhaCungCap frame = new UI_NhaCungCap();
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
	public UI_NhaCungCap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, screen.height);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(UIManager.getBorder("FormattedTextField.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBounds(10, 10, 1600, 767);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 174, 1100, 167);
		panel_4.add(panel);
		panel.setForeground(UIManager.getColor("CheckBox.focus"));
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(10, 38, 1080, 119);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p");
		lblNewLabel.setBounds(10, 10, 123, 21);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p");
		lblTnNhCung.setBounds(10, 41, 123, 21);
		panel_3.add(lblTnNhCung);
		lblTnNhCung.setForeground(Color.BLACK);
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u00FA Th\u00EDch");
		lblNewLabel_1.setBounds(571, 72, 89, 21);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		Dao_HoaDon dao_hd = new Dao_HoaDon();
		String maHDTail = dao_hd.getMaHDTail("maNhaCungCap", "NhaCungCap");
		String[] parts = maHDTail.split("_");
		int soHD = Integer.parseInt(parts[1]) + 1;
		String maKH = "NCC_" + String.format("%04d", soHD);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(146, 11, 294, 19);
		txtMaNCC.setText(maKH);
		txtMaNCC.setEditable(false);
		panel_3.add(txtMaNCC);
		txtMaNCC.setColumns(10);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(146, 42, 294, 19);
		panel_3.add(txtTenNCC);
		txtTenNCC.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(704, 11, 294, 19);
		panel_3.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(704, 42, 294, 19);
		panel_3.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(571, 10, 123, 21);
		panel_3.add(lblEmail);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblaCh.setBounds(571, 41, 89, 21);
		panel_3.add(lblaCh);
		lblaCh.setForeground(Color.DARK_GRAY);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		 txtChuThich = new JTextArea();
		txtChuThich.setBounds(704, 76, 294, 35);
		panel_3.add(txtChuThich);
		txtChuThich.setToolTipText("");
		txtChuThich.setBackground(SystemColor.controlHighlight);
		txtChuThich.setLineWrap(true);
		txtChuThich.setWrapStyleWord(true);
		
		JLabel lblSo = new JLabel("Số điện thoại");
		lblSo.setBounds(10, 72, 123, 21);
		lblSo.setForeground(Color.BLACK);
		lblSo.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblSo);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(146, 73, 294, 19);
		txtSDT.setColumns(10);
		panel_3.add(txtSDT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1134, 174, 358, 167);
		panel_4.add(panel_1);
		panel_1.setBackground(new Color(255, 147, 0));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 204, 0));
		panel_2_1.setBounds(0, 0, 358, 31);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_2_1 = new JLabel("Ch\u1EE9c n\u0103ng");
		lblNewLabel_2_1.setIcon(new ImageIcon("img1\\Settings-icon.png"));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(72, 0, 210, 31);
		panel_2_1.add(lblNewLabel_2_1);
		
		JButton btnThem = new JButton("Th\u00EAm");
		
		// ham them
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThem.setIcon(new ImageIcon("img1/add.png"));
		btnThem.setToolTipText("");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			  if(validData() && XetTenNCC(txtTenNCC.getText())==false) {
				  
						String ma= txtMaNCC.getText();
						String ten=txtTenNCC.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSDT.getText();
						String chuThich=txtChuThich.getText();
						NhaCungCap ncc= new NhaCungCap(ma, ten, diachi, chuThich, sodt, email);
						if(dao_ncc.themNCC(ncc)) {
							String maHDTail = dao_hd.getMaHDTail("maNhaCungCap", "NhaCungCap");
				    		String[] parts = maHDTail.split("_");
				    		int soHD = Integer.parseInt(parts[1]) + 1;
				    		String maKH = "KH_" + String.format("%04d", soHD);
				    		JFrame f= new JFrame();
				    		JOptionPane.showMessageDialog(f, "Thêm hãng sản xuất thành công !!!");
				    		txtMaNCC.setText("");
							txtTenNCC.setText("");
							txtDiaChi.setText("");
							txtEmail.setText("");
							txtSDT.setText("");
							txtChuThich.setText("");
							txtTenNCC.requestFocus();
				    		tableModel.addRow(new Object[] {ncc.getMaNhaCungCap(),ncc.getTenNhaCungCap(),ncc.getDiaChi(),ncc.getEmail(),ncc.getSoDienThoai(),ncc.getChuThich()});
				    		dem();
						}	
				
			  }else {
				  JOptionPane.showMessageDialog(null, "Đã trùng tên nhà cung cấp");
			  }
				
				
			}
		});
		/*
		 * Image img = new
		 * ImageIcon(this.getClass().getResource("/add.ico")).getImage();
		 */
		btnThem.setBackground(Color.ORANGE);
		btnThem.setBounds(20, 52, 142, 36);
		panel_1.add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setIcon(new ImageIcon("G:\\HKI-Nam 3\\PTUD\\QuanLyBanXe\\branches\\Develop\\img1\\Close-2-icon.png"));
		
		
		// ham xoa
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp này sẽ bị xóa","Chú ý", JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r= table_1.getSelectedRow();
							tableModel.removeRow(r);
							xoaNCC();
							dem();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setBounds(199, 52, 142, 36);
		panel_1.add(btnXoa);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		
		//ham cap nhat
		btnCapNhat.setIcon(new ImageIcon("img1/update.png"));
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
			 if(validData()) {
				 try {
						if(row!=-1) {
							JFrame f= new JFrame();
							int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp sẽ được cập nhật","",JOptionPane.YES_NO_OPTION);
							if(hoi==JOptionPane.YES_OPTION) {
								String ma= txtMaNCC.getText();
								String ten=txtTenNCC.getText();
								String diachi=txtDiaChi.getText();
								String email= txtEmail.getText();
								String sodt= txtSDT.getText();
								String chuThich=txtChuThich.getText();
								NhaCungCap ncc= new NhaCungCap(ma, ten, diachi, chuThich, sodt, email);
								if(dao_ncc.update(ncc)) {
									update();
									JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
								}
								txtMaNCC.setText("");
								txtTenNCC.setText("");
								txtDiaChi.setText("");
								txtEmail.setText("");
								txtSDT.setText("");
								txtChuThich.setText("");
								txtTenNCC.requestFocus();
								try {
									loadNCC();
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần cập nhật");
					} catch (Exception e2) {
						// TODO: handle exception
					}
			 }
				
			}
		});
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setBounds(20, 110, 142, 36);
		panel_1.add(btnCapNhat);
		
		JButton btnXoaTrang = new JButton("L\u00E0m t\u01B0\u01A1i");
		btnXoaTrang.setIcon(new ImageIcon("img1/refresh.png"));
		btnXoaTrang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMaNCC.setText("");
				txtTenNCC.setText("");
				txtDiaChi.setText("");
				txtEmail.setText("");
				txtSDT.setText("");
				txtChuThich.setText("");
				txtTenNCC.requestFocus();
			}
		});
		btnXoaTrang.setBackground(Color.ORANGE);
		btnXoaTrang.setBounds(199, 110, 142, 36);
		panel_1.add(btnXoaTrang);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.control);
		panel_6.setBounds(10, 421, 1482, 313);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		String[] header= {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại","Ghi Chú"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(0, 0, 1483, 303);
		panel_6.add(scrollPane);
		table_1 = new JTable(tableModel);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				txtMaNCC.setText(tableModel.getValueAt(i, 0).toString());
				txtTenNCC.setText(tableModel.getValueAt(i, 1).toString());
				txtDiaChi.setText(tableModel.getValueAt(i, 2).toString());
				txtEmail.setText(tableModel.getValueAt(i, 3).toString());
				txtSDT.setText(tableModel.getValueAt(i, 4).toString());
				txtChuThich.setText(tableModel.getValueAt(i, 5).toString());
			}
		});
		table_1.setBorder(null);
		scrollPane.setViewportView(table_1);
		//Load Dá»¯ liá»‡u lÃªn báº£ng
		try {
			loadNCC();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 351, 1100, 60);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nhập mã nhà cung cấp cần tìm");
		lblNewLabel_4.setForeground(new Color(0, 128, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Nhập mã nhà cung cấp cần tìm");
		lblNewLabel_5.setForeground(new Color(0, 128, 0));

		JLabel lblNewLabel_6 = new JLabel("Nhập thông tin nhà cung cấp cần tìm");
		lblNewLabel_6.setForeground(Color.BLACK);

		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 14, 190, 27);
		panel_7.add(lblNewLabel_4);
		
		txtTim = new JTextField();
		txtTim.setBounds(209, 18, 228, 19);
		panel_7.add(txtTim);
		txtTim.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Tìm Kiếm");
		btnNewButton_4.setIcon(new ImageIcon("img1\\search2.png"));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					timNCC();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBackground(Color.ORANGE);
		btnNewButton_4.setBounds(468, 11, 118, 39);
		panel_7.add(btnNewButton_4);
		
		JButton btnShow = new JButton("Hiển Thị Tất Cả");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					loadNCC();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBackground(Color.ORANGE);
		btnShow.setBounds(596, 11, 145, 39);
		panel_7.add(btnShow);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(1134, 351, 358, 60);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_7= new JLabel("Số lượng nhà cung cấp :");
		lblNewLabel_7.setForeground(new Color(0, 128, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(47, 10, 154, 40);
		panel_8.add(lblNewLabel_7);
		
		
		txtDem = new JTextField();
		txtDem.setEditable(false);
		txtDem.setForeground(Color.RED);
		txtDem.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDem.setBackground(new Color(255, 255, 255));
		txtDem.setHorizontalAlignment(SwingConstants.CENTER);
		txtDem.setBounds(211, 18, 79, 28);
		panel_8.add(txtDem);
		txtDem.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 1535, 78);
		panel_4.add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("QUẢN LÝ THÔNG TIN NHÀ CUNG CẤP");
		lblNewLabel_1_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 88, 497, 72);
		panel_4.add(lblNewLabel_1_1);
		dem();
		table = new JTable();
	
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 267, 1181, -260);
	}
	//
	//HÃ m load database
	private void loadNCC() throws SQLException {
		Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		tableModel = dao_ncc.getAllNCC();
		table_1.setModel(tableModel);
	}
	//HÃ m xÃ³a 
	private void xoaNCC() throws SQLException {
		Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		dao_ncc.xoaNCC(txtMaNCC.getText());
		//loadNCC();
	}
	
	private void update() {
		for(int i =0 ; i<table.getRowCount();i++) {
			if(txtMaNCC.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString())) {
				table.setValueAt(txtTenNCC.getText(),i, 1);
				table.setValueAt(txtDiaChi.getText(),i, 2);
				table.setValueAt(txtEmail.getText(),i, 3);
				table.setValueAt(txtSDT.getText(),i, 4);
				table.setValueAt(txtChuThich.getText(),i, 5);
				
				
			}
		}
	}
	//TÃ¬m kiáº¿m
	private void timNCC() throws SQLException{
		Dao_NhaCungCap dao_ncc= new Dao_NhaCungCap();
		tableModel = dao_ncc.timKiem(txtTim.getText());
		table_1.setModel(tableModel);
	}
	public void dem() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql = "select count(maNhaCungCap) from nhaCungCap ";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				String count=rs.getString(1);
				txtDem.setText(count);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public ArrayList<String> xettenncc() {
		tenncc = new ArrayList<String>();
		try {
			Connection con = ConnectDB.getInstance().getCon();
			String sql = "Select tenNhaCungCap from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ten;
				ten = rs.getString(1);
				tenncc.add(ten);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return tenncc;
	}
	public boolean XetTenNCC(String ten) {
		List<String> list = xettenncc();
		for(String i:list) {
			if(i.equalsIgnoreCase(ten))
				return true;
			
		}
		return false;
	}
	
	
	private boolean validData() {
		//String mancc = txtMaNCC.getText();
		String tenncc = txtTenNCC.getText();
		String sodt = txtSDT.getText();
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String chuThich = txtChuThich.getText();
		if(!(tenncc.length()>0 && tenncc.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s/\\\\\\\\.]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không để trống và không chứa các ký tự đặc biệt và không trùng" );
			return false;
		}
		if(!(sodt.length()>0 && sodt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được trống và phải có 10 số" );
			return false;
		}
		if(!(diaChi.length()>0 && diaChi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s/\\\\\\\\.,]+$"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không trống và không chứa kí tự đặc biệt " );
			return false;
		}
		if(!( chuThich.length()>0 &&  chuThich.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Ghi chú không được trống và không chứa kí tự đặc biệt " );
			return false;
		}
		return true;
	}
}
