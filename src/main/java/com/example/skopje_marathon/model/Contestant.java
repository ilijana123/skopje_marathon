package com.example.skopje_marathon.model;

import com.example.skopje_marathon.enumeration.Gender;
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
    private Gender gender;
    private String team;
    private String country;
    private String password;
    private String email;
    private int age;
    @OneToOne(mappedBy = "contestant", cascade = CascadeType.ALL)
    private Race race;
}

