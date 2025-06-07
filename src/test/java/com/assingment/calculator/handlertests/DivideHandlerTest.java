package com.assingment.calculator.handlertests;

import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.handlers.DivideHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DivideHandlerTest {
    private final DivideHandler handler = new DivideHandler();

    @Test
    void supportsDivide() {
        assertTrue(handler.supports(Operation.DIVIDE));
    }

    @Test
    void applyReturnsCorrectResult() {
        assertEquals(2.0, handler.apply(10, 5));
    }

    @Test
    void throwsOnDivideByZero() {
        Exception e = assertThrows(ArithmeticException.class, () -> handler.apply(10, 0));
        assertEquals("Cannot divide by zero.", e.getMessage());
    }
}
