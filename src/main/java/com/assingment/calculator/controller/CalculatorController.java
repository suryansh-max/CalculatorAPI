package com.assingment.calculator.controller;

import com.assingment.calculator.model.CalculationRequest;
import com.assingment.calculator.model.ChainedOperationRequest;
import com.assingment.calculator.service.ICalculatorService;
import com.assingment.calculator.service.CalculatorService.Step;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final ICalculatorService calculatorService;

    public CalculatorController(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public Number calculate(@Valid @RequestBody CalculationRequest request) {
        log.info("Received calculate request: {}", request);
        Number result = calculatorService.calculate(
                request.getOperation(),
                request.getNumber1(),
                request.getNumber2()
        );
        log.info("Calculation result: {}", result);
        return result;
    }

    @PostMapping("/calculate-chained")
    public Number calculateChained(@Valid @RequestBody ChainedOperationRequest request) {
        log.info("Received chained calculation request: {}", request);

        var steps = request.getSteps().stream()
                .map(s -> new Step(s.getOperation(), s.getValue()))
                .collect(Collectors.toList());

        Number result = calculatorService.calculateSequential(request.getInitialValue(), steps);

        log.info("Chained calculation result: {}", result);
        return result;
    }
}
