package com.app.baby.my.service;

import com.app.baby.my.entity.User;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public interface IUserDaoService {

	/**
	 * Méthode de création du User prenant en entrée mail et password.
	 * Le password est salé puis haché puis le user est envoyé au Dao
	 * @param mail
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User createUser(String mail, String password) throws Exception;

}
