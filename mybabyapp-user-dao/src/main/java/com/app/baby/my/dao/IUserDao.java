package com.app.baby.my.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */
public interface IUserDao extends MongoRepository <String, String> {
//	public User findByMail(String Mail);
}
