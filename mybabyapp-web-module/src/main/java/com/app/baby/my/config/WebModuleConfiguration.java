package com.app.baby.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.app.baby.my.services.IUserService;
import com.app.baby.my.validators.UserCreationValidator;

/**
 * Created by mathieu_griffoul on 22/10/2017.
 */
@Configuration
public class WebModuleConfiguration {

	@Bean
	public UserCreationValidator userCreationValidator(IUserService userService){
		return new UserCreationValidator(userService);
	}


}
