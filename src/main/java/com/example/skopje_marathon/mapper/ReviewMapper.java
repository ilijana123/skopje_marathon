package com.example.skopje_marathon.mapper;

import com.example.skopje_marathon.dto.ReviewDTO;
import com.example.skopje_marathon.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(source = "contestant.firstName", target = "contestantName")
    @Mapping(source = "race.category.type", target = "categoryType")
    ReviewDTO toDto(Review review);

    List<ReviewDTO> toDtoList(List<Review> reviews);
}

