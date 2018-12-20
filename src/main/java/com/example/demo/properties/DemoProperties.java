package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("demo")
public class DemoProperties {
    private String welcomeMessage = "Welcome to my Spring Boot demo!";

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
