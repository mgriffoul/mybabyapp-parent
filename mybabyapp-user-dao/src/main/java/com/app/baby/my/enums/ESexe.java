package com.app.baby.my.enums;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public enum ESexe {

	HOMME("m"),FEMME("f");

	private String code;

	ESexe(String code) {
		this.code = code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
