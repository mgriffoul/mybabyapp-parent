package com.app.baby.my.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.app.baby.my.models.UserCreationModel;
import com.app.baby.my.services.IUserService;
import com.app.baby.my.validators.UserCreationValidator;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
@Controller
@RequestMapping(value = ("/sign-up"))
public class UserCreationController {

	@Autowired
	private UserCreationValidator creationValidator;

	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String init(ModelMap model, @ModelAttribute UserCreationModel userCreationModel) {
		model.addAttribute("userCreationModel", userCreationModel);
		return "sign-up";
	}

	@RequestMapping(method = RequestMethod.POST, value = ("signupuser"))
	public String signUpUser(@ModelAttribute("userCreationModel") UserCreationModel userCreationModel, BindingResult result, ModelMap model) {

		creationValidator.validate(userCreationModel, result);

		if (result.hasErrors()) {
			model.addAttribute("message", "erreur");
		} else {

			model.addAttribute("message", "tuttaposto !!");
			model.addAttribute("user", userService.createUser(userCreationModel.getMail(), userCreationModel.getPassword()));
		}

		return "hello-world";
	}

}
