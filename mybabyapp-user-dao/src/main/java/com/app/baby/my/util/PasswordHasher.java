package com.app.baby.my.util;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class PasswordHasher {

	/**
	 * Fonction de hashage d"un mot de passe et d'un sel.
	 * @param password
	 * @param salt
	 * @return
	 * @throws Exception
	 */
	public String ashPassword(String password, String salt) {
		if(password != null && salt != null){
			StringBuilder sb = new StringBuilder();
			try {
				sb.append(hashString(password));
				sb.append(hashString(salt));
				return hashString(sb.toString());
			} catch(Exception e) {
				e.printStackTrace();
				return "";
			}
		}else {
			return "";
		}
	}

	/**
	 * Fonction de hashage en SHA-256
	 * @param s
	 * @return
	 * @throws Exception
	 */
	private String hashString(String s) throws Exception{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(s.getBytes("UTF-8"));
		return DatatypeConverter.printHexBinary(hash);
	}

}
