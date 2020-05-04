package com.example.demospringsecuritydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringSecurityApplication.class, args);
	}

}
