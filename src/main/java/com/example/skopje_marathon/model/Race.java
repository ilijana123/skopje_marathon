package com.example.skopje_marathon.model;

import com.example.skopje_marathon.enumeration.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String registrationNumber;
    private Integer startNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "contestant_id")
    private Contestant contestant;

    @OneToOne(mappedBy = "race", cascade = CascadeType.ALL)
    private Payment payment;
}
