package com.work.view;

public class VariableTest {

	public static void main(String[] args) {
		Variable test = new Variable();
		test.doA();
		test.doB("빨리 쉬고싶어요");

	}

}


class Variable {
	/** 멤버변수: instance 변수 - 외부 클래스 객체 생성 후 참조변수로 접근 사용 가능 */
	public String var1 = "인공지능을 활용한 이미지 기반 자율주행 시스템 개발자 양성과정";
	
	public void doA() {
		// 메서드 내부에서 선언한 지역변수
		String var1 = "자바 프로그래밍 과정";
		
		// 멤버변수명과 지역변수명이 동일하면 지역변수가 우선권을 갖음: 지역변수가 출력
		System.out.println("멤버변수 ?? 지역변수 ?? var1: "+ var1);
	}
	
	public void doB(String var1) {
		// 메서드 매개변수 선언한 지역변수
		
		
		// 멤버변수명과 지역변수명이 동일하면 지역변수가 우선권을 갖음: 지역변수가 출력
		System.out.println("멤버변수 ?? 매개변수 지역변수 ?? var1: "+ var1);  //"매서드의 아규먼트로 전달받은 var1 출력 
	}
	
	public void doC(int data) {
		// 같은 클래스에 있는 멤버변수(instance)는 메서드 내부에서 그대로 사용 가능
		System.out.println("멤버변수 var1: "+ var1);
		
		String result = "결과:";
		if (data % 2 == 0) {
			// if 구문 내부에서만 사용 가능한 지역변수
			//String result = "결과: 짝수";   // 동일한 지역변수 존재 오류발생
			result = "짝수입니다";
			System.out.println(data+ "는 짝수입니다.");
			System.out.println(result);
		} else {
			System.out.println(data + "는 홀수입니다.");
			System.out.println(result);
		}
	}
}
