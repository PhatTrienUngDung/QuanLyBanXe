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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.annotation.processing.Messager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;

public class UI_ThongKe extends JFrame {

	private JPanel contentPane;

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
		
		JFreeChart jchart= ChartFactory.createBarChart("Thống kê số lượng", "Tháng", "Số lượng", dcd, PlotOrientation.VERTICAL, true, true, false);
		
		CategoryPlot plot= jchart.getCategoryPlot();
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		Color color = new Color(0, 192, 0);
		renderer.setSeriesPaint(0, color);
		plot.setRangeGridlinePaint(Color.black);
		ChartPanel chartPanel= new ChartPanel(jchart);
		chartPanel.setBounds(138, 213, 1072, 333);
		contentPane.add(chartPanel);
	}
}
