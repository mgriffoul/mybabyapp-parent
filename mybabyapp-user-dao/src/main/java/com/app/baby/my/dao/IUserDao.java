package com.app.baby.my.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.app.baby.my.entity.User;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */

public interface IUserDao extends MongoRepository <User, Integer> {
	public User findByMail(String Mail);
}


