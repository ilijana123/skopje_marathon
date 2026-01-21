package com.example.skopje_marathon.dto;

import com.example.skopje_marathon.enumeration.CategoryType;
import com.example.skopje_marathon.enumeration.Gender;
import com.example.skopje_marathon.validation.MinAge;
import com.example.skopje_marathon.validation.PhoneNumber;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

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

        @NotNull(message = "Birth date is required.")
        @Past(message = "Birth date must be in the past.")
        @MinAge(value = 16, message = "Age should not be less than 16.")
        LocalDate birthDate,

        @PhoneNumber
        @NotBlank(message = "Phone number is required.")
        String phoneNumber,

        CategoryType categoryType
) {}
