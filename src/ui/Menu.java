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
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JPanel panel_1;
	private JPanel panel_2;
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
	 */
	public Menu() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, screen.height);
		
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
		
		panel_1 = new JPanel();
		panelMain.add(panel_1, "name_7046289087700");
		panel_1.setLayout(null);
		
		
		panel_2 = new JPanel();
		panelMain.add(panel_2, "name_7054596857300");
		panel_2.setLayout(null);
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
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				UI_QuanLyXe ui_QuanLyXe= new UI_QuanLyXe();
				panel.add(ui_QuanLyXe.getContentPane());
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		btnQLKho.setForeground(Color.WHITE);
		btnQLKho.setBackground(new Color(43,87,154));
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
			}
		});
		btnQLHoaDon.setForeground(Color.WHITE);
		btnQLHoaDon.setBorderPainted(false);
		btnQLHoaDon.setBackground(new Color(43, 87, 154));
		panel.add(btnQLHoaDon);
		

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
			}
		});
		btnQuanLyNCC.setForeground(Color.WHITE);
		btnQuanLyNCC.setBorderPainted(false);
		btnQuanLyNCC.setBackground(new Color(43, 87, 154));
		panel.add(btnQuanLyNCC);
		
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
			}
		});
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(43, 87, 154));
		panel.add(btnThongKe);
		
		
		UI_HoaDon ui_HoaDon= new UI_HoaDon();
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
