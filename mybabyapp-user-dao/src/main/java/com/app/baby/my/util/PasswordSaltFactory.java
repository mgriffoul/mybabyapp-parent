package com.app.baby.my.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class PasswordSaltFactory {

	public String createSalt(){
		LocalDateTime l = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		return l.format(dtf);
	}

}
