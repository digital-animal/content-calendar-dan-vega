package com.zahid.home.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${cc.welcomeMessage:Default Welcome Message}")
    private String welcomeMessage;

    @Value("${cc.about}")
    private String about;

    @GetMapping("/")
    public String home() {
        return welcomeMessage;
    }

    @GetMapping("/about")
    public Map<String, String> about() {
        return Map.of(
                "welcomeMessage", welcomeMessage,
                "about", about);

    }

}
