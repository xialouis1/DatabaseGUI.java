import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActViewDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = UICollection.table.getSelectedRow();
		
		if(row == -1) {
			UICollection.showError(true);
		} else {
			UICollection.showError(false);
			Object id = UICollection.table.getValueAt(row, 0);
			DatabaseGUI.setDocument(id);
			new UIDocument();
		}
	}

}
