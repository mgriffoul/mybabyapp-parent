package com.app.baby.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.app.baby.my.mapper.UserDtoMapper;
import com.app.baby.my.processors.IUserProcessor;
import com.app.baby.my.processors.UserProcessor;
import com.app.baby.my.service.IUserDaoService;
import com.app.baby.my.services.IUserService;
import com.app.baby.my.services.UserService;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
@Configuration
public class UserBusinessConfiguration {

	@Bean
	public IUserService userService(IUserDaoService userDaoService, UserDtoMapper userDtoMapper) {
		return new UserService(userDaoService, userDtoMapper);
	}

	@Bean
	public IUserProcessor userProcessor(){
		return new UserProcessor();
	}

	@Bean
	public UserDtoMapper userDtoMapper(){
		return new UserDtoMapper();
	}

}
