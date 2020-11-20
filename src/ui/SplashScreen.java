package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	public JLabel lbLoad;
	public JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen() {
		setUndecorated(true);
		setBounds(100, 100, 795, 443); 
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Cửa Hàng Xe Máy Thành Nam");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(60, 104, 567, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CopyRigth 2020");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(531, 281, 194, 23);
		contentPane.add(lblNewLabel_1);
		
		lbLoad = new JLabel("...");
		lbLoad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lbLoad.setForeground(new Color(255, 255, 255));
		lbLoad.setBackground(Color.WHITE);
		lbLoad.setBounds(312, 359, 149, 23);
		contentPane.add(lbLoad);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(0, 385, 795, 21);
		progressBar.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(progressBar);
	}
}
