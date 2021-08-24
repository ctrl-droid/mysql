package com.work.view;

public class MethodTest {

	public static void main(String[] args) {
		// Method 클래스 객체 생성
		Method m = new Method();
		
		// doA() 호출 수행
		m.doA(10, 20);
		m.doB(10, 10.7);
		 
		double result = m.doB(10, 10.7);  // 변수에 담아놓고 변수를 핸들링해야하는 경우
		System.out.println(result);
		System.out.println();
		
		System.out.println(m.doB(10, 10.7));
		
		result = m.doB(10, 10.7F);  
		// doB(int, float) 
		// => 매개변수 타입이 동일한 타입이 존재하지 않으면
		// => 자동형변환에 의해서 큰타입의 아규먼트를 받는 매서드를 검색
		// => doB(int, float) => doB(int, double)
	}

}


class Method {
	// 2개의 int 타입을 아규먼트로 받는 매서드 선언: doA
	public void doA(int no1, int no2) {
		System.out.println(no1 + no2);
		
	}
	
	
	// 2개의 int, double 타입을 아규먼트로 받는 매서드 선언: doB(),
	// 아규먼트로 전달받은 int + double 덧셈결과를 반환
	// 같은 타입의 연산결과는 같은 타입
	// 다른 타입의 연산결과는 큰 타입
	// 반환타입 ?? double
	
	public double doB(int no1, double no2) {
		System.out.println("doB(int no1, double no2)");
		//return 0; // 반환타입의 자동형변환 작은타입의 값은 큰 반환타입 가능
		return no1 + no2;
		
	}
	
	// 중복정의(overloading): 매서드 이름은 동일하고, 아규먼트가 다름(갯수, 타입, 순서)
	public double doB(double no1, double no2) {
		System.out.println("doB(double no1, double no2)");
		return no1 + no2;
		
	}
	
	// 중복정의(overloading)
	public double doB(int no1, float no2) {
		System.out.println("doB(int no1, float no2)");
		return no1 + no2;
		
	}
	
	
}
