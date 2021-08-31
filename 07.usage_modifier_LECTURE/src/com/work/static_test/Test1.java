package com.work.static_test;

class Test1 {
	// instance 멤버변수
	public int data = 100;
	
	// instance 멤버메서드
	public void doA() {
		System.out.println(data); // 같은 클래스에 있는 instance 멤버는 객체생성없이 그대로 사용
	}
}

class Test2 {
	// instance 멤버변수
	public int data2 = 200;
	
	public void doB() {
		System.out.println(data2); // 같은 클래스에 있는 instance 멤버는 객체생성없이 그대로 사용
		
		Test1 test = new Test1();
		test.data = 500;	// Test1 다른 클래스에 있는 instance 멤버를 객체 생성후 참조변수를 통해서 사용
	}
}

class Test3 {
	// class 멤버변수
	public static int data3 = 300;
	
	// instance 멤버변수
	public int data4 = 400;
	
	// class 멤버메서드 이면서 자바 실행 메서드
	public static void main(String[] args) {
		System.out.println(data3);  // static 멤버메서드 내부에서는 static 멤버는 그대로 사용 가능
		
		//System.out.println(data4);  
		// static 멤버메서드 내부에서는 non-static (즉, instance 멤버)는 그대로 사용 불가: 오류
		// 같은 클래스에 존재하는 instance 멤버일찌라도 static 멤버메서드 내부에서는 반드시 객체를 생성한 후에 참조변수명.instance멤버를 통해서 사용 가능
		Test3 test = new Test3();
		System.out.println(test.data4); // 반드시 객체를 생성한 후에 참조변수명.instance멤버를 통해서 사용 가능
	
		// java.lang.Math.PI
		System.out.println("PI = " + Math.PI);
	}
	
	// instance 멤버 메서드
	public void doC() {
		System.out.println(data3);  // instance 멤버 메서드 내부에서는 같은 클래스에 있는 static 멤버는 그대로 사용 가능 
		System.out.println(data4);  // instance 멤버 메서드 내부에서는 같은 클래스에 있는 instance 멤버는 그대로 사용 가능 
	}
}













