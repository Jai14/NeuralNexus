package com.NeuralNexus.Group.project.controller;



import com.NeuralNexus.Group.project.entity.User;
import com.NeuralNexus.Group.project.repo.UserRepository;
import com.NeuralNexus.Group.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MySignUpController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;



    @GetMapping("/login")
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password, Model model , HttpSession session) {


        if (userRepository.exists(Example.of(new User(email, User.hashString(password))))) {
            User user = new User(email, password);
            session.setAttribute("user", user);
            return "main.html";
        } else {
            model.addAttribute("Perror", true);
            return "login.html";
        }
    }


}