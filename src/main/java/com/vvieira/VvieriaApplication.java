package com.vvieira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class VvieriaApplication {
	public static void main(String[] args) {
		SpringApplication.run(VvieriaApplication.class, args);
	}
}
