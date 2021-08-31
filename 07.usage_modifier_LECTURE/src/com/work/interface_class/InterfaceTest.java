package com.work.interface_class;

public class InterfaceTest {

	public static void main(String[] args) {
		// 추상클래스: 객체는 직접 생성불가하지만, 부모타입 다형성 가능
		// 인터페이스: 객체는 직접 생성불가하지만, 부모타입 다형성 가능
		//Pet pet = new Pet(); // 오류발생: 추상클래스는 직접 객체생성 불가 => 반드시 자식클래스가 상속후 재정의한 후에 객체 생성 사용 가능
		
		Pet[] pets = new Pet[5]; // 모든 애완동물을 저장하기위한 자료저장구조 부모타입(다형성)
		pets[0] = new Dog();
		pets[1] = new Dog();
		pets[2] = new Cat();
		pets[3] = new Rabbit();
		pets[4] = new Rabbit();
		
		// 첫번째 애완동물의 이름 변경 => 인터페이스에 선언한 멤버변수는 모두 상수처리됨 => 변경불가 오류
		//pets[0].name = "박호두";
		//pets[2].name = "양이";
		
		// 모든 애완동물의 eat() 기능을 호출 수행하세요
		for (int index = 0; index < pets.length; index++) {
			pets[index].eat(); // virtual method invocation: 재정의한 메서드는 자식객체타입에 맞는 메서드로 자동 호출 수행
		}
		
		System.out.println();
		// 모든 애완동물의 이름을 출력해보세요
		for (int index = 0; index < pets.length; index++) {
			System.out.println(pets[index].name);
		}
		
	}

}

// 인터페이스 = 상수 + 추상메서드로만 존재하는 클래스의 형태
interface Pet {	
	public String name = "씩씩이"; // 자동으로 public static final : 상수
	
	public abstract void eat(); // 추상메서드: 미완성의 메서드
	
	public void speak(); // 인터페이스는 자동으로 public abstract 지정됨
}

class Dog implements Pet { // 인터페이스는 implements 자식 클래스에서 구현

	@Override
	public void eat() { 
		System.out.println("강아지는 사료를 먹습니다.");
	} 
	
	@Override
	public void speak() {
		System.out.println("강아지는 멍멍멍 말을 합니다.");
	}
}

class Cat implements Pet { 
	@Override
	public void eat() {
		System.out.println("고양이는 저염식을 합니다.");
	}
	
	@Override
	public void speak() {
		System.out.println("고양이는 야옹야옹 말을 합니다.");
	}
}

class Rabbit implements Pet {
	@Override
	public void eat() {
		System.out.println("토끼는 풀을 먹습니다.");
	}

	@Override
	public void speak() { 
		// 수행문이 없는 메서드 재정의
		// 1. 일반화 시킨 부모클래스의 일부 기능이 일부 자식클래스에서는 필요하지 않는 경우도 있음
		// 2. 개발자 개발시에 메서드를 하나씩 하나씩 개발하면 테스트 
		// => 아직 코드를 구현하지 않았지만 컴파일되어야지만 구현한 다른 메서드를 테스트해야하는 경우
	}
	
}












