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
public class PasswordHasherTest {

	@InjectMocks
	private PasswordHasher passwordHasher;

	@Test
	public void ashPassword_should_return_proper_hashed_string_when_call_with_string_and_salt() throws Exception{
		String hashed = passwordHasher.ashPassword("salt", "password");
		Assert.assertEquals("DB5E8ED31B7EC5C837394ED93A36C973B1758C94C9BBDE628A18CB906E5760FD", hashed);
	}

	@Test
	public void ashPassword_should_return_empty_string_if_mail_and_password_are_null() throws Exception {
		String hashed = passwordHasher.ashPassword(null, null);
		Assert.assertNotNull(hashed);
		Assert.assertEquals(hashed, "");
	}

	@Test
	public void ashPassword_should_return_empty_string_if_mail_is_null() throws Exception {
		String hashed = passwordHasher.ashPassword(null, "password");
		Assert.assertNotNull(hashed);
		Assert.assertEquals(hashed, "");
	}

	@Test
	public void ashPassword_should_return_empty_string_if_password_is_null() throws Exception {
		String hashed = passwordHasher.ashPassword("mail", null);
		Assert.assertNotNull(hashed);
		Assert.assertEquals(hashed, "");
	}

}
