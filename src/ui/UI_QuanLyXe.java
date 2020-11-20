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

import org.jfree.util.SortedConfigurationWriter;
import org.jfree.util.TableOrder;

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
import dao.Dao_HangSanXuat;
import dao.Dao_LoaiXe;
import dao.Dao_NhaCungCap;
import dao.Dao_QuanLyXe;
import entity.HangSanXuat;
import entity.KhachHang;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

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
	private DefaultTableModel tableModelLoai;
	private Dao_QuanLyXe dao_qlXe= new Dao_QuanLyXe();
	private Dao_LoaiXe dao_loai= new Dao_LoaiXe();
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTable tableLoai;
	private JTextField txtTim_1;
	private JTextField txtmaHang;
	private JTextField txttenHang;
	private JTextField txttimHang;
	private JTable table_hang;
	private JTextField txtquocGia;
	private DefaultTableModel tableModelHang;
	private Dao_HangSanXuat dao_hsx= new Dao_HangSanXuat();
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
		Dao_NhaCungCap dao_Ncc = new Dao_NhaCungCap();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, (screen.height-50));
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		getContentPane.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 88, 1522, 660);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JPanel panelXe = new JPanel();
		
		panel_5.add(panelXe, "name_24132246182000");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 10, 1512, 82);
		
		JLabel lblNewLabel_1 = new JLabel("DANH SÁCH XE NHẬP");
		lblNewLabel_1.setBounds(57, 0, 329, 72);
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 102, 1502, 195);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Mã Xe");
		lblNewLabel_2_4_1.setBounds(10, 13, 130, 14);
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
		JComboBox cbNhaCC = new JComboBox(dao_Ncc.getListSuppilerName().toArray());
		
		panel_4.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				List<String> listSupplierName = dao_Ncc.getListSuppilerName();
				int soLuongCBB = cbNhaCC.getItemCount();
				int soLuongListSupperlier  = listSupplierName.size();
				if (soLuongCBB < soLuongListSupperlier)
					cbNhaCC.addItem(listSupplierName.get(soLuongListSupperlier-1));
				else if (soLuongCBB > soLuongListSupperlier) {
					cbNhaCC.removeAllItems();
					Collections.sort(listSupplierName);
					for(String ncc : listSupplierName)
						cbNhaCC.addItem(ncc);
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		cbNhaCC.setBounds(557, 13, 206, 19);
		cbNhaCC.setEditable(true);
		/*for (NhaCungCap nhaCungCap : listNCC) {
			cbNhaCC.addItem(nhaCungCap.getTenNhaCungCap());
		}*/
		
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
		panelXe.setLayout(null);
		panelXe.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1);
		panelXe.add(panel_4);
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
		
		scrollPane.setBounds(0, 412, 1502, 238);
		panelXe.add(scrollPane);
		
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
		panel_6.setBounds(0, 307, 700, 95);
		panelXe.add(panel_6);
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
		panel_7.setBounds(710, 307, 792, 95);
		panelXe.add(panel_7);
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
		
		JPanel panelLoai = new JPanel();

		panelLoai.setLayout(null);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(0, 10, 1512, 82);
		panelLoai.add(panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("DANH SÁCH LOẠI XE");
		lblNewLabel_1_2.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(57, 0, 329, 72);
		panel_1_2.add(lblNewLabel_1_2);
		
		JLabel lbMaLoai = new JLabel("Mã Loại Xe");
		lbMaLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMaLoai.setBounds(10, 102, 130, 14);
		panelLoai.add(lbMaLoai);
		
		txtMaLoai = new JTextField();
		txtMaLoai.setColumns(10);
		txtMaLoai.setBounds(144, 102, 287, 19);
		panelLoai.add(txtMaLoai);
		
		JLabel lbTenLoai = new JLabel("Tên Loại Xe");
		lbTenLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTenLoai.setBounds(10, 139, 130, 14);
		panelLoai.add(lbTenLoai);
		
		txtTenLoai = new JTextField();
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(144, 137, 287, 19);
		panelLoai.add(txtTenLoai);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(new Color(231, 150, 36));
		panel_7_1.setBounds(452, 102, 548, 54);
		panelLoai.add(panel_7_1);
		
		JButton btnThem_1 = new JButton("Thêm");
		btnThem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ma= txtMaLoai.getText();
				String ten=txtTenLoai.getText();
				LoaiXe loai= new LoaiXe(ma, ten);
				tableModel.addRow(new Object[] {loai.getMaLoaiXe(),loai.getTenLoaiXe()});
				dao_loai.themLX(loai);
				try {
					loadXe();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFrame f= new JFrame();
				JOptionPane.showMessageDialog(f, "Thêm Thành Công Loại Xe"+txtTenLoai.getText());
			}
		});
		btnThem_1.setIcon(new ImageIcon("img1\\add.png"));
		btnThem_1.setToolTipText("");
		btnThem_1.setBackground(new Color(255, 190, 87));
		btnThem_1.setBounds(10, 10, 125, 36);
		panel_7_1.add(btnThem_1);
		
		JButton btnXoa_1 = new JButton("Xóa");
		btnXoa_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tableLoai.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Loại xe này này sẽ bị xóa","Chú ý", JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r= tableLoai.getSelectedRow();
							tableModel.removeRow(r);
							xoaLoaiXe();
						
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn loại xe để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa_1.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnXoa_1.setBackground(new Color(255, 190, 87));
		btnXoa_1.setBounds(145, 10, 125, 36);
		panel_7_1.add(btnXoa_1);
		
		JButton btnCapNhat_1 = new JButton("Cập nhật");
		btnCapNhat_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tableLoai.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Loại xe này sẽ bị thay đôi !!!","Chú ý",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String ma= txtMaLoai.getText();
							String ten=txtTenLoai.getText();
							LoaiXe loai= new LoaiXe(ma, ten);
							tableModel.addRow(new Object[] {loai.getMaLoaiXe(),loai.getTenLoaiXe()});
							dao_loai.update(loai);
							try {
								loadLoai();
							} catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn loại xe cần thay đổi !!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Mã xe không thể thay đổi");
				}
			}
		});
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
		scrollPane_1.setBounds(12, 195, 1470, 359);
		panelLoai.add(scrollPane_1);
		
		
		String[] headerLoai= {"Mã Loại Xe","Tên Loại Xe"};
		tableModelLoai = new DefaultTableModel(headerLoai, 0);
		tableLoai = new JTable(tableModelLoai);
		tableLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableLoai.getSelectedRow();
				txtMaLoai.setText(tableModelLoai.getValueAt(i, 0).toString());
				txtTenLoai.setText(tableModelLoai.getValueAt(i, 1).toString());
			}
		});
		scrollPane_1.setViewportView(tableLoai);
		try {
			loadLoai();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setLayout(null);
		panel_7_1_1.setBackground(new Color(231, 150, 36));
		panel_7_1_1.setBounds(1010, 102, 472, 54);
		panelLoai.add(panel_7_1_1);
		
		JLabel lbTimLoai = new JLabel("Nhập thông tin cần tìm");
		lbTimLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTimLoai.setBounds(10, 10, 132, 40);
		panel_7_1_1.add(lbTimLoai);
		
		txtTim_1 = new JTextField();
		txtTim_1.setColumns(10);
		txtTim_1.setBounds(146, 21, 152, 19);
		panel_7_1_1.add(txtTim_1);
		
		JButton btn_Tim1 = new JButton("Tìm Kiếm");
		btn_Tim1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					timLoai();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Tim1.setIcon(new ImageIcon("img1\\search2.png"));
		btn_Tim1.setBackground(new Color(255, 190, 87));
		btn_Tim1.setBounds(303, 12, 125, 36);
		panel_7_1_1.add(btn_Tim1);
		
		JPanel panelHang = new JPanel();
		panelHang.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(0, 0, 1522, 716);
		panelHang.add(panel_3_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(0, 10, 1512, 82);
		panel_3_1.add(panel_1_2_1);
		
		//Hãng Sản Xuất
		
		JLabel lblNewLabel_1_2_1 = new JLabel("DANH SÁCH HÃNG SẢN XUẤT");
		lblNewLabel_1_2_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(57, 0, 384, 72);
		panel_1_2_1.add(lblNewLabel_1_2_1);
		
		JLabel lblmaHang = new JLabel("Mã Hãng Sản Xuất");
		lblmaHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaHang.setBounds(0, 102, 130, 14);
		panel_3_1.add(lblmaHang);
		
		txtmaHang = new JTextField();
		txtmaHang.setColumns(10);
		txtmaHang.setBounds(134, 102, 287, 19);
		panel_3_1.add(txtmaHang);
		
		JLabel lbltenHang = new JLabel("Tên Hãng Sản Xuất");
		lbltenHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltenHang.setBounds(0, 139, 130, 14);
		panel_3_1.add(lbltenHang);
		
		txttenHang = new JTextField();
		txttenHang.setColumns(10);
		txttenHang.setBounds(134, 137, 287, 19);
		panel_3_1.add(txttenHang);
		
		JPanel panel_7_1_2 = new JPanel();
		panel_7_1_2.setLayout(null);
		panel_7_1_2.setBackground(new Color(231, 150, 36));
		panel_7_1_2.setBounds(443, 102, 548, 88);
		panel_3_1.add(panel_7_1_2);
		
		JButton btnthemHang = new JButton("Thêm");
		btnthemHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
			    		String maHang = txtmaHang.getText();
			    		String tenHang = txttenHang.getText();
			    		String quocGia = txtquocGia.getText();
			    		HangSanXuat hsx = new HangSanXuat(maHang,tenHang,quocGia);
			    		dao_hsx.themHSX(hsx);
			    		JFrame f = new JFrame();
			    		loadHSX();
			    		JOptionPane.showMessageDialog(f, "Thêm hãng sản xuất thành công");
			    	  }catch(SQLException e1) {
			    		  e1.getMessage();
			    		  JOptionPane.showConfirmDialog(null, "Thêm không thành công");
			    	  }
			}
		});
		btnthemHang.setIcon(new ImageIcon("img1\\add.png"));
		btnthemHang.setToolTipText("");
		btnthemHang.setBackground(new Color(255, 190, 87));
		btnthemHang.setBounds(10, 29, 125, 36);
		panel_7_1_2.add(btnthemHang);
		
		JButton btnxoaHang = new JButton("Xóa");
		btnxoaHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_hang.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Hãng sãn xuất này sẽ bị xóa","Chú ý", JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r = table_hang.getSelectedRow();
							tableModelHang.removeRow(r);
							xoaHangSX();
							
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnxoaHang.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnxoaHang.setBackground(new Color(255, 190, 87));
		btnxoaHang.setBounds(145, 29, 125, 36);
		panel_7_1_2.add(btnxoaHang);
		
		JButton btncapNhatHang = new JButton("Cập nhật");
		btncapNhatHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_hang.getSelectedRow();
				try {
					if(row !=-1) {
						JFrame f = new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Hãng Sản Xuất '"+txttenHang.getText()+"' sẽ được cập nhật !!!","Chú ý ",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String maHang = txtmaHang.getText();
							String tenHang = txttenHang.getText();
							String quocGia = txtquocGia.getText();
				    		HangSanXuat hsx = new HangSanXuat(maHang,tenHang,quocGia);
				    		dao_hsx.update(hsx);
				    		loadHSX();
				    		JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
				    		try {
				    			loadHSX();
				    		}catch(Exception e2) {
				    			e2.printStackTrace();
				    		}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần cập nhật");
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btncapNhatHang.setIcon(new ImageIcon("img1\\update.png"));
		btncapNhatHang.setBackground(new Color(255, 190, 87));
		btncapNhatHang.setBounds(280, 29, 125, 36);
		panel_7_1_2.add(btncapNhatHang);
		
		JButton btnlamMoiHang = new JButton("Làm mới ");
		btnlamMoiHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtmaHang.setText("");
				txttenHang.setText("");
				txtquocGia.setText("");
				txtmaHang.requestFocus();
			}
		});
		btnlamMoiHang.setIcon(new ImageIcon("img1\\refresh.png"));
		btnlamMoiHang.setBackground(new Color(255, 190, 87));
		btnlamMoiHang.setBounds(415, 29, 125, 36);
		panel_7_1_2.add(btnlamMoiHang);
		
		JPanel panel_7_1_1_1 = new JPanel();
		panel_7_1_1_1.setLayout(null);
		panel_7_1_1_1.setBackground(new Color(231, 150, 36));
		panel_7_1_1_1.setBounds(1001, 102, 472, 88);
		panel_3_1.add(panel_7_1_1_1);
		
		JLabel lbltimHang = new JLabel("Nhập thông tin cần tìm");
		lbltimHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltimHang.setBounds(10, 25, 132, 40);
		panel_7_1_1_1.add(lbltimHang);
		
		txttimHang = new JTextField();
		txttimHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txttimHang.getText().length()==0) {
					try {
						loadHSX();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(txttimHang.getText().length()>0) {
					try {
						timHangSanXuat();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		txttimHang.setColumns(10);
		txttimHang.setBounds(146, 36, 152, 19);
		panel_7_1_1_1.add(txttimHang);
		
		JButton btnTimHang = new JButton("Tìm ");
		
		btnTimHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txttimHang.getText().length()>0) {
					try {
						timHangSanXuat();
						//timKhachHang();
					}catch(SQLException e1) {
						e1.printStackTrace();
						
					}
				}
				else {
						try {
							loadHSX();
						}catch(SQLException e1) {
							e1.printStackTrace();
						}
				}
			}
		});
		btnTimHang.setIcon(new ImageIcon("img1\\search2.png"));
		btnTimHang.setBackground(new Color(255, 190, 87));
		btnTimHang.setBounds(303, 27, 125, 36);
		panel_7_1_1_1.add(btnTimHang);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(1, 237, 1472, 366);
		panel_3_1.add(scrollPane_2);
		String [] header_1= {
				"Mã Hãng Sản Xuất","Tên Hãng Sản Xuất","Quốc Gia"
		};
		tableModelHang = new DefaultTableModel(header_1,0);
		
		table_hang = new JTable(tableModelHang);
		table_hang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i  = table_hang.getSelectedRow();
				txtmaHang.setText(table_hang.getValueAt(i, 0).toString());
				txttenHang.setText(table_hang.getValueAt(i, 1).toString());
				txtquocGia.setText(table_hang.getValueAt(i, 2).toString());
			}
		});
		
		scrollPane_2.setViewportView(table_hang);
		
		try {
			loadHSX();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		JLabel lblquocGia = new JLabel("Quốc Gia");
		lblquocGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblquocGia.setBounds(0, 176, 130, 14);
		panel_3_1.add(lblquocGia);
		
		txtquocGia = new JTextField();
		txtquocGia.setColumns(10);
		txtquocGia.setBounds(134, 174, 287, 19);
		panel_3_1.add(txtquocGia);
		
		panel_5.add(panelHang, "name_24132267128600");
		panel_5.add(panelLoai, "name_24132287226400");
		getContentPane.add(panel_5);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1532, 78);
		getContentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLoai = new JButton("");
		btnLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnLoai.setBackground(Color.white);
				panelLoai.setVisible(true);
				panelHang.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		btnLoai.setBackground(Color.WHITE);
		btnLoai.setFocusable(false);
		btnLoai.setIcon(new ImageIcon("img1\\motorbikes-icon.png"));
		btnLoai.setBounds(133, 10, 93, 43);
		btnLoai.setBorderPainted(false);
		panel.add(btnLoai);
		
		JButton btnHang = new JButton("");
		btnHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnHang.setBackground(Color.white);
				panelHang.setVisible(true);
				panelLoai.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		btnHang.setBackground(Color.WHITE);
		btnHang.setFocusable(false);
		btnHang.setIcon(new ImageIcon("img1\\company-building-icon.png"));
		btnHang.setBounds(255, 10, 93, 43);
		btnHang.setBorderPainted(false);
		panel.add(btnHang);
		
		JButton btnXe = new JButton("");
		btnXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnHang.setBackground(Color.white);
				panelXe.setVisible(true);
				panelHang.setVisible(false);
				panelLoai.setVisible(false);
			}
		});
		btnXe.setBackground(Color.WHITE);
		btnXe.setBorderPainted(false);
		btnXe.setFocusable(false);
		btnXe.setIcon(new ImageIcon("img1\\moto1.png"));
		btnXe.setBounds(10, 10, 93, 43);
		panel.add(btnXe);
		
		JLabel lbXe = new JLabel("Xe");
		lbXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelXe.setVisible(true);
				panelHang.setVisible(false);
				panelLoai.setVisible(false);
			}
		});
		lbXe.setHorizontalAlignment(SwingConstants.CENTER);
		lbXe.setBounds(10, 55, 93, 13);
		panel.add(lbXe);
		
		JLabel lblLoiXe = new JLabel("Loại Xe");
		lblLoiXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelLoai.setVisible(true);
				panelHang.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		lblLoiXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoiXe.setBounds(133, 55, 93, 13);
		panel.add(lblLoiXe);
		
		JLabel lblHngSnXut = new JLabel("Hãng Sản Xuất");
		lblHngSnXut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnHang.setBackground(Color.white);
				panelHang.setVisible(true);
				panelLoai.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		lblHngSnXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngSnXut.setBounds(255, 55, 93, 13);
		panel.add(lblHngSnXut);
	}
//Hàm load database
		private void loadXe() throws SQLException {
			Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
			tableModel = dao_xe.getAllXe();
			table.setModel(tableModel);
		}
		private void loadLoai() throws SQLException {
			Dao_LoaiXe dao_lx = new Dao_LoaiXe();
			tableModelLoai = dao_lx.getAllLX();
			tableLoai.setModel(tableModelLoai);
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
		private void xoaLoaiXe() throws SQLException {
			Dao_LoaiXe dao_loai = new Dao_LoaiXe();
			dao_loai.xoaLoaiXe(txtMaLoai.getText());
			loadLoai();
		}
//Tìm xe theo tên và mã 
		private void timXe() throws SQLException{
			Dao_QuanLyXe dao_qlXe= new Dao_QuanLyXe();
			tableModel = dao_qlXe.timKiem("%"+txtTim.getText()+"%");
			table.setModel(tableModel);
		}
		private void timLoai() throws SQLException{
			Dao_LoaiXe dao_loai= new Dao_LoaiXe();
			tableModelLoai = dao_loai.timKiem("%"+txtTim_1.getText()+"%");
			tableLoai.setModel(tableModelLoai);
		}
		
		private void loadHSX() throws SQLException {
			dao_hsx = new Dao_HangSanXuat();
			tableModelHang=dao_hsx.getAllHSX();
			table_hang.setModel(tableModelHang);
		}
		private void xoaHangSX() throws SQLException {
			dao_hsx = new Dao_HangSanXuat();
			dao_hsx.xoaHSX(txtmaHang.getText());
			loadHSX();
		}
		private void timHangSanXuat() throws SQLException{
			dao_hsx = new Dao_HangSanXuat();
			tableModelHang = dao_hsx.timKiem("%"+txttimHang.getText()+"%");
			table_hang.setModel(tableModelHang);
		}
}

