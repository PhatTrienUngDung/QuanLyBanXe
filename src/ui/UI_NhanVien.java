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
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import entity.NhanVien;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import java.beans.PropertyChangeListener;
//import java.lang.FdLibm.Cbrt;
import java.beans.PropertyChangeEvent;
public class UI_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmaNV;
	
	private JTextField txtGT;
	private JTextField txtngayVaoLam;


//	private JTextField txtngaySinh;
//	private JTextField txtchucVu;
	private JTextField txtTimKiem;
	private DefaultTableModel tableModel;
	private Dao_NhanVien dao_nv = new Dao_NhanVien();
	private JTextField textField_1;
	private JTextField txttenNV;
	private JTextField txtdiaChi;
//	private JTextField txtsdt;
	private JTextField txtEmail;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtSdt;
	private JTextField txtcmnd;
	private JDateChooser datengaySinh,datengayVaoLam;
	private Dao_KhachHang dao_kh = new Dao_KhachHang();
	

	
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 1296, 732);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		List<String> list_CMND = dao_kh.getListCMND();
		setBounds(0, 0, screen.width, (screen.height-50));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 1540, 772);
		contentPane.add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 175, 1492, 228);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(0, 10, 1482, 211);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblmaNV = new JLabel("Mã Nhân Viên");
		lblmaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmaNV.setBounds(10, 21, 107, 13);
		panel_6.add(lblmaNV);
		
		String maKH = dao_nv.getMaHDTail("maNhanVien", "NhanVien");
		txtmaNV = new JTextField();
		txtmaNV.setText(maKH);
		txtmaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmaNV.setBounds(139, 20, 260, 27);
		txtmaNV.setEditable(false);
		panel_6.add(txtmaNV);
		txtmaNV.setColumns(10);
		
		JLabel lbltenNV = new JLabel("Tên Nhân Viên");
		lbltenNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltenNV.setBounds(10, 67, 119, 13);
		panel_6.add(lbltenNV);
		
		txttenNV = new JTextField();
		
		txttenNV.addKeyListener(new KeyAdapter() {
			public boolean tennv(String str) {
				return str.matches("\\D*"); 
			}	
			@Override
			public void keyReleased(KeyEvent e) {
				if(!tennv(txttenNV.getText())) 
					txttenNV.setForeground(Color.red);
				else
					txttenNV.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
		        else
		        {   
		            String to_check=txttenNV.getText();
		            int to_check_len=to_check.length();
		            for(String data:list_CMND)
		            {
		                String check_from_data="";
		                for(int i=0;i<to_check_len;i++)
		                {
		                    if(to_check_len<=data.length())
		                    {
		                        check_from_data = check_from_data+data.charAt(i);
		                    }
		                }
		            }
		        }
			}
		});
		txttenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttenNV.setBounds(139, 60, 260, 27);
		panel_6.add(txttenNV);
		txttenNV.setColumns(10);
		
		JLabel lblngaySinh = new JLabel("Ngày sinh");
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblngaySinh.setBounds(10, 107, 96, 21);
		panel_6.add(lblngaySinh);
		
		JDateChooser datengaySinh = new JDateChooser();


		
		datengaySinh.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengaySinh.setBounds(139, 107, 260, 27);
		datengaySinh.setDateFormatString("yyy-MM-dd");
		datengaySinh.addPropertyChangeListener(new PropertyChangeListener() {
		public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
	        if ((birthDate != null) && (currentDate != null)) {
	            return Period.between(birthDate, currentDate).getYears();
	        } else {
	            return 0;
	        }
	    }
		public void propertyChange(PropertyChangeEvent arg0) {
			String date = ((JTextField) datengaySinh.getDateEditor().getUiComponent()).getText();
			if(!date.equalsIgnoreCase("")) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				if(calculateAge(LocalDate.parse(date, formatter), LocalDate.now()) < 18) {
					JOptionPane.showMessageDialog(null, "Khách hàng chưa đủ 18 tuôi!");
					datengaySinh.setDate(null);
				}
			}
		}
	});
		panel_6.add(datengaySinh);
		
		JLabel lblgioiTinh = new JLabel("Giới tính");
		lblgioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblgioiTinh.setBounds(10, 153, 96, 17);
		panel_6.add(lblgioiTinh);
		
		String GT[] = {"Nam","Nữ"};
		JComboBox cbgioiTinh = new JComboBox(GT);
		cbgioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbgioiTinh.setBounds(139, 149, 260, 27);
		panel_6.add(cbgioiTinh);
		
		JLabel lbldiaChi = new JLabel("Địa chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiaChi.setBounds(506, 64, 68, 13);
		panel_6.add(lbldiaChi);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiaChi.setBounds(639, 63, 275, 24);
		panel_6.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblemail.setBounds(506, 114, 46, 13);
		panel_6.add(lblemail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(639, 113, 275, 27);
		panel_6.add(txtEmail);
		txtEmail.setColumns(20);
		
		JLabel lblchucVu = new JLabel("Chức vụ");
		lblchucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblchucVu.setBounds(506, 154, 68, 21);
		panel_6.add(lblchucVu);
		
		ArrayList<ChucVu> dsCV = dao_nv.getAllChucVus();
		@SuppressWarnings("rawtypes")
		JComboBox cbchucVu = new JComboBox();
		cbchucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbchucVu.setBounds(639, 152, 275, 24);
		for (ChucVu cv : dsCV) {
			cbchucVu.addItem(cv.getTenChucVu());
		}
		panel_6.add(cbchucVu);
		
		JLabel lblngayVaoLam = new JLabel("Ngày Vào Làm");
		lblngayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblngayVaoLam.setBounds(1019, 66, 137, 21);
		panel_6.add(lblngayVaoLam);
		
		datengayVaoLam = new JDateChooser();		
		datengayVaoLam.setDate(Date.valueOf(LocalDate.now()));
		datengayVaoLam.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengayVaoLam.setBounds(1192, 57, 270, 30);
		datengayVaoLam.setDateFormatString("yyy-MM-dd");
		panel_6.add(datengayVaoLam);
		
		JLabel lblsdt = new JLabel("Số Điện Thoại");
		lblsdt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblsdt.setBounds(1019, 21, 119, 21);
		panel_6.add(lblsdt);
		
		txtSdt = new JTextField();
		txtSdt.setDocument(new JTextFieldLimit(10));
		txtSdt.addKeyListener(new KeyAdapter() {
			public boolean sdt(String str) {
				return str.matches("\\d*");
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(!sdt(txtSdt.getText())) 
					txtSdt.setForeground(Color.red);
				else
					txtSdt.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
				else
				{   
		            String to_check=txttenNV.getText();
		            int to_check_len=to_check.length();
		            for(String data:list_CMND)
		            {
		                String check_from_data="";
		                for(int i=0;i<to_check_len;i++)
		                {
		                    if(to_check_len<=data.length())
		                    {
		                        check_from_data = check_from_data+data.charAt(i);
		                    }
		                }
		            }
		        }
				  
			}
		});
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSdt.setBounds(1192, 20, 270, 27);
		panel_6.add(txtSdt);
		txtSdt.setColumns(10);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCmnd.setBounds(506, 22, 68, 13);
		panel_6.add(lblCmnd);
		
		txtcmnd = new JTextField();
		txtcmnd.setDocument(new JTextFieldLimit(12));
		txtcmnd.addKeyListener(new KeyAdapter() {
			public boolean cmnd(String str) {
				  return str.matches("\\d*");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			@Override
			public void keyReleased(KeyEvent e) {
				if(!cmnd(txtcmnd.getText())) 
					txtcmnd.setForeground(Color.red);
				else
					txtcmnd.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
		        else
		        {   
		            String to_check=txtcmnd.getText();
		            int to_check_len=to_check.length();
		            for(String data:list_CMND)
		            {
		                String check_from_data="";
		                for(int i=0;i<to_check_len;i++)
		                {
		                    if(to_check_len<=data.length())
		                    {
		                        check_from_data = check_from_data+data.charAt(i);
		                    }
		                }
		            }
		        }
				
			}
		});
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtcmnd.setBounds(639, 21, 275, 27);
		panel_6.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		
//		table = new JTable();
//		table.setBackground(new Color(255, 255, 255));
//		scrollPane.setViewportView(table);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi sinh", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y v\u00E0o l\u00E0m"
//			}
//		));
		table = new JTable(){
		       @Override
		       public boolean isCellEditable(int i, int i1) {
		           return false; //To change body of generated methods, choose Tools | Templates.
		       }
			};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 514, 1482, 205);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","CMND","Ngày Sinh","Giới Tính","Địa Chỉ","Email","Số Điện Thoại","Chức vụ","Ngày Vào Làm"};
		tableModel = new DefaultTableModel(header, 0);
		table.setModel(tableModel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				txtmaNV.setText(tableModel.getValueAt(i, 0).toString().trim());
				txttenNV.setText(tableModel.getValueAt(i, 1).toString().trim());
				txtcmnd.setText(tableModel.getValueAt(i, 2).toString().trim());
				datengaySinh.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 8).toString().trim()))); 
				cbgioiTinh.setSelectedItem(tableModel.getValueAt(i, 3).toString().trim());
				txtdiaChi.setText(tableModel.getValueAt(i, 4).toString().trim());
				txtEmail.setText(tableModel.getValueAt(i, 5).toString().trim());
				txtSdt.setText(tableModel.getValueAt(i, 6).toString().trim());
				cbchucVu.setSelectedItem(tableModel.getValueAt(i, 9).toString().trim());
				datengayVaoLam.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 7).toString())));
			}
		});
		loadNV();
		
	
		table.setRowHeight(20);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 421, 683, 69);
		panel_8.setBackground(new Color(231,150,36));
		
		JLabel lblNhpThngTin = new JLabel("Nhập số CMND của  nhân viên");
		lblNhpThngTin.setBounds(21, 13, 230, 30);
		lblNhpThngTin.setBackground(new Color(255, 228, 225));
		lblNhpThngTin.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtTimKiem.getText().length()==0) {
					try {
						loadNV();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(txtTimKiem.getText().length()>0) {
					try {
						timNV();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		txtTimKiem.setBounds(282, 21, 210, 19);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setBounds(502, 10, 143, 45);
		btnTimKiem.setIcon(new ImageIcon("img1/search2.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3.setLayout(null);
		
		
		//panel_4.setLayout(gl_panel_4);
		panel.setLayout(null);
		panel.add(panel_3);
		panel.add(panel_8);
		panel_8.setLayout(null);
		panel_8.add(lblNhpThngTin);
		panel_8.add(txtTimKiem);
		panel_8.add(btnTimKiem);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(768, 421, 724, 69);
		panel.add(panel_4);
		panel_4.setBackground(new Color(231,150,36));
		
		
		
		
		
		
		//Thêm
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255,190,87));
		btnThem.setBounds(43, 16, 123, 38);
		btnThem.setIcon(new ImageIcon("img1/add.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setToolTipText("");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(validData()) {
				String cb =null;
				String date1  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();
				String date2  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
				
				String ma= txtmaNV.getText();
				String ten=txttenNV.getText();
				String diachi=txtdiaChi.getText();
				String email= txtEmail.getText();
				String sodt= txtSdt.getText();
				String cmnd = txtcmnd.getText();
				ChucVu maChucVu=dao_nv.getMaChucVu((String) cbchucVu.getSelectedItem());
				String chucVu = (String) cbchucVu.getSelectedItem();
				Date ngaySinh=Date.valueOf(LocalDate.parse(date1));
				Date ngayVaoLam =Date.valueOf(LocalDate.parse(date2));
				String gioiTinh = (String) cbgioiTinh.getSelectedItem();
				System.out.println(maChucVu);
				NhanVien nv= new NhanVien(ma, ten, cmnd, gioiTinh, ngaySinh, diachi, email, maChucVu, sodt, ngayVaoLam);
				tableModel.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getCMND(),nv.getGioiTinh(),nv.getDiaChi(),nv.getEmail(),nv.getSdt()
						,nv.getNgayVaoLam(),nv.getNgaySinh(),nv.getChucVu().getMaChucVu()});						
				JFrame f= new JFrame();
				dao_nv.themNV(nv);			
				JOptionPane.showMessageDialog(f, "Thêm thành công !!!");
				}
			}
		});
		
			
			//Xóa
			JButton btnXoa = new JButton("Xóa");
			btnXoa.setBackground(new Color(255,190,87));
			btnXoa.setBounds(217, 16, 123, 38);
			btnXoa.setIcon(new ImageIcon("icon/delete.png"));
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
								if(xoaNV()){
									txtcmnd.setText("");
									txtdiaChi.setText("");
									txtEmail.setText("");
									cbgioiTinh.setSelectedItem(0);
									txtSdt.setText("");
									cbchucVu.setSelectedItem(0);
									datengaySinh.setCalendar(null);
									txttenNV.setText("");
									txttenNV.requestFocus();
									tableModel.removeRow(row);
								}
								
								
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cấp để xóa");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên này !!!");
					}
				}
			});
			btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			JButton btnLamMoi = new JButton("Làm mới");
			btnLamMoi.setBackground(new Color(255,190,87));
			btnLamMoi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnLamMoi.setBounds(555, 16, 135, 38);
			btnLamMoi.setIcon(new ImageIcon("img1/refresh.png"));
			btnLamMoi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				//	txtmaNV.setText("");
					txttenNV.setText("");
					txtdiaChi.setText("");
					txtEmail.setText("");
					txtSdt.setText("");
				//	cbchucVu.setSelectedIndex(-1);
					datengaySinh.setDate(null);
				
					txtcmnd.setText("");
				//	cbgioiTinh.setSelectedIndex(-1);
					datengayVaoLam.setDate(null);
				}
			});
			btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			//Sửa
			JButton btnSua = new JButton("Sửa");
			btnSua.setBackground(new Color(255,190,87));
			btnSua.setBounds(389, 16, 123, 38);
			btnSua.setIcon(new ImageIcon(("img1/update.png")));
			btnSua.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=table.getSelectedRow();
					String date1  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();		
					String date2  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
					try {
						if(validData()) {
						if(row!=-1) {
							JFrame f= new JFrame();
							int hoi=JOptionPane.showConfirmDialog(f, "Nhân viên này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
							if(hoi==JOptionPane.YES_OPTION) {
								String ma= txtmaNV.getText();
								String cmnd = txtcmnd.getText();
								String ten=txttenNV.getText();
								String diachi=txtdiaChi.getText();
								String email= txtEmail.getText();
								String sodt= txtSdt.getText();
								String chucVu = (String) cbchucVu.getSelectedItem();
								Date ngaySinh=Date.valueOf(LocalDate.parse(date1));
								Date ngayVaoLam =Date.valueOf(LocalDate.parse(date2));
								String gioiTinh = (String) cbgioiTinh.getSelectedItem();
								String maChucVu="";
								if (chucVu.equalsIgnoreCase("Quản Lý"))
									maChucVu = "CV_0001";
								else
									maChucVu = "CV_0002";
								NhanVien nv= new NhanVien(ma, ten, cmnd, gioiTinh, ngaySinh, diachi, email, new ChucVu(maChucVu), sodt, ngayVaoLam);
								dao_nv.update(nv);
								loadNV();
								JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công");
							}
						}
						}
						else
							JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để chỉnh sửa thông tin");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					
				}
			});
			panel_4.setLayout(null);
			btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
			panel_4.add(btnSua);
			panel_4.add(btnThem);
			panel_4.add(btnXoa);
			panel_4.add(btnLamMoi);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(0, 0, 1530, 78);
			panel.add(panel_1);
			
			JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
			lblNewLabel_1.setForeground(new Color(184, 134, 11));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(10, 88, 391, 72);
			panel.add(lblNewLabel_1);
	}
	//Hàm Load
	private boolean validNhanVien() {
		if(txtcmnd.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Chứng minh nhân dẫn không được để trống");
			return false;
		}
		if(txttenNV.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Tên nhân viên khônng được để trống");
			return false;
		}
		if(txtdiaChi.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Địa chỉ không được để trống");
			return false;
		}
		if(txtEmail.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Email không được để trống");
			return false;
		}
		if(txtSdt.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Địa chỉ không được để trống");
			return false;
		}
		if(txtGT.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Địa chỉ không được để trống");
			return false;
		}
		String date  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();
		Date ngay=Date.valueOf(LocalDate.parse(date));
		if(ngay.after(Date.valueOf(LocalDate.now()))) {
			
			JOptionPane.showMessageDialog(null, "Ngày sinh phải trước ngày hiện tại" );
			return false;
		}
		String date1  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
		Date datengayVaoLam=Date.valueOf(LocalDate.parse(date));
		if(ngay.after(Date.valueOf(LocalDate.now()))) {
			
			JOptionPane.showMessageDialog(null, "Ngày vào làm  phải trước ngày hiện tại" );
			return false;
		}
	
		return true;
		
	}
	private boolean validData() {
		String tenNV = txttenNV.getText();
		String cmnd = txtcmnd.getText();
		String diaChi = txtdiaChi.getText();
		String email = txtEmail.getText();
		String sdt = txtSdt.getText();
		if(!(tenNV.length()>0 && tenNV.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên nhân viên không trống " );
			return false;
		}
//		if(!(cmnd.length()>0 && cmnd.matches("\\d{12}"))) {
//			JOptionPane.showConfirmDialog(null, "Chứng minh nhân dân gồm 9 kí tự số hoặc 12 số");
//			return false;
//		}
		if(!(diaChi.length()>0 && diaChi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
	            "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
	            "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s/\\.,]+$"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ " );
			return false;
		}
		if(!(email.length()>0 && email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
			JOptionPane.showConfirmDialog(null, "Sai cú pháp gmail. Cú pháp đúng");
			return false;
		}
		if(!(sdt.length()>0 && sdt.matches("^[0][1-9][0-9]{8}$"))) {
			JOptionPane.showConfirmDialog(null, "Số điện thoại gồm 10 kí tự số và bắt đầu từ kí tự 0");
			return false;
		}
		return rootPaneCheckingEnabled;
		
	}
	private void loadNV() throws SQLException {
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		tableModel = dao_nv.getAllNV();
		table.setModel(tableModel);
	}
	//Hàm Xóa
	private boolean xoaNV() throws SQLException {
		dao_nv = new Dao_NhanVien();
		if(dao_nv.xoaNV(txtmaNV.getText()))
			return true;
		return false;
	//	loadNV();
	}
	//Tìm kiếm
		private void timNV() throws SQLException{
			Dao_NhanVien dao_nv= new Dao_NhanVien();
			tableModel = dao_nv.timKiem("%"+txtTimKiem.getText()+"%", "%"+txtTimKiem.getText()+"%");
			table.setModel(tableModel);
		}
//	private void update() {
//		for(int i =0 ; i<table.getRowCount();i++) {
//			if(txtmaNV.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString())) {
//				table.setValueAt(txttenNV.getText(),i, 1);
//				table.setValueAt(txtcmnd.getText(), i, 2);
//				table.setValueAt(txtGT.getText(),i ,3);
//				table.setValueAt(txtdiaChi.getText(), i, 4);
//				table.setValueAt(txtEmail.getText(), i, 5);
//				table.setValueAt(txtSdt.getText(), i, 6);
//				table.setValueAt(cbChuc)
//			}
//	}
//}
}
