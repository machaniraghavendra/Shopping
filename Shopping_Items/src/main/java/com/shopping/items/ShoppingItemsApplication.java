package com.shopping.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.shopping.items.entity")
@SpringBootApplication
public class ShoppingItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingItemsApplication.class, args);
	}
}
