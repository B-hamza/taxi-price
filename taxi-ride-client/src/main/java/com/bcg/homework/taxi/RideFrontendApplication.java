package com.bcg.homework.taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bcg.homework.taxi"})
public class RideFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideFrontendApplication.class, args);
	}

}
