package com.work.final_test;

public class FinalTest {

	public static void main(String[] args) {

	}

}

// public final class String : 상속불가 클래스
//class A extends String { 
//}

class B {
	// 자바: 상수 선언 및 값 할당
	public static final int MAX_COUNT = 20;
	
	public final void doB() {
		System.out.println("B라는 클래스가 정의한 메서드는 그대로 사용해야합니다[자식이어도 재정의 불가]");
	}

	public void doB2() {
		//MAX_COUNT = 30; // 상수는 변경불가
		//Math.PI = 12345678;  // Math.PI => public static final PI double 상수선언 변경 불가
	}
	
	// 암호변경
	public void updateMemberPw(String memberId, String memberPw, final String modifyMemberPw) {
		//  개발자가 임의로 변경암호를 바꿔서는 안됨
		memberPw = "메서드내부에서 임의의 데이터로 변경";
		
		// final 매개변수이므로 전달받은 데이터를 메서드 내부에서 임의로 변경불가
		//modifyMemberPw = "메서드내부에서 임의의 데이터로 변경";
		System.out.println(modifyMemberPw);
	}
}


class C extends B {
//	@Override
//	public void doB() { // public final void doB()  부모클래스에서 재정의 불가 메서드로 선언해서 그대로 사용
//		System.out.println("자식클래스가 재정의 변경합니다.");
//	}
	
	@Override
	public void doB2() {
		System.out.println("자식클래스가 재정의 변경합니다.");
	}
}






