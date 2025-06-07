package com.assingment.calculator.service;

import com.assingment.calculator.model.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CalculatorService implements ICalculatorService {

    private final List<OperationHandler> handlers;

    public CalculatorService(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public Number calculate(Operation operation, Number a, Number b) {
        log.info("Performing operation: {} on values: {} and {}", operation, a, b);

        Number result = handlers.stream()
                .filter(h -> h.supports(operation))
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Unsupported operation attempted: {}", operation);
                    return new UnsupportedOperationException("Operation not supported: " + operation);
                })
                .apply(a, b);

        log.info("Result of {} operation: {}", operation, result);
        return result;
    }

    @Override
    public Number calculateSequential(Number initial, List<Step> steps) {
        log.info("Starting sequential calculation with initial value: {}", initial);
        Number result = initial;

        for (Step step : steps) {
            log.info("Applying step: {} {}", step.operation(), step.value());
            result = calculate(step.operation(), result, step.value());
        }

        log.info("Final result after sequential operations: {}", result);
        return result;
    }

    public record Step(Operation operation, Number value) {}
}
