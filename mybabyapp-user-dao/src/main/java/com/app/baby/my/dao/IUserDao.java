package com.app.baby.my.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.app.baby.my.entitys.UserEntity;

/**
 * Created by mathieu_griffoul on 15/10/2017.
 */

public interface IUserDao extends MongoRepository <UserEntity, Integer> {
	public UserEntity findByMail(String Mail);
}


