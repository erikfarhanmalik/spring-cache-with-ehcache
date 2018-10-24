package com.erik.learn.cachingwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingWithSpringApplication.class, args);
	}
}
