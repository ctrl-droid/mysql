package com.work.model.service;

import com.work.model.dao.MemberDao;
import com.work.model.dao.QnaDao;
import com.work.model.dto.Member;
import com.work.model.dto.Qna;
import com.work.util.Utility;

public class QnaService {
	/** 회원 테이블에 대한 DAO 객체 선언 및 생성 */
	private QnaDao dao = new QnaDao();
	
	/** 로그인 성공한 회원의 아이디를 프로그램 종료시까지 사용하기위한 속성 */
	public static String loginMemberId;
	
	/** 로그인 성공한 회원의 등급을 프로그램 종료시까지 사용하기위한 속성 */
	public static String loginGrade;
	
	
	/**
	 * <pre>
	 * qna 등록
	 * </pre>
	 * 
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰 
	 * @param email 이메일
	 */
	public void addQna(String qnaWriter, String qnaQuestion) {
		Qna dto = new Qna(qnaWriter, qnaQuestion); // 사용자 입력된 정보로 회원 객체 생성
		dto.setQnaTime(Utility.getCurrentDate()); 
		dto.setQnaAnswer(null);
		addQna(dto);
	}
	
	/**
	 * <pre>
	 * qna등록
	 * </pre>
	 * @param dto 회원
	 */
	public void addQna(Qna dto) {
		int result = dao.insertQna(dto);
		if (result == 1) {
			System.out.println("[Q&A 등록 성공]");
		} else {
			System.out.println("[회원 등록 실패]");
		}
	}

	
	/**
	 * 나의 qna 상세조회
	 * @param memberId 아이디
	 * @return 성공시 회원, 실패시 null
	 */
	public Qna getMyQna(String qnaWriter) {
		return dao.selectOne(qnaWriter);
	}
	
	
	/**
	 * 나의 qna 변경
	 * @param qnaNo 
	 * @param qnaWriter 
	 * @param modifiMemberPw 변경할질문
	 * @return 성공시 1, 실패시 0
	 */
	public int setMyQna(int qnaNo, String qnaWriter, String modifyQnaQuestion) {
		return dao.updateQna(qnaNo, qnaWriter, modifyQnaQuestion);
	}
	
	
	

}
