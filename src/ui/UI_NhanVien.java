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

import connect.ConnectDB;
import dao.Dao_NhaCungCap;
import dao.Dao_NhanVien;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import entity.NhanVien;

public class UI_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmaNV;
	private JTextField txttenNV;
	private JTextField txtGT;
	private JTextField txtNgayVaoLam;
	private JTextField txtEmail;
	private JTextField txtSdt;
	private JTextField txtDiaChi;
	private JTextField txtngaySinh;
	private JTextField txtChucVu;
	private JTextField txtTimKiem;
	private JTextField textField;
	private DefaultTableModel tableModel;
	private Dao_NhanVien dao_nv= new Dao_NhanVien();
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_NhanVien frame = new UI_NhanVien();
					frame.setVisible(true);
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setBounds(0, 0, 1900, screen.height);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1296, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 10, 1279, 686);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblQunLNhn = new JLabel("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1216, 221);
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
		panel_5.setBackground(new Color(255, 215, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 127, 80));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/Button-Add-icon.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setToolTipText("");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String ma= txtmaNV.getText();
					String ten=txttenNV.getText();
					String diachi=txtDiaChi.getText();
					String email= txtEmail.getText();
					String sodt= txtSdt.getText();
					String chucVu = txtChucVu.getText();
					String ngaySinh=txtngaySinh.getText();
					String ngayVaoLam =txtNgayVaoLam.getText();
					String gioiTinh = txtGT.getText();
					
					NhanVien nv= new NhanVien ();
					tableModel.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getDiaChi(),nv.getEmail(),nv.getGioiTinh(),nv.getChucVu(),nv.getNgaySinh(),nv.getNgayVaoLam()});
					dao_nv.themNV(nv);
					JFrame f= new JFrame();
					JOptionPane.showMessageDialog(f, "Thêm thành công !!!");
					dem();
				} catch (Exception s) {
					s.getMessage();
				}
				
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
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
							xoaNCC();
							dem();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vu lòng chọn nhà cung cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnSua = new JButton("Sửa");
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
							String ma= txtmaNV.getText();
							String ten=txttenNV.getText();
							String diachi=txtDiaChi.getText();
							String email= txtEmail.getText();
							String sodt= txtSdt.getText();
							String chucVu = txtChucVu.getText();
							String ngaySinh=txtngaySinh.getText();
							String ngayVaoLam =txtNgayVaoLam.getText();
							String gioiTinh = txtGT.getText();
							NhanVien nv= new NhanVien();
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
						JOptionPane.showMessageDialog(null, "Vu lòng chọn nhà cung cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/refresh-icon.png")));
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtmaNV.setText("");
				txttenNV.setText("");
				txtDiaChi.setText("");
				txtEmail.setText("");
				txtSdt.setText("");
				txtChucVu.setText("");
				txtngaySinh.setText("");
				txtGT.setText("");
				txtNgayVaoLam.setText("");
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblChucNang = new JLabel("Chức năng");
		lblChucNang.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(220, 220, 220));
		panel_3.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(211, 211, 211));
		panel_3_1.setBounds(0, 45, 712, 223);
		panel_3.add(panel_3_1);
		
		JLabel lblmaNV = new JLabel("Mã Nhân Viên");
		lblmaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtmaNV = new JTextField();
		txtmaNV.setColumns(10);
		
		JLabel lbltenNV = new JLabel("Tên Nhân Viên");
		lbltenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txttenNV = new JTextField();
		txttenNV.setColumns(10);
		
		JLabel lblngaySinh = new JLabel("Ngày Sinh");
		lblngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtngaySinh= new JTextField();
		txtngaySinh.setColumns(10);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtGT = new JTextField();
		txtGT.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
			
		txtEmail= new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtSdt = new JTextField();
		txtSdt .setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Địa chỉ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Chức vụ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtChucVu = new JTextField();
		txtChucVu.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày vào làm");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtNgayVaoLam = new JTextField();
		txtNgayVaoLam.setColumns(10);
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addComponent(lblmaNV, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtmaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblGT, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(txtNgayVaoLam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addComponent(lbltenNV, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txttenNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(txtGT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addComponent(lblngaySinh, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtngaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_3_1.setVerticalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(1)
							.addComponent(lblmaNV, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtmaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(1)
							.addComponent(lblGT, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNgayVaoLam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lbltenNV, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(txttenNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(2)
							.addComponent(txtGT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(2)
							.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblngaySinh, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(9)
							.addComponent(txtngaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(9)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_3_1.setLayout(gl_panel_3_1);
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		
		JLabel lblNhpThngTin = new JLabel("Nhập mã nhân viên");
		lblNhpThngTin.setBackground(new Color(255, 228, 225));
		lblNhpThngTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(UI_PhieuNhap.class.getResource("/image/search1.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_9 = new JLabel("");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1238, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 712, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblTTNV = new JLabel("Thông tin nhân viên");
		lblTTNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTTNV.setBounds(268, 22, 161, 13);
		panel_3.add(lblTTNV);
		
		JLabel lblNhpSin = new JLabel("Nhập số điện thoại nhân viên");
		lblNhpSin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhpSin.setBackground(new Color(255, 228, 225));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnTimKiem_1 = new JButton("Tìm kiếm");
		btnTimKiem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhpSin)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(btnTimKiem_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhpSin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimKiem_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhpThngTin, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNhpThngTin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addContainerGap(225, Short.MAX_VALUE)
					.addComponent(lblChucNang, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(203))
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(21)
					.addComponent(lblChucNang, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addGap(80))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
		);
		panel_4.setLayout(gl_panel_4);
		panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(495)
					.addComponent(lblQunLNhn, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(551, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblQunLNhn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}
	//Hàm Load
	private void loadNV() throws SQLException {
		Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		tableModel = dao_ncc.getAllNCC();
		table.setModel(tableModel);
	}
	//Hàm Xóa
	private void xoaNCC() throws SQLException {
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
