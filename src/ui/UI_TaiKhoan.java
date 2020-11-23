package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.TaiKhoan;

import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UI_TaiKhoan extends JFrame {

	private JPanel pAccount;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_TaiKhoan frame = new UI_TaiKhoan();
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
	public UI_TaiKhoan() throws SQLException {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1133, 678);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		setBounds(0, 0, width, height);
		pAccount = new JPanel();
		pAccount.setBackground(Color.LIGHT_GRAY);
		pAccount.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pAccount);
		pAccount.setLayout(null);
		
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		List<String> list_MaNV = dao_nv.getListMaNV();
		Dao_TaiKhoan dao_tk = new Dao_TaiKhoan();
		List<TaiKhoan> list_tk = dao_tk.docTuBang();
		
		JLabel lblAccountName = new JLabel("TÀI KHOẢN");
		lblAccountName.setBounds(534, 10, 367, 35);
		lblAccountName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountName.setForeground(new Color(255, 140, 0));
		lblAccountName.setFont(new Font("Tahoma", Font.BOLD, 26));
		pAccount.add(lblAccountName);
		
		JPanel pAccountInfo = new JPanel();
		pAccountInfo.setBackground(new Color(211, 211, 211));
		pAccountInfo.setBounds(5, 50, 910, 149);
		pAccount.add(pAccountInfo);
		pAccountInfo.setLayout(null);
		
		JLabel lblGenInfo_Account = new JLabel("Thông tin chung");
		lblGenInfo_Account.setBounds(10, 5, 139, 20);
		lblGenInfo_Account.setFont(new Font("Tahoma", Font.BOLD, 16));
		pAccountInfo.add(lblGenInfo_Account);
		
		JPanel pAccountInfoDetails = new JPanel();
		pAccountInfoDetails.setBackground(new Color(230, 230, 250));
		pAccountInfoDetails.setBounds(1, 26, 907, 121);
		pAccountInfo.add(pAccountInfoDetails);
		pAccountInfoDetails.setLayout(null);
			
		JLabel lblEmployeeName_Acc = new JLabel("Mã Nhân Viên");
		lblEmployeeName_Acc.setBounds(5, 10, 120, 21);
		pAccountInfoDetails.add(lblEmployeeName_Acc);
		lblEmployeeName_Acc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeName_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextField txtEmployeeNum_Acc = new JTextField();
		txtEmployeeNum_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmployeeNum_Acc.setBounds(148, 10, 220, 23);
		pAccountInfoDetails.add(txtEmployeeNum_Acc);
		
		JLabel lblNewLabel = new JLabel("Tên Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(396, 10, 120, 20);
		pAccountInfoDetails.add(lblNewLabel);
		
		JTextField txtEmployeeName_Acc = new JTextField();
		txtEmployeeName_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmployeeName_Acc.setEditable(false);
		txtEmployeeName_Acc.setBounds(535, 10, 362, 25);
		pAccountInfoDetails.add(txtEmployeeName_Acc);
		
		JLabel lblPassword_Acc = new JLabel("Mật Khẩu");
		lblPassword_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword_Acc.setBounds(15, 50, 93, 21);
		pAccountInfoDetails.add(lblPassword_Acc);
		
		JTextField txtPassword_Acc = new JTextField();
		txtPassword_Acc.setBounds(148, 48, 220, 25);
		txtPassword_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAccountInfoDetails.add(txtPassword_Acc);
		
		JLabel lblPower_Acc = new JLabel("Quyền");
		lblPower_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPower_Acc.setBounds(17, 90, 103, 21);
		pAccountInfoDetails.add(lblPower_Acc);
		
		JComboBox cbbQuyen = new JComboBox();
		cbbQuyen.setBackground(Color.WHITE);
		cbbQuyen.setModel(new DefaultComboBoxModel(new String[] {"Quản Lý", "Nhân Viên"}));
		cbbQuyen.setBounds(148, 88, 220, 25);
		pAccountInfoDetails.add(cbbQuyen);
		
		JLabel lblNote_Acc = new JLabel("Chú Thích");
		lblNote_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNote_Acc.setBounds(400, 50, 103, 21);
		pAccountInfoDetails.add(lblNote_Acc);
		
		JTextArea txtChuThich = new JTextArea();
		txtChuThich.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtChuThich.setBounds(535, 48, 362, 65);
		pAccountInfoDetails.add(txtChuThich);
		
		JPanel pAccountList = new JPanel();
		pAccountList.setBounds(5, 209, 1525, 592);
		pAccount.add(pAccountList);
		pAccountList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1525, 591);
		pAccountList.add(scrollPane);
		
		String[] header = {"STT", "Mã Nhân Viên", "Tên Nhân Viên", "Mật Khẩu", "Quyền", "Chú Thích"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		//table.setColumnSelectionAllowed(true);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setModel(dao_tk.getAllAccount(header, tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.getTableHeader().setBackground(new Color(50,205,50));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		//table.getTableHeader().setForeground(Color.green);
		//table.setShowHorizontalLines(false);
		//table.setShowVerticalLines(false);
		//table.setShowGrid(false);
		
		JPanel pSearchAccount = new JPanel();
		pSearchAccount.setBackground(new Color(211, 211, 211));
		pSearchAccount.setBounds(925, 50, 367, 149);
		pAccount.add(pSearchAccount);
		pSearchAccount.setLayout(null);
		
		JLabel lblSearchAccount = new JLabel("Tìm Kiếm");
		lblSearchAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchAccount.setBounds(10, 5, 91, 20);
		pSearchAccount.add(lblSearchAccount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(1, 26, 365, 121);
		pSearchAccount.add(panel_1);
		panel_1.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton radEmployeeNumSearch = new JRadioButton("Mã Nhân Viên");
		radEmployeeNumSearch.setBounds(16, 6, 123, 25);
		group.add(radEmployeeNumSearch);
		panel_1.add(radEmployeeNumSearch);
		radEmployeeNumSearch.setSelected(true);
		radEmployeeNumSearch.setBackground(new Color(230, 230, 250));
		radEmployeeNumSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton radEmpployeeNameSearch = new JRadioButton("Tên Nhân Viên");
		radEmpployeeNameSearch.setBounds(183, 8, 148, 25);
		group.add(radEmpployeeNameSearch);
		panel_1.add(radEmpployeeNameSearch);
		radEmpployeeNameSearch.setBackground(new Color(230, 230, 250));
		radEmpployeeNameSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblSearch_Acc = new JLabel("Nhập nội dung tìm kiếm");
		lblSearch_Acc.setBounds(88, 37, 175, 21);
		panel_1.add(lblSearch_Acc);
		lblSearch_Acc.setForeground(new Color(0, 128, 128));
		lblSearch_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextField txtSearch_Acc = new JTextField();
		txtSearch_Acc.setBounds(16, 75, 339, 25);
		panel_1.add(txtSearch_Acc);
		
		JPanel pAccountFunction = new JPanel();
		pAccountFunction.setBackground(new Color(211, 211, 211));
		pAccountFunction.setBounds(1302, 50, 228, 149);
		pAccount.add(pAccountFunction);
		pAccountFunction.setLayout(null);
		
		JButton btnAdd_Acc = new JButton("Cấp Tài Khoản");
		btnAdd_Acc.setBackground(new Color(60, 179, 113));
		btnAdd_Acc.setBounds(20, 10, 193, 40);
		pAccountFunction.add(btnAdd_Acc);
		btnAdd_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/add-user-icon.png")));
		
		JButton btnDelete_Acc = new JButton("Xóa Tài Khoản");
		btnDelete_Acc.setBackground(new Color(255, 0, 0));
		btnDelete_Acc.setBounds(20, 55, 193, 40);
		pAccountFunction.add(btnDelete_Acc);
		btnDelete_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDelete_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/remove-user-icon.png")));
		
		JButton btnResetPassword_Acc = new JButton("Đặt Lại Mật Khẩu");
		btnResetPassword_Acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();				
				String maNhanVien = table.getValueAt(row, 1).toString();
				if(dao_tk.Update(maNhanVien)) {
					txtPassword_Acc.setText("12346");
					table.setValueAt("123456", row, 3);
				}
				else {
					JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu không thành công!");
				}
			}
		});
		btnResetPassword_Acc.setBackground(new Color(30, 144, 255));
		btnResetPassword_Acc.setBounds(20, 100, 193, 40);
		pAccountFunction.add(btnResetPassword_Acc);
		btnResetPassword_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
		btnResetPassword_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/Reset-icon.png")));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int viTriDongVuaBam = table.getSelectedRow();
				txtEmployeeNum_Acc.setText(table.getValueAt(viTriDongVuaBam, 1).toString());
				txtEmployeeName_Acc.setText(table.getValueAt(viTriDongVuaBam, 2).toString());
				txtPassword_Acc.setText(table.getValueAt(viTriDongVuaBam, 3).toString());
				txtChuThich.setText(table.getValueAt(viTriDongVuaBam, 5).toString());
				String item = table.getValueAt(viTriDongVuaBam, 4).toString();
				int i;
				if (item.equalsIgnoreCase("Quản Lý"))
					i = 0;
				else 
					i = 1;
				cbbQuyen.setSelectedIndex(i);
			}
		});
		
		txtEmployeeNum_Acc.addKeyListener(new KeyAdapter() {
			public boolean isNumeric(String str) {
				  return str.matches("^[N][V]\\d+");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			@Override
			public void keyReleased(KeyEvent e) {
				//char temp =  Character.toUpperCase(e.getKeyChar());
				//String employeeNum = txtEmployeeNum_Acc.getText() + temp;
				//txtEmployeeNum_Acc.setText(employeeNum);
				//txtEmployeeNum_Acc.setText(txtEmployeeNum_Acc.getText().toUpperCase());
				if (isNumeric(txtEmployeeNum_Acc.getText())) {
					txtEmployeeNum_Acc.setForeground(Color.black);
					Connection con = ConnectDB.getCon();
					String sql = "select * from NhanVien where maNhanVien = ?";
					try {
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, txtEmployeeNum_Acc.getText());
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							txtEmployeeName_Acc.setText(rs.getString("tenNhanVien"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1);
						e1.printStackTrace();
					}
				}
				else {
					txtEmployeeNum_Acc.setForeground(Color.red);
				}				
			}
		});
		
		btnAdd_Acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String maNhanVien = txtEmployeeNum_Acc.getText();
				String matKhau = txtPassword_Acc.getText();
				if (matKhau.equalsIgnoreCase(""))
					matKhau = "123456";
				String quyen = cbbQuyen.getSelectedItem().toString();
				String chuThich = txtChuThich.getText();
				TaiKhoan taiKhoan = new TaiKhoan(new entity.NhanVien(maNhanVien), matKhau, quyen, chuThich);
				String tenNhanVien = txtEmployeeName_Acc.getText();
				int stt = dao_tk.docTuBang().size();
				try {
					if(dao_tk.create(taiKhoan)) {
						tableModel.addRow(new Object[] {stt+"",taiKhoan.getNhanVien().getMaNhanVien(), tenNhanVien, taiKhoan.getMatKhau(), taiKhoan.getQuyen(), taiKhoan.getChuThich()});
					}
					else {
						JOptionPane.showMessageDialog(null, "Nhân viên này đã có tài khoản");
					}
				} catch(Exception e1) {
					//JOptionPane.showMessageDialog(this, "Trung");
					System.out.println("Wrong!");
				}
			}
		});
		
		btnDelete_Acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();	
				if (row < 0)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Tài Khoản cần xóa!");
				else {
					String maNhanVien = table.getValueAt(row, 1).toString();
					if(dao_tk.delete(maNhanVien)) {
						tableModel.removeRow(row);
					}
					else {
						System.out.println("Wrong!");
					}
				}
			}
		});
		
		txtSearch_Acc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtSearch_Acc.getText().equalsIgnoreCase(""))
					try {
						tableModel.getDataVector().removeAllElements();
						tableModel.fireTableDataChanged();
						table.setModel(dao_tk.getAllAccount(header, tableModel));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else if (radEmployeeNumSearch.isSelected()) {
					tableModel.getDataVector().removeAllElements();
					tableModel.fireTableDataChanged();
					try {
						table.setModel(dao_tk.getAccountById(header, tableModel, txtSearch_Acc.getText()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					tableModel.getDataVector().removeAllElements();
					tableModel.fireTableDataChanged();
					try {
						table.setModel(dao_tk.getAccountByName(header, tableModel, txtSearch_Acc.getText()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
}
