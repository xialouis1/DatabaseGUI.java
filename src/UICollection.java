import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import old.Driver;

public class UICollection extends UI {
	static DefaultTableModel tableModel;
	static JTable table;

	@Override
	protected void addComponent() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		add(panel);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setAutoCreateRowSorter(true);

		tableModel = new DefaultTableModel(0, 0);
		table.setModel(tableModel);
		
		JScrollPane scrollpane = new JScrollPane(table);
		panel.add(scrollpane, BorderLayout.CENTER);

		JButton button = new JButton("Select");
		button.addActionListener(new ActViewDocument());
		panel.add(button, BorderLayout.SOUTH);
		
		addTableData();
	}
	
	private void addTableData() {
		MongoCursor<Document> cursor = DatabaseGUI.COLLECTION.find().iterator();
		
		if(cursor.hasNext()) {
			Document document = cursor.next();
			addColumnName(document.keySet().toArray());
			while(cursor.hasNext()) {
				addRowData(document.values().toArray());
				document = cursor.next();
			}
		} 
		
	}

	public void addRowData(Object[] objects) {
		tableModel.addRow(objects);
	}
	
	public void addColumnName(Object[] names) {
		tableModel.setColumnIdentifiers(names);
	}

}
