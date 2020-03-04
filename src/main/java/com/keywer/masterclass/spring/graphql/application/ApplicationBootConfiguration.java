package com.keywer.masterclass.spring.graphql.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.keywer.masterclass.spring.graphql")
public class ApplicationBootConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootConfiguration.class, args);
    }
}
