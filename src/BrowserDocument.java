import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BrowserDocument {
	
	public BrowserDocument(Object id) {
		MongoClient client = MongoClients.create();
		MongoDatabase database = client.getDatabase("mydatabase");
		MongoCollection<Document> collection = database.getCollection("mycollection");
		
		Bson filter = Filters.eq("_id", id);
		
		MongoCursor<Document> cursor = collection.find(filter).iterator();
				
		if(!cursor.hasNext()) {
			// No object found error? Do nothing?
		}
		
		Document document = cursor.next();
		
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		
		JLabel textId = new JLabel((String) document.get("_id").toString());
		JLabel textRank = new JLabel((String) document.get("age").toString());
		JLabel textAge = new JLabel((String) document.get("group").toString());

		frame.add(BorderLayout.NORTH, textId);
		frame.add(BorderLayout.CENTER, textRank);
		frame.add(BorderLayout.SOUTH, textAge);
		
		frame.pack();
		frame.setVisible(true);
		
		if(cursor.hasNext()) {
			// Duplicate id. Error?
		}
	}
	
}
