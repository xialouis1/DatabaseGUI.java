import java.util.Vector;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class DatabaseGUI {
	static MongoClient CLIENT;
	static MongoDatabase DATABASE;
	static MongoCollection<Document> COLLECTION;
	static Document DOCUMENT;
	
	static UI userinterface;
	
	static Vector<String> collectionNames;
	
	public static void main(String[] args) {
		setClient();
		
		userinterface = new UILanding();
	}

	public static void getClient() {
		
	}
	
	public static void setClient() {
		CLIENT = MongoClients.create();
		
		for(int i = 0; i < 5; ++i) {
			MongoDatabase database = CLIENT.getDatabase("mydatabase_" + i);
			MongoCollection<Document> collection = database.getCollection("mycollection" + i);
			
			database.drop();
			
			double document_limit = Math.random() * 10 + 5; // 5-15 Random documents
			for(int j = 0; j <= document_limit; j++) {
				Document document = new Document("_id", j);
				document.append("age_" + i, (int) (Math.random() * 59 + 1));
				document.append("rank_" + i, (int) (Math.random() * 4 + 1));
				
				collection.insertOne(document);
			}
		}
	}
	
	public static Vector<String> getDatabase() {
		MongoIterable<String> databaseNames = CLIENT.listDatabaseNames();
		Vector<String> names = new Vector<String>();
		for(String name : databaseNames) {
			names.add(name);
		}
		
		return names;
	}
	
	public static void setDatabase() {
		DATABASE = CLIENT.getDatabase(UILanding.getSelectedDatabase());
		collectionNames = new Vector<String>();
		for(String name : DATABASE.listCollectionNames()) {
			collectionNames.add(name);
		}
	}
	
	public static Vector<String> getCollection() {
		setDatabase();
		return collectionNames;
	}
	
	public static void setCollection(String database, String collection) {
		COLLECTION = CLIENT.getDatabase(database).getCollection(collection);
	}
	
	public static void getDocument() {
		
	}
	
	public static void setDocument() {
		
	}
}
