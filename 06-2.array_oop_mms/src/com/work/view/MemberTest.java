/**
 * 
 */
package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;

/**
 * 회원관리 시스템 테스트 클래스
 * 
 * -- 회원관리 시스템 클래스 의존관계
 * >> MemberTest => Member, GeneralMember, SpecialMember, AdminMember
 * >> MemberTest => MemberService
 * >> MemberService => Member, GeneralMember, SpecialMember, AdminMember
 */
public class MemberTest {
	public static void main(String[] args) {
		// 회원들의 관리하기 위한 서비스클래스(MemberService) 타입의 선언 및 객체 생성: 생성자 활용
		// 클래스이름 참조변수명 = new 클래스이름(params);
		
		// MemberService memberService = new MemberService(5);
		// BookService bookService = new BookService();
		
		// MemberService service = new MemberService(); => 기본생성자 이용하면 기본으로 10개 배열크기
		MemberService service = new MemberService(20);
		
		// 현재 등록된 회원의 숫자 조회
		int count = service.getCount();
		System.out.println("현재 등록 회원수 : " + count);
		
		System.out.println("\n### 회원 등록 ###");
		service.addMember("khim98", "happy2021", "임경혜", "010-1234-7777", "khim98@empal.com");  // 본인이 회원가입 아이디, 비밀번호, 이름, 휴대폰, 이메일
		
		GeneralMember dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		GeneralMember dto2 = new GeneralMember("user02", "password02", "강감찬", "010-1234-2000", "user02@work.com", "2021-01-05", "G", 950000);
		SpecialMember dto3 = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 
		SpecialMember dto4 = new SpecialMember("user04", "password04", "김유신", "010-1234-4000", "user04@work.com", "2021-01-05", "S", "김하린"); 
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "010-1234-5000", "administrator@work.com", "2020-04-01", "A", "과장"); 

		service.addMember(dto1);
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);
		
		count = service.getCount();
		System.out.println("현재 등록 회원수 : " + count);
		
		System.out.println("\n### 전체회원 조회 ###");
		Member[] members = service.getMemberList();
		// 배열의 크기만큼 반복 하면서 해당 회원의 정보 출력 : toString() 활용
		for(int index = 0; index < members.length; index++) {
			System.out.println(members[index]);
		}
		System.out.println();

		// 문제발생: 회원등록가능한 전체배열 반환받았기때문에 등록되지 않은 배열요소 null 출력
		// 해결: Test 클래스(직접 해결=> 등록된 인원수만큼 반복), 
		// Service 클래스(퇴근했어요..) 
		for(int index = 0; index < service.getCount(); index++) {
			System.out.println(members[index]);
		}
		System.out.println();
		
		// 해결: Service 클래스 : 실제 등록한 회원들의 정보만을 저장한 배열요소 반환
		members = service.getMemberList();
		for(int index = 0; index < members.length; index++) {
			System.out.println(members[index]);
		}
		System.out.println();

		for(Member dto: members) {
			System.out.println(dto);
		}

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
}









