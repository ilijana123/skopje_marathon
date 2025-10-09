package com.example.skopje_marathon.dto;

import com.example.skopje_marathon.enumeration.PaymentStatus;
import lombok.Data;

@Data
public class PaymentResponse {
    private String registrationNumber;
    private PaymentStatus status;
    private Integer startNumber;
    private String message;
}
