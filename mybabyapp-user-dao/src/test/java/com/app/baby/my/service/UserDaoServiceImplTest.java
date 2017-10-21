package com.app.baby.my.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import com.app.baby.my.AppliConfigTest;
import com.app.baby.my.dao.IUserDao;
import com.app.baby.my.entity.User;
import com.app.baby.my.util.PasswordHasher;
import com.app.baby.my.util.PasswordSaltFactory;
import com.mongodb.MongoClientException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = AppliConfigTest.class)
public class UserDaoServiceImplTest {

	Logger logger = LoggerFactory.getLogger(UserDaoServiceImplTest.class);

	@InjectMocks
	private UserDaoServiceImpl userDaoService;

	@Mock
	private PasswordHasher passwordHasher;

	@Mock
	private PasswordSaltFactory passwordSaltFactory;

	@Mock
	private IUserDao userDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createUser_should_return_new_user_with_mail_salt_and_password() throws Exception {
		Mockito.when(passwordSaltFactory.createSalt()).thenReturn("salt");
		Mockito.when(passwordHasher.ashPassword(anyString(), anyString())).thenReturn("ashedPass");
		Mockito.when(userDao.insert(any(User.class))).thenReturn(new User());

		User user = userDaoService.createUser("aString", "otherString");

		Assert.assertNotNull(user);
		Assert.assertEquals("salt", user.getSalt());
		Assert.assertEquals("ashedPass", user.getPassword());
		Assert.assertEquals(user.getMail(), "aString");
		Assert.assertEquals(user.getPassword(), "ashedPass");
		Mockito.verify(userDao).insert(any(User.class));
		Mockito.verify(passwordHasher).ashPassword(anyString(), anyString());
		Mockito.verify(passwordSaltFactory).createSalt();

		logger.info("createUser_should_return_new_user_with_mail_salt_and_password passed with success");

	}

	@Test (expected = Exception.class)
	public void createUser_should_throw_exception_if_problem_occurs_while_hashing() throws Exception {
		Mockito.when(passwordSaltFactory.createSalt()).thenReturn("salt");
		Mockito.doThrow(Exception.class).when(passwordHasher.ashPassword(anyString(), anyString()));
		Mockito.when(userDao.insert(any(User.class))).thenReturn(new User());

		User user = userDaoService.createUser("aString", "otherString");

		logger.info("createUser_should_throw_exception_if_problem_occurs_while_hashing passed with success");

	}

	@Test(expected = MongoClientException.class)
	public void createUser_should_throw_MongoException_if_hashedPassword_is_empty() throws Exception {
		Mockito.when(passwordSaltFactory.createSalt()).thenReturn("salt");
		Mockito.when(passwordHasher.ashPassword(anyString(), anyString())).thenReturn("");
		User user = userDaoService.createUser(null, null);
	}

}
