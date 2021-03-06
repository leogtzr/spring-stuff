package com.eureka.playing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaPlay1Application {
	public static void main(final String[] args) {
		SpringApplication.run(EurekaPlay1Application.class, args);
	}
}

