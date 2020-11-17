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
import dao.Dao_QuanLyXe;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UI_QuanLyXe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel getContentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtMau;
	private JTextField txtSoLuong;
	private JTextField txtPhanKhoi;
	private JTextField txtGiaNhap;
	private JTextField txtImg3;
	private JTextField txtImg2;
	private JTextField txtImg1;
	private JTextField txtTrangThai;
	private JTable table;
	private JTextField txtTim;
	private JTextField txtDem;
	private DefaultTableModel tableModel;
	private Dao_QuanLyXe dao_qlXe= new Dao_QuanLyXe();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_2;
	private JTextField textField_6;
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
	@SuppressWarnings("unchecked")
	public UI_QuanLyXe() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, (screen.height-50));
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		getContentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new CustomTabbedPaneUI());
		tabbedPane.setBounds(5, 5, 1527, 743);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Quản lý nhập xe", new ImageIcon("img1\\moto.png"), panel_2, null);
		
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
		@SuppressWarnings("rawtypes")
		JComboBox cbNhaCC = new JComboBox();
		cbNhaCC.setBounds(557, 13, 206, 19);
		cbNhaCC.setEditable(true);
		for (NhaCungCap nhaCungCap : listNCC) {
			cbNhaCC.addItem(nhaCungCap.getTenNhaCungCap());
		}
		
		JLabel lblNewLabel_2_4_1_2_1 = new JLabel("Hãng sản xuất");
		lblNewLabel_2_4_1_2_1.setBounds(417, 43, 130, 19);
		lblNewLabel_2_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		ArrayList<HangSanXuat> listHang=dao_qlXe.getAllHangSX();
		@SuppressWarnings("rawtypes")
		JComboBox cbHangSx = new JComboBox();
		cbHangSx.setBounds(557, 42, 206, 19);
		cbHangSx.setEditable(true);
		for (HangSanXuat hangSanXuat : listHang) {
			cbHangSx.addItem(hangSanXuat.getTenHangSX());
		}
		
		JLabel lblNewLabel_2_4_1_2_2 = new JLabel("Loại xe");
		lblNewLabel_2_4_1_2_2.setBounds(417, 73, 130, 19);
		lblNewLabel_2_4_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		ArrayList<LoaiXe> dsLoai= dao_qlXe.getAllLoaiXe();
		@SuppressWarnings("rawtypes")
		JComboBox cbLoaiXe = new JComboBox();
		cbLoaiXe.setBounds(557, 72, 206, 19);
		cbLoaiXe.setEditable(true);
		for (LoaiXe loaiXe : dsLoai) {
			cbLoaiXe.addItem(loaiXe.getTenLoaiXe());
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
		
		txtDem = new JTextField();
		txtDem.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDem.setForeground(Color.BLACK);
		txtDem.setHorizontalAlignment(SwingConstants.CENTER);
		txtDem.setText("1");
		txtDem.setEnabled(false);
		txtDem.setEditable(false);
		txtDem.setBounds(10, 52, 263, 133);
		panel_8.add(txtDem);
		txtDem.setColumns(10);
		dem();
		JTextArea txtCt = new JTextArea();
		txtCt.setBounds(964, 134, 208, 51);
		panel_4.add(txtCt);
		
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
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(557, 127, 206, 19);
		panel_4.add(dateChooser_1);
		dateChooser_1.setDate(Date.valueOf(LocalDate.now()));
		String[] header= {"Mã Xe","Tên Xe", "Màu xe","Loại xe", "Hãng sản xuất","Nhà cung cấp","Quốc gia","Phân khối","Số lượng","Giá nhập","Ngày nhập","Trạng thái","Chú thích", "Tổng tiền"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 441, 1502, 261);
		panel_2.add(scrollPane);
		
		table = new JTable(tableModel);
//		ArrayList<Xe> listXe= dao_qlXe.getInfoXe("Xetest");
//		txtImg1.setText(listXe.get(0).getImg1());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				txtMa.setText(tableModel.getValueAt(i, 0).toString());
				txtTen.setText(tableModel.getValueAt(i, 1).toString());
				txtMau.setText(tableModel.getValueAt(i, 2).toString());
				cbLoaiXe.setSelectedItem(tableModel.getValueAt(i, 3));
				cbHangSx.setSelectedItem(tableModel.getValueAt(i, 4));
				cbNhaCC.setSelectedItem(tableModel.getValueAt(i, 5));
				txtPhanKhoi.setText(tableModel.getValueAt(i, 7).toString());
				txtSoLuong.setText(tableModel.getValueAt(i, 8).toString());
				txtGiaNhap.setText(tableModel.getValueAt(i, 9).toString());
				dateChooser_1.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 10).toString())));
				txtTrangThai.setText(tableModel.getValueAt(i, 11).toString());
				txtCt.setText(tableModel.getValueAt(i, 12).toString());
			}
		});
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
		lblNewLabel_3.setBounds(10, 27, 142, 40);
		panel_6.add(lblNewLabel_3);
		
		txtTim = new JTextField();
		txtTim.setBounds(151, 38, 321, 19);
		panel_6.add(txtTim);
		txtTim.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtTim.getText().length()>0) {
					try {
						timXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					try {
						loadXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnTimKiem.setIcon(new ImageIcon("img1\\search2.png"));
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setBounds(507, 27, 118, 40);
		panel_6.add(btnTimKiem);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(231,150,36));
		panel_7.setBounds(720, 336, 792, 95);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		JButton btnThem = new JButton("Thêm");
		dateChooser_1.setDateFormatString("yyy-MM-dd");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String ncc=null;
					String loai=null;
					String hsx = null;
					String ma= txtMa.getText();
					String ten=txtTen.getText();
					String mau= txtMau.getText();
					int soLuong= Integer.parseInt(txtSoLuong.getText());
					for (int i = 0; i < listNCC.size(); i++) {
						if(cbNhaCC.getSelectedItem().toString().equalsIgnoreCase(listNCC.get(i).getTenNhaCungCap())) {
							ncc= listNCC.get(i).getMaNhaCungCap();
						}
					} 
						
					for (int i = 0; i < listHang.size(); i++) {
						if(cbHangSx.getSelectedItem().toString().equalsIgnoreCase(listHang.get(i).getTenHangSX())) {
							hsx= listHang.get(i).getMaHangSX();
						}
					} 
					for (int i = 0; i < dsLoai.size(); i++) {
						if(cbLoaiXe.getSelectedItem().toString().equalsIgnoreCase(dsLoai.get(i).getTenLoaiXe())) {
							loai= dsLoai.get(i).getMaLoaiXe();
						}
					} 
					int phanKhoi=Integer.parseInt(txtPhanKhoi.getText());
					double giaNhap=Float.parseFloat(txtGiaNhap.getText());
					String date  = ((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText();
					Date ngay=Date.valueOf(LocalDate.parse(date));
					String trangThai=txtTrangThai.getText();
					String chuThich=txtCt.getText();
					String img1=txtImg1.getText();
					String img2=txtImg2.getText();
					String img3=txtImg3.getText();
					Xe xe= new Xe(ma, ten, mau, phanKhoi, soLuong, giaNhap, new LoaiXe(loai), new NhaCungCap(ncc), new HangSanXuat(hsx), ngay, trangThai, chuThich, img1, img2, img3);
					//{"Mã Xe","Tên Xe", "Màu Xe", "Loại Xe", "Nhà cung cấp","Hãng sản xuất","Phân Khối","Số Lượng","Giá Nhập","Ngày Nhập","Trạng Thái","Chú Thích"};
					dao_qlXe.themXe(xe);
					JFrame f= new JFrame();
					loadXe();
					JOptionPane.showMessageDialog(f, "Thêm thành công !!!");
					dem();
					
				} catch (Exception s) {
					s.getMessage();
					JOptionPane.showConfirmDialog(null, "aaa");
				}
			}
		});
		btnThem.setIcon(new ImageIcon("img1\\add.png"));
		btnThem.setToolTipText("");
		btnThem.setBackground(new Color(255,190,87));
		btnThem.setBounds(20, 28, 125, 36);
		panel_7.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Xe "+txtTen.getText()+" sẽ bị xóa","Cảnh báo", JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r= table.getSelectedRow();
							tableModel.removeRow(r);
							xoaXe();
							dem();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để xóa !!!");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnXoa.setBackground(new Color(255,190,87));
		btnXoa.setBounds(169, 28, 125, 36);
		panel_7.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Xe '"+txtTen.getText()+"' sẽ được cập nhật !!!","Chú ý ",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String ncc=null;
							String hsx=null;
							String loai=null;
							String ma= txtMa.getText();
							String ten=txtTen.getText();
							String mau= txtMau.getText();
							int soLuong= Integer.parseInt(txtSoLuong.getText());
							for (int i = 0; i < listNCC.size(); i++) {
								if(cbNhaCC.getSelectedItem().toString().equalsIgnoreCase(listNCC.get(i).getTenNhaCungCap())) {
									ncc= listNCC.get(i).getMaNhaCungCap();
								}
							} 
							for (int i = 0; i < listHang.size(); i++) {
								if(cbHangSx.getSelectedItem().toString().equalsIgnoreCase(listHang.get(i).getTenHangSX())) {
									hsx= listHang.get(i).getMaHangSX();
								}
							} 
							for (int i = 0; i < dsLoai.size(); i++) {
								if(cbLoaiXe.getSelectedItem().toString().equalsIgnoreCase(dsLoai.get(i).getTenLoaiXe())) {
									loai= dsLoai.get(i).getMaLoaiXe();
								}
							} 
							int phanKhoi=Integer.parseInt(txtPhanKhoi.getText());
							double giaNhap=Float.parseFloat(txtGiaNhap.getText());
							String date  = ((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText();
							Date ngay=Date.valueOf(LocalDate.parse(date));
							String trangThai=txtTrangThai.getText();
							String chuThich=txtCt.getText();
							String img1=txtImg1.getText();
							String img2=txtImg2.getText();
							String img3=txtImg3.getText();
							Xe xe= new Xe(ma, ten, mau, phanKhoi, soLuong, giaNhap, new LoaiXe(loai), new NhaCungCap(ncc), new HangSanXuat(hsx), ngay, trangThai, chuThich, img1, img2, img3);
							//{"Mã Xe","Tên Xe", "Màu Xe", "Loại Xe", "Nhà cung cấp","Hãng sản xuất","Phân Khối","Số Lượng","Giá Nhập","Ngày Nhập","Trạng Thái","Chú Thích"};
							
							dao_qlXe.update(xe);
							loadXe();
							JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
							try {
								loadXe();
							} catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn xe cần cập nhật");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnCapNhat.setIcon(new ImageIcon("img1\\update.png"));
		btnCapNhat.setBackground(new Color(255,190,87));
		btnCapNhat.setBounds(326, 28, 125, 36);
		panel_7.add(btnCapNhat);
		
		JButton btnXoaTrang = new JButton("Làm mới ");
		btnXoaTrang.setIcon(new ImageIcon("img1\\refresh.png"));
		btnXoaTrang.setBackground(new Color(255,190,87));
		btnXoaTrang.setBounds(482, 28, 125, 36);
		panel_7.add(btnXoaTrang);
		
		JButton btnTT = new JButton("Chi tiết");
		btnTT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				try {
					if(row!=-1) {
						Detail d= new Detail(txtMa.getText());
						d.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để xem thông tin chi tiết !!!");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnTT.setIcon(new ImageIcon("img1\\detail.png"));
		btnTT.setBackground(new Color(255, 190, 87));
		btnTT.setBounds(642, 28, 125, 36);
		panel_7.add(btnTT);
		getContentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Loại Xe", new ImageIcon("img1\\loaixe.png"), panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(0, 47, 1512, 82);
		panel_3.add(panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("DANH SÁCH LOẠI XE");
		lblNewLabel_1_2.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(57, 0, 329, 72);
		panel_1_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_4_1_5 = new JLabel("Mã Loại Xe");
		lblNewLabel_2_4_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_4_1_5.setBounds(22, 142, 130, 14);
		panel_3.add(lblNewLabel_2_4_1_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 142, 287, 19);
		panel_3.add(textField);
		
		JLabel lblNewLabel_2_4_1_5_1 = new JLabel("Tên Loại Xe");
		lblNewLabel_2_4_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_4_1_5_1.setBounds(22, 179, 130, 14);
		panel_3.add(lblNewLabel_2_4_1_5_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 177, 287, 19);
		panel_3.add(textField_1);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(new Color(231, 150, 36));
		panel_7_1.setBounds(464, 142, 548, 54);
		panel_3.add(panel_7_1);
		
		JButton btnThem_1 = new JButton("Thêm");
		btnThem_1.setIcon(new ImageIcon("img1\\add.png"));
		btnThem_1.setToolTipText("");
		btnThem_1.setBackground(new Color(255, 190, 87));
		btnThem_1.setBounds(10, 10, 125, 36);
		panel_7_1.add(btnThem_1);
		
		JButton btnXoa_1 = new JButton("Xóa");
		btnXoa_1.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnXoa_1.setBackground(new Color(255, 190, 87));
		btnXoa_1.setBounds(145, 10, 125, 36);
		panel_7_1.add(btnXoa_1);
		
		JButton btnCapNhat_1 = new JButton("Cập nhật");
		btnCapNhat_1.setIcon(new ImageIcon("img1\\update.png"));
		btnCapNhat_1.setBackground(new Color(255, 190, 87));
		btnCapNhat_1.setBounds(280, 10, 125, 36);
		panel_7_1.add(btnCapNhat_1);
		
		JButton btnXoaTrang_1 = new JButton("Làm mới ");
		btnXoaTrang_1.setIcon(new ImageIcon("img1\\refresh.png"));
		btnXoaTrang_1.setBackground(new Color(255, 190, 87));
		btnXoaTrang_1.setBounds(415, 10, 125, 36);
		panel_7_1.add(btnXoaTrang_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 238, 1470, 410);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Lo\u1EA1i Xe", "T\u00EAn Lo\u1EA1i Xe"
			}
		));
		
		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setLayout(null);
		panel_7_1_1.setBackground(new Color(231, 150, 36));
		panel_7_1_1.setBounds(1022, 142, 472, 54);
		panel_3.add(panel_7_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nhập thông tin cần tìm");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(10, 10, 132, 40);
		panel_7_1_1.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 21, 152, 19);
		panel_7_1_1.add(textField_2);
		
		JButton btnXoaTrang_1_1 = new JButton("Tìm Kiếm");
		btnXoaTrang_1_1.setIcon(new ImageIcon("img1\\search2.png"));
		btnXoaTrang_1_1.setBackground(new Color(255, 190, 87));
		btnXoaTrang_1_1.setBounds(303, 12, 125, 36);
		panel_7_1_1.add(btnXoaTrang_1_1);
		
		JPanel panel_2_1 = new JPanel();
		tabbedPane.addTab("Hãng Sản Xuất", new ImageIcon("img1\\com.png"), panel_2_1, null);
		panel_2_1.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(0, 0, 1522, 716);
		panel_2_1.add(panel_3_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(0, 47, 1512, 82);
		panel_3_1.add(panel_1_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("DANH SÁCH HÃNG SẢN XUẤT");
		lblNewLabel_1_2_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(57, 0, 384, 72);
		panel_1_2_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_4_1_5_2 = new JLabel("Mã Hãng Sản Xuất");
		lblNewLabel_2_4_1_5_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_4_1_5_2.setBounds(22, 142, 130, 14);
		panel_3_1.add(lblNewLabel_2_4_1_5_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 142, 287, 19);
		panel_3_1.add(textField_3);
		
		JLabel lblNewLabel_2_4_1_5_1_1 = new JLabel("Tên Hãng Sản Xuất");
		lblNewLabel_2_4_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_4_1_5_1_1.setBounds(22, 179, 130, 14);
		panel_3_1.add(lblNewLabel_2_4_1_5_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(156, 177, 287, 19);
		panel_3_1.add(textField_4);
		
		JPanel panel_7_1_2 = new JPanel();
		panel_7_1_2.setLayout(null);
		panel_7_1_2.setBackground(new Color(231, 150, 36));
		panel_7_1_2.setBounds(464, 142, 548, 88);
		panel_3_1.add(panel_7_1_2);
		
		JButton btnThem_1_1 = new JButton("Thêm");
		btnThem_1_1.setIcon(new ImageIcon("img1\\add.png"));
		btnThem_1_1.setToolTipText("");
		btnThem_1_1.setBackground(new Color(255, 190, 87));
		btnThem_1_1.setBounds(10, 29, 125, 36);
		panel_7_1_2.add(btnThem_1_1);
		
		JButton btnXoa_1_1 = new JButton("Xóa");
		btnXoa_1_1.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnXoa_1_1.setBackground(new Color(255, 190, 87));
		btnXoa_1_1.setBounds(145, 29, 125, 36);
		panel_7_1_2.add(btnXoa_1_1);
		
		JButton btnCapNhat_1_1 = new JButton("Cập nhật");
		btnCapNhat_1_1.setIcon(new ImageIcon("img1\\update.png"));
		btnCapNhat_1_1.setBackground(new Color(255, 190, 87));
		btnCapNhat_1_1.setBounds(280, 29, 125, 36);
		panel_7_1_2.add(btnCapNhat_1_1);
		
		JButton btnXoaTrang_1_2 = new JButton("Làm mới ");
		btnXoaTrang_1_2.setIcon(new ImageIcon("img1\\refresh.png"));
		btnXoaTrang_1_2.setBackground(new Color(255, 190, 87));
		btnXoaTrang_1_2.setBounds(415, 29, 125, 36);
		panel_7_1_2.add(btnXoaTrang_1_2);
		
		JPanel panel_7_1_1_1 = new JPanel();
		panel_7_1_1_1.setLayout(null);
		panel_7_1_1_1.setBackground(new Color(231, 150, 36));
		panel_7_1_1_1.setBounds(1022, 142, 472, 88);
		panel_3_1.add(panel_7_1_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nhập thông tin cần tìm");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1_1.setBounds(10, 25, 132, 40);
		panel_7_1_1_1.add(lblNewLabel_3_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(146, 36, 152, 19);
		panel_7_1_1_1.add(textField_5);
		
		JButton btnXoaTrang_1_1_1 = new JButton("Tìm ");
		btnXoaTrang_1_1_1.setIcon(new ImageIcon("img1\\search2.png"));
		btnXoaTrang_1_1_1.setBackground(new Color(255, 190, 87));
		btnXoaTrang_1_1_1.setBounds(303, 27, 125, 36);
		panel_7_1_1_1.add(btnXoaTrang_1_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(22, 269, 1472, 437);
		panel_3_1.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00E3ng S\u1EA3n Xu\u1EA5t", "T\u00EAn H\u00E3ng S\u1EA3n Xu\u1EA5t", "Qu\u1ED1c Gia"
			}
		));
		
		JLabel lblNewLabel_2_4_1_5_1_1_1 = new JLabel("Quốc Gia");
		lblNewLabel_2_4_1_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_4_1_5_1_1_1.setBounds(22, 216, 130, 14);
		panel_3_1.add(lblNewLabel_2_4_1_5_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(156, 214, 287, 19);
		panel_3_1.add(textField_6);
	}
//Hàm load database
		private void loadXe() throws SQLException {
			Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
			tableModel = dao_xe.getAllXe();
			table.setModel(tableModel);
		}
//Đếm số lượng xe 
		public void dem() {
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				String sql = "select count(maXe) from Xe ";
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
//Xóa xe
		private void xoaXe() throws SQLException {
			Dao_QuanLyXe dao_qlXe = new Dao_QuanLyXe();
			dao_qlXe.xoaXe(txtMa.getText());
			loadXe();
		}
//Tìm xe theo tên và mã 
		private void timXe() throws SQLException{
			Dao_QuanLyXe dao_qlXe= new Dao_QuanLyXe();
			tableModel = dao_qlXe.timKiem("%"+txtTim.getText()+"%");
			table.setModel(tableModel);
		}
	
}

