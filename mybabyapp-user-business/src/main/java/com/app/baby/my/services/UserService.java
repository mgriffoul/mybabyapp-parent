package com.app.baby.my.services;

import org.apache.commons.lang3.StringUtils;
import com.app.baby.my.dto.UserDto;
import com.app.baby.my.entity.User;
import com.app.baby.my.mapper.UserDtoMapper;
import com.app.baby.my.service.IUserDaoService;
import com.mongodb.MongoException;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public class UserService implements IUserService {


	private IUserDaoService userDaoService;

	private UserDtoMapper userDtoMapper;

	public UserService(IUserDaoService userDaoService, UserDtoMapper userDtoMapper) {
		this.userDaoService = userDaoService;
		this.userDtoMapper = userDtoMapper;
	}

	@Override
	public UserDto createUser(String mail, String password) throws Exception{
		if (StringUtils.isNotBlank(mail) && StringUtils.isNotBlank(password)){
			User user = userDaoService.createUser(mail, password);
			return userDtoMapper.mapUserEntityToUserDto(user);
		}else {
			throw  new MongoException("Le mail et le mot de passe ne peuvent pas être null, vide ou remplit d'espace.");
		}
	}
}
