package com.work.view;

public class MemberTest {

	public static void main(String[] args) {
		// 회원관리 메뉴 클래스 객체 생성
		MemberMenu menu = new MemberMenu();
		
		// 시작메뉴를 무한반복 호출
		while (true) {
			menu.startMenu();
			System.out.println();
		}

		
	}

}
