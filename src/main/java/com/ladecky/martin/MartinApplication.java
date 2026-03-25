package com.ladecky.martin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ladecky.martin")
public class MartinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MartinApplication.class, args);
	}

}
