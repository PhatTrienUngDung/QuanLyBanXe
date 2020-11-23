package ui;

import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;

import connect.ConnectDB;
import dao.Dao_HopDong;
import dao.Dao_KhachHang;
import dao.Dao_NhaCungCap;
import dao.Dao_NhanVien;
import dao.Dao_QuanLyXe;
import entity.HangSanXuat;
import entity.HopDong;
import entity.NhanVien;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;

public class UI_HopDong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtTimKiem;
	private JTextField txtmaHD;
	private JTextField txtmaKH,txtmaNV,txtmaXe,txtngayLap,txtTGBH;
	private DefaultTableModel tableModel;
	private JDateChooser datengayLap;
	private Dao_HopDong dao_hd = new Dao_HopDong();
	private Dao_QuanLyXe dao_qlXe = new Dao_QuanLyXe();
	//private Dao_KhachHang dao_kh = new Dao_KhachHang();
	private Dao_NhanVien dao_nv = new Dao_NhanVien();
	private JTextField textField_3;
	private JTextField txtCMND;
	private JTextField txtdiaChi;
	private JTextField txtdonGia;
	private JTextField txtloaiXe;
	private JTextField txtphanKhoi;
	private JTextField txtsoLuong;
	private JTextField txttongTien;
	private JTextField txtTen;
	private JTextField txtmauXe;
	private JTextField txtsdt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_HopDong frame = new UI_HopDong();
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
	public UI_HopDong() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1312, 735);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		setBounds(0, 0, screen.width, (screen.height-50));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 1512, 695);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin H\u1EE3p \u0110\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_7.setBackground(SystemColor.control);
		panel_7.setBounds(10, 170, 1482, 192);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 20, 1452, 166);
		panel_7.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblmaHD = new JLabel("Mã Hợp Đồng");
		lblmaHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaHD.setBounds(10, 10, 101, 13);
		panel_2.add(lblmaHD);
		
		txtmaHD = new JTextField();
		txtmaHD.setBounds(121, 10, 166, 19);
		panel_2.add(txtmaHD);
		txtmaHD.setColumns(10);
		
		JLabel lbltenKH = new JLabel("Khách Hàng");
		lbltenKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltenKH.setBounds(10, 97, 129, 18);
		panel_2.add(lbltenKH);
		
		ArrayList<KhachHang> dsKH = dao_hd.getAllKH();
		
		JLabel lblmaNV = new JLabel("Nhân Viên");
		lblmaNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmaNV.setBounds(10, 40, 101, 13);
		panel_2.add(lblmaNV);
		
		ArrayList<NhanVien> dsNV = dao_hd.getAllNV();
		@SuppressWarnings("rawtypes")
		JComboBox cbmaNV = new JComboBox();
		cbmaNV.setBounds(121, 39, 166, 21);
		for (NhanVien nv : dsNV) {
			cbmaNV.addItem(nv.getTenNhanVien());
		}
		panel_2.add(cbmaNV);
		
		JLabel lblLoaiXe = new JLabel("Loại Xe");
		lblLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoaiXe.setBounds(739, 10, 74, 13);
		panel_2.add(lblLoaiXe);
		
		txtloaiXe = new JTextField();
		txtloaiXe.setBounds(843, 10, 189, 19);
		panel_2.add(txtloaiXe);
		txtloaiXe.setColumns(10);
		
		
		
		JLabel lblMauXe = new JLabel("Màu Xe");
		lblMauXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMauXe.setBounds(739, 40, 94, 13);
		panel_2.add(lblMauXe);
		
		txtmauXe = new JTextField();
		txtmauXe.setBounds(843, 40, 189, 19);
		panel_2.add(txtmauXe);
		txtmauXe.setColumns(10);
		
		JLabel lblNgayLap = new JLabel("Ngày Lập");
		lblNgayLap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgayLap.setBounds(1120, 68, 74, 19);
		panel_2.add(lblNgayLap);
		
		datengayLap= new JDateChooser();
		datengayLap.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 datengayLap.setBounds(1253, 68, 183, 19);
		panel_2.add( datengayLap);
		
		JLabel lblTGBH = new JLabel("Thời gian bảo hành");
		lblTGBH.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTGBH.setBounds(1120, 97, 123, 19);
		panel_2.add(lblTGBH);
		
		txtTGBH = new JTextField();
		txtTGBH.setBounds(1253, 99, 183, 19);
		panel_2.add(txtTGBH);
		txtTGBH.setColumns(10);
		
		JLabel lbltennXe = new JLabel("Tên Xe");
		lbltennXe.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbltennXe.setBounds(360, 103, 56, 13);
		panel_2.add(lbltennXe);
		
		ArrayList<Xe> dsXe = dao_hd.getAllXes();
		@SuppressWarnings("rawtypes")
		JComboBox cbtenXe = new JComboBox();
////		cbtenXe.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				if(cbtenXe.getItemCount()>0)
////					cbtenXe.removeAll();
////				String tenXe = cbtenXe.getSelectedItem().toString();
////				String loaiXe,mauXe,soLuong,donGia,phanPhoi;
////				if(txtloaiXe.getText().length()==0)
////					loaiXe = "";
////				else
////					loaiXe = txtloaiXe.getText().toString();
////				if(txtmauXe.getText().length()==0)
////					mauXe="";
////				else
////					mauXe=txtmauXe.getText().toString();
////				dao_hd.getAllXes(tenXe,mauXe);
////				
////				
////				
////				
////				
////				
////			}
//				int count =0;
//				String tenXe =(String) cbtenXe.getSelectedItem();
//				ArrayList<LoaiXe> dsLX = dao_hd.getAllLoai();
//			//	for (int u = 0; u < tenXe.length();u++) {	
//			//		if(tenXe.charAt(u)!=' ') {
//			//			count++;
//						if(tenXe.length()>0){
//							for (int i = 0; i < dsXe.size(); i++) {
//								
//								if(cbtenXe.getSelectedItem().toString().equalsIgnoreCase(dsXe.get(i).getTenXe())) {
//									String pk= String.valueOf(dsXe.get(i).getPhanKhoi());
//									txtphanKhoi.setText(pk);
//									txtmauXe.setText(dsXe.get(i).getMauXe());
//									for (int j = 0; j < dsLX.size(); j++) {
//										if(dsXe.get(i).getLoaiXe().getMaLoaiXe().equalsIgnoreCase(dsLX.get(j).getMaLoaiXe())) {
//											txtloaiXe.setText(dsLX.get(j).getTenLoaiXe());
//										}
//									}
//									String dg = String.valueOf(dsXe.get(i).getGiaNhap());
//									txtdonGia.setText(dg);
//								}
//								datengayLap.setDate(Date.valueOf(LocalDate.now()));
//							}
//						
//					
//				
//	
//			
//	});
		
		cbtenXe.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyPressed(KeyEvent e) {
			//	int count =0;
				String tenXe =(String) cbtenXe.getSelectedItem();
				ArrayList<LoaiXe> dsLX = dao_hd.getAllLoai();
			//	for (int u = 0; u < tenXe.length();u++) {	
			//		if(tenXe.charAt(u)!=' ') {
			//			count++;
						if(tenXe.length()>0){
							for (int i = 0; i < dsXe.size(); i++) {
								
								if(cbtenXe.getSelectedItem().toString().equalsIgnoreCase(dsXe.get(i).getTenXe())) {
									String pk= String.valueOf(dsXe.get(i).getPhanKhoi());
									txtphanKhoi.setText(pk);
									txtmauXe.setText(dsXe.get(i).getMauXe());
									for (int j = 0; j < dsLX.size(); j++) {
										if(dsXe.get(i).getLoaiXe().getMaLoaiXe().equalsIgnoreCase(dsLX.get(j).getMaLoaiXe())) {
											txtloaiXe.setText(dsLX.get(j).getTenLoaiXe());
										}
									}
									String dg = String.valueOf(dsXe.get(i).getGiaNhap());
									txtdonGia.setText(dg);
								}
								datengayLap.setDate(Date.valueOf(LocalDate.now()));
							}
						}
					
				
			}
		});
		cbtenXe.setBounds(478, 98, 176, 21);
		for (Xe xe : dsXe) {
			cbtenXe.addItem(xe.getTenXe());
		}
		panel_2.add(cbtenXe);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCmnd.setBounds(10, 72, 46, 13);
		panel_2.add(lblCmnd);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(478, 10, 176, 19);
		panel_2.add(dateChooser);
		
		txtCMND = new JTextField();
		txtCMND.addKeyListener(new KeyAdapter() {
	//		@Override
//			public void keyPressed(KeyEvent e) {
//				//lam tiep di
//				if(txtCMND.getText().length()>0) {
//					for (int i = 0; i < dsKH.size(); i++) {
//						if(txtCMND.getText().equalsIgnoreCase(dsKH.get(i).getCMND())) {
//							txtTen.setText(dsKH.get(i).getTenKhachHang());
//							txtdiaChi.setText(dsKH.get(i).getDiaChi());
//						//	String date  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
//						//	Date ngay= Date.valueOf(LocalDate.parse(date));
//							
//							dateChooser.setDate(dsKH.get(i).getNgaySinh());
//						}
//					}
//				}
//				if(txtCMND.getText().length()==0) {
//					txtCMND.setText("");
//					txtsdt.setText("");
//					txtTen.setText("");
//					txtdiaChi.setText("");
//					dateChooser.setDate(null);
//				}
//				
//			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtCMND.getText().length()>0) {
					for (int i = 0; i < dsKH.size(); i++) {
						if(txtCMND.getText().equalsIgnoreCase(dsKH.get(i).getCMND())) {
							txtTen.setText(dsKH.get(i).getTenKhachHang());
							txtdiaChi.setText(dsKH.get(i).getDiaChi());
							txtsdt.setText(dsKH.get(i).getSoDienThoai());
						//	String date  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
						//	Date ngay= Date.valueOf(LocalDate.parse(date));
							
							dateChooser.setDate(dsKH.get(i).getNgaySinh());
						}
					}
				}
				if(txtCMND.getText().length()==0) {
					txtCMND.setText("");
					txtsdt.setText("");
					txtTen.setText("");
					txtdiaChi.setText("");
					dateChooser.setDate(null);
				}
			}
		});
//		Pattern pattern1 = Pattern.compile("\\d{10}");
//		Matcher matcher1 = pattern1.matcher();
		
		txtCMND.setBounds(121, 70, 166, 19);
		panel_2.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblngaySinh = new JLabel("Ngày Sinh");
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblngaySinh.setBounds(360, 5, 87, 23);
		panel_2.add(lblngaySinh);
		
		JLabel lbldiaChi = new JLabel("Địa Chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldiaChi.setBounds(360, 40, 56, 19);
		panel_2.add(lbldiaChi);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setBounds(478, 42, 176, 19);
		panel_2.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		JLabel lblphanKhoi = new JLabel("Phân Khối");
		lblphanKhoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblphanKhoi.setBounds(739, 69, 74, 13);
		panel_2.add(lblphanKhoi);
		
		
		txtphanKhoi = new JTextField();
		txtphanKhoi.setBounds(843, 69, 189, 19);
		panel_2.add(txtphanKhoi);
		txtphanKhoi.setColumns(10);
		
		JLabel lbldonGia = new JLabel("Đơn giá");
		lbldonGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldonGia.setBounds(1120, 10, 74, 13);
		panel_2.add(lbldonGia);
		
		txtdonGia = new JTextField();
		txtdonGia.setBounds(1253, 9, 183, 19);
		panel_2.add(txtdonGia);
		txtdonGia.setColumns(10);
		
		JLabel lblsoLuong = new JLabel("Số Lượng");
		lblsoLuong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblsoLuong.setBounds(739, 97, 74, 18);
		panel_2.add(lblsoLuong);
		
		txtsoLuong = new JTextField();
		txtsoLuong.setBounds(843, 97, 189, 19);
		panel_2.add(txtsoLuong);
		txtsoLuong.setColumns(10);
		
		JLabel lbltongTien = new JLabel("Tổng Tiền");
		lbltongTien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltongTien.setBounds(1120, 40, 74, 13);
		panel_2.add(lbltongTien);
		
		txttongTien = new JTextField();
		txttongTien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtsoLuong.getText().length()>0 && txtdonGia.getText().length()>0) {
					double c = 0;
					
					String soLuong =(String) txtsoLuong.getText();
					String donGia = (String) txtdonGia.getText();
					int a =Integer.parseInt(soLuong);
					double b = Double.parseDouble(donGia);
					c = a*b;
					
					
				
					txttongTien.setText(String.valueOf(c));
					
					
						
					}
			}
		});
		
			
		
		txttongTien.setBounds(1253, 39, 183, 19);
		panel_2.add(txttongTien);
		txttongTien.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setBounds(121, 100, 166, 19);
		panel_2.add(txtTen);
		txtTen.setColumns(10);
		
		
		
		String[] header=  {"Mã Hợp Đồng","Tên Khách Hàng","CMND","Ngày Sinh","Địa Chỉ","Số Điện Thoai","Tên Nhân Viên","Tên Xe","Loại Xe","Màu Xe","Phân Khối","Số Lượng","Đơn Gía","Tổng Tiền","Ngày Lập","Thời gian BH"};
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				txtmaHD.setText(tableModel.getValueAt(i, 0).toString());
				txtTen.setText(tableModel.getValueAt(i, 1).toString());
				txtCMND.setText(tableModel.getValueAt(i, 2).toString());
				dateChooser.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 3).toString())));
				txtdiaChi.setText(tableModel.getValueAt(i, 4).toString());
				txtsdt.setText(tableModel.getValueAt(i, 5).toString());
				
				
				cbmaNV.setSelectedItem(tableModel.getValueAt(i, 6));
				
				cbtenXe.setSelectedItem(tableModel.getValueAt(i, 7));
				txtloaiXe.setText(tableModel.getValueAt(i, 8).toString());
				txtmauXe.setText(tableModel.getValueAt(i, 9).toString());
				txtphanKhoi.setText(tableModel.getValueAt(i, 10).toString());
				txtsoLuong.setText(tableModel.getValueAt(i, 11).toString());
				txtdonGia.setText(tableModel.getValueAt(i, 12).toString());
				txttongTien.setText(tableModel.getValueAt(i, 13).toString());
				datengayLap.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 14).toString())));
				txtTGBH.setText(tableModel.getValueAt(i, 15).toString());

			}
		});
		try {
			loadHD();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(10, 485, 1482, 200);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c N\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_4.setBounds(10, 361, 1482, 89);
		panel.add(panel_4);
		panel_4.setBackground(SystemColor.control);
		panel_4.setLayout(null);
		
		//Thêm
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255,190,87));
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
				
					String maHD= txtmaHD.getText();
					String nv = null;
					String kh = null;
					String xe = null;
					for (int i = 0; i < dsKH.size(); i++) {
						if(txtCMND.getText().equalsIgnoreCase(dsKH.get(i).getCMND())) {
							kh= dsKH.get(i).getMaKhachHang();
						}
					} 
					for (int i = 0; i < dsNV.size(); i++) {
						if(cbmaNV.getSelectedItem().toString().equalsIgnoreCase(dsNV.get(i).getTenNhanVien())) {
							nv= dsNV.get(i).getMaNhanVien();
						}
					} 
					
					for (int i = 0; i < dsXe.size(); i++) {
						if(cbtenXe.getSelectedItem().toString().equalsIgnoreCase(dsXe.get(i).getTenXe())) {
							xe= dsXe.get(i).getMaXe();
						}
					} 
					
					String date1  = ((JTextField)datengayLap.getDateEditor().getUiComponent()).getText();
					Date ngayLap=Date.valueOf(LocalDate.parse(date1));
					String tgbh = txtTGBH.getText();
					int tgbaoHanh=Integer.parseInt(tgbh);
					HopDong hd = new HopDong(maHD,new KhachHang(kh), new NhanVien(nv), new Xe(xe), ngayLap, tgbaoHanh);
					dao_hd.themHD(hd);
					JFrame f= new JFrame();
					loadHD();
					JOptionPane.showMessageDialog(f, "Thêm thành công !!!");
				} catch (Exception s) {
					s.getMessage();
				}
				
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnThem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Button-Add-icon.png")));
		
		btnThem.setBounds(739, 25, 129, 38);
		panel_4.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255,190,87));
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
							xoaHD();
						
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để xóa !!!");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnXoa.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/delete-icon.png")));
		
		btnXoa.setBounds(1126, 24, 129, 41);
		panel_4.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255,190,87));
		btnSua.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "HopDong  sẽ được cập nhật !!!","Chú ý ",JOptionPane.YES_NO_OPTION);
						String maHD= txtmaHD.getText();
						String nv = null;
						String kh = null;
						String xe = null;
						for (int i = 0; i < dsKH.size(); i++) {
							if(txtCMND.getText().equalsIgnoreCase(dsKH.get(i).getCMND())) {
								kh= dsKH.get(i).getMaKhachHang();
							}
						} 
						for (int i = 0; i < dsNV.size(); i++) {
							if(cbmaNV.getSelectedItem().toString().equalsIgnoreCase(dsNV.get(i).getTenNhanVien())) {
								nv= dsNV.get(i).getMaNhanVien();
							}
						} 
						
						for (int i = 0; i < dsXe.size(); i++) {
							if(cbtenXe.getSelectedItem().toString().equalsIgnoreCase(dsXe.get(i).getTenXe())) {
								xe= dsXe.get(i).getMaXe();
							}
						} 
						
						String date1  = ((JTextField)datengayLap.getDateEditor().getUiComponent()).getText();
						Date ngayLap=Date.valueOf(LocalDate.parse(date1));
						
						String tgbh = txtTGBH.getText();
						int tgbaoHanh=Integer.parseInt(tgbh);
						HopDong hd = new HopDong(maHD,new KhachHang(kh), new NhanVien(nv), new Xe(xe), ngayLap, tgbaoHanh);
						dao_hd.update(hd);
						loadHD();
						
						JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
							try {
								loadHD();
							} catch (Exception e3) {
								// TODO: handle exception
								e3
								.printStackTrace();
							}
						}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn loại xe cần thay đổi !!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Mã xe không thể thay đổi");
				}
			
				
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSua.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Settings-icon.png")));
		
		
		btnSua.setBounds(936, 25, 129, 38);
		panel_4.add(btnSua);
		
		JButton btnNew = new JButton("Làm mới");
		btnNew.setBackground(new Color(255,190,87));
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNew.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/refresh-icon.png")));
		btnNew.setBounds(1314, 25, 129, 38);
		panel_4.add(btnNew);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(10, 21, 659, 58);
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNhpMHp = new JLabel("Nhập mã hợp đồng");
		lblNhpMHp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhpMHp.setBounds(10, 11, 175, 13);
		panel_3.add(lblNhpMHp);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		txtTimKiem.setBounds(220, 10, 290, 19);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(new Color(255,190,87));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTimKiem.setBounds(537, 4, 100, 35);
		panel_3.add(btnTimKiem);
		dateChooser.setDateFormatString("yyy-MM-dd");
		
		JLabel lblsdt = new JLabel("Số Điện Thoại");
		lblsdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblsdt.setBounds(360, 72, 101, 19);
		panel_2.add(lblsdt);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(478, 72, 176, 19);
		panel_2.add(txtsdt);
		txtsdt.setColumns(10);
		datengayLap.setDateFormatString("yyy-MM-dd");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1522, 78);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ THÔNG TIN HỢP ĐỒNG");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 88, 439, 72);
		panel.add(lblNewLabel_1);
		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				for (int i = 0; i < dsKH.size(); i++) {
//					if(txtCMND.getText().equalsIgnoreCase(dsKH.get(i).getCMND())) {
//						txtTen.setText(dsKH.get(i).getTenKhachHang());
//						txtdiaChi.setText(dsKH.get(i).getDiaChi());
//					//	String date  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
//					//	Date ngay= Date.valueOf(LocalDate.parse(date));
//						
//						dateChooser.setDate(dsKH.get(i).getNgaySinh());
//					}
//				}
//				//dóng coi
//				for (int i = 0; i < dsXe.size(); i++) {
//					ArrayList<LoaiXe> dsLX = dao_hd.getAllLoai();
//					if(cbtenXe.getSelectedItem().toString().equalsIgnoreCase(dsXe.get(i).getTenXe())) {
//						String pk= String.valueOf(dsXe.get(i).getPhanKhoi());
//						txtphanKhoi.setText(pk);
//						txtmauXe.setText(dsXe.get(i).getMauXe());
//						for (int j = 0; j < dsLX.size(); j++) {
//							if(dsXe.get(i).getLoaiXe().getMaLoaiXe().equalsIgnoreCase(dsLX.get(j).getMaLoaiXe())) {
//								txtloaiXe.setText(dsLX.get(j).getTenLoaiXe());
//							}
//						}
//						String dg = String.valueOf(dsXe.get(i).getGiaNhap());
//						txtdonGia.setText(dg);
//					}
//					datengayLap.setDate(Date.valueOf(LocalDate.now()));
//				}
//			}
//		});
//		btnNewButton.setBounds(752, 69, 85, 21);
//		panel_4.add(btnNewButton);
		
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtmaHD.setText("");		
				cbmaNV.setSelectedIndex(-1);
				txtCMND.setText("");
				txtsdt.setText("");
				txtphanKhoi.setText("");
				txtsoLuong.setText("");
				txttongTien.setText("");
				txtTen.setText("");
				txtloaiXe.setText("");
				txtmauXe.setText("");
				cbtenXe.setSelectedIndex(-1);
				txtCMND.setText("");
				txtdiaChi.setText("");
				txtdonGia.setText("");
				dateChooser.setDate(null);
				datengayLap.setDate(null);
			}
		});
		
	}
	//Hàm Load
		private void loadHD() throws SQLException {
			Dao_HopDong dao_hd = new Dao_HopDong();
			tableModel = dao_hd.getAllHD();
			table.setModel(tableModel);
		}
		//Hàm Xóa
		private void xoaHD() throws SQLException {
			Dao_HopDong dao_hd= new Dao_HopDong();
			dao_hd.xoaHD(txtmaHD.getText());
			loadHD();
		}
		//Tìm kiếm
			private void timHD() throws SQLException{
				Dao_HopDong dao_hd= new Dao_HopDong();
				tableModel = dao_hd.timKiem(txtTimKiem.getText());
				table.setModel(tableModel);
			}
}


