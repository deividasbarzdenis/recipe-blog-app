package com.debarz.recipeblogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class RecipeBlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeBlogAppApplication.class, args);
    }

}
