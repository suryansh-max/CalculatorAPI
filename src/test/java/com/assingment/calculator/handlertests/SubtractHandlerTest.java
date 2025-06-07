package com.assingment.calculator.handlertests;

import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.handlers.SubtractHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubtractHandlerTest {
    private final SubtractHandler handler = new SubtractHandler();

    @Test
    void supportsSubtract() {
        assertTrue(handler.supports(Operation.SUBTRACT));
        assertFalse(handler.supports(Operation.ADD));
    }

    @Test
    void applyReturnsCorrectResult() {
        assertEquals(5.0, handler.apply(10, 5));
    }
}
