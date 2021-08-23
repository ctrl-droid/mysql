package com.work.view;

//2. import 선언문 : 현재 클래스에서 사용한 클래스의 경로 지정

import com.work.model.dto.Member;

/**
 * <pre>
 * 회원관리 시스템 테스트 클래스
 * </pre>
 * @author 박호두
 * @version ver.1.0
 * @since jdk1.8
 * @see com.work.model.dto.Member
 */
public class MemberTest {

	public static void main(String[] args) {
		// 회원 클래스를 이용한 회원객체 생성
		// 클래스이름 참조변수명 = new 클래스이름 ();
		Member dto1 = new Member();
		
		// 생성한 객체의 멤버변수 사용방법:참조변수명.멤버변수명
		System.out.println(dto1.memberId);  // null => Guest
		System.out.println(dto1.memberPw);  // null => null
		System.out.println(dto1.mileage);   // null => 0
		
		// 생성한 객체의 멤버변수 데이터 변경
		dto1.memberId = "encore01";
		dto1.memberPw = "happy2021";
		dto1.grade = "G";
		dto1.mileage = 5000;
		
		System.out.println();  // 공백라인 출력
		
		System.out.println(dto1.memberId);  // Guest => encore01
		System.out.println(dto1.memberPw);  // null => happy2021
		System.out.println(dto1.mileage);   // 0 => 5000

		
 	}


}
