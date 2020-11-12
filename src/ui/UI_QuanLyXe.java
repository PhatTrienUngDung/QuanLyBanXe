package ui;

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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.Dao_NhaCungCap;
import dao.Dao_QuanLyXe;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class UI_QuanLyXe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtMau;
	private JTextField txtSoLuong;
	private JTextField txtPhanKhoi;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField txtGiaNhap;
	private JTextField txtImg3;
	private JTextField txtImg2;
	private JTextField txtImg1;
	private JTextField txtTrangThai;
	private JTable table;
	private JTextField txtTim;
	private JTextField textField_18;
	private DefaultTableModel tableModel;
	private Dao_QuanLyXe dao_qlXe= new Dao_QuanLyXe();
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 1527, 817);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1522, 41);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Nhập Xe");
		lblNewLabel.setBounds(11, 1, 295, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 47, 1512, 82);
		
		JLabel lblNewLabel_1 = new JLabel("DANH SÁCH XE NHẬP");
		lblNewLabel_1.setBounds(57, 0, 329, 72);
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setIcon(new ImageIcon("img1/moto.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 131, 1502, 195);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1.setBounds(10, 11, 130, 14);
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtMa = new JTextField();
		txtMa.setBounds(144, 11, 208, 19);
		txtMa.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Tên xe");
		lblNewLabel_2_4_1_1.setBounds(10, 40, 130, 14);
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtTen = new JTextField();
		txtTen.setBounds(144, 40, 208, 19);
		txtTen.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1 = new JLabel("Màu xe");
		lblNewLabel_2_4_1_1_1.setBounds(10, 69, 130, 19);
		lblNewLabel_2_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtMau = new JTextField();
		txtMau.setBounds(144, 69, 208, 19);
		txtMau.setColumns(10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(144, 98, 208, 19);
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_2_4_1_1_1_1.setBounds(10, 98, 130, 19);
		lblNewLabel_2_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtPhanKhoi = new JTextField();
		txtPhanKhoi.setBounds(144, 127, 208, 19);
		txtPhanKhoi.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_1_1_2 = new JLabel("Phân khối");
		lblNewLabel_2_4_1_1_1_2.setBounds(10, 127, 130, 19);
		lblNewLabel_2_4_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_2 = new JLabel("Nhà cung cấp");
		lblNewLabel_2_4_1_2.setBounds(417, 11, 88, 19);
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		ArrayList<NhaCungCap> listNCC= dao_qlXe.getAllNCC();
		JComboBox cbNhaCC = new JComboBox();
		cbNhaCC.setBounds(557, 13, 206, 19);
		cbNhaCC.setEditable(true);
		for (NhaCungCap nhaCungCap : listNCC) {
			cbNhaCC.addItem(nhaCungCap.getMaNhaCungCap());
		}
		
		JLabel lblNewLabel_2_4_1_2_1 = new JLabel("Hãng sản xuất");
		lblNewLabel_2_4_1_2_1.setBounds(417, 43, 130, 19);
		lblNewLabel_2_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		ArrayList<HangSanXuat> listHang=dao_qlXe.getAllHangSX();
		JComboBox cbHangSx = new JComboBox();
		cbHangSx.setBounds(557, 42, 206, 19);
		cbHangSx.setEditable(true);
		for (HangSanXuat hangSanXuat : listHang) {
			cbHangSx.addItem(hangSanXuat.getMaHangSX());
		}
		
		JLabel lblNewLabel_2_4_1_2_2 = new JLabel("Loại xe");
		lblNewLabel_2_4_1_2_2.setBounds(417, 73, 130, 19);
		lblNewLabel_2_4_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		ArrayList<LoaiXe> dsLoai= dao_qlXe.getAllLoaiXe();
		JComboBox cbLoaiXe = new JComboBox();
		cbLoaiXe.setBounds(557, 72, 206, 19);
		cbLoaiXe.setEditable(true);
		for (LoaiXe loaiXe : dsLoai) {
			cbLoaiXe.addItem(loaiXe.getMaLoaiXe());
		}
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setBounds(557, 102, 206, 19);
		txtGiaNhap.setColumns(10);
		
		JLabel lblNewLabel_2_4_1_2_2_2 = new JLabel("Giá nhập");
		lblNewLabel_2_4_1_2_2_2.setBounds(417, 102, 130, 19);
		lblNewLabel_2_4_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_2_2_2_1 = new JLabel("Trạng thái");
		lblNewLabel_2_4_1_2_2_2_1.setBounds(830, 9, 130, 19);
		lblNewLabel_2_4_1_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_4 = new JLabel("Ngày nhập");
		lblNewLabel_2_4_1_4.setBounds(417, 131, 130, 14);
		lblNewLabel_2_4_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_3 = new JLabel("Hình ảnh 1");
		lblNewLabel_2_4_1_1_3.setBounds(830, 42, 130, 14);
		lblNewLabel_2_4_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_1_4 = new JLabel("Hình ảnh 2");
		lblNewLabel_2_4_1_1_1_4.setBounds(830, 71, 130, 19);
		lblNewLabel_2_4_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_1_1_2 = new JLabel("Hình ảnh 3");
		lblNewLabel_2_4_1_1_1_1_2.setBounds(830, 100, 130, 19);
		lblNewLabel_2_4_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_4_1_1_1_2_2 = new JLabel("Chú thích");
		lblNewLabel_2_4_1_1_1_2_2.setBounds(830, 129, 130, 19);
		lblNewLabel_2_4_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtImg3 = new JTextField();
		txtImg3.setEditable(false);
		txtImg3.setBounds(964, 100, 170, 19);
		txtImg3.setColumns(10);
		
		txtImg2 = new JTextField();
		txtImg2.setEditable(false);
		txtImg2.setBounds(964, 71, 170, 19);
		txtImg2.setColumns(10);
		
		txtImg1 = new JTextField();
		txtImg1.setEditable(false);
		txtImg1.setBounds(964, 42, 170, 19);
		txtImg1.setColumns(10);
		panel_2.setLayout(null);
		panel_2.add(panel);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		panel_4.add(lblNewLabel_2_4_1);
		panel_4.add(txtMa);
		panel_4.add(lblNewLabel_2_4_1_1);
		panel_4.add(txtTen);
		panel_4.add(lblNewLabel_2_4_1_1_1);
		panel_4.add(txtMau);
		panel_4.add(lblNewLabel_2_4_1_1_1_1);
		panel_4.add(txtSoLuong);
		panel_4.add(lblNewLabel_2_4_1_1_1_2);
		panel_4.add(txtPhanKhoi);
		panel_4.add(lblNewLabel_2_4_1_2_2_2_1);
		panel_4.add(lblNewLabel_2_4_1_2_2_2);
		panel_4.add(lblNewLabel_2_4_1_2_2);
		panel_4.add(txtGiaNhap);
		panel_4.add(cbLoaiXe);
		panel_4.add(lblNewLabel_2_4_1_2_1);
		panel_4.add(cbHangSx);
		panel_4.add(lblNewLabel_2_4_1_2);
		panel_4.add(cbNhaCC);
		panel_4.add(lblNewLabel_2_4_1_4);
		panel_4.add(lblNewLabel_2_4_1_1_3);
		panel_4.add(txtImg1);
		panel_4.add(lblNewLabel_2_4_1_1_1_4);
		panel_4.add(txtImg2);
		panel_4.add(lblNewLabel_2_4_1_1_1_1_2);
		panel_4.add(txtImg3);
		panel_4.add(lblNewLabel_2_4_1_1_1_2_2);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setEditable(false);
		txtTrangThai.setText("Còn hàng");
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(964, 11, 208, 19);
		panel_4.add(txtTrangThai);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBackground(new Color(231,150,36));
		panel_8.setBounds(1219, 0, 283, 195);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng Số Lượng Xe");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 10, 283, 37);
		panel_8.add(lblNewLabel_4);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_18.setForeground(Color.BLACK);
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setText("1");
		textField_18.setEnabled(false);
		textField_18.setEditable(false);
		textField_18.setBounds(10, 52, 263, 133);
		panel_8.add(textField_18);
		textField_18.setColumns(10);
		
		JTextArea txtCt = new JTextArea();
		txtCt.setBounds(964, 134, 208, 51);
		panel_4.add(txtCt);
		
		JDateChooser dtNgayNhap = new JDateChooser();
		dtNgayNhap.getCalendarButton().setBackground(Color.ORANGE);
		dtNgayNhap.getCalendarButton().setForeground(new Color(0, 0, 0));
		dtNgayNhap.setBounds(557, 129, 208, 19);
		panel_4.add(dtNgayNhap);
		
		JButton btnImg1 = new JButton("...");
		btnImg1.setBackground(Color.LIGHT_GRAY);
		btnImg1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setBackground(Color.gray);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".png .jpg", "png","jpg", "Img");
				fileChooser.setFileFilter(filter);
				
		        int result=fileChooser.showSaveDialog(getParent());
		        if(result==JFileChooser.APPROVE_OPTION) {
		        	File selectFile=fileChooser.getSelectedFile();
		        	if(selectFile==null) {
		        		JOptionPane.showConfirmDialog(null, "Vui lòng chọn hình ảnh !!!");
		        	}
		        	txtImg1.setText(selectFile.getAbsolutePath());
		        }
			}
		});
		btnImg1.setBounds(1138, 40, 34, 22);
		panel_4.add(btnImg1);
		
		JButton btnImg2 = new JButton("...");
		btnImg2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setBackground(Color.gray);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".png .jpg", "png","jpg", "Img");
				fileChooser.setFileFilter(filter);
		        int result=fileChooser.showSaveDialog(getParent());
		        if(result==JFileChooser.APPROVE_OPTION) {
		        	File selectFile=fileChooser.getSelectedFile();
		        	if(selectFile==null) {
		        		JOptionPane.showConfirmDialog(null, "Vui lòng chọn hình ảnh !!!");
		        	}
		        	txtImg2.setText(selectFile.getAbsolutePath());
		        }
			}
		});
		btnImg2.setBackground(Color.LIGHT_GRAY);
		btnImg2.setBounds(1138, 67, 34, 25);
		panel_4.add(btnImg2);
		
		JButton btnImg3 = new JButton("...");
		btnImg3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setBackground(Color.gray);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".png .jpg", "png","jpg", "Img");
				fileChooser.setFileFilter(filter);
		        int result=fileChooser.showSaveDialog(getParent());
		        if(result==JFileChooser.APPROVE_OPTION) {
		        	File selectFile=fileChooser.getSelectedFile();
		        	if(selectFile==null) {
		        		JOptionPane.showConfirmDialog(null, "Vui lòng chọn hình ảnh !!!");
		        	}
		        	txtImg3.setText(selectFile.getAbsolutePath());
		        }
			}
		});
		btnImg3.setBackground(Color.LIGHT_GRAY);
		btnImg3.setBounds(1138, 97, 34, 22);
		panel_4.add(btnImg3);
		String[] header= {"Mã Xe","Tên Xe", "Màu Xe", "Loại Xe", "Nhà cung cấp","Hãng sản xuất","Phân Khối","Số Lượng","Giá Nhập","Ngày Nhập","Trạng Thái","Chú Thích"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 441, 1502, 308);
		panel_2.add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		try {
			loadXe();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(231,150,36));
		panel_6.setBounds(10, 336, 700, 95);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập thông tin cần tìm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 27, 191, 40);
		panel_6.add(lblNewLabel_3);
		
		txtTim = new JTextField();
		txtTim.setBounds(180, 38, 191, 19);
		panel_6.add(txtTim);
		txtTim.setColumns(10);
		
		JButton btnShow = new JButton("Hiển thị tất cả");
		btnShow.setBackground(Color.ORANGE);
		btnShow.setBounds(545, 28, 145, 39);
		panel_6.add(btnShow);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon("G:\\HKI-Nam 3\\QuanLyBanXe\\branches\\Develop\\img1\\search2.png"));
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setBounds(417, 27, 118, 39);
		panel_6.add(btnTimKiem);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(231,150,36));
		panel_7.setBounds(720, 336, 792, 95);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("img1\\add.png"));
		btnThem.setToolTipText("");
		btnThem.setBackground(new Color(255,190,87));
		btnThem.setBounds(20, 28, 125, 36);
		panel_7.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnXoa.setBackground(new Color(255,190,87));
		btnXoa.setBounds(169, 28, 125, 36);
		panel_7.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon("img1\\update.png"));
		btnCapNhat.setBackground(new Color(255,190,87));
		btnCapNhat.setBounds(326, 28, 125, 36);
		panel_7.add(btnCapNhat);
		
		JButton btnXoaTrang = new JButton("Làm tươi");
		btnXoaTrang.setIcon(new ImageIcon("img1\\refresh.png"));
		btnXoaTrang.setBackground(new Color(255,190,87));
		btnXoaTrang.setBounds(482, 28, 125, 36);
		panel_7.add(btnXoaTrang);
		
		JButton btnTT = new JButton("Chi tiết");
		btnTT.setIcon(new ImageIcon("img1\\detail.png"));
		btnTT.setBackground(new Color(255, 190, 87));
		btnTT.setBounds(642, 28, 125, 36);
		panel_7.add(btnTT);
		
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
		contentPane.add(tabbedPane);
	}
	//Hàm load database
		private void loadXe() throws SQLException {
			Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
			tableModel = dao_xe.getAllXe();
			table.setModel(tableModel);
		}
}
