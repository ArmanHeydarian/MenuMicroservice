package com.takeaway.menumicroservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProductDto {

    private String title;
    private String imageUrl;
    private String description;

    private List<ProductSizeDto> ProductSizes;


}
