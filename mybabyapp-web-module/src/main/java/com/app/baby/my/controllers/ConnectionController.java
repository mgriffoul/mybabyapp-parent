package com.app.baby.my.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mathieu_griffoul on 28/10/2017.
 */
@Controller
@RequestMapping (value = "/connection")
public class ConnectionController {

	@RequestMapping(method = RequestMethod.GET)
	public String init() {
		return "connect";
	}

	@RequestMapping(value = "/echec", method = RequestMethod.POST)
	public String failedConnect(ModelMap model){
		model.addAttribute("failureMessage", "Identifiant ou mot de passe incorrect");
		return "connect";
	}

}
