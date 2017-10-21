package com.app.baby.my.dto;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class UserDto {

	private String mail;
	private String password;

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

	public static UserDtoBuilder userDtoBuilder() {
		return new UserDtoBuilder();
	}

	public static final class UserDtoBuilder {
		private String mail;
		private String password;

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

		public UserDto build() {
			UserDto userDto = new UserDto();
			userDto.setMail(mail);
			userDto.setPassword(password);
			return userDto;
		}
	}
}
