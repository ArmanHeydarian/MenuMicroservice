package com.takeaway.menumicroservice.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.takeaway.menumicroservice.domain.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class MenuDto {

    private String title;
    private int resturantId;

    private List<Category> categories;
}
