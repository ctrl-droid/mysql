package com.work.mission.calc;

public class CalculatorTest {

	public static void main(String[] args) {
		// 계산기 사용방법 : calculate(숫자, 연산자, 숫자)
		Calculator calculator = new Calculator();
		calculator.calculate(20, '+', 30);
		calculator.calculate(20, '-', 30);
		calculator.calculate(20, 'x', 30);
		calculator.calculate(20, '/', 30);
		
		calculator.calculate(20.7, '+', 30);
		calculator.calculate(20.3, '-', 30.3F);
		calculator.calculate(20f, 'x', 3);
		calculator.calculate(20.7, '/', 35.7);
		
		//double result = calculator.addition(5, 3);  //외부(다른 클래스)에서 해당 메서드를 사용할 수 없음
		//System.out.println(result);
		calculator.calculate(5, '+', 3);
		
		//calculator.title = "거지같은계산기";  // 외부(다른클래스)에서 데이터를 함부로 변경할 수 없음
		calculator.calculate(5, '+', 3);
	}

}
