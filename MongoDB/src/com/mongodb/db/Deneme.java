package com.mongodb.db;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Deneme {

	private static DBCollection table;
	private static DBConnection db;

	public static void main(String[] args) {

		try {

			gets();
			// delete("zeki");
			// insert();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Hata!!!...");
		}

	}

	public static void insert() {
		try {
			db = new DBConnection();
			table = db.getCollection("user");

			BasicDBObject document = new BasicDBObject();
			document.put("name", "Savaş");
			document.put("age", 30);
			document.put("createDate", new Date());
			table.insert(document);

			System.out.println("Kayit eklendi!");
		} catch (Exception e) {

		}

	}

	public static void update() {
		try {

			db = new DBConnection();
			table = db.getCollection("user");

			BasicDBObject query = new BasicDBObject();
			query.put("name", "Ali");

			BasicDBObject newquery = new BasicDBObject();
			newquery.put("name", "Dilek");

			BasicDBObject updatequery = new BasicDBObject();
			updatequery.put("$set", newquery);
			table.update(query, updatequery);

			System.out.println("Kayit guncellendi!");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void delete(String name) {
		try {

			db = new DBConnection();
			table = db.getCollection("user");

			BasicDBObject bs = new BasicDBObject();
			bs.put("name", name);
			table.remove(bs);

			System.out.println("Kayit silindi!");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void gets() {
		try {

			db = new DBConnection();
			table = db.getCollection("user");

			DBCursor cursor = table.find();
			while (cursor.hasNext()) {
				DBObject obj = cursor.next();

				System.out
						.println("[ " + obj.get("name") + ", " + obj.get("age") + " , " + obj.get("createDate") + " ]");
			}

		} catch (Exception e) {

		}
	}

}
