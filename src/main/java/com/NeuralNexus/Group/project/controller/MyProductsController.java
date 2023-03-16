package main.java.com.NeuralNexus.Group.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NeuralNexus.Group.project.MyProduct;

public class MyProductsController {

    

    //Go back About Page when Pressed
    @GetMapping("/about")
    public String goToAbout(){
        return "login.html";
    }
    
    //Go back Contact Page when Pressed
    @GetMapping("/contact")
    public String goToContact(){
        return "login.html";
    }

    //Go back Account Page when Pressed
    @GetMapping("/account")
    public String goToAccount(){
        return "login.html";
    }


    //Store the Products
    public HashMap<Integer, MyProduct> myProducts = new HashMap<Integer, MyProduct>();
    //Count the number of products
    int count = 0;

    @PostMapping("/main")
    public String home(Model model){
        ArrayList<MyProduct> myProductsArr = new ArrayList<MyProduct>();
        myProducts.forEach((key,value) -> myProductsArr.add(value));

        MyProduct prod = new MyProduct(1,"Prod1", 20, "asfasnl", 3);
        MyProduct prod2 = new MyProduct(2,"Prodas1", 220, "afsfasnl", 1);

        myProductsArr.add(prod);
        myProductsArr.add(prod2);
        model.addAttribute("products", myProductsArr);
        return "login.html";
    }





}
