package com.app.baby.my.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
@Document (collection = "users")
public class User implements Serializable{

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

	public static UserBuilder userBuilder() {
		return new UserBuilder();
	}


	public static final class UserBuilder {
		private String mail;
		private String password;
		private String salt;
		private Baby baby;
		private String firstName;
		private String lastName;
		private LocalDateTime creationDateTime;

		private UserBuilder() {
		}

		public UserBuilder mail(String mail) {
			this.mail = mail;
			return this;
		}

		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder salt(String salt) {
			this.salt = salt;
			return this;
		}

		public UserBuilder baby(Baby baby) {
			this.baby = baby;
			return this;
		}

		public UserBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder creationDateTime(LocalDateTime creationDateTime) {
			this.creationDateTime = creationDateTime;
			return this;
		}

		public User build() {
			User user = new User();
			user.setMail(mail);
			user.setPassword(password);
			user.setSalt(salt);
			user.setBaby(baby);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setCreationDateTime(creationDateTime);
			return user;
		}
	}
}
