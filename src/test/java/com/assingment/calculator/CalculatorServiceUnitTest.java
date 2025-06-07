package com.assingment.calculator;


import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.CalculatorService;
import com.assingment.calculator.service.OperationHandler;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceUnitTest {

    @Test
    void usesCorrectHandler() {
        OperationHandler addHandler = new OperationHandler() {
            @Override public boolean supports(Operation op) { return op == Operation.ADD; }
            @Override public Number apply(Number a, Number b) { return 99; }
        };

        CalculatorService service = new CalculatorService(List.of(addHandler));
        assertEquals(99, service.calculate(Operation.ADD, 2, 3));
    }

    @Test
    void throwsIfNoHandlerFound() {
        CalculatorService service = new CalculatorService(List.of());
        Exception e = assertThrows(UnsupportedOperationException.class, () ->
                service.calculate(Operation.MULTIPLY, 2, 2));
        assertTrue(e.getMessage().contains("Operation not supported"));
    }
}
