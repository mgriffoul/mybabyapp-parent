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


	/**
	 * User's id, email adress
	 */
	@Id
	private String mail;

	/**
	 * User's password
	 */
	private String password;

	/**
	 * User password's salt
	 */
	private String salt;

	/**
	 * User's baby
	 */
	private BabyEntity baby;

	/**
	 * First name's user
	 */
	private String firstName;

	/**
	 * Last name's user
	 */
	private String lastName;

	/**
	 * Date time of account creation
	 */
	private LocalDateTime creationDateTime;

	/**
	 * Indicates if user has finished all his sign up steps
	 */
	private boolean allSignUpInfoGiven;

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

	public boolean isAllSignUpInfoGiven() {
		return allSignUpInfoGiven;
	}

	public void setAllSignUpInfoGiven(boolean allSignUpInfoGiven) {
		this.allSignUpInfoGiven = allSignUpInfoGiven;
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
		private boolean allSignUpInfoGiven;

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

		public UserEntityBuilder allSignUpInfoGiven(boolean allSignUpInfoGiven) {
			this.allSignUpInfoGiven = allSignUpInfoGiven;
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
			userEntity.setAllSignUpInfoGiven(allSignUpInfoGiven);
			return userEntity;
		}
	}
}
