package com.phase2.javaProject_Phase2.beans;

import lombok.Getter;

@Getter
public enum Category {
    ELECTRICITY("electricity"),
    FOOD("food"),
    RESTAURANT("restaurant"),
    VACATION("vacation");

    private String name;

    Category(String name) {
        this.name = name;
    }


}
