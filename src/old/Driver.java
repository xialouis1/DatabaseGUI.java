package old;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Driver {
	static MongoClient CLIENT;

	public static void main(String[] args) {
		CLIENT = MongoClients.create();
		
		initializeDatabase();
		
		new BrowserConnection();
	}
	
	private static void initializeDatabase() {
		for(int i = 0; i < 5; ++i) {
			MongoDatabase database = CLIENT.getDatabase("mydatabase_" + i);
			MongoCollection<Document> collection = database.getCollection("mycollection" + i);
			
			database.drop();
			
			double document_limit = Math.random() * 10 + 5; // 5-15 Random documents
			for(int j = 0; j <= document_limit; j++) {
				Document document = new Document("_id", j);
				document.append("age", (int) (Math.random() * 59 + 1));
				document.append("rank", (int) (Math.random() * 4 + 1));
				
				collection.insertOne(document);
			}
		}
	}
	
}
