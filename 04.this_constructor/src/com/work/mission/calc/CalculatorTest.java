package com.work.mission.calc;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.calculate(20, '+', 30);
		calculator.calculate(20, '-', 30);
		calculator.calculate(20, 'x', 30);
		calculator.calculate(20, '/', 30);
		
		calculator.calculate(20.7, '+', 30);
		calculator.calculate(20.3, '-', 30.3F);
		calculator.calculate(20f, 'x', 3);
		calculator.calculate(20.7, '/', 35.7);
	}

}
