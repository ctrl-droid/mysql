package com.work.model.service;

import com.work.model.dao.BookDao;


public class BookService {
	/** 도서 테이블에 대한 DAO 객체 선언 및 생성 */
	private BookDao dao = new BookDao();
	
	/**
	 * 도서 등록
	 * @param title 도서명
	 * @param writer 저자
	 * @param location 도서위치
	 * @param category 도서분류
	 * @param bookNum 등록할 도서 권수
	 */
	public void addBook(String bookTitle, String bookWriter, String publisher, 
			String genre, int price, int amount) {
		int res = dao.insertBook(bookTitle, bookWriter, publisher, genre, price, amount);
		if (res == 1) {
			System.out.println("신간도서 추가 성공");
		} else {
			System.out.println("[오류메세지] 신간도서를 추가하지 못했습니다.");
		}
	}
	
	/**
	 * 도서목록 내 도서번호 검색
	 * @param bookNo 도서번호
	 * @return 존재하면 true, 없으면 false
	 */
	public boolean existBook(int bookNo) {
		return dao.existBookNo(bookNo);

	}
	
	
	/**
	 * 도서정보 수정
	 * @param bookNo 수정대상 도서번호
	 * @param bookTitle 변경할 제목
	 * @param bookWriter 변경할 저자명
	 * @param publisher 변경할 출판사명
	 * @param genre 변경할 장르
	 * @param price 변경할 가격
	 * @param amount 변경할 수량
	 */
	public void editBookInfo(int bookNo, String bookTitle, String bookWriter, 
			String publisher, String genre, int price, int amount) {
		int res = dao.updateBook(bookNo, bookTitle, bookWriter, publisher, genre, price, amount);
		if (res == 1) {
			System.out.println(bookNo + "번 도서정보가 성공적으로 변경되었습니다.");
		} else {
			System.out.println("[오류메세지]");
		}
	}
	
	
	/**
	 * 도서 삭제
	 * @param bookNo 삭제하고자 하는 도서 번호
	 */
	public void removeBook(int bookNo) {
		int res = dao.deleteBook(bookNo);
		if (res == 1) {
			System.out.println(bookNo + "번 도서가 삭제되었습니다.");
		} else {
			System.out.println("[오류메세지] 해당 도서번호에 해당하는 번호가 없습니다.");
		}
		
	}
	

}
