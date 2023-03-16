package com.NeuralNexus.Group.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"main.java.com.NeuralNexus.Group.project.controller"})
public class NeuralNexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeuralNexusApplication.class, args);
    }

}