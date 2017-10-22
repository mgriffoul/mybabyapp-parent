package com.app.baby.my.validators;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import com.app.baby.my.dto.UserDto;
import com.app.baby.my.models.UserCreationModel;
import com.app.baby.my.services.UserService;

import static org.mockito.Matchers.anyString;

/**
 * Created by mathieu_griffoul on 22/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserCreationValidatorTest {

	@InjectMocks
	private UserCreationValidator validator;

	@Mock
	private UserService userService;

	@Test
	public void validate_should_return_empty_errors_object_if_rules_are_ok() throws Exception {
		Mockito.when(userService.finUserByMail(anyString())).thenReturn(UserDto.userDtoBuilder().build());
		UserCreationModel userCreationModel = UserCreationModel.userCreationModelBuilder().mail("toto@toto.com").password("123456").passwordConfirm("123456").build();
		Errors errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);

		Assert.assertFalse(errors.hasErrors());

	}

	@Test
	public void validate_should_return_error_when_mail_doesnt_match() throws Exception {
		Mockito.when(userService.finUserByMail(anyString())).thenReturn(UserDto.userDtoBuilder().build());

		UserCreationModel userCreationModel = UserCreationModel.userCreationModelBuilder().mail("totototo.com").password("123456").passwordConfirm("123456").build();
		Errors errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));

		userCreationModel.setMail("htfgfrds@fgmail");
		errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));

		userCreationModel.setMail("12143@fgmail.124");
		errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));

		userCreationModel.setMail("121*43@fgmail.124");
		errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));

	}

	@Test
	public void validate_should_return_error_when_user_service_return_a_user_with_not_empty_mail() throws Exception {
		Mockito.when(userService.finUserByMail(anyString())).thenReturn(UserDto.userDtoBuilder().mail("aMail").build());
		UserCreationModel userCreationModel = UserCreationModel.userCreationModelBuilder().mail("toto@toto.com").password("123456").passwordConfirm("123456").build();
		Errors errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));
	}

	@Test
	public void validate_should_return_error_when_mail_is_empty_or_white_space() throws Exception {

		Mockito.when(userService.finUserByMail(anyString())).thenReturn(UserDto.userDtoBuilder().build());
		UserCreationModel userCreationModel = UserCreationModel.userCreationModelBuilder().mail("").password("123456").passwordConfirm("123456").build();
		Errors errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));

		userCreationModel.setMail("    ");
		errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));

		userCreationModel.setMail(null);
		errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("mail"));

	}

	@Test
	public void validate_should_return_error_when_password_is_empty_or_white_space() throws Exception {

		Mockito.when(userService.finUserByMail(anyString())).thenReturn(UserDto.userDtoBuilder().build());
		UserCreationModel userCreationModel = UserCreationModel.userCreationModelBuilder().mail("sdfgs@gri.com").password("").passwordConfirm("").build();
		Errors errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("password"));

		userCreationModel.setPassword(null);
		userCreationModel.setPasswordConfirm(null);
		errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("password"));

		userCreationModel.setPassword("   ");
		userCreationModel.setPasswordConfirm("   ");
		errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("password"));

	}

	@Test
	public void validate_should_return_error_when_password_is_less_than_6_characters() throws Exception {
		Mockito.when(userService.finUserByMail(anyString())).thenReturn(UserDto.userDtoBuilder().build());
		UserCreationModel userCreationModel = UserCreationModel.userCreationModelBuilder().mail("sdfgs@gri.com").password("12345").passwordConfirm("12345").build();
		Errors errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("password"));
	}

	@Test
	public void validate_should_return_error_when_password_doesnt_match_passwordConfirm() throws Exception {
		Mockito.when(userService.finUserByMail(anyString())).thenReturn(UserDto.userDtoBuilder().build());
		UserCreationModel userCreationModel = UserCreationModel.userCreationModelBuilder().mail("sdfgs@gri.com").password("1234567").passwordConfirm("7654321").build();
		Errors errors = new BeanPropertyBindingResult(userCreationModel, "userCreationModel");
		validator.validate(userCreationModel, errors);
		Assert.assertTrue(errors.hasErrors());
		Assert.assertTrue(errors.hasFieldErrors("password"));
	}

}
