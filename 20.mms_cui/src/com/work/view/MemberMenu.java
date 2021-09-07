package com.work.view;

import com.work.util.Utility;

/**
 * 회원관리 서비스를 이용하기 위한 메뉴 구성 클래스
 *
 */
public class MemberMenu {
	/** 시작 메뉴 */
	public void startMenu() {
		System.out.println("######### 시작화면 #########");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비밀번호찾기");
		System.out.println("0. 종료");
		System.out.print(">> 메뉴입력(번호만 입력해주세요): ");
		System.out.print("");
		
		int menuNo = Utility.inputNumber();
		
		// 메뉴번호에 따라서 해당 메뉴를 위한 메서드로 dispatch: 어떤 메뉴를 선택했는지 콘솔출력하는 수행문
		switch(menuNo) {
		case 1:
			loginMenu();
			break;
		case 2:
			joinMenu();
			break;
		case 3:
			searchId();
			break;
		case 4:
			searchPw();
			break;
		case 0:
			menuExit();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 메뉴입니다.");
		}
	}


	
	public void loginMenu() {
		System.out.println();
		System.out.println("##### [로그인] #####");
		System.out.println();
		
		System.out.print("ID : ");
		String id = Utility.inputString();
		
		System.out.print("PassWord : ");
		String pw = Utility.inputString();
		
	}
	
	public void joinMenu() {
		System.out.println();
		System.out.println("##### [회원가입] #####");
		System.out.println();
		
		System.out.print("ID : ");
		String memberId = Utility.inputString();
		
		System.out.print("PassWord : ");
		String memberPw = Utility.inputString();
		
		System.out.print("이름 : ");
		String name = Utility.inputString();
		
		System.out.print("휴대폰 : ");
		String mobile = Utility.inputString();
		
		System.out.print("이메일 : ");
		String email = Utility.inputString();
	}
	
	public void searchId() {
		System.out.println();
		System.out.println("##### [아이디 찾기] #####");
		System.out.println();
		
		System.out.println("등록된 이름과 휴대폰번호를 입력해주세요.");
		System.out.print("이름 : ");
		String name = Utility.inputString();
		
		System.out.print("휴대폰 : ");
		String mobile = Utility.inputString();
	}
	
	public void searchPw() {
		System.out.println();
		System.out.println("##### [비밀번호 찾기] #####");
		System.out.println();
		
		System.out.println("등록된 ID와 휴대폰번호를 입력해주세요.");
		System.out.print("ID : ");
		String memberId = Utility.inputString();
		
		System.out.print("휴대폰 : ");
		String mobile = Utility.inputString();
	}
	
	public void menuExit() {
		System.out.println();
		System.out.println("##### [프로그램 종료] #####");
		System.exit(0);
	}
	

}
