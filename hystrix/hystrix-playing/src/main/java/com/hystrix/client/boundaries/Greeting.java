package com.hystrix.client.boundaries;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(
        name = "some-shit",
        url = "http://localhost:8090/hello",
        fallback = 
)
public class Greeting {
}
