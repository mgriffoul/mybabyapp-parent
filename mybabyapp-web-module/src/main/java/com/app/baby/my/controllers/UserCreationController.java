package com.app.baby.my.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.mongodb.MongoException;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
@Controller
@RequestMapping(value = ("/sign-up"))
public class UserCreationController {

	Logger logger = LoggerFactory.getLogger(UserCreationController.class);

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
			try {
				model.put("user", userService.createUser(userCreationModel.getMail(), userCreationModel.getPassword()));
				model.addAttribute("message", "tuttaposto !!");
				return "confirm";
			} catch(MongoException m) {
				logger.error("La création du compte a échoué. Mongo Exception.");
				model.addAttribute("message", "Mongo erreur");
			} catch(java.lang.Exception jl) {
				logger.error("La création du compte a échoué. Mongo Exception.");
				jl.printStackTrace();
			}

		}

		return "hello-world";
	}

}
