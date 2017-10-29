package com.app.baby.my.dto;

import java.time.LocalDateTime;

/**
 * Created by mathieu_griffoul on 29/10/2017.
 */
public class UserDto {

	/**
	 * User's id, email adress
	 */
	private String mail;

	/**
	 * User's password
	 */
	private String password;

	/**
	 * User's password salt
	 */
	private String salt;

	/**
	 * Indicates if user has finished all his sign up steps
	 */
	private boolean allSignUpInfoGiven;

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

	public boolean isAllSignUpInfoGiven() {
		return allSignUpInfoGiven;
	}

	public void setAllSignUpInfoGiven(boolean allSignUpInfoGiven) {
		this.allSignUpInfoGiven = allSignUpInfoGiven;
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

	public static UserDtoBuilder userDtoBuilder() {
		return new UserDtoBuilder();
	}

	public static final class UserDtoBuilder {
		private String mail;
		private String password;
		private String salt;
		private boolean allSignUpInfoGiven;
		private String firstName;
		private String lastName;
		private LocalDateTime creationDateTime;

		private UserDtoBuilder() {
		}

		public UserDtoBuilder mail(String mail) {
			this.mail = mail;
			return this;
		}

		public UserDtoBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserDtoBuilder salt(String salt) {
			this.salt = salt;
			return this;
		}

		public UserDtoBuilder allSignUpInfoGiven(boolean allSignUpInfoGiven) {
			this.allSignUpInfoGiven = allSignUpInfoGiven;
			return this;
		}

		public UserDtoBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserDtoBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDtoBuilder creationDateTime(LocalDateTime creationDateTime) {
			this.creationDateTime = creationDateTime;
			return this;
		}

		public UserDto build() {
			UserDto userDto = new UserDto();
			userDto.setMail(mail);
			userDto.setPassword(password);
			userDto.setSalt(salt);
			userDto.setAllSignUpInfoGiven(allSignUpInfoGiven);
			userDto.setFirstName(firstName);
			userDto.setLastName(lastName);
			userDto.setCreationDateTime(creationDateTime);
			return userDto;
		}
	}
}
