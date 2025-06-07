package com.assingment.calculator.service.handlers;

import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.OperationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DivideHandler implements OperationHandler {
    @Override
    public boolean supports(Operation operation) {
        boolean supported = operation == Operation.DIVIDE;
        log.debug("DivideHandler supports check for operation {}: {}", operation, supported);
        return supported;
    }

    @Override
    public Number apply(Number a, Number b) {
        if (b.doubleValue() == 0) {
            log.error("Attempted division by zero: {}/{}", a, b);
            throw new ArithmeticException("Cannot divide by zero.");
        }
        double result = a.doubleValue() / b.doubleValue();
        log.info("Dividing {} / {} = {}", a, b, result);
        return result;
    }
}
