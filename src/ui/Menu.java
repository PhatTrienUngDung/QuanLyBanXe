package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import entity.HoaDon;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import connect.ConnectDB;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Menu extends JFrame {
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
	private JPanel pnQuanLyKH;
	private JPanel pnQuanLyNV;
	private JPanel pnQLHoaDon;
	private JPanel pnQuanLyHopDong;
	private JPanel pnThongKe;
	private JButton btnTrangChu;
	private JPanel pnTrangChu;
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
		ui_QuanLyXe= new UI_QuanLyXe();
		ui_NhaCungCap = new UI_NhaCungCap();
		ui_KhachHang= new UI_KhachHang();
		ui_HoaDon =new UI_HoaDon();
		ui_HopDong= new UI_HopDong();
		ui_NhanVien= new UI_NhanVien();
		ui_TaiKhoan= new UI_TaiKhoan();
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

		
		pnTrangChu = new JPanel();
		panelMain.add(pnTrangChu, "name_3887874348900");

	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(43,87,154));
		splitPane.setLeftComponent(panel);
		
		btnQLKH = new JButton("Quản Lý Khách Hàng");
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(true);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
			}
		});
		
		btnQLKho = new JButton("Quản Lý Kho Hàng");
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ConnectDB.getInstance().connect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pnQuanLyKho.setVisible(true);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(true);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
			}
		});
		btnQLNV.setForeground(Color.WHITE);
	
		btnQLNV.setBorderPainted(false);
		btnQLNV.setBackground(new Color(43, 87, 154));
		panel.add(btnQLNV);

		btnQLHoaDon = new JButton("Quản Lý Hóa Đơn");
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyKho.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQLHoaDon.setVisible(true);
				
			}
		});
		btnQLHoaDon.setForeground(Color.WHITE);
		btnQLHoaDon.setBorderPainted(false);
		btnQLHoaDon.setBackground(new Color(43, 87, 154));
		panel.add(btnQLHoaDon);
		
		btnQLHD = new JButton("Quản Lý Hợp Đồng");
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(true);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
			}
		});
		btnQLHD.setForeground(Color.WHITE);
		btnQLHD.setBorderPainted(false);
		btnQLHD.setBackground(new Color(43, 87, 154));
		panel.add(btnQLHD);
		
		btnThongKe = new JButton("Thống Kê");
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(true);
				pnTrangChu.setVisible(false);
			}
		});
		

		btnQuanLyNCC = new JButton("Quản Lý Nhà Cung Cấp");
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyNCC.setVisible(true);
				pnQuanLyKho.setVisible(false);
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
		
		
		//panel.setLayout(new UI_HoaDon().setVisible(true));
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
