package old;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BrowserDatabase {
	JFrame frame;
	DefaultTableModel tableModel;
	
	public BrowserDatabase() {
		frame = new JFrame("Collection Name");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		addComponent();
		
		frame.setVisible(true);
	}
	
	private void addComponent() {

		JMenuBar menubar = new JMenuBar();
		JMenu m1 = new JMenu("File");
		JMenuItem m11 = new JMenuItem("Open");
		
		m11.addActionListener(new ActionDatabaseConnection(frame));
		m1.add(m11);
		menubar.add(m1);
		
		frame.getContentPane().add(BorderLayout.NORTH, menubar);

		JTable table = new JTable();
		JScrollPane panel = new JScrollPane(table);
		tableModel = new DefaultTableModel(0, 0);

		table.setDefaultEditor(Object.class, null);
		table.setAutoCreateRowSorter(true);
		table.setModel(tableModel);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		JButton button = new JButton("Select");
		button.addActionListener(new ActionTableSelect(table));
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
	}

	public void addRowData(Object[] objects) {
		tableModel.addRow(objects);
		
	}
	
	public void addColumnName(Object[] names) {
		tableModel.setColumnIdentifiers(names);
	}
	
}
