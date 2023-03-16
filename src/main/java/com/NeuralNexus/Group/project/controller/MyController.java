package main.java.com.NeuralNexus.Group.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String example() {
        return "signup.html";
    }
}
