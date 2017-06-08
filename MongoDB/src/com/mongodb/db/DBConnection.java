package com.mongodb.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DBConnection {

	public DB getConnection() {
		//Connection
		MongoClient client = new MongoClient("localhost", 27017);
		MongoClient client2=new MongoClient("localhost");
		//database created
		return client2.getDB("testDB");

	}

	public DBCollection getCollection(String collection_name) {
		//collection created
		return getConnection().getCollection(collection_name);
	}

}
