package com.springtraining.demos.springboot1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springtraining.demos.springboot1.entities.ShoppingCart;
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "com.springtraining.demos.springboot1.entities")

public class BeanConfig {

	@Bean
	public ShoppingCart cart() {
		return new ShoppingCart();
		
	}
	
}
