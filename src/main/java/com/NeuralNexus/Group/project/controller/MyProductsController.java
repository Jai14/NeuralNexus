package com.NeuralNexus.Group.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.NeuralNexus.Group.project.entity.MyProduct;
import com.NeuralNexus.Group.project.entity.User;
import com.NeuralNexus.Group.project.repo.ProductRepositiory;
import com.NeuralNexus.Group.project.repo.UserRepository;
import com.NeuralNexus.Group.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MyProductsController {



    @Autowired
    private ProductRepositiory productRepositiory;

    @Autowired
    private UserService userService;



    //Go back Account Page when Pressed
    @GetMapping("/account")
    public String goToAccount(HttpSession session , Model model){
        User account = (User) session.getAttribute("account");
        model.addAttribute("account",account);
        return "UserDetails.html";
    }


    @GetMapping("/main")
    public String home(Model model){
        model.addAttribute("products",productRepositiory.findAll());
        System.out.println(productRepositiory.findAll());
        return "main.html";
    }

    @GetMapping("/productview/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        MyProduct product = productRepositiory.findById((long) id).orElseThrow(()->new IllegalArgumentException("dont exist"));
        model.addAttribute("product", product);
        model.addAttribute("positive",false);
        return "productview.html";
    }





}