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

	/**
	 * Méthode de recherche d'un utilisateur par son adresse email
	 * @param mail
	 * @return
	 */
	public User findUserByMail(String mail);


	/**
	 * Cette méthode sert à checker si un mot de passe et un sel sont bien egaux une fois hashé à un mot de pass sous forme de hash
	 * @param passwordToCompare
	 * @param hashedPasswordToCompare
	 * @param salt
	 * @return
	 */
	public boolean checkPasswordIsOk (String passwordToCompare, String hashedPasswordToCompare, String salt);

}
