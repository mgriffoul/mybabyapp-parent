package com.app.baby.my.processors;

import com.app.baby.my.dto.UserDto;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public class UserProcessor implements IUserProcessor{

	public UserProcessor() {
	}

	@Override
	public UserDto createUserDto(String mail, String password) {
		return UserDto.userDtoBuilder().mail(mail).password(password).build();
	}

}
