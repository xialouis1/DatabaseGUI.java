import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bson.Document;

public class UIDocument extends UI {


	@Override
	protected void addComponent() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Database Connection"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		add(panel);
		
		Document document = DatabaseGUI.DOCUMENT;
		for(String key: document.keySet()) {
			JLabel labelKey = new JLabel(key);
			panel.add(labelKey);
			
			String value = "" + document.get(key);
			JTextField textValue = new JTextField(value, 10);
			panel.add(textValue);
		}
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(200, 200);
		setLocationRelativeTo(null);
	}

}
