package com.example.skopje_marathon.mapper;

import com.example.skopje_marathon.dto.CategoryDTO;
import com.example.skopje_marathon.model.Category;

public class CategoryMapper {

    private CategoryMapper() {}

    public static CategoryDTO toDto(Category category) {
        return new CategoryDTO(
                category.getType(),
                category.getPrice(),
                category.getDistance()
        );
    }
}