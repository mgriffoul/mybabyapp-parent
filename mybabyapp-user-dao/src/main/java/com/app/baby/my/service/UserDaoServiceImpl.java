package com.app.baby.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.app.baby.my.dao.IUserDao;
import com.app.baby.my.entity.User;
import com.app.baby.my.util.PasswordHasher;
import com.app.baby.my.util.PasswordSaltFactory;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */

public class UserDaoServiceImpl implements IUserDaoService {

	@Autowired
	private IUserDao userDao;

	private PasswordSaltFactory passwordSaltFactory;

	private PasswordHasher passwordHasher;

	public UserDaoServiceImpl(PasswordSaltFactory passwordSaltFactory, PasswordHasher passwordHasher) {
		this.passwordSaltFactory = passwordSaltFactory;
		this.passwordHasher = passwordHasher;
	}

	@Override
	public User createUser(String mail, String password) throws Exception{

		String salt = passwordSaltFactory.createSalt();
		String hashedPassword = passwordHasher.ashPassword(password, salt);

		User user = User.userBuilder().mail(mail).salt(salt).password(hashedPassword).build();
		userDao.insert(user);

		return user;
	}
}
