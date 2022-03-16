package com.takeaway.menumicroservice.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;

    @JsonIgnore
    private String imageUrl;

    @JsonIgnore
    private int totalQuantity;

    private String description;


    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id" ,  updatable = true)
    private Category category;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
    private List<ProductSize> ProductSizes;

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

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductSize> getProductSizes() {
        return ProductSizes;
    }
    public void setProductSizes(List<ProductSize> productSizes) {
        for (ProductSize productSize : productSizes) {
            productSize.setProduct(this);
        }
        ProductSizes = productSizes;
    }





}
