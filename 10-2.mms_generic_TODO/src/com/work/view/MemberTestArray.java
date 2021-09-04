/**
 * 
 */
package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberServiceArray;

/**
 * 회원관리 시스템 테스트 클래스
 * 
 * -- 회원관리 시스템 클래스 의존관계
 * >> MemberTest => Member, GeneralMember, SpecialMember, AdminMember
 * >> MemberTest => MemberService
 * >> MemberService => Member, GeneralMember, SpecialMember, AdminMember
 */
public class MemberTestArray {
	
	/** 배열 자료저장구조를 이용한 회원서비스 클래스 테스트 */
	public static void main(String[] args) {
		// 초기회원 정보 객체
		GeneralMember dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		GeneralMember dto2 = new GeneralMember("user02", "password02", "강감찬", "010-1234-2000", "user02@work.com", "2021-01-05", "G", 950000);
		SpecialMember dto3 = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 
		SpecialMember dto4 = new SpecialMember("user04", "password04", "김유신", "010-1234-4000", "user04@work.com", "2021-01-05", "S", "김하린"); 
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "010-1234-5000", "administrator@work.com", "2020-04-01", "A", "과장"); 
		
		// 회원 관리 기능(서비스)을 사용하기 위한 서비스 객체 생성
		MemberServiceArray service = new MemberServiceArray(20);

		// 서비스 객체의 회원등록 메서드를 이용해서 초기회원 5명 등록 수행
		System.out.println("\n### 회원 등록 [valid] ###");
		service.addMember(dto1);
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);

		System.out.println("\n### 전체조회 ###");
		Member[] members = service.getMemberList();
		for(int index = 0; index < members.length; index++) {
			System.out.println(members[index]);
		}
		System.out.println();
		
		System.out.println("\n### 회원 등록 [invalid - 아이디 중복] ###");
		service.addMember(dto2);
		service.addMember(dto3);
		
		System.out.println("\n### user01 회원 상세조회 [valid]###");
		Member dto = service.getMember("user01");
		if (dto != null) { 
			System.out.println(dto);
		} else {
			System.out.println("[오류] 해당 회원의 정보가 존재하지 않습니다. : user01");
		}
		
		System.out.println("\n### user99 회원 상세조회 [invalid]###");
		dto = service.getMember("user99");
		
		if (dto != null) { 
			System.out.println(dto);
		} else {
			System.out.println("[오류] 해당 회원의 정보가 존재하지 않습니다. : user99");
		}
		
		System.out.println("\n### null 회원 상세조회 [invalid]###");
		dto = service.getMember(null); // java.lang.NullPointerException 예외발생 => getMember() 변경 후 재실행
		
		if (dto != null) { 
			System.out.println(dto);
		} else {
			System.out.println("[오류] 해당 회원의 정보가 존재하지 않습니다. : null");
		}
		
		// 회원 전체정보변경
		System.out.println("\n### user03 회원 전체정보 변경 전 조회 [valid]###");
		dto = service.getMember("user03");
		System.out.println(dto);
		
		System.out.println("\n### user03 회원 전체정보 변경 [valid]###");
		dto3 = new SpecialMember("user03", "bluesky", "이길자", "010-3333-7777", "user03@korea.com", "2020-11-15", "S", "강동원"); 
		service.updateMember(dto3);
		
		System.out.println("\n### user03 회원 전체정보 변경 후 조회 [valid]###");
		dto = service.getMember("user03");
		System.out.println(dto);
		
		// 암호변경
		System.out.println("\n### user02 회원 암호변경 [valid]###");
		service.updateMemberPw("user02", "password02", "happyday");
		
		System.out.println("\n### user02 회원 암호변경 후 조회 [valid]###");
		dto = service.getMember("user02");
		System.out.println(dto);
		
		// 회원탈퇴
		System.out.println("\n### user01 회원 탈퇴 [valid]###");
		service.removeMember("user01");
		
		// 전체회원조회 : 문제점 여부 체킹
		// 중간에 삭제된 배열요소에 null 이 저장되어 있으므로 java.lang.NullPointerException 예외발생
		// java.lang.NullPointerException 발생되지 않게 하기위한 해결책: if (!null) {...}
		// 완벽한 해결책은 아닌듯함:
		System.out.println("\n### user01 회원 탈퇴 후 전체조회###");
		members = service.getMemberList();
		for(int index = 0; index < members.length; index++) {
			if (members[index] != null) { // null 여부 체킹하지 않으면 실행시 오류 발생함 : removeMember1()
				// java.lang.NullPointerException 발생되지 않게 하기위한 해결책:	
				System.out.println(members[index]);
			}
		}
		
		// 회원탈퇴
		System.out.println("\n### user04 회원 탈퇴 [removeMember() 수정 후]###");
		service.removeMember("user04");
		System.out.println("\n### user01, user04 회원 탈퇴 후 전체조회###");
		
		members = service.getMemberList();
		for(int index = 0; index < members.length; index++) {
			System.out.println(members[index]);	// 해결: 삭제시에 중간에 null 처리 되지 않도록 로직 수행되었으므로 null 여부 체킹하면서 출력할 필요없음 
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









