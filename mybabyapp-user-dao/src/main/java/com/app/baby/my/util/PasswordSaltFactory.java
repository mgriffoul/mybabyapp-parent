package com.app.baby.my.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class PasswordSaltFactory {

	/**
	 * Fonction de création d'un sel sous forme de String à partir de la date heure système
	 * @return
	 */
	public String createSalt(){
		LocalDateTime l = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		return l.format(dtf);
	}

}
