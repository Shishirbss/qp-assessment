package com.grocerybooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *To have Api security by API kay and value
 *uncoment line-13 and coment line-15, add spring security dependency to pom.xml
 *and uncoment class in com.grocerybooking.securityconfig
 *Use Key: G-API-KEY , vALUE: grocerybooking while calling endpoints
 **/

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})

@SpringBootApplication
public class GroceryBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryBookingApiApplication.class, args);
	}

}
