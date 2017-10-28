package com.app.baby.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@SpringBootApplication
public class MybabyappWebModuleApplication extends AbstractMongoConfiguration{



	public static void main(String[] args) {
		SpringApplication.run(MybabyappWebModuleApplication.class, args);
	}

	@Override
	protected String getDatabaseName() {
		return "babyappdb";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost", 27017);
	}
}
