package com.takeaway.menumicroservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
public class CategoryDto {

    private String title;
    private List<ProductDto> productDtos;


}
