import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BrowserConnection2 {
	JFrame frame;
	
	public BrowserConnection2() {
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
		
		JTextField fieldDatabase = new JTextField(20);
		JLabel labelDatabase = new JLabel("Database");
		labelDatabase.setLabelFor(fieldDatabase);
		
		
		JTextField fieldCollection = new JTextField(20);
		JLabel labelCollection = new JLabel("Collection");
		labelCollection.setLabelFor(fieldCollection);

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
		button.addActionListener(new ActionConnectDatabase(frame, fieldDatabase.getText(), fieldCollection.getText()));

		constraints.gridwidth = 2;
		constraints.gridx = 2;
		constraints.gridx = 0;
		panel.add(button, constraints);
	}
	
}
