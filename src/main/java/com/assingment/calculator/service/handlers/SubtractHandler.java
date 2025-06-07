package com.assingment.calculator.service.handlers;

import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.OperationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubtractHandler implements OperationHandler {
    @Override
    public boolean supports(Operation operation) {
        boolean supported = operation == Operation.SUBTRACT;
        log.debug("SubtractHandler supports check for operation {}: {}", operation, supported);
        return supported;
    }

    @Override
    public Number apply(Number a, Number b) {
        double result = a.doubleValue() - b.doubleValue();
        log.info("Subtracting {} - {} = {}", a, b, result);
        return result;
    }
}
