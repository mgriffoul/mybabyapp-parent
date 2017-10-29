package com.app.baby.my.config.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import com.app.baby.my.dto.UserDto;
import com.app.baby.my.services.IUserService;

/**
 * Created by mathieu_griffoul on 28/10/2017.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	private IUserService userService;

	/**
	 * fournit la methode d'authentifacation par défaut
	 * Le Principal du spring security context contient un UserDto
	 * @param authentication
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName();
		Object credentials = authentication.getCredentials();

		if(!(credentials instanceof String)){
			return null;
		}

		String password = credentials.toString();

		UserDto userDto = userService.finUserByMail(name);

		if(userDto == null){
			logger.error("Echec de l'authentification ");
			throw new BadCredentialsException("L'authentification a échoué.");
		}

		if(userService.checkPasswordOk(password, userDto.getPassword(), userDto.getSalt())){
			List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
			grantedAuthorityList.add(new SimpleGrantedAuthority("user"));

			logger.info("Authentification réalisée avec succès");

			return new UsernamePasswordAuthenticationToken(userDto, userDto.getPassword(), grantedAuthorityList);
		}else {
			logger.error("Echec de l'authentification ");
			throw new BadCredentialsException("L'authentification a échoué.");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
