package com.cloud.client.configurationclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController("/api")
public class MessageRestController {

    @Value("${message:Hello from default}")
    private String message;

    @GetMapping("message")
    public String message() {
        return this.message;
    }

}
