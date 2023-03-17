package com.NeuralNexus.Group.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@AutoConfiguration
@ComponentScan(basePackages = "com.NeuralNexus.Group.project")

public class NeuralNexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeuralNexusApplication.class, args);
    }

}