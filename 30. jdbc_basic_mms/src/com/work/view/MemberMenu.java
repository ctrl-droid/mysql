package com.work.view;

import com.work.model.service.MemberService;

import util.Utility;

/**
 * 회원관리 서비스를 이용하기 위한 메뉴 구성 클래스
 *
 */
public class MemberMenu {
	
	MemberService service = new MemberService();
	
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
		String memberId = Utility.inputString();
		
		System.out.print("PassWord : ");
		String memberPw = Utility.inputString();
		
		System.out.println();
		service.login(memberId, memberPw);
		String grade = service.login(memberId, memberPw);
		if (grade != null) {
			// 로그인 성공: 회원전용 메뉴 표시
			serviceMainMenu();
		} else {
			System.out.println("[로그인 실패] 회원정보를 다시 확인하시기 바랍니다");
		}
		
	}
	
	/** 회원전용 서비스 메인 메뉴 */
	private void serviceMainMenu() {
		System.out.println("######### 회원전용 서비스 메뉴 #########");
		System.out.println("1. 회원정보 변경");
		System.out.println("2. 비밀번호 변경");
		System.out.println("3. ");
		System.out.println("9. 로그아웃");
		System.out.println("0. 종료");
		System.out.print(">> 메뉴입력(번호만 입력해주세요): ");
		System.out.print("");
		
		int menuNo = Utility.inputNumber();
		
		// 메뉴번호에 따라서 해당 메뉴를 위한 메서드로 dispatch: 어떤 메뉴를 선택했는지 콘솔출력하는 수행문
		switch(menuNo) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			break;
		case 9:
			startMenu();
			break;
		case 0:
			menuExit();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 메뉴입니다.");
		}
		
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
