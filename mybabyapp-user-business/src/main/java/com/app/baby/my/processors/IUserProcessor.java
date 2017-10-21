package com.app.baby.my.processors;

import com.app.baby.my.dto.UserDto;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public interface IUserProcessor {

	public UserDto createUserDto(String mail, String password);
}
