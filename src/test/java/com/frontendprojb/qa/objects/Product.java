package com.frontendprojb.qa.objects;

import com.frontendprojb.qa.utils.JacksonUtils;

import java.io.IOException;

public class Product {

    int id;
    String name;
    String category;
    String price;
    String search_term;

    public String getSearch_term() {
        return search_term;
    }

    public void setSearch_term(String search_term) {
        this.search_term = search_term;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product() {

    }

    public Product(int id) throws IOException {
        Product[] products = JacksonUtils.deserializeJson("products.json", Product[].class);
        for(Product product: products) {
            if(product.getId() == id) {
                this.id = product.getId();
                this.name = product.getName();
                this.category = product.getCategory();
                this.price = product.getPrice();
                this.search_term = product.getSearch_term();
            }
        }
    }
}
