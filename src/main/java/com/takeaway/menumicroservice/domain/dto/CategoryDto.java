package com.takeaway.menumicroservice.domain.dto;

import com.takeaway.menumicroservice.domain.model.Menu;

import java.util.List;

public class CategoryDto {


    private String title;
    private List<ProductDto> products;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
