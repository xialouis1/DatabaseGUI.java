import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Driver {

	public static void main(String[] args) {
//		initializeDatabase();
		
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
	
	private static void initializeDatabase() {
		MongoClient client = MongoClients.create();
		MongoDatabase database = client.getDatabase("mydatabase");
		MongoCollection<Document> collection = database.getCollection("mycollection");
		
//		collection.drop();
		
		double count = Math.random() * 20 + 5; // 5-25 Random documents
		for(int i = 1; i <= count; i++) {
			Document document = new Document();
			document.append("_id", i);
			int age = (int) (Math.random() * 59 + 1); // 1 - 60 Age value
			document.append("age", age);
			int group = (int) (Math.random() * 4 + 1); // 1 - 5 Group options
			document.append("group", group);

			collection.insertOne(document);
		}
		
		
	}
}
