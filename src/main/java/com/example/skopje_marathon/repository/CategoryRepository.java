package com.example.skopje_marathon.repository;

import com.example.skopje_marathon.model.Category;
import com.example.skopje_marathon.enumeration.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByType(CategoryType type);
}
