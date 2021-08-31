package com.work.abstract_class;

public class AbstractTest {

	public static void main(String[] args) {
		// 추상클래스: 객체는 직접 생성불가하지만, 부모타입 다형성 가능
		//Pet pet = new Pet(); // 오류발생: 추상클래스는 직접 객체생성 불가 => 반드시 자식클래스가 상속후 재정의한 후에 객체 생성 사용 가능
		
		Pet[] pets = new Pet[5]; // 모든 애완동물을 저장하기위한 자료저장구조 부모타입(다형성)
		pets[0] = new Dog();
		pets[1] = new Dog();
		pets[2] = new Cat();
		pets[3] = new Rabbit();
		pets[4] = new Rabbit();
		
		// 첫번째 애완동물의 이름 변경
		pets[0].name = "박호두";
		pets[2].name = "양이";
		
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

// 추상클래스 구성요소 = 멤버변수 + 멤버메서드 + [추상메서드]
// 추상클래스 : 부모클래스 = 재산(멤버메서드) + 채무(추상메서드=> 반드시 채무는 변제해야하기 때문에 반드시 재정의)
abstract class Pet {	// 추상메서드가 존재하면 반드시 추상클래스로 선언
	public String name = "씩씩이";
	
//	public void eat() {
//		System.out.println("애완동물은 맛난것을 먹습니다.");
//	}
	
	public abstract void eat(); // 추상메서드: 미완성의 메서드
	
	public void speak() { // 구현된 메서드
		System.out.println("애완동물이 말을합니다.");
	}
}

class Dog extends Pet { // 부모클래스가 추상클래스가 아닌 경우에는 상속은 선택

	@Override
	public void eat() { 
		System.out.println("강아지는 사료를 먹습니다.");
	} 
	
}

class Cat extends Pet { // 부모클래스가 추상클래스가 아닌 경우에는 상속은 선택
	@Override
	public void eat() {
		System.out.println("고양이는 저염식을 합니다.");
	}
}

class Rabbit extends Pet {
	@Override
	public void eat() {
		System.out.println("토끼는 풀을 먹습니다.");
	}
	
}












