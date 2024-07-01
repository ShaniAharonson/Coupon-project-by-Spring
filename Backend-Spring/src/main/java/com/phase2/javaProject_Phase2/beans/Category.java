package com.phase2.javaProject_Phase2.beans;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter

public enum Category {
    ELECTRICITY("electricity"),
    FOOD("food"),
    RESTAURANT("restaurant"),
    VACATION("vacation");

    private final String name;
     Category(String name) {
        this.name = name;
    }


}
