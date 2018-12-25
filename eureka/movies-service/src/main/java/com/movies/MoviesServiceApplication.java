package com.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MoviesServiceApplication {
	public static void main(final String[] args) {
		SpringApplication.run(MoviesServiceApplication.class, args);
	}
}

