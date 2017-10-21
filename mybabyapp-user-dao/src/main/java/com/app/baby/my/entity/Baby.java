package com.app.baby.my.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.app.baby.my.enums.ESexe;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public class Baby implements Serializable{

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

	public static BabyBuilder builder() {
		return new BabyBuilder();
	}

	public static final class BabyBuilder {
		private String id;
		private String firstName;
		private LocalDateTime birthDate;
		private ESexe sexe;

		private BabyBuilder() {
		}

		public BabyBuilder id(String id) {
			this.id = id;
			return this;
		}

		public BabyBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public BabyBuilder birthDate(LocalDateTime birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public BabyBuilder sexe(ESexe sexe) {
			this.sexe = sexe;
			return this;
		}

		public Baby build() {
			Baby baby = new Baby();
			baby.setId(id);
			baby.setFirstName(firstName);
			baby.setBirthDate(birthDate);
			baby.setSexe(sexe);
			return baby;
		}
	}
}








