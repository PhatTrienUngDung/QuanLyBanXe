package ui;


	import java.awt.*;
	import javax.swing.*;
	import javax.swing.table.*;

	public class TableIcon extends JPanel
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TableIcon()
	    {
	        Icon aboutIcon = new ImageIcon("img1/thungrac.png");
	        Icon addIcon = new ImageIcon("add16.gif");
	        Icon copyIcon = new ImageIcon("copy16.gif");

	        String[] columnNames = {"Picture", "Description"};
	        Object[][] data =
	        {
	            {aboutIcon, "About"},
	            {addIcon, "Add"},
	            {copyIcon, "Copy"},
	        };

	        DefaultTableModel model = new DefaultTableModel(data, columnNames)
	        {
	            //  Returning the Class of each column will allow different
	            //  renderers to be used based on Class
	            public Class getColumnClass(int column)
	            {
	                return getValueAt(0, column).getClass();
	            }
	        };
	        setLayout(null);
	        JTable table = new JTable( model );
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());

	        JScrollPane scrollPane = new JScrollPane( table );
	        scrollPane.setBounds(368, 5, 152, 74);
	        add( scrollPane );
	        
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setBounds(132, 134, 545, 292);
	        add(fileChooser);
	    }

	    private static void createAndShowGUI()
	    {
	        JFrame frame = new JFrame("Table Icon");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(new TableIcon());
	        frame.setLocationByPlatform( true );
	        frame.pack();
	        frame.setVisible( true );
	    }

	    public static void main(String[] args)
	    {
	        EventQueue.invokeLater(new Runnable()
	        {
	            public void run()
	            {
	                createAndShowGUI();
	            }
	        });
	    }
}
