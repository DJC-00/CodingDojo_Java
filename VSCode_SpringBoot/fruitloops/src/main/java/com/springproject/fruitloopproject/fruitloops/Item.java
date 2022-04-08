package com.springproject.fruitloopproject.fruitloops;

public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;

    public Item(String inName, double inPrice) {
        this.name = inName;
        this.price = inPrice;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

};

