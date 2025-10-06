package com.example.skopje_marathon.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contestant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    @OneToOne(mappedBy = "contestant", cascade = CascadeType.ALL)
    private Race race;
}
