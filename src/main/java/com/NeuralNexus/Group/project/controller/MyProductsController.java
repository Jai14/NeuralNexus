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

@Controller
public class MyProductsController {

    //Go back About Page when Pressed
    @GetMapping("/about")
    public String goToAbout(){
        return "home.html";
    }
    
    //Go back Contact Page when Pressed
    @GetMapping("/contact")
    public String goToContact(){
        return "contact.html";
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


    @GetMapping("/main")
    public String home(Model model){
        ArrayList<MyProduct> myProductsArr = new ArrayList<MyProduct>();
        MyProduct prod0 = new MyProduct(count++,"Prod1", 20, "asfasnl", 3, "product-1.jpg");
        MyProduct prod1 = new MyProduct(count++,"Prod2", 20, "asf3asnal", 3, "product-1.jpg");
        MyProduct prod2 = new MyProduct(count++,"Prod3", 220, "afsfqasnl", 1, "product-2.jpg");
        MyProduct prod3 = new MyProduct(count++,"Prod4", 220, "afsffasnl", 1, "product-3.jpg");
        MyProduct prod4 = new MyProduct(count++,"Prod5", 220, "afsfasnl", 1);
        MyProduct prod5 = new MyProduct(count++,"Prod6", 220, "affsfvasnl", 1);
        MyProduct prod6 = new MyProduct(count++,"Prod7", 220, "afasfasnl", 1, "product-4.jpg");
        MyProduct prod7 = new MyProduct(count++,"Prod8", 220, "afsfasnl", 1, "product-5.jpg");
        MyProduct prod8 = new MyProduct(count++,"Prod9", 220, "afsfasgnl", 1, "product-6.jpg");

        myProducts.put(prod0.getId(), prod0);
        myProducts.put(prod1.getId(), prod1);
        myProducts.put(prod2.getId(), prod3);
        myProducts.put(prod3.getId(), prod2);
        myProducts.put(prod4.getId(), prod3);
        myProducts.put(prod5.getId(), prod4);
        myProducts.put(prod6.getId(), prod1);
        myProducts.put(prod7.getId(), prod5);
        myProducts.put(prod8.getId(), prod2);
        
        myProducts.forEach((key,value) -> myProductsArr.add(value));

        model.addAttribute("products", myProductsArr);
        return "main.html";
    }

    @GetMapping("/productview/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        MyProduct product = myProducts.get(id);
        model.addAttribute("product", product);
        return "productview.html";
    }





}
