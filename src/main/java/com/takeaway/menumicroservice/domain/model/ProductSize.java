package com.takeaway.menumicroservice.domain.model;

import javax.persistence.*;


@Entity
public class ProductSize {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private Boolean availability;
    private Integer price;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
