package com.aloogn.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.aloogn.project")
public class MainWeb {
    public static void main(String[] args) {
        SpringApplication.run(MainWeb.class);
    }
}
