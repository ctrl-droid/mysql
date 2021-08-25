package com.work.view;

import com.work.model.dto.Member;

public class MemberTest {
	
	// public setter()/getter() 메서드를 사용한 멤버변수 사용
	public static void main(String[] args) {
		Member dto3 = new Member("user02", "password02", "김철수", "010-5678-2000", "user02@work.com");
		
		//이름 : 본인 이름으로 변경
		dto3.setName("박호두");
		//마일리지 변경 : invalid
		dto3.setMileage(-100);   // 잘못된 데이터로 변경 가능한 문제 : => 해결: 검증 메서드 구현
		
		// 마일리지 변경 : valid
		dto3.setMileage(50000);
		
		// 마일리지 조회
		int mileage = dto3.getMileage();
		System.out.println("마일리지: " + mileage);
		
		// 아이디 변경
		dto3.setMemberId(null);  // 가능: 객체타입의 기본값은 null, String은 객체
		dto3.setMemberPw("    ");  // 가능 : 공백 문자
		dto3.setMemberId("   happyday2021");
		
		String memberId = dto3.getMemberId();
		System.out.println("ID: " + memberId);
	}

	
	// private 멤버별 접근 사용 불가
	public static void main1(String[] args) {
		Member dto3 = new Member("user02", "password02", "김철수", "010-5678-2000", "user02@work.com");
		// toString():String
		// System.out.println(참조변수명);  // 해당 클래스에서 재정의해놓은 toString() 수행결과 문자열을 출력
		// System.out.println(참조변수명.toString);  // .toString() 생략가능
		
		System.out.println(dto3);
		
		
		// Member 클래스에 멤버변수와 접근권한이 public인 경우 문제
//		dto3.memberId = null;
//		dto3.manager = "강동원";
//		dto3.mileage = -500000000;
//		dto3.grade = "XXXXX";
		
		System.out.println(dto3);  // 데이터가 올바르지 않게 변경됨(문제) => 해결: encapsulation 실패
	}
}
