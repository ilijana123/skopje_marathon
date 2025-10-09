package com.example.skopje_marathon.enumeration;

import lombok.Getter;

@Getter
public enum CategoryType {
    FIVE_KM("5km"),
    TEN_KM("10km"),
    HALF_MARATHON("Half Marathon"),
    MARATHON("Marathon");

    private final String displayName;

    CategoryType(String displayName) {
        this.displayName = displayName;
    }
}
