package com.NeuralNexus.Group.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


@Entity
@Table(name="myproduct")
public class MyProduct{


    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;
    @Column(name = "desc")
    private String desc;
    @Column(name = "rating")
    private float rating;
    @Column(name = "imgsrc")
    private String imgSrc;




    @Autowired
    public MyProduct(){

    }

    public MyProduct(int id, String name,float price, String desc, float rating, String imgSrc){
        this.id = id;
        this.desc = desc;
        this.price = price;
        this.rating = rating;
        this.name = name;
        this.imgSrc = imgSrc;

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