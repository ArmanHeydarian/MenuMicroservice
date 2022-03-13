package com.takeaway.menumicroservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
public class ProductSizeDto {

    private Size size;
    private Boolean availability;
    private Integer price;

}
