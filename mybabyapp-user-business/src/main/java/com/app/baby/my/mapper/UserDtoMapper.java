package com.app.baby.my.mapper;

import com.app.baby.my.dto.UserDto;
import com.app.baby.my.entitys.UserEntity;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class UserDtoMapper {

	/**
	 * Fonction de mapping d'un User (entity) en UserDto
	 * @param userEntity
	 * @return
	 */
	public UserDto mapUserEntityToUserDto(UserEntity userEntity){

		UserDto userDto = new UserDto();

		if(userEntity != null) {
			if(userEntity.getMail()!=null) {
				userDto.setMail(userEntity.getMail());
			}
			if(userEntity.getPassword()!=null){
				userDto.setPassword(userEntity.getPassword());
			}
			if(userEntity.getSalt()!=null){
				userDto.setSalt(userEntity.getSalt());
			}
		}

		return userDto;
	}


}
