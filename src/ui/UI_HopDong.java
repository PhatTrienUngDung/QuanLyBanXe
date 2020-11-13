package ui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.Dao_HopDong;
import dao.Dao_NhaCungCap;
import dao.Dao_NhanVien;
import entity.HopDong;
import entity.NhanVien;
import entity.KhachHang;
import entity.Xe;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_HopDong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtTimKiem;
	private JTextField txtmaHD;
	private JTextField txttenHD;
	private JTextField txtmaKH,txtmaNV,txtmaXe,txtTGBH,txtngayLap;
	private DefaultTableModel tableModel;
	private JDateChooser datengayLap;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1312, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1279, 683);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 10, 1248, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQunLHp = new JLabel("Quản lý hợp đồng");
		lblQunLHp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQunLHp.setBackground(new Color(255, 69, 0));
		lblQunLHp.setBounds(539, 10, 159, 35);
		panel_1.add(lblQunLHp);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 215, 0));
		panel_6.setBounds(687, 71, 571, 229);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(77, 61, 433, 133);
		panel_6.add(panel_4);
		panel_4.setBackground(new Color(255, 140, 0));
		panel_4.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Button-Add-icon.png")));
		btnThem.setBounds(61, 27, 129, 21);
		panel_4.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/delete-icon.png")));
		btnXoa.setBounds(61, 86, 129, 21);
		panel_4.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Settings-icon.png")));
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String maHD= txtmaHD.getText();
							String maKH =txtmaKH.getText();
							String maNV =txtmaNV.getText();
							String maXe =txtmaXe.getText();
							Date ngayLap = datengayLap.getDate();
						
							String tgbh = txtTGBH.getText();
							
							
							HopDong hd= new HopDong(maHD, new KhachHang(maKH), new NhanVien(maNV), new Xe(maXe), ngayLap, tgbh);
							tableModel.addRow(new Object[] {hd.getMaHD(),hd.getKhachHang(),hd.getNhanVien(),hd.getXe(),hd.getNgayLap(),hd.getTGBH()});
							try {
								loadHD();
							} catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vu lòng chọn nhà cung cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		
		btnSua.setBounds(277, 27, 129, 21);
		panel_4.add(btnSua);
		
		JButton btnNew = new JButton("Làm mới");
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNew.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/refresh-icon.png")));
		btnNew.setBounds(277, 86, 129, 21);
		panel_4.add(btnNew);
		
		JLabel lblChucNang = new JLabel("Chức năng");
		lblChucNang.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChucNang.setBounds(253, 23, 131, 13);
		panel_6.add(lblChucNang);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 215, 0));
		panel_7.setBounds(10, 70, 667, 230);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblTTHD = new JLabel("Thông tin hợp đồng");
		lblTTHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTTHD.setBounds(63, 10, 185, 24);
		panel_7.add(lblTTHD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 36, 647, 184);
		panel_7.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblmaHD = new JLabel("Mã Hợp Đồng");
		lblmaHD.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblmaHD.setBounds(10, 10, 101, 13);
		panel_2.add(lblmaHD);
		
		txtmaHD = new JTextField();
		txtmaHD.setBounds(143, 9, 96, 19);
		panel_2.add(txtmaHD);
		txtmaHD.setColumns(10);
		
		JLabel lbltenHD= new JLabel("Tên Hợp Đồng");
		lbltenHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltenHD.setBounds(10, 50, 101, 13);
		panel_2.add(lbltenHD);
		
		txttenHD = new JTextField();
		txttenHD.setBounds(143, 49, 96, 19);
		panel_2.add(txttenHD);
		txttenHD.setColumns(10);
		
		JLabel lblmaKH = new JLabel("Mã Khách Hàng");
		lblmaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaKH.setBounds(10, 90, 101, 13);
		panel_2.add(lblmaKH);
		
		JComboBox cbmaKH = new JComboBox();
		cbmaKH.setBounds(143, 88, 96, 21);
		panel_2.add(cbmaKH);
		
		JLabel lbltenKH = new JLabel("Tên Khách Hàng");
		lbltenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltenKH.setBounds(10, 127, 129, 13);
		panel_2.add(lbltenKH);
		
		JComboBox cbtenKH = new JComboBox();
		cbtenKH.setBounds(143, 125, 96, 21);
		panel_2.add(cbtenKH);
		
		JLabel lblmaNV = new JLabel("Mã Nhân Viên");
		lblmaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaNV.setBounds(10, 161, 101, 13);
		panel_2.add(lblmaNV);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(143, 161, 96, 21);
		panel_2.add(comboBox_2);
		
		JLabel lbltenNV = new JLabel("Tên Nhân Viên");
		lbltenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltenNV.setBounds(395, 12, 94, 13);
		panel_2.add(lbltenNV);
		
		JComboBox cbtenNV = new JComboBox();
		cbtenNV.setBounds(526, 8, 94, 21);
		panel_2.add(cbtenNV);
		
		JLabel lblLoaiXe = new JLabel("Loại Xe");
		lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoaiXe.setBounds(395, 52, 74, 13);
		panel_2.add(lblLoaiXe);
		
		JComboBox cbloaiXe = new JComboBox();
		cbloaiXe.setBounds(526, 48, 94, 21);
		panel_2.add(cbloaiXe);
		
		JLabel lblMauXe = new JLabel("Màu Xe");
		lblMauXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMauXe.setBounds(395, 92, 94, 13);
		panel_2.add(lblMauXe);
		
		JComboBox cbmauXe = new JComboBox();
		cbmauXe.setBounds(526, 88, 94, 21);
		panel_2.add(cbmauXe);
		
		JLabel lblNgayLap = new JLabel("Ngày Lập");
		lblNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayLap.setBounds(395, 129, 74, 13);
		panel_2.add(lblNgayLap);
		
		datengayLap= new JDateChooser();
		datengayLap.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 datengayLap.setBounds(526, 127, 94, 19);
		panel_2.add( datengayLap);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 438, 1239, 235);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u1EE3p \u0110\u1ED3ng", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "M\u00E3 Xe", "T\u00EAn xe", "Ng\u00E0y L\u1EADp"
			}
		));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(35, 330, 642, 57);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNhpMHp = new JLabel("Nhập mã hợp đồng");
		lblNhpMHp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhpMHp.setBounds(10, 21, 175, 13);
		panel_3.add(lblNhpMHp);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(220, 20, 137, 19);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTmKim = new JButton("Tìm Kiếm");
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTmKim.setBounds(437, 19, 100, 21);
		panel_3.add(btnTmKim);
		
	}
	//Hàm Load
		private void loadHD() throws SQLException {
			Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
			tableModel = dao_ncc.getAllNCC();
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
			public void dem() {
				try {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					String sql = "select count(maNhaCungCap) from nhaCungCap ";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						String count=rs.getString(1);
					
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
}


