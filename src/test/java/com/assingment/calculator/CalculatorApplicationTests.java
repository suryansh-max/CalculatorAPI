package com.assingment.calculator;

import com.assingment.calculator.model.Operation;
import com.assingment.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceIntegrationTest {

	@Autowired
	private CalculatorService calculatorService;

	@Test
	void testAddition() {
		Number result = calculatorService.calculate(Operation.ADD, 10, 5);
		assertEquals(15.0, result);
	}

	@Test
	void testSubtraction() {
		Number result = calculatorService.calculate(Operation.SUBTRACT, 10, 5);
		assertEquals(5.0, result);
	}

	@Test
	void testMultiplication() {
		Number result = calculatorService.calculate(Operation.MULTIPLY, 10, 5);
		assertEquals(50.0, result);
	}

	@Test
	void testDivision() {
		Number result = calculatorService.calculate(Operation.DIVIDE, 10, 2);
		assertEquals(5.0, result);
	}

	@Test
	void testDivisionByZero() {
		Exception ex = assertThrows(ArithmeticException.class, () ->
				calculatorService.calculate(Operation.DIVIDE, 10, 0));
		assertEquals("Cannot divide by zero.", ex.getMessage());
	}

	@Test
	void testChainedOperations() {
		var steps = List.of(
				new CalculatorService.Step(Operation.ADD, 3),
				new CalculatorService.Step(Operation.MULTIPLY, 2),
				new CalculatorService.Step(Operation.SUBTRACT, 4)
		);

		Number result = calculatorService.calculateSequential(5, steps);
		// 5 + 3 = 8, * 2 = 16, - 4 = 12
		assertEquals(12.0, result);
	}
}