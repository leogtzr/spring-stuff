package com.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
public class HystrixPlayingApplication {
	public static void main(final String[] args) {
		SpringApplication.run(HystrixPlayingApplication.class, args);
	}
}

