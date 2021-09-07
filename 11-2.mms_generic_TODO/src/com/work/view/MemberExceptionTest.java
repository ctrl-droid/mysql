/**
 * 
 */
package com.work.view;

import java.util.ArrayList;

import com.work.exception.AlreadyExistException;
import com.work.exception.InvalidDataException;
import com.work.exception.NotFoundException;
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
public class MemberExceptionTest {
	
	// 회원객체 생성시 일반회원의 마일리지가 범위를 벗어나면 예외 발생: InvalidDataException 
	public static void main(String[] args) throws InvalidDataException, AlreadyExistException, NotFoundException {
		print("초기회원 정보 객체");
		GeneralMember dto1 = null;
		try {
			dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		} catch (com.sun.media.sound.InvalidDataException e1) {
			e1.printStackTrace();
		}
		
		GeneralMember dto2 = null;
		try {
			dto2 = new GeneralMember("user02", "password02", "강감찬", "010-1234-2000", "user02@work.com", "2021-01-05", "G", 950000);
		} catch (com.sun.media.sound.InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SpecialMember dto3 = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 
		SpecialMember dto4 = new SpecialMember("user04", "password04", "김유신", "010-1234-4000", "user04@work.com", "2021-01-05", "S", "김하린"); 
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "010-1234-5000", "administrator@work.com", "2020-04-01", "A", "과장"); 
		
		print("회원관리를 위한 서비스객체 생성 후 회원 등록");
		MemberService service = new MemberService();
		print("회원등록 : user01 ~ user05");

		// 아이디 중복 예외처리 테스트 : throws AlreadyExistException 
		// 회원등록 아규먼트 null 예외 처리 테스트
		try {
			service.addMember(dto1);	
			service.addMember(dto3);
			service.addMember(dto4);
			service.addMember(dto5);
			service.addMember(dto2);  // 일반회원 user02의 마일리지가 950,000 이므로 회원객체가 생성되지 않음 => dto2 = null
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		} catch (InvalidDataException e) {
			System.out.println(e.getMessage());
		}
		
		// 아이디 미존재 예외처리 테스트 : throws NotFoundException
		Member dto = null;
		try {
			print("회원상세조회: user01");
			dto = service.getMember("user01");
			System.out.println(dto);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(dto); 
		
		try {
			print("회원상세조회: user02");
			dto = service.getMember("user02");
			System.out.println(dto);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(dto); 
		
		print("전체회원조회");
		try {
			ArrayList<Member> list = service.getMemberList();
			for (Member m : list) {
				System.out.println(m);
			}
		} catch(InvalidDataException e) {
			System.out.println(e.getMessage());
		}
		
		
		print("회원 상세조회");
		try {
			System.out.println(service.getMember("user01"));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(service.getMember("user99"));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		print("회원 전체정보변경");
		try {
			service.updateMember(new SpecialMember("user03", "happy03", "장보고", "010-1004-1004", "user0303@email.com", "2021-09-04", "S", "추성훈"));
			System.out.println(service.getMember("user03"));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		print("회원 암호변경");
		try {
			service.updateMemberPw("user03", "happy03", "password03");
			System.out.println(service.getMember("user03"));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(service.updateMemberPw("user99", "happy03", "password03"));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		} 
			
		
//		print("회원탈퇴");
//		service.removeMember("user03");
//		System.out.println(service.getMember("user03"));
//		System.out.println(service.removeMember("user99"));
//		
//		print("로그인");
//		System.out.println(service.login("user01", "password01"));
//		System.out.println(service.login("user01", "happy01"));
//		System.out.println(service.login("user99", "happy01"));
//		
//		print("일반회원 등업요청");
//		System.out.println(service.updateGrade("user02"));
//		System.out.println(service.updateGrade("user01"));
//		
//		print("회원 아이디찾기");
//		System.out.println(service.findMemberId("홍길동", "010-1234-1000"));
//		System.out.println(service.findMemberId("홍길동", "010-1000"));
//		System.out.println(service.findMemberId("박길상", "010-1000"));
//		
//		print("회원 비밀번호찾기 + 임시비번 부여");
//		System.out.println("임시비밀번호 : " + service.findMemberPw("user01", "홍길동", "010-1234-1000"));
//		
		print("회원관리 프로그램을 정상 종료 하였습니다.");
	}

	
	
	// 회원 조회 : 존재하지 않는 경우에 대한 예외 처리 테스트
	public static void main2(String[] args) throws AlreadyExistException, InvalidDataException {
		print("초기회원 정보 객체");
		GeneralMember dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		GeneralMember dto2 = new GeneralMember("user02", "password02", "강감찬", "010-1234-2000", "user02@work.com", "2021-01-05", "G", 950000);
		SpecialMember dto3 = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 
		SpecialMember dto4 = new SpecialMember("user04", "password04", "김유신", "010-1234-4000", "user04@work.com", "2021-01-05", "S", "김하린"); 
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "010-1234-5000", "administrator@work.com", "2020-04-01", "A", "과장"); 
		
		print("회원관리를 위한 서비스객체 생성 후 회원 등록");
		MemberService service = new MemberService();
		print("회원등록 : user01 ~ user05");

		// 아이디 중복 예외처리 테스트 완료 : 
		service.addMember(dto1);	
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);	
		
		// 상세조회: 아이디가 존재하지 않으면 예외 발생 테스트
		try {
			Member dto = service.getMember("user01");
			System.out.println(dto); // 상세조회 수행결과가 null 여부 체킹하지않고 그냥 사용가능, 예외발생하지 않았다면 존재
			
			dto = service.getMember("user99");
			System.out.println(dto); // 상세조회 수행결과가 null 여부 체킹하지않고 그냥 사용가능, 예외발생하지 않았다면 존재
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// 회원등록 : 중복 예외 처리 테스트
	public static void main1(String[] args) throws InvalidDataException {
		print("초기회원 정보 객체");
		GeneralMember dto1 = new GeneralMember("user01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000);
		GeneralMember dto2 = new GeneralMember("user02", "password02", "강감찬", "010-1234-2000", "user02@work.com", "2021-01-05", "G", 950000);
		SpecialMember dto3 = new SpecialMember("user03", "password03", "이순신", "010-1234-3000", "user03@work.com", "2020-11-15", "S", "강동원"); 
		SpecialMember dto4 = new SpecialMember("user04", "password04", "김유신", "010-1234-4000", "user04@work.com", "2021-01-05", "S", "김하린"); 
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "010-1234-5000", "administrator@work.com", "2020-04-01", "A", "과장"); 
		
		print("회원관리를 위한 서비스객체 생성 후 회원 등록");
		MemberService service = new MemberService();
		print("회원등록 : user01 ~ user05");
		
		try {
			service.addMember(dto1);	// ok
			service.addMember(dto2);
			service.addMember(dto3);
			service.addMember(dto4);
			service.addMember(dto5);	// ok
			
			service.addMember(dto1);	// exception: 예외발생 코드를 맨아래에 위치해서 테스트처리
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			service.addMember(dto1);	// ok
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		try {
			service.addMember(dto1);	// exception
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		try {
			service.addMember(dto2);	// ok
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		try {
			service.addMember(dto3);	// ok
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		try {
			service.addMember(dto4);	// ok
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		try {
			service.addMember(dto5);	// ok
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		print("등록인원수: " + service.getCount());	// 5
		
		print("중복회원등록: user01");
		try {
			service.addMember(dto1);	// exception
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		
		
		print("[회원관리 프로그램을 종료합니다.]");	// 정상종료
	}
	
	
	/** 객체 생성하지 않고 테스트시에 메세지 출력위한 메서드 */
	public static void print(String message) {
		System.out.println("\n### " + message + " ###");
	}

}









