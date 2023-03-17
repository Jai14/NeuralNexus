package com.NeuralNexus.Group.project.controller;

import com.NeuralNexus.Group.project.entity.MyProduct;
import com.NeuralNexus.Group.project.entity.User;
import com.NeuralNexus.Group.project.repo.ProductRepositiory;
import com.NeuralNexus.Group.project.repo.UserRepository;
import com.NeuralNexus.Group.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyCartController {


    @Autowired
    private ProductRepositiory productRepositiory;

    HashMap<Long, MyProduct> cart = new HashMap<Long, MyProduct>();

    @GetMapping("/addcart/{id}")
    public String addcart(@PathVariable Long id, Model model , HttpSession session) {

        MyProduct product = productRepositiory.findById(id).orElseThrow(()->new IllegalArgumentException("don't exist"));
        cart.put(id,product);
        session.setAttribute("cart",cart);
        model.addAttribute("product",product);
        model.addAttribute("positive",true);
        return "ProductView.html";

    }

    @GetMapping("/cart")
    public String cartShow(Model model){
        model.addAttribute("products",cart.values());
        return "ShoppingCart.html";
    }


    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, HttpSession session) {
        Map<Long, MyProduct> cart = (Map<Long, MyProduct>) session.getAttribute("cart");
        cart.remove(id);
        session.setAttribute("cart",cart);
        return "redirect:/cart";
    }


}
