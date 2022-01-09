import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UICollection extends UI {
	DefaultTableModel tableModel;

	@Override
	protected void addComponent() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		add(panel);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		
		JTable table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setAutoCreateRowSorter(true);

		tableModel = new DefaultTableModel(0, 0);
		table.setModel(tableModel);

		constraints.gridx = 0;
		constraints.gridy = 0;
		JScrollPane scrollpane = new JScrollPane(table);
		panel.add(scrollpane, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		JButton button = new JButton("Select");
		button.addActionListener(null);
		panel.add(button, constraints);
	}
	
	private void addTableData() {
		
	
		for(int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
	}

	public void addRowData(Object[] objects) {
		tableModel.addRow(objects);
	}
	
	public void addColumnName(Object[] names) {
		tableModel.setColumnIdentifiers(names);
	}

}
