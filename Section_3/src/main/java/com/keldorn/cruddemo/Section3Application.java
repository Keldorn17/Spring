package com.keldorn.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Section3Application {

    public static void main(String[] args) {
        SpringApplication.run(Section3Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
            System.out.println("Hello World");
        };
    }
}
