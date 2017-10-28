package com.app.baby.my.service;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.baby.my.dao.IUserDao;
import com.app.baby.my.entity.User;
import com.app.baby.my.util.PasswordHasher;
import com.app.baby.my.util.PasswordSaltFactory;
import com.mongodb.MongoClientException;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
public class UserDaoServiceImpl implements IUserDaoService {

	Logger logger = LoggerFactory.getLogger(UserDaoServiceImpl.class);

	@Autowired
	private IUserDao userDao;

	private PasswordSaltFactory passwordSaltFactory;

	private PasswordHasher passwordHasher;

	public UserDaoServiceImpl(PasswordSaltFactory passwordSaltFactory, PasswordHasher passwordHasher) {
		this.passwordSaltFactory = passwordSaltFactory;
		this.passwordHasher = passwordHasher;
	}


	/**
	 * Méthode de création du User prenant en entrée mail et password.
	 * Le password est salé puis haché puis le user est envoyé au Dao
	 *
	 * @param mail
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Override
	public User createUser(String mail, String password) {
		String salt = passwordSaltFactory.createSalt();
		String hashedPassword = passwordHasher.ashPassword(password, salt);
		User user = User.userBuilder().mail(mail).salt(salt).password(hashedPassword).build();
		if(StringUtils.isNotEmpty(hashedPassword)){
			userDao.insert(user);
		}else{
			logger.error("Echec de l'insertion de l'utilisateur en base, le hashage du mot de passe a rencontré un problème");
			throw new MongoClientException("Echec de l'insertion de l'utilisateur en base, le hashage du mot de passe a rencontré un problème");
		}
		return user;
	}

	/**
	 * Méthode de recherche d'un utilisateur par son adresse mail
	 * @param mail
	 * @return
	 */
	@Override
	public User findUserByMail(String mail) {
		return userDao.findByMail(mail);
	}

	/**
	 *  Cette méthode sert à checker si un mot de passe et un sel sont bien egaux une fois hashé à un mot de pass sous forme de hash
	 *  retourne true si oui, false si non
	 * @param passwordToCompare
	 * @param hashedPasswordToCompare
	 * @param salt
	 * @return
	 */
	@Override
	public boolean checkPasswordIsOk(String passwordToCompare, String hashedPasswordToCompare, String salt) {
		String passwordToCheck = passwordHasher.ashPassword(passwordToCompare, salt);

		if(StringUtils.equals(passwordToCheck, hashedPasswordToCompare)){
			return true;
		}else {
			return false;
		}

	}
}
