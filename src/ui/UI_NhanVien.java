package ui;



import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.tools.DocumentationTool.Location;

import connect.ConnectDB;
import dao.Dao_NhaCungCap;
import dao.Dao_NhanVien;
import entity.ChucVu;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.lang.FdLibm.Cbrt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import entity.NhanVien;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UI_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmaNV;
	
	private JTextField txtGT;
	private JTextField txtngayVaoLam;


	private JTextField txtngaySinh;
	private JTextField txtchucVu;
	private JTextField txtTimKiem;
	private JTextField textField;
	private DefaultTableModel tableModel;
	private Dao_NhanVien dao_nv = new Dao_NhanVien();
	private JTextField textField_1;
	private JTextField txttenNV;
	private JTextField txtdiaChi;
	private JTextField txtsdt;
	private JTextField txtEmail;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_NhanVien frame = new UI_NhanVien();
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
	 * @throws SQLException 
	 */
	public UI_NhanVien() throws SQLException {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 1296, 732);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		setBounds(0, 0, screen.width, (screen.height-50));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 10, 1527, 743);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 1492, 50);
		panel_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblQunLNhn = new JLabel("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		lblQunLNhn.setBounds(603, 10, 192, 30);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 434, 1492, 241);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 1468, 221);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi sinh", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y v\u00E0o l\u00E0m"
			}
		));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(732, 70, 770, 268);
		panel_5.setBackground(new Color(255, 215, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 71, 770, 197);
		panel_4.setBackground(new Color(255, 127, 80));
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 77, 696, 261);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 40, 676, 211);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblmaNV = new JLabel("Mã Nhân Viên");
		lblmaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmaNV.setBounds(10, 21, 96, 13);
		panel_6.add(lblmaNV);
		
		txtmaNV = new JTextField();
		txtmaNV.setBounds(139, 20, 96, 19);
		panel_6.add(txtmaNV);
		txtmaNV.setColumns(10);
		
		JLabel lbltenNV = new JLabel("Tên Nhân Viên");
		lbltenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltenNV.setBounds(10, 63, 96, 13);
		panel_6.add(lbltenNV);
		
		txttenNV = new JTextField();
		txttenNV.setBounds(139, 60, 96, 19);
		panel_6.add(txttenNV);
		txttenNV.setColumns(10);
		
		JLabel lblngaySinh = new JLabel("Ngày sinh");
		lblngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblngaySinh.setBounds(10, 113, 96, 13);
		panel_6.add(lblngaySinh);
		
		JDateChooser datengaySinh = new JDateChooser();
		datengaySinh.setBounds(139, 107, 96, 19);
		panel_6.add(datengaySinh);
		
		JLabel lblgioiTinh = new JLabel("Giới tính");
		lblgioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblgioiTinh.setBounds(10, 153, 96, 13);
		panel_6.add(lblgioiTinh);
		
		JComboBox cbgioiTinh = new JComboBox();
		cbgioiTinh.setBounds(139, 149, 96, 21);
		panel_6.add(cbgioiTinh);
		
		JLabel lbldiaChi = new JLabel("Địa chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldiaChi.setBounds(357, 23, 68, 13);
		panel_6.add(lbldiaChi);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setBounds(474, 20, 96, 19);
		panel_6.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblemail.setBounds(357, 63, 46, 13);
		panel_6.add(lblemail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(474, 60, 96, 19);
		panel_6.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblchucVu = new JLabel("Chức vụ");
		lblchucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblchucVu.setBounds(357, 113, 68, 13);
		panel_6.add(lblchucVu);
		
		JComboBox cbchucVu = new JComboBox();
		cbchucVu.setBounds(474, 109, 96, 21);
		panel_6.add(cbchucVu);
		
		JLabel lblngayVaoLam = new JLabel("Ngày Vào Làm");
		lblngayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblngayVaoLam.setBounds(357, 157, 107, 13);
		panel_6.add(lblngayVaoLam);
		
		JDateChooser datengayVaoLam = new JDateChooser();
		datengayVaoLam.setBounds(474, 153, 98, 19);
		panel_6.add(datengayVaoLam);
		
		
		
		//Thêm
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(146, 29, 123, 33);
		btnThem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Button-Add-icon.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setToolTipText("");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String date1  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();
				String date2  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
				
				String ma= txtmaNV.getText();
				String ten=txttenNV.getText();
				String diachi=txtdiaChi.getText();
				String email= txtEmail.getText();
				String sodt= txtsdt.getText();
				String chucVu = (String) cbchucVu.getSelectedItem();
				Date ngaySinh=Date.valueOf(LocalDate.parse(date1));
				Date ngayVaoLam =Date.valueOf(LocalDate.parse(date2));
				String gioiTinh = (String) cbgioiTinh.getSelectedItem();
				NhanVien nv = new NhanVien(ma,ten,diachi,email,sodt,new ChucVu(chucVu),ngaySinh,ngayVaoLam,gioiTinh);
				tableModel.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getDiaChi(),nv.getEmail(),nv.getSdt(),nv.getChucVu().getMaChucVu(),nv.getNgaySinh(),nv.getNgayVaoLam()});
		
				dao_nv.themNV(nv);
			}
		});
		scrollPane.setViewportView(table);
	
		
		//Xóa
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(504, 29, 123, 33);
		btnXoa.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/delete-icon.png")));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Nhân viên sẽ bị xóa","Chú ý",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r= table.getSelectedRow();
							tableModel.removeRow(r);
							xoaNV();
							
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setBounds(504, 122, 123, 41);
		btnLamMoi.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/refresh-icon.png")));
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtmaNV.setText("");
				txttenNV.setText("");
				txtdiaChi.setText("");
				txtEmail.setText("");
				txtsdt.setText("");
				//cbChucVu
			//	datengaySinh.setDate("");
				txtGT.setText("");
				//datengayVaoLam.setDate("");
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//Sửa
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(146, 126, 123, 33);
		btnSua.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Settings-icon.png")));
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				String date1  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();		
				String date2  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String ma= txtmaNV.getText();
							String ten=txttenNV.getText();
							String diachi=txtdiaChi.getText();
							String email= txtEmail.getText();
							String sodt= txtsdt.getText();
							String chucVu = (String) cbchucVu.getSelectedItem();
							Date ngaySinh=Date.valueOf(LocalDate.parse(date1));
							Date ngayVaoLam =Date.valueOf(LocalDate.parse(date2));
							String gioiTinh = (String) cbgioiTinh.getSelectedItem();
							NhanVien nv = new NhanVien(ma,ten,diachi,email,sodt, new ChucVu(chucVu),ngaySinh,ngayVaoLam,gioiTinh);
							tableModel.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getDiaChi(),nv.getEmail(),nv.getSdt(),nv.getChucVu().getMaChucVu(),nv.getNgaySinh(),nv.getNgayVaoLam()});						
							dao_nv.update(nv);
							try {
								loadNV();
							} catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		panel_4.setLayout(null);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnSua);
		panel_4.add(btnThem);
		panel_4.add(btnXoa);
		panel_4.add(btnLamMoi);
		
		JLabel lblChucNang = new JLabel("Chức năng");
		lblChucNang.setBounds(225, 21, 88, 32);
		lblChucNang.setFont(new Font("Tahoma", Font.BOLD, 14));
		
	
		

		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(18, 356, 688, 50);
		panel_8.setBackground(new Color(255, 255, 255));
		
		JLabel lblNhpThngTin = new JLabel("Nhập mã nhân viên");
		lblNhpThngTin.setBounds(10, 10, 140, 30);
		lblNhpThngTin.setBackground(new Color(255, 228, 225));
		lblNhpThngTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(196, 18, 246, 19);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(496, 13, 125, 21);
		btnTimKiem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/search1.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(446, 21, 46, 13);
	
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(724, 356, 778, 50);
		panel_7.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		
		
		

		
		
		
		
		JLabel lblnhapSDT = new JLabel("Nhập số điện thoại nhân viên");
		lblnhapSDT.setBounds(10, 10, 186, 30);
		lblnhapSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnhapSDT.setBackground(new Color(255, 228, 225));
		
		textField = new JTextField();
		textField.setBounds(214, 18, 305, 19);
		textField.setColumns(10);
		
		JButton btnTimKiem_1 = new JButton("Tìm kiếm");
		btnTimKiem_1.setBounds(576, 13, 125, 25);
		btnTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		//panel_4.setLayout(gl_panel_4);
		panel.setLayout(null);
		panel.add(panel_2);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblQunLNhn);
		panel.add(panel_3);
		
		JLabel lblThngTinNhn = new JLabel("Thông tin nhân viên");
		lblThngTinNhn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThngTinNhn.setBounds(258, 20, 164, 13);
		
		panel_3.add(lblThngTinNhn);
		

		
		
		panel.add(panel_5);
		panel_5.setLayout(null);
		panel_5.add(lblChucNang);
		panel_5.add(panel_4);
		panel.add(panel_8);
		panel_8.setLayout(null);
		panel_8.add(lblNhpThngTin);
		panel_8.add(txtTimKiem);
		panel_8.add(lblNewLabel_9);
		panel_8.add(btnTimKiem);
		panel.add(panel_7);
		panel_7.setLayout(null);
		panel_7.add(lblnhapSDT);
		panel_7.add(textField);
		panel_7.add(btnTimKiem_1);
	}
	//Hàm Load
	private void loadNV() throws SQLException {
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		tableModel = dao_nv.getAllNV();
		table.setModel(tableModel);
	}
	//Hàm Xóa
	private void xoaNV() throws SQLException {
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		dao_nv.xoaNV(txtmaNV.getText());
		loadNV();
	}
	//Tìm kiếm
		private void timNV() throws SQLException{
			Dao_NhanVien dao_nv= new Dao_NhanVien();
			tableModel = dao_nv.timKiem(txtTimKiem.getText());
			table.setModel(tableModel);
		}
}
