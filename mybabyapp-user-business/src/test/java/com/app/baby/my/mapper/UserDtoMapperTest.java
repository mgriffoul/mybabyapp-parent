package com.app.baby.my.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.app.baby.my.dto.UserDto;
import com.app.baby.my.entity.User;

/**
 * Created by mathieu_griffoul on 22/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDtoMapperTest {

	Logger logger = LoggerFactory.getLogger(UserDtoMapperTest.class);

	@InjectMocks
	private UserDtoMapper userDtoMapper;

	@Test
	public void mapUserEntityToUserDto_should_return_set_UserDto_when_called_with_User() throws Exception {
		User user = User.userBuilder().mail("mail").build();
		UserDto userDto = userDtoMapper.mapUserEntityToUserDto(user);

		Assert.assertEquals(userDto.getMail(), "mail");
		Assert.assertNotNull(userDto);

		logger.info("mapUserEntityToUserDto_should_return_set_UserDto_when_called_with_User passed with success");

	}

	@Test
	public void mapUserEntityToUserDto_should_return_empty_UserDto_if_called_with_null_User(){
		UserDto userDto = userDtoMapper.mapUserEntityToUserDto(null);
		Assert.assertNotNull(userDto);
	}
}
