package com.app.baby.my.entity;

import java.time.LocalDateTime;

import com.app.baby.my.enums.ESexe;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public class Baby {

	private String id;
	private String firstName;
	private LocalDateTime birthDate;
	private ESexe sexe;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public ESexe getSexe() {
		return sexe;
	}

	public void setSexe(ESexe sexe) {
		this.sexe = sexe;
	}
}








