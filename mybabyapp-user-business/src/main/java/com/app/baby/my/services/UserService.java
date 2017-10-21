package com.app.baby.my.services;

import com.app.baby.my.dto.UserDto;
import com.app.baby.my.entity.User;
import com.app.baby.my.mapper.UserDtoMapper;
import com.app.baby.my.processors.IUserProcessor;
import com.app.baby.my.service.IUserDaoService;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public class UserService implements IUserService {

	private IUserProcessor userProcessor;

	private IUserDaoService userDaoService;

	private UserDtoMapper userDtoMapper;

	public UserService(IUserProcessor userProcessor, IUserDaoService userDaoService, UserDtoMapper userDtoMapper) {
		this.userProcessor = userProcessor;
		this.userDaoService = userDaoService;
		this.userDtoMapper = userDtoMapper;
	}

	@Override
	public UserDto createUser(String mail, String password) throws Exception{
		User user = userDaoService.createUser(mail, password);
		return userDtoMapper.mapUserEntityToUserDto(user);
	}
}
