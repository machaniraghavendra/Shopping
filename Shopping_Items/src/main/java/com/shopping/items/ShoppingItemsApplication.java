package com.shopping.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan(basePackages = "com.shopping.items.entity")
@SpringBootApplication
public class ShoppingItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingItemsApplication.class, args);
	}
}
