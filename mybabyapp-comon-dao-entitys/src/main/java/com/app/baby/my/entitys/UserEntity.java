package com.app.baby.my.entitys;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by mathieu_griffoul on 29/10/2017.
 */
@Document(collection = "users")
public class UserEntity implements Serializable{

	@Id
	private String mail;

	private String password;
	private String salt;
	private BabyEntity baby;
	private String firstName;
	private String lastName;
	private LocalDateTime creationDateTime;

	public UserEntity() {
	}

	public UserEntity(String mail, String password) {
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

	public BabyEntity getBaby() {
		return baby;
	}

	public void setBaby(BabyEntity baby) {
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

	public static UserEntityBuilder userEntityBuilder() {
		return new UserEntityBuilder();
	}

	public static final class UserEntityBuilder {
		private String mail;
		private String password;
		private String salt;
		private BabyEntity baby;
		private String firstName;
		private String lastName;
		private LocalDateTime creationDateTime;

		private UserEntityBuilder() {
		}



		public UserEntityBuilder mail(String mail) {
			this.mail = mail;
			return this;
		}

		public UserEntityBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserEntityBuilder salt(String salt) {
			this.salt = salt;
			return this;
		}

		public UserEntityBuilder baby(BabyEntity baby) {
			this.baby = baby;
			return this;
		}

		public UserEntityBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserEntityBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserEntityBuilder creationDateTime(LocalDateTime creationDateTime) {
			this.creationDateTime = creationDateTime;
			return this;
		}

		public UserEntity build() {
			UserEntity userEntity = new UserEntity();
			userEntity.setMail(mail);
			userEntity.setPassword(password);
			userEntity.setSalt(salt);
			userEntity.setBaby(baby);
			userEntity.setFirstName(firstName);
			userEntity.setLastName(lastName);
			userEntity.setCreationDateTime(creationDateTime);
			return userEntity;
		}
	}
}
