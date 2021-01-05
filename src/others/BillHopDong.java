package others;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.UI_XuatHopDong;

import javax.swing.JTextArea;
public class BillHopDong extends JFrame{
	private JPanel contentPane;
	public static JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public BillHopDong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		textArea = new JTextArea();
		textArea.setBounds(5, 5, 426, 248);
		textArea.append("\n         		  HỢP ĐỒNG MUA BÁN XE ");
		textArea.append("\n	Mã hợp đồng là         		: "	+UI_XuatHopDong.txtmaHD.getText());
		textArea.append("\n	Tên nhân viên là              		: " +UI_XuatHopDong.txttenNV.getText());
		textArea.append("\n	Tên khách hàng là         		: " +UI_XuatHopDong.txttenKH.getText());
		textArea.append("\n	Số chứng minh nhân dân là 		: " +UI_XuatHopDong.txtcmnd.getText());
		textArea.append("\n	Số điện thoại là          		: " +UI_XuatHopDong.txtsdt.getText());
		textArea.append("\n	Loại xe là                		: " +UI_XuatHopDong.txtloaiXe.getText());
		textArea.append("\n	Tên xe là                 		: " +UI_XuatHopDong.txttenXe.getText());
		textArea.append("\n	Phân khối là              		: " +UI_XuatHopDong.txtphanKhoi.getText());
		textArea.append("\n	Màu xe là                 		: " +UI_XuatHopDong.txtmauXe.getText());
		textArea.append("\n	Số khung là               		: " +UI_XuatHopDong.txtsoKhung.getText());
		textArea.append("\n	Số máy là                 		: " +UI_XuatHopDong.txtsoMay.getText());
		textArea.append("\n	Đơn giá là                		: " +UI_XuatHopDong.txtdonGia.getText());
		textArea.append("\n	Thời gian bảo hành  là    		: " +UI_XuatHopDong.txttgbh.getText());
		textArea.append("\n                                     		Ngày     Tháng    Năm    ");
		textArea.append("\n Bên bán                          											 Người mua");
		contentPane.add(textArea);
	}
}
