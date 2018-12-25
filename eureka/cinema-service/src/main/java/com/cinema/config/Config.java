package com.cinema.config;

import com.cinema.domain.Cinema;
import com.cinema.persistence.CinemaRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public InitializingBean populateDatabase(final CinemaRepository repository) {
        return () -> {
            repository.save(new Cinema(1, "Alamo", null));
            repository.save(new Cinema(2, "4DX", null));
        };
    }


}
