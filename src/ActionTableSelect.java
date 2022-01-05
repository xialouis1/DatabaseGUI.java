import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.bson.types.ObjectId;

public class ActionTableSelect implements ActionListener {
	JTable table;
	
	public ActionTableSelect(JTable table) {
		this.table = table;
	}
	
	public void actionPerformed(ActionEvent event) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		
		try {
			if(row < 0) {
				throw new ArrayIndexOutOfBoundsException(row);
			}
			
			if(col < 0) {
				throw new ArrayIndexOutOfBoundsException(col);
			}
			
			ObjectId selected = (ObjectId) table.getValueAt(row, 0);
			System.out.printf("_id: %s%n", selected);
			new BrowserDocument(selected);
		} catch (ArrayIndexOutOfBoundsException exception) {
			arrayOutOfBounds();
		}
	}
	
	private void arrayOutOfBounds() {
		String message = "No Document was selected.";
		String title = "Error";
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

}
