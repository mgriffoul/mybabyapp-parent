package com.app.baby.my.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.baby.my.dao.IUserDao;
import com.app.baby.my.entity.User;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
@Component
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao;

	@Override
	public void test() {
		System.out.println("test tuttaposto");
	}

	@Override
	public User createUser(String mail, String password) {
		return null;
	}
}
