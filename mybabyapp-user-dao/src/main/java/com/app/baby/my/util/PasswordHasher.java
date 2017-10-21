package com.app.baby.my.util;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class PasswordHasher {

	public String ashPassword(String password, String salt) throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append(hashString(password));
		sb.append(hashString(salt));
		return hashString(sb.toString());
	}

	private String hashString(String s) throws Exception{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(s.getBytes("UTF-8"));
		return DatatypeConverter.printHexBinary(hash);
	}

}
