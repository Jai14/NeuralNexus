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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String start(HttpSession session) {

        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        return "login.html";

    }


//   TODO - later
    @PostMapping("/login")
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password, Model model , HttpSession session) {


        if (userRepository.exists(Example.of(new User(email, User.hashString(password))))) {
            User user = new User (email, password);
            session.setAttribute("user", user);
            return "main.html";
        } else {
            model.addAttribute("Perror", true);
            return "login.html";
        }
    }


    @GetMapping("/sign-up")
    public String signupForm() {
        return "signup.html";
    }


    @PostMapping("/sign-up")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        // code to save user
        if (!userService.emailExists(user.getemail())) {
            userRepository.save(user);
            return "main.html";
        } else {
            model.addAttribute("Perror", true);
            return "signup.html";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/home")
    public String home() {
        return "main.html";
    }

    @GetMapping("/cart")
    public  String cart(){
        return "ShoppingCart.html";
    }

    @GetMapping("/payment")
    public  String payment(){
        return "FakePayment.html";
    }

}
