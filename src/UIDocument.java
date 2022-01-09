import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIDocument extends UI {

	@Override
	protected void addComponent() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Database Connection"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		add(panel);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		JLabel labelId = new JLabel("ID: ");
		panel.add(labelId, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		JLabel labelAge = new JLabel("Age: ");
		panel.add(labelAge, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		JLabel labelRank = new JLabel("Rank: ");
		panel.add(labelRank, constraints);
	}

}
