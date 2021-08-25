package com.work.view;

import com.work.model.dto.Member;
/*
 ## new 객체 생성 절차
 	1. 메모리 할당 : 멤버변수
 	2. 기본값 자동 초기화
 	3. 명시적 초기화:
 		>> 멤버변수 선언시에 함꼐 지정하는 초기값
 		>> public String memberId = "Guest";
 	4. 생성자 수행
 		>> 개발자가 명시적으로 생성자를 정의하지 않으면
 		>> javac(자바 컴파일러) 자동으로 기본생성자 제공
 	5. 메모리에 생성된 객체에 대한 참조값 할당
 */

public class MemberTest {
	// 생성자 호출 테스트
	public static void main(String[] args) {
		// Member 기본 생성자를 이용해서 객체 타입 선언 및 객체 생성 : 참조변수명 dto1
		Member dto1 = new Member();
		
		//회원 가입시 회원 입력해야하는 필수데이터(아이디, 비밀번호, 이름, 휴대폰, 이메일) 초기화 생성자를 이용한 객체 생성
		Member dto2 = new Member("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com");
		
		//회원 모든데이터 초기화 생성자를 이용한 객체 생성
		//우수회원 객체 생성
		Member dto3 = new Member("user01", "pw01","정현아", "010-1234-5678","user01@work.com");
				
		System.out.println();
		//객체 생성후 메서드 호출정보 출력
		dto1.printMember(); //기본생성자 객체생성 정보가 기본값으로 설정
		dto2.printMember(); // 객체 생성자 전달받은 데이터로 초기화 수행
		dto3.printMember();
	}
	
	// this 멤버변수 테스트
	public static void main1(String[] args) {
		// Member 객체 타입 선언 및 객체 생성 : 참조변수명 dto1
		Member dto1 = new Member();
		
		// setter() 메서드를 호출해서 마일리지와 이름을 변경 수행
		dto1.setMileage(1000);
		dto1.setName("박호두");
		
		//출력메서드를 호출해서 생성한 회원객체의 모든 정보 출력
		//출력결과 확인 : 마일리지, 이름이 올바르게 변경 되었는지 출력
		//결과 : 마일리지 올바르게 변경 성공, 이름은 변경 x(초기값 그대로)
		dto1.printMember();
	}
}
