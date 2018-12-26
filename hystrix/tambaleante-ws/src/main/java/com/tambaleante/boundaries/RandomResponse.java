package com.tambaleante.boundaries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RandomResponse {

    @GetMapping("/hello")
    public String hello() {
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            throw new RuntimeException("Vale shet la vida");
        }
        return "Holis";
    }
}