package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 27, 2020
* @version: 1.0
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage extends JFrame  {

	private JPanel contentPane;
	private JLabel lbltieuDe,lblanh;
	private String[] list = {
			"img1.jpg",
			"img2.png",
			"Main.png"
	};
//	private Timer tm;
	int x = 0;
	private JLabel lblimg;
	int position=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 750);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
//		lblimg = new JLabel();
//		lblimg.setBounds(66, 83, 1220, 374);
		
		
//		SetImageSize(1);
//		tm = new Timer(500,new ActionListener() {
//			
//			 @Override
//	            public void actionPerformed(ActionEvent e) {
//	                SetImageSize(x);
//	                x += 1;
//	                if(x >= list.length)
//	                    x = 0; 
//	            }
//			
//		});
//		tm.start();
//		contentPane.add(lblimg);
//		
	
		lbltieuDe = new JLabel("CHÀO MỪNG ĐẾN VỚI CÔNG TY TNHH THÀNH NAM");
		lbltieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieuDe.setFont(new Font("Tahoma", Font.BOLD, 35));
		lbltieuDe.setBounds(0, 0, 1370, 72);
		
		
		contentPane.add(lbltieuDe);
		
		JPanel panelthongTin = new JPanel();
		panelthongTin.setBackground(new Color(102, 102, 255));
		panelthongTin.setBounds(0, 468, 1370, 232);
		contentPane.add(panelthongTin);
		panelthongTin.setLayout(null);
		
		JLabel lblCngTy = new JLabel("@ Công ty TNHH Xe Thành Nam");
		lblCngTy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCngTy.setBounds(33, 92, 254, 14);
		panelthongTin.add(lblCngTy);
		
		JLabel lblNewLabel = new JLabel("Mã số doanh nghiệp: 0108617038. \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 122, 202, 36);
		panelthongTin.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GỌI MUA HÀNG, HỖ TRỢ (08:00 - 21:00): 1900.272737");
		lblNewLabel_1.setBounds(33, 169, 294, 14);
		panelthongTin.add(lblNewLabel_1);
		
		JLabel lblThng = new JLabel("THÔNG TIN");
		lblThng.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThng.setBounds(31, 24, 170, 36);
		panelthongTin.add(lblThng);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(31, 71, 164, 4);
		panelthongTin.add(panel);
		
		JLabel lblLinH = new JLabel("Liên Hệ");
		lblLinH.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLinH.setBounds(605, 24, 170, 36);
		panelthongTin.add(lblLinH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(551, 71, 229, 4);
		panelthongTin.add(panel_1);
		
		JLabel lblChiNhnhH = new JLabel("Chi nhánh tại TPHCM :");
		lblChiNhnhH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChiNhnhH.setBounds(595, 92, 179, 14);
		panelthongTin.add(lblChiNhnhH);
		
		JLabel lblNewLabel_2 = new JLabel("14-16 Quốc Hương, Phường Thảo Điền, Quận 2");
		lblNewLabel_2.setBounds(595, 123, 229, 14);
		panelthongTin.add(lblNewLabel_2);
		
		JLabel lblChiNhnhTi = new JLabel("Chi nhánh tại Hà Nội :");
		lblChiNhnhTi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChiNhnhTi.setBounds(595, 148, 179, 19);
		panelthongTin.add(lblChiNhnhTi);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tầng 2, T-231, Aeon Hà Đông");
		lblNewLabel_2_1.setBounds(595, 181, 229, 14);
		panelthongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(HomePage.class.getResource("/img/Phone-icon.png")));
		lblNewLabel_3.setBounds(7, 169, 16, 14);
		panelthongTin.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(HomePage.class.getResource("/img/blue-home-icon.png")));
		lblNewLabel_3_1.setBounds(565, 122, 20, 15);
		panelthongTin.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(HomePage.class.getResource("/img/blue-home-icon.png")));
		lblNewLabel_3_1_1.setBounds(565, 181, 20, 15);
		panelthongTin.add(lblNewLabel_3_1_1);
		
		JLabel lblTheoDiChng = new JLabel("Theo dõi chúng tôi tại");
		lblTheoDiChng.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTheoDiChng.setBounds(1020, 24, 322, 36);
		panelthongTin.add(lblTheoDiChng);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(1020, 71, 294, 4);
		panelthongTin.add(panel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(HomePage.class.getResource("/img/social-facebook-box-blue-icon.png")));
		lblNewLabel_4.setBounds(1030, 92, 39, 30);
		panelthongTin.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(HomePage.class.getResource("/img/Twitter-icon.png")));
		lblNewLabel_4_1.setBounds(1097, 92, 39, 30);
		panelthongTin.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setIcon(new ImageIcon(HomePage.class.getResource("/img/google-plus-icon.png")));
		lblNewLabel_4_1_1.setBounds(1159, 92, 39, 30);
		panelthongTin.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1.setIcon(new ImageIcon(HomePage.class.getResource("/img/Linked-In-icon.png")));
		lblNewLabel_4_1_1_1.setBounds(1219, 92, 39, 30);
		panelthongTin.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1_1.setIcon(new ImageIcon(HomePage.class.getResource("/img/youtube-icon.png")));
		lblNewLabel_4_1_1_1_1.setBounds(1275, 92, 39, 30);
		panelthongTin.add(lblNewLabel_4_1_1_1_1);
		
	    lblanh = new JLabel("");
		lblanh.setBounds(21, 69, 1326, 388);
		contentPane.add(lblanh);
		
		//lblnutPhai.addMouseListener(this);;
		
		//SetImageSize(2);
		Timer timer = new Timer(1500,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = (int) Math.floor(Math.random() * 3);
				String image = list[n];
				lblanh.setIcon(new ImageIcon("img\\"+image));
//				System.out.println(n);
			}
		});
		timer.start();
		//show(position);
	}
//	public void show(int index) {
//		String[] Images = takeImage();
//		String img = Images[index];
//		ImageIcon icon = new ImageIcon(getClass().getResource("/img1/"+img));
//		Image image = icon.getImage().getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
//		lblanh.setIcon(new ImageIcon(image));
//	}
//	public String[] takeImage(){
//		File f = new File(getClass().getResource("/img1").getFile());
//		String[] Images = f.list();
//		return Images;
//	}

//	public void SetImageSize(int i) {
//		ImageIcon icon = new ImageIcon(list[i]);
//		Image img = icon.getImage();
//		Image newImg = img.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(),Image.SCALE_SMOOTH );
//		ImageIcon newImc = new ImageIcon(newImg);
//		lblanh.setIcon(newImc);
//		
//	}
}


