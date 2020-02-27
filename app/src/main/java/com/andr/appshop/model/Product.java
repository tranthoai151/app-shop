package com.andr.appshop.model;

public class Product {

    Integer id;
    String name;
    String urlImage;
    Double price;

    public Product() {
    }

    public Product(Integer id, String name, String urlImage, Double price) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
