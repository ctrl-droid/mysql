package com.work.view;

import com.work.util.Utility;

public class SearchBookMenu {
	
	/**
	 * <pre>
	 * 도서 검색 메뉴
	 * </pre>
	 */
	public void searchBook() {
		CustomerMenu customer = new CustomerMenu();
		
		System.out.println("====================================");
		System.out.println("\t[도서검색 메뉴]");
		System.out.println("====================================");
		System.out.println("1. 도서명으로 검색");
		System.out.println("2. 저자명으로 검색");
		System.out.println("3. 출판사명으로 검색");
		System.out.println("4. 장르별 검색");
		System.out.println("9. 나가기(도서 구매 메뉴로)");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int menuNo = Utility.inputNumber();
		switch (menuNo) {
		case 1:
			searchBookname();
			break;
		case 2:
			searchBookWriter();
			break;
		case 3:
			searchBookPublisher();
			break;
		case 4:
			searchBookGenre(); 
			break;
		case 9:
			customer.myPage();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}
	
	private void searchBookname() {
	}
	
	private void searchBookWriter() {
	}

	private void searchBookPublisher() {
	}
	
	private void searchBookGenre() {
	}
	
	
	/** 종료 메뉴 */
	private void exitMenu() {
		System.out.println();
		System.out.println("[ 프로그램을 정상 종료하였습니다. ]");
		System.out.println();
		System.exit(0);
	}
	
	
}
