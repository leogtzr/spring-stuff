package com.movies.config;

import com.movies.domain.Movie;
import com.movies.persistence.MovieRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public InitializingBean populateDatabase(final MovieRepository movieRepository) {
        return () -> {
            movieRepository.save(new Movie(1, "Matrix"));
            movieRepository.save(new Movie(2, "The Simpsons Movie"));
            movieRepository.save(new Movie(3, "Pirates of the Caribbean"));
        };
    }


}
