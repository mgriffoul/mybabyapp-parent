package com.app.baby.my.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * Created by mathieu_griffoul on 28/10/2017.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/resources/**", "/sign-up/**", "/connect/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/connect")
				.loginProcessingUrl("/login")
				.successForwardUrl("/home")
				.failureForwardUrl("/connect/failed").permitAll()
				.and()
				.httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

	//	@Bean
	//	private ViewResolver viewResolver() {
	//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	//		viewResolver.setPrefix("/WEB-INF/jsp/");
	//		viewResolver.setSuffix(".jsp");
	//		return viewResolver;
	//	}

}
