package com.work.view;

import java.util.ArrayList;

import com.work.model.dto.Member;
import com.work.model.service.MemberService;

public class MemberTest {
	
	public static void main(String[] args) {
		// 회원관리 CUI MemberMenu 객체 선언 및 생성
		MemberMenu menu = new MemberMenu();
		
		// 시작메뉴를 무한반복 호출
		while (true) {
			menu.startMenu();
			System.out.println();
		}
		
	}
	

	public static void main1(String[] args) {
		// 회원관리 DAO 객체 선언 및 생성
		// MemberDao service = new MemberDao();
		// 회원관리 Service 객체 선언 및 생성해서 서비스에게 요청
		
		MemberService service = new MemberService();
		
		print("전제회원조회");
		ArrayList<Member> list = service.getMemberList();
		
		for (int index = 0; index < list.size(); index ++) {
			System.out.println(list.get(index));
		}
			
		print("회원상세조회");
		Member dto = service.getMember("user01");
		System.out.println(dto);

		print("비밀번호 변경");
		int result = service.setMemberPw("user01", "password01", "happyday01");
		if (result == 1) {
			print("비밀번호 변경 성공");
		} else {
			print("비밀번호 변경 실패 : 정보를 다시 확인하시기 바랍니다.");
		}
		
		print("회원등록");
		service.addMember("hodurotorl", "happy1004", "박호두", "010-1004-1004", "hodu@email.com");

		print("회원등록");
		Member dto1 = new Member("test01", "password01", "홍길동", "010-1234-1000", "user01@work.com", "2020-12-15", "G", 50000, null);
		service.addMember(dto1);
	}
	
	public static void print(String message) {
		System.out.println("\n### " + message + " ###");
	}

}
