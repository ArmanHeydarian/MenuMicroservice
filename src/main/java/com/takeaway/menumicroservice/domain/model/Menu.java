package com.takeaway.menumicroservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;

    private int resturantId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResturantId() {
        return resturantId;
    }

    public void setResturantId(int resturantId) {
        this.resturantId = resturantId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
    private List<Category> categories;
}
