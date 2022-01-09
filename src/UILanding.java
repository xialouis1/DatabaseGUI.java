import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UILanding extends UI {
	static DefaultComboBoxModel databases;
	static DefaultComboBoxModel collections;
	static JComboBox fieldDatabase;
	static JComboBox fieldCollection;

	protected void addComponent() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		add(panel);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		databases = new DefaultComboBoxModel(DatabaseGUI.getDatabase());
		fieldDatabase = new JComboBox(databases);
//		fieldDatabase.setEditable(true);
		fieldDatabase.setSelectedIndex(3);
		panel.add(fieldDatabase, constraints);
		fieldDatabase.addActionListener(new ActChangeDatabaseSelection());

		constraints.gridx = 0;
		constraints.gridy = 0;
		JLabel labelDatabase = new JLabel("Database: ");
		labelDatabase.setLabelFor(fieldDatabase);
		panel.add(labelDatabase, constraints);

		constraints.gridx = 1;
		constraints.gridy = 1;
		collections = new DefaultComboBoxModel(DatabaseGUI.getCollection());
		fieldCollection = new JComboBox(collections);
		fieldCollection.setEditable(false);
		panel.add(fieldCollection, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		JLabel labelCollection = new JLabel("Collection: ");
		labelCollection.setLabelFor(fieldCollection);
		panel.add(labelCollection, constraints);
		
		constraints.gridwidth = 2;
		constraints.gridx = 0;
		constraints.gridy = 2;
		JButton button = new JButton("Connect");
		button.addActionListener(new ActConnectToDatabase());
		panel.add(button, constraints);
	}
	
	public static void setSelectedDatabase() {
		databases.removeAllElements();
		databases.addAll(DatabaseGUI.getDatabase());
	}
	
	public static void setSelectedCollection() {
		collections.removeAllElements();
		collections.addAll(DatabaseGUI.getCollection());
		fieldCollection.setSelectedIndex(0);
	}
	
	public static String getSelectedDatabase() {
		return fieldDatabase.getSelectedItem().toString();
	}
	
	public static String getSelectedCollection() {
		return fieldCollection.getSelectedItem().toString();
	}
}
