import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ActionConnectDatabase implements ActionListener {
	JFrame frame;
	String databaseName;
	String collectionName;
	BrowserDatabase browser;
	
	public ActionConnectDatabase(JFrame frame, String fieldDatabase, String fieldCollection) {
		this.frame = frame;
		this.databaseName = fieldDatabase;
		this.collectionName = fieldCollection;
	}
	
	public void actionPerformed(ActionEvent e) {
		// Error handling before closing dialog
		if(databaseName.length() < 1) {
			String title = "Error";
			String message = "No database name was given.";
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} else if(collectionName.length() < 1) {
			String title = "Error";
			String message = "No collection name was given.";
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
		} else {
			frame.setVisible(false);

			browser = new BrowserDatabase();
			
			MongoClient client = Driver.CLIENT;
			MongoDatabase database = client.getDatabase(databaseName);
			MongoCollection<Document> collection = database.getCollection(collectionName);
			MongoCursor<Document> cursor = collection.find().iterator();
			
			if(cursor.hasNext()) {
				Document document = cursor.next();
				browser.addColumnName(document.keySet().toArray());
				while(cursor.hasNext()) {
					browser.addRowData(document.values().toArray());
					document = cursor.next();
				}
			} 
		}
	}
	
}
