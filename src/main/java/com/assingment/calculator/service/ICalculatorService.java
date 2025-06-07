package com.assingment.calculator.service;

import com.assingment.calculator.model.Operation;
import java.util.List;


public interface ICalculatorService {
   Number calculate(Operation operation, Number a, Number b);
    Number calculateSequential(Number initial, List<CalculatorService.Step> steps);
}
