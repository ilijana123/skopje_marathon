package com.example.skopje_marathon.dto;

import com.example.skopje_marathon.enumeration.CategoryType;
import jakarta.validation.constraints.*;

public record RegisterRequest(
    @NotBlank(message = "First name must not be blank.")
    String firstName,
    @NotBlank(message = "Last name must not be blank.")
    String lastName,
    @Email(message = "Invalid email format.")
    @NotBlank(message = "Email is required.")
    String email,
    @Min(value = 16, message = "Age should not be less than 16.")
    int age,
    CategoryType categoryType
) {}
