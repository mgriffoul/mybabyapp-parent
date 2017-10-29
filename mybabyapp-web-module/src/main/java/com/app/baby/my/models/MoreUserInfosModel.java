package com.app.baby.my.models;

/**
 * Created by mathieu_griffoul on 29/10/2017.
 */
public class MoreUserInfosModel {

	/**
	 * User's first name
	 */
	private String firstName;

	/**
	 * User's last name
	 */
	private String lastName;

	/**
	 * Baby's user's first name
	 */
	private String babyFirstName;

	/**
	 * Baby's user's sexe
	 */
	private String sexe;

	/**
	 * Baby's user's birthDate
	 */
	private String birthDate;

	/**
	 * getter and setters
	 * @return
	 */
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

	public String getBabyFirstName() {
		return babyFirstName;
	}

	public void setBabyFirstName(String babyFirstName) {
		this.babyFirstName = babyFirstName;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
}
