package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;

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
import java.awt.SystemColor;

public class UI_ThongKe1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel tableModel;
	@SuppressWarnings("unused")
	private JTextField txtTen;
	@SuppressWarnings("unused")
	private JTextField txtSl;
	@SuppressWarnings("unused")
	private JTextField txtTongTien;
	private JRadioButton rdThang;
	private JRadioButton rdNgay;
	private JRadioButton rdNam;
	private Dao_ThongKe dao_ThongKe = new Dao_ThongKe();
	private JTable table;
	private DefaultCategoryDataset dcd;
	@SuppressWarnings("rawtypes")
	private JComboBox cbNam= new JComboBox<>();
	@SuppressWarnings("rawtypes")
	private JComboBox cbThang= new JComboBox<>();;
	
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		panel_1.setBounds(25, 88, 337, 176);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Thống kê số lượng xe mới
		JLabel lbThongKeXeMoi = new JLabel("");
		lbThongKeXeMoi.setBackground(Color.BLACK);
		lbThongKeXeMoi.setForeground(Color.WHITE);
		
		lbThongKeXeMoi.setBounds(0, 0, 337, 176);
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
		lbTKXM.setBounds(10, 10, 317, 34);
		panel_1.add(lbTKXM);
		
		JLabel lbSLXeMoi = new JLabel("...");
		
		lbSLXeMoi.setForeground(Color.WHITE);
		lbSLXeMoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLXeMoi.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLXeMoi.setBounds(10, 46, 317, 63);
		panel_1.add(lbSLXeMoi);
		lbThongKeXeMoi.setIcon(imageIcon);
		panel_1.add(lbThongKeXeMoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(409, 88, 337, 176);
		contentPane.add(panel_2);
		
		//Thống kê số lượng xe bán
		JLabel lbThongKeSoLuongXeBan = new JLabel("");
		lbThongKeSoLuongXeBan.setBounds(0, 0, 337, 176);
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
		lbTKXB.setBounds(0, 0, 337, 34);
		panel_2.add(lbTKXB);
		
		JLabel lbSLXeBan = new JLabel("...");
		
		lbSLXeBan.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLXeBan.setForeground(Color.WHITE);
		lbSLXeBan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLXeBan.setBounds(10, 46, 317, 63);
		panel_2.add(lbSLXeBan);
		lbThongKeSoLuongXeBan.setIcon(imageIcon1);
		panel_2.add(lbThongKeSoLuongXeBan);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(800, 88, 337, 176);
		contentPane.add(panel_3);
		
		//Thống kê doanh thu
		JLabel lbThongKeSoTienDaBan = new JLabel("");
		lbThongKeSoTienDaBan.setBounds(0, 0, 337, 176);
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
		lbSTDB.setBounds(0, 0, 337, 34);
		panel_3.add(lbSTDB);
		
		JLabel lbSLTienBan = new JLabel("...");
		lbSLTienBan.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLTienBan.setForeground(Color.WHITE);
		lbSLTienBan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLTienBan.setBounds(0, 47, 337, 63);
		panel_3.add(lbSLTienBan);
		lbThongKeSoTienDaBan.setIcon(imageIcon2);
		panel_3.add(lbThongKeSoTienDaBan);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(1189, 88, 323, 176);
		contentPane.add(panel_4);
		
		//Thống kê khách hàng 
		JLabel lbThongKeKH = new JLabel("");
		lbThongKeKH.setBounds(0, 0, 337, 176);
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
		
		JLabel lbSLKH = new JLabel("Tổng Khách Hàng Mới Trong Tháng");
		lbSLKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLKH.setForeground(Color.WHITE);
		lbSLKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSLKH.setBounds(10, 0, 294, 34);
		panel_4.add(lbSLKH);
		
		JLabel lbSLKhachHang = new JLabel("...");
		lbSLKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLKhachHang.setForeground(Color.WHITE);
		lbSLKhachHang.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLKhachHang.setBounds(0, 46, 323, 63);
		panel_4.add(lbSLKhachHang);
		lbThongKeKH.setIcon(imageIcon3);
		panel_4.add(lbThongKeKH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(25, 308, 1492, 459);
		//Thống kê bằng biểu đồ
		dcd= new DefaultCategoryDataset();
		for (int i = 1; i <= 12; i++) {
			dcd.addValue(dao_ThongKe.BieuDoXeNhap(i, LocalDate.now().getYear()), "Số lượng Nhập", "Tháng "+i);
			dcd.addValue(dao_ThongKe.BieuDoXeBan(i, LocalDate.now().getYear()), "Số lượng Bán", "Tháng "+i);
		}

		JFreeChart jchart= ChartFactory.createBarChart("Thống kê số lượng xe bán", "Tháng", "Số lượng", dcd, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot= jchart.getCategoryPlot();
		jchart.setBackgroundPaint(Color.white);
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		Color color = new Color(0, 192, 0);
		renderer.setSeriesPaint(0, color);
		plot.setRangeGridlinePaint(Color.black);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JPanel pnChart = new JPanel();
		pnChart.setBackground(Color.WHITE);
		pnChart.setLayout(null);
		ChartPanel chartPanel= new ChartPanel(jchart);
		chartPanel.setBounds(10, 10, 933, 420);
		chartPanel.setBackground(Color.white);
		chartPanel.setLayout(null);
		pnChart.add(chartPanel);
		panel_5.add(pnChart, "name_6412416537300");
		//Hàm đọc số lượng
		int t=LocalDate.now().getMonthValue();
		int n=LocalDate.now().getYear();
		lbSLXeMoi.setText(String.valueOf(dao_ThongKe.BieuDoXeNhap(t, n)));
		
		lbSLXeBan.setText(String.valueOf(dao_ThongKe.BieuDoXeBan(t, n)));
		
		lbSLKhachHang.setText(String.valueOf(dao_ThongKe.SoLuongKhachHangTrongThang(t, n)));
		DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
		lbSLTienBan.setText(df.format(dao_ThongKe.TongTienTheoThang(t, n)));
		System.out.println(df.format(dao_ThongKe.TongTienTheoNam(2020)));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(978, 10, 504, 420);
		pnChart.add(scrollPane);
		
		
		String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
		tableModel= new DefaultTableModel(header,0);
		table = new JTable(tableModel);
		table.setEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		try {
			tableModel = dao_thongKe.getAllCTHD(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		table.setModel(tableModel);
		
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
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(panel_5);
		
		JLabel lbLoc = new JLabel("Lọc ");
		lbLoc.setBounds(25, 274, 42, 24);
		contentPane.add(lbLoc);
		lbLoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbThang = new JLabel("Tháng");
		lbThang.setBounds(78, 281, 45, 13);
		contentPane.add(lbThang);
		
		cbThang.setBounds(133, 277, 85, 21);
		contentPane.add(cbThang);
		cbThang.setBackground(Color.WHITE);
		cbThang.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		cbThang.setSelectedItem(LocalDate.now().getMonthValue());
		
		JLabel lbNam = new JLabel("Năm");
		lbNam.setBounds(233, 281, 45, 13);
		contentPane.add(lbNam);
		
		cbNam.setBounds(269, 277, 85, 21);
		contentPane.add(cbNam);
		cbNam.setBackground(Color.WHITE);
		cbNam.setSelectedItem(LocalDate.now().getYear());
		
		for (int i = 1; i <= 12; i++) {
			cbThang.addItem(i);
		}
		for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
			cbNam.addItem(i);
		}
		cbThang.setSelectedItem(LocalDate.now().getMonthValue());
		cbNam.setSelectedItem(LocalDate.now().getYear());
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.control);
		panel_7.setBounds(410, 274, 359, 28);
		contentPane.add(panel_7);
		panel_7.setBorder(null);
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
		rdNgay.setBackground(SystemColor.control);
		
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
		rdThang.setBackground(SystemColor.control);
		
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
		rdNam.setBackground(SystemColor.control);
		//Bộ lọc quyền năng
		JButton txtLoc = new JButton("Lọc");
		txtLoc.setBounds(783, 277, 85, 21);
		contentPane.add(txtLoc);
		txtLoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int t1=(int) cbThang.getSelectedItem();
					int n1=(int) cbNam.getSelectedItem();
					DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
					if (rdThang.isSelected()) {
						loadThongKeThang();
						lbSLXeMoi.setText(String.valueOf(dao_ThongKe.BieuDoXeNhap(t1, n1)));
						lbSLXeBan.setText(String.valueOf(dao_ThongKe.BieuDoXeBan(t1, n1)));
						lbSLKhachHang.setText(String.valueOf(dao_ThongKe.SoLuongKhachHangTrongThang(t1, n1)));
						lbSLTienBan.setText(df.format(dao_ThongKe.TongTienTheoThang(t1, n1)));
						lbTKXB.setText("Tổng Số Lượng Xe Bán Trong Tháng");
						lbTKXM.setText("Tổng Số Lượng Xe Mới Trong Tháng");
						lbSTDB.setText("Tổng Doanh Thu Trong Tháng");
						lbSLKH.setText("Tổng Khách Hàng Mới Trong Tháng");
						//Biểu đồ
						int t2=(int) cbThang.getSelectedItem();
						int n2=(int) cbNam.getSelectedItem();
						Calendar calendar = Calendar.getInstance();
						calendar.set(n2, t2, 0);
						int maxDay =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
						System.out.println("dsa"+maxDay);
						for (int i = 1; i <=maxDay; i++) {
							dcd.addValue(dao_ThongKe.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(dao_ThongKe.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
							System.out.println(dao_ThongKe.BieuDoXeNhap(i, t2,n2));
						}
						for (int i = 1; i <=maxDay; i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán", String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 1; i <= 12; i++) {
							dcd.addValue(dao_ThongKe.BieuDoXeNhap(i, n2), "Số lượng Nhập", "Tháng "+i);
							dcd.addValue(dao_ThongKe.BieuDoXeBan(i, n2), "Số lượng Bán", "Tháng "+i);
						}
						
					}
					if(rdNam.isSelected()) {
						if(dao_ThongKe.SoLuongXeNhapTrongNam(n1)==null) {
							lbSLXeMoi.setText("0");
						}
						else {
							lbSLXeMoi.setText(dao_ThongKe.SoLuongXeNhapTrongNam(n1));
						}
						lbSLXeBan.setText(String.valueOf(dao_ThongKe.SoLuongXeBanTrongNam(n1)));
						lbSLKhachHang.setText(String.valueOf(dao_ThongKe.SoLuongKhachHangTrongNam(n1)));				
						lbSLTienBan.setText(df.format(dao_ThongKe.TongTienTheoNam(n)));
						System.out.println(df.format(dao_ThongKe.TongTienTheoNam(n)));
						lbTKXB.setText("Tổng Số Lượng Xe Bán Trong Năm");
						lbTKXM.setText("Tổng Số Lượng Xe Mới Trong Năm");
						lbSTDB.setText("Tổng Doanh Thu Trong Năm");
						lbSLKH.setText("Tổng Khách Hàng Mới Trong Năm");
						loadThongKeNam();
					}
					if(rdNgay.isSelected()) {
						int t2=(int) cbThang.getSelectedItem();
						int n2=(int) cbNam.getSelectedItem();
						Calendar calendar = Calendar.getInstance();
						calendar.set(n2, t2, 0);
						int maxDay =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
						System.out.println("dsa"+maxDay);
						for (int i = 1; i <= 12; i++) {
							dcd.addValue(dao_ThongKe.BieuDoXeNhap(i, LocalDate.now().getYear()), "Số lượng Nhập", "Tháng "+i);
							dcd.addValue(dao_ThongKe.BieuDoXeBan(i, LocalDate.now().getYear()), "Số lượng Bán", "Tháng "+i);
						}
						for (int i = 1; i <=12; i++) {
							dcd.removeValue("Số lượng Nhập", "Tháng "+i);
							dcd.removeValue("Số lượng Bán", "Tháng "+i);
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 1; i <=maxDay; i++) {
							dcd.addValue(dao_ThongKe.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(dao_ThongKe.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
							System.out.println(dao_ThongKe.BieuDoXeNhap(i, t2,n2));
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		TableCellRenderer baseRenderer = table.getTableHeader().getDefaultRenderer();
		table.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(baseRenderer));
	}
	private void loadThongKeThang() throws SQLException {
		int n=(int) cbNam.getSelectedItem();
		int t=(int) cbThang.getSelectedItem();
		Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModel = dao_thongKe.getAllCTHD(t, n);
		table.setModel(tableModel);
	}
	private void loadThongKeNam() throws SQLException {
		int n=(int) cbNam.getSelectedItem();
		Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModel = dao_thongKe.getAllYear(n);
		table.setModel(tableModel);
	}
}
