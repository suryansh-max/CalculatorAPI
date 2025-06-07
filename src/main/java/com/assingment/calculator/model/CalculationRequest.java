package com.assingment.calculator.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculationRequest {
    @NotNull(message = "Operation must be provided")
    private Operation operation;
    @NotNull(message = "number1 must be provided")
    private Double number1;
    @NotNull(message = "number2 must be provided")
    private Double number2;

}
