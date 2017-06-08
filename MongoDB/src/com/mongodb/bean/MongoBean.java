package com.mongodb.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.db.DBConnection;
import com.mongodb.entity.UserEntity;

@ManagedBean(name = "mongobean")
@SessionScoped
public class MongoBean implements Serializable {

	private static final long serialVersionUID = -3581977289633723455L;

	private String name;
	private String surname;
	private Date birthDate;
	private String userName;
	private String password;
	private Date createdDate;
	private UserEntity select;
	public DBCollection table;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public UserEntity getSelect() {
		return select;
	}
	
	public void setSelect(UserEntity select) {
		this.select = select;
	}
	
	public void register() {

		try {
			DBConnection db = new DBConnection();
			table = db.getCollection("Kullanici");
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			BasicDBObject document = new BasicDBObject();
			document.put("name", getName());
			document.put("surname", getSurname());
			document.put("birthDate", df.format(getBirthDate()));
			document.put("userName", getUserName());
			document.put("password", getPassword());
			setCreatedDate(new Date());
			document.put("createdDate", df.format(getCreatedDate()));
			table.insert(document);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	
	 public void onRowSelect(SelectEvent event) {
			DBConnection db = new DBConnection();
			table = db.getCollection("Kullanici");
			BasicDBObject bs = new BasicDBObject();	
			bs.put("name", ((UserEntity) event.getObject()).getName());
			table.remove(bs);
	        FacesMessage msg = new FacesMessage(((UserEntity) event.getObject()).getName()+" isimli kayıt silindi!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	 
	    public void onRowUnselect(UnselectEvent event) {
	        FacesMessage msg = new FacesMessage("Car Unselected", ((UserEntity) event.getObject()).getName());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
}
