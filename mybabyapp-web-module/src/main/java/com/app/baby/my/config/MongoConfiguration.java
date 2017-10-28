package com.app.baby.my.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Created by mathieu_griffoul on 28/10/2017.
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "babyappdb";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost", 27017);
	}


}
