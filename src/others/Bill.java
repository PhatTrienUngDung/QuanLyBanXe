package others;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.Dao_HoaDon;
import dao.Dao_NhanVien;
import entity.HoaDon;
import entity.KhachHang;
import entity.Xe;
import ui.Login;
import ui.UI_HoaDon;
import ui.UI_ThanhToan;

import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Bill extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea;
	public static String maHD;
	public static int kt=0;
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

	/**
	 * Create the frame.
	 */
	public Bill() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Dao_HoaDon dao_hd = new Dao_HoaDon();
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setBounds(5, 5, 693, 535);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		KhachHang kh = dao_hd.getKhachHangbyHDId(maHD);
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		HoaDon hd = dao_hd.getHoaDonByID(maHD);
		
		textArea.append("\n				CỬA HÀNG XE MÁY NAM THÀNH \n");
		textArea.append("\n		12-14 Phan Văn Trị, Phường 5, Gò Vấp, Thành Phố Hồ Chí Minh \n");
		textArea.append("	    ---------------------------------------------------------------------\n\n");
		textArea.append("			PHIẾU THANH TOÁN \n");
		textArea.append("\n			Số Hóa Đơn          :" + maHD + "\n");
		textArea.append("			Ngày Lập Hóa Đơn    :" +  hd.getNgayLapHoaDon() + "\n");
		textArea.append("			Nhân Viên           :" + dao_nv.getTenNhanVienById("NV_0001") + "\n");
		textArea.append("	    ---------------------------------------------------------------------\n\n");
		textArea.append("			THÔNG TIN KHÁCH HÀNG \n");
		textArea.append("\n			Tên khách hàng      :  " + kh.getTenKhachHang() + "\n");
		textArea.append("			Chứng minh nhân dân :  " + kh.getCMND() + "\n");
		textArea.append("			Số điện thoại       :  " + kh.getSoDienThoai() + "\n");
		textArea.append("\n      ----------------------------------------------------------------------------------------\n");
		//"   |    Tên xe    |      Màu xe ở   |Phân Khối|     Số khung      |  Số máy  |   Thành tiền    |\n"
		textArea.append(String.format("   |%-14s|%-16s|%-9s|%-19s|%-10s|%-17s|\n", "    Tên xe    ", "      Màu xe    ", "Phân Khối", "     Số khung      ", "  Số máy  ", "   Thành tiền    "));
		textArea.append("      ----------------------------------------------------------------------------------------\n");
		
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		NumberFormat num = NumberFormat.getNumberInstance();
		int tableRowCount  = UI_HoaDon.table.getRowCount();
		String tenXe, mauXe, phanKhoi, soKhung, soMay, thanhTien;
		
		List<Xe> listOrderDetails = dao_hd.getListOrderDetails(maHD);
		for(Xe xe : listOrderDetails) {
			textArea.append(String.format("   |%-14s|%-16s|%-9s|%-19s|%-10s|%-17s|\n",xe.getTenXe(), xe.getMauXe(), xe.getPhanKhoi()+"", xe.getSoKhung(), xe.getSoMay(), df.format(xe.getThanhTien())));
			textArea.append("      ----------------------------------------------------------------------------------------\n");
		}
		double cusMoney = 0;
		textArea.append(String.format("\n							Total          : %20s" , df.format(dao_hd.getTotalMoneyHD(maHD))));
		if(kt == 0) {
			try {
				cusMoney = num.parse(UI_ThanhToan.txtCusMoney.getText()).doubleValue();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textArea.append(String.format("\n							Tiền khách trả : %20s" , df.format(cusMoney)));
			textArea.append(String.format("\n							Tiền thừa      : %20s" , UI_ThanhToan.txtRefunds.getText()));
		} else
			textArea.append("\n\n			Ngày xuất hóa đơn  :  " + LocalDateTime.now() +"\n");
		contentPane.add(textArea);
	}

	private void setViewportView(JTable table) {
		// TODO Auto-generated method stub
		
	}
}
