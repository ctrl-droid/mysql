package com.work.view;

import java.util.ArrayList;

import com.work.model.dto.Qna;
import com.work.model.service.BookService;
import com.work.model.service.MemberService;
import com.work.model.service.QnaService;
import com.work.model.service.SalesService;
import com.work.util.Utility;

public class CustomerMenu {
	
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
	 * 도서구매 메뉴
	 * </pre>
	 */
	public void buyBookMenu() {
		SearchBookMenu search = new SearchBookMenu();
		
		System.out.println("====================================");
		System.out.println("\t[도서구매 메뉴]");
		System.out.println("====================================");
		System.out.println("1. 도서검색");
		System.out.println("2. 도서구매");
		System.out.println("3. 마이페이지");
		System.out.println("9. 로그아웃(첫 화면 이동");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
	
		int menuNo = Utility.inputNumber();
		
		switch(menuNo) {
		case 1:
			search.searchBook();
			break;
		case 2:
			buyBook();
			break;
		case 3:
			myPage();
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

	private void buyBook() {
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
	 * 마이페이지 메뉴
	 * </pre>
	 */
	public void myPage() {
		IndexMenu index = new IndexMenu();
		
		System.out.println("====================================");
		System.out.println("\t[마이페이지]");
		System.out.println("====================================");
		System.out.println("1. 회원정보조회");
		System.out.println("2. 내정보변경");
		System.out.println("3. 구매내역 확인");
		System.out.println("4. 도서환불");
		System.out.println("5. Q&A");
		System.out.println("7. 회원탈퇴");
		System.out.println("8. 나가기(도서구매메뉴로 이동");
		System.out.println("9. 로그아웃(첫 화면 이동");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
	
		int menuNo = Utility.inputNumber();
		
		switch(menuNo) {
		case 1:
			searchMemberInfo();
			break;
		case 2:
			updateMemberInfo();
			break;
		case 3:
			purchaseList();
			break;
		case 4:
			refundBook();
			break;	
		case 5:
			costmerQnaMenu();
			break;
		case 7:
			deleteAccount();
			break;	
		case 8:
			buyBookMenu();
			break;
		case 9:
			index.startMenu();
			break;		
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}

	private void searchMemberInfo() {
		String memberId = memberService.loginMemberId;
		System.out.println(memberService.getMember(memberId));
		myPage();
	}

	private void updateMemberInfo() {
		String memberId = memberService.loginMemberId;
		
		System.out.print("현재 비밀번호: ");
		String memberPw = Utility.inputString();
		
		System.out.print("변경할 비밀번호: ");
		String modifyMemberPw = Utility.inputString();
		
		memberService.updateMember(memberId, memberPw, modifyMemberPw);
		
		System.out.println(memberService.getMember(memberId));
		myPage();
	}

	private void purchaseList() {
	}

	private void refundBook() {
	}


	private void deleteAccount() {
		IndexMenu index = new IndexMenu();
		String memberId = memberService.loginMemberId;
		
		memberService.deleteMember(memberId);
		index.startMenu();
	}
	

	/**
	 * <pre>
	 * 사용자 Q&A 메뉴
	 * </pre>
	 */
	
	public void costmerQnaMenu() {;
		System.out.println("====================================");
		System.out.println("\t[Q&A]");
		System.out.println("====================================");
		System.out.println("1. Q&A 작성");
		System.out.println("2. Q&A 수정");
		System.out.println("3. 나의 Q&A 조회");
		System.out.println("4. Q&A 삭제");
		System.out.println("9. 나가기(마이페이지)");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int menuNo = Utility.inputNumber();
		switch (menuNo) {
		case 1:
			writeQna();
			break;
		case 2:
			updateQna();
			break;
		case 3:
			myQnaList();
			break;
		case 4:
			deleteQna(); 
			break;
		case 9:
			myPage();
			break;
		case 0:
			exitMenu();
			break;
		default:
			System.out.println("[오류] 지원하지 않는 서비스 메뉴번호입니다.");
			break;
		}
	}
	
	private void writeQna() {
		String memberId = memberService.loginMemberId;
		
		System.out.println();
		System.out.println("[ Q&A 등록 ]");
		
		System.out.print("문의내용: ");
		String qnaQuestion = Utility.inputString();
		
		qnaService.addQna(memberId, qnaQuestion);
		costmerQnaMenu();
	}

	private void updateQna() {
		System.out.print("수정할 Q&A 번호 입력: ");
		int qnaNo = Utility.inputNumber();
		
		System.out.print("수정 Q&A 내용: ");
		String qnaQuestion = Utility.inputString();
		
		qnaService.setMyQna(qnaNo, MemberService.loginMemberId, qnaQuestion);
		costmerQnaMenu();
		
	}

	private void myQnaList() {
		ArrayList<Qna> list = new ArrayList<Qna>(qnaService.getMyQna());
		for (int index = 0; index < list.size(); index ++) {
			System.out.println(list.get(index));
		}
		costmerQnaMenu();
	}

	private void deleteQna() {
		System.out.print("삭제할 Q&A 번호 입력: ");
		int qnaNo = Utility.inputNumber();
		qnaService.removeMyQna(qnaNo, MemberService.loginMemberId);
		costmerQnaMenu();
		
	}
	
	
	/** 종료 메뉴 */
	private void exitMenu() {
		System.out.println();
		System.out.println("[ 프로그램을 정상 종료하였습니다. ]");
		System.out.println();
		System.exit(0);
	}
	
}
