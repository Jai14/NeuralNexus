package com.NeuralNexus.Group.project;

import java.io.Serializable;


public class MyProduct implements Serializable{
    private int id;
    private String name;
    private float price;
    private String desc;
    private float rating;
    //private Sting imgSrc;

    public MyProduct(int d, String name,float price, String desc, float rating){
        this.id = id;
        this.desc = desc;
        this.price = price;
        this.rating = rating;
        this.name = name;
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
