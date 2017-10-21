package com.app.baby.my.service.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by mathieu_griffoul on 21/10/2017.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages ="com.app.baby.my")
@EnableMongoRepositories(basePackages = "com.app.baby.my.dao")
public class AppliConfigTest {

	/*Classe nécessaire à la créatin d'un contexte d'application dans le scope Test*/

}
