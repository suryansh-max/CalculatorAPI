package com.assingment.calculator.service;

import com.assingment.calculator.model.Operation;

public interface OperationHandler {
    boolean supports(Operation operation);
    Number apply(Number a, Number b);
}