import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActConnectionUI implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DatabaseGUI.userinterface.setVisible(false);
		DatabaseGUI.userinterface = new UILanding();
	}

}
