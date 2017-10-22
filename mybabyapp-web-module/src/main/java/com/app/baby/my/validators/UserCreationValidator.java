package com.app.baby.my.validators;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.app.baby.my.dto.UserDto;
import com.app.baby.my.models.UserCreationModel;
import com.app.baby.my.services.IUserService;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public class UserCreationValidator implements Validator {

	private IUserService userService;

	public UserCreationValidator(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class candidate) {
		return UserCreationModel.class.isAssignableFrom(candidate);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCreationModel model = (UserCreationModel) target;
		validateMail(model.getMail(), errors);
		validatePassword(model.getPassword(), model.getPasswordConfirm(), errors);
	}

	/**
	 * Validation de l'adresse mail
	 *
	 * @param mail
	 * @param errors
	 */
	private void validateMail(String mail, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "required", "L'adresse mail est obligatoire");

		//Vérification du format du mail
		EmailValidator emailValidator = EmailValidator.getInstance();
		if (!emailValidator.isValid(mail)) {
			errors.rejectValue("mail", "wrong format", "L'adresse mail que vous avez rentré est invalide");
		}

		//Vérification de l'existence du compte
		UserDto userDto = userService.finUserByMail(mail);
		if (userDto.getMail() != null) {
			errors.rejectValue("mail", "already exists", "Cette adresse mail est déjà rattachée à un compte.");
		}
	}

	/**
	 * Validation du mot de passe
	 * @param password
	 * @param errors
	 */
	private void validatePassword(String password, String passwordConfirm, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Vous n'avez pas rentré de mot de passe");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "required", "Veuillez confirmer votre mot de passe");

		if(password == null || !password.matches("^.{6,}$")){
			errors.rejectValue("password", "lenght issue", "Votre mot de passe doit faire au moins 6 caractères");
		}

		if(!StringUtils.equals(password, passwordConfirm)){
			errors.rejectValue("password", "dont matches", "Vous avez tappé deux mots de passe différents.");
		}
	}




}
