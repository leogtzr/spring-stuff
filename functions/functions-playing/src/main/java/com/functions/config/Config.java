package com.functions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Config {

    @Bean
    /*
        curl --noproxy "*" http://localhost:8080/reverseString -H "Content-Type: text/plain" -d "Leonardo"
     */
    public Function<String, String> reverseString() {
        return value -> new StringBuilder(value).reverse().toString();
    }

}
