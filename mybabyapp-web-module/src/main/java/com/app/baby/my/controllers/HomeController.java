package com.app.baby.my.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mathieu_griffoul on 28/10/2017.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@RequestMapping
	public String init(ModelMap model, Authentication authentication) {

		model.addAttribute("userLogin", authentication.getName());
		return "home";
	}

	@RequestMapping(value = "/more")
	public String more(ModelMap model) {


		return "home";
	}

}
