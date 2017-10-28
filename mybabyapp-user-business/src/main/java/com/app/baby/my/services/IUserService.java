package com.app.baby.my.services;

import com.app.baby.my.dto.UserDto;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public interface IUserService {

	public UserDto createUser(String mail, String password) throws Exception;

	public UserDto finUserByMail(String mail);

	public boolean checkPasswordOk(String passwordToCompare, String hashedPasswordToCompare, String salt);

}
