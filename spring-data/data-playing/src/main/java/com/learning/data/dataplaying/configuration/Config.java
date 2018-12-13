package com.learning.data.dataplaying.configuration;

import com.learning.data.dataplaying.domain.Country;
import com.learning.data.dataplaying.repository.CountryRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public InitializingBean populateDatabase(final CountryRepository repository) {
        return () -> {
            repository.save(new Country(1, "USA"));
            repository.save(new Country(2, "MX"));
        };
    }

    @Bean
    public CommandLineRunner queryDatabase(final CountryRepository repository) {
        return args -> {
            repository.findAll().forEach(System.out::println);
        };
    }

}
