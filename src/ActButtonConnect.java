import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActButtonConnect implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DatabaseGUI.setCollection(UILanding.getSelectedDatabase(),
				UILanding.getSelectedCollection());

		DatabaseGUI.userinterface.setVisible(false);
		DatabaseGUI.userinterface = new UICollection();
	}

}
