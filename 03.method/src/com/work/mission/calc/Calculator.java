package com.work.mission.calc;

/*
 * ## 미션 : 사칙 연산 계산기
 * 
 * ## 
 */
public class Calculator {
	public void calculate(long no1, char operator, long no2) {
		switch(operator) {
		case '+':
			System.out.println("" + no1 + operator + no2 + "=" + addition(no1, no2));
			break;
		case '-':
			System.out.println("" + no1 + operator + no2 + "=" + subtraction(no1, no2));
			break;
		case 'x':
			System.out.println("" + no1 + operator + no2 + "=" + multiply(no1, no2));
			break;
		case '/':
			System.out.println("" + no1 + operator + no2 + "=" + division(no1, no2));
			break;
		default:
			System.out.println("[오류] 사칙연산 기호는 +, -, *, / 만 사용 가능합니다");
		}
	}

	public void calculate(double no1, char operator, double no2) {
		switch(operator) {
		case '+':
			System.out.println("" + no1 + operator + no2 + "=" + addition(no1, no2));
			break;
		case '-':
			System.out.println("" + no1 + operator + no2 + "=" + subtraction(no1, no2));
			break;
		case 'x':
			System.out.println("" + no1 + operator + no2 + "=" + multiply(no1, no2));
			break;
		case '/':
			System.out.println("" + no1 + operator + no2 + "=" + division(no1, no2));
			break;
		default:
			System.out.println("[오류] 사칙연산 기호는 +, -, *, / 만 사용 가능합니다");
		}
	}
	
	/**
	 * 정수형 덧셈 기능
	 * @param no1 숫자1
	 * @param no2 숫자2
	 * @return 정수형 덧셈결과
	 */
	public long addition(long no1, long no2) {
		return no1 + no2;
	}
	
	/**
	 * 실수형 덧셈 기능
	 * @param no1 숫자1
	 * @param no2 숫자2
	 * @return 실수형 덧셈결과
	 */
	public double addition(double no1, double no2) {
		return no1 + no2;
	}
	
	public long subtraction(long no1, long no2) {
		return no1 - no2;
	}
	
	public double subtraction(double no1, double no2) {
		return no1 - no2;
	}
	
	public long multiply(long no1, long no2) {
		return no1 *  no2;
	}
	
	public double multiply(double no1, double no2) {
		return no1 * no2;
	}
	
	public long division(long no1, long no2) {
		return no1 / no2;
	}
	
	public double division(double no1, double no2) {
		return no1 / no2;
	}
	
}
