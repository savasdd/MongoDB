package com.mongodb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.db.DBConnection;
import com.mongodb.entity.UserEntity;

@ManagedBean
@SessionScoped
public class DataListBean implements Serializable {

	private static final long serialVersionUID = -4095430566864003425L;
	private List<UserEntity> userList;

	@PostConstruct
	public void init() {

		try {
			userList = new ArrayList<>();

			DBConnection db = new DBConnection();
			DBCollection table = db.getCollection("Kullanici");
			DBCursor cursor = table.find();

			while (cursor.hasNext()) {
				DBObject obj = cursor.next();

				UserEntity entity = new UserEntity(obj.get("name").toString(), obj.get("surname").toString(),
						obj.get("birthDate").toString(), obj.get("userName").toString(), obj.get("password").toString(),
						obj.get("createdDate").toString());

				userList.add(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hata");
		}

	}

	public List<UserEntity> getUserList() {
		return userList;
	}

}
