package com.work.static_test;

public class StaticTest {
	
	public static void main(String[] args) {
		// A 클래스 객체 생성 : message, title 초기화 생성자 사용
		// 객체를 2개 생성하는데 message, title은 각각 다른 값을 지정해서 객체를 2개 생성
		
		A a1 = new A("hello", "배고프다");	// message, title
		System.out.println();
		
		A a2 = new A("bye", "비온다"); // message(class 멤버변수), title(instance 멤버변수)
		System.out.println();
		
		System.out.println(A.message); // class 멤버변수는 객체생성하지않고 클래스이름.class멤버변수명 사용가능
		System.out.println(a1.message); // class 멤버변수는 해당 클래스의 모든 객체들이 공유하는 변수
		System.out.println(a2.message); // 모두다 동일한 message "bye" 출력
		System.out.println();
		
		System.out.println(a1.title);	// a1 참조하고있는 title 출력 "배고프다"
		System.out.println(a2.title);	// a2 참조하고있는 title 출력 "비온다"
		
		A.message = "배고프죠.. 우리 이것 제대로 출력되면 밥먹을까요??";
		
		System.out.println();
		System.out.println(new A().message);
		System.out.println(a1.message); // class 멤버변수는 해당 클래스의 모든 객체들이 공유하는 변수
		System.out.println(a2.message); // 모두다 동일한 message "배고프죠.. 우리 이것 제대로 출력되면 밥먹을까요??" 출력
		System.out.println();
		
	}
	
	public static void main1(String[] args) {
		// A 클래스 객체 생성 : 기본생성자 사용
		A a1 = new A();
		System.out.println();
		
		A a2 = new A();
	}

}


class A {
	// class 멤버변수 선언
	public static String message = "자바 프로그래밍";
	
	// instanc 멤버변수 선언 
	public String title = "Usage Modifier";
	
	// class 블럭 초기화
	static {
		System.out.println("[class 블럭 초기화] 프로그램실행시 딱 한번만 수행됩니다.: " + message);
	}
	
	// instance 블럭 초기화
	{
		System.out.println("[instance 블럭 초기화] 객체 생성할때마다 호출 수행됩니다.");
	}
	
	// 기본 생성자
	public A() {
		System.out.println("[기본생성자] 생성자도 객체 생성할때마다 호출 수행됩니다.");
	}
	
	// 생성자 중복 정의
	public A(String message, String title) {
		this.message = message;
		this.title = title;
		System.out.println("[중복정의 생성자] 중복정의 생성자도 객체 생성할때마다 호출 수행됩니다.[멤버변수를 아규먼트 받아서 초기화]");
		System.out.println("message[static 멤버변수]: " + this.message);
		System.out.println("title[instance 멤버변수]: " + this.title);
	}
}