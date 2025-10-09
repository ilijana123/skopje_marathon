package com.example.skopje_marathon.dto;

import com.example.skopje_marathon.enumeration.Status;
import lombok.Data;

@Data
public class RaceDTO {
    private String registrationNumber;
    private Integer startNumber;
    private String categoryType;
    private String contestantName;
    private Status status;
}
