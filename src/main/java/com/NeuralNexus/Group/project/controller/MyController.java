package com.NeuralNexus.Group.project.controller;

import com.NeuralNexus.Group.project.entity.MyProduct;
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

import java.util.Optional;

@Controller
public class MyController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String start(HttpSession session) {

        if (session.getAttribute("user") != null) {
            return "redirect:/main";
        }
        return "login.html";

    }



    @PostMapping("/login")
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password, Model model , HttpSession session) {

        if (email.equals("admin@admin") && password.equals("admin")) {
            return "redirect:/adminhome";
        }

        if (userRepository.exists(Example.of(new User(email, User.hashString(password))))) {
            User user = new User (email, password);
            session.setAttribute("user", user);
            float total = 0;
            session.setAttribute("total", total);
            User account = userRepository.findByEmail(email);
            session.setAttribute("account",account);
            return "redirect:/main";
        } else {
            model.addAttribute("Perror", true);
            return "redirect:/";
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
            return "redirect:/main";
        } else {
            model.addAttribute("Perror", true);
            return "redirect:/sign-up";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }



    @GetMapping("/payment")
    public  String payment(Model model,HttpSession session){
        float total = (float) session.getAttribute("total");
        model.addAttribute("total",total);
        return "FakePayment.html";
    }

}
