package com.app.baby.my.entitys;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;
import com.app.baby.my.enums.ESexe;

/**
 * Created by mathieu_griffoul on 29/10/2017.
 */
@Document(collection = "babys")
public class BabyEntity implements Serializable {

	private String id;
	private String firstName;
	private LocalDate birthDate;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public ESexe getSexe() {
		return sexe;
	}

	public void setSexe(ESexe sexe) {
		this.sexe = sexe;
	}

	public static BabyEntityBuilder babyEntityBuilder() {
		return new BabyEntityBuilder();
	}

	public static final class BabyEntityBuilder {
		private String id;
		private String firstName;
		private LocalDate birthDate;
		private ESexe sexe;

		private BabyEntityBuilder() {
		}

		public BabyEntityBuilder id(String id) {
			this.id = id;
			return this;
		}

		public BabyEntityBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public BabyEntityBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public BabyEntityBuilder sexe(ESexe sexe) {
			this.sexe = sexe;
			return this;
		}

		public BabyEntity build() {
			BabyEntity babyEntity = new BabyEntity();
			babyEntity.setId(id);
			babyEntity.setFirstName(firstName);
			babyEntity.setBirthDate(birthDate);
			babyEntity.setSexe(sexe);
			return babyEntity;
		}
	}
}
