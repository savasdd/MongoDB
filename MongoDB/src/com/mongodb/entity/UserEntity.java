package com.mongodb.entity;

public class UserEntity {

	private String name;
	private String surname;
	private String birthDate;
	private String userName;
	private String password;
	private String createdDate;

	public UserEntity(String name, String surname, String birthDate, String userName, String password,
			String createdDate) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.userName = userName;
		this.password = password;
		this.createdDate = createdDate;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
