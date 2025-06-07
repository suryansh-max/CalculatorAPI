package com.assingment.calculator.handlertests;

import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.handlers.MultiplyHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MultiplyHandlerTest {
    private final MultiplyHandler handler = new MultiplyHandler();

    @Test
    void supportsMultiply() {
        assertTrue(handler.supports(Operation.MULTIPLY));
    }

    @Test
    void applyReturnsCorrectResult() {
        assertEquals(50.0, handler.apply(10, 5));
    }
}
