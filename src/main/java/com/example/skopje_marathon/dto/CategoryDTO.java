package com.example.skopje_marathon.dto;

import com.example.skopje_marathon.enumeration.CategoryType;
import lombok.Data;

@Data
public class CategoryDTO {
    public CategoryDTO(CategoryType type, Double price, Integer distance) {
        this.type = type;
        this.price = price;
        this.distance = distance;
    }
    private CategoryType type;
    private Double price;
    private Integer distance;
}
