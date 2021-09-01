package com.work.view;

/**
 * <pre>
 * ## java.lang.Object
	- 모든 클래스의 최상위 클래스 (Root Class)
	- 명시적으로 상속하지 않아도 자동으로 상속됨
	- 모든 객체가 갖어야할 공통 기능으로 모델링
	-- 자주 재정의하여 사용하는 메서드
	  ==> public String toString(){} : 주요 데이터 문자열 반환
	  ==> public boolean equals(Object obj){} : 같은 객체인지 비교
	  ==> public int hashCode(){} : 생성한 객체의 참조값 반환
 * </pre>
 */
public class ObjectTest {

	public static void main(String[] args) {
		// Object 타입의 객체를 2개 생성
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		Object obj3 = obj1; // obj1, obj3 같은 객체를 참조하고 있음 => 같은 참조값
			
		// 생성한 객체들의 hashcode() 메서드 호출 출력
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());

		
		
		// 생성한 객체들의 hashCode() 메서드 호출 출력
		System.out.println(obj1 == obj2);  // false
		System.out.println(obj1 == obj3);  // true
		
		System.out.println(obj1.equals(obj2));  // false
		System.out.println(obj1.equals(obj3));  // true
		
		// toString() 호출 수행
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
		
		System.out.println(obj1);  // 참조변수명.toString() 동일함, 콘솔출력시에는 toString() 생략가능
		System.out.println(obj2);
		System.out.println(obj3);
		
		System.out.println();
		
		
	}

}
