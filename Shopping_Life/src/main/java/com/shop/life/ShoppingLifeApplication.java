package com.shop.life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.shop.life.entity")
@EnableJpaRepositories("com.shop.life.repo")
public class ShoppingLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingLifeApplication.class, args);
	}

}
