package com.retry.boundaries;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyResource {

    @Retryable(
            value = RuntimeException.class,
            maxAttempts = 2,
            backoff = @Backoff(delay = 1000)
    )
    @GetMapping("/hello")
    public String hello() {

//        final long time = System.currentTimeMillis();
//        if (time % 2 == 0) {
//            throw new RuntimeException("even except ... ");
//        }
        long time = System.currentTimeMillis();
        time = 0;
        if (time == 0) {
            throw new RuntimeException("even except ... ");
        }

        return "hello";
    }

    @Recover
    public String helloRecover(final RuntimeException ex) {
        ex.printStackTrace();
        return "Hello with recover";
    }

}
