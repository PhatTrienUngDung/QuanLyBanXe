package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.CardLayout;

import connect.ConnectDB;
import dao.Dao_ThongKe;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI_ThongKe1 extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private JTextField txtTen;
	private JTextField txtSl;
	private JTextField txtTongTien;
	private JRadioButton rdThang;
	private JRadioButton rdNgay;
	private JRadioButton rdNam;
	private Dao_ThongKe dao_ThongKe = new Dao_ThongKe();
	private JTable table;
	private JComboBox cbNam;
	private JComboBox cbThang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_ThongKe1 frame = new UI_ThongKe1();
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
	public UI_ThongKe1() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, (screen.height-50));
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1532, 78);
		contentPane.add(panel);
		
		JButton btnLoai = new JButton("");
		btnLoai.setIcon(new ImageIcon("img1\\money.png"));
		btnLoai.setFocusable(false);
		btnLoai.setBorderPainted(false);
		btnLoai.setBackground(Color.WHITE);
		btnLoai.setBounds(157, 10, 120, 43);
		panel.add(btnLoai);
		
		JButton btnHang = new JButton("");
		btnHang.setIcon(new ImageIcon("img1\\Customer.png"));
		btnHang.setFocusable(false);
		btnHang.setBorderPainted(false);
		btnHang.setBackground(Color.WHITE);
		btnHang.setBounds(326, 10, 120, 43);
		panel.add(btnHang);
		
		JButton btnXe = new JButton("");
		btnXe.setIcon(new ImageIcon("img1\\cruise-bike-icon.png"));
		btnXe.setFocusable(false);
		btnXe.setBorderPainted(false);
		btnXe.setBackground(Color.WHITE);
		btnXe.setBounds(10, 10, 93, 43);
		panel.add(btnXe);
		
		JLabel lbXe = new JLabel("Thống Kê Xe");
		lbXe.setHorizontalAlignment(SwingConstants.CENTER);
		lbXe.setBounds(10, 55, 93, 13);
		panel.add(lbXe);
		
		JLabel lblLoiXe = new JLabel("Thống Kê Doanh Thu");
		lblLoiXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoiXe.setBounds(144, 55, 148, 13);
		panel.add(lblLoiXe);
		
		JLabel lblHngSnXut = new JLabel("Thống Kê Khách Hàng");
		lblHngSnXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngSnXut.setBounds(313, 55, 148, 13);
		panel.add(lblHngSnXut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(25, 88, 314, 176);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Thống kê số lượng xe mới
		JLabel lbThongKeXeMoi = new JLabel("");
		lbThongKeXeMoi.setBackground(Color.BLACK);
		lbThongKeXeMoi.setForeground(Color.WHITE);
		
		lbThongKeXeMoi.setBounds(0, 0, 314, 176);
		BufferedImage img = null;
		String imgURL= "img\\1.png";
		try {
		    img = ImageIO.read(new File(imgURL));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JLabel lbTKXM = new JLabel("Tổng Số Lượng Xe Mới Trong Tháng");
		lbTKXM.setForeground(Color.WHITE);
		lbTKXM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTKXM.setHorizontalAlignment(SwingConstants.CENTER);
		lbTKXM.setBounds(10, 10, 294, 34);
		panel_1.add(lbTKXM);
		
		JLabel lbSLXeMoi = new JLabel("...");
		
		lbSLXeMoi.setForeground(Color.WHITE);
		lbSLXeMoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLXeMoi.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLXeMoi.setBounds(74, 46, 167, 63);
		panel_1.add(lbSLXeMoi);
		lbThongKeXeMoi.setIcon(imageIcon);
		panel_1.add(lbThongKeXeMoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(409, 88, 314, 176);
		contentPane.add(panel_2);
		
		//Thống kê số lượng xe bán
		JLabel lbThongKeSoLuongXeBan = new JLabel("");
		lbThongKeSoLuongXeBan.setBounds(0, 0, 314, 176);
		BufferedImage img1 = null;
		String imgURL1= "img\\2.png";
		try {
		    img1 = ImageIO.read(new File(imgURL1));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg1 = img1.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon1 = new ImageIcon(dimg1);
		
		JLabel lbTKXB = new JLabel("Tổng Số Lượng Xe Bán Trong Tháng");
		lbTKXB.setHorizontalAlignment(SwingConstants.CENTER);
		lbTKXB.setForeground(Color.WHITE);
		lbTKXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTKXB.setBounds(10, 0, 294, 34);
		panel_2.add(lbTKXB);
		
		JLabel lbSLXeBan = new JLabel("...");
		
		lbSLXeBan.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLXeBan.setForeground(Color.WHITE);
		lbSLXeBan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLXeBan.setBounds(77, 46, 167, 63);
		panel_2.add(lbSLXeBan);
		lbThongKeSoLuongXeBan.setIcon(imageIcon1);
		panel_2.add(lbThongKeSoLuongXeBan);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(805, 88, 314, 176);
		contentPane.add(panel_3);
		
		//Thống kê doanh thu
		JLabel lbThongKeSoTienDaBan = new JLabel("");
		lbThongKeSoTienDaBan.setBounds(0, 0, 314, 176);
		BufferedImage img2 = null;
		String imgURL2= "img\\3.png";
		try {
		    img2 = ImageIO.read(new File(imgURL2));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg2 = img2.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon2 = new ImageIcon(dimg2);
		
		JLabel lbSTDB = new JLabel("Tổng Doanh Thu Trong Tháng");
		lbSTDB.setHorizontalAlignment(SwingConstants.CENTER);
		lbSTDB.setForeground(Color.WHITE);
		lbSTDB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSTDB.setBounds(10, 0, 294, 34);
		panel_3.add(lbSTDB);
		
		JLabel lbSLTienBan = new JLabel("...");
		lbSLTienBan.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLTienBan.setForeground(Color.WHITE);
		lbSLTienBan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLTienBan.setBounds(77, 46, 167, 63);
		panel_3.add(lbSLTienBan);
		lbThongKeSoTienDaBan.setIcon(imageIcon2);
		panel_3.add(lbThongKeSoTienDaBan);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(1200, 88, 314, 176);
		contentPane.add(panel_4);
		
		//Thống kê khách hàng 
		JLabel lbThongKeKH = new JLabel("");
		lbThongKeKH.setBounds(0, 0, 314, 176);
		BufferedImage img3 = null;
		String imgURL3= "img\\4.png";
		try {
		    img3 = ImageIO.read(new File(imgURL3));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg3 = img3.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon3 = new ImageIcon(dimg3);
		
		JLabel lbSLKH = new JLabel("Tổng Số Lượng Khách Hàng Mới Trong Tháng");
		lbSLKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLKH.setForeground(Color.WHITE);
		lbSLKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSLKH.setBounds(10, 0, 294, 34);
		panel_4.add(lbSLKH);
		
		JLabel lbSLKhachHang = new JLabel("...");
		lbSLKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLKhachHang.setForeground(Color.WHITE);
		lbSLKhachHang.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLKhachHang.setBounds(77, 46, 167, 63);
		panel_4.add(lbSLKhachHang);
		lbThongKeKH.setIcon(imageIcon3);
		panel_4.add(lbThongKeKH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(25, 274, 1492, 493);
		
		DefaultCategoryDataset dcd= new DefaultCategoryDataset();
		for (int i = 1; i <= 12; i++) {
			dcd.addValue(i*10, "Số lượng", "Tháng "+i);
		}
		
//		dcd.addValue(100, "Số lượng", "Tháng 2");
//		dcd.addValue(200, "Số lượng", "Tháng 3");
//		dcd.addValue(14, "Số lượng", "Tháng 4");
//		dcd.addValue(16, "Số lượng", "Tháng 5");
//		dcd.addValue(19, "Số lượng", "Tháng 6");
//		dcd.addValue(29, "Số lượng", "Tháng 7");
//		dcd.addValue(22, "Số lượng", "Tháng 8");
//		dcd.addValue(26, "Số lượng", "Tháng 9");
//		dcd.addValue(23, "Số lượng", "Tháng 10");
//		dcd.addValue(11, "Số lượng", "Tháng 11");
//		dcd.addValue(223, "Số lượng", "Tháng 12");
		
		JFreeChart jchart= ChartFactory.createBarChart("Thống kê số lượng xe bán", "Tháng", "Số lượng", dcd, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot= jchart.getCategoryPlot();
		jchart.setBackgroundPaint(Color.white);
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		Color color = new Color(0, 192, 0);
		renderer.setSeriesPaint(0, color);
		plot.setRangeGridlinePaint(Color.black);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setLayout(null);
		ChartPanel chartPanel= new ChartPanel(jchart);
		chartPanel.setBounds(10, 63, 933, 420);
		chartPanel.setBackground(Color.white);
		chartPanel.setLayout(null);
		panel_6.add(chartPanel);
		panel_5.add(panel_6, "name_6412416537300");
		
		JLabel lblNewLabel = new JLabel("Lọc ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 15, 42, 24);
		panel_6.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tháng");
		lblNewLabel_1.setBounds(63, 22, 45, 13);
		panel_6.add(lblNewLabel_1);
		
		cbThang = new JComboBox();
		cbThang.setBackground(Color.WHITE);
		cbThang.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		cbThang.setBounds(118, 18, 85, 21);
		for (int i = 1; i <= 12; i++) {
			cbThang.addItem(i);
		}
		cbThang.setSelectedItem(LocalDate.now().getMonthValue());
		panel_6.add(cbThang);
		
		JLabel lblNewLabel_1_1 = new JLabel("Năm");
		lblNewLabel_1_1.setBounds(218, 22, 45, 13);
		panel_6.add(lblNewLabel_1_1);
		
		cbNam = new JComboBox();
		cbNam.setBackground(Color.WHITE);
		cbNam.setBounds(254, 18, 85, 21);
		for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
			cbNam.addItem(i);
		}
		int t=LocalDate.now().getMonthValue();
		int n=LocalDate.now().getYear();
		lbSLXeMoi.setText(dao_ThongKe.SoLuongXeNhapTrongThang(t, n));
		cbNam.setSelectedItem(LocalDate.now().getYear());
		lbSLXeBan.setText(dao_ThongKe.SoLuongXeBanTrongThang(t, n));
		panel_6.add(cbNam);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(null);
		panel_7.setBounds(395, 15, 359, 28);
		panel_6.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		rdNgay = new JRadioButton("Theo Ngày");
		rdNgay.setSelected(true);
		rdNgay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdNgay.isSelected()) {
					rdThang.setSelected(false);
					rdNam.setSelected(false);
				}
			}
		});
		panel_7.add(rdNgay);
		rdNgay.setBackground(Color.WHITE);
		
		rdThang = new JRadioButton("Theo Tháng");
		rdThang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdThang.isSelected()) {
					rdNgay.setSelected(false);
					rdNam.setSelected(false);
				}
			}
		});
		panel_7.add(rdThang);
		rdThang.setBackground(Color.WHITE);
		
		rdNam = new JRadioButton("Theo Năm");
		rdNam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdNam.isSelected()) {
					rdNgay.setSelected(false);
					rdThang.setSelected(false);
				}
			}
		});
		panel_7.add(rdNam);
		rdNam.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(978, 63, 504, 420);
		panel_6.add(scrollPane);
		
		
		String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
		tableModel= new DefaultTableModel(header,0);
		table = new JTable(tableModel);
		try {
			loadThongKe();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table.getColumnModel().getColumn(1).setPreferredWidth(5);
	    table.setRowHeight(30);
	    table.setShowGrid(false);
	    table.getColumnModel().getColumn(1).setPreferredWidth(5);
		scrollPane.setViewportView(table);
		Border border = new LineBorder(Color.white);
		scrollPane.setBorder(border);
		table.getTableHeader().setBorder(border);
		DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		renderer1.setHorizontalAlignment(SwingConstants.LEFT);
		table.getTableHeader().setBackground(Color.white);
		table.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Lọc");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (rdThang.isSelected()) {
						loadThongKe();
					}
					if(rdNam.isSelected()) {
						loadThongKeThang();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(768, 18, 85, 21);
		panel_6.add(btnNewButton);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(panel_5);
		TableCellRenderer baseRenderer = table.getTableHeader().getDefaultRenderer();
		table.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(baseRenderer));
	}
	private void loadThongKe() throws SQLException {
		int t=(int) cbThang.getSelectedItem();
		int n=(int) cbNam.getSelectedItem();
		Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModel = dao_thongKe.getAllCTHD(t, n);
		table.setModel(tableModel);
	}
	private void loadThongKeThang() throws SQLException {
		int n=(int) cbNam.getSelectedItem();
		Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModel = dao_thongKe.getAllYear(n);
		table.setModel(tableModel);
	}
}
