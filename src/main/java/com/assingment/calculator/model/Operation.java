package com.assingment.calculator.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    // Ensures lower case also works i.e add
    @JsonCreator
    public static Operation fromString(String value) {
        return Operation.valueOf(value.trim().toUpperCase());
    }
}
