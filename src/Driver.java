import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Driver {

	public static void main(String[] args) {
		BrowserDatabase browser = new BrowserDatabase();
		
		MongoClient client = MongoClients.create();
		MongoDatabase database = client.getDatabase("mydatabase");
		MongoCollection<Document> collection = database.getCollection("mycollection");
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
