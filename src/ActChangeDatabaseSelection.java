import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActChangeDatabaseSelection implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		UILanding.setSelectedCollection();
	}

}
