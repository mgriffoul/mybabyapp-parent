package com.app.baby.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.app.baby.my.service.IUserDaoService;
import com.app.baby.my.service.UserDaoServiceImpl;
import com.app.baby.my.util.PasswordHasher;
import com.app.baby.my.util.PasswordSaltFactory;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
@Configuration
public class UserDaoModuleConfiguration {


	@Bean
	public IUserDaoService daoService(PasswordSaltFactory passwordSaltFactory, PasswordHasher passwordHasher){
		return new UserDaoServiceImpl(passwordSaltFactory, passwordHasher);
	}

	@Bean
	public PasswordSaltFactory passwordSalter(){
		return new PasswordSaltFactory();
	}

	@Bean
	public PasswordHasher passwordHasher(){
		return new PasswordHasher();
	}

}
