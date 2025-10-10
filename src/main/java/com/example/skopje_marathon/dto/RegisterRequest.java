package com.example.skopje_marathon.dto;

import com.example.skopje_marathon.enumeration.CategoryType;
import com.example.skopje_marathon.enumeration.Gender;
import jakarta.validation.constraints.*;

public record RegisterRequest(
    @NotBlank(message = "First name must not be blank.")
    String firstName,
    @NotBlank(message = "Last name must not be blank.")
    String lastName,
    Gender gender,
    String team,
    String country,
    @Email(message = "Invalid email format.")
    @NotBlank(message = "Email is required.")
    String email,
    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit and one special character."
    )
    String password,
    @Min(value = 16, message = "Age should not be less than 16.")
    int age,
    CategoryType categoryType
) {}
