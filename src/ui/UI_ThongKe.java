package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.util.Locale.Category;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.Legend;
import org.jfree.chart.demo.PieChartDemo1;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.annotation.processing.Messager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.DefaultComboBoxModel;

public class UI_ThongKe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_ThongKe frame = new UI_ThongKe();
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
	@SuppressWarnings("deprecation")
	public UI_ThongKe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultCategoryDataset dcd= new DefaultCategoryDataset();
		dcd.addValue(20, "Số lượng", "Tháng 1");
		dcd.addValue(100, "Số lượng", "Tháng 2");
		dcd.addValue(200, "Số lượng", "Tháng 3");
		dcd.addValue(14, "Số lượng", "Tháng 4");
		dcd.addValue(16, "Số lượng", "Tháng 5");
		dcd.addValue(19, "Số lượng", "Tháng 6");
		dcd.addValue(29, "Số lượng", "Tháng 7");
		dcd.addValue(22, "Số lượng", "Tháng 8");
		dcd.addValue(26, "Số lượng", "Tháng 9");
		dcd.addValue(23, "Số lượng", "Tháng 10");
		dcd.addValue(11, "Số lượng", "Tháng 11");
		dcd.addValue(223, "Số lượng", "Tháng 12");
		
		JFreeChart jchart= ChartFactory.createBarChart("Thống kê số lượng xe bán", "Tháng", "Số lượng", dcd, PlotOrientation.VERTICAL, true, true, false);
		
		CategoryPlot plot= jchart.getCategoryPlot();
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		Color color = new Color(0, 192, 0);
		renderer.setSeriesPaint(0, color);
		plot.setRangeGridlinePaint(Color.black);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Nhóm 0 - 14", 26);
        dataset.setValue("Nhóm 15 - 59", 30);
        dataset.setValue("Nhóm trên 60", 44);
        JFreeChart pieChart = ChartFactory.createPieChart("Thống kê xe", dataset, true, true, true);
        PiePlot p= (PiePlot) pieChart.getPlot();
        
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 312, 805, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		ChartPanel chartPanel= new ChartPanel(jchart);
		chartPanel.setBounds(10, 10, 782, 333);
		panel.add(chartPanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(832, 312, 411, 356);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		ChartPanel chartPanel1= new ChartPanel(pieChart);
		chartPanel1.setBounds(10, 10, 391, 333);
		panel_1.add(chartPanel1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(10, 159, 607, 143);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(new Color(0, 128, 0));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setToolTipText("");
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setText("20,000,000 đ");
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 31, 587, 49);
		panel_2.add(textField);
		textField.setColumns(20);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBackground(Color.WHITE);
		textField_1.setEnabled(false);
		textField_1.setBounds(10, 79, 287, 54);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.GREEN);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBackground(Color.WHITE);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(296, 79, 301, 54);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 215, 0));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(0, 0, 607, 28);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng Số Tiền Thu Được");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(163, 0, 285, 23);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(636, 159, 607, 143);
		contentPane.add(panel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setText("100");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(new Color(0, 128, 0));
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(20);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(10, 31, 587, 49);
		panel_2_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(10, 79, 287, 54);
		panel_2_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(Color.GREEN);
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(296, 79, 301, 54);
		panel_2_1.add(textField_5);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 140, 0));
		panel_3_1.setBounds(0, 0, 607, 28);
		panel_2_1.add(panel_3_1);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng Số Lượng Xe Đã Bán");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(155, 0, 285, 23);
		panel_3_1.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ngay", "Thang", "Nam"}));
		comboBox.setBounds(202, 99, 118, 21);
		contentPane.add(comboBox);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooser_1.setBounds(10, 101, 182, 19);
		contentPane.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Lọc");
		btnNewButton.setBounds(340, 99, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(284, 159, 45, 13);
		contentPane.add(lblNewLabel);
	}
}
