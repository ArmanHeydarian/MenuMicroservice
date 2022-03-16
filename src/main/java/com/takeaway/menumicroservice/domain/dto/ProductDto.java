package com.takeaway.menumicroservice.domain.dto;

import java.util.List;

public class ProductDto {

    private String title;
    private String imageUrl;
    private String description;

    private List<ProductSizeDto> productSizes;


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

    public String getDescription() {
        return description;
    }

    public List<ProductSizeDto> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSizeDto> productSizes) {
        this.productSizes = productSizes;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
