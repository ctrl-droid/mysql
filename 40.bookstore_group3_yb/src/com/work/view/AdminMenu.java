package com.work.view;

import com.work.model.service.BookService;
import com.work.model.service.MemberService;
import com.work.model.service.QnaService;
import com.work.model.service.SalesService;
import com.work.util.Utility;

/**
 * <pre>
 * (관리자용)도서판매관리시스템을 이용하기 위한 메뉴 구성 클래스
 * </pre>
 * @author 박예빈
 * @version ver.1.0
 * @since jdk.1.8
 * @see com.work.model.service.BookService;
 * @see com.work.model.service.MemberService
 * @see com.work.model.service.QnaService;
 * @see com.work.model.service.SaleService;
 * @see com.work.util.Utility;
 * @see 
 *
 */
public class AdminMenu {
	/** 회원관리 Service 객체 선언 및 생성 */
	MemberService memberService = new MemberService();
	/** 도서관리 Service 객체 선언 및 생성 */
	BookService bookService = new BookService();
	/** Q&A 게시판관리 Service 객체 선언 및 생성 */
	QnaService qnaService = new QnaService();
	/** 판매정보관리 Service 객체 선언 및 생성 */
	SalesService saleService = new SalesService();
	
	/**
	 * <pre>
	 * 관리자용 메인 메뉴
	 * </pre>
	 */
	public void adminMenu() {
		
		System.out.println("====================================");
		System.out.println("\t[관리자 메인 메뉴]");
		System.out.println("====================================");
		System.out.println("1. 전체회원 정보조회");
		System.out.println("2. 도서목록 관리");
		System.out.println("3. Q&A게시판 관리");
		System.out.println("4. 판매내역 관리");
		System.out.println("9. 로그아웃(첫 화면으로 이동)");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int menuNo = Utility.inputNumber();
		switch (menuNo) {
		case 1:
			memberList();
			break;
		case 2:
			administrateBook();
			break;
		case 3:
			administrateQna();
			break;
		case 4:
			administrateSales();
			break;
		case 9:
			logoutMenu();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}
	
	
	private void memberList() {
		
	}

	private void administrateBook() {
		
	}

	private void administrateQna() {
		
	}

	private void administrateSales() {
		
	}

	/** 9. 로그아웃 [시작메뉴] 메뉴 */
	private void logoutMenu() {
		IndexMenu index = new IndexMenu();
		
		System.out.println("[ 로그아웃이 정상 처리되었습니다. ]");
		memberService.logout();
		index.startMenu();
	}
	

	/**
	 * <pre>
	 * 관리자용 도서목록 관리 메뉴
	 * </pre>
	 */
	public void adminBookMenu() {
		SearchBookMenu search = new SearchBookMenu();
		
		System.out.println("====================================");
		System.out.println("\t[도서 목록 관리 메뉴]");
		System.out.println("====================================");
		System.out.println("1. 신간도서 추가");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 정보 수정");
		System.out.println("4. 도서 삭제");
		System.out.println("9. 나가기(관리자 메인메뉴)");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int menuNo = Utility.inputNumber();
		switch (menuNo) {
		case 1:
			addNewBook();
			break;
		case 2:
			search.searchBook();
			break;
		case 3:
			updateBook();
			break;
		case 4:
			deleteBook();
			break;
		case 9:
			adminMenu();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}

	private void addNewBook() {
		
	}

	private void updateBook() {
	
	}

	private void deleteBook() {
		
	}


	/**
	 * <pre>
	 * 관리자 Q&A 메뉴
	 * </pre>
	 */
	public void adminQnaMenu() {
		System.out.println("====================================");
		System.out.println("\t[QnA게시판 관리 메뉴]");
		System.out.println("====================================");
		System.out.println("1. QnA 전체목록");
		System.out.println("2. QnA 답변추가");
		System.out.println("3. QnA 삭제");
		System.out.println("8. 나가기(관리자 메인메뉴)");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int menuNo = Utility.inputNumber();
		switch (menuNo) {
		case 1:
			qnaList();
			break;
		case 2:
			qnaAnswer();
			break;
		case 3:
			qnaDelete();
			break;
		case 8:
			adminMenu();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}
	private void qnaList() {
	}
	
	private void qnaAnswer() {
	}
	
	private void qnaDelete() {
	}
	
	
	
	/*
	 * <pre>
	 * 판매내역 관리 메뉴(관리자)
	 * </pre>
	 *
	 * @author 전효정
	 * @since jdk1.8
	 * @version ver.1.0
	 */
	public void salesControlMenu() {
		System.out.println("====================================");
		System.out.println("\t[판매내역 관리 메뉴]");
		System.out.println("====================================");
		System.out.println("1. 판매내역 전체 조회");
		System.out.println("2. 판매 통계 확인");
		System.out.println("9. 나가기(관리자 메인메뉴)");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int menuNo = Utility.inputNumber();
		switch (menuNo) {
		case 1:
			salesList();
			break;
		case 2:
			salesAnalysis();
			break;
		case 9:
			adminMenu();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}
	private void salesList() {
	}
	private void salesAnalysis() {
	}
	
	/** 종료 메뉴 */
	private void exitMenu() {
		System.out.println();
		System.out.println("[ 프로그램을 정상 종료하였습니다. ]");
		System.out.println();
		System.exit(0);
	}
}
