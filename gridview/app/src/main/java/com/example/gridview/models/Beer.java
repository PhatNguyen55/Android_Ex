package com.example.gridview.models;

public class Beer {
    public Beer(int beerThumb, String name, double price) {
        this.beerThumb = beerThumb;
        this.name = name;
        this.price = price;
    }

    int beerThumb;
    String name;
    double price;

    public void setBeerThumb(int beerThumb) {
        this.beerThumb = beerThumb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBeerThumb() {
        return beerThumb;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}