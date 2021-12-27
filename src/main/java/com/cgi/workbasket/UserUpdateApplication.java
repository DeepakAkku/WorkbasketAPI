package com.cgi.workbasket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class UserUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserUpdateApplication.class, args);
	}

}
