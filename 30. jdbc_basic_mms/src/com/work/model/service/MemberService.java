package com.work.model.service;
import java.util.ArrayList;

import com.work.model.dao.MemberDao;
import com.work.model.dto.Member;
import util.Utility;

/**회원관리를 위한 서비스(업무처리) 클래스*/
public class MemberService {
	/** 회원 테이블에 대한 DAO 객체 선언 및 생성 */
	private MemberDao dao = new MemberDao();
	
	
	/**
	 * 회원 등록
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
		Member dto = new Member(memberId, memberPw, name, mobile, email); //사용자 입력된 정보로 회원 객체 생성
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setGrade("G");
		dto.setMileage(1000);
		
//		int result = dao.insertMember(dto);
//		if (result == 1) {
//			System.out.println("[회원 등록 성공]");
//		} else {
//			System.out.println("[회원 등록 실패]");
//		}
		
		addMember(dto);
	}
	
	
	// -> 회원등록(회원객체) : 일반, 우수, 관리자
	public void addMember(Member dto) {
		if (dao.existMemberId(dto.getMemberId())) {
			System.out.println("[회원 등록 실패] " + dto.getMemberId() + "는 사용불가 합니다.");
			return;
		}
		
		int result = dao.insertMember(dto);
		if (result == 1) {
			System.out.println("[회원 등록 성공] " + dto.getMemberId() + " 님 로그인 후 서비스를 이용하시기 바랍니다");
		} else {
			System.out.println("[회원 등록 실패] ");
		}
	}
	
	
	/**
	 * 회원 전체조회
	 * @return
	 */
	public ArrayList<Member> getMemberList() {
		return dao.selectList();
	}
	
	
	/**
	 * 회원상세조회
	 * @param string
	 * @return
	 */
	public Member getMember(String memberId) {
		return dao.selectOne(memberId);
	}


	/**
	 * 비밀번호 변경
	 * @param string
	 * @param string2
	 * @param string3
	 * @return
	 */
	public int setMemberPw(String memberId, String memeberPw, String modifyMemberPw) {
		return dao.updateMemberPw(memberId, memeberPw, modifyMemberPw);
	}

	/**
	 * 로그인
	 * @param memberId
	 * @param memberPw
	 * @return 로그인 성공 회원의 등급, 실패시 null
	 */
	public String login(String memberId, String memberPw) {
//		String grade = dao.login(memberId, memberPw);
//		return grade;
		return dao.login(memberId, memberPw);
	}
	


	
	
	
}
