package com.app.baby.my.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.app.baby.my.dto.UserDto;
import com.app.baby.my.entitys.UserEntity;
import com.app.baby.my.mapper.UserDtoMapper;
import com.app.baby.my.service.UserDaoServiceImpl;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by mathieu_griffoul on 22/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserDaoServiceImpl userDaoService;

	@Mock
	private UserDtoMapper userDtoMapper;

	@Test
	public void createUser_should_return_UserDto_when_called_with_string_string() throws Exception {
		given(userDaoService.createUser(anyString(), anyString()))
				.willReturn(UserEntity.userEntityBuilder().build());
		given(userDtoMapper.mapUserEntityToUserDto(any(UserEntity.class))).willReturn(UserDto.userDtoBuilder().build());

		UserDto userDto = userService.createUser("mail","pass");

		Mockito.verify(userDtoMapper).mapUserEntityToUserDto(any(UserEntity.class));
		Mockito.verify(userDaoService).createUser(anyString(), anyString());
		Assert.assertNotNull(userDto);

	}

	@Test (expected = MongoClientException.class)
	public void createUser_should_throw_MongoClientException_if_dao_throws_one() throws Exception {
		when(userDaoService.createUser(anyString(),anyString())).thenThrow(MongoClientException.class);
		UserDto userDto = userService.createUser("mail","pass");
	}

	@Test(expected = MongoException.class)
	public void createUser_should_throw_MongoException_if_mail_is_null() throws Exception{
		UserDto userDto = userService.createUser(null,"pass");
	}

	@Test(expected = MongoException.class)
	public void createUser_should_throw_MongoException_if_mail_is_empty() throws Exception{
		UserDto userDto = userService.createUser("","pass");
	}

	@Test(expected = MongoException.class)
	public void createUser_should_throw_MongoException_if_mail_is_only_white_space_composed() throws Exception{
		UserDto userDto = userService.createUser("      ","pass");
	}

	@Test(expected = MongoException.class)
	public void createUser_should_throw_MongoException_if_password_is_null() throws Exception{
		UserDto userDto = userService.createUser("mail",null);
	}

	@Test(expected = MongoException.class)
	public void createUser_should_throw_MongoException_if_password_is_empty() throws Exception{
		UserDto userDto = userService.createUser("mail","");
	}

	@Test(expected = MongoException.class)
	public void createUser_should_throw_MongoException_if_password_is_only_white_space_composed() throws Exception{
		UserDto userDto = userService.createUser("mail","        ");
	}

	@Test
	public void checkPasswordOk_should_call_userServiceDao_and_return_true_if_userServiceDao_Does() throws Exception {
		given(userDaoService.checkPasswordIsOk(anyString(), anyString(), anyString())).willReturn(true);

		boolean b = userDaoService.checkPasswordIsOk("password1", "ashedPass", "sel");

		Mockito.verify(userDaoService, times(1)).checkPasswordIsOk(anyString(), anyString(), anyString());
		Assert.assertTrue(b);
	}

	@Test
	public void checkPasswordOk_should_call_userServiceDao_and_return_false_if_userServiceDao_Does() throws Exception {
		given(userDaoService.checkPasswordIsOk(anyString(), anyString(), anyString())).willReturn(false);

		boolean b = userDaoService.checkPasswordIsOk("password1", "ashedPass", "sel");

		Mockito.verify(userDaoService, times(1)).checkPasswordIsOk(anyString(), anyString(), anyString());
		Assert.assertFalse(b);
	}

}
