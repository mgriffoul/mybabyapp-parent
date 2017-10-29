package com.app.baby.my.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.baby.my.dto.UserDto;
import com.app.baby.my.models.MoreUserInfosModel;

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
			return ("forward:/home/moreinfoform");
		}

		return "home";
	}

	@RequestMapping(value = "/moreinfoform")
	public String moreUserInfos(@ModelAttribute MoreUserInfosModel moreUserInfosModel, ModelMap model) {
		model.addAttribute("userInformationsModel", moreUserInfosModel);
		return "sign-up-step-2";
	}

}
