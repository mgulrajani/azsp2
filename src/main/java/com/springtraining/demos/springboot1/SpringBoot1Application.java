package com.springtraining.demos.springboot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.springtraining.demos.springboot1.entities.ShoppingCart;
import com.springtraining.demos.springboot1.repo.IBookMongoRepo;
@EnableMongoRepositories(basePackageClasses = IBookMongoRepo.class)
@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,value=IBookMongoRepo.class))
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBoot1Application {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	
		/*
		 * ApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(BeanConfig.class);
		 * 
		 * ShoppingCart cart = ctx.getBean(ShoppingCart.class);
		 * 
		 * cart.checkOut();
		 * 
		 */
	}

}
