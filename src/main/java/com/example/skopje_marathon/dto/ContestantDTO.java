package com.example.skopje_marathon.dto;

import lombok.Data;

@Data
public class ContestantDTO {
    private Integer startNumber;
    private String firstName;
    private String lastName;
    private String gender;
    private String team;
    private String country;
    private String distance;
}
