/**
 * 
 */
package com.work.view;

import java.util.ArrayList;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberServiceArray;
import com.work.model.service.MemberServiceGenericArrayList;

/**
 * 회원관리 시스템 테스트 클래스
 * 
 * -- 회원관리 시스템 클래스 의존관계
 * >> MemberTest => Member, GeneralMember, SpecialMember, AdminMember
 * >> MemberTest => MemberService
 * >> MemberService => Member, GeneralMember, SpecialMember, AdminMember
 */
public class MemberTestGenericArrayList {
	
	/** Generic ArrayList 자료 저장구조를 활용한 회원서비스 테스트 */
	public static void main(String[] args) {
		
		print("초기회원 정보 객체");
		GeneralMember dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		GeneralMember dto2 = new GeneralMember("user02", "password02", "강감찬", "010-1234-2000", "user02@work.com", "2021-01-05", "G", 950000);
		SpecialMember dto3 = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 
		SpecialMember dto4 = new SpecialMember("user04", "password04", "김유신", "010-1234-4000", "user04@work.com", "2021-01-05", "S", "김하린"); 
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "010-1234-5000", "administrator@work.com", "2020-04-01", "A", "과장"); 
		
		print("회원 관리 기능(서비스)을 사용하기 위한 서비스 객체 생성");
		// MemberServiceArrayList service = new MemberServiceArrayList(20);
		MemberServiceGenericArrayList service = new MemberServiceGenericArrayList();

		print("회원 등록");
		service.addMember("hodurotorl", "happy", "박호두", "010-2017-0919", "hodu@email.com");
		service.addMember(dto1);
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);

		print("회원 전체조회");
		ArrayList<Member> list = service.getMemberList();
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		
//		System.out.println(service.getMemberList());
		
		print("회원 상세조회");
//		Member dto = service.getMember("user01");
//		if (dto != null) {
//			System.out.println(dto);
//		} 
		System.out.println(service.getMember("user01"));
		System.out.println(service.getMember("user99"));
		
		print("회원 전체정보변경");
		service.updateMember(new SpecialMember("user03", "happy03", "장보고", "010-1004-1004", "user0303@email.com", "2021-09-04", "S", "추성훈"));
		System.out.println(service.getMember("user03"));
		
		print("회원 암호변경");
		service.updateMemberPw("user03", "happy03", "password03");
		System.out.println(service.getMember("user03"));
		System.out.println(service.updateMemberPw("user99", "happy03", "password03"));
		
		print("회원탈퇴");
		service.removeMember("user03");
		System.out.println(service.getMember("user03"));
		System.out.println(service.removeMember("user99"));
		
		print("로그인");
		System.out.println(service.login("user01", "password01"));
		System.out.println(service.login("user01", "happy01"));
		System.out.println(service.login("user99", "happy01"));
		
		print("일반회원 등업요청");
		System.out.println(service.updateGrade("user02"));
		System.out.println(service.updateGrade("user01"));
		
		print("회원 아이디찾기");
		System.out.println(service.findMemberId("홍길동", "010-1234-1000"));
		System.out.println(service.findMemberId("홍길동", "010-1000"));
		System.out.println(service.findMemberId("박길상", "010-1000"));
		
		print("회원 비밀번호찾기 + 임시비번 부여");
		System.out.println("임시비밀번호 : " + service.findMemberPw("user01", "홍길동", "010-1234-1000"));
		
		print("회원 전체조회");
		list = service.getMemberList();
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
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
	
	/** 객체 생성하지 않고 테스트시에 메세지 출력위한 메서드 */
	public static void print(String message) {
		System.out.println("\n### " + message + " ###");
	}

}









