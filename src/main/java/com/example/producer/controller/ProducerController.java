package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ProducerController {

    @Autowired
    Environment environment;

    @Value("${text.message}")
    String textMessage;

    @GetMapping("/producer")
    public String getData(){
        return " Hello from producer :"+environment.getProperty("server.port");
    }

    @GetMapping("/config")
    public String getConfigData(){
        return " Configuration message :"+textMessage;
    }
}
