package me.develop_han.TDD_start.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.develop_han.TDD_start.calculator.Calculator;

class CalculatorTest {

	@DisplayName("1. 더하기(+) 테스트")
	@Test
	public void plus_test() throws Exception{
		int result = Calculator.plus(1,2);
		assertEquals(3,result);
		assertEquals(5,Calculator.plus(4,1));

	}

}
