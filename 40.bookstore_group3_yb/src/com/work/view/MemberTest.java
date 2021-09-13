package com.work.view;


import com.work.model.dto.Member;
import com.work.model.service.MemberService;

/**
 * <pre>
 * 도서판매시스템 테스트 클래스
 * </pre>
 * @author 박예빈
 * @version ver.1.0
 * @since jdk1.8
 * @see com.work.model.dto.Member
 * @see com.work.model.dao.MemberDao
 * @see com.work.model.service.MemberService
 */
public class MemberTest {
	/** 
	 * 회원관리시스템 테스트(시작) 메서드
	 * @param args 프로그램 시작시 문자열 배열 
	 * */
	public static void main(String[] args) {
		IndexMenu menu = new IndexMenu();
		while(true) {
			menu.startMenu();
		}
	}
	
	/**
	 * main 메서드에서 하드코딩 테스트 메서드
	 * @param args 프로그램 시작시 문자열 배열
	 */
	public static void main1(String[] args) {
		MemberService memberservice = new MemberService();
		
		print("회원등록");
		memberservice.addMember("khim98", "happyday", "임경혜", "010-1234-2773", "khim98@empal.com");
		
//		print("전체회원조회");
//		ArrayList<Member> list = service.getMemberList();
//		
//		for (int index = 0; index < list.size(); index++) {
//			System.out.println(list.get(index));
//		}
//		
//		print("회원상세조회");
//		Member dto = service.getMember("user01");
//		System.out.println(dto);
//		
//		print("비밀번호변경");
//		
//		int result = service.setMemberPw("user01", "password01", "happyday");
//		if (result == 1) {
//			print("비밀번호 변경 성공");
//		} else {
//			print("비밀번호 변경 실패 : 정보를 다시 확인하시기 바랍니다.");
//		}
//		
//		print("비밀번호 변경 후 회원상세조회");
//		dto = service.getMember("user01");
//		System.out.println(dto);
//		
//		print("회원등록");
//		service.addMember("khim98", "happyday", "임경혜", "010-1234-2773", "khim98@empal.com");
//		
//		print("회원등록");
//		Member dto = new Member("test01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000, null);
//		memberservice.addMember(dto);
//	
	}

	/**
	 * <pre>
	 * 테스트시에 사용하기 위한 메세지 출력위한 Class 메서드
	 * </pre>
	 * @param message 출력 문자열
	 */
	public static void print(String message) {
		System.out.println("\n### " + message + " ###");
	}
}










