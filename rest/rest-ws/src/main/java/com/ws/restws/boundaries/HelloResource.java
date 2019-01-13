package com.ws.restws.boundaries;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class HelloResource {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
