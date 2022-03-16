package com.takeaway.menumicroservice.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.takeaway.menumicroservice.domain.model.Category;
import com.takeaway.menumicroservice.domain.model.Resturant;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MenuDto {

    @NotBlank(message = "Menu Title is mandatory")
    private String title;

    @NotNull
    private List<ResturantDto> resturants;

    @NotNull
    private List<CategoryDto> categories;



    public List<ResturantDto> getResturants() {
        return resturants;
    }
    public void setResturants(List<ResturantDto> resturants) {
        this.resturants = resturants;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public List<CategoryDto> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
}
