package com.example.skopje_marathon.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private int rating;
    private String content;
    private String contestantName;
    private String categoryType;
}
