package com.work.view;


import com.work.model.service.BookService;
import com.work.model.service.MemberService;
import com.work.model.service.QnaService;
import com.work.model.service.SalesService;
import com.work.util.Utility;

/**
 * <pre>
 * 도서판매관리시스템을 이용하기 위한 메뉴 구성 클래스
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
public class IndexMenu {
	
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
	 * 시작메뉴
	 * </pre>
	 */
	public void startMenu() {
		System.out.println("====================================");
		System.out.println("\t[BookStore시작메뉴]");
		System.out.println("====================================");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비밀번호찾기");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
	
		int menuNo = Utility.inputNumber();
		
		switch(menuNo) {
		case 1:
			loginMenu();
			break;
		case 2:
			joinMemberMenu();
			break;
		case 3:
			findMemberIdMenu();
			break;
		case 4:
			findMemberPwMenu();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}
	

	/** 회원가입 메뉴 */
	private void joinMemberMenu() {
		System.out.println();
		System.out.println("[ 회원가입 메뉴 ]");

		System.out.print("아이디: ");
		String memberId = Utility.inputString();
		
		System.out.print("비밀번호: ");
		String memberPw = Utility.inputString();
		
		System.out.print("이름: ");
		String name = Utility.inputString();

		System.out.print("휴대폰: ");
		String mobile = Utility.inputString();

		System.out.print("이메일: ");
		String email = Utility.inputString();
		
		memberService.addMember(memberId, memberPw, name, mobile, email);
	}
	
	/** 로그인 메뉴 */
	private void loginMenu() {
		CustomerMenu customer = new CustomerMenu();
		System.out.println();
		System.out.println("[ 로그인 메뉴 ]");
		
		System.out.print("아이디: ");
		String memberId = Utility.inputString();
		
		System.out.print("비밀번호: ");
		String memberPw = Utility.inputString();
		
		System.out.println();
		String grade = memberService.login(memberId, memberPw);
		if (grade != null) {
			customer.buyBookMenu();
		} else {
			System.out.println("[로그인 실패] 회원정보를 다시 확인하시기 바랍니다.");
			
		}
		
	}
	
	/** 비밀번호 찾기 메뉴 */
	private void findMemberPwMenu() {
		System.out.println();
		System.out.println("[ 비밀번호찾기 메뉴 ]");
		System.out.println();
	}
	
	/** 아이디 찾기 메뉴 */
	private void findMemberIdMenu() {
		System.out.println();
		System.out.println("[ 아이디찾기 메뉴 ]");
		System.out.println();
	}
	
	/** 종료 메뉴 */
	private void exitMenu() {
		System.out.println();
		System.out.println("[ 프로그램을 정상 종료하였습니다. ]");
		System.out.println();
		System.exit(0);
	}

}
