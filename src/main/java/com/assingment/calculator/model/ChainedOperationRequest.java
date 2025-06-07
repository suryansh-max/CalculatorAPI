package com.assingment.calculator.model;

import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
public class ChainedOperationRequest {
    @NonNull
    private Double initialValue;
    @NonNull
    private List<Step> steps;

    @Data
    public static class Step {
        private Operation operation;
        private Double value;
    }

}
