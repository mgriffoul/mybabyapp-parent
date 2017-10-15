package com.app.baby.my.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
@Document (collection = "users")
public class User {

	@Id
	private String mail;

	private String password;
	private String salt;
	private Baby baby;
	private String firstName;
	private String lastName;
	private LocalDateTime creationDateTime;


	public User() {
	}

	public User(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Baby getBaby() {
		return baby;
	}

	public void setBaby(Baby baby) {
		this.baby = baby;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"mail='" + mail + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", baby=" + baby +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", creationDateTime=" + creationDateTime +
				'}';
	}
}
