package com.work.view;

import java.util.ArrayList;

import com.work.model.dto.Member;
import com.work.model.service.MemberServiceSimple;

public class MemberTestSimple {
	/** 회원관리 Simple 테스트 클래스 */
	public static void main(String[] args) {
		print("회원서비스클래스 생성");
		MemberServiceSimple service = new MemberServiceSimple();
		
		print("회원 등록 5명 : user01, user02, user03, user04, user05");

		service.addMember("user01", "password01", "홍길동");
		service.addMember(new Member("user02", "password02", "유관순"));
		service.addMember(new Member("user03", "password03", "강감찬"));
		service.addMember(new Member("user04", "password04", "김유신"));
		service.addMember(new Member("user05", "password05", "홍길자"));

		
		print("회원 아이디 중복 등록 : user01");
		service.addMember("user01", "password01", "홍길동");
		service.addMember(new Member("user01", "password01", "홍길동"));
		
		print("회원 등록 인원수 조회");
		System.out.println(service.getCount());
		
		print("회원 전체조회");
		ArrayList list = service.getMemberList();
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		
		print("회원 아이디 상세조회");
		Member dto = service.getMember("user01");
		if (dto != null) {
			System.out.println(dto);
		} 
		
		print("회원 전체변경 : user01, happyday, 본인이름");
		dto = new Member("user01", "happyday", "박호두");
		service.setMember(dto);
		
		print("회원 아이디 상세조회");
		Member dto1 = service.getMember("user01");
		if (dto1 != null) {
			System.out.println(dto1);
		} 
		
		print("회원 암호변경 : user01, happyday, 본인암호");
		service.updateMemberPw("user01", "happyday", "hodu");
//		service.updateMemberPw("user99", "happyday", "hodu");
		
		print("회원 탈퇴: user02, user03");
		service.removeMember("user02");
		service.removeMember("user03", "happyday");
		
		print("회원 등록 인원수 조회");
		System.out.println(service.getCount());
		
		print("회원 전체조회");
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		
	}

	/** 객체 생성하지 않고 테스트시에 메세지 출력위한 메서드 */
	public static void print(String message) {
		System.out.println("\n### " + message + " ###");
	}
}
