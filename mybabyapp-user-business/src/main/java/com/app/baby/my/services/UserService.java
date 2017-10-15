package com.app.baby.my.services;

import org.springframework.stereotype.Component;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
@Component
public class UserService implements IUserService{

	@Override
	public void test() {
		System.out.println("test tuttaposto");
	}
}
