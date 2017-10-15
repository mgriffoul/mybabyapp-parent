package com.app.baby.my.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.app.baby.my.models.UserCreationModel;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
@Component
public class UserCreationValidator implements Validator {


	@Override
	public boolean supports(Class candidate) {
		return UserCreationModel.class.isAssignableFrom(candidate);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "required", "L'adresse mail est obligatoire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Vous n'avez pas rentrer votre mot de passe");
	}
}
