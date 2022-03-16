package com.takeaway.menumicroservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotBlank(message = "Menu Title is mandatory")
    private String title;

    @JsonIgnore
    private Boolean status;

    private Date createDate;

    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
    private List<Resturant> resturants;



    public List<Resturant> getResturants() {
        return resturants;
    }
    public void setResturants(List<Resturant> resturants) {
        for (Resturant resturant : resturants) {
            resturant.setMenu(this);
        }
        this.resturants = resturants;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        for (Category cat : categories) {
            cat.setMenu(this);
        }
        this.categories = categories;

    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date modifiedDate) {
        this.createDate = modifiedDate;
    }



}
