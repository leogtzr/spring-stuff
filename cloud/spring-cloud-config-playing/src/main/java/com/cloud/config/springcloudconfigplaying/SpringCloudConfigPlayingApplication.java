package com.cloud.config.springcloudconfigplaying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigPlayingApplication {
	public static void main(final String[] args) {
		SpringApplication.run(SpringCloudConfigPlayingApplication.class, args);
	}
}
