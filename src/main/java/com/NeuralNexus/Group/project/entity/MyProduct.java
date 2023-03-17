package com.NeuralNexus.Group.project.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


@Entity
@Table(name="myproduct")
public class MyProduct{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private float rating;


    @Column(name ="imgsrc")
    private String imgSrc;




    @Autowired
    public MyProduct(){

    }

    public MyProduct(int id, String name,float price, String description, float rating, String imgSrc){
        this.id = id;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.name = name;
        this.imgSrc = imgSrc;

    }

    public String getImgSrc() {
        return imgSrc;
    }
    public String getdescription() {
        return description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public float getRating() {
        return rating;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

}