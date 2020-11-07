package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.Dao_NhaCungCap;
import entity.NhaCungCap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class UI_NhaCungCap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNCC;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtTenNCC;
	private JTable table;
	private JTable table_1;
	private JTextField txtTim;
	private JTextField txtDem;
	private DefaultTableModel tableModel;
	private JTextField txtSDT;
	private Dao_NhaCungCap dao_ncc= new Dao_NhaCungCap();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_NhaCungCap frame = new UI_NhaCungCap();
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
	public UI_NhaCungCap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 740);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(UIManager.getBorder("FormattedTextField.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(UIManager.getColor("window"));
		panel_4.setBounds(10, 56, 1221, 618);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 51, 826, 167);
		panel_4.add(panel);
		panel.setForeground(UIManager.getColor("CheckBox.focus"));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new LineBorder(new Color(130, 135, 144)));
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 10, 805, 21);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u00F4ng tin nh\u00E0 cung c\u1EA5p");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 0, 210, 21);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(10, 33, 805, 122);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p");
		lblNewLabel.setBounds(10, 10, 123, 21);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p");
		lblTnNhCung.setBounds(10, 41, 123, 21);
		panel_3.add(lblTnNhCung);
		lblTnNhCung.setForeground(new Color(0, 128, 0));
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u00FA Th\u00EDch");
		lblNewLabel_1.setBounds(446, 72, 89, 13);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(146, 11, 237, 19);
		panel_3.add(txtMaNCC);
		txtMaNCC.setColumns(10);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(146, 42, 237, 19);
		panel_3.add(txtTenNCC);
		txtTenNCC.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(555, 11, 237, 19);
		panel_3.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(555, 41, 237, 19);
		panel_3.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(446, 10, 123, 21);
		panel_3.add(lblEmail);
		lblEmail.setForeground(new Color(0, 128, 0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblaCh.setBounds(446, 41, 123, 21);
		panel_3.add(lblaCh);
		lblaCh.setForeground(new Color(0, 128, 0));
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JTextArea txtChuThich = new JTextArea();
		txtChuThich.setBounds(555, 72, 237, 35);
		panel_3.add(txtChuThich);
		txtChuThich.setToolTipText("");
		txtChuThich.setBackground(SystemColor.controlHighlight);
		txtChuThich.setLineWrap(true);
		txtChuThich.setWrapStyleWord(true);
		
		JLabel lblSo = new JLabel("Số Điện Thoại");
		lblSo.setForeground(new Color(0, 128, 0));
		lblSo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSo.setBounds(10, 72, 123, 21);
		panel_3.add(lblSo);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(146, 73, 237, 19);
		panel_3.add(txtSDT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(853, 51, 358, 167);
		panel_4.add(panel_1);
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBorder(new MatteBorder(1, 6, 1, 1, (Color) UIManager.getColor("CheckBox.focus")));
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 10, 338, 21);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_2_1 = new JLabel("Ch\u1EE9c n\u0103ng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 0, 210, 21);
		panel_2_1.add(lblNewLabel_2_1);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ma= txtMaNCC.getText();
				String ten=txtTenNCC.getText();
				String diachi=txtDiaChi.getText();
				String email= txtEmail.getText();
				String sodt= txtSDT.getText();
				String chuThich=txtChuThich.getText();
				NhaCungCap ncc= new NhaCungCap(ma, ten, diachi, chuThich, sodt, email);
				tableModel.addRow(new Object[] {ncc.getMaNhaCungCap(),ncc.getTenNhaCungCap(),ncc.getDiaChi(),ncc.getEmail(),ncc.getSoDienThoai(),ncc.getChuThich()});
				dao_ncc.themNCC(ncc);
				JFrame f= new JFrame();
				JOptionPane.showMessageDialog(f, "Thêm thành công !!!");
			}
		});
		/*
		 * Image img = new
		 * ImageIcon(this.getClass().getResource("/add.ico")).getImage();
		 */
		btnThem.setBackground(new Color(152, 251, 152));
		btnThem.setBounds(20, 52, 142, 36);
		panel_1.add(btnThem);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp này sẽ bị xóa","Chú ý",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r= table_1.getSelectedRow();
							tableModel.removeRow(r);
							xoaNCC();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vu lòng chọn nhà cung cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1.setBounds(199, 52, 142, 36);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C\u1EADp nh\u1EADt");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String ma= txtMaNCC.getText();
							String ten=txtTenNCC.getText();
							String diachi=txtDiaChi.getText();
							String email= txtEmail.getText();
							String sodt= txtSDT.getText();
							String chuThich=txtChuThich.getText();
							NhaCungCap ncc= new NhaCungCap(ma, ten, diachi, chuThich, sodt, email);
							dao_ncc.update(ncc);
							try {
								loadNCC();
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
		btnNewButton_2.setBackground(new Color(152, 251, 152));
		btnNewButton_2.setBounds(20, 110, 142, 36);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("L\u00E0m t\u01B0\u01A1i");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMaNCC.setText("");
				txtTenNCC.setText("");
				txtDiaChi.setText("");
				txtEmail.setText("");
				txtSDT.setText("");
				txtChuThich.setText("");
			}
		});
		btnNewButton_3.setBackground(new Color(152, 251, 152));
		btnNewButton_3.setBounds(199, 110, 142, 36);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_5.setBounds(0, 0, 1221, 28);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("QU\u1EA2N L\u00DD NH\u00C0 CUNG C\u1EA4P");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(43, 0, 353, 28);
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 306, 1201, 289);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		String[] header= {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại","Ghi Chú"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 10, 1181, 269);
		panel_6.add(scrollPane);
		table_1 = new JTable(tableModel);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				txtMaNCC.setText(tableModel.getValueAt(i, 0).toString());
				txtTenNCC.setText(tableModel.getValueAt(i, 1).toString());
				txtDiaChi.setText(tableModel.getValueAt(i, 2).toString());
				txtEmail.setText(tableModel.getValueAt(i, 3).toString());
				txtSDT.setText(tableModel.getValueAt(i, 4).toString());
				txtChuThich.setText(tableModel.getValueAt(i, 5).toString());
			}
		});
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table_1);
		//Load Dữ liệu lên bảng
		try {
			loadNCC();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 236, 826, 60);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nhập mã nhà cung cấp cần tìm");
		lblNewLabel_4.setForeground(new Color(0, 128, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 14, 190, 27);
		panel_7.add(lblNewLabel_4);
		
		txtTim = new JTextField();
		txtTim.setBounds(209, 18, 228, 19);
		panel_7.add(txtTim);
		txtTim.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("btnTim");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					timNCC();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.setBounds(469, 17, 85, 21);
		panel_7.add(btnNewButton_4);
		
		JButton btnShow = new JButton("Hiển thị tất cả");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					loadNCC();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBackground(new Color(0, 255, 0));
		btnShow.setBounds(566, 17, 134, 21);
		panel_7.add(btnShow);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(853, 236, 358, 60);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Số lượng nhà cung cấp :");
		lblNewLabel_5.setForeground(new Color(0, 128, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(47, 10, 154, 40);
		panel_8.add(lblNewLabel_5);
		
		txtDem = new JTextField();
		txtDem.setEnabled(false);
		txtDem.setBounds(211, 18, 79, 28);
		panel_8.add(txtDem);
		txtDem.setColumns(10);
		table = new JTable();
	
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 267, 1181, -260);
	}
	//Hàm load database
	private void loadNCC() throws SQLException {
		Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		tableModel = dao_ncc.getAllNCC();
		table_1.setModel(tableModel);
	}
	//Hàm xóa 
	private void xoaNCC() throws SQLException {
		Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		dao_ncc.xoaNCC(txtMaNCC.getText());
		loadNCC();
	}
	//Tìm kiếm
	private void timNCC() throws SQLException{
		Dao_NhaCungCap dao_ncc= new Dao_NhaCungCap();
		tableModel = dao_ncc.timKiem(txtTim.getText());
		table_1.setModel(tableModel);
	}
}
