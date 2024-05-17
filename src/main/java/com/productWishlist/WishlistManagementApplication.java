package com.productWishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WishlistManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishlistManagementApplication.class, args);
		System.out.println("Management application");
	}

}
