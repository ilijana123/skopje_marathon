package com.example.skopje_marathon.model;

import com.example.skopje_marathon.enumeration.CategoryType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryType type;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer distance;
}
