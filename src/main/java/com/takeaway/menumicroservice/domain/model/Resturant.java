package com.takeaway.menumicroservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    private int resturantId;


    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getResturantId() {
        return resturantId;
    }
    public void setResturantId(int resturantId) {
        this.resturantId = resturantId;
    }

    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }



}
