package old;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoIterable;

public class BrowserConnection {
	JFrame frame;
	
	public BrowserConnection() {
		frame = new JFrame("Open a Connection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		addComponent();
		
		frame.setVisible(true);
	}
	
	private void addComponent() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Database Connection"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		frame.getContentPane().add(panel);

		MongoIterable<String> dbNames = Driver.CLIENT.listDatabaseNames();
		Vector<String> databaseNames = new Vector<String>();
		for(String name : dbNames) {
			databaseNames.add(name);
		}

		JComboBox fieldDatabase = new JComboBox(databaseNames);
		JLabel labelDatabase = new JLabel("Database");

		fieldDatabase.setSelectedIndex(3);
		
		Vector<String> collectionName = new Vector<String>();

		JComboBox fieldCollection = new JComboBox(collectionName);
		JLabel labelCollection = new JLabel("Collection");
		labelCollection.setLabelFor(fieldCollection);
		
		getCollections(fieldDatabase, collectionName);
		fieldCollection.setSelectedIndex(0);
		
		fieldDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCollections(fieldDatabase, collectionName);
				fieldCollection.setSelectedIndex(0);
			}
		});
		

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.gridx = 0;
		constraints.gridx = 0;
		
		panel.add(labelDatabase, constraints);

		constraints.gridx = 0;
		constraints.gridx = 1;
		panel.add(fieldDatabase, constraints);

		constraints.gridx = 1;
		constraints.gridx = 0;
		panel.add(labelCollection, constraints);

		constraints.gridx = 0;
		constraints.gridx = 1;
		panel.add(fieldCollection, constraints);
		
		JButton button = new JButton("Connect");
		button.addActionListener(new ActionConnectDatabase(frame, (String) fieldDatabase.getSelectedItem(), fieldCollection.getSelectedItem().toString()));

		constraints.gridwidth = 2;
		constraints.gridx = 2;
		constraints.gridx = 0;
		panel.add(button, constraints);
	}
	
	public void getCollections(JComboBox fieldDatabase, Vector<String> collectionName) {
		collectionName.clear();
		String database = fieldDatabase.getSelectedItem().toString();

		MongoIterable<String> colNames = Driver.CLIENT.getDatabase(database).listCollectionNames();
		for(String name : colNames) {
			collectionName.add(name);
		}
	}
	
}
