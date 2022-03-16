package com.takeaway.menumicroservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.takeaway.menumicroservice.domain.dto.Size;
import javax.persistence.*;

@Entity
public class ProductSize {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonIgnore
    private int id;

    private Boolean availability;

    @JsonIgnore
    private Integer price;

    private Size size;

    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",  updatable = true)
    private Product product;

    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
