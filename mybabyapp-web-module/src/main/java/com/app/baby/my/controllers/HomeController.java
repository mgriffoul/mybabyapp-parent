package com.app.baby.my.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.baby.my.dto.UserDto;

/**
 * Created by mathieu_griffoul on 28/10/2017.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@RequestMapping
	public String init(ModelMap model, Authentication authentication) {
		UserDto user = (UserDto) authentication.getPrincipal();
		model.addAttribute("userLogin", user.getMail());


		if (!user.isAllSignUpInfoGiven()) {
			return ("forward:/inscription/vosinformations");
		}

		return "home";
	}



}
