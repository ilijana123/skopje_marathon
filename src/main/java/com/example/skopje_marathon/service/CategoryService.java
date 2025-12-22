package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.CategoryDTO;
import com.example.skopje_marathon.mapper.CategoryMapper;
import com.example.skopje_marathon.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .toList();
    }
}
