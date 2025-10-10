package com.example.skopje_marathon.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String content;

    @ManyToOne
    private Race race;

    @ManyToOne
    private Contestant contestant;
}
