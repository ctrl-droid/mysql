package com.work.view;

import com.work.model.dto.Member;

/**
 * Member 클래스의 equals() / hashCode() 메서드 재정의 테스트
 * -- 같은 클래스 여부 비교
 * -- 회원의 아이디가 같으면 같은 객체로 처리 변경 : 재정의
 * @author 박호두
 *
 */
public class MemberTest {

	public static void main(String[] args) {
		// Member 객체를 3개 생성
		Member dto1 = new Member("user01", "password01", "홍길동");
		Member dto2 = new Member("user02", "password02", "강감찬");
		Member dto3 = new Member("user01", "password01", "홍길자");
		
		// Member#toString() 재정의 : 회원의 아이디가 같으면 같은 객체로 처리 변경
		// == 연산자를 이용해서 3개의 객체를 각각 비교 결과 출력
		System.out.println("\n## == 연산자 비교 결과");
		System.out.println(dto1 == dto2);  // false
		System.out.println(dto1 == dto3);  // false
		
		// ********* 중요!!!! 객체 비교시에는 반드시 equals() 메서드로 비교해라, 당근 문자열도 객체 비교시 equals()
		System.out.println("\n## equals() 비교 결과");
		System.out.println(dto1.equals(dto2));  // false
		System.out.println(dto1.equals(dto3));  // true
		
		System.out.println("\n## 생성한 객체들의 참조값 hashCoe()");
		System.out.println("dto1:" + dto1.hashCode());  // false
		System.out.println("dto2:" + dto2.hashCode());
		System.out.println("dto3:" + dto3.hashCode());
	}

}
