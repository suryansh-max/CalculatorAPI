package com.assingment.calculator.handlertests;
import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.handlers.AddHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddHandlerTest {
    private final AddHandler handler = new AddHandler();

    @Test
    void testSupportsAdd() {
        assertTrue(handler.supports(Operation.ADD));
        assertFalse(handler.supports(Operation.SUBTRACT));
    }

    @Test
    void testAddition() {
        assertEquals(8.0, handler.apply(5, 3));
    }
}
