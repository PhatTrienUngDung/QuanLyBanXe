package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


import connect.ConnectDB;
import dao.Dao_NhanVien;
import dao.Dao_ThongKe;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Font;

public class Menu extends JFrame {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JButton btnQLKho;
	private JButton btnQLKH;
	private JButton btnQLNV;
	private JButton btnQuanLyNCC;
	private JButton btnQLHD;
	private JButton btnThongKe;
	private JButton btnQLHoaDon;
	private JPanel panelMain;
	private JPanel pnQuanLyKho;
	private JPanel pnQuanLyNCC;
	private UI_QuanLyXe ui_QuanLyXe;
	private UI_NhaCungCap ui_NhaCungCap;
	private UI_KhachHang ui_KhachHang;
	private UI_HoaDon ui_HoaDon;
	private UI_HopDong ui_HopDong;
	private UI_NhanVien ui_NhanVien;
	private UI_TaiKhoan ui_TaiKhoan;
	private UI_ThongKe1 ui_ThongKe1;
	private HomePage home;
	private JPanel pnQuanLyKH;
	private JPanel pnQuanLyNV;
	private JPanel pnQLHoaDon;
	private JPanel pnQuanLyHopDong;
	private JPanel pnThongKe;
	private JButton btnTrangChu;
	private JPanel pnTrangChu;
	private JButton btnQuanLyTaiKhoan;
	private JPanel pnTaiKhoan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Menu frame = new Menu();
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
	 * @throws SQLException 
	 */
	public Menu() throws SQLException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (InstantiationException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IllegalAccessException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (UnsupportedLookAndFeelException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		home= new HomePage();
		ui_QuanLyXe= new UI_QuanLyXe();
		ui_NhaCungCap = new UI_NhaCungCap();
		ui_KhachHang= new UI_KhachHang();
		ui_HoaDon =new UI_HoaDon();
		ui_HopDong= new UI_HopDong();
		ui_NhanVien= new UI_NhanVien();
		ui_TaiKhoan= new UI_TaiKhoan();
		ui_ThongKe1= new UI_ThongKe1();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, screen.height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerSize(0);
		getContentPane().add(splitPane, "name_9617081772200");
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		splitPane.setRightComponent(panelMain);
		panelMain.setLayout(new CardLayout(0, 0));
		
		//Giao Dien Quan Ly Kho
		pnQuanLyKho = new JPanel();
		panelMain.add(pnQuanLyKho, "name_7046289087700");
		pnQuanLyKho.setLayout(null);
		ui_QuanLyXe.setVisible(true);
		pnQuanLyKho.add(ui_QuanLyXe.getContentPane());
		ui_QuanLyXe.setVisible(false);
		
		//Giao Dien Quan Ly Nha Cung Cap
		pnQuanLyNCC = new JPanel();
		panelMain.add(pnQuanLyNCC, "name_7054596857300");
		pnQuanLyNCC.setLayout(null);
		ui_NhaCungCap.setVisible(true);
		pnQuanLyNCC.add(ui_NhaCungCap.getContentPane());
		ui_NhaCungCap.setVisible(false);
		
		//Giao Dien Quan Ly Khach Hang
		pnQuanLyKH = new JPanel();
		panelMain.add(pnQuanLyKH, "name_3755726204700");
		pnQuanLyKH.setLayout(null);
		ui_KhachHang.setVisible(true);
		pnQuanLyKH.add(ui_KhachHang.getContentPane());
		ui_KhachHang.setVisible(false);
		
		//Giao Dien Quan Ly Nhan Vien
		pnQuanLyNV = new JPanel();
		panelMain.add(pnQuanLyNV, "name_3759579047400");
		pnQuanLyNV.setLayout(null);
		ui_NhanVien.setVisible(true);
		pnQuanLyNV.add(ui_NhanVien.getContentPane());
		ui_NhanVien.setVisible(false);
		
		//Giao Dien Quan Ly Hoa Don
		pnQLHoaDon = new JPanel();
		panelMain.add(pnQLHoaDon, "name_3761516368600");
		pnQLHoaDon.setLayout(null);
		ui_HoaDon.setVisible(true);
		pnQLHoaDon.add(ui_HoaDon.getContentPane());
		ui_HoaDon.setVisible(false);
		
		pnQuanLyHopDong = new JPanel();
		panelMain.add(pnQuanLyHopDong, "name_3763305576000");
		pnQuanLyHopDong.setLayout(null);
		ui_HopDong.setVisible(true);
		pnQuanLyHopDong.add(ui_HopDong.getContentPane());
		ui_HopDong.setVisible(false);
		
		pnThongKe = new JPanel();
		panelMain.add(pnThongKe, "name_3836959492400");
		pnThongKe.setLayout(null);
		ui_ThongKe1.setVisible(true);
		pnThongKe.add(ui_ThongKe1.getContentPane());
		ui_ThongKe1.setVisible(false);
		//Home
		pnTrangChu = new JPanel();
		panelMain.add(pnTrangChu, "name_3887874348900");
		pnTrangChu.setLayout(null);
		home.setVisible(true);
		pnTrangChu.add(home.getContentPane());
		home.setVisible(false);
		//Giao diện quản lý tài khoản
		pnTaiKhoan = new JPanel();
		panelMain.add(pnTaiKhoan, "name_1832465809800");
		pnTaiKhoan.setLayout(null);
		ui_TaiKhoan.setVisible(true);
		pnTaiKhoan.add(ui_TaiKhoan.getContentPane());
		ui_TaiKhoan.setVisible(false);
	
		pnQuanLyKho.setVisible(false);
		pnTrangChu.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(43,87,154));
		splitPane.setLeftComponent(panel);
		
		btnQLKH = new JButton("Quản Lý Khách Hàng");
		btnQLKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLKH.setForeground(Color.WHITE);
		btnQLKH.setBorderPainted(false);
		btnQLKH.setBackground(new Color(43, 87, 154));
		btnQLKH.setFocusable(false);
		btnQLKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLKH.setBackground(Color.white);
				btnQLKH.setForeground(Color.black);
				btnQLKH.setFocusable(false);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyKH.setVisible(true);
			}
		});
		
		btnQLKho = new JButton("Quản Lý Kho Hàng");
		btnQLKho.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLKho.setFocusable(false);
		btnQLKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLKho.setBackground(Color.white);
				btnQLKho.setForeground(Color.black);
				btnQLKho.setFocusable(false);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ConnectDB.getInstance().connect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pnTaiKhoan.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyKho.add(ui_QuanLyXe.getContentPane());
				pnQuanLyKho.setVisible(true);
				
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnTrangChu.setBackground(Color.white);
				btnTrangChu.setForeground(Color.black);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLNV.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				
			}
		});
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setFocusable(false);
		btnTrangChu.setBorderPainted(false);
		btnTrangChu.setBackground(new Color(43, 87, 154));
		panel.add(btnTrangChu);
		btnQLKho.setForeground(Color.white);
		btnQLKho.setBackground(new Color(43, 87, 154));
		btnQLKho.setBorderPainted(false);
		
		panel.add(btnQLKho);
		panel.add(btnQLKH);
		
		btnQLNV = new JButton("Quản Lý Nhân Viên");
		btnQLNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLNV.setFocusable(false);
		btnQLNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLNV.setBackground(Color.white);
				btnQLNV.setForeground(Color.black);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyNV.add(ui_NhanVien.getContentPane());
				pnQuanLyNV.setVisible(true);
			}
		});
		btnQLNV.setForeground(Color.WHITE);
	
		btnQLNV.setBorderPainted(false);
		btnQLNV.setBackground(new Color(43, 87, 154));
		panel.add(btnQLNV);

		btnQLHoaDon = new JButton("Quản Lý Hóa Đơn");
		btnQLHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLHoaDon.setFocusable(false);
		btnQLHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLHoaDon.setBackground(Color.white);
				btnQLHoaDon.setForeground(Color.black);
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQLHoaDon.add(ui_HoaDon.getContentPane());
				pnQLHoaDon.setVisible(true);
			}
		});
		btnQLHoaDon.setForeground(Color.WHITE);
		btnQLHoaDon.setBorderPainted(false);
		btnQLHoaDon.setBackground(new Color(43, 87, 154));
		panel.add(btnQLHoaDon);
		
		btnQLHD = new JButton("Quản Lý Hợp Đồng");
		btnQLHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLHD.setFocusable(false);
		btnQLHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLHD.setBackground(Color.white);
				btnQLHD.setForeground(Color.black);
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyHopDong.add(ui_HopDong.getContentPane());
				pnQuanLyHopDong.setVisible(true);
			}
		});
		btnQLHD.setForeground(Color.WHITE);
		btnQLHD.setBorderPainted(false);
		btnQLHD.setBackground(new Color(43, 87, 154));
		panel.add(btnQLHD);
		
		btnThongKe = new JButton("Thống Kê");
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThongKe.setFocusable(false);
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnThongKe.setBackground(Color.white);
				btnThongKe.setForeground(Color.black);
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQLHD.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnTrangChu.setVisible(false);
				pnThongKe.add(ui_ThongKe1.getContentPane());
				pnThongKe.setVisible(true);
				ui_ThongKe1.LoadTong();
			}
		});
		

		btnQuanLyNCC = new JButton("Quản Lý Nhà Cung Cấp");
		btnQuanLyNCC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLyNCC.setFocusable(false);
		btnQuanLyNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuanLyNCC.setBackground(Color.white);
				btnQuanLyNCC.setForeground(Color.black);
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnTrangChu.setVisible(false);
				pnThongKe.setVisible(false);
				pnQuanLyNCC.add(ui_NhaCungCap.getContentPane());
				pnQuanLyNCC.setVisible(true);
				
			}
		});
		btnQuanLyNCC.setForeground(Color.WHITE);
		btnQuanLyNCC.setBorderPainted(false);
		btnQuanLyNCC.setBackground(new Color(43, 87, 154));
		panel.add(btnQuanLyNCC);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(43, 87, 154));
		panel.add(btnThongKe);
		
		btnQuanLyTaiKhoan = new JButton("Quản Lý Tài Khoản");
		btnQuanLyTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLyTaiKhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuanLyTaiKhoan.setBackground(Color.white);
				btnQuanLyTaiKhoan.setForeground(Color.black);
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setForeground(Color.white);
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnTrangChu.setVisible(false);
				pnThongKe.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnTaiKhoan.add(ui_TaiKhoan.getContentPane());
				pnTaiKhoan.setVisible(true);
				
			}
		});
		btnQuanLyTaiKhoan.setForeground(Color.WHITE);
		btnQuanLyTaiKhoan.setFocusable(false);
		btnQuanLyTaiKhoan.setBorderPainted(false);
		btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
		panel.add(btnQuanLyTaiKhoan);
		
		btnTrangChu.setBackground(Color.white);
		btnTrangChu.setForeground(Color.black);

		JPanel panel1 = new JPanel();
		JButton btnUser = new JButton();
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		String ten = dao_nv.getTenNhanVienById(Login.txtuser.getText());
		btnUser.setText(ten);
		btnUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUser.setForeground(Color.WHITE);
		btnUser.setBorderPainted(false);
		btnUser.setBackground(new Color(43, 87, 154));
		btnQLKH.setFocusable(false);
		panel1.add(btnUser, BorderLayout.EAST);
		panel1.setBackground(new Color(43, 87, 154));
		panel.add(panel1, BorderLayout.EAST);
		
		//panel.setLayout(new UI_HoaDon().setVisible(true));
		
	}
}
