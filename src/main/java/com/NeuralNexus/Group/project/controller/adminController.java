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


@Controller
public class adminController {

    @Autowired
    private ProductRepositiory productRepositiory;

    @GetMapping("/adminhome")
    public String adminhome(){
        return "adminhome.html";
    }



    @GetMapping("/adminadd")
    public String addProduct(){
        return "adminadd.html";
    }

    @PostMapping("/adminadd")
    public String addtodb(@ModelAttribute("product") MyProduct product){
        productRepositiory.save(product);
        return "redirect:/adminhome";
    }


    @GetMapping("/adminremove")
    public String removeProduct(Model model){
        model.addAttribute("products",productRepositiory.findAll());
        return "adminremove.html";
    }

    @GetMapping("/adminremove/{id}")
    public String removeProductfromrepo(@PathVariable("id") Long id){
        productRepositiory.deleteById(id);
        return "redirect:/adminremove";
    }


}