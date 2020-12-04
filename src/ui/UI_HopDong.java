package ui;

import java.awt.BorderLayout;





import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
//import java.lang.FdLibm.Cbrt;
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
import entity.ChucVu;
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
import javax.swing.JTextArea;

public class UI_HopDong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

		//ArrayList<KhachHang> tableModel;
	private DefaultTableModel tableModel1,tableModel;
	private Dao_HopDong dao_hd = new Dao_HopDong();
	private Dao_QuanLyXe dao_qlXe = new Dao_QuanLyXe();
	//private Dao_KhachHang dao_kh = new Dao_KhachHang();
	private Dao_NhanVien dao_nv = new Dao_NhanVien();
	
	private JTable table_1;
	private JTextField txtcmnd;
	private JTextField txttenKH;
	private JTextField textField_4;
	private JDateChooser dateChooser;

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
		


		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1522, 78);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
	
		
		
		
		JLabel lblNewLabel_1 = new JLabel("QUáº¢N LÃ THÃ”NG TIN Há»¢P Äá»’NG");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 88, 439, 72);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 170, 1084, 209);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		String [] header1 = {"MÃ£ há»£p Ä‘á»“ng","CMND","TÃªn khÃ¡ch hÃ ng","Sá»‘ Ä‘iá»‡n thoáº¡i","MÃ£ xe","TÃªn xe","Loáº¡i xe","PhiÃªn báº£n","PhÃ¢n khá»‘i","Sá»‘ khung","ÄÆ¡n giÃ¡","Thuáº¿","NgÃ y láº­p","Thá»i gian báº£o hÃ nh"};
		tableModel1 = new DefaultTableModel(header1,0);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 1084, 209);
		panel_2.add(scrollPane_2);
		
		table_1 = new JTable(tableModel1);
		try {
			loadHD();
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		scrollPane_2.setViewportView(table_1);
		
		String [] header = {"MÃ£ xe","TÃªn xe","Loáº¡i xe","PhiÃªn báº£n","PhÃ¢n khá»‘i","Sá»‘ khung","ÄÆ¡n giÃ¡","Thuáº¿","Tráº¡ng thÃ¡i"};
		tableModel = new DefaultTableModel(header,0);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 404, 1084, 200);
		panel.add(scrollPane);
		
		table = new JTable(tableModel);
		try {
			loadXe();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(1104, 170, 398, 200);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNgyChn = new JLabel("NgÃ y chá»n");
		lblNgyChn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyChn.setBounds(10, 26, 80, 23);
		panel_3.add(lblNgyChn);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyy/MM/dd");
		dateChooser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(dateChooser.getDate().toString().length()==0) {
					try {
						loadHD();
					
					}catch (SQLException e2) {
						e2.printStackTrace();
						// TODO: handle exception
					}
				}if(dateChooser.getDate().toString().length()>0) {
					try {
						timNgay();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(dateChooser.getDate().toString().length()==0) {
//					try {
//						loadHD();
//					
//					}catch (SQLException e2) {
//						e2.printStackTrace();
//						// TODO: handle exception
//					}
//				}if(dateChooser.getDate().toString().length()>0) {
//					try {
//						timNgay();
//					} catch (SQLException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//				}
//			}
			});
		dateChooser.setBounds(152, 26, 180, 23);
	
	//	String ngayLap =  dateChooser.getDate().toString();
		panel_3.add(dateChooser);
		
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCmnd.setBounds(10, 73, 80, 13);
		panel_3.add(lblCmnd);
		
		txtcmnd = new JTextField();	
		txtcmnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtcmnd.getText().length()==0) {
					try {
						loadHD();
					//	loadXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					ArrayList<KhachHang> dsKH = dao_hd.getAllKH();
//					for (int i = 0; i < dsKH.size(); i++) {
//						if(txtcmnd.getText().equalsIgnoreCase(dsKH.get(i).getCMND())) {
//						
//							txttenKH.setText(dsKH.get(i).getTenKhachHang());
//						}
//					}
				}
				if(txtcmnd.getText().length()>0) {
					try {
						timHD();
					 
						//timXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(txtcmnd.getText().length()==0 && dateChooser.getDate().toString().length()==0) {
					try {
						loadHD();
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(txtcmnd.getText().length()>0 && dateChooser.getDate().toString().length()>0) {
					try {
						locData();
					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				ArrayList<KhachHang> dsKH = dao_hd.getAllKH();
				for (int i = 0; i < dsKH.size(); i++) {
					if(txtcmnd.getText().equalsIgnoreCase(dsKH.get(i).getCMND())) {
					
						txttenKH.setText(dsKH.get(i).getTenKhachHang());
					}
				}
			}
			
		});
		
		txtcmnd.setBounds(152, 66, 180, 20);
		panel_3.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(10, 109, 132, 19);
		panel_3.add(lblTnKhchHng);
		
	
		txttenKH = new JTextField();
		txttenKH.setBounds(152, 108, 180, 20);
		panel_3.add(txttenKH);
		txttenKH.setColumns(10);
		
		
		JButton btnTaoMoi = new JButton("Tạo mới");		
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTaoMoi.setBackground(Color.ORANGE);
		btnTaoMoi.setBounds(65, 158, 115, 32);
		btnTaoMoi.setIcon(new ImageIcon("img1/add.png"));
		panel_3.add(btnTaoMoi);
		
		JButton btnLamSach = new JButton("Làm sạch");
		btnLamSach.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLamSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser.setDate(null);
				txtcmnd.setText("");
				txttenKH.setText("");
				dateChooser.requestFocus();
				try {
					loadHD();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLamSach.setBackground(Color.ORANGE);
		btnLamSach.setBounds(221, 158, 122, 32);
		btnLamSach.setIcon(new ImageIcon("img1/refresh.png"));
		panel_3.add(btnLamSach);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(1104, 407, 398, 197);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNhapCmnd = new JLabel("Nhập số CMND");
		lblNhapCmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhapCmnd.setBounds(10, 33, 131, 13);
		panel_4.add(lblNhapCmnd);
		
		textField_4 = new JTextField();
		textField_4.setBounds(151, 20, 189, 31);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnTimKiem = new JButton("TÃ¬m");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_4.getText().length()==0) {
					try {
						loadHD();
					//	loadXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(textField_4.getText().length()>0) {
					try {
						timKiemHD();
					 
						//timXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setBounds(230, 115, 99, 41);
		btnTimKiem.setIcon(new ImageIcon("img1/search2.png"));
		
		panel_4.add(btnTimKiem);
		
		JButton btnXuatHD = new JButton("Xuất");
		btnXuatHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob printjob =  PrinterJob.getPrinterJob();
				printjob.setJobName("Hãng mua bán xe");
				printjob.setPrintable(new Printable() {
					
					@Override
					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						if(pageIndex > 0){
							return Printable.NO_SUCH_PAGE;
						}
						return Printable.PAGE_EXISTS;
					}
				});
				boolean returningResult = printjob.printDialog();
				if(returningResult) {
					try {
						printjob.print();
					}catch (PrinterException printException) {
						JOptionPane.showMessageDialog(null, "Print Error" + printException.getMessage());
						// TODO: handle exception
					}
				}
			}
		});
		btnXuatHD.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatHD.setBackground(Color.ORANGE);
		btnXuatHD.setBounds(67, 115, 99, 41);
		btnXuatHD.setIcon(new ImageIcon("img1/update.png"));
		panel_4.add(btnXuatHD);
		
//		JButton btnInHD = new JButton("In");
//		btnInHD.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			//	PrinterException printer = new PrinterException();
//				
//				}
//			
//		});
//		btnInHD.setFont(new Font("Tahoma", Font.BOLD, 10));
//		btnInHD.setBackground(Color.ORANGE);
//		btnInHD.setBounds(142, 115, 99, 41);
//		btnInHD.setIcon(new ImageIcon("img1/print-icon.png"));
//		panel_4.add(btnInHD);
		

	
		// nghe k
		// mo mic cho nao v
		//t noi m nghe k
		// co'

	}

	private void loadHD() throws SQLException {
		Dao_HopDong dao_hd = new Dao_HopDong();		
		tableModel1 = dao_hd.getAllHD();
		table_1.setModel(tableModel1);
	}
	private void loadXe() throws SQLException{
		Dao_HopDong dao_hd = new Dao_HopDong();
		tableModel  =dao_hd.getAllXe();
		table.setModel(tableModel);
	}
	private void timHD() throws SQLException{
		dao_hd = new Dao_HopDong();
		tableModel1 = dao_hd.timKiem("%"+txtcmnd.getText()+"%");
		table_1.setModel(tableModel1);
	}
	private void timKiemHD() throws SQLException{
		dao_hd = new Dao_HopDong();
		tableModel1 = dao_hd.timKiem("%"+textField_4.getText()+"%");
		table_1.setModel(tableModel1);
	}
	private void timXe() throws SQLException{
		dao_hd = new Dao_HopDong();
		tableModel = dao_hd.timKiemXe(txtcmnd.getText());
		table.setModel(tableModel);
	}
	private void timNgay() throws SQLException{	
		dao_hd = new Dao_HopDong();		
		tableModel1 = dao_hd.timKiemNgay("%"+dateChooser.getDate().toString()+"%");
		table_1.setModel(tableModel1);
		
	}
	
	private void locData() throws SQLException{
		JDateChooser dateChooser = new JDateChooser();
		//String ngayLap =  dateChooser.getDate().toString();
		dao_hd = new Dao_HopDong();
		tableModel1 = dao_hd.locData("%"+txtcmnd.getText()+"%","%"+dateChooser.getDate().toString()+"%");
		table_1.setModel(tableModel1);
	}
//	private void locdata() throws SQLException{
//		dao_hd = new Dao_HopDong();
//		tableModel = dao_hd.locData(cmnd, tenXe)
		
		
	//	tableModel1 = dao_hd.timKiemNgay(dateChoo );
		
	//}
	

}


