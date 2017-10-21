package com.app.baby.my.service;

import com.app.baby.my.entity.User;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public interface IUserDaoService {

	public User createUser(String mail, String password) throws Exception;

}
