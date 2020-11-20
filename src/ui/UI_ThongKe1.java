package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class UI_ThongKe1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_ThongKe1 frame = new UI_ThongKe1();
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
	public UI_ThongKe1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, (screen.height-50));
		contentPane = new JPanel();
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
		btnLoai.setFocusable(false);
		btnLoai.setBorderPainted(false);
		btnLoai.setBackground(Color.WHITE);
		btnLoai.setBounds(133, 10, 93, 43);
		panel.add(btnLoai);
		
		JButton btnHang = new JButton("");
		btnHang.setFocusable(false);
		btnHang.setBorderPainted(false);
		btnHang.setBackground(Color.WHITE);
		btnHang.setBounds(255, 10, 93, 43);
		panel.add(btnHang);
		
		JButton btnXe = new JButton("");
		btnXe.setFocusable(false);
		btnXe.setBorderPainted(false);
		btnXe.setBackground(Color.WHITE);
		btnXe.setBounds(10, 10, 93, 43);
		panel.add(btnXe);
		
		JLabel lbXe = new JLabel("Xe");
		lbXe.setHorizontalAlignment(SwingConstants.CENTER);
		lbXe.setBounds(10, 55, 93, 13);
		panel.add(lbXe);
		
		JLabel lblLoiXe = new JLabel("Loại Xe");
		lblLoiXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoiXe.setBounds(133, 55, 93, 13);
		panel.add(lblLoiXe);
		
		JLabel lblHngSnXut = new JLabel("Hãng Sản Xuất");
		lblHngSnXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngSnXut.setBounds(255, 55, 93, 13);
		panel.add(lblHngSnXut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(25, 88, 314, 176);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbThongKeXeMoi = new JLabel("");
		
		lbThongKeXeMoi.setBounds(0, 0, 314, 176);
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
		lbThongKeXeMoi.setIcon(imageIcon);
		panel_1.add(lbThongKeXeMoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(409, 88, 314, 176);
		contentPane.add(panel_2);
		
		JLabel lbThongKeSoLuongXeBan = new JLabel("");
		lbThongKeSoLuongXeBan.setBounds(0, 0, 314, 176);
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
		lbThongKeSoLuongXeBan.setIcon(imageIcon1);
		panel_2.add(lbThongKeSoLuongXeBan);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(805, 88, 314, 176);
		contentPane.add(panel_3);
		
		JLabel lbThongKeSoTienDaBan = new JLabel("");
		lbThongKeSoTienDaBan.setBounds(0, 0, 314, 176);
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
		lbThongKeSoTienDaBan.setIcon(imageIcon2);
		panel_3.add(lbThongKeSoTienDaBan);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(1200, 88, 314, 176);
		contentPane.add(panel_4);
		
		JLabel lbThongKeKH = new JLabel("");
		lbThongKeKH.setBounds(0, 0, 314, 176);
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
		lbThongKeKH.setIcon(imageIcon3);
		panel_4.add(lbThongKeKH);
	}
}
