package com.app.baby.my.models;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public class UserCreationModel {

	private String mail;
	private String password;
	private String passwordConfirm;

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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

	public static UserCreationModelBuilder userCreationModelBuilder() {
		return new UserCreationModelBuilder();
	}

	public static final class UserCreationModelBuilder {
		private String mail;
		private String password;
		private String passwordConfirm;

		private UserCreationModelBuilder() {
		}

		public UserCreationModelBuilder mail(String mail) {
			this.mail = mail;
			return this;
		}

		public UserCreationModelBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserCreationModelBuilder passwordConfirm(String passwordConfirm) {
			this.passwordConfirm = passwordConfirm;
			return this;
		}

		public UserCreationModel build() {
			UserCreationModel userCreationModel = new UserCreationModel();
			userCreationModel.setMail(mail);
			userCreationModel.setPassword(password);
			userCreationModel.setPasswordConfirm(passwordConfirm);
			return userCreationModel;
		}
	}
}
