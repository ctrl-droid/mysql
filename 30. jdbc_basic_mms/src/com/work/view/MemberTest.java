package com.work.view;

import java.util.ArrayList;

import com.work.model.dao.MemberDao;
import com.work.model.dto.Member;

public class MemberTest {

	public static void main(String[] args) {
		// 회원관리 DAO 객체 선언 및 생성
		MemberDao dao = new MemberDao();
		
		print("전제회원조회");
		ArrayList<Member> list = dao.selectList();
		
		for (int index = 0; index < list.size(); index ++) {
			System.out.println(list.get(index));
		}
			
			
		print("회원상세조회");
		Member dto = dao.selectOne("user02");
		System.out.println(dto);

		print("로그인");
		print("아이디 찾기");
		print("비밀번호 찾기");
		print("회원정보 전체변경");
		print("비밀번호 변경");
		print("우수회원 등업");

	}
	
	public static void print(String message) {
		System.out.println("\n### " + message + " ###");
	}

}
