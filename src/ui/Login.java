package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 22, 2020
* @version: 1.0
*/


import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.ConnectDB;
import dao.Dao_TaiKhoan;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;






public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; 
	private JLabel lblAnh;
	private JLabel lbltieuDe;
	private JLabel lbluser;
	private JLabel lblpass;
	private JPanel paneluser;
	private JPanel panelpass;
	private JLabel imageuser;
	private JLabel imagepass;
	public static JTextField txtuser;
	private JPasswordField txtpass;
	private JLabel lblxoauser,lblxoapass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
//	
	public Login() throws InterruptedException {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dao_TaiKhoan dao_tk = new Dao_TaiKhoan();
		setBounds(-10, 0, 1430, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(10, 11, 843, 599);
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(255, 255, 255));
		panelLeft.setBounds(853, 11, 507, 599);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		lblAnh = new JLabel("");
		lblAnh.setIcon(new ImageIcon(Login.class.getResource("/img/User-Administrator-Red-icon.png")));
		lblAnh.setBounds(174, 135, 172, 136);
		panelLeft.add(lblAnh);
		
		lbltieuDe = new JLabel("USER LOGIN");
		lbltieuDe.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbltieuDe.setBounds(143, 65, 221, 40);
		panelLeft.add(lbltieuDe);
		
		lbluser = new JLabel("User :");
		lbluser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbluser.setBounds(94, 311, 76, 31);
		panelLeft.add(lbluser);
		
		lblpass = new JLabel("Password :");
		lblpass.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblpass.setBounds(94, 414, 161, 31);
		panelLeft.add(lblpass);
		
		paneluser = new JPanel();
		paneluser.setBackground(Color.BLACK);
		paneluser.setBounds(94, 388, 283, 4);
		panelLeft.add(paneluser);
		
		panelpass = new JPanel();
		panelpass.setBackground(Color.BLACK);
		panelpass.setBounds(94, 484, 283, 4);
		panelLeft.add(panelpass);
		
		imageuser = new JLabel("");
		imageuser.setIcon(new ImageIcon(Login.class.getResource("/img/User-icon.png")));
		imageuser.setBounds(94, 353, 32, 40);
		panelLeft.add(imageuser);
		
		imagepass = new JLabel("");
		imagepass.setIcon(new ImageIcon(Login.class.getResource("/img/lock-icon.png")));
		imagepass.setBounds(94, 448, 46, 40);
		panelLeft.add(imagepass);
		
		txtuser = new JTextField();
		txtuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(txtuser.getText().length()>0) {
					lblxoauser.setVisible(true);
				}
				else {
					lblxoauser.setVisible(false);
				}
			}
		});
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtuser.setBackground(Color.WHITE);
		txtuser.setBounds(131, 353, 215, 31);
		txtuser.setBorder(null);
		panelLeft.add(txtuser);
		txtuser.setColumns(10);
		
		JButton btndangNhap = new JButton("Đăng Nhập");
		btndangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = txtuser.getText();
				@SuppressWarnings("deprecation")
				String password = txtpass.getText();
				TaiKhoan tk = dao_tk.Login(username, password);
				if(tk != null) {
					//txtuser.setText("");
					//txtpass.setText("");
					//close();
					Menu m = null;
					try {
						m = new Menu();
						m.setExtendedState(JFrame.MAXIMIZED_BOTH);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					m.setVisible(true);
					close();
				}
				else {
					JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ ", "Wrong !", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btndangNhap.setForeground(new Color(0, 0, 0));
		btndangNhap.setBackground(new Color(153, 102, 51));
		btndangNhap.setFont(new Font("Tahoma", Font.BOLD, 25));
		btndangNhap.setBounds(143, 524, 202, 49);
		panelLeft.add(btndangNhap);
		
		txtpass = new JPasswordField();
		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
					String username = txtuser.getText();
					@SuppressWarnings("deprecation")
					String password = txtpass.getText();
					TaiKhoan tk = dao_tk.Login(username, password);
					if(tk != null) {
						//txtuser.setText("");
						//txtpass.setText("");
						//close();
						Menu m = null;
						try {
							m = new Menu();
							m.setExtendedState(JFrame.MAXIMIZED_BOTH);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						m.setVisible(true);
						close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ ", "Wrong !", JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtpass.getText().length()>0) {
					lblxoapass.setVisible(true);
				}
				else {
					lblxoapass.setVisible(false);
				}
			}
		});
		txtpass.setBounds(134, 453, 215, 31);
		txtpass.setBorder(null);
		
		panelLeft.add(txtpass);
		
		lblxoauser = new JLabel("");
		
		lblxoauser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtuser.setText("");
				txtuser.requestFocus();
				lblxoauser.setVisible(false);
			}
		});
		lblxoauser.setIcon(new ImageIcon(Login.class.getResource("/img/delete-1-icon.png")));
		lblxoauser.setBounds(360, 370, 17, 16);
		lblxoauser.setVisible(false);
		panelLeft.add(lblxoauser);
		
		lblxoapass = new JLabel("");
		
		lblxoapass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpass.setText("");
				txtpass.requestFocus();
				lblxoapass.setVisible(false);
			}
		});
		lblxoapass.setIcon(new ImageIcon(Login.class.getResource("/img/delete-1-icon.png")));
		lblxoapass.setBounds(359, 465, 17, 16);
		lblxoapass.setVisible(false);
		panelLeft.add(lblxoapass);
	}
	private void close() {
		WindowEvent winClosing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
	}
}


