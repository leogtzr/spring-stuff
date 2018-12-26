package com.hystrix.client.boundaries;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Greeting {

    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String getGreeting() {
        return new RestTemplate()
                .getForObject("http://localhost:8090/hello", String.class);
    }

    private String defaultGreeting() {
        return "default greeting";
    }

}
