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

	/**
	 * Methode de création d'un user
	 * @param userCreationModel
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = ("signupuser"))
	public String signUpUser(@ModelAttribute("userCreationModel") UserCreationModel userCreationModel, BindingResult result, ModelMap model) {

		creationValidator.validate(userCreationModel, result);

		if (result.hasErrors()) {
			logger.error("Binding result found errors");
			model.addAttribute("message", "erreur");
		} else {
			try {
				model.put("user", userService.createUser(userCreationModel.getMail(), userCreationModel.getPassword()));
				model.addAttribute("message", "tuttaposto !!");
				return "confirm";
			} catch(Exception e) {
				logger.error("La création du compte a échoué.");
				model.addAttribute("message", "Mongo erreur");
			}
		}

		return "sign-up";
	}

}
