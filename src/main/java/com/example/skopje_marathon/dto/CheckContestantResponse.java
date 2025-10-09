package com.example.skopje_marathon.dto;

import lombok.Data;

@Data
public class CheckContestantResponse {
    private String message;
    private String registrationNumber;
    private Integer startNumber;
    private String paymentLink;
}
