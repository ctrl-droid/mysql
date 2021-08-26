/**
 * 
 */
package com.work.view;

import java.util.Date;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 *	회원관리 시스템 테스트 클래스
 */
public class MemberTest {
	
	public static void main(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
	
		SpecialMember s = (SpecialMember)dto1; 
		// 컴파일 정상, 실행해보세요?? => 잘못된 객체를 형변환을 하게되면 실행시 오류발생 
		// => 해결책??: 형변환하기 전헤 해당 클래스의 객체(instance)인지 검증하는 로직이 필요함
		// 실행 오류발생
		//Exception in thread "main" java.lang.ClassCastException: com.work.model.dto.GeneralMember cannot be cast to com.work.model.dto.SpecialMember
		//at com.work.view.MemberTest.main(MemberTest.java:21)

	}
	
	
	// 부모타입인 경우에는 자식객체의 멤버를 접근 불가 => 실제적으로 메모리에는 자식객체 로딩되어 있음
	// 실제 자식 객체 타입으로 형변환을 통해서 자식객체의 멤버 접근 사용 가능
	// 타입 참조변수명 = (타입)참조변수명;
	public static void main6(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		//dto1.setMileage(5000); // error 부모타입 자식멤버 접근 불가
		System.out.println(dto1.toString()); // 부모타입이든 자식타입이든 상속받아 재정의한 메서드는 실제 자식객체의 재정의 메서드로 자동호출됨
		
		GeneralMember g1 = (GeneralMember)dto1;
		g1.setMileage(5000);	// ok: 실제 자식객체 타입으로 형변환이 되어 자식의 멤버 접근 가능
		System.out.println(g1.toString());	// 부모타입이든 자식타입이든 상속받아 재정의한 메서드는 실제 자식객체의 재정의 메서드로 자동호출됨
		
	}
	
	// 부모타입의 참조변수에 자식객체를 저장하는 경우 : 메모리 구조
	public static void main5(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		
		//dto1.setMileage(5000);	// error: 부모타입으로 자식객체를 참조하는 경우에는 자식의 멤버 접근 하지 않음
		String info = dto1.toString();	// 부모타입이지만 virtual method invocation에 의해서 자식이 재정의한 toString() 호출 수행
		
	}
	
	// 다형성 객체형 : 회원 적용 
	// 회원관리 상속구조 : Object => [ Member ] => GeneralMember, SpecialMember, AdminMember
	public static void main4(String[] args) {
		// 회원의 부모 클래스 
		Member dto = new Member();  // Member = Member 같은 타입 할당
		System.out.println("1. " + dto); // Member: 1. null, null, null, null, null, null, null
		
		// 일반회원 : GeneralMember = GeneralMember 같은 타입 할당
		GeneralMember dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		System.out.println("2. " + dto1); // GeneralMember: 2. user01, password01, 홍길동, 010-1234-1000, user01@work.com, 2020-12-15, G, 50000
	
		// 부모타입의 다형성: 부모 및 모든 자식클래스를 참조 가능한 변수
		dto = dto1;   // Member = GeneralMember : 큰타입(부모타입) 할당 가능
		
		// virtual method invocation: 재정의한 메서드는 부모타입이어도 실제 자식객체가 재정의한 메서드로 자동 호출 수행됨
		System.out.println("1. " + dto); // GeneralMember: 1. user01, password01, 홍길동, 010-1234-1000, user01@work.com, 2020-12-15, G, 50000
	
		// Member = SpecialMember : 큰타입(부모타입) 할당 가능 
		dto = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 

		// virtual method invocation: 재정의한 메서드는 부모타입이어도 실제 자식객체가 재정의한 메서드로 자동 호출 수행됨
		System.out.println("1. " + dto); // SpecialMember: 1. user03, password03, 이순신, 010-1234-3000, user03@work.com, 2020-11-15, S, 강동원
	}
	
	// 다형성 객체형 : 모든 클래스의 최상위 클래스 : Object 
	// virtual method invocation: 재정의한 메서드는 부모타입이어도 실제 자식객체가 재정의한 메서드로 자동 호출 수행됨
	public static void main3(String[] args) {
		Object obj1 = new Object();		// 모든 객체들을 담을 수 있는 최상위 부모클래스
		System.out.println("1. " + obj1);	// Object#toString() 1. java.lang.Object@15db9742
		
		obj1 = "hello";		// Object = String 부모타입 다형성 할당 가능
		System.out.println("2. " + obj1);	// String#toString() 2. hello => 자식클래스가 재정의해 놓은 toString() 메서드로 자동 호출 수행(겁나 편리함)
		
		obj1 = new Date();
		System.out.println("3. " + obj1);	// Date#toString() 3. Thu Aug 26 15:41:02 KST 2021 // see api: dow mon dd hh:mm:ss zzz yyyy
	}
	
	
	// 다형성 : 변수 큰 타입 : 단일변수, 매개변수, 반환타입, 배열타입
	// 다형성 기본형 : 
	public static void main2(String[] args) {
		// 기본형
		// 정수형 큰 타입: long
		//long no1 = 5; // long = int : 큰타입 자동할당
		double no1 = 5; // double = int : 큰타입 자동할당
		no1 = 5L;	// long = long : 같은 타입 자동할당
		
		no1 = 5.1;	
		// long = double : 같은타입도 아니고 큰타입아님, 다른 타입 오류 발생
		// 기본형의 가장 큰 타입: 정수형, 실수형 모두 담는 기억공간 => double
		// 정수형 큰타입 : long (정수형만 저장)
		// 실수형 큰타입 : double (정수형 + 실수형 저장)
		
	}
	
	/**
	 * 객체 생성없이 회원의 정보를 초기화하기 위한 객체 생성 메서드 
	 * -- 초기화 데이터 참고해서 5명의 회원객체를 생성하는 코드를 구현해주세요, 해당 클래스의 생성자를 활용하세요
	 * -- 일반회원
	 * -- 우수회원
	 * -- 관리자
	 */
	public static void initMember() {
		GeneralMember dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		GeneralMember dto2 = new GeneralMember("user02", "password02", "강감찬", "010-1234-2000", "user02@work.com", "2021-01-05", "G", 950000);
		
		SpecialMember dto3 = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 
		SpecialMember dto4 = new SpecialMember("user04", "password04", "김유신", "010-1234-4000", "user04@work.com", "2021-01-05", "S", "김하린"); 
		
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "010-1234-5000", "administrator@work.com", "2020-04-01", "A", "과장"); 
	}

	/**
	 * <pre>
	 * 테스트 메서드
	 * </pre>
	 * @param args 자바프로그램 실행시에 전달받은 데이터
	 */
	public static void main1(String[] args) {
		// 일반회원객체 생성
		GeneralMember g1 = new GeneralMember();
		
		System.out.println(g1); 	// GeneralMember#toString()
		//g1.memberId = "user01";	// 부모가 private 선언해서 자식일찌라도 직접 접근 불가 : 오류
		
		// 부모로부터 상속받은 publie setter()/getter() 메서드를 통해서 멤버변수 사용 가능
		// setter() 메서드를 이용해서 일반회원의 모든 정보를 설정해주세요
		g1.setMemberId("user01");
		g1.setMemberPw("password01"); 
		g1.setName("홍길동"); 
		g1.setMobile("010-1234-1000"); 
		g1.setEmail("user01@work.com"); 
		g1.setEntryDate("2021-08-26"); 
		g1.setGrade("G"); 
		//g1.setMileage(1000); 
		
		System.out.println(g1); 
		// 1. Member 클래스에서 toString() 재정의하지 않고 수행후 결과를 확인해보세요
		// api : getClass().getName() + '@' + Integer.toHexString(hashCode())
		// com.work.model.dto.GeneralMember@15db9742, 0
		
		// 2. Member 클래스에서 toString() 재정의하고 수행후 결과를 확인
		// user01, password01, 홍길동, 010-1234-1000, user01@work.com, 2021-08-26, G, 0
		
		// 3. Member 클래스에서 @Override 어노테이션을 제거하고 public String toString(String) 중복정의를 한 것임
		// com.work.model.dto.GeneralMember@277050dc, 0
	}

}









