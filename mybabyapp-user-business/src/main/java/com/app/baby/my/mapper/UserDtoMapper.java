package com.app.baby.my.mapper;

import com.app.baby.my.dto.UserDto;
import com.app.baby.my.entity.User;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class UserDtoMapper {

	public UserDto mapUserEntityToUserDto(User userEntity){

		UserDto userDto = new UserDto();

		userDto.setMail(userEntity.getMail());

		return userDto;
	}


}
