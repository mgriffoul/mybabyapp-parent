package com.app.baby.my.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class PasswordSaltFactoryTest {

	@InjectMocks
	private PasswordSaltFactory passwordSaltFactory;

	@Test
	public void createSalt_should_return_string_when_called(){
		String salt = passwordSaltFactory.createSalt();
		Assert.assertNotNull(salt);
		Assert.assertTrue(salt.matches("[0-9]{1,}"));
	}

}
