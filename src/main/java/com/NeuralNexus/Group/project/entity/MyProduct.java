package com.NeuralNexus.Group.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
public class MyProduct{

    @Id
    private int id;
    private String name;
    private float price;
    private String desc;
    private float rating;
    private String imgSrc;

    public MyProduct(int id, String name,float price, String desc, float rating, String imgSrc){
        this.id = id;
        this.desc = desc;
        this.price = price;
        this.rating = rating;
        this.name = name;
        this.imgSrc = imgSrc;

    }
    public MyProduct(int id, String name,float price, String desc, float rating){
        this.id = id;
        this.desc = desc;
        this.price = price;
        this.rating = rating;
        this.name = name;
    }
    public String getImgSrc() {
        return imgSrc;
    }
    public String getDesc() {
        return desc;
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

}