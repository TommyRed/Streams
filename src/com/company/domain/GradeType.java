package com.company.domain;

/**
 * Created by semantier on 11/27/2016.
 */
public enum GradeType {
    A(100), B(80), C(60), D(40), E(20), F(0);

    private final int value;

    GradeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
