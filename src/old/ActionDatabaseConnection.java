package old;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionDatabaseConnection implements ActionListener {
	JFrame frame;
	
	public ActionDatabaseConnection(JFrame frame) {
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		new BrowserConnection();
	}
	
}
