/**
 * 
 */
package com.work.model.dto;

/**
 * 관리자
 *
 */
public class AdminMember extends Member {
	/** 관리자 직책 */
	private String position;

	/** 기본 생성자 */
	public AdminMember() {
	}

	/**
	 * <pre>
	 * 회원가입시 사용자 입력 필수데이터 초기화 생성자 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * </pre>
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email) {
		super(memberId, memberPw, name, mobile, email);
	}
	
	/**
	 * <pre>
	 * 필수데이터 초기화 생성자 : (아이디, 비밀번호, 이름, 휴대폰, 이메일) + 가입일,  등급
	 * </pre>
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 */
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
	}

	/** 전체데이터 초기화 생성자 : (아이디, 비밀번호, 이름, 휴대폰, 이메일, 가입일, 등급) + 마일리지 */ 
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, String position) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.position = position;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + position;
	}
	
}
